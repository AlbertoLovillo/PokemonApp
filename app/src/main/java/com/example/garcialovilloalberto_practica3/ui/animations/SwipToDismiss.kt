package com.example.garcialovilloalberto_practica3.ui.animations

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.verticalDrag
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

/**
 * Extensión de [Modifier] que permite descartar un elemento con un gesto de deslizamiento vertical.
 *
 * Esta función capta gestos de deslizamiento vertical, calculando la velocidad del desplazamiento y
 * animando la pantalla hacia arriba. Si el deslizamiento alcanza suficiente velocidad o distancia,
 * se ejecuta [onDismissed].
 *
 * Características principales:
 * - Solo permite el deslizamiento hacia arriba.
 * - Utiliza [Animatable] para controlar el offset vertical de la vista.
 * - Calcula la posición final con [splineBasedDecay] para una animación más natural.
 * - Soporta animacion de retroceso si no se alcanza la velocidad/distancia mínima.
 *
 * @param onDismissed Lambda que se ejecuta cuando el elemento ha sido deslizado y descartado.
 *
 * @return [Modifier] que aplica el comportamiento de deslizamiento al elemento.
 */
@SuppressLint("ReturnFromAwaitPointerEventScope", "MultipleAwaitPointerEventScopes")
fun Modifier.swipeToDismiss(
    onDismissed: () -> Unit
): Modifier = composed {
    // This Animatable stores the vertical offset for the element.
    val offsetY = remember { Animatable(0f) }
    pointerInput(Unit) {
        // Used to calculate a settling position of a fling animation.
        val decay = splineBasedDecay<Float>(this)
        // Wrap in a coroutine scope to use suspend functions for touch events and animation.
        coroutineScope {
            while (true) {
                // Wait for a touch down event.
                val pointerId = awaitPointerEventScope { awaitFirstDown().id }
                // Interrupt any ongoing animation.
                offsetY.stop()
                // Prepare for drag events and record velocity of a fling.
                val velocityTracker = VelocityTracker()
                // Wait for drag events.
                awaitPointerEventScope {
                    verticalDrag(pointerId) { change ->
                        // Solo aceptar movimiento hacia arriba (negativo)
                        val dragDelta = change.positionChange().y
                        if (dragDelta < 0) {  // Solo hacia arriba
                            val verticalDragOffset = offsetY.value + dragDelta
                            launch {
                                offsetY.snapTo(verticalDragOffset)
                            }
                            velocityTracker.addPosition(change.uptimeMillis, change. position)
                            if (change.positionChange() != Offset.Zero) change.consume()
                        }
                    }
                }
                // Dragging finished.  Calculate the velocity of the fling.
                val velocity = velocityTracker.calculateVelocity().y
                // Calculate where the element eventually settles after the fling animation.
                val targetOffsetY = decay.calculateTargetValue(offsetY.value, velocity)
                // The animation should end as soon as it reaches these bounds.
                offsetY.updateBounds(
                    lowerBound = -size.height. toFloat(),
                    upperBound = 0f
                )
                launch {
                    if (targetOffsetY.absoluteValue <= size.height) {
                        // Not enough velocity; Slide back to the default position.
                        offsetY.animateTo(targetValue = 0f, initialVelocity = velocity)
                    } else {
                        // Enough velocity to slide away the element to the edge.
                        offsetY.animateDecay(velocity, decay)
                        // The element was swiped away.
                        onDismissed()
                    }
                }
            }
        }
    }
        // Apply the vertical offset to the element.
        .offset { IntOffset(0, offsetY.value. roundToInt()) }
}