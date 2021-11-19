package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var firstPlayerArray = ArrayList<Int>()
    private var secondPlayerArray = ArrayList<Int>()


    private lateinit var player1tv: TextView
    private lateinit var player2tv: TextView
    private var firstPlayerPoints = 0
    private var secondPlayerPoints = 0

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetScoreBtn: Button
    private lateinit var resetButton: Button

    private var winnerPlayer = 0
    private var playerSwitch = 0
    private var roundPlayed = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        player1tv = findViewById(R.id.PlayerOneTV)
        player2tv = findViewById(R.id.PlayerTwoTV)

        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)
        resetScoreBtn = findViewById(R.id.restartScoreButton)
        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resetScoreBtn.setOnClickListener(this)
        resetButton.setOnClickListener(this)

    }


    override fun onClick(clickedView: View?) {

        if( clickedView is Button){

            var buttonNumber = 0

            when(clickedView.id){
                R.id.btn1 -> buttonNumber = 1
                R.id.btn2 -> buttonNumber = 2
                R.id.btn3 -> buttonNumber = 3
                R.id.btn4 -> buttonNumber = 4
                R.id.btn5 -> buttonNumber = 5
                R.id.btn6 -> buttonNumber = 6
                R.id.btn7 -> buttonNumber = 7
                R.id.btn8 -> buttonNumber = 8
                R.id.btn9 -> buttonNumber = 9
                R.id.resetButton -> resetGame()
                R.id.restartScoreButton -> resetScore()

            }

            if(buttonNumber != 0){
                playGame(clickedView,buttonNumber)
            }

        }

    }



    private fun playGame(clickedView: Button,buttonNumber: Int) {

        if(playerSwitch == 0){
            clickedView.text = "X"
            clickedView.textSize = 35F
            playerSwitch = 1
            firstPlayerArray.add(buttonNumber)
            roundPlayed+=1
        }else{
            clickedView.text = "O"
            clickedView.textSize = 35F
            playerSwitch = 0
            secondPlayerArray.add(buttonNumber)
            roundPlayed+=1
        }
        clickedView.isEnabled = false
        checkWinner()


    }

    private fun resetScore(){
        player1tv.text = "First Player: 0"
        player2tv.text = "Second Player: 0"
        firstPlayerPoints = 0
        secondPlayerPoints = 0
        resetGame()
    }

    private fun resetGame() {

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        firstPlayerArray.clear()
        secondPlayerArray.clear()
        winnerPlayer = 0
        roundPlayed = 0

        playerSwitch = 0

        enableButtons()

    }

    private fun disableButtons(){

        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }

    private fun enableButtons(){

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

    }




    private fun checkWinner() {


        if (firstPlayerArray.contains(1) && firstPlayerArray.contains(2) && firstPlayerArray.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(1) && secondPlayerArray.contains(2) && secondPlayerArray.contains(3)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(4) && firstPlayerArray.contains(5) && firstPlayerArray.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(4) && secondPlayerArray.contains(5) && secondPlayerArray.contains(6)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(7) && firstPlayerArray.contains(8) && firstPlayerArray.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(7) && secondPlayerArray.contains(8) && secondPlayerArray.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(1) && firstPlayerArray.contains(4) && firstPlayerArray.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(1) && secondPlayerArray.contains(4) && secondPlayerArray.contains(7)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(2) && firstPlayerArray.contains(5) && firstPlayerArray.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(2) && secondPlayerArray.contains(5) && secondPlayerArray.contains(8)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(3) && firstPlayerArray.contains(6) && firstPlayerArray.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(3) && secondPlayerArray.contains(6) && secondPlayerArray.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(1) && firstPlayerArray.contains(5) && firstPlayerArray.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(1) && secondPlayerArray.contains(5) && secondPlayerArray.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayerArray.contains(3) && firstPlayerArray.contains(5) && firstPlayerArray.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayerArray.contains(3) && secondPlayerArray.contains(5) && secondPlayerArray.contains(7)){
            winnerPlayer = 2
        }

        if(winnerPlayer == 1){
            Toast.makeText(this, "winner is first player", Toast.LENGTH_SHORT).show()
            firstPlayerPoints+=1
            player1tv.text = "First Player: ${firstPlayerPoints}"
            disableButtons()

        }else if (winnerPlayer == 2){
            Toast.makeText(this, "winer is second player", Toast.LENGTH_SHORT).show()
            secondPlayerPoints+=1
            player2tv.text = "Second Player: ${secondPlayerPoints}"
            disableButtons()

        }else if(roundPlayed == 9){
            Toast.makeText(this, "tamashi morcha fred", Toast.LENGTH_SHORT).show()
            disableButtons()
        }

    }


}