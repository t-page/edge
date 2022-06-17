package effects

sealed class Option

data class Some<T>(val value: T): Option() {
    fun show(): T = this.value
    fun <A>map(f: (T) -> A): Option = optionFrom(f(this.value))
    fun <A>flatMap(f: (T) -> Some<A>): Option = f(this.value)
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

fun <T> createSome(value: T): Option = Some(value)