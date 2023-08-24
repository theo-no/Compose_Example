package com.csh.compose_example.uses.screen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.ui.theme.Compose_ExampleTheme

@Composable
fun Animation2Screen(
    navController: NavController
){
    var isDarkMode by remember { mutableStateOf(false) }

    // 단계 1: `updateTransition` 수행하고 `targetState`를 `isDarkMode`로
    // 설정합니다. `transition`으로 리턴을 받습니다.
    val transition = updateTransition(
        targetState = isDarkMode,
        label = "다크 모드 트랜지션"
    )

    // 단계 2: `transition`에 대해 `animateColor`를 호출해 `backgroundColor`를 받습니다.
    // 배경색상을 만듭시다. false일 때 하얀 배경, true일 때 검은 배경.
    val backgroundColor by transition.animateColor(
        label = "다크 모드 배경색상 애니메이션"
    ) { state ->
        when(state){
            true -> Color.Black
            else -> Color.White
        }
    }

    // 단계 3: 글자 색상을 만듭시다.
    val color by transition.animateColor(
        label = "다크 모드 글자 색상 애니메이션"
    ) {state ->
        when(state){
            true -> Color.White
            else -> Color.Black
        }
    }

    // 단계 4: `animateFloat`를 호출해서 알파 값을 만듭시다.
    val alpha by transition.animateFloat(
        label = "다크 모드 알파 애니메이션"
    ) {state ->
        when(state){
            true -> 1f
            else -> 0.7f
        }
    }

    // 단계 5: 컬럼에 배경과 알파를 적용합시다.
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        // 단계 6: 라디오 버튼에 글자 색을 적용합시다.
        RadioButtonWithText(text = "일반 모드", color = color, selected = !isDarkMode) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크 모드", color = color, selected = isDarkMode) {
            isDarkMode = true
        }

        // 단계 7: Crossfade를 이용해 `isDarkMode`가 참일 경우
        // `Row`로 항목을 표현하고 거짓일 경우 `Column`으로 표현해봅시다.
//        Row {
//            Box(modifier = Modifier
//                .background(Color.Red)
//                .size(20.dp)) {
//                Text("1")
//            }
//            Box(modifier = Modifier
//                .background(Color.Magenta)
//                .size(20.dp)) {
//                Text("2")
//            }
//            Box(modifier = Modifier
//                .background(Color.Blue)
//                .size(20.dp)) {
//                Text("3")
//            }
//        }
        Crossfade( //그냥 if문으로 해도 되지만 얘를 쓰면 전환될 때 애니메이션이 적용된다.
            targetState = isDarkMode,
            label = "다크 모드 배치 변경"
        ) {state ->
            when(state){
                true -> {
                    Surface(
                        modifier = Modifier.background(Color.White)
                    ) {
                        Text(
                            "나랏말\nHello World!"
                        )
                    }
                }
                else -> {
                    Row {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)) {
                            Text("1")
                        }
                        Box(modifier = Modifier
                            .background(Color.Magenta)
                            .size(20.dp)) {
                            Text("2")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)) {
                            Text("3")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
    Compose_ExampleTheme {
        RadioButtonWithText(
            text = "라디오 버튼",
            color = Color.Red,
            selected = true,
            onClick = {}
        )
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun Animation2Preview(){
    Animation2Screen(rememberNavController())
}
