package routis.examples

import arrow.optics.optics

@optics data class Account(val balance: Int, val available: Int) {
    companion object
}

fun main() {

    val a = Account(10, 10).let(Account.iso::get)
//    (Account(10, 10) + Account(20, 2)).also { println(it) }
}