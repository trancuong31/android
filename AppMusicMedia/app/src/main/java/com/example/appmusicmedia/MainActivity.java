package com.example.appmusicmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle,txtTimeSong,txtTimeTotal;
    SeekBar skSong;
    ImageButton btnPrev,btnPlay,btnStop,btnNext;
    ArrayList<Song> arrayList;
    MediaPlayer mediaPlayer;
    ImageView imageView;
    Animation animation;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        anhxa();
        addSong();
        khoiTaoMediaplayer();
        animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotatecd);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                updateTimeSong();
                imageView.animate().cancel();
                btnPlay.setImageResource(R.drawable.play);
            }
            else {
                mediaPlayer.start();
                updateTimeSong();
                btnPlay.setImageResource(R.drawable.pause);
                setTimeTotal();
                imageView.setAnimation(animation);
            }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play);
                khoiTaoMediaplayer();
                imageView.clearAnimation();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position>arrayList.size()-1){
                    position=0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                khoiTaoMediaplayer();
                mediaPlayer.start();
                setTimeTotal();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position<0){
                    position=arrayList.size()-1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                khoiTaoMediaplayer();
                mediaPlayer.start();
                setTimeTotal();
                updateTimeSong();
            }
        });
        setTimeTotal();
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
        updateTimeSong();
    }

    private void updateTimeSong() {
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdang=new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhdang.format(mediaPlayer.getCurrentPosition()));
                //update progress seekbar
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                //check time Song ,if complete thì next bài tiếp theo
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position>arrayList.size()-1){
                            position=0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        khoiTaoMediaplayer();
                        mediaPlayer.start();
                        setTimeTotal();
                        updateTimeSong();
                    }
                });
                    handler.postDelayed(this, 500);
            }
        },100);
    }

    private void setTimeTotal() {
        SimpleDateFormat dinhdanggio=new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhdanggio.format(mediaPlayer.getDuration()));
        skSong.setMax(mediaPlayer.getDuration());
    }

    private void khoiTaoMediaplayer() {
        mediaPlayer=MediaPlayer.create(MainActivity.this,arrayList.get(position).getFile());
        txtTitle.setText(arrayList.get(position).getTitle());

    }

    private void addSong() {
        arrayList=new ArrayList<>();
        arrayList.add(new Song("Âm thầm bên em",R.raw.am_tham_ben_em));
        arrayList.add(new Song("Cơn mưa ngang qua",R.raw.con_mua_xa_dan));
        arrayList.add(new Song("Hãy trao cho anh",R.raw.hay_trao_cho_anh));
        arrayList.add(new Song("Muộn rồi mà sao còn",R.raw.muon_roi_ma_sao_con));
        arrayList.add(new Song("Nắng ấm xa dần",R.raw.nang_am_ngang_qua));
        arrayList.add(new Song("Nơi này có anh",R.raw.noi_nay_co_anh));
    }

    private void anhxa() {
        txtTitle=findViewById(R.id.titleSong);
        txtTimeSong=findViewById(R.id.timeSong);
        txtTimeTotal=findViewById(R.id.timeTotal);
        skSong=findViewById(R.id.skSong);
        btnPrev=findViewById(R.id.btnPrev);
        btnPlay=findViewById(R.id.btnPlay);
        btnStop=findViewById(R.id.btnStop);
        btnNext=findViewById(R.id.btnSkip);
        imageView=findViewById(R.id.imageView);
    }



}