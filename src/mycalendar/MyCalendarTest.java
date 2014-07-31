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

	@Test
	public void mappingDays() {
		MyCalendar cal = new MyCalendar(2014, 8);

		int[][] august = cal.mappingDays();

		assertThat(august[0][0], is(0));
		assertThat(august[0][5], is(1));
		assertThat(august[1][0], is(3));
		assertThat(august[2][0], is(10));
		assertThat(august[3][0], is(17));
		assertThat(august[4][0], is(24));
		assertThat(august[5][0], is(31));
		assertThat(august[5][6], is(0));
	}

	@Test
	public void render() {
		MyCalendar cal = new MyCalendar(2014, 8);

		String except = "                1  2\n" +
		                " 3  4  5  6  7  8  9\n" +
				        "10 11 12 13 14 15 16\n" +
		                "17 18 19 20 21 22 23\n" +
				        "24 25 26 27 28 29 30\n" +
		                "31\n";

		assertThat(cal.render(), is(except));
	}
}
