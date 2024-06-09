package pe.edu.idat.evaluacion01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.idat.evaluacion01.ui.theme.Evaluacion01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Evaluacion01Theme {
                //Ejercicio 01
                calcularSalario()

                //Ejercicio 02
                //promedioPracticas()

                //Ejercicio 03
                //conversionTiempo()

                //Ejercicio 04
                //SumarSerie()
            }
        }
    }
}