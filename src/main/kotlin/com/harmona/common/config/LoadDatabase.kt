package com.harmona.common.config

import com.harmona.common.entity.Album
import com.harmona.common.entity.Artist
import com.harmona.common.entity.ArtistSong
import com.harmona.common.entity.Audio
import com.harmona.common.entity.Note
import com.harmona.common.entity.Song
import com.harmona.common.entity.Voice
import com.harmona.common.repository.ArtistRepository
import com.harmona.common.repository.SongRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class LoadDatabase {
    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    @Bean
    fun initDatabase(songRepository: SongRepository, artistRepository: ArtistRepository): CommandLineRunner {
        return CommandLineRunner { _: Array<String?>? ->
            log.info("Preloading database")

            artistRepository.deleteAll()
            songRepository.deleteAll()

            var artist = artistRepository.save(Artist("Projeto Sola", "https://scontent-gig4-1.xx.fbcdn.net/v/t1.6435-9/65071963_2646356358716090_1855653307570192384_n.png?_nc_cat=100&ccb=1-7&_nc_sid=a5f93a&_nc_eui2=AeERwSPn-qvvIg-MRkCJ-hlkB_jPrnoeuTEH-M-ueh65MZ9Fyr-h_mCRFYBA2w-X4Jo&_nc_ohc=G4DDRTqdQzwQ7kNvgG9FPDc&_nc_oc=AdlImdcJPnkngjP8wcKbVUMm2rzozFrpiwxRl24UxRozz1ipTRhg94_m7SPSXJ6rCoU&_nc_zt=23&_nc_ht=scontent-gig4-1.xx&_nc_gid=Xy_09r3LGeDVYhzRUXkmHA&oh=00_AYGUUZ9rL9yqLZKpAAGyZ1tZgCzKVAfHwk4wQ1Hym2T4lw&oe=68023FD5"))
            var song = Song("Colossensses 1",
                "Ele é a imagem do Deus invisível\n" +
                "Ele é Senhor sobre a criação\n" +
                "\n" +
                "Pois, Nele foram criadas\n" +
                "Todas as coisas nos céus e na terra\n" +
                "Sejam tronos, soberanias\n" +
                "Poderes ou autoridades\n" +
                "Ele é antes de tudo\n" +
                "E a todos sustenta pela Palavra\n" +
                "Pois, foi do agrado de Deus\n" +
                "Que em tudo Ele tenha\n" +
                "Supremacia\n" +
                "\n" +
                "Ele é o resplendor da glória do Pai\n" +
                "Ele é a exata expressão do seu ser\n" +
                "\n" +
                "Pois, Nele foram criadas\n" +
                "Todas as coisas nos céus e na terra\n" +
                "Sejam tronos, soberanias\n" +
                "Poderes ou autoridades\n" +
                "Ele é antes de tudo\n" +
                "E a todos sustenta pela Palavra\n" +
                "Pois, foi do agrado de Deus\n" +
                "Que em tudo Ele tenha\n" +
                "Supremacia\n" +
                "\n" +
                "Já não há mais nada\n" +
                "Que a Ele não pertença\n" +
                "Em tudo existe graça\n" +
                "Cantemos, sim\n" +
                "\n" +
                "Já não há mais nada\n" +
                "Que a Ele não pertença\n" +
                "Em tudo existe graça\n" +
                "Cantemos, sim",
                null,
                Album("500"),
                setOf(Audio("1", Voice.CONTRALTO, Note.DO), Audio("2", Voice.CONTRALTO, Note.DO_SUS), Audio("3", Voice.CONTRALTO, Note.RE), Audio("4", Voice.CONTRALTO, Note.RE_SUS), Audio("5", Voice.CONTRALTO, Note.MI), Audio("6", Voice.CONTRALTO, Note.FA), Audio("7", Voice.CONTRALTO, Note.FA_SUS), Audio("8", Voice.CONTRALTO, Note.SOL), Audio("9", Voice.CONTRALTO, Note.SOL_SUS), Audio("10", Voice.CONTRALTO, Note.LA), Audio("11", Voice.CONTRALTO, Note.LA_SUS), Audio("12", Voice.CONTRALTO, Note.SI),
                Audio("1", Voice.SOPRANO, Note.DO), Audio("2", Voice.SOPRANO, Note.DO_SUS), Audio("3", Voice.SOPRANO, Note.RE), Audio("4", Voice.SOPRANO, Note.RE_SUS), Audio("5", Voice.SOPRANO, Note.MI), Audio("6", Voice.SOPRANO, Note.FA), Audio("7", Voice.SOPRANO, Note.FA_SUS), Audio("8", Voice.SOPRANO, Note.SOL), Audio("9", Voice.SOPRANO, Note.SOL_SUS), Audio("10", Voice.SOPRANO, Note.LA), Audio("11", Voice.SOPRANO, Note.LA_SUS), Audio("12", Voice.SOPRANO, Note.SI),
                Audio("1", Voice.TENOR, Note.DO), Audio("2", Voice.TENOR, Note.DO_SUS), Audio("3", Voice.TENOR, Note.RE), Audio("4", Voice.TENOR, Note.RE_SUS), Audio("5", Voice.TENOR, Note.MI), Audio("6", Voice.TENOR, Note.FA), Audio("7", Voice.TENOR, Note.FA_SUS), Audio("8", Voice.TENOR, Note.SOL), Audio("9", Voice.TENOR, Note.SOL_SUS), Audio("10", Voice.TENOR, Note.LA), Audio("11", Voice.TENOR, Note.LA_SUS), Audio("12", Voice.TENOR, Note.SI),
                Audio("1", Voice.TODAS, Note.DO), Audio("2", Voice.TODAS, Note.DO_SUS), Audio("3", Voice.TODAS, Note.RE), Audio("4", Voice.TODAS, Note.RE_SUS), Audio("5", Voice.TODAS, Note.MI), Audio("6", Voice.TODAS, Note.FA), Audio("7", Voice.TODAS, Note.FA_SUS), Audio("8", Voice.TODAS, Note.SOL), Audio("9", Voice.TODAS, Note.SOL_SUS), Audio("10", Voice.TODAS, Note.LA), Audio("11", Voice.TODAS, Note.LA_SUS), Audio("12", Voice.TODAS, Note.SI)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Sempre Em Frente", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("126", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Confissões", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("23", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Ressurreição", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Filho De Deus", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Canção De Um Certo Pedro", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Maria", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Das Trevas À Luz", null, null, Album("500"), setOf(Audio("123", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)

            artist = artistRepository.save(Artist("Oficina G3", "https://scontent-gig4-1.xx.fbcdn.net/v/t39.30808-6/453203080_1070093867812052_4932871516972843467_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeGtdBQVtsiQT7HgPyKSCJBVBsy4DmdGlQUGzLgOZ0aVBTiStCnlzYSnbdqXiajTzeo&_nc_ohc=Yih5IpVMM2sQ7kNvgHjh808&_nc_oc=Adll-S_VCcDtn3KrKBsEO1Beb7EkN00B14dQKPcEGqh579p_Y6aGaqSWU7UkpDEyUVU&_nc_zt=23&_nc_ht=scontent-gig4-1.xx&_nc_gid=CWpY_CgR3raqgezirPt_CQ&oh=00_AYGsknENKjKCE_5igP24s8O0BgoPclX-454NARTOKqGLPg&oe=67E0987C"))
            song = Song("Incondicional", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("D.A.G.", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Meus Próprios Meios", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Eu Sou", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Meus Passos", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Continuar", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("De Joelhos", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Tua Mão", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Muros", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Depois da Guerra", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("A Ele", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Obediência", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Better", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("People Get Ready", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
            song = Song("Inconditional", null, null, Album("DDG"), setOf(Audio("321", Voice.CONTRALTO, Note.FA)))
            song.songArtists = setOf(ArtistSong(artist, song))
            songRepository.save(song)
        }
    }
}