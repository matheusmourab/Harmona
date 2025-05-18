package com.harmona.common.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "songs")
@Table(indexes = [Index(columnList = "name"), Index(columnList = "album_id")])
class Song(
    @Column(nullable = false)
    val name: String,
    @Column(nullable = true, length = 5000)
    val lyrics: String? = null,
    @Column(nullable = true, length = 500)
    val bannerImageUrl: String? = null,
    @JoinColumn(name = "album_id")
    @ManyToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    val album: Album? = null,
    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "song", targetEntity = Audio::class)
    val audios: Set<Audio> = HashSet(),
    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY, targetEntity = Category::class)
    @JoinTable(
        name = "song_category",
        joinColumns = [JoinColumn(name = "song_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")],
        uniqueConstraints = [UniqueConstraint(columnNames = ["song_id", "category_id"])],
        indexes = [Index(columnList = "song_id"), Index(columnList = "category_id")]
    )
    var categories: Set<Category>? = null,
) {
    @Column(nullable = true)
    @OneToMany(mappedBy = "song", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, targetEntity = ArtistSong::class)
    var songArtists: Set<ArtistSong>? = null
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

    fun incrementFavoriteCount() {
        favoriteCount++
    }

    fun incrementAccessCount() {
        accessCount++
    }
}
