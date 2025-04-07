package com.example.appaula

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaula.ui.theme.AppAulaTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAulaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppAula()
                }
            }
        }
    }
}

@Composable
fun AppAula(){
    var Nome by remember { mutableStateOf("") }
    var Endereco by remember { mutableStateOf("") }
    var Bairro by remember { mutableStateOf("") }
    var Cep by remember { mutableStateOf("") }
    var Cidade by remember { mutableStateOf("") }
    var Estado by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxWidth(),
        Arrangement.Center
    ){
        Row (
            Modifier
                .fillMaxWidth(),
            Arrangement.Center,

            ){}
        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){
            Text("Cadastro",
                fontSize = 30.sp,

                ) }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){
            TextField(
                value = Nome,
                onValueChange = { Nome = it },
                label = { Text("Nome Completo") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){

            TextField(
                value = Endereco,
                onValueChange = { Endereco = it },
                label = { Text("Endereço") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){

            TextField(
                value = Bairro,
                onValueChange = { Bairro = it },
                label = { Text("Bairro") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){

            TextField(
                value = Cep,
                onValueChange = { Cep = it },
                label = { Text("CEP") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){

            TextField(
                value = Cidade,
                onValueChange = { Cidade = it },
                label = { Text("Cidade") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.Center
        ){

            TextField(
                value = Estado,
                onValueChange = { Estado = it },
                label = { Text("Estado") }
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(25.dp),
            Arrangement.Center
        ){
            Column (
                Modifier
                    .fillMaxWidth(0.4f)

            ){
                Button(
                    onClick = {
                        val db = Firebase.firestore
                        // Create a new user with a first and last name

                        val user = hashMapOf(
                            "Nome" to Nome,
                            "Endereco" to Endereco,
                            "Bairro" to Bairro,
                            "Cep" to Cep,
                            "Cidade" to Cidade,
                            "Estado" to Estado,

                        )

                        // Add a new document with a generated ID
                        db.collection("users")
                            .add(user)
                            .addOnSuccessListener { documentReference ->
                                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                Log.w(TAG, "Error adding document", e)
                            }


                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(1.dp, Color.Blue) // Aqui você define a cor e espessura da borda
                ) {
                    Text("Cadastrar",
                        fontSize = 16.sp
                    )
                }
            }
            Column (
                Modifier
                    .padding(start = 10.dp)

            ){
                Button(
                    onClick = { /* ... */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(1.dp, Color.Blue) // Aqui você define a cor e espessura da borda
                ) {
                    Text("Cancelar",
                        fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun appAulaPreview() {
    AppAulaTheme {
            AppAula()
    }
}