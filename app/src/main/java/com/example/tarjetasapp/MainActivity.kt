package com.example.tarjetasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetasapp.ui.theme.PlayfairDisplay
import com.example.tarjetasapp.ui.theme.TarjetasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tarjeta()
                }
            }
        }
    }
}

@Composable
fun Tarjeta() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        CuadranteTop(
            titulo = stringResource(R.string.titulo) ,
            subtitulo = stringResource(R.string.subtitulo),
        )

        var cuadranteActivo by remember {
            mutableStateOf(true)
        }
        if (cuadranteActivo){
            CuadranteBotUno(
                datosContacto = stringResource(R.string.datosContacto),
                miTelefono = stringResource(R.string.textoTelefono),
                miGithub = stringResource(R.string.textoGithub),
                miCorreo = stringResource(R.string.textoEmail),
                parteUnoDeDos = stringResource(R.string.parteUnoDeDos))
        }
        else{
            CuadranteBotDos(
                lenguajes = stringResource(R.string.lenguajes),
                lenguajeUno = stringResource(R.string.lenguajeUno),
                lenguajeDos = stringResource(R.string.lenguajeDos),
                lenguajeTres = stringResource(R.string.lenguajeTres),
                lenguajeCuatro = stringResource(R.string.lenguajeCuatro),
                lenguajeCinco = stringResource(R.string.lenguajeCinco),
                parteDosDeDos = stringResource(R.string.parteDosDeDos),
            )
        }

        Button(
            modifier = Modifier.size(124.dp, 60.dp),
            onClick = {cuadranteActivo = !cuadranteActivo}
        )
        {
            Text(
                stringResource(id = R.string.textoBoton),
                fontSize = (18.sp)
            )
        }
    }
}

@Composable
fun CuadranteTop(
    titulo: String,
    subtitulo: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imagen = painterResource(id = R.drawable.imagen_android)
        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier
                .size(136.dp)
        )
        Text(
            text = titulo,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Text(
            text = subtitulo,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            fontSize = 17.sp
        )
    }
}

@Composable
fun CuadranteBotUno(
    datosContacto:String,
    miTelefono: String,
    miGithub: String,
    miCorreo: String,
    parteUnoDeDos:String,
    modifier: Modifier = Modifier
){
    Text(
        text = datosContacto,
        modifier = Modifier
            .padding(top=32.dp, start = 32.dp)
            .fillMaxWidth(),
    )

    Column(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end =16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            val icono_telefono = painterResource(id = R.drawable.logo_telefono_oscuro)
            Image(
                painter = icono_telefono,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = miTelefono,
                modifier = Modifier.padding(8.dp),
            )
        }

        Row(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            val icono_github = painterResource(id = R.drawable.logo_github_oscuro)
            Image(
                painter = icono_github,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = miGithub,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            val icono_correo = painterResource(id = R.drawable.logo_email_oscuro)
            Image(
                painter = icono_correo,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = miCorreo,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
    Text(
        text = parteUnoDeDos,
        modifier = Modifier
            .padding(8.dp)
    )
}

@Composable
fun CuadranteBotDos(
    lenguajes: String,
    lenguajeUno: String,
    lenguajeDos: String,
    lenguajeTres: String,
    lenguajeCuatro: String,
    lenguajeCinco: String,
    parteDosDeDos: String
){
    Text(
        text = lenguajes,
        modifier = Modifier
            .padding(top=32.dp, start = 32.dp)
            .fillMaxWidth(),

    )
    Column(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            ){
            val java_logo = painterResource(R.drawable.java_logo)
            Image(
                painter = java_logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp),

                )
            val kotlin_logo = painterResource(R.drawable.kotlin_logo)
            Image(
                painter = kotlin_logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp),
            )
            val xml_logo = painterResource(R.drawable.xml_logo)
            Image(
                painter = xml_logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp)


            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
        ){
            val html_logo = painterResource(R.drawable.html_logo)
            Image(
                painter = html_logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp),
            )
            val css_logo = painterResource(R.drawable.css_logo)
            Image(
                painter = css_logo,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp,bottom = 8.dp)
                    .size(90.dp),
            )
        }
    }
    Text(
            text = parteDosDeDos,
    modifier = Modifier
        .padding(8.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun TarjetaPreview() {
    TarjetasAppTheme {
        Tarjeta()
    }
}