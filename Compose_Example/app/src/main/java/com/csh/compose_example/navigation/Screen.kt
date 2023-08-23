package com.csh.compose_example.navigation

/**
 * selead class란 다른 클래스가 상속 받지 못하도록 제한하는 클래스
 */
sealed class Screen(val route: String) {
    object Uses : Screen(route = "uses_screen")
}