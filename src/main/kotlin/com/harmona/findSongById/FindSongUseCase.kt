package com.harmona.findSongById

import com.harmona.common.config.LoadDatabase
import com.harmona.common.repository.SongRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FindSongUseCase (
    val songRepository: SongRepository
) {
    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    fun find(id: String): FindSongResponsePayload {
        log.info("Finding song by id: {}", id)

        val song = songRepository.findById(UUID.fromString(id))
        return FindSongResponsePayload.from(song.orElseThrow())
    }
}