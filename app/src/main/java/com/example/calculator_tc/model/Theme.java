package com.example.calculator_tc.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator_tc.R;

public enum  Theme {

THEME_ONE (R.string.theme_one, R.drawable.ic_baseline_5g_24, R.style.Theme_Calculator_TC, "one"),
THEME_TWO (R.string.theme_two, R.drawable.baseline_add_24, R.style.Theme_Calculator_TC_Version2, "two"),
THEME_THREE (R.string.theme_three, R.drawable.baseline_ac_unit_24, R.style.Theme_Calculator_TC_Version3, "three"),
THEME_FOUR (R.string.theme_four, R.drawable.baseline_add_alarm_24, R.style.Theme_Calculator_TC_Version4, "four");

    @StringRes
    private final int title;
    @DrawableRes
    private final int image;
    @StyleRes
    private final int theme;

    private final String key;

    private Theme(int title, int image, int theme, String key) {
        this.title = title;
        this.image = image;
        this.theme = theme;
        this.key = key;
    }

    public int getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public int getTheme() {
        return theme;
    }

    public String getKey() {
        return key;
    }
}


