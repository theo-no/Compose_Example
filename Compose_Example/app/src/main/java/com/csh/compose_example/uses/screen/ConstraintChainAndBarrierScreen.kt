package com.csh.compose_example.uses.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.navigation.Screen
import kotlinx.coroutines.flow.channelFlow

@Composable
fun ConstraintChainAndBarrierScreen(
    navController: NavController
){
//    val constraintSet = ConstraintSet{
//        // 단계 1: createRefFor로 레드, 마젠타, 그린, 옐로 박스를 위한 레퍼런스를 만듭니다.
//        // 파라미터 id로 레퍼런스의 이름을 적어 줍시다. eg. redBox
//        val redBox = createRefFor("redBox")
//        val yellowBox = createRefFor("yellowBox")
//        val magentaBox = createRefFor("magentaBox")
//
//        // 단계 2: `constrain`을 열고 만들었던 레퍼런스를 인자로 넣읍시다.
//        // 레드, 마젠타, 그린, 옐로 박스 레퍼런스에 대해 `constrain`을 적읍시다.
//        // 후행 람다의 내용은 기존에 `constrainAs`에 적어둔 것을 참고합니다.
//        constrain(redBox){
//        }
//        constrain(yellowBox){
//        }
//        constrain(magentaBox){
//        }
//
//        createVerticalChain(redBox, yellowBox, magentaBox)
//    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
//                .layoutId("redBox")
                .constrainAs(redBox){
                    top.linkTo(parent.top, margin = 16.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
//                .layoutId("yellowBox")
                .constrainAs(yellowBox){
                    top.linkTo(parent.top, margin = 32.dp)

                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
//                .layoutId("magentaBox")
                .constrainAs(magentaBox){
                    top.linkTo(parent.top, margin = 8.dp)

                }
        )

        // 단계 1: `createVerticalChain`, `createHorizontalChain`를
        // 이용해서 세 박스의 레퍼런스를 연결해봅시다.
//        createVerticalChain(redBox, yellowBox, magentaBox)
//        createHorizontalChain(redBox, yellowBox, magentaBox)

        // 단계 2: `createHorizontalChain`를 사용하고 `chainStyle`
        // 키워드 파라미터를 추가합시다.
        // `ChainStyle.Packed`,`ChainStyle.Spread`,
        // `ChainStyle.SpreadInside`등을 지정해봅시다.
        createHorizontalChain(redBox, yellowBox, magentaBox,
            chainStyle = ChainStyle.SpreadInside)

        // 단계 3: 세 박스의 top을 parent.top에 연결하고 각각
        // 다른 마진을 줍시다.

        // 단계 4: `createBottomBarrier`로 배리어를 만듭시다.
        // 이는 모든 박스들의 하단을 포함하는 배리어입니다.
        val bottomBarrier = createBottomBarrier(redBox, yellowBox, magentaBox)

        // 단계 5: `Text` 하나 만들고 top을 박스 베리어로 지정합니다.
        Text(
            "세 박스 모두 밑에 생겨라~~ 세 박스 모두 밑에 생겨라~~ 세 박스 모두 밑에 생겨라~~",
            modifier = Modifier.constrainAs(text){
                top.linkTo(bottomBarrier)
            }
        )

        // 단계 6: 체이닝 방향이나 베리어 방향을 바꾸어 보며 다양하게 테스트해봅시다.
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintChainAndBarrierPreview(){
    ConstraintChainAndBarrierScreen(rememberNavController())
}