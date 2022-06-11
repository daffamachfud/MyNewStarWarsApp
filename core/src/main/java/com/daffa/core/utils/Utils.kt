package com.daffa.core.utils

object Utils {
    fun generateImagePathFilm(title:String):String{
        return when(title){
            "A New Hope" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aO9yUpTu5PKy75FOP8cFBAoH6jr.jpg"
            "The Empire Strikes Back" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u9yVRKbdVg7xJGzT2rTm4VZzgVw.jpg"
            "Return of the Jedi" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mDCBQNhR6R0PVFucJl0O4Hp5klZ.jpg"
            "The Phantom Menace" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6wkfovpn7Eq8dYNKaG5PY3q2oq6.jpg"
            "Attack of the Clones" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/oZNPzxqM2s5DyVWab09NTQScDQt.jpg"
            "Revenge of the Sith" -> "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xfSAoBEm9MNBjmlNcDYLvLSMlnq.jpg"
            "The Force Awakens" -> " "
            else -> ""
        }
    }

    fun generateImagePathPeople(name:String):String{
        return when(name){
            "Luke Skywalker"-> "https://lumiere-a.akamaihd.net/v1/images/luke-skywalker-main_5a38c454_461eebf5.jpeg?region=0%2C0%2C1536%2C864&width=768"
            "C-3PO"-> "https://lumiere-a.akamaihd.net/v1/images/c-3po-main_417a2902.jpeg?region=176%2C0%2C951%2C536&width=768"
            "R2-D2"-> "https://lumiere-a.akamaihd.net/v1/images/r2-d2-main_042e8d4f.jpeg?region=338%2C0%2C942%2C531&width=768"
            "Dart Vader"-> "https://lumiere-a.akamaihd.net/v1/images/Darth-Vader_6bda9114.jpeg?region=0%2C23%2C1400%2C785&width=768"
            "Leia Organa"-> "https://lumiere-a.akamaihd.net/v1/images/leia-organa-feature-image_d0f5e953.jpeg?region=0%2C0%2C1280%2C720&width=768"
            "Owen Lars"-> "https://lumiere-a.akamaihd.net/v1/images/databank_owenlars_01_169_effce0f8.jpeg?region=0%2C0%2C1560%2C878&width=768"
            "Beru White Sun lars"-> "https://lumiere-a.akamaihd.net/v1/images/databank_berulars_01_169_68101518.jpeg?region=0%2C0%2C1560%2C878&width=768"
            "R5-D4"-> "https://lumiere-a.akamaihd.net/v1/images/r5-d4_main_image_7d5f078e.jpeg?region=374%2C0%2C1186%2C666&width=768"
            "Biggs Darklighter"-> "https://lumiere-a.akamaihd.net/v1/images/image_606ff7f7.jpeg?region=0%2C0%2C1560%2C878&width=768"
            "Obi-Wan Kenobi"-> "https://lumiere-a.akamaihd.net/v1/images/Obi-Wan-Kenobi_6d775533.jpeg?region=0%2C0%2C1536%2C864&width=768"
            else -> ""
        }
    }

    fun generateImagePathStarship(name:String):String{
        return when(name){
            "CR90 Corvette" -> "https://vignette.wikia.nocookie.net/starwars/images/2/24/TantiveIV-TSWB.png/revision/latest/scale-to-width-down/500?cb=20201021033048"
            "Star Destroyer" -> "https://lumiere-a.akamaihd.net/v1/images/databank_superstardestroyer_01_169_d5757b90.jpeg?region=0%2C0%2C1560%2C878&width=768"
            "Sentinel-class landing craft" -> "https://vignette.wikia.nocookie.net/starwars/images/5/5b/Imperial_Sentinel-class_shuttle.png/revision/latest/scale-to-width-down/500?cb=20161008235432"
            "Death Star" -> "https://lumiere-a.akamaihd.net/v1/images/Death-Star-I-copy_36ad2500.jpeg?region=0%2C0%2C1600%2C900&width=768"
            "Millennium Falcon" -> "https://lumiere-a.akamaihd.net/v1/images/millennium-falcon-main-tlj-a_7cf89d3a.jpeg?region=0%2C0%2C1280%2C720&width=768"
            "Y-wing" -> "https://lumiere-a.akamaihd.net/v1/images/Y-Wing-Fighter_0e78c9ae.jpeg?region=0%2C0%2C1536%2C864&width=768"
            "X-wing" -> "https://lumiere-a.akamaihd.net/v1/images/X-Wing-Fighter_47c7c342.jpeg?region=0%2C1%2C1536%2C864&width=768"
            "TIE Advanced x1" -> "https://vignette.wikia.nocookie.net/starwars/images/1/1d/Vader_TIEAdvanced_SWB.png/revision/latest/scale-to-width-down/500?cb=20160915042032"
            "Executor" -> "https://lumiere-a.akamaihd.net/v1/images/databank_executor_01_169_8157df82.jpeg?region=57%2C0%2C1503%2C845&width=768"
            "Rebel Transport" -> "https://lumiere-a.akamaihd.net/v1/images/gr-75-medium-transport_cd04862d.jpeg?region=15%2C0%2C770%2C433&width=768"
            else -> ""
        }
    }
}