package mycalendar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyCalendarTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dayOfWeekToInt() {
		MyCalendar cal = new MyCalendar(2014, 8);

		int[][] testValues = {
				// {入力値, 期待値}
				{Calendar.MONDAY, 1},
				{Calendar.SUNDAY, 0},
				{Calendar.WEDNESDAY, 3},
				{Calendar.THURSDAY, 4},
				{Calendar.TUESDAY, 2},
				{Calendar.FRIDAY, 5},
				{Calendar.SATURDAY, 6},
				{1, 0}, // 1 はSUNDAYに当たる
				{0, -1},
				{-1, -1},
			};

		for(int[] val : testValues) {
			assertThat(cal.dayOfWeekToInt(val[0]), is(val[1]));
		}
	}
}
