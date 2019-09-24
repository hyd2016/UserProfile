package com.example.hotsoon_user_profiiles.Interface;

import android.os.Messenger;

import com.example.hotsoon_user_profiiles.music.MusicParcelable;

public interface MusicChange {
    void musicPlay(Messenger messenger, MusicParcelable musicParcelable);
}
