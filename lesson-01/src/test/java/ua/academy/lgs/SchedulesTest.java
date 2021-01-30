package ua.academy.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class SchedulesTest {
	private Schedule schedule;
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
		schedule  = new Schedule();
	}

	@After
	public void afterTest() {
		schedule = null;
	}
	@Test
	public void addSeanceTest() {
		int expectedSize = schedule.seances.size()+1;
		schedule.addSeance(Schedule.seanceSupplier.get());
		int sizeAfterAdding =schedule.seances.size();
		
		Assert.assertEquals(expectedSize, sizeAfterAdding);
	}
	public void RemoveSeanceTest() {
		int expectedSize = 0;
		schedule.addSeance(Schedule.seanceSupplier.get());
		schedule.removeSeance();
		int sizeAfterDeleting =schedule.seances.size();
		
		Assert.assertEquals(expectedSize, sizeAfterDeleting);
	}
	
	
}
