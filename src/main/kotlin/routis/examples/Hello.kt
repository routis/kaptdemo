package routis.examples

import arrow.extension
import arrow.typeclasses.Monoid
import routis.examples.bigdecimalwrapper.monoid.combineAll
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

fun main() {
    println(listOf(BigDecimal("1.0"), BigDecimal("2.0"))
            .map { BigDecimalWrapper(it) }.combineAll().value)
}