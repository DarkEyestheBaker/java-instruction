package prs.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import prs.business.Product;
import prs.exceptions.PrsDataException;

public class RequestDB extends DB {

	public Product get(long productID) {
		String selectOne = "SELECT * FROM Product WHERE ID = ?";
		Product requestProduct = null;
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

				requestProduct = new Product(id, vendorId, partNumber, name, price, unit, photoPath);
				System.out.println("Requested items: " + requestProduct);
			}
		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products.  Msg: " + e.getMessage());
		}
		return requestProduct;

	}
}
