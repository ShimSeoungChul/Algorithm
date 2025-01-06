package 인강.딩코딩코.정렬_스택_큐_해쉬;

import java.util.Arrays;

// 쓱 최대로 할인 적용하기
// https://fern-freeze-290.notion.site/3-eda59f516d3d4372bdabe54674101396
public class Q1 {
    public static void main(String[] args) {
        System.out.println("정답 = 926000 / 현재 풀이 값 = " + getMaxDiscountedPrice(
                new int[]{30000, 2000, 1500000},
                new int[]{20, 40}
        ));
        System.out.println("정답 = 485000 / 현재 풀이 값 = " + getMaxDiscountedPrice(
                new int[]{50000, 1500000},
                new int[]{10, 70, 30, 20}
        ));
        System.out.println("정답 = 1550000 / 현재 풀이 값 = " + getMaxDiscountedPrice(
                new int[]{50000, 1500000},
                new int[]{}
        ));
        System.out.println("정답 = 1458000 / 현재 풀이 값 = " + getMaxDiscountedPrice(
                new int[]{20000, 100000, 1500000},
                new int[]{10, 10, 10}
        ));
    }

    public static int getMaxDiscountedPrice(int[] prices, int[] coupons) {
        Arrays.sort(prices);
        Arrays.sort(coupons);

        for (int i = 0; i < coupons.length; i++) {
            if(prices.length <= i) break;
            prices[prices.length - i - 1] = prices[prices.length - i - 1] * (100 - coupons[coupons.length - i - 1]) / 100;
        }

        return Arrays.stream(prices).sum();
    }
}

// 상품 가격이 높을 수록 높은 할인율의 쿠폰 적용하기
