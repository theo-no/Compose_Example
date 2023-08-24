package com.csh.compose_example.uses.screen

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
){
    LazyColumn {
        item {
            Button(onClick = {
                navController.navigate(Screen.ConstraintLayout.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "ConstraintLayout"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.ConstraintSet.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "ConstraintSet"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.ConstraintChainAndBarrier.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "ConstraintChainAndBarrier"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.ConstraintLayoutUses.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "ConstraintLayoutUses"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.Canvas.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "Canvas"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.Dialog.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "Dialog"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.CustomDialog.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "CustomDialog"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.DropDownMenu.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "DropDownMenu"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.SnackBar.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "SnackBar"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.BottomAppBar.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "BottomAppBar"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.State.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "State"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.Animation.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "Animation"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.Animation2.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "Animation2"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.SideEffect.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "SideEffect"
                )
            }
        }
        item {
            Button(onClick = {
                navController.navigate(Screen.ToDo.route)
            }, modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    "ToDo"
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview(){
    HomeScreen(rememberNavController())
}