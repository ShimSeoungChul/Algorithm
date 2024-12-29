package 인강.딩코딩코.이진탐색과재귀;

import java.util.List;
import java.util.Arrays;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        List<String> shopMenus = Arrays.asList("만두", "떡볶이", "오뎅", "사이다", "콜라");
        List<String> shopOrders = Arrays.asList("오뎅", "콜라", "만두");
        List<String> shopOrders2 = Arrays.asList("오뎅", "콜라", "만두", "짬뽕");

        boolean result = isAvailableToOrde2(shopMenus, shopOrders);
        System.out.println(result);

        boolean result2 = isAvailableToOrde2(shopMenus, shopOrders2);
        System.out.println(result2);
    }

    public static boolean isAvailableToOrder(List<String> menus, List<String> orders) {
        List<String> shopMenus = menus.stream().sorted().toList(); // 시간 복잡도 nlogn
        for(String order : orders) {
            int start = 0;
            int end = shopMenus.size() - 1;

            int mid = 0;
            while(start <= end) {
                mid = (start + end) / 2;
                if (order.compareTo(shopMenus.get(mid)) == 0) {
                    break;
                } else if (order.compareTo(shopMenus.get(mid)) < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (!order.equals(shopMenus.get(mid))) return false;
        }

        return true;
    }

    // 개선
    public static boolean isAvailableToOrde2(List<String> menus, List<String> orders) {
        Set<String> menuSet = Set.copyOf(menus);

        for (String order : orders) {
            if (!menuSet.contains(order)) return false;
        }

        return true;
    }
}