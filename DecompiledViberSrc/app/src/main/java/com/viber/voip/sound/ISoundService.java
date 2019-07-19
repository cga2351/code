package com.viber.voip.sound;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.viber.jni.PhoneControllerDelegate;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.sound.config.SoundConfig;

public abstract interface ISoundService extends PhoneControllerDelegate, DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerPhoneState
{
  public static final int STREAM_RING = 2;
  public static final int STREAM_VOICE;

  public abstract void cleanupAudioRoute();

  public abstract BtControl getBluetoothCtl();

  public abstract Context getContext();

  public abstract Handler getHandler();

  public abstract AudioManager getPlatformAudioManager();

  public abstract SoundConfig getSoundConfig();

  public abstract boolean isBluetoothOn();

  public abstract boolean isGSMCallActive();

  public abstract boolean isHeadsetPluggedIn();

  public abstract boolean isRTCCallActive();

  public abstract boolean isSpeakerphoneOn();

  public abstract boolean isUserWantsSpeaker();

  public abstract boolean isViberCallActive();

  public abstract int mode_InCall();

  public abstract int mode_bluetooth();

  public abstract int mode_default();

  public abstract void prepareCallAudioRoute();

  public abstract void preparePttAudioRoute();

  public abstract void prepareVideoPttAudioRoute();

  public abstract void registerSpeakerStateListener(SpeakerStateListener paramSpeakerStateListener);

  public abstract void setMode(int paramInt);

  public abstract void setSpeakerphoneOn(boolean paramBoolean);

  public static abstract interface SpeakerStateListener
  {
    public abstract void onHeadphonesConnected(boolean paramBoolean);

    public abstract void onSpeakerStateChanged(boolean paramBoolean);

    public abstract void onSpeakerStatePreChanged(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ISoundService
 * JD-Core Version:    0.6.2
 */