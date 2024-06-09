package pe.edu.idat.evaluacion01

import android.R
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SumarSerie() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)) {

        var num by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(
                text = "Sumar Números de Serie",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style= TextStyle(fontWeight = FontWeight.Bold, fontSize=30.sp)
            )
            MySpace(espacio = 16)
            OutlinedTextField(
                value = num,
                onValueChange = { num=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el Numero Limite:") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultado= sumarnumeros(num.toInt()).toString()
            },
                modifier=Modifier.fillMaxWidth()) {
                Text(text = "Mostrar Suma")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style=TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray))
        }
    }
}

fun sumarnumeros(num: Int): String{

    var suma=0
    var resultado=""

    for(i in 1..num){
        //print("\nNumero: $i\n")
        resultado+="$i \n"
        suma+=i
    }


    return "Numeros: \n $resultado \n La Suma es: $suma"
}
