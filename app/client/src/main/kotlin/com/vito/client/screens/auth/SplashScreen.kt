package com.vito.client.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vito.core.ui.theme.VitoPrimary
import com.vito.core.ui.theme.VitoAccent
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showContent by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay(300)
        showContent = true
        delay(1700) // Total 2 seconds
        onFinished()
    }
    
    Surface(
        modifier = modifier.fillMaxSize(),
        color = VitoPrimary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo placeholder
            Text(
                text = "VITO",
                style = MaterialTheme.typography.displayLarge,
                color = VitoAccent
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            AnimatedVisibility(
                visible = showContent,
                enter = androidx.compose.animation.fadeIn()
            ) {
                Text(
                    text = "Your city, your way.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}