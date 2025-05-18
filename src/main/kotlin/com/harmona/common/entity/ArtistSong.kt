package com.harmona.common.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "artist_song")
@Table(indexes = [Index(columnList = "song_id"), Index(columnList = "artist_id")])
class ArtistSong (
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    val artist: Artist,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    val song: Song,
    @Column(nullable = false)
    var isMain: Boolean = true,
) {
    @CreationTimestamp
    val createdAt: LocalDateTime? = null
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
}