package routis.examples

import arrow.data.ListK

import arrow.data.k
import arrow.extension
import arrow.instances.listk.foldable.foldable
import arrow.typeclasses.Monoid
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class BigDecimalWrapper(val value: BigDecimal) {
    companion object
}

@extension
interface BigDecimalAddition : Monoid<BigDecimalWrapper> {
    override fun empty(): BigDecimalWrapper = BigDecimalWrapper(ZERO)
    override fun BigDecimalWrapper.combine(b: BigDecimalWrapper): BigDecimalWrapper =
        BigDecimalWrapper(this.value.plus(b.value))
}

fun main(args: Array<String>) {
    val ls = listOf(BigDecimal("1.0"), BigDecimal("2.0"))

// TODO This used to work on 0.7.3

//    with(ListK.foldable()) {
//        ls.k().map { BigDecimalWrapper(it) }.fold(BigDecimalWrapper.bigDecimalAddition())
//    }
}