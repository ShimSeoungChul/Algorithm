package 프로그래머스.기출.pccp;

public class 아날로그시계TODO {
    public static void main(String[] args) {
        Solution아날로그시계TODO solution = new Solution아날로그시계TODO();
        System.out.println(solution.solution(12, 30, 55, 13, 31, 57));.

    }
}

class Solution아날로그시계TODO {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;

        if (startTime == 0 * 3600 || startTime == 12 * 3600) {
            answer++;
        }

        while (startTime < endTime) {
            double hCurAngle = startTime / 120.0 % 360;
            double mCurAngle = startTime / 10.0 % 360;
            double sCurAngle = startTime * 6.0 % 360;

            double hNextAngle = (startTime + 1) / 120.0 % 360 == 0 ? 360 : (startTime + 1) / 120.0 % 360;
            double mNextAngle = (startTime + 1) / 10.0 % 360 == 0 ? 360 : (startTime + 1) / 10.0 % 360;
            double sNextAngle = (startTime + 1) * 6.0 % 360 == 0 ? 360 : (startTime + 1) * 6.0 % 360;

            if (sCurAngle < hCurAngle && sNextAngle >= hNextAngle) {
                answer++;
            }
            if (sCurAngle < mCurAngle && sNextAngle >= mNextAngle) {
                answer++;
            }
            if (sNextAngle == hNextAngle && hNextAngle == mNextAngle) {
                answer--;
            }

            startTime++;
        }

        return answer;
    }
}

// 초침과 시침이 겹치는 횟수 더하기
// 초침과 분침이 겹치는 횟수 더하기
// 초침과 분침과 시침이 겹치는 횟수 빼기

// 시침은 1시간 동안 30도, 1분 동안 1/2도, 1초 동안 1/120도 움직임
// 분침은 1분 동안 6도, 1초 동안 1/10도 움직임
// 초침은 1초 동안 6도 움직임
// 초침이 분침, 시침의 각도보다 낮다가 높아지면 겹치는 순간이 온거임