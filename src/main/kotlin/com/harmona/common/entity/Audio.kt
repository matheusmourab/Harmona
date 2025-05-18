package com.harmona.common.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "audios")
class Audio(
    @Column(nullable = false)
    val url: String,
    @Column(nullable = false)
    val voice: Voice,
    @Column(nullable = false)
    val note: Note,
    @JoinColumn(name = "song_id")
    @ManyToOne(fetch = FetchType.LAZY)
    val song: Song? = null,
) {
    @CreationTimestamp
    val createdAt: LocalDateTime? = null
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
}
