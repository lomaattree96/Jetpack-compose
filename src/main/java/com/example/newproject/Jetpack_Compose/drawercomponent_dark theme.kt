package com.example.newproject.Jetpack_Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun Frame_layout(){
    val enabledDarkMode = remember{ mutableStateOf(false)}
    Custom_Theme(enabledDarkMode)
    {
        DrawerComponent(enabledDarkMode)
    }
}

@Composable
fun Custom_Theme(enabledDarkMode: MutableState<Boolean>,children : @Composable() ()->Unit){
    var theme_color = lightColors(
        primary = Color(0xff4c78db),
    primaryVariant = Color(0xff6200ee),
        onPrimary = Color(0xffb00020),
        secondary = Color(0xff3700b3),
        secondaryVariant = Color(0xff000000),
        onSecondary = Color(0xff0000ff),
        background = Color(0xffffffff),
        onBackground = Color(0xff000000),
        surface =Color(0xffffffff),
        onSurface = Color(0xff000000),
        error = Color(0xff03dac5),
        onError = Color(0xffb00020)
    )

    val darkColors = darkColors()
    val colors = if(enabledDarkMode.value) darkColors
    else lightColors()


    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            textIndent = TextIndent(firstLine = 16.sp)

        )
    )

    MaterialTheme(colors = colors,content = children, typography = typography )


}

@Composable
fun DrawerComponent(enabledDarkMode: MutableState<Boolean>){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentState = remember{ mutableStateOf(DrawerAppScreen.scr3)}
    val coroutineScope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled =  drawerState.isOpen,
        drawerContent = {
            DrawerAppComponent(
                currentState = currentState,
                closeDrawer = {coroutineScope.launch { drawerState.close() }}
            )
        },
        content = {
            Component(
                currentState = currentState.value,
                enabledDarkMode = enabledDarkMode,

                opendrawer = {
                    coroutineScope.launch { drawerState.open() }
                }
            )
        }
    )
}

enum class DrawerAppScreen {
    scr1,
    scr2,
    scr3,


}
@Composable
fun DrawerAppComponent( currentState: MutableState<DrawerAppScreen >,
                        closeDrawer :() -> Unit,
//enabledDarkMode: MutableState<Boolean>
) {
    /**  Column(
    modifier = Modifier.fillMaxSize()
    ){
    Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ){
    for(index in DrawerAppScreen.values().indices) {
    val screen = getScreen(index)
    Column(
    modifier = Modifier.clickable(
    onClick = {
    currentState.value = screen
    closeDrawer()
    }
    ),
    content = {
    Surface(modifier =Modifier.fillMaxWidth(),
    color = if(currentState.value == screen){
    MaterialTheme.colors.secondary
    } else {
    MaterialTheme.colors.surface
    }


    ){
    Text(text = screen.name, modifier = Modifier.padding(16.dp))
    }


    }
    )
    }

    }

    } **/

    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(modifier = Modifier.clickable(onClick = {
            currentState.value = DrawerAppScreen.scr1
            closeDrawer()
        }),
            content = {
                Text(text = "screen one is dispalyed", modifier = Modifier.padding(16.dp))
            }
        )


        Column(modifier = Modifier.clickable(onClick = {
            currentState.value = DrawerAppScreen.scr2
            closeDrawer()
        }),
            content = {
                Text(text = "screen two is displayed", modifier = Modifier.padding(16.dp))
            }
        )

        Column(modifier = Modifier.clickable(onClick = {
            currentState.value = DrawerAppScreen.scr3
            closeDrawer()
        }),
        content = {
            Text(text = "screen 3 is displayed", modifier = Modifier.padding(16.dp))
        })


    }
}

fun getScreen(index:Int) =  when(index){
    0 -> DrawerAppScreen.scr1
    1 -> DrawerAppScreen.scr2
    2 -> DrawerAppScreen.scr3
    else -> DrawerAppScreen.scr1




}





@Composable
fun Component(
    currentState : DrawerAppScreen,
    enabledDarkMode: MutableState<Boolean>,
    opendrawer: () -> Unit
){
    val changedvalue = { _: Boolean ->
        enabledDarkMode.value = !enabledDarkMode.value

    }
    when(currentState)
    {
        DrawerAppScreen.scr1 -> Screen_1 (opendrawer,
            changedvalue,
        enabledDarkMode.value)
        DrawerAppScreen.scr2 -> Screen_2(opendrawer,
        changedvalue,
        enabledDarkMode.value)
        DrawerAppScreen.scr3 -> Screen_3(opendrawer,
        changedvalue,
        enabledDarkMode.value)
    }

}
@Composable
fun Screen_3(opendrawer: () -> Unit,
changedvalue : (Boolean) ->Unit,
             enabledDarkMode: Boolean
             ) {
    Column(
        modifier =Modifier.fillMaxSize()
            .padding(16.dp)
    ){
        TopAppBar(
            title = {Text("screen 3 title")},
            navigationIcon = {
                IconButton(onClick = opendrawer){
                    Icon(Icons.Filled.Close, contentDescription = null)
                }
            }
        )
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Switch(checked = enabledDarkMode,onCheckedChange = changedvalue )
                Text(text = "HEY!!! How U Doing....", style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
        Column(modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colors.background)
          ){
            Text(text = "Screen 3",
            style = MaterialTheme.typography.body1.copy( color = MaterialTheme.colors.onPrimary)
              )
        }
    }


}
@Composable
fun Screen_2(opendrawer: () -> Unit,
             changedvalue : (Boolean) ->Unit,
             enabledDarkMode: Boolean) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)){
        TopAppBar(
            title = {Text("screen 2 title")},
            navigationIcon = {
                IconButton(onClick = opendrawer){
                    Icon(Icons.Filled.Call,
                        contentDescription = null)
                }
            }
        )
        Card(){
            Row(){
                Switch(checked = enabledDarkMode,onCheckedChange = changedvalue)
                Text(text = "Be motivated always", style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Right, fontSize = 25.sp ))
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Screen 2")

        }
    }


}

@Composable
fun Screen_1(opendrawer: () ->Unit,
             changedvalue : (Boolean) ->Unit,
             enabledDarkMode: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ){
        TopAppBar(
            title = {Text("screen1 title")},
            navigationIcon = {
                IconButton(onClick = opendrawer){
                    Icon(Icons.Default.Email,
                        contentDescription = null)
                }

            }
        )
        Card(){

            Row(){
                Switch(checked = enabledDarkMode, onCheckedChange = changedvalue)
                Text("have a good life ahead", style = MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.primaryVariant, fontSize = 29.sp, fontWeight = FontWeight.Medium))
            }
        }
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Screen 1")

        }
    }
}

@Preview
@Composable
fun PreviewDrawerComponent() {
    Custom_Theme(enabledDarkMode = remember { mutableStateOf(false) }) {
        Card {
            Text("Preview Text", modifier = Modifier.padding(32.dp))
            DrawerAppScreen.scr3
        }
    }


    Custom_Theme(enabledDarkMode =  remember{ mutableStateOf(true)}){
        Card{
            Text("${DrawerAppScreen.scr2}")
        }
    }

    Custom_Theme(enabledDarkMode = remember { mutableStateOf(true) }){
        Card{
            Text("${DrawerAppScreen.scr1}")
        }
    }

}

