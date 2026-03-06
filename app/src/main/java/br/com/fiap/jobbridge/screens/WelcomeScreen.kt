package br.com.fiap.jobbridge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size // Adicionado
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jobbridge.R // Import necessário para reconhecer o R.drawable
import br.com.fiap.jobbridge.ui.theme.BlueJob

@Composable
fun WelcomeScreen(clicouNoBotao: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_img),
            contentDescription = "Logo JobBridge",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "JobBridge",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Connecting you to job opportunities",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = clicouNoBotao,
            modifier = Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BlueJob)
        ) {
            Text("Entrar")
        }
    }
}