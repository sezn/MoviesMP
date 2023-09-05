package com.szn.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val adult: Boolean = false,
    val backdrop_path: String?,
    val genre_ids: List<Int>? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val video: Boolean = true,
    val vote_average: Double = 0.0,
    val vote_count: Int? = 0,
    val genres: List<Genre>? = null,
    val runtime: Int? = null
) {
    fun getGenders(): List<String> {
        val genders = mutableListOf<String>()
        genres?.forEach {
            genders.add(it.name)
        }
        return genders
    }
}

data class Genre(
    val id: Int,
    val name: String
)

val fakeMovie = Movie(id= 0,
    title = "Les minions, il était une fois GRU",
//    genres = mutableListOf("Test, Action", "Foot")
    description = "Alors que les années 70 battent leur plein, Gru qui grandit en banlieue au milieu des jeans à pattes d’éléphants et des chevelures en fleur, met sur pied un plan machiavélique à souhait pour réussir à intégrer un groupe célèbre de super méchants, connu sous le nom de Vicious 6, dont il est le plus grand fan. Il est secondé dans sa tâche par les Minions, ses petits compagnons aussi turbulents que fidèles. Avec l’aide de Kevin, Stuart, Bob et Otto – un nouveau Minion arborant un magnifique appareil dentaire et un besoin désespéré de plaire - ils vont déployer ensemble des trésors d’ingéniosité afin de construire leur premier repaire, expérimenter leurs premières armes, et lancer leur première mission. Lorsque les Vicious 6 limogent leur chef, le légendaire \" Wild Knuckles \", Gru passe l’audition pour intégrer l’équipe. Le moins qu’on puisse dire c’est que l’entrevue tourne mal, et soudain court quand Gru leur démontre sa supériorité et se retrouve soudain leur ennemi juré.",
    poster_path = "https://image.tmdb.org/t/p/w500/qsGrZgwOs8B6Jqen0ECBJ6UgfEG.jpg",
    backdrop_path = "https://image.tmdb.org/t/p/w500/nmGWzTLMXy9x7mKd8NKPLmHtWGa.jpg",
    release_date = "2022-06-11",
    runtime = 102
)
