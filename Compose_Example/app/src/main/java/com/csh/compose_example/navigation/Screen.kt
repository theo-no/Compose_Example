package com.csh.compose_example.navigation

/**
 * selead class란 다른 클래스가 상속 받지 못하도록 제한하는 클래스
 */
sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object ConstraintLayout : Screen(route = "constraint_layout_screen")
    object ConstraintSet : Screen(route = "constraint_set_screen")
    object ConstraintChainAndBarrier : Screen(route = "constraint_chain_and_barrier_screen")
    object ConstraintLayoutUses : Screen(route = "constraint_layout_uses_screen")
    object Canvas : Screen(route = "canvas_screen")
    object Dialog : Screen(route = "dialog_screen")
}