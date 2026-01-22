package com.example.garcialovilloalberto_practica3.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.garcialovilloalberto_practica3.R
import kotlin.to

/**
 * Representa un par de recursos compuesto por una imagen y un texto.
 *
 * Se utiliza para modelar elementos visuales que requieren un drawable y una cadena asociada, como
 * tarjetas o listas de Pokemon.
 *
 * @property drawable Recurso drawable que representa la imagen.
 * @property text Recurso de string que representa el texto asociado.
 *
 */
data class DrawableStringPair(
    @DrawableRes val drawable: Int, @StringRes val text: Int
)


/**
 * Lista de Pokemon ordenados alfabéticamente.
 *
 * Cada elemento contiene el recurso de imagen del Pokemon y su nombre, utilizada principalmente
 * para vistas que requieren un orden alfabético.
 *
 */
val pokemonDataAlphabetical = listOf(
    R.drawable.blastoise to R.string.blastoise,
    R.drawable.blaziken to R.string.blaziken,
    R.drawable.charizard to R.string.charizard,
    R.drawable.chesnaught to R.string.chesnaught,
    R.drawable.cinderace to R.string.cinderace,
    R.drawable.decidueye to R.string.decidueye,
    R.drawable.delphox to R.string.delphox,
    R.drawable.emboar to R.string.emboar,
    R.drawable.empoleon to R.string.empoleon,
    R.drawable.feraligatr to R.string.feraligatr,
    R.drawable.greninja to R.string.greninja,
    R.drawable.incineroar to R.string.incineroar,
    R.drawable.infernape to R.string.infernape,
    R.drawable.inteleon to R.string.inteleon,
    R.drawable.meganium to R.string.meganium,
    R.drawable.meowscarada to R.string.meowscarada,
    R.drawable.primarina to R.string.primarina,
    R.drawable.quaquaval to R.string.quaquaval,
    R.drawable.rillaboom to R.string.rillaboom,
    R.drawable.samurott to R.string.samurott,
    R.drawable.sceptile to R.string.sceptile,
    R.drawable.serperior to R.string.serperior,
    R.drawable.skeledirge to R.string.skeledirge,
    R.drawable.swampert to R.string.swampert,
    R.drawable.torterra to R.string.torterra,
    R.drawable.typhlosion to R.string.typhlosion,
    R.drawable.venusaur to R.string.venusaur,
).map { DrawableStringPair(it.first, it.second) }


/**
 * Lista de Pokemon organizados por generación.
 *
 * El orden de los elementos sigue la secuencia de las generaciones de Pokemon.
 *
 */
val pokemonDataGenerational = listOf(
    R.drawable.venusaur to R.string.venusaur,
    R.drawable.charizard to R.string.charizard,
    R.drawable.blastoise to R.string.blastoise,
    R.drawable.meganium to R.string.meganium,
    R.drawable.typhlosion to R.string.typhlosion,
    R.drawable.feraligatr to R.string.feraligatr,
    R.drawable.sceptile to R.string.sceptile,
    R.drawable.blaziken to R.string.blaziken,
    R.drawable.swampert to R.string.swampert,
    R.drawable.torterra to R.string.torterra,
    R.drawable.infernape to R.string.infernape,
    R.drawable.empoleon to R.string.empoleon,
    R.drawable.serperior to R.string.serperior,
    R.drawable.emboar to R.string.emboar,
    R.drawable.samurott to R.string.samurott,
    R.drawable.chesnaught to R.string.chesnaught,
    R.drawable.delphox to R.string.delphox,
    R.drawable.greninja to R.string.greninja,
    R.drawable.decidueye to R.string.decidueye,
    R.drawable.incineroar to R.string.incineroar,
    R.drawable.primarina to R.string.primarina,
    R.drawable.rillaboom to R.string.rillaboom,
    R.drawable.cinderace to R.string.cinderace,
    R.drawable.inteleon to R.string.inteleon,
    R.drawable.meowscarada to R.string.meowscarada,
    R.drawable.skeledirge to R.string.skeledirge,
    R.drawable.quaquaval to R.string.quaquaval,
).map { DrawableStringPair(it.first, it.second) }

/**
 * Colección de Pokemon favoritos.
 *
 * Contiene una selección reducida de Pokemon destacados, utilizada
 * para secciones de favoritos o colecciones especiales.
 *
 */
val favoriteCollectionData = listOf(
    R.drawable.venusaur to R.string.venusaur,
    R.drawable.typhlosion to R.string.typhlosion,
    R.drawable.swampert to R.string.swampert,
    R.drawable.torterra to R.string.torterra,
    R.drawable.serperior to R.string.serperior,
    R.drawable.delphox to R.string.delphox,
    R.drawable.decidueye to R.string.decidueye,
    R.drawable.cinderace to R.string.cinderace,
    R.drawable.skeledirge to R.string.skeledirge,
    ).map { DrawableStringPair(it.first, it.second) }