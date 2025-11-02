package com.csanchez.aplicacionesmovilesactividad03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csanchez.aplicacionesmovilesactividad03.ui.theme.AplicacionesMovilesActividad03Theme
import com.csanchez.aplicacionesmovilesactividad03.ui.theme.screen.DashboardScreen
import com.csanchez.aplicacionesmovilesactividad03.ui.theme.screen.LoginScreen
import com.csanchez.aplicacionesmovilesactividad03.ui.theme.screen.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionesMovilesActividad03Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(navController = navController, innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyApp(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(navController = navController, startDestination = "welcome", modifier = Modifier.padding(innerPadding)) {
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("dashboard") {
            DashboardScreen()
        }
    }
}
