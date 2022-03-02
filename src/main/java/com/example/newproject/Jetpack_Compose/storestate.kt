package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newproject.health_carekit.Title

@Composable
fun Buttonn(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Gray)
    ){
        State_change()
        Spacer(modifier = Modifier.height(10.dp))
        Mode_state_change()

    }

}

@Composable
fun State_change(){
    var states by remember{ mutableStateOf(0)}
    Title(" the current state for this function is considered as zero")
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ){
        Button(
            modifier = Modifier.padding(16.dp)
                .weight(1f)

            ,
            colors = ButtonDefaults.buttonColors(Color.Red),
            elevation = ButtonDefaults.elevation(8.dp),
            onClick = {
                      states++
            }, content = {
            Text("Increment the value ", modifier = Modifier.padding(8.dp))
        })

        Button(
            modifier = Modifier.padding(16.dp)
                .weight(1f),
            colors = ButtonDefaults.buttonColors(Color.Red),
            elevation = ButtonDefaults.elevation(8.dp),
            onClick = {
                         states = 0
        },
        content = {
            Text ("Reset the value ", modifier = Modifier.padding(8.dp))
        })



    }
    Text("state is ${states}", modifier = Modifier.padding(4.dp))



}


//se of a data class called [CounterState] to hold the state that we want our composables to observe.
data class mode_state(val states :Int = 0)

@Composable

fun Mode_state_change(){
    var mode_states by remember{ mutableStateOf(mode_state())}
    Title(" here the state is changing acc to the counter Increment ")
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            modifier = Modifier.padding(16.dp)
                .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Red),
            elevation = ButtonDefaults.elevation(8.dp),
            onClick = {
                     mode_states = mode_states.copy(states = mode_states.states +1)
            }, content = {
                Text("incrementing  the value", modifier = Modifier.padding(8.dp))
            }
        )

        Button(modifier =Modifier.padding(16.dp)
            .weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Red),
        elevation = ButtonDefaults.elevation(8.dp),
            onClick = {
                mode_states = mode_states.copy(states = 0)
            }
        ,content = {
            Text("resetting the value",  modifier = Modifier.padding(8.dp))
            }
        )
    }
    Text(text = "value is : ${mode_states.states}",modifier = Modifier.padding(4.dp))
}

@Preview
@Composable
fun Previewstates(){
    Buttonn()
}