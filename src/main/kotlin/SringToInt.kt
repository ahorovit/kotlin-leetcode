import java.lang.Exception

/*
 * Requirements:
 *
 * - there may be leading whitespace
 * - first non-whitespace char can be +,- or 0..9
 * --> result is positive if omitted
 * - terminate upon end of string or non-digit char
 * - if no digits read --> result is 0
 * - bound result to INT_MIN/INT_MAX
 */

fun main() {
    val testCases = listOf(
        Pair("21474836460", Int.MAX_VALUE),
        Pair("", 1),
        Pair("   ",0),
        Pair("   a",0),
        Pair("   +-123",0),
        Pair("123",123),
        Pair("  +123",123),
        Pair("  -123",-123),
        Pair("123a456",123),
        Pair("  -200000000000000000000000",Int.MIN_VALUE),
        Pair("  200000000000000000000000",Int.MAX_VALUE),
    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = myAtoi(input)
        println("""Input "$input" --> Output "$res"""")

        assert(res == testCase.second)

//        if (res != testCase.second) {
//            throw Exception("$res != ${testCase.second}")
//        }
    }
}

/*
 * States:
 * pre-digit (spaces -> continue, +-0..9 transition to sign
 * started-positive (+ or first digit)
 * out-of-bound-pos
 * started-negative (- only)
 * out-of-bound-neg
 * terminated
 */


sealed class State
object Terminated : State()
object PreDigits : State()
object MaxVal : State()
object MinVal : State()
object StartedPos : State()
object StartedNeg : State()

fun myAtoi(s: String): Int {
    val strBuilder = StringBuilder()
    var state: State = PreDigits

    loop@for (c in s) {
        state = checkNext(c, state)

        when (state) {
            is PreDigits -> continue@loop
            is StartedPos, is StartedNeg -> {
                strBuilder.append(c)
                if (c in '0'..'9') {
                    state = checkBounds(strBuilder, state)
                }
            }
            is MaxVal, is MinVal, is Terminated -> break@loop
        }
    }

    return when(state) {
        MaxVal -> Int.MAX_VALUE
        MinVal -> Int.MIN_VALUE
        else -> {
            try {
                strBuilder.toString().toInt()
            } catch (e: Throwable) {
                0
            }
        }
    }
}

fun checkNext(next: Char, state: State): State {
    return when(state) {
        is PreDigits -> {
            when(next) {
                ' ' -> PreDigits
                '+' -> StartedPos
                '-' -> StartedNeg
                in '0'..'9' -> StartedPos
                else -> Terminated
            }
        }
        is StartedPos, is StartedNeg -> {
            when(next) {
                in '0'..'9' -> state
                else -> Terminated
            }
        }
        is MaxVal, is MinVal, Terminated -> state
    }
}

fun checkBounds(strBuilder: StringBuilder, state: State): State {
    val long = strBuilder.toString().toLong()

    return when {
        long > Int.MAX_VALUE -> MaxVal
        long < Int.MIN_VALUE -> MinVal
        else -> state
    }
}

