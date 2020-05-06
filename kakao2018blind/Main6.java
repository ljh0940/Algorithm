package kakao2018blind;

import java.util.ArrayList;
import java.util.Comparator;

class Main6 {
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		String m = "CC#BCC#BCC#BCC#B";
		String musicinfos[] = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };
		sol.solution(m, musicinfos);
	}
}

class Music {
	int index;
	String music;
	String melody;
	String startTime;
	String endTime;
	String playMelody;
	int time = 0;

	Music(int index, String music, String melody, String startTime, String endTime) {
		this.index = index;
		this.music = music;
		this.melody = melody.replace("C#", "H").replace("D#", "I").replace("F#", "J").replace("G#", "K").replace("A#",
				"L");
		this.startTime = startTime;
		this.endTime = endTime;

		calcTime();

		playMelody = playMelody(this.melody, time);
	}

	void calcTime() {
		time = Integer.parseInt(endTime.split(":")[0]) * 60;
		time = time + Integer.parseInt(endTime.split(":")[1]);
		time = time - Integer.parseInt(startTime.split(":")[0]) * 60;
		time = time - Integer.parseInt(startTime.split(":")[1]);
	}

	String playMelody(String melody, int time) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < time; i++) {
			sb.append(melody.charAt(count++));
			if (count == melody.length())
				count = 0;
		}

		return sb.toString();
	}
}

class Solution6 {
	ArrayList<Music> musicList;

	public String solution(String m, String[] musicinfos) {
		String answer = "";

		m = m.replace("C#", "H").replace("D#", "I").replace("F#", "J").replace("G#", "K").replace("A#", "L");

		musicList = new ArrayList<>();
		for (int i = 0; i < musicinfos.length; i++) {
			String str[] = musicinfos[i].split(",");
			String startTime = str[0];
			String endTime = str[1];
			String music = str[2];
			String melody = str[3];

			Music ms = new Music(i, music, melody, startTime, endTime);
			if (ms.playMelody(ms.melody, ms.time).contains(m)) {
				musicList.add(ms);
			}
		}

		if (musicList.size() == 0) {
			answer = "(None)";
		} else if (musicList.size() == 1) {
			answer = musicList.get(0).music;
		} else {
			Comparator<Music> com = new Comparator<Music>() {

				@Override
				public int compare(Music o1, Music o2) {
					if (o1.time < o2.time)
						return 1;
					else if (o1.time == o2.time) {
						if (o1.index > o2.index)
							return 1;
						else
							return -1;
					}
					return -1;
				}
			};

			musicList.sort(com);

			answer = musicList.get(0).music;
		}

		return answer;
	}

}