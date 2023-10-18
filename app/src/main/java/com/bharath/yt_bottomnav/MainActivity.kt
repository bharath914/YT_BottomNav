package com.bharath.yt_bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bharath.yt_bottomnav.presentation.MyNavHost
import com.bharath.yt_bottomnav.presentation.Screens
import com.bharath.yt_bottomnav.ui.theme.YT_BottomNavTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YT_BottomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNav(navController = navController)
                        }
                    ) {
                        it
                        MyNavHost(
                            navHostController = navController,
                            startDestination = Screens.Home.route
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNav(
    navController: NavHostController,
) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val list = listOf(
        Screens.Home,
        Screens.Favorite,
        Screens.Mail,
        Screens.Profile,

        )
    NavigationBar(

    ) {
        list.forEachIndexed { index, screens ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screens.route)
                    selectedIndex = index
                },
                icon = {
                    Icon(imageVector = screens.imageVector, contentDescription = "")
                },
                label = {
                    Text(text = screens.label)

                },
                alwaysShowLabel = false

            )
        }
    }
}

