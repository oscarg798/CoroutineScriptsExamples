import kotlinx.coroutines.*
import java.util.*

data class User(val username: String, val password: String, val name: String)
data class FavoriteMovies(val movies: List<String>)
data class SuggestedMovies(val movies: List<String>)
data class UserInfo(val user: User, val favorites:FavoriteMovies, val suggested: SuggestedMovies)
suspend fun login(username: String, password: String): User {
    print("Login ${Thread.currentThread()} ${Date()}\n")
    delay(1000)
    return User("username", "password", "Joan")
}
suspend fun getFavoritesMovies(user: User): FavoriteMovies {
    print("Favorites ${Thread.currentThread()} ${Date()}\n")
    delay(2000)
    return FavoriteMovies(listOf("Titanic", "Avengers"))
}
suspend fun getSuggestedMovies(user: User): SuggestedMovies {
    print("Suggested ${Thread.currentThread()} ${Date()}\n")
    delay(1000)
    return SuggestedMovies(listOf("Planes", "Cars"))
}
val dispathcher = newFixedThreadPoolContext(1, "Joan")
CoroutineScope(dispathcher).launch {
    val userInfo = withContext(Dispatchers.IO) {
        val user = login("username", "password")
        val favorites = getFavoritesMovies(user)
        val suggested = getSuggestedMovies(user)
        UserInfo(user, favorites, suggested)
    }
    print(userInfo)
}