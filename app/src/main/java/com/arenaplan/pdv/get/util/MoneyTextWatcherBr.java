package com.arenaplan.pdv.get.util;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyTextWatcherBr implements TextWatcher {

    private final WeakReference<EditText> editTextWeakReference;
    private final Locale locale = new Locale("pt", "BR");

    @SuppressLint("NotConstructor")
    public MoneyTextWatcherBr(EditText editText) {
        this.editTextWeakReference = new WeakReference<>(editText);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable editable) {
        EditText editText = editTextWeakReference.get();
        if (editText == null) return;
        editText.removeTextChangedListener(this);

        BigDecimal parsed = parseToBigDecimal(editable.toString());
        String formatted = NumberFormat.getCurrencyInstance(locale).format(parsed);

        // Remove o símbolo da moeda e espaçamento para garantir o formato correto
        String cleanString = formatted.replace(getCurrencySymbol(), "").trim();

        editText.setText(cleanString);
        editText.setSelection(cleanString.length());
        editText.addTextChangedListener(this);
    }

    private BigDecimal parseToBigDecimal(String value) {
        String cleanValue = value.replaceAll("[^\\d]", "");
        if (cleanValue.isEmpty()) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(cleanValue).divide(BigDecimal.valueOf(100));
        }
    }

    public static String formatTextPrice(String price) {
        BigDecimal bD = new BigDecimal(formatPriceSave(formatPrice(price)));
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return numberFormat.format(bD).replace(getCurrencySymbol(), "").trim();
    }

    public static String formatPrice(String price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(Double.parseDouble(price));
    }

    static String formatPriceSave(String price) {
        String cleanString = price.replaceAll("[R$,.\\s]", "");
        return new StringBuilder(cleanString).insert(cleanString.length() - 2, '.').toString();
    }

    public static String getCurrencySymbol() {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).getCurrency().getSymbol();
    }
}
