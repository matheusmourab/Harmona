package com.harmona.searchSongByName

import com.harmona.common.entity.Artist
import com.harmona.common.entity.Song
import org.springframework.data.domain.Page
import java.util.UUID

class SearchSongResponsePayload (
    val data: List<SongPayload>,
    val totalElements: Long,
    val pageNo: Int,
    var totalPages: Int,
) {
    companion object {
        fun from(songsPage: Page<Song>): SearchSongResponsePayload {
            val songs = songsPage.map { song ->
                val artist: Artist? = song.songArtists
                    ?.firstOrNull { artistSong -> artistSong.isMain }
                    ?.artist
                SongPayload(
                    song.id!!,
                    song.name,
                    artist?.avatarImageUrl,
                    artist?.name,
                    song.album?.name
            )}.toList()
            return SearchSongResponsePayload(songs, songsPage.totalElements, songsPage.number, songsPage.totalPages)
        }
    }

    class SongPayload (
        val id: UUID,
        val name: String,
        val avatarUrl: String?,
        var mainArtistsName: String?,
        val albumName: String?,
    )
}