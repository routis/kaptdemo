package routis.examples

import arrow.instance
import arrow.typeclasses.Monoid
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class BigDecimalWrapper(val value: BigDecimal) {
 companion object
}

@instance(BigDecimalWrapper::class)
interface BigDecimalAddition : Monoid<BigDecimalWrapper>{
    override fun empty(): BigDecimalWrapper  = BigDecimalWrapper(ZERO)
    override fun BigDecimalWrapper.combine(b: BigDecimalWrapper): BigDecimalWrapper =
        BigDecimalWrapper(this.value.plus(b.value))
}