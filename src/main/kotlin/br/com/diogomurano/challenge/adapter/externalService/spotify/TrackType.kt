package br.com.diogomurano.challenge.adapter.externalService.spotify

enum class TrackType {

    PARTY {
        override fun matchesWithTemperature(temperature: Int): Boolean = temperature > 30
    },
    POP {
        override fun matchesWithTemperature(temperature: Int): Boolean = temperature in 15..30
    },
    ROCK {
        override fun matchesWithTemperature(temperature: Int): Boolean = temperature in 10..14
    },
    CLASSICAL {
        override fun matchesWithTemperature(temperature: Int): Boolean = temperature < 10
    };

    abstract fun matchesWithTemperature(temperature: Int): Boolean

    companion object {

        fun findByTemperature(temperature: Int): TrackType =
            values().find { it.matchesWithTemperature(temperature) }
                ?: throw IllegalStateException("It was not possible to identify the musical genre to find the tracks")

    }

}