// MainActivity.java
// MainActivity displays the MainActivityFragment
package com.s15752.Game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.s15752.R

class GameActivity : AppCompatActivity() {
    // called when the app first launches
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
    }
}