package edu.neu.coe.info6205.union_find;

import java.lang.reflect.Field;
import java.util.*;

public class UF_HWQUPC_client {


    static final Random rand = new Random();

    public static void main(String[] args) throws Exception {
        //input the value of point
        int n = inputValue();
        //get count
        System.out.println(count(n));
    }

    public static int count(int n) throws Exception {
        UF uf = new UF_HWQUPC(n);
        Class<UF_HWQUPC> c = UF_HWQUPC.class;
        Field field = c.getDeclaredField("height");
        field.setAccessible(true);
        int[] height = (int[]) field.get(uf);
        int count = 0;
        while (!contains(height, n)) {
            Pair pair = randomPair(n);
            
            if (uf.isConnected(pair.getFirst(), pair.getSecond())) {
                continue;
            }
            uf.connect(pair.getFirst(), pair.getSecond());
	    count++;
        }

        //assert if n = 6 whether all of point is connected
        //assertTrue(uf.isConnected(0, 1));
        //assertTrue(uf.isConnected(0, 2));
        //assertTrue(uf.isConnected(0, 3));
        //assertTrue(uf.isConnected(0, 4));
        //assertTrue(uf.isConnected(0, 5));
        //assertTrue(uf.isConnected(1, 2));
        //assertTrue(uf.isConnected(1, 3));
        //assertTrue(uf.isConnected(1, 4));
        //assertTrue(uf.isConnected(1, 5));
        //assertTrue(uf.isConnected(2, 3));
        //assertTrue(uf.isConnected(2, 4));
        //assertTrue(uf.isConnected(2, 5));
        //assertTrue(uf.isConnected(3, 4));
        //assertTrue(uf.isConnected(3, 5));
        //assertTrue(uf.isConnected(4, 5));

        return count;
    }

    public static boolean contains(int[] arr, int targetValue) {
        for (int s : arr) {
            if (s == targetValue) {
                return true;
            }
        }
        return false;
    }

    /**
     * input point
     *
     * @return
     */
    static int inputValue() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * Get a random value pair
     *
     * @param n get the value from 0 to n
     * @return a random value pair
     */

    static Pair randomPair(int n) {
        int first = rand.nextInt(n);
        int second = rand.nextInt(n);
        return new Pair(first, second);
    }

    /**
     * Store a pair of values
     */
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
