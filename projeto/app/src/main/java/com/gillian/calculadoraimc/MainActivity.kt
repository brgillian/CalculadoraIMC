package com.gillian.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gillian.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.btCalcular
        val mensagem = binding.mensagem

        bt_calcular.setOnClickListener{
            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            if(editPeso.isEmpty()){
                mensagem.setText("Informe o seu peso.")
            }else if(editAltura.isEmpty()){
                mensagem.setText("Informe a sua altura.")
            }else{
                CalculoDeIMC()
            }
        }
    }
    private fun CalculoDeIMC(){
        val pesoID = binding.editPeso
        val alturaID = binding.editAltura

        val peso = Integer.parseInt(pesoID.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())
        val resultado = binding.mensagem
        val imc = peso / (altura * altura)

        val Mensagem = when{
            imc <= 18.5 -> "Abaixo do peso"
            imc <= 24.9 -> "Peso normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade(Grau 1)"
            imc <= 39.9 -> "Obesidade(Grau 2)"
            else -> "Obesidade morbida (Gra 3)"
        }
        imc.toString()
        resultado.setText("IMC: $imc \n $Mensagem")

    }
}