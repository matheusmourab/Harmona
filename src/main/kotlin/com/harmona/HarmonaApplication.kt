package com.harmona

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class HarmonaApplication

fun main(args: Array<String>) {
	runApplication<HarmonaApplication>(*args)
}
