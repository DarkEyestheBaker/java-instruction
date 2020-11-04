package prs.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.User;
import prs.exceptions.PrsDataException;

public class UserDB extends DB {

	public List<User> getAll() {
		String SelectAll = "SELECT * FROM User";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SelectAll)) {

			List<User> users = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer,
						isAdmin);
				users.add(user);
			}
			return users;

		} catch (SQLException e) {

			throw new PrsDataException("Error retrieving user.  Msg: " + e.getMessage());
		}
	}

	/**
	 * Authenticates a User
	 *
	 * @param userName The user's userName
	 * @param password The user's password
	 * @returns The matching User or null if no matching User found
	 */
	public User authenticateUser(String userName, String password) {

		String selectbyUserandPass = "SELECT * FROM prs.user  WHERE UserName = ?  AND Password =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(selectbyUserandPass);) {
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("ID");
				String userNameFromDB = rs.getString("UserName");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userNameFromDB, passwordFromDB, firstName, lastName, phoneNumber, email,
						isReviewer, isAdmin);

				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new PrsDataException("Error authenticating user. Msg: " + e.getMessage());
		}
	}
}
