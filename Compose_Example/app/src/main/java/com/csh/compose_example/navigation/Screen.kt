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
    object CustomDialog : Screen(route = "custom_dialog_screen")
    object DropDownMenu : Screen(route = "drop_down_menu_screen")
    object SnackBar : Screen(route = "snack_bar_screen")
    object BottomAppBar : Screen(route = "bottom_app_bar_screen")
    object State : Screen(route = "state_screen")
    object Animation : Screen(route = "animation_screen")
    object Animation2 : Screen(route = "animation2_screen")
    object SideEffect : Screen(route = "side_effect_screen")
}