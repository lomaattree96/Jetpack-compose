package com.example.newproject.Jetpack_Compose


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import com.example.newproject.R
import kotlinx.coroutines.delay

@Composable
fun Stack() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.img_heatlhkit_backgroud),
                contentDescription = null
            )

            Surface {
                Text(
                    text = "Title",
                    style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            content =
            {
                val transition = rememberInfiniteTransition()

                //rememberInfiniteTransition is used to create a transition that uses infitine child animations
                val rotation by transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 390f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = 2900,
                            delayMillis = 96,
                            easing = FastOutLinearInEasing
                        ),
                    )

                )
                Canvas(modifier = Modifier.fillMaxSize()) {

                    rotate(rotation) {
                        drawRect(color = Color(255, 138, 128))
                        drawOval(
                            color = Color.Yellow,
                            topLeft = Offset(x = 12F, y = 30F)
                        )
                    }

                }


                // Create a value that is altered by the transition based on the configuration. We use
                //            // the animated float value the returns and updates a float from the initial value to
                //            // target value and repeats it (as its called on the infititeTransition).

            })

        Spacer(modifier = Modifier.height(40.dp))
        val currentcolor = remember { mutableStateOf(Color.Blue) }
        val transitions = updateTransition(currentcolor)


      /**  val colors by transitions.animateColor(
            transitionSpec = { TweenSpec<Color>(durationMillis = 100,
            easing = FastOutLinearInEasing) },
        ) { state ->
            when (state) {
                Color.Red -> Color.Green
                Color.Green -> Color.Blue
                Color.Blue -> Color.Red
                else -> Color.Red
            }

        } **/

        Column(
            modifier = Modifier.fillMaxWidth()
               // .background(color = colors)
        ) {


        }


    }
}

@Preview
@Composable

fun PreviewStack() {
    Stack()
}