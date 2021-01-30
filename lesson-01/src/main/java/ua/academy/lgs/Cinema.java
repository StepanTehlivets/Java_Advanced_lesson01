package ua.academy.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Cinema {

	TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Time openTime;
	Time closeTime;

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closeTime == null) ? 0 : closeTime.hashCode());
		result = prime * result + ((moviesLibrary == null) ? 0 : moviesLibrary.hashCode());
		result = prime * result + ((openTime == null) ? 0 : openTime.hashCode());
		result = prime * result + ((schedules == null) ? 0 : schedules.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (closeTime == null) {
			if (other.closeTime != null)
				return false;
		} else if (!closeTime.equals(other.closeTime))
			return false;
		if (moviesLibrary == null) {
			if (other.moviesLibrary != null)
				return false;
		} else if (!moviesLibrary.equals(other.moviesLibrary))
			return false;
		if (openTime == null) {
			if (other.openTime != null)
				return false;
		} else if (!openTime.equals(other.openTime))
			return false;
		if (schedules == null) {
			if (other.schedules != null)
				return false;
		} else if (!schedules.equals(other.schedules))
			return false;
		return true;
	}

	public Cinema() {
		this.openTime = new Time();
		this.closeTime = new Time();
	}

	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + "]";
	}

	static Supplier<Movie> newMovie = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name");
		String name = sc.next();
		System.out.println("Enter film duration( in Numbers)");
		return new Movie(name, new Time());
	};

	public void startCinema() {
		schedules.put(Days.Monday, new Schedule());
		schedules.put(Days.Tuesday, new Schedule());
		schedules.put(Days.Wednesday, new Schedule());
		schedules.put(Days.Thursday, new Schedule());
		schedules.put(Days.Friday, new Schedule());
		schedules.put(Days.Saturday, new Schedule());
		schedules.put(Days.Sunday, new Schedule());
	}

	public void addMovie() {

		moviesLibrary.add(newMovie.get());
	}

	public void removeMovie() {
		Movie movie = newMovie.get();

		Iterator<Days> iteratorOnDays = schedules.keySet().iterator();
		while (iteratorOnDays.hasNext()) {
			Days d = iteratorOnDays.next();
			schedules.get(d).removeSeanceWithMovie(movie);

		}
		moviesLibrary.remove(movie);
	}

	public void addSeanceToSchedule() {
		System.out.println("Let's check if we have this movie");
		Movie movie1 = newMovie.get();
		Predicate<Movie> predicate = movie -> movie.equals(movie1);
		Boolean weHaveThisMovie = moviesLibrary.stream().anyMatch(predicate);
		System.out.println("Enter day");
		Scanner sc = new Scanner(System.in);
		String day = sc.next();
		if (weHaveThisMovie == true) {
			System.out.println("Yes, now we proceed");
			Iterator<Days> iteratorOnDays = schedules.keySet().iterator();
			while (iteratorOnDays.hasNext()) {
				Days d = iteratorOnDays.next();
				if (d.name().equalsIgnoreCase(day)) {
					Seance newSeance = Schedule.mySeanceSupplier.get(movie1);
					if (newSeance.startTime.compareTo(openTime) < 0 && newSeance.startTime.compareTo(closeTime) > 0) {
						System.out.println("Sorry, you can't add seance when we are closed");
					} else if (newSeance.endTime.compareTo(closeTime) > 0) {
						System.out.println("Sorry, seance will finish after closing. We can't permit it");
					} else {
						schedules.get(d).addSeance(newSeance);
					}

				}
			}
		} else {
			System.out.println("We don't have this movie, sorry");
		}
	}

	public void removeSeanceFromSchedule() {
		Movie movie1 = newMovie.get();
		Predicate<Movie> predicate = movie -> movie.equals(movie1);
		Boolean weHaveThisMovie = moviesLibrary.stream().anyMatch(predicate);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day");
		String day = sc.next();
		if (weHaveThisMovie == true) {
			Iterator<Days> iteratorOnDays = schedules.keySet().iterator();
			while (iteratorOnDays.hasNext()) {
				Days d = iteratorOnDays.next();
				if (d.name().equalsIgnoreCase(day)) {
					schedules.get(d).removeSeance();

				}
			}
		} else {
			System.out.println("We don't have this movie, sorry");
		}
	}

	public void showFilms() {
		moviesLibrary.forEach(System.out::println);
	}

	public void showSchedules() {
		Iterator<Days> iteratorOnDays = schedules.keySet().iterator();
		while (iteratorOnDays.hasNext()) {
			System.out.println(schedules.get(iteratorOnDays.next()).toString());
		}
	}

}
