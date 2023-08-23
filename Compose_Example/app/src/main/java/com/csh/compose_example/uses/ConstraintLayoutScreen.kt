package com.csh.compose_example.uses

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ConstraintLayoutScreen(
    navController: NavController
){
    Column{
        Text(
            "constraintLayout"
        )
    }
}
