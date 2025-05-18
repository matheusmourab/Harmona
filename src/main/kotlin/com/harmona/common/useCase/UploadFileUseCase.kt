package com.harmona.common.useCase

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface UploadFileUseCase {
    fun upload(file: MultipartFile, name: String): String
}