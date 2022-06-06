package com.daffa.mynewstarwarsapp.core.utils

object Utils {
    fun generateImagePathFilm(title:String):String{
        return when(title){
            "A New Hope" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aO9yUpTu5PKy75FOP8cFBAoH6jr.jpg"
            "The Empire Strikes Back" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u9yVRKbdVg7xJGzT2rTm4VZzgVw.jpg"
            "Return of The Jedi" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mDCBQNhR6R0PVFucJl0O4Hp5klZ.jpg"
            "The Phantom Menace" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6wkfovpn7Eq8dYNKaG5PY3q2oq6.jpg"
            "Attack of The Clones" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/oZNPzxqM2s5DyVWab09NTQScDQt.jpg"
            "Revenge of the Sith" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xfSAoBEm9MNBjmlNcDYLvLSMlnq.jpg"
            else -> ""
        }
    }
}