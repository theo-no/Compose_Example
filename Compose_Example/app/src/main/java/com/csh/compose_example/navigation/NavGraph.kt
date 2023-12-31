package com.csh.compose_example.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.screen.Animation2Screen
import com.csh.compose_example.uses.screen.AnimationScreen
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
import com.csh.compose_example.uses.screen.SideEffectScreen
import com.csh.compose_example.uses.screen.SnackBarScreen
import com.csh.compose_example.uses.screen.StateScreen
import com.csh.compose_example.uses.screen.ToDoScreen

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
        composable(
            route = Screen.State.route
        ) {
            StateScreen(navController)
        }
        composable(
            route = Screen.Animation.route
        ) {
            AnimationScreen(navController)
        }
        composable(
            route = Screen.Animation2.route
        ) {
            Animation2Screen(navController)
        }
        composable(
            route = Screen.SideEffect.route
        ) {
            SideEffectScreen(LocalLifecycleOwner.current, navController)
        }
        composable(
            route = Screen.ToDo.route
        ) {
            ToDoScreen(navController)
        }
    }
} // End of setUpNavGraph
