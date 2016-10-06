package cs193a.stanford.edu.berkeleyadmissionquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1, num2, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
    }

    private void pickNumbers() {
        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Points: " + points);

        // initialization code
        Random randy = new Random();
        while (true) {
            num1 = randy.nextInt(10);
            num2 = randy.nextInt(10);
            if (num1 != num2) {
                break;
            }
        }

        Button left = (Button) findViewById(R.id.left_button);
        Button right = (Button) findViewById(R.id.right_button);

        left.setText(String.valueOf(num1));
        right.setText(String.valueOf(num2));
    }

    public void leftButtonClick(View view) {
        if(num1 > num2) {
            // correct
            points++;
        } else {
            // incorrect
            points--;
        }

        pickNumbers();
    }

    public void rightButtonClick(View view) {
        if(num2 > num1) {
            // correct
            points++;
        } else {
            // incorrect
            points--;
        }
        pickNumbers();
    }
}
