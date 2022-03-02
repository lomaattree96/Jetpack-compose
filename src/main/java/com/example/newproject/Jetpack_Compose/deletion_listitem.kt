package com.example.newproject.Jetpack_Compose

import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newproject.R


data class persons(
    @DrawableRes val imageUrl : Int? = R.drawable.antibiotic_medicine___powder,
    val name : String = "",
    val catName : String = "",
    var isSelected : Boolean = false
)


val personlists = listOf<persons>(
    persons(name = "Neosprin", catName = "Topical Anti"),
    persons(name = "ABC", catName = "Topical Anti"),
    persons(name = "Neosprin", catName = "Topical AntiX"),
    persons(name = "ABC", catName = "Topical AntiX")
)


@ExperimentalAnimationApi
@Composable
fun ListAnimation(personlists: List<persons>){

    val delete_personlists = remember{ mutableStateListOf<persons>()}

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        // AnimatedVisibility is a pre-defined composable that automatically animates the
        // appearace and disappearance of it's content
        repeat(100) {
            itemsIndexed(items = personlists
            ) { index, persons ->

                AnimatedVisibility(
                    visible = !delete_personlists.contains<Any>(persons),
                    enter = expandVertically(),
                    exit = shrinkVertically(
                        animationSpec = tween(
                            durationMillis = 1000
                        )
                    )
                ) {
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = Color.DarkGray,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                persons.name,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            IconButton(onClick = {
                                delete_personlists.add(persons)

                            }
                            )
                            {
                                Icon(Icons.Default.Delete, contentDescription = null)
                            }

                        }

                    }

                }
            }

        }
    }
}


@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewListAnimation(){
    ListAnimation(personlists)
}