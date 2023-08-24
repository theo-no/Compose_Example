package com.csh.compose_example.uses.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun DropDownMenuScreen(
    navController: NavController
){
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        var expandDropDownMenu by remember { mutableStateOf(false) }
        var counter by remember { mutableStateOf(0) }

        Column {
            Button(onClick = { expandDropDownMenu = true }) {
                Text("드롭다운 메뉴 열기")
            }
            Text("카운터: $counter")
        }

        // 단계 1: `DropdownMenu`를 만들고 `expanded`를 `expandDropDownMenu`로
        // 등록합시다.
        // `onDismissRequest`에 대해서는 `expandDropDownMenu`를 `false`로 바꿉니다.

        // 단계 2: 두개의 `DropdownMenuItem`을 등록합시다. `onClick`을 구현하고
        // 내용물은 `Text`로 채워봅시다.
        DropdownMenu(
            expanded = expandDropDownMenu,
            onDismissRequest = {
                expandDropDownMenu = false
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        "증가"
                    )
                },
                onClick = {
                    counter++
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        "감소"
                    )
                },
                onClick = {
                    counter--
                }
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DropDownMenuPreview(){
    DropDownMenuScreen(rememberNavController())
}