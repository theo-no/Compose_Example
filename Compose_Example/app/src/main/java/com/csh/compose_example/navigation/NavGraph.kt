package com.csh.compose_example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.csh.compose_example.uses.UsesActivity
import com.csh.compose_example.uses.UsesScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Uses.route
    ) {
        composable(
            route = Screen.Uses.route
        ) {
            UsesScreen(navController = navController)
        }
    }
} // End of setUpNavGraph
