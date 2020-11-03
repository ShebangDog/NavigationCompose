package dog.shebang.navigation.list

import androidx.compose.runtime.Composable
import dog.shebang.navigation.Greeting
import dog.shebang.navigation.Screen

@Composable
fun ListScreen() {
    Greeting(content = Screen.List.route)
}