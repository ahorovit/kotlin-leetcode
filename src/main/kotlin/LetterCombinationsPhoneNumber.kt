/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 */

fun main()
{
    val obj = LetterCombos()

    obj.letterCombinations("789").forEach {
        println(it)
    }
}


class LetterCombos {
    var inputDigits = ""
    val results = mutableListOf<String>()
    val builder = StringBuilder()
    var digitIndex = -1


    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()
        inputDigits = digits
        digitIndex = -1
        build()
        return results
    }

    fun build() {
        digitIndex++
        for(c in CHARS[inputDigits[digitIndex]]!!)
        {
            builder.append(c)

            if(isComplete()) {
                results.add(builder.toString())
            } else {
                build()
            }

            builder.deleteCharAt(digitIndex)
        }

        digitIndex--
    }


    fun isComplete(): Boolean
    {
        return builder.length == inputDigits.length
    }


    companion object {
        val CHARS = hashMapOf(
            '2' to listOf('a','b','c'),
            '3' to listOf('d','e','f'),
            '4' to listOf('g','h','i'),
            '5' to listOf('j','k','l'),
            '6' to listOf('m','n','o'),
            '7' to listOf('p','q','r','s'),
            '8' to listOf('t','u','v'),
            '9' to listOf('w','x','y', 'z')
        )
    }
}