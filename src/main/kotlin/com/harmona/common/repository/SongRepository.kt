package com.harmona.common.repository

import com.harmona.common.entity.Song
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface SongRepository: JpaRepository<Song, UUID> {

    @EntityGraph(attributePaths = ["album", "songArtists", "songArtists.artist"])
    fun findByNameContainingIgnoreCase(name: String, pageable: Pageable?): Page<Song>

    @EntityGraph(attributePaths = ["audios", "album", "songArtists", "songArtists.artist", "categories"])
    override fun findById(id: UUID): Optional<Song>
}