package com.csh.compose_example.uses.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateScreen(
    navController: NavController
){
    //remeberSabeable은 cache하기 때문에 너무 많이 쓰면 메모리 낭비,,,
    var pyeong by rememberSaveable{
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }



    // 단계 1: remember를 이용해 상태를 만들고 평 값을 입력하면
    // 제곱미터가 출력되도록 화면을 구성하시오.
    // 평을 제곱미터로 바꾸기 위해서는 3.306을 곱하면 됩니다.
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//                if(it.isBlank()){
//                    pyeong = ""
//                    squaremeter = ""
//                    return@OutlinedTextField
//                }
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField // Float으로 바꿀 수 없으면 null 리턴 -> null이 들어오면 강제 종료
//                pyeong = it
//                squaremeter = (numericValue*3.306).toString()
//            }, label = {
//                Text("평")
//            }
//        )
//        OutlinedTextField(
//            value = squaremeter,
//            onValueChange = {},
//            label = {
//                Text("제곱미터")
//            }
//        )
//    }

    // 단계 2: `Composable` 함수를 만들고 `Column`의 항목들을 옮기세요.
    // 단 상태는 옮기지 말아야 합니다.

    // 파라미터는 아래와 같이 구성합니다.
    // `pyeong: String, squareMeter: String, onPyeongChange: (String) -> Unit`
    PyeongToSquareMeterStateless( //이렇게 상태에 관한 것만 모아놓고 아래에 ui 부분만
        pyeong = pyeong,
        squareMeter = squaremeter
    ){
        if(it.isBlank()){
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless // Float으로 바꿀 수 없으면 null 리턴 -> null이 들어오면 강제 종료
        pyeong = it
        squaremeter = (numericValue*3.306).toString()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
){
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun StatePreview(){
    StateScreen(rememberNavController())
}