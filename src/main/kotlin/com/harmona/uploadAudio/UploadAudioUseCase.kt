package com.harmona.uploadAudio

import com.harmona.common.config.LoadDatabase
import com.harmona.common.entity.Audio
import com.harmona.common.entity.Note
import com.harmona.common.entity.Voice
import com.harmona.common.repository.AudioRepository
import com.harmona.common.repository.SongRepository
import com.harmona.common.useCase.UploadFileUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@Service
class UploadAudioUseCase (
    val uploadFileUseCase: UploadFileUseCase,
    val audioRepository: AudioRepository,
    val songRepository: SongRepository
) {
    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    fun upload(songId: String, payload: UploadAudioRequestPayload, file: MultipartFile) {
        log.info("Uploading audio. songId: {}, note: {}, voice: {}", songId, payload.note, payload.voice)

        val voice = Voice.valueOf(payload.voice.uppercase())
        val note = Note.valueOf(payload.note.uppercase())
        val song = songRepository.getReferenceById(UUID.fromString(songId))
        val url = uploadFile(file, generateName(songId, voice, note))
        val audio = Audio(url, voice, note, song)

        audioRepository.save(audio)
    }

    private fun generateName(songId: String, voice: Voice, note: Note): String {
        return "${songId}_${voice.title}_${note.symbol}"
    }

    private fun uploadFile(file: MultipartFile, name: String): String {
        return uploadFileUseCase.upload(file, name)
    }
}