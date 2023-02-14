package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView gameTitle;
    static MediaPlayer music;
    ImageView minaMenu;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bEasy.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_EasyFragment));
        binding.bHard.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_HardFragment));


        gameTitle = requireView().findViewById(R.id.gameTitle);
        final Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.shake1);
        gameTitle.startAnimation(animation);
        minaMenu = requireView().findViewById(R.id.minaMenu);
        final Animation animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.shake3);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    minaMenu.startAnimation(animation2);
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        minaMenu.startAnimation(animation2);
        playMusic(getContext(), R.raw.crash_bandicoot_3_warped);
    }

    @Override
    public void onDestroyView() {
        music.stop();
        super.onDestroyView();
        binding = null;
    }

    public static void playMusic(final Context context, int rawMusic) {
        music = MediaPlayer.create(context, rawMusic);
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (music != null) {
                    music.release();
                }
            }
        });
        music.start();
    }

}