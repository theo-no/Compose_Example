package com.csh.compose_example.component

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.csh.compose_example.component.ui.theme.Compose_ExampleTheme

private const val TAG = "차선호"
class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckBoxEx()
                }
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
//    Row(
//       verticalAlignment = Alignment.CenterVertically
//    ){
//        var checked = false
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
//        Text("체크박스가 생겼습니까?")
//    }
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        val checked = remember{ mutableStateOf(false)}
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                Log.d(TAG, "CheckBoxEx clicked... ${checked.value}")
//                checked.value = !checked.value
//            }
//        )
//        Text("체크박스가 생겼습니까?")
//    }
//    Row(
//       verticalAlignment = Alignment.CenterVertically
//    ){
//        var checked by remember {
//            mutableStateOf(false)
//        }
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
//        Text("체크박스가 생겼습니까?")
//    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        //위임을 사용하지 않고 getter, setter를 선언해서 사용
        val (getChecked, setChecked) = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = getChecked,
//            onCheckedChange = {
//                setChecked(!checked)
//            }
            onCheckedChange = setChecked //onCheckedChange 값 자체가 토글된 값)\
        )
        Text(
            "체크박스가 생겼습니까?",
            modifier = Modifier.clickable {
                setChecked(!getChecked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    Compose_ExampleTheme {
        CheckBoxEx()
    }
}