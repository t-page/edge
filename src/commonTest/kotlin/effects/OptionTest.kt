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
    fun testResolveForSome() {
        val startingSome = Some(10)
        var someCounter = 0

        startingSome.resolve({ someCounter = 1 }, { someCounter = 0 })

        assertTrue { someCounter == 1 }
    }

    @Test
    fun testResolveForNone() {
        val startingSome = None
        var someCounter = 0

        startingSome.resolve({ someCounter = 1 }, { someCounter = 0 })

        assertTrue { someCounter == 0 }
    }

    @Test
    fun testFlattenForSomeOfSome() {
        val someOfSome = Some(Some(10))

        assertEquals(Some(10), someOfSome.flatten())
    }

    @Test
    fun testCombineForSomeInt() {
        val firstSome = Some(10)
        val secondSome = Some(10)

        val result = firstSome.combine(secondSome)

        assertEquals(Some(20), result)
    }

    @Test
    fun testCombineForSomeString() {
        val firstSome = Some("ting ")
        val secondSome = Some("ting!")

        val result = firstSome.combine(secondSome)

        assertEquals(Some("ting ting!"), result)
    }

    @Test
    fun testCombineForSomeChar() {
        val s = "AB"
        val a: Some<Char> = Some(s[0])
        val b: Some<Char> = Some(s[1])

        val result = a.combine(b)

        assertEquals(Some("AB"), result)
    }

    @Test
    fun testCombineForNone() {
     val noneOne = None
     val noneTwo = None

     val result = noneOne.combine(noneTwo)

     assertEquals(None, result)
    }

    @Test
    fun testShow() = assertEquals(10, Some(10).show())

    @Test
    fun testOptionFrom() = assertEquals(Some(10), optionFrom(10))

    @Test
    fun testNone() = assertTrue { None.show() is Nothing? }
}