package com.csh.compose_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csh.compose_example.ui.theme.Compose_ExampleTheme

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RowEx()
                }
            }
        }
    }
}

@Composable
fun RowEx() {
//    Row(
//        modifier = Modifier.size(200.dp)
//    ){
//        Text(
//            text = "첫 번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//        Text(
//            text = "두 번째",
//            modifier = Modifier.align(Alignment.CenterVertically)
//        )
//        Text(
//            text = "세 번째",
//            modifier = Modifier.align(Alignment.Bottom)
//        )
//    }
    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.size(200.dp)
    ){
        Text(
            text = "첫 번째",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(3f)
                .background(Color.Magenta)
        )
        Text(
            text = "두 번째",
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(3f)
                .background(Color.Yellow)
        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가",
            modifier = Modifier.weight(2f)
                .background(Color.Cyan)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_ExampleTheme {
        RowEx()
    }
}