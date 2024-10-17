package com.db.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryUtil {

    /**
     *
     * @param connection
     * @param query
     * @return
     * @throws SQLException
     */
    public ResultSet executeQuery(Connection connection, String query) throws SQLException {
        Connection dbConnectionString = connection;
        Statement stmt = null;
        stmt = dbConnectionString.createStatement();

        return stmt.executeQuery(query);

    }

    public JSONArray convertDBResultToJson(ResultSet rs) throws SQLException {
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()) {
            int numColumns = rsmd.getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i=1; i<=numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }
            json.put(obj);
        }
        return json;
    }

    public Map<String, Object> convertDBResultToHashMap(ResultSet resultSet) throws SQLException {
        Map<String, Object> resultValues = new HashMap<String, Object>();
        ResultSetMetaData md = resultSet.getMetaData();


        int columns = md.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {

                resultValues.put(md.getColumnName(i), resultSet.getObject(i));
            }
            System.out.println(resultSet.getString(1));
        }

        return resultValues;
    }



    public List<Map<String, Object>> convertMulitpleDBResultToHashMap(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> dbResultList = new ArrayList<Map<String,Object>>();
        ResultSetMetaData md = resultSet.getMetaData();


        int columns = md.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> resultValues = new HashMap<String, Object>();
            for (int i = 1; i <= columns; i++)
            {

                resultValues.put(md.getColumnName(i), resultSet.getObject(i));
            }
            //System.out.println(resultSet.getString(1));
            dbResultList.add(resultValues);

        }

        return dbResultList;
    }
    public List<Map<String, Object>> convertMulitpleDBResultToHashMap(ResultSet resultSet,String value) throws SQLException {
        List<Map<String, Object>> dbResultList = new ArrayList<Map<String,Object>>();
        ResultSetMetaData md = resultSet.getMetaData();


        int columns = md.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> resultValues = new HashMap<String, Object>();
            for (int i = 1; i <= columns; i++)
            {
                if (resultValues.containsKey(md.getColumnName(i)))
                {
                    resultValues.put(value+"1",resultSet.getObject(i));
                }
                else {
                    resultValues.put(md.getColumnName(i), resultSet.getObject(i));
                }
            }
            //System.out.println(resultSet.getString(1));
            dbResultList.add(resultValues);

        }

        return dbResultList;
    }
}
