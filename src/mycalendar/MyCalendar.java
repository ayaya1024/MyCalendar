package mycalendar;

import java.util.Calendar;

/**
 * カレンダーを表示する
 */

public class MyCalendar {
	/** 日付、曜日計算用のクラス */
	private Calendar calendar;
	private int year;
	private int month;

	public MyCalendar(int year, int month) {
		this.year = year;
		this.month = month;

		calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(this.year, this.month - 1, 1);
	}

	/**
	 * 1日の曜日を取得する。
	 */
	public int firstDayOfWeek() {
		return this.calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 月の最終日
	 */
	public int endOfMonth() {
		return this.calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 日曜が0、土曜が6になるように変換する。
	 */
	public int dayOfWeekToInt(int dayOfweek) {
		switch(dayOfweek) {
		case Calendar.SUNDAY:
			return 0;
		case Calendar.MONDAY:
			return 1;
		case Calendar.TUESDAY:
			return 2;
		case Calendar.WEDNESDAY:
			return 3;
		case Calendar.THURSDAY:
			return 4;
		case Calendar.FRIDAY:
			return 5;
		case Calendar.SATURDAY:
			return 6;
		default:
			return -1;
		}
	}
}
