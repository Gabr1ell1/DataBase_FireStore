package com.example.cadastro_telakotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cadastro_telakotlin.ui.theme.Cadastro_TelaKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cadastro_TelaKotlinTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Login") {
                            Login(
                                onLogin = { userName ->
                                    navController.navigate("home/${userName.ifBlank { "Convidado" }}")
                                },
                                onRegisterClick = {
                                    navController.navigate("Cadastro")
                                }
                            )
                        }
                        composable("Cadastro") {
                            Cadastro(
                                onRegisterComplete = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}