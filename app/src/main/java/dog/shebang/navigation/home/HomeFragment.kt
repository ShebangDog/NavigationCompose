package dog.shebang.navigation.home

import androidx.compose.runtime.Composable
import dog.shebang.navigation.Greeting
import dog.shebang.navigation.Screen

@Composable
fun HomeScreen() {
    Greeting(content = Screen.Home.route)
}