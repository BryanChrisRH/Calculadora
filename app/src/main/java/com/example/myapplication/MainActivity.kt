package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.DecimalFormat
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Bborrar:Button= findViewById(R.id.Borrar)
        var B7:Button= findViewById(R.id.Boton_7)
        var B8:Button= findViewById(R.id.Numero_8)
        var B9:Button= findViewById(R.id.Numero_9)
        var B4:Button= findViewById(R.id.Numero_4)
        var B5:Button= findViewById(R.id.Numero_5)
        var B6:Button= findViewById(R.id.Numero_6)
        var B1:Button= findViewById(R.id.Numero_1)
        var B2:Button= findViewById(R.id.Numero_2)
        var B3:Button= findViewById(R.id.Numero_3)
        val B0:Button= findViewById(R.id.Numero_0)
        var BPunto:Button= findViewById(R.id.puntito)
        var BSumar:Button= findViewById(R.id.Boton_Sumar)
        var BRestar:Button= findViewById(R.id.Boton_Restar)
        var BMulti:Button=findViewById(R.id.Boton_Multi)
        var BDividir:Button=findViewById(R.id.Buton_Division)
        var BResultado:Button= findViewById(R.id.Boton_resultado)
        val input:TextView= findViewById(R.id.input)
        val output:TextView= findViewById(R.id.output)
//Funcion a los botones para que se impriman en la pantalla
        Bborrar.setOnClickListener {
            input.text=""
            output.text=""
        }

        B0.setOnClickListener {
            input.text= addToInputText("0")
        }

        B1.setOnClickListener {
            input.text=addToInputText("1")
        }

        B2.setOnClickListener {
            input.text=addToInputText("2")
        }

        B3.setOnClickListener {
            input.text=addToInputText("3")
        }

        B4.setOnClickListener {
            input.text=addToInputText("4")
        }

        B5.setOnClickListener {
            input.text=addToInputText("5")
        }

        B6.setOnClickListener {
            input.text=addToInputText("6")
        }

        B7.setOnClickListener {
            input.text=addToInputText("7")
        }

        B8.setOnClickListener {
            input.text=addToInputText("8")
        }

        B9.setOnClickListener {
            input.text=addToInputText("9")
        }

        BPunto.setOnClickListener {
            input.text=addToInputText(".")
        }

        BSumar.setOnClickListener {
            input.text=addToInputText("+")
        }
        BRestar.setOnClickListener {
            input.text=addToInputText("-")
        }
        BMulti.setOnClickListener {
            input.text=addToInputText("*")
        }
        BDividir.setOnClickListener {
            input.text=addToInputText("/")
        }

        BResultado.setOnClickListener {
            Resultado()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        val input:TextView= findViewById(R.id.input)
        return input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        val input:TextView= findViewById(R.id.input)
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun Resultado() {
        val output:TextView= findViewById(R.id.output)
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Mensaje de error
                output.text = ""
                output.setTextColor(ContextCompat.getColor(this, R.color.md_theme_dark_error))
            } else {
                // Mirar el resultado
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.md_theme_light_background))
            }
        } catch (e: Exception) {
            // Mensaje de error
            output.text = ""
            output.setTextColor(ContextCompat.getColor(this, R.color.md_theme_dark_error))
        }
    }
}