package routis.examples

import arrow.product

@product
data class Account(val balance: Int, val available: Int) {
    companion object
}

fun main(args: Array<String>) {

    val a = Account(10, 10).tupled().also { println(it) }
    (Account(10, 10) + Account(20, 2)).also { println(it) }
}