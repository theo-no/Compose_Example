package com.csh.compose_example.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.csh.compose_example.component.ui.theme.Compose_ExampleTheme

class ProfileCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column{
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }
    companion object{
        val cardData = CardData(
            imageUrl = "https://cdn.pixabay.com/photo/2023/05/05/21/00/cute-7973191_1280.jpg",
            imageDescription = "귀여운 이미지",
            author = "차선호",
            description = "귀여운 이미지는 차선호와 꼭 닮았습니다."
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            AsyncImage(
                model = cardData.imageUrl,
                contentDescription = cardData.imageDescription,
                modifier = Modifier.size(32.dp)
//                    .clip(CircleShape) //둥글게
                    .clip(RoundedCornerShape(10.dp)), //모서리에 둥글게
                contentScale = ContentScale.Crop, //centerCrop
                placeholder = ColorPainter(placeHolderColor)
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    Compose_ExampleTheme {
        CardEx(ProfileCardActivity.cardData)
    }
}

data class CardData(
    val imageUrl: String,
    val imageDescription: String,
    val author: String,
    val description: String
)