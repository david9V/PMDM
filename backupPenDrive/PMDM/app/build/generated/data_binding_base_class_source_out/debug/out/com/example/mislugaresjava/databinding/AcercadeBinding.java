// Generated by view binder compiler. Do not edit!
package com.example.mislugaresjava.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.mislugaresjava.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class AcercadeBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  @NonNull
  public final TextView TextView01;

  private AcercadeBinding(@NonNull TextView rootView, @NonNull TextView TextView01) {
    this.rootView = rootView;
    this.TextView01 = TextView01;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static AcercadeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AcercadeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.acercade, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AcercadeBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    TextView TextView01 = (TextView) rootView;

    return new AcercadeBinding((TextView) rootView, TextView01);
  }
}
