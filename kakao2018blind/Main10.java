package kakao2018blind;

import java.util.ArrayList;
import java.util.Comparator;

class Main10 {
	public static void main(String[] args) {
		Solution10 sol = new Solution10();
		int n = 2;
		int t = 10;
		int m = 2;
//		String[] timetable = { "09:00", "09:00", "09:00", "09:00" };
		String[] timetable = { "09:10", "09:09", "08:00" };
//		String[] timetable = { "08:00", "08:01", "08:02", "08:03" };

		sol.solution(n, t, m, timetable);
	}
}

class Bus {
	String time;
	ArrayList<Crue> seat;

	Bus(String time) {
		this.time = time;
		seat = new ArrayList<>();
	}
}

class Crue {
	int busIndex;
	int time;

	Crue(int time) {
		this.time = time;
	}
}

class Solution10 {
	ArrayList<Crue> crues;
	Bus busList[];
	int myTime = 0;

	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		busList = new Bus[n];

		for (int i = 0; i < n; i++) {
			int time = timeToNum("09:00") + i * t;
			busList[i] = new Bus(timeToString(time));
		}

		crues = new ArrayList<>();
		for (int i = 0; i < timetable.length; i++) {
			crues.add(new Crue(timeToNum(timetable[i])));
		}

		Comparator<Crue> com = new Comparator<Crue>() {

			@Override
			public int compare(Crue o1, Crue o2) {
				if (o1.time > o2.time)
					return 1;
				else
					return -1;
			}
		};

		crues.sort(com);

		boolean flag = true;
		for (int i = 0; i < crues.size(); i++) {
			boolean notEmpty = true;
			for (int j = 0; j < busList.length; j++) {
				if (timeToNum(busList[j].time) < crues.get(i).time)
					continue;
				if (busList[j].seat.size() < m) {
					crues.get(i).busIndex = j;
					busList[j].seat.add(crues.get(i));
					notEmpty = true;
					break;
				} else
					notEmpty = false;
			}

			if (notEmpty == false) {
				flag = false;
				break;
			}
		}

		if (flag == true && busList[n - 1].seat.size() < m)
			answer = busList[n - 1].time;
		else

		{
			answer = timeToString(busList[n - 1].seat.get(busList[n - 1].seat.size() - 1).time - 1);
		}

		return answer;
	}

	int timeToNum(String time) {
		int calcTime = 0;

		calcTime = Integer.parseInt(time.split(":")[0]) * 60;
		calcTime = calcTime + Integer.parseInt(time.split(":")[1]);

		return calcTime;
	}

	String timeToString(int time) {
		StringBuilder sb = new StringBuilder();

		sb.append(time / 60 < 10 ? "0" + time / 60 : time / 60);
		sb.append(":");
		sb.append(time % 60 < 10 ? "0" + time % 60 : time % 60);

		return sb.toString();
	}
}