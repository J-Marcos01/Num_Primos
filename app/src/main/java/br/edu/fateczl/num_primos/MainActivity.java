package br.edu.fateczl.num_primos;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import controller.CalcController;

public class MainActivity extends AppCompatActivity {
    private EditText etNum1;
    private EditText etNum2;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNum1=findViewById(R.id.etNum1);
        etNum1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etNum1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String input = s.toString().trim();


                if (!input.isEmpty()) {
                    try {
                        int value = Integer.parseInt(input);
                        if (value < 0|| value>50) {
                            etNum1.setError("Valor deve estar entre 0 e 50");
                        }
                    } catch (NumberFormatException e) {
                        etNum1.setError("Valor deve estar entre 0 e 50");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        etNum2=findViewById(R.id.etNum2);
        etNum2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etNum2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String input = s.toString().trim();


                if (!input.isEmpty()) {
                    try {
                        int value = Integer.parseInt(input);
                        if (value < 0|| value>50) {
                            etNum2.setError("Valor deve estar entre 0 e 50");
                        }
                    } catch (NumberFormatException e) {
                        etNum2.setError("Valor deve estar entre 0 e 50");
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tvRes=findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnCalc=findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> CalcPrimos());
    }

    public void CalcPrimos(){

        CalcController calcCont=new CalcController();

            int n1=Integer.parseInt(etNum1.getText().toString());
            int n2=Integer.parseInt(etNum2.getText().toString());

            int res=calcCont.primos(n1,n2);

            String result=getString(R.string.res)+" ="+res;

            tvRes.setText(result);

    }

}