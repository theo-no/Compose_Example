package com.csh.compose_example.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.csh.compose_example.R
import com.csh.compose_example.ui.theme.Compose_ExampleTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ImageEx()
                    CoilEx()
                }
            }
        }
    }
}

@Composable
fun ImageEx() {
    Column{
        Image(
            painter = painterResource(id = R.drawable.image_iu),
            contentDescription = "아이유" 
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "설정"
        )
    }
}

@Composable
fun CoilEx(){
    // https://cdn.pixabay.com/photo/2023/05/05/21/00/cute-7973191_1280.jpg
    // rememberImagePainter안에 들어가면 coil 패키지가 있고 gradle에서 의존성 설정을 해놨기 때문에 가능
//    val painter = rememberImagePainter(data = "https://cdn.pixabay.com/photo/2023/05/05/21/00/cute-7973191_1280.jpg")
//    Image(
//        painter = painter,
//        contentDescription = "귀여운 이미지"
//    )
    //coil 문서에선 Async 권고
    AsyncImage(
        model = "https://cdn.pixabay.com/photo/2023/05/05/21/00/cute-7973191_1280.jpg",
        contentDescription = "귀여운 이미지"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Compose_ExampleTheme {
//        ImageEx()
        CoilEx()
    }
}