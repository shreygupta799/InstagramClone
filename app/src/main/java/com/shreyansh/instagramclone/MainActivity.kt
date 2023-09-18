package com.shreyansh.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
   // @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyNavigation()
        }
    }
}


@Composable
fun MyNavigation() {//hello
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Splash.route
    ) {
        composable(Splash.route) {
            splashScreen(navController)
        }
        composable(SignUp.route) {
            signUp()
        }


    }
}

