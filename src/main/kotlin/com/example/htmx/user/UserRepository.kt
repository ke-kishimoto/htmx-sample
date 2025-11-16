package com.example.htmx.user

import com.example.htmx.user.model.User
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) {

    fun findAllUsernames(): List<User> {
        val sql = "SELECT * FROM users"
        return namedParameterJdbcTemplate.query(sql, DataClassRowMapper(User::class.java))
    }

    fun findByUsernameLike(q: String): List<User> {
        val sql = "SELECT * FROM users WHERE name LIKE :q OR email LIKE :q"
        val params = mapOf("q" to "%$q%")
        return namedParameterJdbcTemplate.query(sql, params, DataClassRowMapper(User::class.java))
    }

}