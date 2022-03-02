package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

var list_alphabets= listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
/**
@Composable
fun Flow_row(alphalist:List<String>){
    val selectedIndices = remember{mutableStateListOf<Int>()}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.Center,
          crossAxisSpacing = 16.dp,
           mainAxisSpacing = 16.dp,
          mainAxisSize = SizeMode.Expand
       ){
            list_alphabets.forEachIndexed { index,  alphalist ->
                Box(
                    modifier = Modifier.clickable (onClick = {selectedIndices.add(index) }), children = {
                        Text(
                       text = if (selectedIndices.contains(index)) "✓ ${list_alphabets}" else null,
                     overflow = TextOverflow.Ellipsis,
                       modifier = Modifier.drawBackground(
                         color = colors[index % colors.size], shape = RoundedCornerShape(15.dp)
                       ) +
                           Modifier.padding(8.dp)
                    })
                )
            }

    }


}

**/