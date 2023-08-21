 package com.csh.compose_example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csh.compose_example.ui.theme.Compose_ExampleTheme

 private const val TAG = "차선호"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomButton(onButtonClicked = {
                        Log.d(TAG, "onClicked...")
                        Toast.makeText(this, "onClick....", Toast.LENGTH_SHORT).show()
                    }) //위임 받아서 여기 코드가 돌아감
                }
            }
        }
    }
}


@Composable
fun CustomText(name: String) {
    Text(
        color = Color.Red,
        text = "Hello $name!\nHello $name!\nHello $name!",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(300.dp)
    )
}

//@Preview(showBackground = true)
@Composable
fun CustomTextPreview() {
    Compose_ExampleTheme {
        CustomText("Android")
    }
}

 @Composable
 fun CustomButton(onButtonClicked: () -> Unit){
    Button(
        onClick = onButtonClicked,
//        enabled = false,
        border = BorderStroke(1.dp, Color.Black), //테두리
        shape = RoundedCornerShape(10.dp), //모양 설정(값 하나만 주면 모서리에 모두 10dp만큼 둥글게 설정)
        contentPadding = PaddingValues(10.dp), //padding 값 설정(값 하나만 주면 전체에 같은 값 패딩 적용)
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = "exampleButton" //버튼에 대한 설명
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing) //제공하는 icon 사이 여백 값(dp로 임의로 줘도 됨)
        )
        Text("Button")
    }
 }


 @Preview(showBackground = true)
 @Composable
 fun CustomButtonPreview() {
     Compose_ExampleTheme {
         CustomButton(onButtonClicked = {}) //위임 받아서 여기 코드가 돌아감
     }
 }
