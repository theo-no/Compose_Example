package com.csh.compose_example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.ConstraintLayoutScreen
import com.csh.compose_example.uses.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.ConstraintLayout.route
        ) {
            ConstraintLayoutScreen(navController)
        }
    }
} // End of setUpNavGraph
