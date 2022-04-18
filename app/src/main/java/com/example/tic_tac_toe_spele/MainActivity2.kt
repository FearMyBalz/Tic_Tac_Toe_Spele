package com.example.tic_tac_toe_spele

import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList

lateinit var b0 : Button
lateinit var b1 : Button
lateinit var b2 : Button
lateinit var b3 : Button
lateinit var b4 : Button
lateinit var b5 : Button
lateinit var b6 : Button
lateinit var b7 : Button
lateinit var b8 : Button

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionBar2 = supportActionBar

        actionBar2!!.title = "Tic_Tac_Toe_Spele"

        actionBar2.setDisplayHomeAsUpEnabled(true)

        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
    }

    fun buClick( view: View) {

        val buSelected = view as Button

        var cellId = 0
        when (buSelected.id) {
            R.id.b0 -> cellId = 1
            R.id.b1 -> cellId = 2
            R.id.b2 -> cellId = 3
            R.id.b3 -> cellId = 4
            R.id.b4 -> cellId = 5
            R.id.b5 -> cellId = 6
            R.id.b6 -> cellId = 7
            R.id.b7 -> cellId = 8
            R.id.b8 -> cellId = 9
        }

        playGame(cellId, buSelected)

    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var count = 0

    fun playGame(cellId:Int, buSelected:Button) {

        if (activePlayer == 1 && count < 9) {
            buSelected.text = "X"
            buSelected.backgroundTintList = getColorStateList(R.color.black)
            buSelected.setTextColor(Color.WHITE)
            player1.add(cellId)
            activePlayer = 2
            count++
            autoPlay()

        } else if(activePlayer == 2 && count < 9) {

            buSelected.text = "0"
            buSelected.backgroundTintList = getColorStateList(R.color.black)
            buSelected.setTextColor(Color.WHITE)
            player2.add(cellId)
            activePlayer = 1
            count++
        }

        buSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {

        var winner = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner == 1) {
            showMessage("Player-1 is Winner")
        } else if (winner == 2) {
            showMessage("Computer is Winner")
        } else if (count == 9) {
            showMessage("It's a Draw!")
        }

    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe")
            .setPositiveButton(
                "Return to main menu",
                DialogInterface.OnClickListener { dialog, which ->
                    finish()
                })
            .show()

    }

    fun autoPlay(){
        if (count < 9){

        var emptyCells = ArrayList<Int>()

        for(cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var buSelected:Button?
        buSelected = when(cellId){
            1-> b0
            2-> b1
            3-> b2
            4-> b3
            5-> b4
            6-> b5
            7-> b6
            8-> b7
            9-> b8
            else -> { b0}
        }

        playGame(cellId, buSelected)
        }
    }
}
