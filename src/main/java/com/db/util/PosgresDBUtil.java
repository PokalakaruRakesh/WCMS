package com.db.util;

import base.utils.EncryptionUtil;
import org.apache.commons.collections.functors.IfClosure;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PosgresDBUtil {
    private String url = "";
    private  String user = "";
    public static String dbDriver = "";
    public static String hostname = "";
    public static String userName = "";
    public static String password = "";
    public static String port = "";
    public static String dbName = "";
    Connection conn = null;




    /**
     * Method used to set DB Configuration
     */
    public void setDBConnection(String env)
    {
    	if(env.equalsIgnoreCase("qa")) {
			hostname = getDBConfiguration("dbHostNameQA");
			userName = getDBConfiguration("dbUserNameQA");
			password = getDBConfiguration("dbPwdQA");
			user = getDBConfiguration("dbUser");
			dbName = getDBConfiguration("dbName");
			port = getDBConfiguration("port");
    	}
    	else if (env.equalsIgnoreCase("dev")) {
			hostname = getDBConfiguration("dbHostNameDEV");
			userName = getDBConfiguration("dbUserNameDEV");
			password = getDBConfiguration("dbPwdDEV");
			user = getDBConfiguration("dbUserDEV");
			dbName = getDBConfiguration("dbNameDEV");
			port = getDBConfiguration("portDEV");
    	}
        else if (env.equalsIgnoreCase("stage")||env.equalsIgnoreCase("stg")) {
            hostname = getDBConfiguration("dbHostNameSTG");
            userName = getDBConfiguration("dbUserNameSTG");
            password = getDBConfiguration("dbPwdSTG");
            user = getDBConfiguration("dbUserSTG");
            dbName = getDBConfiguration("dbNameSTG");
            port = getDBConfiguration("portSTG");
        }
       

    }

    /**
     * Method used to make connection to PostGres DB
     * @return DB Connection
     */
    public Connection connect(String env) {
        setDBConnection(env);

        try {
            url = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    /**
     *Method used to get decrypted values
     * @param key
     * @return
     */
    private static String getDBConfiguration(String key) {
        File file = new File("src\\test\\resources\\keycodes.properties");
        EncryptionUtil encryptionUtil = null;
        try {
            encryptionUtil=new EncryptionUtil();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptionUtil.decrypt(prop.getProperty(key));

    }


    public void closeDBConnection(Connection conn)
    {
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
