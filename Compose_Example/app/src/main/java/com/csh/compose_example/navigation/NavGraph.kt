package com.csh.compose_example.navigation

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.screen.ConstraintChainAndBarrierScreen
import com.csh.compose_example.uses.screen.ConstraintLayoutScreen
import com.csh.compose_example.uses.screen.ConstraintSetScreen
import com.csh.compose_example.uses.screen.HomeScreen

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
        composable(
            route = Screen.ConstraintSet.route
        ) {
            ConstraintSetScreen(navController)
        }
        composable(
            route = Screen.ConstraintChainAndBarrier.route
        ) {
            ConstraintChainAndBarrierScreen(navController)
        }
    }
} // End of setUpNavGraph
