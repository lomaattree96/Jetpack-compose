package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newproject.health_carekit.Title

val listitems = listOf("apps","movies","books","games")

@Composable
fun Bottomnavigationwithlabel() {
    var selected by remember { mutableStateOf(0) }

    BottomNavigation(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)

    ) {
        listitems.forEachIndexed { index, label ->

            BottomNavigationItem(
                icon = {
                       Icon(Icons.Default.Favorite,contentDescription = null)

                },
                label ={
                       Text(label)
                },
                selected = selected == index,
                onClick = {
                    selected == index
                }
            )
        }

    }
}

@Composable
fun Bottomnavigation__label(){
    var selected by remember{ mutableStateOf(0)}
    BottomNavigation(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
    ){
        listitems.forEachIndexed { index, label ->
            BottomNavigationItem(
                icon = {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                },
                label = {
                    Text(label)
                },
                selected = selected == index,
                onClick = {
                    selected == index

                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
fun Bottom_navigation_display(){
    val scrollState = rememberScrollState()
    Column(
       verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =Modifier.fillMaxWidth()
            .padding(8.dp)
            .verticalScroll(scrollState)

    ) {
        Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor  = Color.Green
    ) {
        Title("this is the bottomnavigation which always show labels")
        Bottomnavigationwithlabel()
    }

        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor  = Color.Cyan
        ) {
            Title("this is the bottomnavigation which show labels for selected items")
            Bottomnavigation__label()
        }

    }
}

@Preview
@Composable
fun  PreviewBottom_navigation_display(){
    Bottom_navigation_display()
}