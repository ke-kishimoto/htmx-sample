package com.example.htmx.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController {

    @GetMapping("/")
    fun index(): String {
        return "list"
    }
}