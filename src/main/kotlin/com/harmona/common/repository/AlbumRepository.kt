package com.harmona.common.repository

import com.harmona.common.entity.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AlbumRepository: JpaRepository<Album, UUID>