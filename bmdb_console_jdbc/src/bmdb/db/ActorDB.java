package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bmdb.business.Actor;

public class ActorDB {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		long id = rs.getLong("ID");
		String firstName = rs.getString("FirstName");
		String lastName = rs.getString("LastName");
		String gender = rs.getString("Gender");
		String birthDate = rs.getString("BirthDate");

		Actor actor = new Actor(id, firstName, lastName, gender, LocalDate.parse(birthDate));

		return actor;

	}

	public List<Actor> getAll() {
		List<Actor> actorList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet actors = stmt.executeQuery("SELECT * FROM Actor");) {

			while (actors.next()) {
				Actor actor = getActorFromResultSet(actors);
				actorList.add(actor);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception.  " + e);
			return null;
		}

		return actorList;
	}

	public Actor getActorByLastName(String lastName) {

		String actorSelect = "SELECT * FROM ACTOR WHERE LastName =    ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(actorSelect);) {
			ps.setString(1, lastName);
			ResultSet actors = ps.executeQuery();

			if (actors.next()) {
				Actor actor = getActorFromResultSet(actors);
				actors.close();
				return actor;

			} else {
				actors.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public Actor get(long id) {

		String actorSelect = "SELECT * FROM ACTOR WHERE ID =  ? ";
		System.out.println(actorSelect);

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(actorSelect);) {
			ps.setLong(1, id);
			ResultSet actors = ps.executeQuery();

			if (actors.next()) {
				Actor actor = getActorFromResultSet(actors);
				actors.close();
				return actor;

			} else {
				actors.close();
				return null;

			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

	}

	public boolean add(Actor actor) {
		String actorInsert = "INSERT INTO actor(FirstName, LastName, Gender, BirthDate) VALUES (?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(actorInsert)) {
			ps.setString(1, actor.getFirstName());
			ps.setString(2, actor.getLastName());
			ps.setString(3, actor.getGender());
			ps.setString(4, actor.getBirthDate().toString());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}
	}

	public boolean delete(long id) {
		String actorDelete = "DELETE FROM actor WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(actorDelete)) {
			ps.setLong(1, id);

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}

	}

	public boolean update(Actor actor) {
		String actorUpdate = "UPDATE actor SET firstName = ?, lastName = ?, Gender = ?, BirthDate = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(actorUpdate)) {
			ps.setString(1, actor.getFirstName());
			ps.setString(2, actor.getLastName());
			ps.setString(3, actor.getGender());
			ps.setString(4, actor.getBirthDate().toString());
			ps.setLong(5, actor.getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}

	}
}
