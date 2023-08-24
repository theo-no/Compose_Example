package com.csh.compose_example.uses.screen

import android.widget.CheckBox
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.csh.compose_example.uses.ui.theme.Compose_ExampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(
    navController: NavController
){
    val (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }

    // 단계 4: `onSubmit`, `onEdit`, `onToggle`, `onDelete`를
    // 만들어 `ToDo`에 연결합니다.
    val onSubmit: (String) -> Unit = {text ->
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(
            key,
            text
        ))
        setText("")
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(done = checked) //새로운 객체를 복사하면서 done 프로퍼티 설정
    }

    val onDelete: (Int) -> Unit = {key ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(i)
    }
    
    val onEdit: (Int, String) -> Unit = {key, text ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = text)
    }

    Scaffold { paddingValue ->
        Surface(
            modifier = Modifier.padding(paddingValue)
        ) {
            Column {
                ToDoInput(
                    text,
                    setText,
                    onSubmit
                )
                // 단계 3: `LazyColumn`으로 `toDoList`를 표시합시다.
                // `key`를 `toDoData`의 `key`를 사용합니다.
                LazyColumn{
                    items(toDoList, key = {it.key}){toDoData ->
                        ToDo(
                            toDoData = toDoData,
                            onToggle = onToggle,
                            onDelete = onDelete,
                            onEdit = onEdit
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ToDoPreview(){
    ToDoScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    Compose_ExampleTheme {
        ToDoInput("테스트", {}, {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){

        // 단계 2: `Crossfade`를 통해 `isEditing`을 따라 다른
        // UI를 보여줍니다. `OutlinedTextField`와 `Button을
        // 넣어봅시다.

        Crossfade(
            targetState = isEditing,
            label = "수정이냐 아니냐"
        ) {
            when(it){
                false -> {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ){
                        Text(
                            text = toDoData.text + toDoData.key,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = {checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )
                        Button(
                            onClick = {
                                isEditing = true
                            }
                        ){
                            Text(
                                "수정"
                            )
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(
                            onClick = {
                                onDelete(toDoData.key)
                            }
                        ){
                            Text(
                                "삭제"
                            )
                        }
                    }
                }
                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        var (newText, setNewText) = remember {
                            mutableStateOf(toDoData.text)
                        }

                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(
                            onClick = {
                                onEdit(toDoData.key, newText)
                                isEditing = false
                            }
                        ) {
                            Text(
                                "완료"
                            )
                        }
                    }
                }
                else -> {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoUnitPreview() {
    Compose_ExampleTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

//immutable -> 이렇게 만든 이유는 mutableStateList가 데이터 자체가 추가되거나 삭제되거나 변경됐을 때 갱신되기 때문
data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)
