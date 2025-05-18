package com.harmona.findSongById

import com.harmona.common.entity.Artist
import com.harmona.common.entity.Song
import java.util.UUID

class FindSongResponsePayload (
    val id: UUID,
    val name: String,
    val lyrics: String?,
    val avatarImageUrl: String?,
    val artistName: String?,
    val albumName: String?,
    val audios: List<Audio>,
) {
    companion object {
        fun from(song: Song): FindSongResponsePayload {
            val artist: Artist? = song.songArtists
                ?.firstOrNull { artistSong -> artistSong.isMain }
                ?.artist
            return FindSongResponsePayload(
                song.id!!,
                song.name,
                song.lyrics,
                artist?.name,
                artist?.avatarImageUrl,
                song.album?.name,
                song.audios.stream().map {
                    audio -> Audio(audio.url, audio.voice.title, Note(audio.note.title, audio.note.symbol))
                }.toList()
            )
        }
    }

    class Audio (
        val url: String,
        val voice: String,
        val note: Note,
    )

    class Note (
        val name: String,
        val symbol: String,
    )
}