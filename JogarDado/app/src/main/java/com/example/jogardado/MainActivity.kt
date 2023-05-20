package com.example.jogardado

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //criar atividade para um botão  , ao clicar ele chama a função ROLLDICE()
        val JogarDadoButon: Button = findViewById(R.id.button)
        JogarDadoButon.setOnClickListener {
            val diceImage: ImageView = findViewById(R.id.imageView)
            rollDice()
        }
    }

    private fun rollDice() {
        val valorDados = Dice(6)
        val jogarDado = valorDados.roll()
        val resultadoDaImagem: ImageView = findViewById(R.id.imageView)

        when (jogarDado) {
            1 -> resultadoDaImagem.setImageResource(R.drawable.dice_1)
            2 -> resultadoDaImagem.setImageResource(R.drawable.dice_2)
            3 -> resultadoDaImagem.setImageResource(R.drawable.dice_3)
            4 -> resultadoDaImagem.setImageResource(R.drawable.dice_4)
            5 -> resultadoDaImagem.setImageResource(R.drawable.dice_5)
            6 -> resultadoDaImagem.setImageResource(R.drawable.dice_6)
        }
    }
}

/* na classe abaixo foi criada a FUNÇÃO ROLL que pega um numero inteiro de 1 até o numero que
definirmos nos parametros  NUMSIDES e usa outra função conhecida do JAVA que é o RANDOM */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}