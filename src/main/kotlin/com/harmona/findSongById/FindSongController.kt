package com.harmona.findSongById

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/songs")
class FindSongController(
    val findSongUseCase: FindSongUseCase
) {
    @GetMapping("/{id}")
    fun findSong(@PathVariable("id") id: String): ResponseEntity<FindSongResponsePayload> {
        return ResponseEntity.ok(findSongUseCase.find(id))
    }
}