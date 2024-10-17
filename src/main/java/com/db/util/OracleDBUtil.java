package com.db.util;

import base.utils.EncryptionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class OracleDBUtil {
    Connection con = null;

    public Connection getOracleConnection()
    {
        //Create Connection to DB
        try {
            con = DriverManager.getConnection(getDBConfiguration("oracleDBUrl"),getDBConfiguration("oracleDBUserName"),getDBConfiguration("oraclePassword"));

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return con;




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

    public void closeDBConnection()
    {
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
