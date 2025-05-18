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
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "albuns")
@Table(indexes = [Index(columnList = "name")])
class Album(
    @Column(nullable = false)
    val name: String,
    @Column(nullable = true, length = 500)
    val bannerImageUrl: String? = null,
    @Column(nullable = true)
    val albumType: AlbumType? = null,
    @Column(nullable = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", targetEntity = Song::class)
    val songs: Set<Song> = HashSet(),
    @Column(nullable = true)
    @OneToMany(mappedBy = "album", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, targetEntity = ArtistAlbum::class)
    var albumArtists: Set<ArtistAlbum>? = null,
    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY, targetEntity = Category::class)
    @JoinTable(
        name = "album_category",
        joinColumns = [JoinColumn(name = "album_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")],
        uniqueConstraints = [UniqueConstraint(columnNames = ["album_id", "category_id"])],
        indexes = [Index(columnList = "album_id"), Index(columnList = "category_id")]
    )
    var categories: Set<Category>? = null,
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
