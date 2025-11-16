package com.example.htmx.user

import org.springframework.stereotype.Service

@Service
class UserService {

    fun getAllUsers(): List<String> {
        return listOf("Alice", "Bob", "Charlie")
    }
}