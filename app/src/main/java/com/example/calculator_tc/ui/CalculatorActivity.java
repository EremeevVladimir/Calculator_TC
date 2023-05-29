package com.example.calculator_tc.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.calculator_tc.R;
import com.example.calculator_tc.model.CalculatorImpl;
import com.example.calculator_tc.model.Operator;
import com.example.calculator_tc.model.Theme;
import com.example.calculator_tc.storage.ThemeStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;
    private CalculatorPresenter presenter;

    private LinearLayout container;

    private final String ARG_THEME = "ARG_THEME";

    private ThemeStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        storage = new ThemeStorage(this);
        setTheme(storage.getTheme().getTheme());

//        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_THEME)) {
//            selectedTheme = (Theme) savedInstanceState.getSerializable(ARG_THEME);
//            setTheme(selectedTheme.getTheme());
//        }

        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        initGui();
    }

    private void initGui() {
        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);
        digits.put(R.id.key_zero, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_zero).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus, Operator.SUB);
        operators.put(R.id.key_mult, Operator.MULT);
        operators.put(R.id.key_divide, Operator.DIV);

        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operatorsClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

        //обработка альтернативной кнопки
        Button logBtn = findViewById(R.id.key_log);
        if (logBtn != null) {

        }

        container = findViewById(R.id.theme_container);

        if (container == null) {
            return;
        }

        for (Theme theme : Theme.values()) {
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, container, false);

            ImageView img = itemView.findViewById(R.id.img);
            TextView txt = itemView.findViewById(R.id.txt);

            img.setImageResource(theme.getImage());
            txt.setText(theme.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    storage.setTheme(theme);
                    recreate();
                }
            });

            container.addView(itemView);
        }

    }

    @Override
    public void shouResult(String result) {

        resultTxt.setText(result);

    }


//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        if (selectedTheme !=null) {
//            outState.putSerializable(ARG_THEME, selectedTheme);
//        }
//        super.onSaveInstanceState(outState);
//    }
}