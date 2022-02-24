package com.example.newproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.newproject.Jetpack_Compose.ClickableText
import com.example.newproject.Jetpack_Compose.DrawerComponent
import com.example.newproject.Jetpack_Compose.Exp1
import com.example.newproject.Jetpack_Compose.Showfun
import com.example.newproject.health_carekit.*
import com.example.newproject.health_carekit.FirstAid
import com.example.newproject.ui.theme.NewProjectTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //InstagramSlicedProgressBar(steps = 3, currentStep = 2, paused = false){}
                    DrawerComponent()
              //  Exp1()
                // Showfun()
                   // ClickableText()
                   // Healthkitradiance()
                   // Report()
                   // FirstAid(onClick = {})
                   // healthkit(onClick = {})
                   // val item = SubModuleCardData()
                  //  SubModuleListScreen(listOf(item))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewProjectTheme {
        Greeting("Android")
    }
}