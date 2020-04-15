// GameElement.java
// Represents a rectangle-bounded game element
package com.s15752.Game

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

open class GameElement(// the view that contains this GameElement
        protected var view: CannonView?, color: Int, soundId: Int, x: Int,
        y: Int, width: Int, length: Int, velocityY: Float) {
    protected var paint = Paint() // Paint to draw this GameElement
    var shape // the GameElement's rectangular bounds
            : Rect
    private var velocityY // the vertical velocity of this GameElement
            : Float
    private val soundId // the sound associated with this GameElement
            : Int

    // update GameElement position and check for wall collisions
    open fun update(interval: Double) { // update vertical position
        shape.offset(0, (velocityY * interval).toInt())
        // if this GameElement collides with the wall, reverse direction
        if (shape.top < 0 && velocityY < 0 ||
                shape.bottom > view!!.screenHeight && velocityY > 0) velocityY *= -1f // reverse this GameElement's velocity
    }

    // draws this GameElement on the given Canvas
    open fun draw(canvas: Canvas) {
        canvas.drawRect(shape, paint)
    }

    // plays the sound that corresponds to this type of GameElement
    fun playSound() {
        view!!.playSound(soundId)
    }

    // public constructor
    init {
        paint.color = color
        shape = Rect(x, y, x + width, y + length) // set bounds
        this.soundId = soundId
        this.velocityY = velocityY
    }
}