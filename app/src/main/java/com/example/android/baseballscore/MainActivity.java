package com.example.android.baseballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // tracks the ball count
    int ballCount = 0;

    //tracks the strike count
    int strikeCount = 0;

    //tracks the out count during the current inning half
    int outCount = 0;

    //indicates that this is the top of the inning "true" or the bottom of it "false"
    boolean topOfInning = true;

    //tracks the guest team score
    int guestScore = 0;

    //tracks the home team score
    int homeScore = 0;

    //tracks the inning number
    int inningNumber = 1;

    //indicates that this is the final score "true" or the match still on "false"
    boolean finalScore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guestScoreDisplay(0);
        homeScoreDisplay(0);
        ballCountDisplay(0);
        strikeCountDisplay(0);
        outCountDisplay(0);
        inningCountDisplay(1);
        setFinalScore(">>>>");
    }

    /**
     * Indicate that this is the Final score and the match end
     */
    public void setFinalScore(String Status) {
        TextView scoreView = (TextView) findViewById(R.id.final_score);
        scoreView.setText(String.valueOf(Status));
    }

    /**
     * Indicate that this is the Top or the Bottom of the current inning
     * T for Top,  B for Bottom
     */
    public void setInningHalf(String Status) {
        TextView scoreView = (TextView) findViewById(R.id.Top_Bottom_Text);
        scoreView.setText(String.valueOf(Status));
    }

    /**
     * Displays the given score for Guest team.
     */
    public void guestScoreDisplay(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Guest_Score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Home team.
     */
    public void homeScoreDisplay(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Home_Score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Ball count.
     */
    public void ballCountDisplay(int ball_count) {
        TextView scoreView = (TextView) findViewById(R.id.Ball_Count);
        scoreView.setText(String.valueOf(ball_count));
    }

    /**
     * Displays the given Strike count.
     */
    public void strikeCountDisplay(int strike_count) {
        TextView scoreView = (TextView) findViewById(R.id.Strike_Count);
        scoreView.setText(String.valueOf(strike_count));
    }

    /**
     * Displays the given Out count.
     */
    public void outCountDisplay(int out_count) {
        TextView scoreView = (TextView) findViewById(R.id.Out_Count);
        scoreView.setText(String.valueOf(out_count));
    }

    /**
     * Displays the given Inning count.
     */
    public void inningCountDisplay(int inning_number) {
        TextView scoreView = (TextView) findViewById(R.id.INNING_Number);
        scoreView.setText(String.valueOf(inning_number));
    }


    /**
     * Increases the ball count
     */

    public void setBallCount(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            //if ball count is less than 3 increment
            if (ballCount < 3) {
                ballCount++;
            } else {//ball count reached four

                //reset ball and strikes counts and display them
                ballCount = 0;
                strikeCount = 0;
                strikeCountDisplay(strikeCount);
            }
            ballCountDisplay(ballCount);
        }

    }


    /**
     * Increases the strike count
     */

    public void setStrikeCount(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (strikeCount < 2) {
                strikeCount++;
            } else { //if strike count reached three
                //reset ball count and display it
                ballCount = 0;
                ballCountDisplay(ballCount);
                // reset strike count
                strikeCount = 0;
                outCount++;
                // if this is the third out call threeOutReached to handle it
                if (outCount < 3)
                    outCountDisplay(outCount);
                else
                    threeOutReached();

            }
            strikeCountDisplay(strikeCount);
        }

    }

    /**
     * Increases the guest score
     */

    public void setGuestScore(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (topOfInning == true)
                guestScore++;

            guestScoreDisplay(guestScore);
        }
    }

    /**
     * Increases the guest score by two runs
     */

    public void setGuestScoreTwo(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (topOfInning == true)
                guestScore += 2;

            guestScoreDisplay(guestScore);
        }
    }

    /**
     * Increases the guest score by three runs
     */

    public void setGuestScoreThree(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (topOfInning == true)
                guestScore += 3;

            guestScoreDisplay(guestScore);
        }
    }

    /**
     * Increases the guest score by Four runs "Grand Slam"
     */

    public void setGuestScoreGrand(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (topOfInning == true)
                guestScore += 4;

            guestScoreDisplay(guestScore);
        }
    }


    /**
     * Increases the home score
     */

    public void setHomeScore(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (!topOfInning)
                homeScore++;

            //it's a walk off win
            if (inningNumber >= 9 && homeScore > guestScore) {
                finalScore = true;
                setFinalScore("FINAL");
            }
            homeScoreDisplay(homeScore);
        }

    }

    /**
     * Increases the home score by two runs
     */

    public void setHomeScoreTwo(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (!topOfInning)
                homeScore += 2;
            //it's a walk off win
            if (inningNumber >= 9 && homeScore > guestScore) {
                finalScore = true;
                setFinalScore("FINAL");
            }

            homeScoreDisplay(homeScore);
        }
    }

    /**
     * Increases the home score by three runs
     */

    public void setHomeScoreThree(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (!topOfInning)

                homeScore += 3;
            //it's a walk off win
            if (inningNumber >= 9 && homeScore > guestScore) {
                finalScore = true;
                setFinalScore("FINAL");
            }
            homeScoreDisplay(homeScore);
        }
    }

    /**
     * Increases the home score by four runs "Grand Slam"
     */

    public void setHomeScoreGrand(View view) {
        // don't increment if the score is final "game ended"
        if (!finalScore) {
            if (!topOfInning)
                homeScore += 4;

            //it's a walk off win
            if (inningNumber >= 9 && homeScore > guestScore) {
                finalScore = true;
                setFinalScore("FINAL");
            }

            homeScoreDisplay(homeScore);
        }
    }


    /**
     * Handles the inning number when the out count reaches three
     */

    private void threeOutReached() {
        boolean inningState = topOfInning;
        topOfInning ^= true; //three outs" half inning has ended"

        // display the current half of the inning "Top" or Bottom
        if (topOfInning)
            setInningHalf("T");
        else
            setInningHalf("B");

        //if this is the bottom of the inning go to the next inning
        if (!inningState)
            inningNumber++;

        //the home team is leading , the guest team couldn't tie in the top of the inning and it's the ninth inning or more
        if ((inningNumber >= 9 && !topOfInning) && (homeScore > guestScore)) {
            finalScore = true;
            setFinalScore("FINAL");
        }
        //the guest team is leading , the home team couldn't tie in the bottom of the 9th inning or more
        if ((inningNumber > 9 && topOfInning) && (homeScore < guestScore)) {
            finalScore = true;
            setFinalScore("FINAL");
        }
        //reset the strikes count
        strikeCount = 0;
        strikeCountDisplay(strikeCount);

        //reset the ball count
        ballCount = 0;
        ballCountDisplay(strikeCount);

        //reset the out count
        outCount = 0;
        outCountDisplay(outCount);

        //if the game isn't finished move to the next inning
        if (!finalScore)
            inningCountDisplay(inningNumber);

    }

    /**
     * Increases the out count
     */

    public void setOutCount(View view) {
        if (!finalScore) {
            if (outCount < 2) {
                outCount++;
                outCountDisplay(outCount);
            } else //strike count reached three call threeOutReached() to handle the situation
                threeOutReached();

        }
    }

    /**
     * resets the score board and the counters
     */

    public void resetBoard(View view) {
        finalScore = false;
        ballCount = 0;
        strikeCount = 0;
        outCount = 0;
        topOfInning = true;
        guestScore = 0;
        homeScore = 0;
        inningNumber = 1;
        guestScoreDisplay(guestScore);
        homeScoreDisplay(homeScore);
        ballCountDisplay(ballCount);
        strikeCountDisplay(strikeCount);
        outCountDisplay(outCount);
        inningCountDisplay(inningNumber);
        setFinalScore(">>>>");


    }

}
