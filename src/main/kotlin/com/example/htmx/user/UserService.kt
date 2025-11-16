package com.example.htmx.user

import com.example.htmx.user.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getAllUsers(): List<User> {
        return userRepository.findAllUsernames()
    }

    fun get(q: String): List<User> {
        return userRepository.findByUsernameLike(q)
    }
}