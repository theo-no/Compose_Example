package com.csh.compose_example.uses

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.navigation.NavGraph
import com.csh.compose_example.uses.ui.theme.Compose_ExampleTheme


class UsesActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme

                Scaffold(
                    topBar = {
                        // 스텝 1: `topBar`를 `TopAppBar`로 채워 봅시다.
                        TopAppBar(
                            title = {
                                Text(
                                    "Compose 활용"
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    onBackPressed()
                                }) {
                                    Image(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "뒤로가기"
                                    )
                                }
                            }
                        )
                    }) {
                        Surface(
                            modifier = Modifier.padding(it)
                        ) {
                            NavGraph()
                        }
                }
            }
        }
    }
}

