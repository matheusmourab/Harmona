package com.harmona.uploadAudio

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/songs")
class UploadAudioController(
    val uploadAudioUseCase: UploadAudioUseCase
) {
    @PostMapping("/{id}/audios")
    fun findSong(
        @PathVariable("id") songId: String,
        @RequestParam("file") file: MultipartFile,
        @RequestBody payload: UploadAudioRequestPayload): ResponseEntity<Unit> {

        return ResponseEntity.ok(uploadAudioUseCase.upload(songId, payload, file))
    }
}