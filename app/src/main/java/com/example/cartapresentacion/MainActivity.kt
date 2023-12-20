package com.example.cartapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartapresentacion.ui.theme.CartaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaPresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Carta("Android")
                }
            }
        }
    }
}

@Composable
fun Carta(name: String, modifier: Modifier = Modifier) {
    var mostrarDatosAdicionales by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(217, 209, 186))
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val imagen = painterResource(R.drawable.fotodeperfil)


        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .clickable { mostrarDatosAdicionales = !mostrarDatosAdicionales }
        )

        Text(
            text = stringResource(R.string.nombre),
            modifier = Modifier
                .padding(top = 10.dp, bottom = 1.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.apellido),
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(R.string.profesion),
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Haz clic en la imagen para ver los datos adicionales",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )


        if (mostrarDatosAdicionales) {
            Spacer(modifier = Modifier.height(16.dp))


            Column {
                FilaTexto("⌨️   Lenguajes: " +
                        "Kotlin, Java, XML/HTML")
                FilaTexto("\uD83D\uDCF1  +34 633 26 78 19")
                FilaTexto("\uD83D\uDCE7  pablofontandelacruz@gmail.com")
            }
        }
    }
}

@Composable
fun FilaTexto(texto: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = texto, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartaPresentacionTheme {
        Carta("Android")
    }
}
