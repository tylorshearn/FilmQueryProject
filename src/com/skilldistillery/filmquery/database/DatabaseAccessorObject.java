package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor { 
	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String USER = "student";
	private static final String PASS = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		
		try (Connection conn = DriverManager.getConnection(url, USER, PASS);) {

		String sql = "SELECT film.id, film.title, film.description, film.release_year, language.name, film.rental_duration, film.length, film.rental_rate, film.replacement_cost, film.rating, film.special_features FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);

		ResultSet findFilmById = stmt.executeQuery();

		if (findFilmById.next()) {
			film = new Film();

			film.setiD(findFilmById.getInt("film.id"));
			film.setTitle(findFilmById.getString("film.title"));
			film.setDescription(findFilmById.getString("film.description"));
			film.setReleaseYear(findFilmById.getInt("film.release_year"));
			film.setLanguage(findFilmById.getString("language.name"));
			film.setRentalDuration(findFilmById.getInt("film.rental_duration"));
			film.setLength(findFilmById.getInt("film.length"));
			film.setRentalRate(findFilmById.getDouble("film.rental_rate"));
			film.setReplacementCost(findFilmById.getDouble("film.replacement_cost"));
			film.setRating(findFilmById.getString("film.rating"));
			film.setSpecialFeatures(findFilmById.getString("film.special_features"));
			film.setActors(findActorsByFilmId(film.getiD()));

		}

		findFilmById.close();
		stmt.close();
		conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;

		try (Connection conn = DriverManager.getConnection(url, USER, PASS);) {

		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, actorId);

		ResultSet findActorById = stmt.executeQuery();

		if (findActorById.next()) {
			actor = new Actor();

			actor.setiD(findActorById.getInt("id"));
			actor.setFirstName(findActorById.getString("first_name"));
			actor.setLastName(findActorById.getString("last_name"));
			actor.setFilms(findFilmsByActorId(actorId));

		}

		findActorById.close();
		stmt.close();
		conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;

		try (Connection conn = DriverManager.getConnection(url, USER, PASS);) {

		String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film_actor.film_id = film.id WHERE film.id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);

		ResultSet findActorsByFilmId = stmt.executeQuery();

		while (findActorsByFilmId.next()) {
			actor = new Actor();

			actor.setiD(findActorsByFilmId.getInt("actor.id"));
			actor.setFirstName(findActorsByFilmId.getString("actor.first_name"));
			actor.setLastName(findActorsByFilmId.getString("actor.last_name"));

			actors.add(actor);
		}

		findActorsByFilmId.close();
		stmt.close();
		conn.close();
		
		} catch (SQLException e){
			e.printStackTrace();
		}

		return actors;

	}
	@Override
	public List<Film> findFilmsByActorId(int actorId) throws SQLException {
		List<Film> films = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url, USER, PASS);) {
			
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
			 
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, actorId);
			
			ResultSet findFilmsByActorId = stmt.executeQuery();
			
			while (findFilmsByActorId.next()) {
				
				int iD = findFilmsByActorId.getInt("id");
				String title = findFilmsByActorId.getString("title");
				String description = findFilmsByActorId.getString("description");
				int releaseYear = findFilmsByActorId.getInt("release_year");
				int languageId = findFilmsByActorId.getInt("language_id");
				int rentalDuration = findFilmsByActorId.getInt("rental_duration");
				double rentalRate = findFilmsByActorId.getDouble("rental_rate");
				int length = findFilmsByActorId.getInt("length");
				Double replacementCost = findFilmsByActorId.getDouble("replacement_cost");
				String rating = findFilmsByActorId.getString("rating");
				String specialFeatures = findFilmsByActorId.getString("special_features");
				
				Film film = new Film(iD, title, description, releaseYear, languageId, rentalDuration, length, replacementCost, rentalRate, rating, specialFeatures);
				
				films.add(film);
	
			}
			
			findFilmsByActorId.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return films;
		
	}
	
	@Override
	public List<Film> findFilmsByInput(String keyWord) throws SQLException {
		List<Film> films = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url, USER, PASS);) {
			
			String sql = "SELECT film.title, film.description, language.name, film.id, film.release_year, film.rental_duration, film.length, film.rental_rate, film.replacement_cost, film.rating, film.special_features FROM film JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "%" + keyWord + "%");
			stmt.setString(2, "%" + keyWord + "%");
			
			ResultSet findFilmsByInput = stmt.executeQuery();
			
			while (findFilmsByInput.next()) {
				Film film = new Film();
				
				film.setTitle(findFilmsByInput.getString("film.title"));
				film.setDescription(findFilmsByInput.getString("film.description"));
				film.setLanguage(findFilmsByInput.getString("language.name"));
				film.setiD(findFilmsByInput.getInt("film.id"));
				film.setReleaseYear(findFilmsByInput.getInt("film.release_year"));
				film.setRentalDuration(findFilmsByInput.getInt("film.rental_duration"));
				film.setLength(findFilmsByInput.getInt("film.length"));
				film.setRentalRate(findFilmsByInput.getDouble("film.rental_rate"));
				film.setReplacementCost(findFilmsByInput.getDouble("film.replacement_cost"));
				film.setRating(findFilmsByInput.getString("film.rating"));
				film.setSpecialFeatures(findFilmsByInput.getString("film.special_features"));
				film.setActors(findActorsByFilmId(film.getiD()));
	
				films.add(film);
			}
			
			findFilmsByInput.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return films;
		
	}

}
