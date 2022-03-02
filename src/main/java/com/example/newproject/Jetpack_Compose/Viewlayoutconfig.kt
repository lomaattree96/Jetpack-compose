package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable

fun RowequalWeights(){
    Row(modifier = Modifier.fillMaxWidth()){
        Button(
            modifier = Modifier.weight(1f)
                .padding(4.dp) ,
            onClick = {}
        ){
            Text("button_1",
            style = TextStyle()
            )

        }

    }
}
