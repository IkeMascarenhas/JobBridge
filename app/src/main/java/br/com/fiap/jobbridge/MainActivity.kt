package br.com.fiap.jobbridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.fiap.jobbridge.screens.SignUpScreen
import br.com.fiap.jobbridge.screens.SigninScreen
import br.com.fiap.jobbridge.screens.WelcomeScreen
import br.com.fiap.jobbridge.ui.theme.JobBridgeTheme
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobBridgeTheme {
                // Surface com fundo branco para evitar bordas estranhas nas imagens
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    var telaExibida by remember { mutableStateOf(1) }

                    LaunchedEffect(Unit) {
                        delay(3000) // Tempo em milissegundos (3000ms = 3 segundos)
                        telaExibida = 2 // Muda para a tela de Login automaticamente
                    }
                    when (telaExibida) {
                        1 -> WelcomeScreen(clicouNoBotao = { telaExibida = 2 })
                        2 -> SigninScreen(
                            aoClicarEntrar = { /* Login */ },
                            clicouEmCriarConta = { telaExibida = 3 } // Leva para o Cadastro Completo
                        )
                        3 -> SignUpScreen(
                            aoFinalizar = { telaExibida = 1 }, // Volta ao início após cadastrar
                            clicouEmVoltar = { telaExibida = 2 } // Volta para o Login
                        )
                    }
                    }
                }
            }
        }
    }
