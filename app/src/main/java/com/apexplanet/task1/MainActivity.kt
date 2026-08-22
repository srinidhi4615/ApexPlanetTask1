package com.apexplanet.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

val Teal = Color(0xFF008577)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApexPlanetTask1Theme {

                var isLoggedIn by remember {
                    mutableStateOf(false)
                }

                if (!isLoggedIn) {

                    LoginScreen(
                        onLoginSuccess = {
                            isLoggedIn = true
                        }
                    )

                } else {

                    InternshipApp()
                }
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

        "home" -> {

            HomeScreen(
                onViewTasks = {
                    currentScreen = "tasks"
                }
            )
        }

        "tasks" -> {

            TasksScreen(
                onTask1Click = {
                    currentScreen = "task1"
                },
                onApiClick = {
                    currentScreen = "api"
                },
                onHomeClick = {
                    currentScreen = "home"
                }
            )
        }

        "task1" -> {

            TaskDetailsScreen(
                onBack = {
                    currentScreen = "tasks"
                }
            )
        }

        "api" -> {

            ApiScreen(
                onBack = {
                    currentScreen = "tasks"
                }
            )
        }
    }
}


/* ---------------- HOME SCREEN ---------------- */

@Composable
fun HomeScreen(
    onViewTasks: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "APEX PLANET",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Teal
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Hello, Srinidhi",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Welcome to your internship journey",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE0F2F1)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Internship Progress",
                    fontWeight = FontWeight.Bold,
                    color = Teal
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "3 / 5",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Teal
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Tasks Completed"
                )
            }
        }

        Spacer(
            modifier = Modifier.height(32.dp)
        )

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


/* ---------------- TASKS SCREEN ---------------- */

@Composable
fun TasksScreen(
    onTask1Click: () -> Unit,
    onApiClick: () -> Unit,
    onHomeClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "MY INTERNSHIP TASKS",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Teal
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "ApexPlanet Internship",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )


        /* TASK 1 */

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE0F2F1)
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = onTask1Click
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Task 1",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Teal
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Android Development Environment Setup",
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "✓ Completed",
                    color = Color(0xFF218838),
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        /* TASK 2 */

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE0F2F1)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Task 2",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Teal
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Designing and Implementing UI/UX",
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "✓ Completed",
                    color = Color(0xFF218838),
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        /* TASK 3 */

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE0F2F1)
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = onApiClick
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Task 3",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Teal
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Backend Integration and API Development",
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "✓ Completed",
                    color = Color(0xFF218838),
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.height(32.dp)
        )


        Button(
            onClick = onHomeClick,
            modifier = Modifier.fillMaxWidth(),
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


/* ---------------- TASK 1 DETAILS ---------------- */

@Composable
fun TaskDetailsScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Task 1 - Android Setup",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Teal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Android Development Environment Setup",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE8F5E9)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "STATUS",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "Completed",
                    color = Color(0xFF218838),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Objective",
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Set up the Android development environment and create a basic Android application.",
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Tools Used",
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Android Studio\nKotlin\nJetpack Compose\nGit & GitHub",
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
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