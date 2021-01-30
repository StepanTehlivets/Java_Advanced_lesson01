package ua.academy.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	private Cinema cinema;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() {
		cinema  = new Cinema();
	}

	@After
	public void afterTest() {
		cinema = null;
	}
	@Test
	public void startCinemaTest() {
		cinema.startCinema();
		String firstDayInMyCinema = cinema.schedules.firstKey().toString();
		String realFirstDay = "Monday";
		Assert.assertEquals(firstDayInMyCinema, realFirstDay);
	}
	
	@Test
	public void addMovieTest() {
		int expectedSize = cinema.moviesLibrary.size()+1;
		cinema.addMovie();
		int sizeAfterAdding =cinema.moviesLibrary.size();
		
		Assert.assertEquals(expectedSize, sizeAfterAdding);
	}
	
	@Test
	public void removeMovieTest() {
		int expectedSize = 0;
		cinema.addMovie();
		cinema.removeMovie();
		int sizeAfterDeleting =cinema.moviesLibrary.size();
		
		Assert.assertEquals(expectedSize, sizeAfterDeleting);
	}
}
