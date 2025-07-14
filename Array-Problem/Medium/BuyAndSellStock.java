import java.util.Scanner;

public class BuyAndSellStock {
     public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (buyPrice < price) {
                int currProfit = price - buyPrice;
                maxProfit = Math.max(maxProfit, currProfit);
            } else {
                buyPrice = price;
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuyAndSellStock sol = new BuyAndSellStock();

        // Input for stock prices
        System.out.println("Enter stock prices separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] prices = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        int result = sol.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}

