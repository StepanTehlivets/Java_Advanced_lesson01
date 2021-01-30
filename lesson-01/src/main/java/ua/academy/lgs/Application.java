package ua.academy.lgs;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		System.out.println("Before we start, please tell me when we are open(First open time, than time of closing)");
		Cinema cinema = new Cinema();
		Scanner sc = new Scanner(System.in);
		cinema.startCinema();

		while (true) {
			Menu.menu();
			switch (sc.next()) {
			case "1": {
				cinema.addMovie();
				break;
			}
			case "2": {
				cinema.addSeanceToSchedule();
				break;
			}
			case "3": {
				cinema.removeSeanceFromSchedule();
				break;
			}
			case "4": {
				cinema.removeMovie();
				break;
			}
			case "5": {
				cinema.showFilms();
				break;
			}
			case "6": {
				cinema.showSchedules();
				break;
			}
			case "7": {
				System.exit(0);
			}
			}

		}
	}
}
