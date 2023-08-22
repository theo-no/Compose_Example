 package com.csh.compose_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    color = MaterialTheme.colorScheme.surface
                ) {
                    //위임 받아서 여기 코드가 돌아감
                    CustomText(name = "android")
                }
            }
        }
    }
}

 //////////////////////////Text //////////////////////////////////////////
@Composable
fun CustomText(name: String) {
     Surface(
         modifier = Modifier.padding(10.dp),
         shadowElevation = 10.dp,
//         tonalElevation = 10.dp,
         border = BorderStroke(
             width = 2.dp,
             color = Color.Gray
         ),
         shape = CircleShape,
         color = MaterialTheme.colorScheme.error
     ) {
         Text(
//             color = Color.Black,
             text = "Hello $name!",
             fontSize = 30.sp,
             fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
             letterSpacing = 2.sp,
//        maxLines = 2,
//             textDecoration = TextDecoration.Underline,
             textAlign = TextAlign.Center,
             modifier = Modifier.width(300.dp)
         )
     }

}

@Preview(showBackground = true)
@Composable
fun CustomTextPreview() {
    Compose_ExampleTheme {
        CustomText("Android")
    }
}

 /////////////////////////////Button /////////////////////////////////////
 @Composable
 fun CustomButton(onButtonClicked: () -> Unit){

    Button(
        onClick = onButtonClicked,
//        enabled = false,
        border = BorderStroke(1.dp, Color.Black), //테두리
        shape = RoundedCornerShape(10.dp), //모양 설정(값 하나만 주면 모서리에 모두 10dp만큼 둥글게 설정)
        contentPadding = PaddingValues(10.dp), //padding 값 설정(값 하나만 주면 전체에 같은 값 패딩 적용)
        modifier = Modifier
            .wrapContentSize()
//            .width(150.dp)
//            .height(200.dp)
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors( //버튼의 color는 colors 이용해서 바꿔라
            containerColor = Color.Gray,
            contentColor = Color.DarkGray
        )
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = "exampleButton" //버튼에 대한 설명
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing) //제공하는 icon 사이 여백 값(dp로 임의로 줘도 됨)
        )
        Text(
            "Button",
//            modifier = Modifier.clickable {  },
            modifier = Modifier.offset(x = 5.dp)
        )
    }
 }


// @Preview(showBackground = true)
 @Composable
 fun CustomButtonPreview() {
     Compose_ExampleTheme {
         CustomButton(onButtonClicked = {}) //위임 받아서 여기 코드가 돌아감
     }
 }
