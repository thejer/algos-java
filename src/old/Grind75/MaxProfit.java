package javaSolutions.src.old.Grind75;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int curPrice : prices) {
            if (curPrice < minPrice) {
                minPrice = curPrice;
            } else if (curPrice - minPrice > maxProfit) {
                maxProfit = curPrice - minPrice;
            }
        }
        return maxProfit;
    }
}
