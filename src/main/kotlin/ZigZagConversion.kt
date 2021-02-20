/*
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 */

fun main() {
    println(convert("AB", 1))
}



var input = ""
var rowCount = -1
var rows = arrayOf<StringBuilder>()
var rowIdx = 0
var charIdx = 0

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    initialize(s, numRows)

    while (isNotDone()) {
        zig()
        zag()
    }

    return rows.joinToString("") { it.toString() }
}

// Print Down
fun zig() {
    while(rowIdx < rowCount && isNotDone()) {
        appendNextChar()
        rowIdx++
    }
    rowIdx -= 2
}

// Print diagonally up
fun zag() {
    while(rowIdx >= 0 && isNotDone()) {
        appendNextChar()
        rowIdx--
    }
    rowIdx += 2
}

fun appendNextChar() {
    rows[rowIdx].append(input[charIdx])
    charIdx++
}

fun initialize(s: String, numRows: Int) {
    input = s
    rowCount = numRows
    rows = Array(numRows) { StringBuilder() }
    rowIdx = 0
    charIdx = 0
}

fun isNotDone(): Boolean {
    return charIdx < input.length
}
