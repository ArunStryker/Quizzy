package com.example.arunvenkatesh.quizzy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button answer1, answer2, answer3, answer4;
    protected TextView score;
    protected TextView question;
    private Questions mQuestions = new Questions();

    public String[] mAnswer;
    private int mScore = 0;
    public int count = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;
    String scoreText = "Score: ";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        // Initial Dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("The following quiz contains 9 questions");
        alertDialogBuilder.setPositiveButton("OK", null);
        alertDialogBuilder.show();

        // Creating Lists from Strings
        // Questions' List
        final ArrayList<String> noRepeatQues = new ArrayList<>();
        noRepeatQues.addAll(Arrays.asList(mQuestions.mQuestions).subList(0, mQuestionsLength));

        // Choices' List
        final ArrayList<ArrayList<String>> noRepChoice = new ArrayList<>();
        ArrayList<String> choiceSets = new ArrayList<>();
        int i = 0;
        while (i < mQuestionsLength) {
            choiceSets.addAll(Arrays.asList(mQuestions.mChoices[i]).subList(0, 4));
            noRepChoice.add(new ArrayList<>(choiceSets));
            choiceSets.clear();
            i++;
        }

        // Correct Answers' List
        final ArrayList<String> corAns = new ArrayList<>();
        corAns.addAll(Arrays.asList(mQuestions.mCorrectAnswers).subList(0, mQuestionsLength));

        // Randomize the List elements
        long seed = System.nanoTime();
        Collections.shuffle(noRepeatQues, new Random(seed));
        Collections.shuffle(noRepChoice, new Random(seed));
        Collections.shuffle(corAns, new Random(seed));

        // Log
        for (i = 0; i < noRepeatQues.size(); i++)
            Log.d(TAG, "onCreate: ques: " + noRepeatQues.get(i));

        for (i = 0; i < noRepChoice.size(); i++)
            Log.d(TAG, "onCreate: choice: " + noRepChoice.get(i));

        for (i = 0; i < corAns.size(); i++)
            Log.d(TAG, "onCreate: ans: " + corAns.get(i));

        // Start the execution
        score.setText(scoreText.concat(Integer.toString(mScore)));
        updateQuestion(count, noRepeatQues, noRepChoice, corAns);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mAnswer[count]) {
                    mScore++;
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
                else {
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mAnswer[count]) {
                    mScore++;
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
                else {
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mAnswer[count]) {
                    mScore++;
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
                else {
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mAnswer[count]) {
                    mScore++;
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
                else {
                    count++;
                    score.setText(scoreText.concat(Integer.toString(mScore)));
                    if (count==mQuestionsLength) gameOver();
                    else updateQuestion(count, noRepeatQues, noRepChoice, corAns);
                }
            }
        });
    }

    public void updateQuestion(int num, ArrayList<String> noRepeatQues, ArrayList<ArrayList<String>> noRepChoice, ArrayList<String> corAns){

        question.setText(noRepeatQues.get(num));
        answer1.setText(noRepChoice.get(num).get(0));
        answer2.setText(noRepChoice.get(num).get(1));
        answer3.setText(noRepChoice.get(num).get(2));
        answer4.setText(noRepChoice.get(num).get(3));

        mAnswer = corAns.toArray(new String[corAns.size()]);

        //Log
        for (int i = 0; i < mQuestionsLength; i++)
            Log.d(TAG, "onCreate: m_m: " + mAnswer[i]);
    }

    private void gameOver(){

        //Log
        Log.d(TAG, "onCreate: count: " + count);
        Log.d(TAG, "onCreate: score: " + mScore);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Game Over! Your Score is: " + mScore);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("New Game",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
        alertDialogBuilder.setNegativeButton("Exit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
