import java.lang.Math.abs
import kotlin.math.absoluteValue

fun main() {
    val input = -123
    val output = ReverseInteger().reverse(input)

    println("reversed $input is $output")
}



class ReverseInteger {

    fun reverse(x: Int): Int {
        val signCoefficient = if (x < 0) -1 else 1

        return try {
            (x * signCoefficient).toString().reversed().toInt() * signCoefficient
        } catch (ex: Exception) {
            0
        }
    }
}