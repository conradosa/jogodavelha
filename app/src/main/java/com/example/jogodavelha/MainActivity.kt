package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b_reset = findViewById<Button>(R.id.b_reset)

        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        val b5 = findViewById<Button>(R.id.b5)
        val b6 = findViewById<Button>(R.id.b6)
        val b7 = findViewById<Button>(R.id.b7)
        val b8 = findViewById<Button>(R.id.b8)
        val b9 = findViewById<Button>(R.id.b9)

        b1.setBackgroundColor(Color.GRAY)
        b2.setBackgroundColor(Color.GRAY)
        b3.setBackgroundColor(Color.GRAY)
        b4.setBackgroundColor(Color.GRAY)
        b5.setBackgroundColor(Color.GRAY)
        b6.setBackgroundColor(Color.GRAY)
        b7.setBackgroundColor(Color.GRAY)
        b8.setBackgroundColor(Color.GRAY)
        b9.setBackgroundColor(Color.GRAY)

        fun resetGame(){

            //Enable
            b1.isEnabled = true
            b2.isEnabled = true
            b3.isEnabled = true
            b4.isEnabled = true
            b5.isEnabled = true
            b6.isEnabled = true
            b7.isEnabled = true
            b8.isEnabled = true
            b9.isEnabled = true

            //Backgrounds
            b1.setBackgroundColor(Color.GRAY)
            b2.setBackgroundColor(Color.GRAY)
            b3.setBackgroundColor(Color.GRAY)
            b4.setBackgroundColor(Color.GRAY)
            b5.setBackgroundColor(Color.GRAY)
            b6.setBackgroundColor(Color.GRAY)
            b7.setBackgroundColor(Color.GRAY)
            b8.setBackgroundColor(Color.GRAY)
            b9.setBackgroundColor(Color.GRAY)

            //Textos
            b1.setText("")
            b2.setText("")
            b3.setText("")
            b4.setText("")
            b5.setText("")
            b6.setText("")
            b7.setText("")
            b8.setText("")
            b9.setText("")

        }

        b_reset.setOnClickListener {
            b_reset.isEnabled = false
            b_reset.isVisible = false
            player1.clear()
            player2.clear()
            resetGame()
        }

    }

    fun btClick(view: View){
        val btSelecionado = view as Button
        var cellID = 0

        when(btSelecionado.id){
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9
        }

        playGame(cellID, btSelecionado)

    }

    //Jogadores
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    //Turnos
    var activePlayer = 1

    fun playGame(cellID:Int, btSelecionado:Button){
        if(activePlayer == 1){
            btSelecionado.text = "X"
            btSelecionado.setTextColor(Color.WHITE)
            btSelecionado.setBackgroundColor(Color.BLUE)
            player1.add(cellID)
            activePlayer = 2
        }else{
            btSelecionado.text = "O"
            btSelecionado.setTextColor(Color.WHITE)
            btSelecionado.setBackgroundColor(Color.RED)
            player2.add(cellID)
            activePlayer = 1
        }
        btSelecionado.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = 0

        //LINHAS

        // linha 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        // linha 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        // linha 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //COLUNAS

        //Coluna 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //Coluna 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //Coluna 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //DIAGONAIS

        //Diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //Diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        //Empate
        if(player1.size == 4 && player2.size == 5 && winner == 0){
            val b1 = findViewById<Button>(R.id.b1)
            val b2 = findViewById<Button>(R.id.b2)
            val b3 = findViewById<Button>(R.id.b3)
            val b4 = findViewById<Button>(R.id.b4)
            val b5 = findViewById<Button>(R.id.b5)
            val b6 = findViewById<Button>(R.id.b6)
            val b7 = findViewById<Button>(R.id.b7)
            val b8 = findViewById<Button>(R.id.b8)
            val b9 = findViewById<Button>(R.id.b9)

            b1.isEnabled = false
            b2.isEnabled = false
            b3.isEnabled = false
            b4.isEnabled = false
            b5.isEnabled = false
            b6.isEnabled = false
            b7.isEnabled = false
            b8.isEnabled = false
            b9.isEnabled = false

            Toast.makeText(this,"Empate!", Toast.LENGTH_SHORT).show()
            val b_reset = findViewById<Button>(R.id.b_reset)
            b_reset.isEnabled = true
            b_reset.isVisible = true
        }
        if(player2.size == 4 && player1.size == 5 && winner == 0){
            val b1 = findViewById<Button>(R.id.b1)
            val b2 = findViewById<Button>(R.id.b2)
            val b3 = findViewById<Button>(R.id.b3)
            val b4 = findViewById<Button>(R.id.b4)
            val b5 = findViewById<Button>(R.id.b5)
            val b6 = findViewById<Button>(R.id.b6)
            val b7 = findViewById<Button>(R.id.b7)
            val b8 = findViewById<Button>(R.id.b8)
            val b9 = findViewById<Button>(R.id.b9)

            b1.isEnabled = false
            b2.isEnabled = false
            b3.isEnabled = false
            b4.isEnabled = false
            b5.isEnabled = false
            b6.isEnabled = false
            b7.isEnabled = false
            b8.isEnabled = false
            b9.isEnabled = false

            Toast.makeText(this,"Empate!", Toast.LENGTH_SHORT).show()
            val b_reset = findViewById<Button>(R.id.b_reset)
            b_reset.isEnabled = true
            b_reset.isVisible = true
        }

        //Winner
        if(winner != 0){
            val b1 = findViewById<Button>(R.id.b1)
            val b2 = findViewById<Button>(R.id.b2)
            val b3 = findViewById<Button>(R.id.b3)
            val b4 = findViewById<Button>(R.id.b4)
            val b5 = findViewById<Button>(R.id.b5)
            val b6 = findViewById<Button>(R.id.b6)
            val b7 = findViewById<Button>(R.id.b7)
            val b8 = findViewById<Button>(R.id.b8)
            val b9 = findViewById<Button>(R.id.b9)

            b1.isEnabled = false
            b2.isEnabled = false
            b3.isEnabled = false
            b4.isEnabled = false
            b5.isEnabled = false
            b6.isEnabled = false
            b7.isEnabled = false
            b8.isEnabled = false
            b9.isEnabled = false

            if(winner == 1){
                Toast.makeText(this,"Jogador 1 ganhou o jogo!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Jogador 2 ganhou o jogo!", Toast.LENGTH_SHORT).show()
            }
            val b_reset = findViewById<Button>(R.id.b_reset)
            b_reset.isEnabled = true
            b_reset.isVisible = true
        }
    }
}