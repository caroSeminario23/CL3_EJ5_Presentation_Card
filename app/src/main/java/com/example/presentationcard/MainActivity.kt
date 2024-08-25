package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentationCardApp()
                }
            }
        }
    }
}

@Composable
fun PresentationCardApp() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5F
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Presentacion(
                logotipo = painterResource(R.drawable.logotipo1),
                nombre = stringResource(R.string.nombre_text),
                cargo = stringResource(R.string.cargo_text)
            )

            Spacer(modifier = Modifier.size(24.dp))

            InformacionContacto(
                telefono = stringResource(R.string.telefono_text),
                paginaWeb = stringResource(R.string.pagina_web_text),
                correo = stringResource(R.string.correo_text)
            )
        }
    }
}

@Composable
private fun Presentacion(
    logotipo: Painter,
    nombre: String,
    cargo: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = logotipo,
            contentDescription = "Logotipo de presentación",
            Modifier.height(152.dp)
        )

        Text(
            text = nombre,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = modifier.padding(top = 12.dp)
        )

        Text(
            text = cargo,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 12.dp)
        )
    }
}

@Composable
private fun InformacionContacto(
    telefono: String,
    paginaWeb: String,
    correo: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        InformacionCaracteristica(
            icono = painterResource(R.drawable.logo_telefono),
            texto = telefono
        )

        InformacionCaracteristica(
            icono = painterResource(R.drawable.logo_p_gina_web),
            texto = paginaWeb
        )

        InformacionCaracteristica(
            icono = painterResource(R.drawable.logo_email),
            texto = correo
        )
    }
}

@Composable
private fun InformacionCaracteristica(
    icono: Painter,
    texto: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icono,
            contentDescription = null,
            modifier = modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = texto,
            fontSize = 14.sp
        )
    }
}

@Preview(
    showBackground = true,
    //showSystemUi = true
)
@Composable
fun PresentationCardPreview() {
    PresentationCardTheme {
        PresentationCardApp()
    }
}