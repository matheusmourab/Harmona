package com.harmona.searchSongByName

import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/songs")
class SeachSongController (
    val searchSongUseCase: SearchSongUseCase
) {
    @GetMapping
    fun searchSong(@RequestParam(name = "search", defaultValue = "") search: String,
                   @RequestParam(name = "page", defaultValue = "0") page: Int,
                   @RequestParam(name = "size", defaultValue = "20") size: Int): ResponseEntity<SearchSongResponsePayload> {
        return ResponseEntity.ok(searchSongUseCase.search(search, PageRequest.of(page, size)))
    }
}