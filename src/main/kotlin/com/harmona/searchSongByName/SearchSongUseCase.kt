package com.harmona.searchSongByName

import com.harmona.common.config.LoadDatabase
import com.harmona.common.repository.SongRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SearchSongUseCase (
    val songRepository: SongRepository
) {
    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    fun search(name: String, pageable: Pageable?): SearchSongResponsePayload {
        log.info("Searching song by name: {}", name)

        val songs = songRepository.findByNameContainingIgnoreCase(name, pageable)
        return SearchSongResponsePayload.from(songs)
    }
}