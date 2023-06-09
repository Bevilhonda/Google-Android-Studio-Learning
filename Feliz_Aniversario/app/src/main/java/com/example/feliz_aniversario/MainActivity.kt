package com.example.feliz_aniversario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.feliz_aniversario.ui.theme.Feliz_AniversarioTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Feliz_AniversarioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Imagem_de_Fundo(
                        message = getString(R.string.feliz_aniversario_text),
                        from = getString(R.string.assinatura_text)
                    )
                }
            }
        }
    }
}

@Composable
fun Mensagem_de_Parabens(message: String, from: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun Imagem_de_Fundo(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Mensagem_de_Parabens(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun Mensagem_de_Aniversario() {
    Feliz_AniversarioTheme {
        Mensagem_de_Parabens(message = "Feliz Aniversário Yuri!", from = " de: Marcelo")
    }
}