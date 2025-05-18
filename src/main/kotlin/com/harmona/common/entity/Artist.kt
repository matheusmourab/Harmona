package com.harmona.common.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "artists")
@Table(indexes = [Index(columnList = "name")])
class Artist(
    @Column(nullable = false)
    val name: String,
    @Column(nullable = true, length = 500)
    val avatarImageUrl: String? = null,
    @Column(nullable = true, length = 500)
    val bannerImageUrl: String? = null,
    @Column(nullable = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artist", cascade = [CascadeType.REMOVE], targetEntity = ArtistSong::class)
    val artistSongs: Set<ArtistSong>? = null,
    @Column(nullable = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artist", cascade = [CascadeType.REMOVE], targetEntity = ArtistAlbum::class)
    val artistAlbuns: Set<ArtistAlbum>? = null,
) {
    @Column(nullable = false)
    val favoriteCount: Int = 0
    @Column(nullable = false)
    val accessCount: Int = 0
    @CreationTimestamp
    val createdAt: LocalDateTime? = null
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
}
