package com.example.htmx.user

import com.example.htmx.user.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getAllUsers(page: Int): List<User> {
        return userRepository.findAllUsernames(page)
    }

    fun get(search: String, page: Int): List<User> {
        return userRepository.findByUsernameLike(search, page)
    }
}