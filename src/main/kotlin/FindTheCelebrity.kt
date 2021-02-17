/*
https://leetcode.com/problems/find-the-celebrity/

Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity.
The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is
to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the
celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int
findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if
there is a celebrity in the party. If there is no celebrity, return -1.

 */


interface Relation
{
    fun knows(a: Int, b: Int) : Boolean
    fun findCelebrity(n: Int) : Int
}


/*
observations:
    - it's impossible for there to be multiple Celebrities, because they would have to know each other, which would disqualify them
    - we don't know how many edges there are
    - we never need to call knows(a,a) -- always 1
    - as soon as knows(a,b) returns true, we know a is not a celebrity
    --> We never need to call knows(_,a) after
    - once we find someone who knows nobody, we need to verify that everyone knows them
    - once we find someone who everyone knows, we need to verify they know nobody

 */

class Soln: Relation {
    private var N = -1
    private lateinit var isCelebrityMap: Array<Boolean?>

    override fun findCelebrity(n: Int) : Int {
        N = n
        isCelebrityMap = Array(N) { null }

        loop@for (i in 0 until n) {
            if (isCelebrityMap[i] == false) continue@loop

            if (isKnownByAll(i) && knowsNobody(i)) {
                return i
            }
        }

        return -1
    }

    fun isKnownByAll(i: Int): Boolean
    {
        loop@for(j in 0 until N) {
            if (j == i) continue@loop
            if (!knows(j, i)) {
                isCelebrityMap[i] = false
                return false
            } else {
                isCelebrityMap[j] = false
            }
        }

        return true
    }

    fun knowsNobody(i: Int): Boolean
    {
        loop@for(j in 0 until N) {
            if (j == i) continue@loop
            if (knows(i, j)) {
                isCelebrityMap[i] = false
                return false
            } else {
                isCelebrityMap[j] = false
            }
        }

        return true
    }




    override fun knows(a: Int, b: Int) = true
}