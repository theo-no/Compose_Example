package com.csh.compose_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csh.compose_example.ui.theme.Compose_ExampleTheme

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomBox()
                }
            }
        }
    }
}

@Composable
fun CustomBox() {
//    Box(
//        modifier = Modifier.size(200.dp)
//    ){
//        Text(
//            text = "Hello World!",
//            modifier = Modifier.align(Alignment.TopStart)
//        )
//        Text(
//            text = "Jetpack Compose!",
//            modifier = Modifier.align(Alignment.Center)
//        )
//        Text(
//            text = "Android!",
//            modifier = Modifier.align(Alignment.BottomEnd)
//        )
//    }
//    Box(
//        modifier = Modifier.size(200.dp)
//    ){
//        Box(
//            modifier = Modifier.size(150.dp)
//                .background(Color.Cyan)
//                .align(Alignment.Center)
//        ){
//        }
//        Box(
//            modifier = Modifier.size(150.dp)
//                .background(Color.Yellow)
//                .align(Alignment.BottomEnd)
//        ){
//        }
//    }
    Box(){
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.Center)
        ){
        }
        Box(
            modifier = Modifier.size(150.dp)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd)
        ){
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPrevivew() {
    Compose_ExampleTheme {
        CustomBox()
    }
}