package com.csh.compose_example.uses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.navigation.NavGraph
import com.csh.compose_example.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
){
    Column {
        Text(
            "HomeScreen"
        )
        Spacer(modifier = Modifier.run { size(8.dp) })
        Button(onClick = {
            navController.navigate(Screen.ConstraintLayout.route)
        }) {
            Text(
                "ConstraintLayout"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    HomeScreen(rememberNavController())
}