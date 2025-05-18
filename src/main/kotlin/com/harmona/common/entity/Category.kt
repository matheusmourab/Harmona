package com.harmona.common.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "categories")
class Category(
    @Column(nullable = false)
    val name: String,
    @Column(nullable = true, length = 500)
    val bannerImageUrl: String? = null,
) {
    @Column(nullable = false)
    var favoriteCount: Int = 0
    @Column(nullable = false)
    var accessCount: Int = 0
    @CreationTimestamp
    val createdAt: LocalDateTime? = null
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    fun incrementAccessCount() {
        accessCount++
    }
}