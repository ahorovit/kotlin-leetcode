/*
https://leetcode.com/problems/median-of-two-sorted-arrays/

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */


fun main() {
    println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val merged = merge(nums1, nums2)
    val mid = merged.size / 2
    return when {
        merged.size % 2 == 0 -> {
            (merged[mid - 1].toDouble() + merged[mid].toDouble()) / 2
        }
        else -> {
            merged[mid].toDouble()
        }
    }
}

fun merge(nums1: IntArray, nums2: IntArray): IntArray {
    val m = nums1.size
    val n = nums2.size

    if (m == 0) return nums2
    if (n == 0) return nums1

    var ptr1 = 0
    var ptr2 = 0
    val result = IntArray(m + n) { 0 }

    while (ptr1 < m || ptr2 < n) {
        result[ptr1 + ptr2] = when {
            ptr1 == m -> nums2[ptr2++]
            ptr2 == n -> nums1[ptr1++]
            else -> {
                if (nums1[ptr1] < nums2[ptr2]) {
                    nums1[ptr1++]
                } else {
                    nums2[ptr2++]
                }
            }
        }
    }

    return result
}
