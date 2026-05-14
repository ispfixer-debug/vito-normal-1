package com.vito.admin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AdminMenuItem(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val count: Int = 0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen() {
    val menuItems = listOf(
        AdminMenuItem("Users", Icons.Default.People, 0),
        AdminMenuItem("Drivers", Icons.Default.DirectionsCar, 0),
        AdminMenuItem("Rides", Icons.Default.LocalTaxi, 0),
        AdminMenuItem("QR Codes", Icons.Default.QrCode, 0),
        AdminMenuItem("Promo Codes", Icons.Default.LocalOffer, 0),
        AdminMenuItem("Analytics", Icons.Default.Analytics, 0),
        AdminMenuItem("Settings", Icons.Default.Settings, 0)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Vito Admin") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {
            Text("Dashboard", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Manage your Vito platform", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            
            // Stats Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickStatCard("Total Users", "0", Modifier.weight(1f))
                QuickStatCard("Active Rides", "0", Modifier.weight(1f))
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            Text("Management", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(menuItems) { item ->
                    AdminMenuCard(item)
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            Text("Demo Mode: ON", color = Color(0xFF2196F3))
        }
    }
}

@Composable
fun AdminMenuCard(item: AdminMenuItem) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(item.icon, null, tint = Color(0xFF2196F3))
            Spacer(modifier = Modifier.width(16.dp))
            Text(item.title, modifier = Modifier.weight(1f), fontSize = 16.sp)
            if (item.count > 0) {
                Badge { Text(item.count.toString()) }
            }
            Icon(Icons.Default.ChevronRight, null, tint = Color.Gray)
        }
    }
}

@Composable
fun QuickStatCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(80.dp)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(value, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))
            Text(label, fontSize = 12.sp, color = Color.Gray)
        }
    }
}