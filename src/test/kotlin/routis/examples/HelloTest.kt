package routis.examples

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import routis.examples.bigdecimalwrapper.monoid.combineAll
import java.math.BigDecimal

class HelloTest {


    @Test
    fun testMonoid() {
        val actual = listOf("1.0", "2.0")
                .map { BigDecimalWrapper(BigDecimal(it)) }
                .combineAll()
                .value
        assertEquals(BigDecimal("3.0"), actual)
    }

    @Test
    fun `verify that an optic in a sealed class works`() {
        val e = DomainError.SecurityError.NotAuthorized("foo")
        val e2=DomainError.securityError.notAuthorized.forAction.modify(e) {"bar"}
        if (e2 !is DomainError.SecurityError.NotAuthorized || e2.forAction != "bar") {
            fail()
        }

    }

    @Test
    fun `verify that an optic in a sealed class works even for wrong argument`() {
        val e = DomainError.NetworkError
        val e2=DomainError.securityError.notAuthorized.forAction.modify(e) {"bar"}
        if (e2 !is DomainError.NetworkError) {
            fail()
        }

    }
}
