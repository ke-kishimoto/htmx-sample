package com.example.htmx.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController(
    private val userService: UserService
) {

    @GetMapping("/")
    fun index(model: Model): String {
        val users = userService.getAllUsers()
        model.addAttribute("users", users)
        return "user/list"
    }
}