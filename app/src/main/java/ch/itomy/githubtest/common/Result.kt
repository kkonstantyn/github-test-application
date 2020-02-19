package ch.itomy.githubtest.common

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Progress : Result<Nothing>()

    inline fun <R> map(transform: (value: T) -> R): Result<R> = when (this) {
        is Success -> Success(transform(this.data))
        is Progress -> this
        is Error -> this
    }
}