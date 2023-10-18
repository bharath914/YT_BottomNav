package com.bharath.yt_bottomnav.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavHost(
    navHostController: NavHostController,
    startDestination: String,
) {

    NavHost(navController = navHostController,
        startDestination = startDestination,
        builder = {
            composable(NavCons.home) {
                HomeScreen()
            }
            composable(NavCons.favorites) {
                FavoriteScreen()
            }
            composable(NavCons.mail) {
                MailScreen()
            }
            composable(NavCons.profile) {
                ProfileScreen()
            }
        })

}

sealed class Screens(val route: String, val imageVector: ImageVector, val label: String) {

    object Home : Screens(
        route = NavCons.home,
        label = "Home",
        imageVector = Icons.Rounded.Home
    )

    object Favorite : Screens(
        route = NavCons.favorites,
        label = "Favorite",
        imageVector = Icons.Rounded.FavoriteBorder
    )

    object Mail : Screens(
        route = NavCons.mail,
        label = "Mail",
        imageVector = Icons.Rounded.MailOutline
    )

    object Profile : Screens(
        route = NavCons.profile,
        label = "Profile",
        imageVector = Icons.Rounded.Person
    )
}

object NavCons {
    const val home = "Home"
    const val profile = "Profile"
    const val favorites = "Favorites"
    const val mail = "mail"
}
