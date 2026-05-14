package com.vito.core.common

object FirestoreCollections {
    const val USERS = "users_v2"
    const val QR_TOKENS = "qr_tokens"
    const val RIDES = "rides"
    const val PACKAGES = "packages"
    const val MART_ORDERS = "mart_orders"
    const val MART_PRODUCTS = "mart_products"
    const val CHATS = "chats"
    const val DRIVER_LOCATIONS = "driver_locations"
    const val AUDIT_LOGS = "audit_logs"
    const val PAYOUT_REQUESTS = "payout_requests"
}

object VitoConfig {
    const val APP_NAME = "Vito"
    const val DEEP_LINK_SCHEME = "vito"
    const val DEFAULT_COUNTRY_CODE = "+1"
    const val MAX_STOPS_PER_RIDE = 3
    const val RIDE_REQUEST_TIMEOUT_SECONDS = 60
}
