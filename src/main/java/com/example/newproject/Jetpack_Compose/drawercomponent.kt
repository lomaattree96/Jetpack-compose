package com.example.newproject.Jetpack_Compose

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DrawerComponent(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
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
                        closeDrawer :() -> Unit)
{
    Column(
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
    opendrawer: () -> Unit
){
    when(currentState)
    {
        DrawerAppScreen.scr1 -> Screen_1(opendrawer)
        DrawerAppScreen.scr2 -> Screen_2(opendrawer)
        DrawerAppScreen.scr3 -> Screen_3(opendrawer)
    }

}
@Composable
fun Screen_3(opendrawer: () -> Unit) {
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
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Screen 3")
        }
    }


}
@Composable
fun Screen_2(opendrawer: () -> Unit) {
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
fun Screen_1(opendrawer: () ->Unit) {
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
fun PreviewDrawerComponent(){
    DrawerComponent()
}


