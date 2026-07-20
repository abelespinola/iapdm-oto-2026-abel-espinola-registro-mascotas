package com.abelespinola.registromascotas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.outlined.Balance
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.HourglassEmpty
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abelespinola.registromascotas.ui.theme.AutumnPlaceholderDark
import com.abelespinola.registromascotas.ui.theme.AutumnPlaceholderLight
import com.abelespinola.registromascotas.ui.theme.IconoHuesito
import com.abelespinola.registromascotas.ui.theme.MascotasTheme
import java.util.UUID


// MODELO DE DATOS Y VIEWMODEL

data class Mascota(
    val id: String = UUID.randomUUID().toString(),
    val nombre: String,
    val especie: String,
    val raza: String,
    val edad: String,
    val peso: String
)

class MascotaViewModel : ViewModel() {
    var nombre by mutableStateOf("")
    var especie by mutableStateOf("")
    var raza by mutableStateOf("")
    var edad by mutableStateOf("")
    var peso by mutableStateOf("")

    val listaMascotas = mutableStateListOf<Mascota>()

    fun registrarMascota() {
        if (nombre.isNotBlank() && especie.isNotBlank() && raza.isNotBlank() && edad.isNotBlank() && peso.isNotBlank()) {
            listaMascotas.add(
                Mascota(
                    nombre = nombre,
                    especie = especie,
                    raza = raza,
                    edad = "$edad años",
                    peso = "$peso kg"
                )
            )
            nombre = ""; especie = ""; raza = ""; edad = ""; peso = ""
        }
    }

    fun eliminarMascota(mascota: Mascota) {
        listaMascotas.remove(mascota)
    }
}


// ACTIVIDAD PRINCIPAL

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MascotasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardClinicaApp()
                }
            }
        }
    }

    override fun onStart() { super.onStart(); Log.i(TAG, "onStart") }
    override fun onStop() { super.onStop(); Log.i(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.i(TAG, "onDestroy") }
}


// INTERFAZ DE USUARIO PRINCIPAL

@Composable
fun DashboardClinicaApp(viewModel: MascotaViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, start = 20.dp, end = 20.dp, bottom = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Pets,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Veterinaria Mascotitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Control y Registros de Mascotas",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(24.dp)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                SoftTextField(
                    valor = viewModel.nombre,
                    onValorCambiado = { viewModel.nombre = it },
                    icono = { Icon(Icons.Outlined.Pets, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp)) },
                    label = "Nombre de la mascota",
                    placeholder = "Ej: Firulais"
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    SoftTextField(
                        valor = viewModel.especie,
                        onValorCambiado = { viewModel.especie = it },
                        icono = { Icon(Icons.Outlined.Category, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp)) },
                        label = "Especie",
                        placeholder = "Ej: Perro",
                        modifier = Modifier.weight(1f)
                    )

                    // ¡AQUÍ REEMPLAZAMOS EL EMOJI POR NUESTRO ÍCONO VECTORIAL!
                    SoftTextField(
                        valor = viewModel.raza,
                        onValorCambiado = { viewModel.raza = it },
                        icono = { Icon(IconoHuesito, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp)) },
                        label = "Raza",
                        placeholder = "Ej: Poodle",
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    SoftTextField(
                        valor = viewModel.edad,
                        onValorCambiado = { input -> viewModel.edad = input.filter { it.isDigit() } },
                        icono = { Icon(Icons.Outlined.HourglassEmpty, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp)) },
                        label = "Edad",
                        placeholder = "Años",
                        modifier = Modifier.weight(1f),
                        keyboardType = KeyboardType.Number
                    )
                    SoftTextField(
                        valor = viewModel.peso,
                        onValorCambiado = { input -> viewModel.peso = input.filter { it.isDigit() || it == '.' } },
                        icono = { Icon(Icons.Outlined.Balance, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(22.dp)) },
                        label = "Peso",
                        placeholder = "Kg",
                        modifier = Modifier.weight(1f),
                        keyboardType = KeyboardType.Number
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { viewModel.registrarMascota() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Registrar Paciente", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Pacientes Activos (${viewModel.listaMascotas.size})",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            items(viewModel.listaMascotas, key = { it.id }) { mascota ->
                ItemMascotaTarjeta(
                    mascota = mascota,
                    onEliminarClick = { viewModel.eliminarMascota(mascota) }
                )
            }
        }
    }
}


// COMPONENTES AUXILIARES

@Composable
fun SoftTextField(
    valor: String,
    onValorCambiado: (String) -> Unit,
    icono: @Composable () -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val darkTheme = isSystemInDarkTheme()
    val currentPlaceholderColor = if (darkTheme) AutumnPlaceholderDark else AutumnPlaceholderLight

    OutlinedTextField(
        value = valor,
        onValueChange = onValorCambiado,
        label = { Text(label) },
        placeholder = { Text(placeholder, color = currentPlaceholderColor, fontSize = 14.sp) },
        leadingIcon = icono,
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = currentPlaceholderColor
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun ItemMascotaTarjeta(mascota: Mascota, onEliminarClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = mascota.nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item { SoftTag(mascota.especie, icono = { Icon(Icons.Outlined.Category, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp)) }) }

                // Huesito inyectado en la etiqueta
                item { SoftTag(mascota.raza, icono = { Icon(IconoHuesito, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp)) }) }

                item { SoftTag(mascota.edad, icono = { Icon(Icons.Outlined.HourglassEmpty, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp)) }) }
                item { SoftTag(mascota.peso, icono = { Icon(Icons.Outlined.Balance, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp)) }) }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onEliminarClick,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.End)
                    .height(38.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
            ) {
                Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.White)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Eliminar", fontSize = 12.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun SoftTag(texto: String, icono: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icono()
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = texto, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
