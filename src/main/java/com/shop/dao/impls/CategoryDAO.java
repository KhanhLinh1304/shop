package com.shop.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shop.dao.ICategoryDAO;
import com.shop.database.ConnectDB;
import com.shop.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO{
	Connection conn = null;
	PreparedStatement preStatement = null;
	ResultSet results = null;

	@Override
	public List<CategoryModel> getAllCategory() {
		List<CategoryModel> categories = new ArrayList<>();
		String query = "select * from category";
		try {
			conn = new ConnectDB().getConnection();
			preStatement = conn.prepareStatement(query);
			results = preStatement.executeQuery();
			while(results.next()) {
				int id = results.getInt(1);
				String name = results.getString(2);
				CategoryModel category = new CategoryModel(id, name);
				categories.add(category);
			}
			return categories; 
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

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
	public void CreateCategory(CategoryModel category) {
         String query = "insert into category (nameCategory) values (?)";
         try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, category.getNameCategory());
			preStatement.executeUpdate();
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

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
	}

	@Override
	public void UpdateCategory(CategoryModel category) {
		String query = "update category(nameCategory) set(?) where idCategory =  ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, category.getNameCategory());
			preStatement.setInt(2, category.getIdCategory());
			preStatement.executeQuery();	
		}
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {

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
	}

	@Override
	public void DeleteCategory(int idCategory) {
		String query = "delete from category where idCategory = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, idCategory);
			preStatement.executeQuery();
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

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
		
	}

}
