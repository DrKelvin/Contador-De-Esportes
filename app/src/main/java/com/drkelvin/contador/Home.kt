package com.drkelvin.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Esconder o tittle name
        supportActionBar?.hide()

        // Esconder a barra de notificações e deixar em fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var pointsTeamOne: Int = 0
        var pointsTeamTwo: Int = 0

        val buttonTeamOne = findViewById<Button>(R.id.buttonTeamOne)
        val buttonTeamTwo = findViewById<Button>(R.id.buttonTeamTwo)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        buttonTeamOne.setOnClickListener{
            pointsTeamOne ++
            updatePointTeamOne(buttonTeamOne, pointsTeamOne)
        }

        buttonTeamTwo.setOnClickListener{
            pointsTeamTwo ++
            updatePointTeamTwo(buttonTeamTwo, pointsTeamTwo)
        }

        buttonTeamOne.setOnLongClickListener{
            if (pointsTeamOne > 0 ){
                pointsTeamOne --
                updatePointTeamOne(buttonTeamOne, pointsTeamOne)
            }else{
                pointsTeamOne
                updatePointTeamOne(buttonTeamOne, pointsTeamOne)
            }
        }

        buttonTeamTwo.setOnLongClickListener{
            if (pointsTeamTwo > 0 ){
                pointsTeamTwo --
                updatePointTeamTwo(buttonTeamTwo, pointsTeamTwo)
            }else{
                pointsTeamTwo
                updatePointTeamTwo(buttonTeamTwo, pointsTeamTwo)
            }
        }

        buttonReset.setOnClickListener{
            pointsTeamOne = 0
            pointsTeamTwo = 0
            resetPoints(buttonTeamOne, buttonTeamTwo,pointsTeamOne, pointsTeamTwo)
        }
    }

    private fun updatePointTeamOne(button: Button, points: Int): Boolean {
        button.text = points.toString()
        return true
    }

    private fun updatePointTeamTwo(button: Button, points: Int): Boolean {
        button.text = points.toString()
        return true
    }

    private fun resetPoints(buttonOne: Button, buttonTwo: Button, pointsOne: Int, pointsTwo: Int){
        buttonOne.text = pointsOne.toString()
        buttonTwo.text = pointsTwo.toString()
    }
}
