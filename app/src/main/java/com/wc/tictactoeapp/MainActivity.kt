package com.wc.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val playerX = "X"
    private val playerO = "O"

    private var currentOrNextPlayer = ""
    var playerXList = arrayListOf<Int>()
    var playerOList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCell1.setOnClickListener(this)
        btnCell2.setOnClickListener(this)
        btnCell3.setOnClickListener(this)

        btnCell4.setOnClickListener(this)
        btnCell5.setOnClickListener(this)
        btnCell6.setOnClickListener(this)

        btnCell7.setOnClickListener(this)
        btnCell8.setOnClickListener(this)
        btnCell9.setOnClickListener(this)

        btnRestartGame.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnRestartGame -> {
                restartGame()
            }

            // row 1
            btnCell1 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell1, selectedPlayer)
                    addSelectedCellInListforXO(1, selectedPlayer)
                }
            }
            btnCell2 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell2, selectedPlayer)
                    addSelectedCellInListforXO(2, selectedPlayer)
                }
            }
            btnCell3 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell3, selectedPlayer)
                    addSelectedCellInListforXO(3, selectedPlayer)
                }
            }

            // Row 2
            btnCell4 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell4, selectedPlayer)
                    addSelectedCellInListforXO(4, selectedPlayer)
                }
            }
            btnCell5 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell5, selectedPlayer)
                    addSelectedCellInListforXO(5, selectedPlayer)
                }
            }
            btnCell6 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell6, selectedPlayer)
                    addSelectedCellInListforXO(6, selectedPlayer)
                }
            }

            // Row 3
            btnCell7 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell7, selectedPlayer)
                    addSelectedCellInListforXO(7, selectedPlayer)
                }
            }
            btnCell8 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell8, selectedPlayer)
                    addSelectedCellInListforXO(8, selectedPlayer)
                }
            }
            btnCell9 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell9, selectedPlayer)
                    addSelectedCellInListforXO(9, selectedPlayer)
                }
            }

        }
    }

    fun getPlayer(player: String): String? {
        var currentPlayer: String? = null
        // First move in the game or player X
        if (player.isBlank() || player == playerX) {
            currentPlayer = playerX
        }
        if (player == playerO) {
            currentPlayer = playerO
        }
        return currentPlayer
    }

    fun addSelectedCellInListforXO(cellId: Int, selectedPlayer: String) {
        currentOrNextPlayer = if (selectedPlayer == playerX) {
            playerXList.add(cellId)
            // setting next player to O
            playerO
        } else {
            playerOList.add(cellId)
            // setting next player to X
            playerX
        }
    }

    private fun setTextAndColorForBtn(btnCell: Button, player: String) {
        btnCell.text = player
        btnCell.isEnabled = false
        if (player.isNotBlank() && player == playerX) {
            btnCell.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
        } else if (player.isNotBlank() && player == playerO) {
            btnCell.setTextColor(ContextCompat.getColor(this, R.color.pink_dark))
        }
    }

    private fun setAllButtonsEnabled(flag: Boolean) {

        btnCell1.isEnabled = flag
        btnCell2.isEnabled = flag
        btnCell3.isEnabled = flag

        btnCell4.isEnabled = flag
        btnCell5.isEnabled = flag
        btnCell6.isEnabled = flag

        btnCell7.isEnabled = flag
        btnCell8.isEnabled = flag
        btnCell9.isEnabled = flag
    }

    // Restart Game
    private fun restartGame() {

        currentOrNextPlayer = ""
        playerXList = arrayListOf()
        playerOList = arrayListOf()

        btnCell1.text = ""
        btnCell2.text = ""
        btnCell3.text = ""

        btnCell4.text = ""
        btnCell5.text = ""
        btnCell6.text = ""

        btnCell7.text = ""
        btnCell8.text = ""
        btnCell9.text = ""
        // setting all the buttons to clickable
        setAllButtonsEnabled(true)

        tv_result.text = getString(R.string.new_game)
    }


}