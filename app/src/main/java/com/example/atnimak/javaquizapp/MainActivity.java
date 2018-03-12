package com.example.atnimak.javaquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int rightAnswer = 0;
    public boolean isAllChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkOn(View view) {
        checkQuestions(view);
        if (isAllChecked) {
            setContentView(R.layout.finish_layout);
            rightAnswers(view);
        }

    }

    public void rightAnswers(View view) {
        TextView textView = (TextView) findViewById(R.id.rightAswers);
        textView.setText(getString(R.string.results, rightAnswer));
    }

    public void checkQuestions(View view) {
        String[] questions = {"answers1", "answers2", "answers3", "answers4", "answers5", "answers6", "answers7", "answers8", "answers9", "answers10",};
        String[] answers = {"char", "short", "-128 до 127", "32", "16", "64", "double", "true/false", "3.4E+38", "-1.7E+308",};

        for (int i = 0; i < 10; i++) {
            int temp = getResources().getIdentifier(questions[i], "id", getPackageName());
            RadioGroup questions1 = findViewById(temp);
            RadioButton r1 = findViewById(questions1.getCheckedRadioButtonId());
            if (r1 != null) {
                isAllChecked = true;
                if (r1.getText().equals(answers[i])) {
                    ++rightAnswer;
                }
            } else {
                isAllChecked = false;
                Toast toast = Toast.makeText(getApplicationContext(), R.string.need_ask_toast, Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }

}
