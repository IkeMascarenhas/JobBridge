package br.com.fiap.jobbridge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jobbridge.R
import br.com.fiap.jobbridge.components.CampoTextoPersonalizado // Import do seu componente centralizado
import br.com.fiap.jobbridge.ui.theme.BlueJob

@Composable
fun SigninScreen(
    clicouEmCriarConta: () -> Unit, // Nome idêntico ao que a MainActivity usa
    aoClicarEntrar: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text("JobBridge", fontSize = 32.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        CampoTextoPersonalizado(
            valor = email,
            aoMudar = { email = it },
            label = "Email *",
            icone = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        CampoTextoPersonalizado(
            valor = password,
            aoMudar = { password = it },
            label = "Senha *",
            icone = Icons.Default.Lock
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = aoClicarEntrar,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BlueJob),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text("Entrar")
        }

        // O LINK QUE LEVA PARA O CADASTRO (SignUpScreen)
        TextButton(onClick = clicouEmCriarConta) {
            Row {
                Text("Não tem uma conta? ", color = Color.Gray)
                Text("Cadastrar", fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}