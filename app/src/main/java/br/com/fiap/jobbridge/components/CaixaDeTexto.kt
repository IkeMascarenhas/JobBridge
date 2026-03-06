package br.com.fiap.jobbridge.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CampoTextoPersonalizado(
    valor: String,
    aoMudar: (String) -> Unit,
    label: String,
    icone: ImageVector
) {
    OutlinedTextField(
        value = valor,
        onValueChange = aoMudar,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        trailingIcon = { Icon(icone, contentDescription = null) }
    )
}