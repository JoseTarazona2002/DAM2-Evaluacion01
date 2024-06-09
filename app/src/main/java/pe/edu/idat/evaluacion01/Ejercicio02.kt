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
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp

@Composable
fun promedioPracticas() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)) {

        var nt1 by rememberSaveable {
            mutableStateOf("")
        }
        var nt2 by rememberSaveable {
            mutableStateOf("")
        }
        var nt3 by rememberSaveable {
            mutableStateOf("")
        }
        var nt4 by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(
                text = "Promedio de Practicas",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style= TextStyle(fontWeight = FontWeight.Bold, fontSize=30.sp)
            )
            Spacer(modifier=Modifier.size(16.dp))
            OutlinedTextField(
                value = nt1,
                onValueChange = { nt1=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese La Nota 1:") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier=Modifier.size(16.dp))
            OutlinedTextField(
                value = nt2,
                onValueChange = { nt2=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese La Nota 2: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier=Modifier.size(16.dp))
            OutlinedTextField(
                value = nt3,
                onValueChange = { nt3=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese La Nota 3:") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier=Modifier.size(16.dp))
            OutlinedTextField(
                value = nt4,
                onValueChange = { nt4=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese La Nota 4: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier=Modifier.size(16.dp))
            Button(onClick = {
                resultado= calcularPromedio(nt1.toInt(),
                    nt2.toInt(), nt3.toInt(), nt4.toInt()).toString()
            },
                modifier= Modifier.fillMaxWidth()) {
                Text(text = "Calcular Promedio")
            }
            Spacer(modifier=Modifier.size(16.dp))
            Text(text = resultado,
                style= TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}


fun calcularPromedio(nt1: Int, nt2: Int, nt3: Int, nt4: Int): String{
    var promedio=0
    var menor=minOf(nt1,nt2,nt3,nt4)

    if(nt1<nt2 && nt1<nt3 && nt1<nt4){
        promedio=(nt2+nt3+nt4)/3
    }else if(nt2<nt1 && nt2<nt3 && nt2<nt4){
        promedio=(nt1+nt3+nt4)/3
    }else if(nt3<nt1 && nt3<nt2 && nt3<nt4){
        promedio=(nt2+nt1+nt4)/3
    }else if(nt4<nt2 && nt4<nt3 && nt4<nt1){
        promedio=(nt2+nt3+nt1)/3
    }

    return "La Nota menor es: $menor, el promedio es: $promedio"
}
