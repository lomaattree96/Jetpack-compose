package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newproject.health_carekit.ResoluteTheme

@Composable
fun Samplepadding(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(ResoluteTheme.COLOR_GREY_BG)
    ){
        Text(
            text = "try it with the sample texting giving padding on all sides",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = ResoluteTheme.COLOR_BLUE,
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Medium
            )

        )

    }
}

@Composable
fun CustomizedPadding(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(ResoluteTheme.COLOR_WHITE_BG)
            .padding(start = 50.dp, end = 80.dp,bottom = 40.dp, top =80.dp)
    ){

        Text(
            text = "try this example with customised padding ",
           // modfier = Modifier.padding(start = 35.dp, end = 10.dp,bottom = 4.dp, top =10.dp),
            style= TextStyle(
                color = ResoluteTheme.COLOR_BLUE,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace

            )
        )


    }
}

@Composable
fun Offsets(){
    Surface(
        color = ResoluteTheme.COLOR_PINK_DARK,
        modifier = Modifier.offset(x = 25.dp, y = 4.dp)
    ){
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up modifying the size of the layout. Using offset instead ensures that the size of the layout retains its size"
        ,style= TextStyle(
                color = ResoluteTheme.COLOR_BLUE,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace

            )
        )


    }
}

@Composable
fun Aspect(){
    Column(
        modifier = Modifier.aspectRatio(30/55f)
            .background(color = Color.White)
    )
        {
            Text(
                text = "This text is using an aspect ratio of 16/9f"
                ,style= TextStyle(
                    color = ResoluteTheme.COLOR_BLUE,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace

                )
            )


    }
}

@Composable
fun Showfun(){
    LazyColumn {
        item{ Aspect() }
        item{ Samplepadding()}
        item{ CustomizedPadding()}
        item{ Offsets()}
    }

}

@Preview
@Composable
fun PreviewShowfun(){
    Showfun()
}