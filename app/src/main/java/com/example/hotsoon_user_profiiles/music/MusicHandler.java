package com.example.hotsoon_user_profiiles.music;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import com.example.hotsoon_user_profiiles.Interface.MusicChange;


public class MusicHandler extends Handler {

    private static final int MSG_FROM_CLIENT = 0;
    private static final String TAG = "MusicHandler";
    private MusicChange musicChange;

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what)
        {
            case MSG_FROM_CLIENT:
                Log.d(TAG, "receive msg from client: msg");

                Log.d(TAG, "handleMessage: thread"+Thread.currentThread().getId());

                //不加这一句话会出现ClassNotFoundException when unmarshalling
                msg.getData().setClassLoader(MusicParcelable.class.getClassLoader());

                Messenger client = msg.replyTo;
                MusicParcelable musicParcelable = msg.getData().getParcelable("music");
                Log.d(TAG, "handleMessage: "+ musicParcelable.getMusicUrl());
                if (musicChange != null){
                    musicChange.musicPlay(client, musicParcelable);
                }


                break;
            default:
                super.handleMessage(msg);
        }
    }
    public void setMusicChange(MusicChange change){
        this.musicChange = change;
    }




}
