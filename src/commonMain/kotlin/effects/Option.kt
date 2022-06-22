package effects

sealed class Option {
    fun resolve(someFunction: () -> Unit, noneFunction: () -> Unit ) {
        when(this) {
            is Some<*> -> someFunction()
            is None -> noneFunction()
        }
    }
}

data class Some<T>(val value: T): Option() {
    fun show(): T = this.value
    fun <A>map(f: (T) -> A): Some<A> = Some(f(this.value))
    fun <A>flatMap(f: (T) -> Some<A>): Some<A> = f(this.value)

    fun flatten(): T {
        return when (this.show()) {
            is Some<*> -> this.show()
            is None -> this.show()
            else -> throw UnableToFlattenOption("This is not an Option. Unable to flatten")
        }
    }
}

object None: Option() {
    fun show(): Nothing? = null
}

fun <T> optionFrom(value: T?): Option {
    return when(value) {
        null -> None
        else -> Some(value)
    }
}

fun <T> createSome(value: T): Some<T> = Some(value)

class UnableToFlattenOption(message: String): Exception(message)