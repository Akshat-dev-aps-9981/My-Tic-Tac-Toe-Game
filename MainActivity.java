package com.mytictac.toe.game.as;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    TextView headerText;
    int Player_O = 0;
    int Player_X = 1;
    int activePlayer = Player_O;
    int[] filledPos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean isGameActive = true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        headerText = findViewById(R.id.header_text);
        headerText.setText("O turn");
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        
		btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View p1)
    {
        if(!isGameActive)
        {
            return;
        }
        Button clickedBtn = findViewById(p1.getId());
        int clickedTag = Integer.parseInt(p1.getTag().toString());
        
        if(filledPos[clickedTag] != -1)
        {
            return;
        }
        
        if(filledPos[0] != -1)
            {if(filledPos[1] != -1)
            {if(filledPos[2] != -1)
            {if(filledPos[3] != -1)
            {if(filledPos[4] != -1)
            {if(filledPos[5] != -1)
            {if(filledPos[6] != -1)
            {if(filledPos[7] != -1) 
            {if(filledPos[8] != -1)
            {if(filledPos[9] != -1)
        {
            restartGame();
        }
        }}}}}}}}}
        
        filledPos[clickedTag] = activePlayer;
        
        if(activePlayer == Player_O)
        {
            clickedBtn.setText("O");
            activePlayer = Player_X;
            headerText.setText("Now X Player Turn");
        }
        
        else
        {
            clickedBtn.setText("X");
            activePlayer = Player_O;
            headerText.setText("Now O Player Turn");
        }
        
        checkForWin();
    }
    
    private void checkForWin()
    {
        int[][] winingPos
        = {{0,3,6}, {1,4,7}, {2,5,8}, {0,1,2}, {3,4,5}, {6,7,8}, {0,4,8}, {2,4,6}};
        
        for(int i=0; i<8; i++)
        {
            int val0 = winingPos[i][0];
            int val1 = winingPos[i][1];
            int val2 = winingPos[i][2];
            
           if(filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2])
            {
                if(filledPos[val0] != -1)
                {
                    if(filledPos[val0] == Player_O)
                    {
                        isGameActive = false;
                        showDilog("Player O");
                        headerText.setText("O is winner");
                    }
                    else
                    {
                        isGameActive = false;
                        showDilog("Player X");
                        headerText.setText("X is winner");
                    }
                }
            }
        }
    }
    
    
    private void showDilog(String winnerName)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(winnerName);
        builder.setMessage(winnerName + " is winner");
        builder.setPositiveButton("Restart",
        new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface p1, int p2)
                {
                    restartGame();
                }
            });
            builder.create();
        builder.show();
    }

    private void restartGame()
    {
        activePlayer = Player_O;
        headerText.setText("O turn");
        filledPos = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        
        
        isGameActive = true;
        
    }
}
