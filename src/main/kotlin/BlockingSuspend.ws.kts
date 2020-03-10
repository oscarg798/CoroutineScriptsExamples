import kotlinx.coroutines.*
import java.util.*

data class User(val username: String, val password: String, val name: String)
data class FavoriteMovies(val movies: List<String>)
data class SuggestedMovies(val movies: List<String>)
data class UserInfo(val user: User, val favorites: FavoriteMovies, val suggested: SuggestedMovies)

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

CoroutineScope(Dispatchers.Unconfined).launch {
    print("I started\n")
    Thread.sleep(3000)
    print("I Have finished\n")
}

for(i in 0 until 10){
    print("Hello")
}