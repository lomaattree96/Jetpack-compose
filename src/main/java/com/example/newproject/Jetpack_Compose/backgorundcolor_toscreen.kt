package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newproject.health_carekit.ResoluteTheme


@Composable
fun Styletext(text:String , style: TextStyle? = null, maxLines: Int? = null){

    /**  text = text,
        maxLines = 2,
        style = TextStyle(
            color = ResoluteTheme.COLOR_WHITE_BG,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify**/
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
            style = style ?: TextStyle.Default,
            overflow = TextOverflow.Ellipsis,
            maxLines = maxLines ?: Int.MAX_VALUE,

        )
    Divider( modifier = Modifier.fillMaxWidth(),
        color = Color.Magenta,
        startIndent = 10.dp,
        thickness = 3.dp

    )


}

@Composable
fun Exp1(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .background(ResoluteTheme.COLOR_WHITE_BG)
            .verticalScroll(scrollState)
    ) {
        Styletext("this is a normal text")
        Styletext("size is slight bigger than previous text",
            style = TextStyle(
                fontSize = 30.sp
            )
        )
        Styletext("text style is Italic",
        style = TextStyle(
            fontStyle = FontStyle.Italic
        ))

        Styletext("color of text is changed",
        style = TextStyle(color = Color.Yellow)
        )

        Styletext("using the font family",
        style = TextStyle(
            fontFamily = FontFamily.Cursive
        ))

        Styletext("changing text with the text decoration",
        style = TextStyle(
            textDecoration = TextDecoration.LineThrough))

        Styletext("changing text with the text decoration",
            style = TextStyle(
                textDecoration = TextDecoration.Underline))

        Styletext("this line adds ellipsis to the line if the text is longer than one line , keeping maxline =1",
        maxLines = 1,
        style = TextStyle(
            fontStyle = FontStyle.Italic
        ))

        Styletext("implementing text with shadow",
        style = TextStyle(
            shadow = Shadow(
                color = Color.Green,
                blurRadius = 12f,
                offset = Offset(12f, 12f))
        ))

        Styletext("depicting text with alignments",
        style = TextStyle(
            textAlign = TextAlign.Right))

        Styletext("This text will demonstrate how to justify your line break spreads and takes the entire width of the container" ,
            style = TextStyle(
                textAlign = TextAlign.Justify
            )
                )
        Styletext("This text will demonstrate how to add indentation to your text. In this example, indentation was only indentation to the rest of the lines if you'd like",
        style = TextStyle(
            textAlign = TextAlign.Justify,
            textIndent = TextIndent(firstLine = 60.sp,restLine = 50.sp)
        ))

        Styletext("line height and background color is shown here",
        style = TextStyle(
            lineHeight = 10.sp,
            background =  ResoluteTheme.COLOR_GREY5_DARK,
            color = ResoluteTheme.COLOR_BLUE ))
      Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp,
                        color = ResoluteTheme.COLOR_GREY3_DARK,
                    )

                )
                {
                    append("this string has span style ")
                }
                addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
                addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
                addStyle(style = SpanStyle(color = Color.Blue), start = 22, end = 27)

            }
        )



    }

}


@Preview
@Composable
fun PreviewExp1(){
    Exp1()
}