package com.shop.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.IAccountDAO;
import com.shop.database.ConnectDB;
import com.shop.model.AccountModel;

public class AccountDAO implements IAccountDAO {
	Connection conn = null;
	PreparedStatement preStatement = null;
	ResultSet results = null;

	@Override
	public AccountModel checkAccount(String email) {
		AccountModel acc = null;
		String query = "select * from account where email = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, email);
			results = preStatement.executeQuery();
			while (results.next()) {
				int id = results.getInt(1);
				String name = results.getString(2);
				String emailAcc = results.getString(3);
				String pass = results.getString(4);
				int idRole = results.getInt(5);
				acc = new AccountModel(id, name, idRole, emailAcc, pass);
			}
			return acc;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
				if (results != null) {
					results.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}

	@Override
	public List<AccountModel> listAccount() {
		List<AccountModel> listAcc = new ArrayList<>();
		String query = "select * from account";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			results = preStatement.executeQuery();
			while (results.next()) {
				int id = results.getInt(1);
				String name = results.getString(2);
				String emailAcc = results.getString(3);
				String pass = results.getString(4);
				int idRole = results.getInt(5);
				AccountModel acc = new AccountModel(id, name, idRole, emailAcc, pass);
				listAcc.add(acc);
			}
			return listAcc;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if(preStatement != null) {
					preStatement.close();
				}
				if(results != null) {
					results.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void DeleteAccount(String email) {
		String query = "delete from account where email = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, email);
			preStatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
