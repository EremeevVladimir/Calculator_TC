package com.example.calculator_tc.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.calculator_tc.model.Theme;

public class ThemeStorage {

    private static final String ARG_THEME = "ARG_THEME";

    private SharedPreferences sharedPreferences;

    public ThemeStorage(Context context) {
           this.sharedPreferences = context.getSharedPreferences("theme", Context.MODE_PRIVATE);
    }

    public void setTheme (Theme theme) {
        sharedPreferences.edit().putString(ARG_THEME, theme.getKey()).apply();

    }

    public void getTheme () {
        String key = sharedPreferences.getString(ARG_THEME, Theme.THEME_ONE.getKey());

        
    }

}