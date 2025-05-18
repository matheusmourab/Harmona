package com.harmona.common.useCase

import com.harmona.common.config.LoadDatabase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UploadFileAwsUseCase(

): UploadFileUseCase {
    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    override fun upload(file: MultipartFile, name: String): String {
        log.info("Uploading file to S3: {}", name)

        val url = "file_url"

        log.info("Upload file to S3 completed. name: {}, url: {}", name, url)
        return url
    }
}