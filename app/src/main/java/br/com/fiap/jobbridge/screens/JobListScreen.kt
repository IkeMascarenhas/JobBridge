package br.com.fiap.jobbridge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jobbridge.ui.theme.JobBridgeTheme

data class Job(
    val title: String,
    val company: String,
    val tags: List<Pair<String, Color>>
)

@Composable
fun JobListScreen() {

    val jobs = listOf(
        Job(
            "Software Engineer",
            "Tech Corp",
            listOf(
                "Remote" to Color(0xFF3B82F6),
                "Inclusive" to Color(0xFFA5C8FF)
            )
        ),
        Job(
            "Graphic Designer",
            "Design Studio",
            listOf(
                "Part-Time" to Color(0xFF3B82F6),
                "Accessible" to Color(0xFFA5C8FF)
            )
        ),
        Job(
            "Project Manager",
            "Business Solutions",
            listOf(
                "Full-Time" to Color(0xFF3B82F6),
                "Diversity" to Color(0xFFA5C8FF)
            )
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF202020)),
        contentAlignment = Alignment.Center
    ) {

        Card(
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF4F4F4)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Header()

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Vagas disponíveis",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                FilterRow()

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(jobs) { job ->
                        JobCard(job)
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "JobBridge",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3B82F6),
                contentColor = Color.White
            )
        ) {
            Text("Filtro")
        }
    }
}

@Composable
fun FilterRow() {

    var remoto by remember { mutableStateOf(true) }
    var presencial by remember { mutableStateOf(false) }
    var hibrido by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {

        FilterItem("Remoto", remoto) { remoto = it }
        FilterItem("Presencial", presencial) { presencial = it }
        FilterItem("Híbrido", hibrido) { hibrido = it }

    }
}

@Composable
fun FilterItem(text: String, checked: Boolean, onChecked: (Boolean) -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Checkbox(
            checked = checked,
            onCheckedChange = onChecked
        )

        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Composable
fun JobCard(job: Job) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = job.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = job.company,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                job.tags.forEach { tag ->
                    Tag(tag.first, tag.second)
                }

            }
        }
    }
}

@Composable
fun Tag(text: String, color: Color) {

    Box(
        modifier = Modifier
            .background(color, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {

        Text(
            text = text,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JobListScreenPreview() {
    JobBridgeTheme {
        JobListScreen()
    }
}