package com.wc.tictactoeapp

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.wc.tictactoeapp.constants.Constants.Companion.combinationsToWin
import com.wc.tictactoeapp.constants.Constants.Companion.gameDraw
import com.wc.tictactoeapp.constants.Constants.Companion.playerO
import com.wc.tictactoeapp.constants.Constants.Companion.playerOWin
import com.wc.tictactoeapp.constants.Constants.Companion.playerX
import com.wc.tictactoeapp.constants.Constants.Companion.playerXWin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var currentOrNextPlayer = ""
    var playerXList = ArrayList<Int>()
    var playerOList = ArrayList<Int>()

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

        tvResult.text = getString(R.string.new_game)
        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        tvResult.startAnimation(anim)
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
                    addSelectedCellInListforPlayer(1, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell2 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell2, selectedPlayer)
                    addSelectedCellInListforPlayer(2, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell3 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell3, selectedPlayer)
                    addSelectedCellInListforPlayer(3, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }

            // Row 2
            btnCell4 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell4, selectedPlayer)
                    addSelectedCellInListforPlayer(4, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell5 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell5, selectedPlayer)
                    addSelectedCellInListforPlayer(5, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell6 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell6, selectedPlayer)
                    addSelectedCellInListforPlayer(6, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }

            // Row 3
            btnCell7 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell7, selectedPlayer)
                    addSelectedCellInListforPlayer(7, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell8 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell8, selectedPlayer)
                    addSelectedCellInListforPlayer(8, selectedPlayer)
                    checkCurrentGameStatus()
                }
            }
            btnCell9 -> {
                val selectedPlayer = getPlayer(currentOrNextPlayer)
                if (selectedPlayer != null) {
                    setTextAndColorForBtn(btnCell9, selectedPlayer)
                    addSelectedCellInListforPlayer(9, selectedPlayer)
                    checkCurrentGameStatus()
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

    fun addSelectedCellInListforPlayer(cellId: Int, selectedPlayer: String) {
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

   private fun checkCurrentGameStatus() {
        // Check current game status for Win/Draw/Game Continues
        val gameStatus = checkGameStatus(this.currentOrNextPlayer)

        if (gameStatus != null) {
            when (gameStatus) {
                playerXWin -> showPlayerXWins()
                playerOWin -> showPlayerOWins()
                gameDraw -> showGameIsDraw()
                // game continues
                else -> startNextPlayerTurn(gameStatus)
            }
        }
    }

    fun checkGameStatus(nextPlayer: String): String? {
        when {
            combinationsToWin.any { playerXList.containsAll(it) } -> return playerXWin
            combinationsToWin.any { playerOList.containsAll(it) } -> return playerOWin
            playerXList.size + playerOList.size == 9 -> {
                return gameDraw
            }
        }
        // game continues
        return nextPlayer
    }

    private fun showPlayerXWins() {
        setAllButtonsEnabled(false)
        updateCurrentStatusInResult(getString(R.string.player_x_wins))
    }

    private fun showPlayerOWins() {
        setAllButtonsEnabled(false)
        updateCurrentStatusInResult(getString(R.string.player_o_wins))
    }

    private fun showGameIsDraw() {
        updateCurrentStatusInResult(getString(R.string.game_draw))
    }

    private fun startNextPlayerTurn(nextPlayer: String) {
        updateCurrentStatusInResult("Player $nextPlayer has to play now")
    }

    private fun updateCurrentStatusInResult(result : String) {
        tvResult.text = result
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

        tvResult.text = getString(R.string.new_game)
    }
}