// Blocker.java
// Subclass of GameElement customized for the Blocker
package com.s15752.Game

class Blocker // constructor
(view: CannonView?, color: Int, // returns the miss penalty for this Blocker
 val missPenalty // the miss penalty for this Blocker
 : Int, x: Int,
 y: Int, width: Int, length: Int, velocityY: Float) : GameElement(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length,
        velocityY)