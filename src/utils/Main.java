package utils;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;



public class Main {

 public static void main(String [] args)

 {

  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=super_market";

  String userName="sa";

  String userPwd="123qwe";

  try

  {

   Class.forName(driverName);

   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);

    System.out.println("连接数据库成功");

  }

  catch(Exception e)

  {

   e.printStackTrace();

   System.out.print("连接失败");

  }    

 }

}