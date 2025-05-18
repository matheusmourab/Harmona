package com.harmona.common.repository

import com.harmona.common.entity.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ArtistRepository: JpaRepository<Artist, UUID>