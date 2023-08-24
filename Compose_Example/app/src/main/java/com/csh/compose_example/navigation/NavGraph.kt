package com.csh.compose_example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.screen.BottomAppBarScreen
import com.csh.compose_example.uses.screen.CanvasScreen
import com.csh.compose_example.uses.screen.ConstraintChainAndBarrierScreen
import com.csh.compose_example.uses.screen.ConstraintLayoutScreen
import com.csh.compose_example.uses.screen.ConstraintLayoutUsesScreen
import com.csh.compose_example.uses.screen.ConstraintSetScreen
import com.csh.compose_example.uses.screen.CustomDialogScreen
import com.csh.compose_example.uses.screen.DialogScreen
import com.csh.compose_example.uses.screen.DropDownMenuScreen
import com.csh.compose_example.uses.screen.HomeScreen
import com.csh.compose_example.uses.screen.SnackBarScreen

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
        composable(
            route = Screen.ConstraintLayoutUses.route
        ) {
            ConstraintLayoutUsesScreen(navController)
        }
        composable(
            route = Screen.Canvas.route
        ) {
            CanvasScreen(navController)
        }
        composable(
            route = Screen.Dialog.route
        ) {
            DialogScreen(navController)
        }
        composable(
            route = Screen.DropDownMenu.route
        ) {
            DropDownMenuScreen(navController)
        }
        composable(
            route = Screen.SnackBar.route
        ) {
            SnackBarScreen(navController)
        }
        composable(
            route = Screen.BottomAppBar.route
        ) {
            BottomAppBarScreen(navController)
        }
    }
} // End of setUpNavGraph
