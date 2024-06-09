package pe.edu.idat.evaluacion01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun calcularSalario() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)) {

        var ht by rememberSaveable {
            mutableStateOf("")
        }

        var salario by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(
                text = "Calcular Salario Semanal",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style= TextStyle(fontWeight = FontWeight.Bold, fontSize=30.sp)
            )
            MySpace(espacio = 16)
            OutlinedTextField(
                value = ht,
                onValueChange = { ht=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese horas trabajadas") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                salario= calcular(ht.toInt()
                    ).toString()
            },
                modifier= Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR SALARIO")
            }
            MySpace(espacio = 16)
            Text(text = salario,
                style= TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace(espacio: Int){
    Spacer(modifier= Modifier.size(espacio.dp))
}

fun calcular(ht: Int): String{
    var hextras=0
    var resultado=0
    if(ht<=40){
        resultado=ht*16
    }else if(ht>40){
        hextras=(ht-40)*20
        resultado=(40*16)+hextras
    }else{
        resultado=0
    }
    return "Su Salario es: $resultado"
}
