package com.shop.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shop.dao.IProductDAO;
import com.shop.database.ConnectDB;
import com.shop.model.ProductModel;
import com.shop.model.SizeColorModel;

public class ProductDAO implements IProductDAO{
	Connection conn = null;
	PreparedStatement preStatement = null;
	ResultSet results = null;

	@Override
	public List<ProductModel> getAllProduct() {
		List<ProductModel> products = new ArrayList<>();
		String query = "select * from product";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			results =  preStatement.executeQuery();
			while(results.next()) {
				int idP = results.getInt(1);
				int idC = results.getInt(2);
				int quantity = results.getInt(3);
				float price = results.getFloat(4);
				String image = results.getString(5);
				String nameP = results.getString(6);
				ProductModel product = new ProductModel(idP, idC, quantity, price, image, nameP);
				products.add(product);	
			}
			return products;
			
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
	public void CreateProduct(ProductModel product) {
		String query = "insert into product(idCategory, quantityProduct, priceProduct, imageProduct, nameProduct) values(?,?,?,?,?)";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, product.getIdCategory());
			preStatement.setInt(2, product.getQuantity());
			preStatement.setFloat(3, product.getPrice());
			preStatement.setString(4, product.getImage());
			preStatement.setString(5,product.getName());
			preStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
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
	public void UpdateProduct(ProductModel product) {
		String query = "update product (idCategory, quantityProduct, priceProduct, imageProduct, nameProduct) set (?,?,?,?,?)";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, product.getIdCategory());
			preStatement.setInt(2, product.getQuantity());
			preStatement.setFloat(3, product.getPrice());
			preStatement.setString(4, product.getImage());
			preStatement.setString(5,product.getName());
			preStatement.executeUpdate();
			
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
		
	}

	@Override
	public void DeleteProduct(int idProduct) {
		String query = "delete from product where idProduct = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, idProduct);
			preStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
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
	public ProductModel getProductByIdProduct(int idProduct) {
		ProductModel product = null;
		String query = "select * from product where idProduct = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, idProduct);
			results = preStatement.executeQuery();
			while(results.next()) {
				int idP = results.getInt(1);
				int idC = results.getInt(2);
				int quantity = results.getInt(3);
				float price = results.getFloat(4);
				String image = results.getString(5);
				String nameP = results.getString(6);
				product = new ProductModel(idProduct, idC, quantity, price, image, nameP);
			}
			return product;
		} catch (ClassNotFoundException | SQLException e) {
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
	public List<ProductModel> getProductByIdCategory(int idCategory) {
		List<ProductModel> products = new ArrayList<>();
		String query = "select * from product where idCategory = ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, idCategory);
			results = preStatement.executeQuery();
			while(results.next()) {
				int idP = results.getInt(1);
				int idC = results.getInt(2);
				int quantity = results.getInt(3);
				float price = results.getFloat(4);
				String image = results.getString(5);
				String nameP = results.getString(6);
				ProductModel product = new ProductModel(idP, idC, quantity, price, image, nameP);
				products.add(product);
			}
			return products;
			
		} catch (ClassNotFoundException | SQLException e) {
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
	public List<SizeColorModel> getSizeColorProduct(int idProduct) {
		 List<SizeColorModel> lists = new ArrayList<>();
		 String query = "select product_color_size.* , size.nameSize, color.nameColor from product_color_size inner join size on product_color_size.idSize = size.idSize inner join color on product_color_size.idColor = color.idColor where idProduct = ?";
		 try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setInt(1, idProduct);
			results = preStatement.executeQuery();
			while(results.next()) {
				int idP = results.getInt(2);
				int idS = results.getInt(3);
				int idC = results.getInt(4);
				String nameSize = results.getString("nameSize");
				String nameColor = results.getString("nameColor");
				SizeColorModel sizeColorP = new SizeColorModel(idP, idS, idC,nameSize,nameColor);
				lists.add(sizeColorP);
			}
			return lists;
		} catch (SQLException | ClassNotFoundException e) {
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
	public List<ProductModel> searchByNameProduct(String name) {
		List<ProductModel> products = new ArrayList<>();
		String query = "select * from product where nameProduct like ?";
		try {
			conn = ConnectDB.getConnection();
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, "%"+name+"%");
			results = preStatement.executeQuery();
			while(results.next()) {
				int idP = results.getInt(1);
				int idC = results.getInt(2);
				int quantity = results.getInt(3);
				float price = results.getFloat(4);
				String image = results.getString(5);
				String nameP = results.getString(6);
				ProductModel product = new ProductModel(idP, idC, quantity, price, image, nameP);
				products.add(product);
			}
			return products;
			
		} catch (ClassNotFoundException | SQLException e) {
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

}
