package br.com.fiap.jobbridge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jobbridge.components.CampoTextoPersonalizado
import br.com.fiap.jobbridge.ui.theme.BlueJob
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage // Biblioteca recomendada para carregar imagens
import androidx.compose.foundation.clickable

@Composable
fun SignUpScreen(aoFinalizar: () -> Unit, clicouEmVoltar: () -> Unit) {
    var fullName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<android.net.Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: android.net.Uri? ->
        imageUri = uri // Armazena a imagem escolhida (mesmo que não salve no banco ainda)
    }
    Scaffold(
        topBar = {
            // Cabeçalho Azul igual ao print
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color(0xFFD9E2F3)),
                contentAlignment = Alignment.Center
            ) {
                Text("JOBBRIDGE", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            }
        },
        bottomBar = {
            // Barra de navegação inferior com os ícones do seu print
            NavigationBar(containerColor = Color.White, modifier = Modifier.height(60.dp)) {
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Person, null) })
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Work, null) }) // Representa a maleta do print
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Notifications, null) })
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Cadastrar", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            // Foto de perfil circular
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0F0F0))
                    .clickable { launcher.launch("image/*") }, // Abre a galeria ao clicar
                contentAlignment = Alignment.Center
            ) {
                if (imageUri != null) {
                    // Exibe a foto selecionada
                    AsyncImage(
                        model = imageUri,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // Ícone padrão caso não tenha foto
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp),
                        tint = Color.LightGray
                    )
                }
            }
            Text("Upload de foto de perfil", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(24.dp))

            // Inputs conforme o print
            CampoTextoPersonalizado(valor = fullName, aoMudar = { fullName = it }, label = "Nome Completo", icone = Icons.Default.Person)
            Spacer(modifier = Modifier.height(12.dp))
            CampoTextoPersonalizado(valor = age, aoMudar = { age = it }, label = "Idade", icone = Icons.Default.DateRange)
            Spacer(modifier = Modifier.height(12.dp))
            CampoTextoPersonalizado(valor = city, aoMudar = { city = it }, label = "Cidade - Estado", icone = Icons.Default.LocationOn)
            Spacer(modifier = Modifier.height(12.dp))
            CampoTextoPersonalizado(valor = email, aoMudar = { email = it }, label = "Email", icone = Icons.Default.Email)
            Spacer(modifier = Modifier.height(12.dp))
            CampoTextoPersonalizado(valor = contact, aoMudar = { contact = it }, label = "Número de telefone", icone = Icons.Default.Phone)

            // Botão de Currículo (Cinza)
            Button(
                onClick = {},
                modifier = Modifier.padding(vertical = 24.dp).fillMaxWidth().height(80.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.CloudUpload, contentDescription = null, tint = Color.Black)
                    Text("Anexar Currículo", color = Color.Black)
                }
            }

            // Botão Submit Azul
            Button(
                onClick = aoFinalizar,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueJob),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text("Confirmar", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            TextButton(onClick = clicouEmVoltar) {
                Text("Login", color = Color.Gray)
            }
        }
    }
}