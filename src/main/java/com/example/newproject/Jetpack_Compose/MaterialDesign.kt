package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newproject.R
import com.example.newproject.health_carekit.Title

@OptIn(ExperimentalMaterialApi::class)

// MATERIALCARD
@Composable
fun MaterialCard(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
        ListItem(text =  {
            Text(text = "TITLE")
        },
        secondaryText = {
            Text(text = "SUBTITLE")
        },
        icon = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Image(painter =painterResource(id = R.drawable.img_heatlhkit_backgroud),
                contentDescription = null)
            }
        })

    }
}

//CHECKBOX

@Composable
fun Material_CheckBox() {
    var checked by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(checked = checked,
                onCheckedChange = {
                    checked = !checked
                })
            Text("checkbox is displayed using material checkbox", modifier = Modifier.padding(16.dp))

        }
    }
}


//TRI -- CHECKBOX
@Composable
fun Tri_checkbox(){
    val toggleState = listOf(ToggleableState.On,ToggleableState.Indeterminate,ToggleableState.Off)

    var count by remember{ mutableStateOf(0)}

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            TriStateCheckbox(
                state = toggleState[count % 3],
                onClick = {
                    count++
                }
            )
        }
    }
    Text("the tricheckbox box is made", modifier = Modifier.padding(16.dp))
}


// RADIOBUTTON
@Composable
fun Radio_Button() {
    var selected by remember { mutableStateOf("android") }
    val radiobuttons = listOf("android", "ios", "windows")
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {

        val onSelectChange = { text: String ->
            selected = text
        }
        Column {
            radiobuttons.forEach { text ->
                Row(modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
                    .selectable(
                        selected = (text == selected),
                        onClick = { onSelectChange(text) }
                    ))
                {
                    RadioButton(
                        selected = (text == selected),
                        onClick = { onSelectChange(text) }
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(16.dp),
                    )
                }


            }
        }
    }
}

@Composable
fun MaterialLinearProgress(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
    ){
        Row(){
LinearProgressIndicator()
        }
    }
}

@Composable
fun MaterialDeterminateLinearProgress(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            LinearProgressIndicator(progress = 0.7f)
        }

    }
}

@Composable
fun MaterialCircularProgress() {
    Card(shape = RoundedCornerShape(16.dp),
    modifier = Modifier.fillMaxWidth()
        .padding(4.dp))
    {
        Row(
            verticalAlignment =  Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
        }

    }
}

@Composable
fun InderterminateCircularIndicator(){
    Card(
       shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            CircularProgressIndicator(
                progress = 0.5f,
                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
            )

        }

    }

}

@Composable
fun MaterialSnackbar(){
    Card(
        shape = RoundedCornerShape(16.dp),
    modifier = Modifier.fillMaxWidth()
        .padding(4.dp)){
       Snackbar(
           content = {
                     Text(text = "here is the snackbar !!!")

           },
           action = {
               Text(text = "Ok",
                   style = TextStyle(MaterialTheme.colors.primary)
               )
           }
           )

    }
}


//remember{} is a helper composable that calculates the value passed to it only during the first composition
@Composable
fun MaterialContinuous_Slider(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier =Modifier.fillMaxWidth()
            .padding(4.dp)
    ){
        var slider_value by remember{ mutableStateOf(0f)}

            Slider(
                value = slider_value,
                onValueChange = {
                    newValue -> slider_value = newValue
                }
            )

    }
}

@Composable
fun MaterialDiscrete_Slider(){
    var slider__value by  remember { mutableStateOf(0f) }
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
    ){
        Slider(
            value = slider__value,
            valueRange = 0f..15f,
            onValueChange = {
                slider__value = it
            })
        Text(text = "Slider value is %.5f".format(slider__value),
        modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun Material_switch(){
    var switch_state by remember{ mutableStateOf(false)}
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp)
            .background(color = Color.Green)
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(4.dp)

        ){
            Switch(
                checked  =  switch_state,
                onCheckedChange =  {
                  switch_state = !switch_state
                }
            )
            Text(text = "switch case is implemented", modifier =Modifier.padding(4.dp))

        }


    }
}

// Column with clickable modifier wraps the child composable and enables it to react to a
// click through the onClick callback similar to the onClick listener that we are accustomed
// to on Android. In order to show a ripple effect, we set indication of Modifier.clickable
// with a RippleIndication.

@Composable
fun Material_Ripple(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {})
                .background(
                    color = Color.Cyan,
                    shape = RoundedCornerShape(4.dp)
                )
        ){
            Text(text = "  the ripple effect is shown with the help of clickable function in column",
            style= TextStyle(textAlign =  TextAlign.Justify,
            fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            ))

        }
    }
}


@Composable
fun All_materialdesign(){
    LazyColumn(){
        item{
            Title("This is a simple Material card")
            MaterialCard()}
        item{
            Title("This is a checkbox that represents two state")
            Material_CheckBox()}

        item{
            Title("This is a checkbox that represents three state")
            Tri_checkbox()}
        item{
            Title("This is a radio button group")
            Radio_Button()}
        item{
            Title("This is a loading progress indicator")
            MaterialLinearProgress()}
        item{
            Title("This is a determinate progress indicator")
            MaterialDeterminateLinearProgress()}
        item{
            Title("This is a loading circular progress indicator")
            MaterialCircularProgress()}
        item{
            Title("This is a determinate circular progress indicator")
            InderterminateCircularIndicator()
        }
        item{
            Title("This is a material Snackbar")
            MaterialSnackbar()}
        item{
            Title("This is a non-discrete slider")
            MaterialContinuous_Slider()}

        item{
            Title("This is a discrete slider")
            MaterialDiscrete_Slider()}
        item {
            Title("This is a switch")
            Material_switch()}
        item{
            Title("This is how you add a ripple effect to a view")
            Material_Ripple()}




    }
}
@Preview
@Composable
fun  PreviewMaterialTheme(){
    All_materialdesign()
}