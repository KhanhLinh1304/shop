package com.shop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ecommercial";
		String username="root";
		String password="0385170019";
		try {
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Kết nối cơ sở dữ liệu thành công!");
                connection.close();
            } else {
                System.out.println("Kết nối cơ sở dữ liệu thất bại!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
}
