package com.example.pyllit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pyllit.ui.theme.PyllitTheme

private val messages:List<MyMessage> = listOf(
        MyMessage("Panadol","disponible(4)           Lugares Cercanos(10)"),
        MyMessage("Petbismol","disponible(2)           Lugares Cercanos(1)"),
        MyMessage("Vitaminas","disponible(8)           Lugares Cercanos(2)"),
        MyMessage("Panadol","disponible(4)           Lugares Cercanos(10)"),
        MyMessage("Petbismol","disponible(2)           Lugares Cercanos(1)"),
        MyMessage("Vitaminas","disponible(8)           Lugares Cercanos(2)"),
        MyMessage("Panadol","disponible(4)           Lugares Cercanos(10)"),
        MyMessage("Petbismol","disponible(2)           Lugares Cercanos(1)"),
        MyMessage("Vitaminas","disponible(8)           Lugares Cercanos(2)"),
        MyMessage("Panadol","disponible(4)           Lugares Cercanos(10)"),
        MyMessage("Petbismol","disponible(2)           Lugares Cercanos(1)"))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            PyllitTheme {
                MyMessages(messages)
            }
        }
    }
}
data class MyMessage(val title: String,val body:String)
@Composable
fun MyMessages(messages:List<MyMessage>){
    LazyColumn{
        items(messages) { message ->
            MyComponet(message)
        }
        }
    }

@Composable
fun MyComponet(message: MyMessage){
    Row (modifier= Modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)) {
    MyImage()
    MyTexts(message)
    }
}
@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp) /* Tamaño de imgen */
            .clip(CircleShape)/* Forma*/
            .background(MaterialTheme.colors.primary))/* Color de Fondo */
}
@Composable
fun MyTexts(messages:MyMessage){
    Column(modifier = Modifier.padding(start= 8.dp)) {
        MyText( messages.title,
            MaterialTheme.colors.primary,
        MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(messages.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }
}
@Composable
fun MyText(text:String,color: Color,style:TextStyle){
    Text(text,color=color,style= style)
}
@Preview(showSystemUi = true)
@Composable
fun PreviewComponet(){
    PyllitTheme {
        /* otro metodo para mover la pantalla***
        val scrollState = rememberScrollState()
        Column(modifier= Modifier.verticalScroll(scrollState)){ }*/
            MyMessages(messages)

    }
}