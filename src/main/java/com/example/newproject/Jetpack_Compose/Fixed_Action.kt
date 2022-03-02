package com.example.newproject.Jetpack_Compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Floating_Actionbutton(){
    val fab_shape = RoundedCornerShape(16.dp)
    Scaffold(
        topBar = { TopAppBar(title = {Text("this is the topapp bar")})},
        bottomBar = { BottomAppBar(cutoutShape = fab_shape){}},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = fab_shape,
                backgroundColor = MaterialTheme.colors.secondary
            ){
               IconButton(onClick = {}){
                   Icon(Icons.Default.Favorite, contentDescription = null)
               }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End,
        content = {
            padding ->
            val scrollState = rememberScrollState()
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
                .scrollable(scrollState, orientation = Orientation.Vertical)){
               repeat(100){
                   Card(
                      backgroundColor = colors.background,
                       shape = RoundedCornerShape(8.dp),
                       modifier = Modifier.padding(8.dp)
                   ){
                       Spacer(modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp))

                   }
               }
            }
        }

    )
}

@Preview
@Composable
fun PreviewFloating_Actionbutton(){
    Floating_Actionbutton()
}