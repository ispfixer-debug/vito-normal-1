package com.vito.client.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String = "",
    val icon: ImageVector? = null
) {
    // Auth
    data object QrRegister : ClientScreen("qr_register", "Register", Icons.Default.QrCode)
    
    // Main tabs
    data object Home : ClientScreen("home", "Home", Icons.Default.Home)
    data object Activity : ClientScreen("activity", "Activity", Icons.Default.History)
    data object Profile : ClientScreen("profile", "Profile", Icons.Default.Person)
    
    // VitoRide flow
    data object VitoRideHome : ClientScreen("vito_ride_home", "Ride", Icons.Default.LocalTaxi)
    data object RideTracking : ClientScreen("ride_tracking/{rideId}", "Tracking") {
        fun createRoute(rideId: String) = "ride_tracking/$rideId"
    }
    data object RideRating : ClientScreen("ride_rating/{rideId}", "Rate") {
        fun createRoute(rideId: String) = "ride_rating/$rideId"
    }
    
    // VitoSend flow
    data object VitoSendHome : ClientScreen("vito_send_home", "Send", Icons.Default.LocalShipping)
    data object SendForm : ClientScreen("send_form", "Send Package")
    data object SendTracking : ClientScreen("send_tracking/{packageId}", "Tracking") {
        fun createRoute(packageId: String) = "send_tracking/$packageId"
    }
    
    // VitoMart flow
    data object VitoMartHome : ClientScreen("vito_mart_home", "Mart", Icons.Default.ShoppingCart)
    data object ProductDetail : ClientScreen("product/{productId}", "Product") {
        fun createRoute(productId: String) = "product/$productId"
    }
    data object Cart : ClientScreen("cart", "Cart", Icons.Default.ShoppingCart)
    data object MartCheckout : ClientScreen("mart_checkout", "Checkout")
    data object MartOrderTracking : ClientScreen("mart_order/{orderId}", "Order") {
        fun createRoute(orderId: String) = "mart_order/$orderId"
    }
    
    // Profile screens
    data object WalletTopUp : ClientScreen("wallet_top_up", "Top Up")
    data object SavedCards : ClientScreen("saved_cards", "Cards")
    data object AppLockSetup : ClientScreen("app_lock_setup", "Lock")
    data object LinkDevice : ClientScreen("link_device", "Link Device")
    data object Chat : ClientScreen("chat/{rideId}", "Chat") {
        fun createRoute(rideId: String) = "chat/$rideId"
    }
}

val clientBottomNavItems = listOf(
    ClientScreen.VitoRideHome,
    ClientScreen.VitoSendHome,
    ClientScreen.VitoMartHome,
    ClientScreen.Activity,
    ClientScreen.Profile
)

// Service tabs enum for tab bar
enum class VitoServiceTab(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    RIDE("vito_ride_home", "Ride", Icons.Default.LocalTaxi),
    SEND("vito_send_home", "Send", Icons.Default.LocalShipping),
    MART("vito_mart_home", "Mart", Icons.Default.ShoppingCart),
    ACTIVITY("activity", "Activity", Icons.Default.History),
    PROFILE("profile", "Profile", Icons.Default.Person)
}