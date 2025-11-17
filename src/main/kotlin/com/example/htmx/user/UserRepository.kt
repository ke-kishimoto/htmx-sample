package com.example.htmx.user

import com.example.htmx.user.model.User
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) {

    fun findAllUsernames(page: Int): List<User> {
        val sql = "SELECT * FROM users ORDER BY id LIMIT 10 OFFSET :offset"
        val params = mapOf("offset" to (page - 1) * 10)
        return namedParameterJdbcTemplate.query(sql, params, DataClassRowMapper(User::class.java))
    }

    fun findByUsernameLike(search: String, page: Int): List<User> {
        val sql = "SELECT * FROM users WHERE name LIKE :search OR email LIKE :search ORDER BY id LIMIT 10 OFFSET :offset"
        val params = mapOf("search" to "%$search%")
            .plus("offset" to (page - 1) * 10)
        return namedParameterJdbcTemplate.query(sql, params, DataClassRowMapper(User::class.java))
    }

}