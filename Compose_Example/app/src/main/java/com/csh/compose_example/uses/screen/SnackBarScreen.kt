package com.csh.compose_example.uses.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackBarScreen(
    navController: NavController
){
    var counter by remember { mutableStateOf(0) }

    // 단계 3: couroutineScope를 만듭시다.
    // `rememberCoroutineScope`를 사용합니다.

    // 단계 1: scaffoldState를 만들고 Scaffold에 설정합시다.
    // scaffoldState를 만들기 위해 `rememberScaffoldState`를 사용합니다.
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope() //snackBar가 suspen fun이기 때문에 coroutineScope를 만든 것이다.

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {

//        LaunchedEffect(
//            snackbarHostState
//        ){
//            coroutineScope.launch {
//                snackbarHostState.showSnackbar(
//                    "카운터가 ${counter}가 되었습니다!",
//                    "닫기",
//                    false,
//                    SnackbarDuration.Short
//                )
//            }
//        }

        // 단계 2: "더하기" 버튼을 만들어 봅시다.
        // action에서 counter를 증가시킵시다.
        Surface(
            modifier = Modifier.padding(it)
        ) {
            Button(onClick = {
                counter++
                coroutineScope.launch {
                    val result = snackbarHostState.showSnackbar(
                        "카운터가 ${counter}가 되었습니다!",
                        "닫기",
                        false,
                        SnackbarDuration.Short
                    )
                    when(result){
                        SnackbarResult.Dismissed -> {}
                        else -> {}
                    }
                }
            }) {
                Text(
                    "더하기"
                )
            }

            // 단계 4: 버튼의 onClick에서 `coroutineScope.launch`를
            // 사용합니다.

            // 단계 5: 스낵바를 사용하기 위해 `scaffoldState.snackbarHostState.showSnackbar`
            // 사용합니다.

            // `message`에 카운터를 출력합시다.
            // `actionLabel`를 "닫기"로 지정합시다.
            // `duration`에 `SnackbarDuration.Short`를 사용합니다.

        }

    }
}



@Preview(showBackground = true)
@Composable
fun SnackBarPreview(){
    SnackBarScreen(rememberNavController())
}