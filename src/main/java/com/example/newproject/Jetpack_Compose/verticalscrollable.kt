package com.example.newproject.Jetpack_Compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.newproject.R


data class person(
    @DrawableRes val imageUrl : Int? = R.drawable.antibiotic_medicine___powder,
    val name : String = "",
    val catName : String = "",
    var isSelected : Boolean = false
)


val personlist = listOf<person>(
    person(name = "Neosprin", catName = "Topical Anti"),
    person(name = "ABC", catName = "Topical Anti"),
    person(name = "Neosprin", catName = "Topical AntiX"),
    person(name = "ABC", catName = "Topical AntiX")
)


@Composable
fun lazy_column(personlist: List<person>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()

    )
    {
        repeat(50) {

            items(items = personlist, itemContent = { person ->
                val index = personlist.indexOf(person)

                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = colors.onSurface,
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp)
                    )
                    //HORIZONTAL SCROLL
                    //,content = {
                    //val context =  LocalContext.current
                    //val resources  = context.resources
                    //val displayMetrices = resources.displayMetrices
                    //val screenWidth = displayMetrices.widthPixels/displayMetrices.density
                    {

//Column(modifier = Modifier.width(screenWidth.dp - (spacing * 2 )))
                       repeat(20) {
                           Text(
                               text = "${person.name}",
                               style = TextStyle(
                                   color = Color.Blue,
                                   fontSize = 20.sp,
                                   fontWeight = FontWeight.SemiBold,
                                   textAlign = TextAlign.Justify

                               )
                           )
                       }

                    }

                }
            })


        }

    }
}


@Composable
fun WithoutLazyColumn(personlist: List<person>) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
            .verticalScroll(scrollState)
            //.horizontalScroll(state = scrollState)
         //   .scrollable(scrollState, orientation = Orientation.Horizontal)
    ){
      for((index, person) in personlist.withIndex()){
          Row(
              modifier = Modifier.fillMaxWidth()
          ){
              Card(
                  shape = RoundedCornerShape(16.dp),
                  backgroundColor = colors.background,
                  modifier = Modifier.fillMaxWidth()
                      .padding(8.dp),
                  elevation = 4.dp,

              ){
                  Text("${person.name}",
                  style = TextStyle(
                      color = Color.Green,
                      textAlign = TextAlign.Justify,
                      fontSize = 22.sp,
                      fontWeight = FontWeight.Medium
                  ))
              }

          }
      }

    }

}


@Composable
fun withorwithoutLC() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        WithoutLazyColumn(personlist)
        Spacer(modifier = Modifier.height(8.dp))
        lazy_column(personlist)

    }
}

@Preview
@Composable
fun PreviewwithorwithoutLC(){
    withorwithoutLC()
}