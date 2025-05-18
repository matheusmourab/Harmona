package com.harmona.common.repository

import com.harmona.common.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoryRepository: JpaRepository<Category, UUID>