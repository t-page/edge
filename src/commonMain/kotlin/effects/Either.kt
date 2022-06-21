package effects

sealed class Either {
    fun resolve(rightFunc: () -> Unit, leftFunc: () -> Unit) {
        when (this) {
            is Right<*> -> rightFunc()
            is Left<*> -> leftFunc()
        }
    }
}

data class Right<T> (val value: T): Either() {
    fun show(): T = this.value
    fun <A>map(f: (T) -> A): Right<A> = Right(f(this.value))
    fun <A>flatMap(f: (T) -> Right<A>) = f(this.value)
}

data class Left<T> (val value: T): Either() {
    fun show(): T = this.value
    fun <A>map(f: (T) -> A): Left<A> = Left(f(this.value))
    fun <A>flatMap(f: (T) -> Left<A>): Left<A> = f(this.value)
}
