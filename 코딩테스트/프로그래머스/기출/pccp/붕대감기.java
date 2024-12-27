package 프로그래머스.기출.pccp;

import java.util.*;

public class 붕대감기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[] {5,1,5}, 30, new int[][] {{2, 10}, {9, 15}, {10, 5}, {11, 5}});
        System.out.println(result);
    }
}

class Attack{
    final int time;
    final int damage;

    public Attack(int time, int damage) {
        this.time = time;
        this.damage = damage;
    }

    public int getTime() {
        return time;
    }

    public int getDamage() {
        return damage;
    }
}

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        boolean continued = true;
        Queue<Attack> attackList = new LinkedList<>();

        for (int[] attack: attacks) {
            attackList.add(new Attack(attack[0], attack[1]));
        }

        Attack attack = attackList.poll();
        int currentTime = 1;
        int castingTime = 0;
        int currentHealth = health;

        while(continued) {
            if (attack.getTime() == currentTime) {
                currentHealth -= attack.getDamage();

                if (currentHealth <= 0) {
                    currentHealth = -1;
                    continued = false;
                }
                castingTime = 0;
                attack = attackList.poll();

                if (attack == null) {
                    continued = false;
                }
            } else {
                currentHealth = recover(currentHealth, bandage[1], health);
                castingTime++;
                if (castingTime == bandage[0]) {
                    currentHealth = recover(currentHealth, bandage[2], health);
                    castingTime = 0;
                }

            }

            currentTime++;
        }

        return currentHealth;
    }

    public int recover(int currentHealth, int bandageSize, int totalHealth) {
        currentHealth += bandageSize;
        if (currentHealth > totalHealth) {
            currentHealth = totalHealth;
        }
        return currentHealth;
    }
}