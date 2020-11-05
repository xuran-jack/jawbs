package com.ketanglearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@javax.servlet.annotation.WebServlet(name = "MyServlet",urlPatterns = {"/MyServlet"})
public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("必然成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://106.15.37.103:3306/testdb?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8";

        String user = "jack";
        String password = "2wsxZSE$";

        try(Connection con  = DriverManager.getConnection(url,user,password)){
            PrintWriter out =response.getWriter();
            out.println(con);
            out.println("连接成功");
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
