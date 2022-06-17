package effects

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class OptionTest {
    @Test
    fun testCreateSome() {
        val expectedSome: Option = createSome("I am a Some")
        assertTrue { expectedSome is Some<*> }
    }

    @Test
    fun testSomeMap() {
        val startingSome = Some(5)
        val expectedSome = Some(10)

        assertEquals(expectedSome, startingSome.map{ it * 2 })
    }

    @Test
    fun testSomeFlatMap() {
        val startingSome = Some(Some(5))
        val expectedSome = Some(10)
        val result = startingSome.flatMap { Some(it.flatMap { ting -> Some(ting * 2) }) }

        assertEquals(expectedSome, result)
    }

    @Test
    fun testShow() = assertEquals(10, Some(10).show())

    @Test
    fun testOptionFrom() = assertEquals(Some(10), optionFrom(10))

    @Test
    fun testNone() = assertTrue { None.show() is Nothing? }
}