package com.example.newproject.Jetpack_Compose

import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Processs() {
    Column(

        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.width(500.dp)
                .aspectRatio(16 / 9f),
            backgroundColor = colors.primaryVariant,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                var name by remember{ mutableStateOf("")}

                var textvalue by rememberSaveable { mutableStateOf("12345678") }
                TextField(
                    value = TextFieldValue(textvalue),
                    onValueChange = {
                        newTextValue ->
                        textvalue = newTextValue.text},
                    modifier = Modifier.padding(16.dp),
                    textStyle = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,

                    ),
                    keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = CardVisual()
                )

                Text(text = "Loma",
                modifier = Modifier.padding(16.dp),
                style  = TextStyle(textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
                )

            }
        }
    }
}

class CardVisual: VisualTransformation{
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
       AnnotatedString(text.text.replace("...". toRegex(), "$0")),
        CardOffsetMap
        )
    }
}


val CardOffsetMap = object : OffsetMapping {
    override fun originalToTransformed(offset: Int) = offset + (offset / 4)
    override fun transformedToOriginal(offset: Int) = offset - (offset / 4)
}
@Preview
@Composable
 fun PreviewPrcossed(){
     Processs()
 }




