package com.example.newproject.Jetpack_Compose

import android.app.AlertDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newproject.health_carekit.ResoluteTheme

//remember{} is a helper composable that calculates the value passed to it only during the first composition.
// It then returns the same value for every subsequent composition.
//  mutableStateOf as an observable value where updates to this variable will redraw all the composable functions that access it.
//  Any composable that reads its value will be recomposed any time the value changes.
@Composable

fun ClickableText() {

    var showbar by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = { showbar = true }),
        content = {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                backgroundColor = ResoluteTheme.COLOR_WHITE_BG

            ) {
                Text(
                    text = "Click on the text",
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }
        }
    )

    val popup = { showbar = false }
//A lambda that toggles the showPopup value to off.
// pass it to the onDismiss equivalent callback of the AlertDialog.
    if (showbar) {
       AlertDialog(onDismissRequest = popup,
       text = {
           Text("successfully built clickabke button")
       },
           confirmButton = {
               Button(
                   onClick = popup
               )
               {
                   Text(text = "OK")
               }
           }
       )

    }
}

@Preview
@Composable
fun PreviewClickableText()
{
    ClickableText()
}