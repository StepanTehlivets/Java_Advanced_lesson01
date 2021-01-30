package ua.academy.lgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Time implements Comparable <Time>{
	int hours;
	int min;

	public Time() {
		this.setHours();
		this.setMin();

	}

	public Time(int hours, int minutes) {
		this.hours = hours;
		min = minutes;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + min;
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
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	public int getMin() {
		return min;
	}

	public void setMin() {
		boolean timeIsSettedRight = false;
		Scanner sc = new Scanner(System.in);

		while (!timeIsSettedRight) {
			try {
				System.out.println("Enter minutes");
				int min = sc.nextInt();
				if (min <= 60 && min >= 0) {
					this.min = min;
					timeIsSettedRight = true;
				} else {
					throw new WrongTimeInputException("Sorry wrong time");
				}
			} catch (WrongTimeInputException e) {
				System.out.println(e.getMessage() + " there are only 60 minutes in hour");
			} catch (InputMismatchException e) {
				System.out.println("Please, use numbers to set time");

			}
		}

	}

	public int getHours() {
		return hours;
	}

	public void setHours() {
		boolean timeIsSettedRight = false;
		Scanner sc = new Scanner(System.in);

		while (!timeIsSettedRight) {
			try {
				System.out.println("Enter hours");
				int hours = sc.nextInt();
				if (hours <= 24 && hours >= 0) {
					this.hours = hours;
					timeIsSettedRight = true;
				} else {
					throw new WrongTimeInputException("Sorry wrong time");
				}
			} catch (WrongTimeInputException e) {
				System.out.println(e.getMessage() + " there are only 24 hours in day");
			} catch (InputMismatchException e) {
				System.out.println("Please, use numbers to set time");
			}
		}

	}

	@Override
	public String toString() {
		return hours + ":" + min;
	}
	
	
	@Override
	public int compareTo(Time o) {
		if (this.hours > o.getHours()) {
			return 1;
		} else if (this.hours < o.getHours()) {
			return -1;
		} else {
			if (this.min > o.getMin()) {
				return 1;
			} else if(this.min < o.getMin()){
				return -1;
			}

		}
		return 0;
	}

}
