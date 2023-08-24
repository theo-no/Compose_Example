package com.csh.compose_example.uses.screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

private const val TAG = "SideEffectScreen"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideEffectScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    navController: NavController
){
    val snackbarHostState = remember { SnackbarHostState() }

    // 단계 1: `LaunchedEffect`을 이용해서 스낵바를 이용해 봅시다.
    // 파라미터에는 `scaffoldState.snackbarHostState`를 전달합시다.
    // "헬로 컴포즈"라고 출력합시다.
    // `LaunchedEffect`는 `CouroutineScope`를 만들기 때문에 스코프를 별도로
    // 만들 필요는 없습니다.
    LaunchedEffect(
        snackbarHostState
    ){
        snackbarHostState.showSnackbar(
            "헬로 컴포즈."
        )
    }

    // 단계 2: `DisposableEffect`를 호출하고 파리미터로 `lifecycleOwner`를
    // 전달합니다.

    // `LifecycleEventObserver`를 상속받고 두 상태에 대해 로그를 남깁니다.
    // `Lifecycle.Event.ON_START`, `Lifecycle.Event.ON_STOP`

    // 블록 내에서 `lifecycleOwner.lifecycle.addObserver`로 옵저버를 추가하고
    // onDispose에서 옵저버를 제거합니다.
    DisposableEffect(
        lifecycleOwner //이렇게 하면 lifecycleOwner가 바꼈을 때 reset이 됨
    ){
        //할당
        val observer = LifecycleEventObserver{ source, event ->
            // SAM : Single Abstract Method 인 경우 편하게 { }로 표현
            when(event){
                Lifecycle.Event.ON_START -> {
                    Log.d(TAG, "ON_START...")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d(TAG, "ON_STOP...")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    Log.d(TAG, "ON_PAUSE...")
                }
                Lifecycle.Event.ON_RESUME -> {
                    Log.d(TAG, "ON_RESUME...")
                }
                else -> {
                    Log.d(TAG, "ETC...")
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose { //해제
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun SideEffectPreview(){
    SideEffectScreen(LocalLifecycleOwner.current, rememberNavController())
}