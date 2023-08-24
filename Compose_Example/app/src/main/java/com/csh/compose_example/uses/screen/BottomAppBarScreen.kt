package com.csh.compose_example.uses.screen

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarScreen(
    navController: NavController
){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope() //snackBar가 suspen fun이기 때문에 coroutineScope를 만든 것이다.
    var counter by remember{
        mutableStateOf(0)
    }

    // 단계 1: `Scaffold`에 `scaffoldState`를 설정합니다.
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomAppBar{
                Text(
                    "hello"
                )
                Button(
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                "안녕하세요"
                            )
                        }
                    }
                ) {
                    Text(
                        "인사"
                    )
                }
                Button(
                    onClick = {
                        counter++
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                "카운터가 ${counter}가 되었습니다."
                            )
                        }
                    }
                ) {
                    Text(
                        "더하기"
                    )
                }
                Button(
                    onClick = {
                        counter--
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                "카운터가 ${counter}가 되었습니다."
                            )
                        }
                    }
                ) {
                    Text(
                        "빼기"
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ){
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Text(
                    "카운터는 ${counter}회입니다.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

    // 단계 2: `bottomBar` 파라미터에 `BottomAppBar`를 넣읍시다.
    // 내용은 텍스트와 버튼을 넣어 봅시다. 버튼에는 `snackBar`를
    // 연동해 메시지를 출력합니다.

    // 단계 3: 더하기와 빼기 버튼을 추가로 만들고 `MutableState`
    // 만듭시다. `Scaffold`의 `content`에 `Text`를 넣어 카운터를 출력하게
    // 합시다.
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview(){
    BottomAppBarScreen(rememberNavController())
}