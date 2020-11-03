package dog.shebang.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.VectorAsset

sealed class Screen(val route: String, val vectorAsset: VectorAsset) {
    object Home : Screen("home", Icons.Filled.Home)
    object List : Screen("list", Icons.Filled.List)
}

val items = listOf(Screen.Home, Screen.List)