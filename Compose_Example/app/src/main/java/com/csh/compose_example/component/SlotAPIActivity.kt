package com.csh.compose_example.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.csh.compose_example.component.ui.theme.Compose_ExampleTheme

class SlotAPIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}

//@Composable
//private fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable RowScope.() -> Unit
//    //RowScope.로 수신자를 바꾸는 이유는 람다 내에서 RowScope 안에 있는 것처럼 쓸 수 있다.
//){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable{
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content() //함수 호출하는 부분에서 책임지겠다라는 의미.
//    }
//}

@Composable
private fun CheckBoxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit, //가능한 한 밖으로 위임해라
    content: @Composable RowScope.() -> Unit
    //RowScope.로 수신자를 바꾸는 이유는 람다 내에서 RowScope 안에 있는 것처럼 쓸 수 있다.
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable{
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content() //함수 호출하는 부분에서 책임지겠다라는 의미.
    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
//        CheckBoxWithSlot(checked = checked1){
//            Text(
//                "체크박스 1",
//                modifier = Modifier.align(Alignment.CenterVertically) //위에서 RowScope로 수신자를 지정해줬기 때문이다.
//            )
//        }
//        CheckBoxWithSlot(checked = checked2){
//            Text(
//                "체크박스 2"
//            )
//        }
        CheckBoxWithSlot(
            checked = checked1,
            onCheckedChanged = {checked1 = !checked1} //위임을 여기서 결정
        ) {
            Text(
                "체크박스1"
            )
        }
        CheckBoxWithSlot(
            checked = checked2,
            onCheckedChanged = {checked2 = !checked2}
        ) {
            Text(
                "체크박스2"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    Compose_ExampleTheme {
        SlotEx()
    }
}