package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor dao = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
	//	app.test();
		app.launch();
	}

	private void test() throws SQLException {
		// Film film = dao.findFilmById(1);
		// Actor actor = dao.findActorById(1);
		// List<Actor> actors = dao.findActorsByFilmId(1);
		// System.out.println(actor);
		// System.out.println(film);
		// System.out.println(actors);

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("~~~Welcome to the movies!~~~");
		boolean keepGoing = true;
		while (keepGoing) {


	System.out.println("\"1: \"Look up a film by its ID (film IDs range from 1-1000)");
	System.out.println("\"2: \"Look up a film by a keyword");
	System.out.println("\"3: \"Exit the application");

	int switcher = 0;
	try {
	switcher = input.nextInt();
	if (switcher <1 || switcher >3) {
		System.out.println("Please enter a number between 1 and 3.");
	}
	}
	catch(InputMismatchException e) {
		System.err.println("Please enter a number between 1 and 3.");
	}
	finally {
		input.nextLine();
	}
	switch(switcher) {
	
	  case 1:
		try {
			findFilmById(input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  break;
	  case 2:
		  try {
			findFilmByInput(input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  break;
	  case 3:
	  keepGoing = false;
	  }
	}
	}

	private void findFilmById(Scanner input) throws SQLException {
		System.out.println("Please enter an ID to find a film by: ");  
		int iD = 0;
		
		try {
			iD = input.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Please enter a number between 1 and 1000.");
		}
		
		Film film = dao.findFilmById(iD);
		
		if (film == null) {
			System.out.println("That is not a valid film ID");
		}
		else {
			System.out.println(film.toStringLimited());
		}
	  }
	
	private void findFilmByInput(Scanner input) throws SQLException {
		System.out.println("Please enter a keyword to search for a film by: ");
		
		String keyWord = input.nextLine();
		
		List<Film> films = dao.findFilmsByInput(keyWord);
			
		if (films.size() == 0) {
		System.out.println("Keyword not found. Please try again.");
		}
		else {
		for (Film film: films)	{
			System.out.println(film.toStringLimited());
		}
		
		}
	}
}
