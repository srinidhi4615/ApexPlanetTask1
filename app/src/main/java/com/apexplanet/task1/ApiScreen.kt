package com.apexplanet.task1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ApiScreen(
    onBack: () -> Unit
) {

    var post by remember {
        mutableStateOf<Post?>(null)
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    var postMessage by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    // GET API request
    LaunchedEffect(Unit) {

        try {
            post = RetrofitClient.apiService.getPost()

        } catch (e: Exception) {

            errorMessage =
                "Unable to load data. Please check your internet connection."

        } finally {

            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Screen heading
        Text(
            text = "Backend API Integration",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008577),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Loading
        if (isLoading) {

            Text(
                text = "Loading data...",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp
            )
        }

        // Error
        else if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp
            )
        }

        // API response
        else if (post != null) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE0F2F1)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "API RESPONSE",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF008577),
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "ID: ${post!!.id}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Title: ${post!!.title}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        lineHeight = 23.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Body: ${post!!.body}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // POST button
            Button(
                onClick = {

                    scope.launch {

                        try {

                            postMessage = "Sending data..."

                            val newPost = Post(
                                id = 0,
                                title = "Task 3 API Test",
                                body = "Data sent successfully from Android app.",
                                userId = 1
                            )

                            RetrofitClient.apiService.createPost(newPost)

                            postMessage = "Data sent successfully!"

                        } catch (e: Exception) {

                            postMessage = "Failed to send data."

                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5369A3)
                )
            ) {

                Text(
                    text = "SEND DATA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            if (postMessage.isNotEmpty()) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = postMessage,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Back button
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5369A3)
            )
        ) {

            Text(
                text = "BACK",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}