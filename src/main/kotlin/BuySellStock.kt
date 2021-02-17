import kotlin.math.max
import kotlin.math.min

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 */


fun maxProfit(prices: IntArray): Int {
    var minSoFar = Int.MAX_VALUE
    var maxProfit = 0

    for(price in prices) {
        maxProfit = max(maxProfit, price - minSoFar)
        minSoFar = min(minSoFar, price)
    }

    return maxProfit
}