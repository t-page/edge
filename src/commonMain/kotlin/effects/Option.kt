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

    fun combine(someToAdd: Some<*>): Some<*> {
        return when (someToAdd.value) {
            is Int -> Some(this.value as Int + someToAdd.value)
            is Number -> Some(this.value as Number + someToAdd.value)
            is Long -> Some(this.value as Long + someToAdd.value)
            is Char -> Some(this.value.toString() + someToAdd.value.toString())
            is String -> Some(this.value as String + someToAdd.value)
            else -> Some("ting")
        }
    }
}

object None: Option() {
    fun combine(secondSome: None): None = None
    fun show(): Nothing? = null
}

fun <T> optionFrom(value: T?): Option {
    return when(value) {
        null -> None
        else -> Some(value)
    }
}

fun <T> createSome(value: T): Some<T> = Some(value)

private operator fun <T> T.plus(value: T): T =  this + value

class UnableToFlattenOption(message: String): Exception(message)