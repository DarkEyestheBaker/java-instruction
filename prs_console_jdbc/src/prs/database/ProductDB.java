
package prs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.exceptions.PrsDataException;

public class ProductDB {

	public ProductDB() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<Product> getAll() {
		String selectAll = "SELECT * FROM Product";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<Product> products = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int vendorId = rs.getInt("VendorId");
				String partNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				Product product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

				products.add(product);
			}
			return products;

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products.  Msg: " + e.getMessage());
		}
	}

	public Product get(long productID) {
		String selectOne = "SELECT * FROM Product WHERE ID = ?";
		Product product = null;
		try (Connection con = getConnection(); PreparedStatement pd = con.prepareStatement(selectOne)) {
			pd.setLong(1, productID);
			ResultSet rs = pd.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("ID");
				int vendorId = rs.getInt("VendorId");
				String partNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

			}
		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products.  Msg: " + e.getMessage());
		}
		return product;

	}

	public boolean delete(long id) {
		String productDelete = "DELETE FROM Product WHERE ID = ?";
//				"DELETE product(vendorId, partNumber, name, price, unit, photoPath) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement pd = con.prepareStatement(productDelete)) {
			pd.setLong(1, id);

			pd.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}
	}

	public boolean add(Product product) {
		String productInsert = "INSERT INTO product(vendorId, partNumber, name, price, unit, photoPath) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement pa = con.prepareStatement(productInsert)) {
			pa.setInt(1, product.getVendorId());
			pa.setString(2, product.getPartNumber());
			pa.setString(3, product.getName());
			pa.setDouble(4, product.getPrice());
			pa.setString(5, product.getUnit());
			pa.setString(6, product.getPhotoPath());

			pa.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}
	}
}
