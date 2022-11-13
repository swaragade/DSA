package io.swaragade;

// cmd + option + L : format code

public class BuySellStock {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = fr.nextInt();
        }
        System.out.println(new BuySellStock().maxProfit(inputArr));
    }

    public int maxProfit(int[] prices) {
        int maxProf = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProf){
                    maxProf = profit;
                }
            }

        }
        return maxProf;
    }
}
