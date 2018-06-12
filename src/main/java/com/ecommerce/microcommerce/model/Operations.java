package com.ecommerce.microcommerce.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operations {

    String account = "", dim1 = "", dim1desc = "", dim2 = "", dim2desc = "";
    String dim3 = "", dim3desc = "", dim4 = "", dim4desc = "", dim5 = "", dim5desc = "";
    String department = "", reporting_team = "";

    public Operations(){

    }

    /*
    public boolean checknstore (String acc, String dm1, String dm1d, String dm2, String dm2d, String dm3, String dm3d, String dm4, String dm4d, String dm5, String dm5d, String dep, String repteam){

        //check and update db
        String urlms = "jdbc:mysql://localhost:3306/smart_budget";//fileWatcher2
        MySQLConnect ms_connection = null;
        Connection ms_dbconnect = null;
        Statement ms_instruction = null;

        ms_connection = new MySQLConnect();
        ms_dbconnect = ms_connection.Connect(urlms, "root", "kpi@123");

        Statement instruction = null;
        ResultSet dbkpi_content = null;
        try {
            instruction = ms_dbconnect.createStatement();
            String checkRequest = "SELECT * FROM sb_kpi3 sk,   WHERE ";
            dbkpi_content = instruction.executeQuery(checkRequest);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    */
}
