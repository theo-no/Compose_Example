package com.csh.compose_example.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.csh.compose_example.component.ui.theme.Compose_ExampleTheme

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
    Row(
       verticalAlignment = Alignment.CenterVertically
    ){
        
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    Compose_ExampleTheme {
        CheckBoxEx()
    }
}