package com.vito.core.data.model

data class ChatMessageDto(
    val id: String = "",
    val chatId: String = "",
    val senderId: String = "",
    val receiverId: String = "",
    val message: String = "",
    val timestamp: Long? = null,
    val isRead: Boolean = false
)
