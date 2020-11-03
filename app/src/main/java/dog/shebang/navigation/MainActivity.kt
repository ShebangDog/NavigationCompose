package dog.shebang.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.*
import dog.shebang.navigation.home.HomeScreen
import dog.shebang.navigation.list.ListScreen
import dog.shebang.navigation.ui.NavigationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                NavigationPreview()
            }
        }
    }
}

@Composable
fun NavigationPreview() {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.vectorAsset) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.popBackStack(navController.graph.startDestination, false)

                        navController.navigate(screen.route)
                    }
                )
            }
        }
    }) {

        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.List.route) { ListScreen() }
        }
    }
}

@Composable
fun Greeting(content: String) {
    Text(text = content)
}