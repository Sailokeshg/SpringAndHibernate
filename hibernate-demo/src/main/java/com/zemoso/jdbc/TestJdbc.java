package com.zemoso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {


        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user ="hbstudent";
        String pass = "hbstudent";

        try{
            System.out.println("connecting to db:"+ jdbcUrl);
            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection successful");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
