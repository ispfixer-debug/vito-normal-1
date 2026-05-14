package com.vito.client.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ServiceItem(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val description: String,
    val color: Color
)

@Composable
fun HomeScreen() {
    val services = listOf(
        ServiceItem("ride", "VitoRide", Icons.Default.DirectionsCar, "Book a ride", Color(0xFF2196F3)),
        ServiceItem("send", "VitoSend", Icons.Default.LocalShipping, "Send packages", Color(0xFF4CAF50)),
        ServiceItem("mart", "VitoMart", Icons.Default.ShoppingCart, "Shop essentials", Color(0xFFFF9800))
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "Activity") },
                    label = { Text("Activity") },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Welcome to Vito", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Where would you like to go?", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Text("Services", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(services) { service ->
                    ServiceCard(service = service)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("Quick Actions", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickActionButton("Scan QR", Icons.Default.QrCodeScanner, Modifier.weight(1f))
                QuickActionButton("My Wallet", Icons.Default.AccountBalanceWallet, Modifier.weight(1f))
                QuickActionButton("Support", Icons.Default.Help, Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(1f))
            Text("Demo Mode: ON", color = Color(0xFF2196F3))
        }
    }
}

@Composable
fun ServiceCard(service: ServiceItem) {
    Card(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(56.dp).clip(CircleShape).background(service.color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(service.icon, null, tint = service.color, modifier = Modifier.size(28.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(service.name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Text(service.description, fontSize = 14.sp, color = Color.Gray)
            }
            Icon(Icons.Default.ChevronRight, null, tint = Color.Gray)
        }
    }
}

@Composable
fun QuickActionButton(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(80.dp), shape = RoundedCornerShape(12.dp)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(icon, null, tint = Color(0xFF2196F3))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text, fontSize = 12.sp)
        }
    }
}
