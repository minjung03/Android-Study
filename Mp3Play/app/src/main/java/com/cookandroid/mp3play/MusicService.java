package com.cookandroid.mp3play;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        mp = MediaPlayer.create(this, R.raw.schoolbell);
        mp.setLooping(false); // 반복 재생
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
