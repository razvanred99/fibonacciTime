import kotlinx.coroutines.runBlocking

fun main() {

    println(classicFibonacci(9))
    println(recFibonacci(9))

    runBlocking {
        with(fibonacciSequence.iterator()){
            for (i in 0 until 10){ //the tenth number is 9
                print("${next()}\t")
            }
        }
    }

}

fun classicFibonacci(n: Int): Int {
    var cur = 0
    var next = 1

    var i = 0

    while (true) {

        if (i == n)
            return cur

        val temp = cur
        cur = next
        next += temp

        i++
    }
}

fun recFibonacci(n: Int): Int {

    if (n == 0 || n == 1)
        return n

    return recFibonacci(n - 1) + recFibonacci(n - 2)
}

val fibonacciSequence = sequence {
    var next = 1
    var cur = 0
    var i = 0

    while (true) {
        yield(cur)
        val temp = cur
        cur = next
        next += temp
        i++
    }

}