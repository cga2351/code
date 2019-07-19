package com.viber.voip.sound.audiofocus;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class AudioFocusManager
{
  public static final int AUDIOFOCUS_NONE = 0;
  public static final float DUCK_VOLUME = 0.2F;
  private static final Logger L = ViberEnv.getLogger();
  final AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener()
  {
    public void onAudioFocusChange(int paramAnonymousInt)
    {
      AudioFocusManager.this.handleAudioFocusChange(paramAnonymousInt);
    }
  };
  private final AudioManager mAudioManager;
  int mLastLossFocusMode;
  AudioFocusable mPlayer;

  public AudioFocusManager(Context paramContext)
  {
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
  }

  public void abandonAudioFocus()
  {
    this.mPlayer = null;
    this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
  }

  void handleAudioFocusChange(int paramInt)
  {
    if (this.mPlayer == null)
      return;
    switch (paramInt)
    {
    case 0:
    default:
      return;
    case -3:
      this.mLastLossFocusMode = paramInt;
      this.mPlayer.onLossAudioFocusCanDuck();
      return;
    case 1:
      switch (this.mLastLossFocusMode)
      {
      default:
      case -1:
      case -2:
      case -3:
      }
      while (true)
      {
        this.mLastLossFocusMode = 0;
        return;
        this.mPlayer.onGainAudioFocus();
        continue;
        this.mPlayer.onGainAudioFocusTransient();
        continue;
        this.mPlayer.onGainAudioFocusMayDuck();
      }
    case -1:
      this.mLastLossFocusMode = paramInt;
      this.mPlayer.onLossAudioFocus();
      return;
    case -2:
    }
    this.mLastLossFocusMode = paramInt;
    this.mPlayer.onLossAudioFocusTransient();
  }

  public boolean requestAudioFocus(AudioFocusable paramAudioFocusable, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramAudioFocusable == null)
      return false;
    this.mPlayer = paramAudioFocusable;
    if (this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, paramInt1, paramInt2) == i);
    while (true)
    {
      return i;
      int j = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.audiofocus.AudioFocusManager
 * JD-Core Version:    0.6.2
 */