package com.apexplanet.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apexplanet.task1.ui.theme.ApexPlanetTask1Theme

private val Teal = Color(0xFF00796B)
private val DarkTeal = Color(0xFF004D40)
private val LightTeal = Color(0xFFE0F2F1)
private val Green = Color(0xFF2E7D32)
private val Orange = Color(0xFFF57C00)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApexPlanetTask1Theme {
                InternshipApp()
            }
        }
    }
}

@Composable
fun InternshipApp() {

    var currentScreen by remember {
        mutableStateOf("home")
    }

    when (currentScreen) {

        "home" -> HomeScreen(
            onViewTasks = {
                currentScreen = "tasks"
            }
        )

        "tasks" -> TasksScreen(
            onTask1Click = {
                currentScreen = "details"
            },
            onHomeClick = {
                currentScreen = "home"
            }
        )

        "details" -> TaskDetailsScreen(
            onBack = {
                currentScreen = "tasks"
            }
        )
    }
}

@Composable
fun HomeScreen(
    onViewTasks: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "APEX PLANET",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Teal
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Hello, Srinidhi 👋",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Welcome to your internship journey",
                fontSize = 16.sp,
                color = Color(0xFF666666),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightTeal
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Internship Progress",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkTeal
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "1 / 2",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Teal
                    )

                    Text(
                        text = "Tasks Completed",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onViewTasks,
                modifier = Modifier
                    .width(180.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Teal
                )
            ) {

                Text(
                    text = "VIEW TASKS",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TasksScreen(
    onTask1Click: () -> Unit,
    onHomeClick: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {

            Text(
                text = "MY INTERNSHIP TASKS",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Teal
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "ApexPlanet Internship",
                fontSize = 15.sp,
                color = Color(0xFF555555)
            )

            Spacer(modifier = Modifier.height(24.dp))

            TaskCard(
                taskTitle = "Task 1",
                description = "Android Development Environment Setup",
                status = "✓ Completed",
                statusColor = Green,
                onClick = onTask1Click
            )

            Spacer(modifier = Modifier.height(16.dp))

            TaskCard(
                taskTitle = "Task 2",
                description = "Designing and Implementing UI/UX",
                status = "● In Progress",
                statusColor = Orange,
                onClick = { }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onHomeClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Teal
                )
            ) {
                Text(
                    text = "HOME",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TaskCard(
    taskTitle: String,
    description: String,
    status: String,
    statusColor: Color,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightTeal
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = taskTitle,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = DarkTeal
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = status,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = statusColor
            )
        }
    }
}

@Composable
fun TaskDetailsScreen(
    onBack: () -> Unit
) {

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {

            Text(
                text = "Task 1 — Android Setup",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Teal
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Android Development Environment Setup",
                fontSize = 15.sp,
                color = Color(0xFF555555)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE8F5E9)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "STATUS",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkTeal
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "✓ Completed",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Green
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Objective",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkTeal
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Set up the Android development environment and create a basic Android application.",
                fontSize = 14.sp,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tools Used",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkTeal
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Android Studio\nKotlin\nJetpack Compose",
                fontSize = 14.sp,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Your Name")
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Email")
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Teal
                )
            ) {

                Text(
                    text = "BACK TO TASKS",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}