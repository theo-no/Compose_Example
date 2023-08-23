package com.csh.compose_example.component

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csh.compose_example.component.ui.theme.Compose_ExampleTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFieldEx()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEx() {
    var name by remember{
        mutableStateOf("Tom")
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(
                    "이름"
                )
            },
        )
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(
                    "이름"
                )
            },
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            "Hello $name"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    Compose_ExampleTheme {
        TextFieldEx()
    }
}