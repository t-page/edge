package effects

sealed class Either<T> {
    abstract fun show(): T

    fun resolve(rightFunc: () -> Unit, leftFunc: () -> Unit) {
        when (this) {
            is Right<*> -> rightFunc()
            is Left<*> -> leftFunc()
        }
    }

    fun flatten(): T {
        return when (this.show()) {
            is Right<*> -> this.show()
            is Left<*> -> this.show()
            else -> throw UnableToFlattenEither("This is not an Either. Unable to flatten")
        }
    }
}

data class Right<T> (val value: T): Either<T>() {
    override fun show(): T = this.value
    fun <A>map(f: (T) -> A): Right<A> = Right(f(this.value))
    fun <A>flatMap(f: (T) -> Right<A>) = f(this.value)
}

data class Left<T> (val value: T): Either<T>() {
    override fun show(): T = this.value
    fun <A>map(f: (T) -> A): Left<A> = Left(f(this.value))
    fun <A>flatMap(f: (T) -> Left<A>): Left<A> = f(this.value)
}

class UnableToFlattenEither(message: String): Exception(message)