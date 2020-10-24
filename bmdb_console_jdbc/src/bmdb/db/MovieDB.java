package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDB {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
		long id = rs.getLong("ID");
		String movieTitle = rs.getString("Movie Title");
		String year = rs.getString("Year");
		String genre = rs.getString("Genre");
		String rating = rs.getString("Rating");
		String director = rs.getString("Director");

		Movie movie = new Movie(id, movieTitle, year, genre, rating);

		return movie;

	}

	public List<Movie> getAll() {
		List<Movie> movieList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet movies = stmt.executeQuery("SELECT * FROM Movie");) {

			while (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movieList.add(movie);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception.  " + e);
			return null;
		}

		return movieList;
	}

	public Movie getMovieByTitle(String Title) {

		String movieSelect = "SELECT * FROM Movie WHERE title =    ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieSelect);) {
			ps.setString(1, movie);
			ResultSet movies = ps.executeQuery();

			if (movie.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movies.close();
				return movie;

			} else {
				movies.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public Movie get(long id) {

		String movieSelect = "SELECT * FROM MOVIE WHERE ID =  ? ";
		System.out.println(movieSelect);

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieSelect);) {
			ps.setLong(1, id);
			ResultSet movies = ps.executeQuery();

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);
				movies.close();
				return movie;

			} else {
				movies.close();
				return null;

			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

	}

	public boolean add(Movie movie) {
		String movieInsert = "INSERT INTO movie(title, year, genre, rating, director) VALUES (?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieInsert)) {
			ps.setString(1, movie.geTitle());
			ps.setString(2, movie.getYear());
			ps.setString(3, movie.getGenre());
			ps.setString(4, movie.getRating());
			ps.setString(5, movie.getDirector());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}
	}

	public boolean delete(long id) {
		String actorDelete = "DELETE FROM movie WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieDelete)) {
			ps.setLong(1, id);

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}

	}

	public boolean update(Movie movie) {
		String actorUpdate = "UPDATE movie SET firstName = ?, lastName = ?, Gender = ?, BirthDate = ? WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movie.Update)) {
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getYear());
			ps.setString(3, movie.getGenre());
			ps.setString(4, movie.getRating());
			ps.setString(5, movie.getDirector());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception " + e);
			return false;
		}

	}
}
