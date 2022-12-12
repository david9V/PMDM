package com.example.mislugaresjava.pruebas;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.mislugaresjava.R;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState,
                                    String rootKey) {
        setPreferencesFromResource(R.xml.preferencias, rootKey);
    }
}

