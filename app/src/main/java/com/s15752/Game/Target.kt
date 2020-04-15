// Target.java
// Subclass of GameElement customized for the Target
package com.s15752.Game

class Target // constructor
(view: CannonView?, color: Int, // returns the hit reward for this Target
 val hitReward // the hit reward for this target
 : Int, x: Int, y: Int,
 width: Int, length: Int, velocityY: Float) : GameElement(view!!, color, CannonView.TARGET_SOUND_ID, x, y, width, length,
        velocityY)