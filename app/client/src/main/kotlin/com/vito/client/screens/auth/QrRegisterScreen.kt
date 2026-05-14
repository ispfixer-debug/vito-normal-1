package com.vito.client.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vito.core.ui.theme.VitoPrimary
import com.vito.core.ui.theme.VitoAccent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrRegisterScreen(
    onRegisterSuccess: () -> Unit,
    onDebugSkip: () -> Unit,
    modifier: Modifier = Modifier
) {
    var token by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    
    LaunchedEffect(Unit) {
        // Auto-skip in demo mode
        delay(500)
    }
    
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.QrCodeScanner,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = VitoPrimary
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "Scan QR Code",
                style = MaterialTheme.typography.headlineMedium
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Scan the QR code provided by your admin to register your account",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Camera placeholder
            Card(
                modifier = Modifier.size(280.dp),
                colors = CardDefaults.cardColors(Color.LightGray.copy(alpha = 0.3f))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Camera permission required",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Manual token entry
            OutlinedTextField(
                value = token,
                onValueChange = { 
                    token = it
                    error = null
                },
                label = { Text("Or enter token manually") },
                leadingIcon = { Icon(Icons.Default.Keyboard, null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (error != null) {
                Text(
                    text = error!!,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            Button(
                onClick = { 
                    if (token.isNotBlank()) {
                        isLoading = true
                        // Simulate token validation
                        kotlinx.coroutines.MainScope().launch {
                            delay(1000)
                            isLoading = false
                            onRegisterSuccess()
                        }
                    } else {
                        error = "Please enter a valid token"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = token.isNotBlank() && !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = VitoPrimary)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White
                    )
                } else {
                    Text("Register", fontSize = 16.sp)
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Debug skip button
            OutlinedButton(
                onClick = onDebugSkip,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Skip (Demo Mode)")
            }
        }
    }
}