package effects

import kotlin.test.*

class EitherTest {
    @Test
    fun testRightMap() {
        val right = Right(1)
        val result = right.map { it + 1 }

        assertTrue { result.show() == 2 }
    }

    @Test
    fun testRightFlatMap() {
        val rightRight = Right(Right(1))
        val result = rightRight.flatMap { it.map { ting -> ting.toString() + "Hi!!!"}}

        assertFalse { result == Right(Right(Int)) }
        assertEquals(Right("1Hi!!!"), result)
    }

    @Test
    fun testLeftMap() {
        val left = Left(1)
        val result = left.map { it + 1 }

        assertTrue { result.show() == 2 }
    }

    @Test
    fun testLeftFlatMap() {
        val leftLeft = Left(Left(1))
        val result = leftLeft.flatMap { it.map { ting -> ting.toString() + "Hi!!!"}}

        assertFalse { result == Left(Left(Int)) }
        assertEquals(Left("1Hi!!!"), result)
    }

    @Test
    fun testResolveRightFun() {
        val right = Right(1)
        var rightCounter = 0

        right.resolve( { rightCounter = 1 }, { rightCounter = 0 })

        assertTrue { rightCounter == 1 }
    }

    @Test
    fun testResolveLeftFun() {
        val left = Left(1)
        var leftCounter = 0

        left.resolve( { leftCounter = 0 }, { leftCounter = 1 })

        assertTrue { leftCounter == 1 }
    }

    @Test
    fun testFlattenLeftOfRight() {
        val leftOfRight = Left(Right(1))

        assertEquals(Right(1), leftOfRight.flatten())
    }

    @Test
    fun testFlattenRightOfLeft() {
        val rightOfLeft = Right(Left(1))

        assertEquals(Left(1), rightOfLeft.flatten())
    }

    @Test
    fun testFlattenThrowsErrorWithRight() {
        val right = Right(1)

        assertFailsWith(
            UnableToFlattenEither::class,
            "This is not an Either. Unable to flatten"
        ) { right.flatten() }
    }

    @Test
    fun testFlattenThrowsErrorWithLeft() {
        val left = Left(1)

        assertFailsWith(
            UnableToFlattenEither::class,
            "This is not an Either. Unable to flatten"
        ) { left.flatten() }
    }
}