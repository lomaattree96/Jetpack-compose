package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Simple_button(){
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        elevation = ButtonDefaults.elevation(6.dp)
    ){
        Text("this is the simple button implementation")
    }
}

@Composable
fun Buttonwith_Border(){
    Button(onClick = {},
        elevation = ButtonDefaults.elevation(6.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Blue))
    ){
        Text("this is simple button with borders")
    }

}

@Composable
fun Rounded_cornerButton(){
    Button(onClick =  {},
    elevation = ButtonDefaults.elevation(6.dp),
    modifier = Modifier.fillMaxWidth()
        .padding(8.dp),
        shape = RoundedCornerShape(16.dp)){
        Text("this is rounded corner button", modifier = Modifier.padding(16.dp))


    }
}

@Composable
fun Outlined_Button(){
    OutlinedButton(
        onClick = {},
        elevation = ButtonDefaults.elevation(6.dp),
        modifier = Modifier.padding(16.dp)
    ){
        Text("outlined button is displayed")
    }
}

@Composable
fun Text_button(){
    TextButton(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        elevation = ButtonDefaults.elevation(6.dp)
    ){
        Text("displaying text_button")

    }
}

@Composable
fun Displaying_Button(){
    LazyColumn(){
       item{ Simple_button()
       Spacer(modifier = Modifier.height(8.dp))}
       item{ Buttonwith_Border()
           Spacer(modifier = Modifier.height(8.dp))}

        item{
            Rounded_cornerButton()
            Spacer(modifier = Modifier.height(8.dp))}
        item{
            Outlined_Button()
            Spacer(modifier = Modifier.height(8.dp))}
        item{
            Text_button()
            Spacer(modifier = Modifier.height(8.dp))}
       }
    }

@Preview
@Composable
fun PreviewDisplaying_Button() {
    Displaying_Button()
}