package com.harmona.common.entity

enum class Note(
    val symbol: String,
    val title: String,
) {
    DO("C", "Dó"),
    DO_SUS("C#", "Dó Sustenido"),
    RE("D", "Ré"),
    RE_SUS("D#", "Ré Sustenido"),
    MI("E", "Mi"),
    FA("F", "Fá"),
    FA_SUS("F#", "Fá Sustenido"),
    SOL("G", "Sol"),
    SOL_SUS("G#", "Sol Sustenido"),
    LA("A", "Lá"),
    LA_SUS("A#", "Lá Sustenido"),
    SI("B", "Si")
}
