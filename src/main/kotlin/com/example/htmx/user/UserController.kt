package com.example.htmx.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@Controller
class UserController(
    private val userService: UserService
) {

    @GetMapping(value = ["/", "/users"])
    fun search(
        @RequestParam(value = "q", required = false, defaultValue = "") search: String,
        @RequestParam(value = "page", required = false, defaultValue = "1") page: Int,
        @RequestHeader(value = "HX-Request", required = false) hxRequest: String?,
        model: Model
    ): String {
        val users = if(search.isEmpty()) {
            userService.getAllUsers(page)
        } else {
            userService.get(search, page)
        }
        model.addAttribute("users", users)
        model.addAttribute("page", page)
        model.addAttribute("search", search)
        // HTMXリクエストの場合はフラグメントのみ、それ以外はフルページを返す
        return if (hxRequest != null) {
            "fragments/user-list :: user-list"
        } else {
            "pages/index"
        }
    }
}