package com.example.pruebatabbedactivity.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pruebatabbedactivity.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    Drawable myDrawable;
    String title;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("UseCompatLoadingForDrawables")
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position < 2) {
            title = mContext.getResources().getString(TAB_TITLES[position]);
            SpannableStringBuilder sb = new SpannableStringBuilder("   " + title);
            return sb;
        } else {
            myDrawable = mContext.getResources().getDrawable(R.drawable.ic_baseline_4g_mobiledata_24);
            title = mContext.getResources().getString(TAB_TITLES[position]);

            SpannableStringBuilder sb = new SpannableStringBuilder(title);
            try {
                myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
                ImageSpan   span = new ImageSpan(myDrawable, ImageSpan.ALIGN_CENTER);
                sb.setSpan(span, 0, 1, Spanned.SPAN_INTERMEDIATE);
                return sb;
            } catch (Exception e) {
                return null;
            }
        }
        //return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}