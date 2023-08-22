package com.csh.compose_example.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csh.compose_example.ui.theme.Compose_ExampleTheme

class ConstraintsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Outer()
                }
            }
        }
    }
}

@Composable
fun Outer() {
    Column(
        modifier = Modifier.width(150.dp)
    ){
        Inner(
            modifier = Modifier
//                .widthIn(min = 100.dp)
                .widthIn(200.dp) //위에서 Cloumn의 modifier 때문에 안됨
                .height(160.dp) //widthIn과 heightIn이 제약 조건이 많아서 원하는대로 되기 힘들다.
        )
        Inner(
            modifier = Modifier
//                .widthIn(min = 100.dp)
                .widthIn(200.dp)
                .height(100.dp) //widthIn과 heightIn이 제약 조건이 많아서 원하는대로 되기 힘들다.
        )
    }
}

@Composable
private fun Inner(modifier: Modifier = Modifier){ //기본값으로 그냥 Modifier를 할 수 있고, compose 내에선 companion object로 Modifier가 구현되어 있다.
    BoxWithConstraints(modifier) {
        if(maxHeight > 150.dp){
            Text(
                "여기 꽤 길군요!",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text(
            "maxW : $maxWidth, maxH : $maxHeight // minW : $minWidth, minH : $minHeight"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Compose_ExampleTheme {
        Outer()
    }
}