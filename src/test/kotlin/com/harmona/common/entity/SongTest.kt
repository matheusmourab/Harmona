package com.harmona.common.entity

import com.harmona.common.repository.ArtistRepository
import com.harmona.common.repository.CategoryRepository
import com.harmona.common.repository.SongRepository
import org.hibernate.LazyInitializationException
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class SongTest {

    @Autowired
    private lateinit var songRepository: SongRepository
    @Autowired
    private lateinit var artistRepository: ArtistRepository
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Test
    fun fetchMusicByName() {
        songRepository.deleteAll()
        val artist = artistRepository.save(Artist("Projeto Sola"))
        val category = categoryRepository.save(Category("Worship"))
        var song = Song("Sobre Ele", null, null, Album("DDG"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)), setOf(category))
        song.songArtists = setOf(ArtistSong(artist, song))
        songRepository.save(song)
        song.incrementAccessCount()
        category.incrementAccessCount()
        songRepository.save(song)
        songRepository.save(Song("Isaías 53"))

        var songsPage = songRepository.findByNameContainingIgnoreCase("Sobre Ele", PageRequest.of(0, 2))
        var songs = songsPage.get().toList()
        assertEquals(1, songs.size)
        assertEquals("Sobre Ele", songs[0].name)
        assertEquals(1, songs[0].accessCount)
        assertEquals("DDG", songs[0].album!!.name)
        assertEquals("Projeto Sola", songs[0].songArtists!!.first().artist.name)
        assertNotNull(songs[0].createdAt)
        assertNotNull(songs[0].updatedAt)
        assertThrows(LazyInitializationException::class.java) { songs[0].audios.size }
        assertThrows(LazyInitializationException::class.java) { songs[0].categories!!.size }

        song = songRepository.findById(songs[0].id!!).get()
        assertEquals("123", song.audios.first().url)
        assertEquals("Worship", song.categories!!.first().name)
        assertEquals(1, song.categories!!.first().accessCount)

        songsPage = songRepository.findByNameContainingIgnoreCase("s", PageRequest.of(0, 2))
        songs = songsPage.get().toList()
        assertEquals(2, songs.size)
        assertEquals(0, songsPage.number)
        assertEquals(2, songsPage.totalElements)
        assertEquals(1, songsPage.totalPages)
        assertNotNull(songs[0].id)
    }
}