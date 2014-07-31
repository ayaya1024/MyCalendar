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
	 * 描画する。
	 */
	public void print() {
		System.out.println(this.render());
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

	/**
	 * 配列でカレンダーを組む
	 */
	public int[][] mappingDays () {
		int[][] map = new int[6][7];
		// 月の最初の日の曜日
		int firstWeekday = dayOfWeekToInt(firstDayOfWeek());
		// 月の最終日
		int endOfMonth = endOfMonth();

		int dayOfCount = 1; // 日付

		// 第1週
		for(int day = firstWeekday; day < 7; day++) {
			map[0][day] = dayOfCount;
			dayOfCount++;
		}

		// 第2週以降
		map_for:
		for(int week = 1; week < 6; week++) { // 週（行）
			for(int day = 0; day < 7; day++) { // 曜日（列）
				map[week][day] = dayOfCount;
				dayOfCount++;
				if (dayOfCount > endOfMonth) {
					break map_for; // ループを終える
				}
			}
		}

		return map;
	}

	/**
	 * カレンダーを描画する。
	 */
	public String render() {
		int[][] map = mappingDays();
		// 月の最終日
		int endOfMonth = endOfMonth();

		StringBuilder builder = new StringBuilder();

		render_for:
		for (int week = 0; week < 6; week++) { // 週（行）
			for (int day = 0; day < 7; day++) { // 曜日（列）
				// 1日より前は空白で埋める
				if (map[week][day] == 0){
					builder.append("   ");
					continue;
				}

				builder.append(String.format("%2d", map[week][day]));

				// 最終日になったら終了
				if(map[week][day] == endOfMonth) {
					builder.append('\n');
					break render_for; // ループを終える
				}

				if (day < 6) { // 土曜日以外は日付の後ろに空白を挿入
					builder.append(' ');
				}
			}
			builder.append('\n');
		}

		return builder.toString();
	}

	/**
	 * お題1：休日（土日）の前に「*」を表示するようにする。
	 *        休日以外は「*」の代わりに半角空白を入れる。（横位置を揃えるため）
	 *        理想形はテストコードを参照。
	 */
	public String render(boolean holiday) {
		int[][] map = mappingDays();
		// 月の最終日
		int endOfMonth = endOfMonth();

		StringBuilder builder = new StringBuilder();

		render_for:
		for (int week = 0; week < 6; week++) { // 週（行）
			for (int day = 0; day < 7; day++) { // 曜日（列）
				// 1日より前は空白で埋める
				if (map[week][day] == 0){
					builder.append("   ");
					continue;
				}

				builder.append(String.format("%2d", map[week][day]));

				// 最終日になったら終了
				if(map[week][day] == endOfMonth) {
					builder.append('\n');
					break render_for; // ループを終える
				}

				if (day < 6) { // 土曜日以外は日付の後ろに空白を挿入
					builder.append(' ');
				}
			}
			builder.append('\n');
		}

		return builder.toString();
	}

	/**
	 * お題2：前後の月も一緒にカレンダーにする。
	 *        理想形はテストコードを参照。
	 */
	public String renderWithSide() {
		return "";
	}
}
