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
        val expectedSome = Some(Some(10))
        val result = startingSome.map { it.map { ting -> ting * 2 } }

        assertEquals(expectedSome, result)
    }

    @Test
    fun testMultipleMapsTogether() {
        val startingSome = Some(Some(5))
        val expectedSome = Some("hello 10")

        val result = startingSome.flatMap { it.map { ting -> ting * 2  } }.map { "hello $it" }

        assertEquals(expectedSome, result)
    }

    @Test
    fun testFoldForSome() {
        val startingSome = Some(10)
        var someCounter = 0

        startingSome.fold({ someCounter = 1 }, { someCounter = 0 })

        assertTrue { someCounter == 1 }
    }

    @Test
    fun testFoldForNone() {
        val startingSome = None
        var someCounter = 0

        startingSome.fold({ someCounter = 1 }, { someCounter = 0 })

        assertTrue { someCounter == 0 }
    }

    @Test
    fun testShow() = assertEquals(10, Some(10).show())

    @Test
    fun testOptionFrom() = assertEquals(Some(10), optionFrom(10))

    @Test
    fun testNone() = assertTrue { None.show() is Nothing? }
}