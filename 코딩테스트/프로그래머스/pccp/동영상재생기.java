package 프로그래머스.pccp;

// https://school.programmers.co.kr/learn/courses/30/lessons/340213?language=java

class 동영상재생기 {
    public static void main(String[] args) {
        String answer = solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"});
        System.out.println(answer);
        String answer2 = solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"});
        System.out.println(answer2);
        String answer3 = solution("07:22", "04:05", "00:15", "04:07", new String[] {"next"});
        System.out.println(answer3);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_seconds = toSeconds(video_len);
        int pos_seconds = toSeconds(pos);
        int op_start_seconds = toSeconds(op_start);
        int op_end_seconds = toSeconds(op_end);

        pos_seconds = validate(pos_seconds, op_start_seconds, op_end_seconds, video_len_seconds);
        for (String command: commands) {
            if (command.equals("prev")) {
                pos_seconds -= 10;
            } else {
                pos_seconds += 10;
            }

            pos_seconds = validate(pos_seconds, op_start_seconds, op_end_seconds, video_len_seconds);
        }

        return toString(pos_seconds);
    }

    public static int validate(int pos_seconds, int op_start_seconds, int op_end_seconds, int video_len_seconds) {
        if (pos_seconds < 0) {
            pos_seconds = 0;
        }

        if (pos_seconds > video_len_seconds) {
            pos_seconds = video_len_seconds;
        }

        if (pos_seconds >= op_start_seconds && pos_seconds <= op_end_seconds) {
            pos_seconds = op_end_seconds;
        }

        return pos_seconds;
    }

    public static int toSeconds(String timeStr) {
        String[] times = timeStr.split(":");

        int minutes = Integer.parseInt(times[0]);
        int seconds = Integer.parseInt(times[1]);

        return minutes * 60 + seconds;
    }

    public static String toString(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;

        String minutesStr = minutes < 10 ? String.format("0%d", minutes) : Integer.toString(minutes);
        String secondsStr = seconds < 10 ? String.format("0%d", seconds) : Integer.toString(seconds);

        return String.format("%s:%s",minutesStr, secondsStr);
    }
}
