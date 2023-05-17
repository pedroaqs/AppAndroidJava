package com.example.hellowordsem9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int a = 0;
    public String inputa = "";
    public int b = 0;
    public String inputb = "";
    public String operacion = "";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    TextView input;
    TextView output;

    Button btn_divide;
    Button btn_multi;
    Button btn_sub;
    Button btn_add;
    Button btn_equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        btn_divide= findViewById(R.id.button_divide);
        btn_multi= findViewById(R.id.button_multi);
        btn_sub= findViewById(R.id.button_sub);
        btn_add= findViewById(R.id.button_add);
        btn_equal= findViewById(R.id.button_equal);

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("" + calcular());
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("/");
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("×");
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("-");
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("+");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInput(9);
            }
        });

    }

    public void agregarInput(Integer input) {
        if (operacion == "") {
            if(this.inputa == "") {
                this.a = input;
            } else {
                this.a = Integer.parseInt(this.inputa + input);
            }
            this.inputa = "" + a;
            this.input.setText(this.inputa);
        }else {
            if(this.inputb == "") {
                this.b = input;
            } else {
                this.b = Integer.parseInt(this.inputb + input) ;
            }
            this.inputb = "" + b;
            this.input.setText("" + this.inputa + " " + this.operacion + " " + this.inputb);
        }
    }

    public void agregarOperacion(String operacion) {
        if(this.operacion == "") {
            this.operacion = operacion;
            this.input.setText("" + a + " " + this.operacion + " " + b);
        } else {
            Log.i("Error operaciones", operacion +  "input a " + a + " input b " + b + " = " + this.calcular());
            this.a = this.calcular();
            this.inputa = "" + a;
            this.b = 0;
            this.inputb = "" + b;
            this.operacion = operacion;
            this.input.setText("" + a + " " + this.operacion + " " + b);
        }
    }

    public int calcular () {
        switch (operacion) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "×":
                return a*b;
            case "/":
                return a/b;
            default:
                return a+b;
        }
    }
}
