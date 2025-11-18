package com.example.mad_23012531032_practical5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mad_23012531032_practical5.screen.LoginUI
import com.example.mad_23012531032_practical5.screen.RegisterUI

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable(route = "login"){ LoginUI(navController) }
        composable(route = "register"){ RegisterUI(navController) }
    }
}