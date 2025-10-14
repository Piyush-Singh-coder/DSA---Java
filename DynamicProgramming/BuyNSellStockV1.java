package DynamicProgramming;

public class BuyNSellStockV1 {
    public static int maxCost(int stocks[]){
        int min = stocks[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i<stocks.length; i++){
            int profit = stocks[i] - min;
            max = Math.max(max, profit);
            min = Math.min(min,stocks[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int stocks[] = {7,1,5,3,4,6};
        System.out.println(maxCost(stocks));
    }
}
