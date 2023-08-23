package com.csh.compose_example.uses.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CustomDialogScreen(
    navController: NavController
){
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            // 단계 1: 디스미스 처리를 합니다.
            openDialog = false
        }) {
            Surface {
                // 단계 2: 컬럼을 만들고 설명을 적어봅시다.
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        "버튼을 클릭해주세요.",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "+1을 누르면 카운터가 증가해요.\n" +
                                "-1을 누르면 값이 감소합니다.",
                        fontSize = 16.sp
                    )
                    Row(
                        modifier = Modifier.align(Alignment.End)
                    ){
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text(
                                "+1"
                            )
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text(
                                "-1"
                            )
                        }
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text(
                                "취소"
                            )
                        }
                    }
                }

                // 단계 3: 컬럼 안에 로우를 만들어 수평 방향으로 버튼을 배열합니다.
                // 버튼은 +1, -1, 취소로 구성하겠습니다.

                // +1은 counter를 증가시키고 -1은 감소, 취소는 다이얼로그를 닫습니다.
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomDialogPreview(){
    CustomDialogScreen(rememberNavController())
}