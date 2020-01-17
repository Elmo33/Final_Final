package ge.msda.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        var score_p1 = 0
        var score_p2 = 0

        // Times Used
        var btn00 = 0
        var btn01 = 0
        var btn02 = 0
        var btn10 = 0
        var btn11 = 0
        var btn12 = 0
        var btn20 = 0
        var btn21 = 0
        var btn22 = 0

        var turn = 1

        var final = 1

        fun checkwin(){
            // Button texts
            val btn00t = button_00.text.toString()
            val btn01t = button_01.text.toString()
            val btn02t = button_02.text.toString()
            val btn10t = button_10.text.toString()
            val btn11t = button_11.text.toString()
            val btn12t = button_12.text.toString()
            val btn20t = button_20.text.toString()
            val btn21t = button_21.text.toString()
            val btn22t = button_22.text.toString()
            if(final==1) {
                if (btn00t == btn01t && btn00t == btn02t && btn00t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn10t == btn11t && btn10t == btn12t && btn10t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn20t == btn21t && btn20t == btn22t && btn20t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn00t == btn10t && btn00t == btn20t && btn00t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn01t == btn11t && btn01t == btn21t && btn01t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn02t == btn12t && btn02t == btn22t && btn02t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn00t == btn11t && btn00t == btn22t && btn00t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
                if (btn02t == btn11t && btn20t == btn02t && btn02t != "") {
                    if (turn % 2 == 0) {
                        score_p1 += 1
                        final += 1
                        player1_score.setText("Player 1: " + score_p1)
                        Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show()
                    } else {
                        score_p2 += 1
                        final += 1
                        player2_score.setText("Player 2: " + score_p2)
                        Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }

        button_00.setOnClickListener {
            if (turn % 2 != 0 && btn00 == 0) {
                btn00 += 1
                turn += 1
                button_00.setText("X")
                checkwin()

            } else if (btn00 == 0) {
                btn00 += 1
                turn += 1
                button_00.setText("O")
                checkwin()
            }
        }
        button_01.setOnClickListener {
            if (turn % 2 != 0 && btn01 == 0) {
                btn01 += 1
                turn += 1
                button_01.setText("X")
                checkwin()
            } else if (btn01 == 0) {
                btn01 += 1
                turn += 1
                button_01.setText("O")
                checkwin()
            }
        }
        button_02.setOnClickListener {
            if (turn % 2 != 0 && btn02 == 0) {
                btn02 += 1
                turn += 1
                button_02.setText("X")
                checkwin()
            } else if (btn02 == 0) {
                btn02 += 1
                turn += 1
                button_02.setText("O")
                checkwin()
            }
        }
        button_10.setOnClickListener {
            if (turn % 2 != 0 && btn10 == 0) {
                btn10 += 1
                turn += 1
                button_10.setText("X")
                checkwin()
            } else if (btn10 == 0) {
                btn10 += 1
                turn += 1
                button_10.setText("O")
                checkwin()
            }
        }
        button_11.setOnClickListener {
            if (turn % 2 != 0 && btn11 == 0) {
                btn11 += 1
                turn += 1
                button_11.setText("X")
                checkwin()
            } else if (btn11 == 0) {
                btn11 += 1
                turn += 1
                button_11.setText("O")
                checkwin()
            }
        }
        button_12.setOnClickListener {
            if (turn % 2 != 0 && btn12 == 0) {
                btn12 += 1
                turn += 1
                button_12.setText("X")
                checkwin()
            } else if (btn12 == 0) {
                btn12 += 1
                turn += 1
                button_12.setText("O")
                checkwin()
            }
        }
        button_20.setOnClickListener {
            if (turn % 2 != 0 && btn20 == 0) {
                btn20 += 1
                turn += 1
                button_20.setText("X")
                checkwin()
            } else if (btn20 == 0) {
                btn20 += 1
                turn += 1
                button_20.setText("O")
                checkwin()
            }
        }
        button_21.setOnClickListener {
            if (turn % 2 != 0 && btn21 == 0) {
                btn21 += 1
                turn += 1
                button_21.setText("X")
                checkwin()
            } else if (btn21 == 0) {
                btn21 += 1
                turn += 1
                button_21.setText("O")
                checkwin()
            }
        }
        button_22.setOnClickListener {
            if (turn % 2 != 0 && btn22 == 0) {
                btn22 += 1
                turn += 1
                button_22.setText("X")
                checkwin()
            } else if (btn22 == 0) {
                btn22 += 1
                turn += 1
                button_22.setText("O")
                checkwin()
            }
        }
        button_reset.setOnClickListener{
            button_00.setText("")
            button_01.setText("")
            button_02.setText("")
            button_10.setText("")
            button_11.setText("")
            button_12.setText("")
            button_20.setText("")
            button_21.setText("")
            button_22.setText("")
            btn00 = 0
            btn01 = 0
            btn02 = 0
            btn10 = 0
            btn11 = 0
            btn12 = 0
            btn20 = 0
            btn21 = 0
            btn22 = 0
            turn = 1
            final = 1
        }
        button_restart.setOnClickListener{
            button_00.setText("")
            button_01.setText("")
            button_02.setText("")
            button_10.setText("")
            button_11.setText("")
            button_12.setText("")
            button_20.setText("")
            button_21.setText("")
            button_22.setText("")
            btn00 = 0
            btn01 = 0
            btn02 = 0
            btn10 = 0
            btn11 = 0
            btn12 = 0
            btn20 = 0
            btn21 = 0
            btn22 = 0
            turn = 1
            final = 1
            player1_score.setText("Player 1: 0")
            player2_score.setText("Player 2: 0")
            score_p1 = 0
            score_p2 = 0
        }
    }
}