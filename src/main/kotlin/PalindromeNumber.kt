import java.lang.Exception

/*
input: integer
output bool -> true if palindrome, false if not
 */


fun main()
{
    val testCases = listOf(
        Pair(0,true),
        Pair(11,true),
        Pair(121,true),
        Pair(1221,true),
        Pair(12321,true),
        Pair(1234321,true),
        Pair(12344321,true),
        Pair(-1,false),
        Pair(10,false),
        Pair(123,false),
    )

    for (testCase in testCases) {
        val input = testCase.first
        val res = isPalindrome(input)
        println("""Input "$input" --> Output "$res"""")

        if (res != testCase.second) {
            throw Exception("$res != ${testCase.second}")
        }
    }
}


fun isPalindrome(x: Int): Boolean {

    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false
    }

    if (x < 10) {
        return true
    }

    var forward = x
    var backward = 0

    while(backward <= forward) {
        val digit = forward % 10
        forward /= 10

        backward *= 10
        backward += digit

        if (forward == backward || forward == backward/10){
            return true
        }
    }



    return false
}


//
//fun isPalindrome(x: Int): Boolean {
////    return x.toString().reversed() == x.toString()
//
//    if (x < 0) {
//        return false
//    }
//
//    val input = x.toString()
//
//    if (input.length == 1) {
//        return true
//    }
//
//    var i: Int = input.length / 2 - 1
//    var j: Int
//
//
//    if (input.length % 2 == 0) {
//        // if even: start middle, move out
//        j = i + 1
//    } else {
//        // if even: start middle, move out
//        j = i + 2
//    }
//
//    while(i >= 0 && j <= input.length) {
//        if (input[i] != input[j]) {
//            return false
//        }
//
//        i--
//        j++
//    }
//
//    return true
//}