package com.viber.voip.sound;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer.PlaybackListener;
import com.viber.voip.util.bw;

public class MessageSoundPlayer<T>
{
  private static final Logger L = ViberEnv.getLogger();
  private final AudioFocusManager mAudioFocusManager;
  private final AudioManager mAudioManager;
  private final Context mContext;
  private T mCurrenltyPlaying;
  private Listener<T> mListener;
  private final AudioFocusableMediaPlayer.PlaybackListener mPlaybackListener = new AudioFocusableMediaPlayer.PlaybackListener()
  {
    public void onPlayStarted()
    {
      MessageSoundPlayer.this.onSoundStarted();
    }

    public void onPlayStopped(int paramAnonymousInt)
    {
      MessageSoundPlayer.this.onSoundStopped(paramAnonymousInt);
    }
  };
  private final Object mPlayerLock = new Object();
  private AudioFocusableMediaPlayer mSoundPlayer;
  private final TelephonyManager mTelephonyManager;
  private final Handler mUiHandler;

  public MessageSoundPlayer(Context paramContext, Listener<T> paramListener)
  {
    this.mAudioFocusManager = new AudioFocusManager(paramContext);
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.mTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.mContext = paramContext;
    this.mUiHandler = av.a(av.e.a);
    this.mListener = paramListener;
  }

  private void pauseInternal()
  {
    synchronized (this.mPlayerLock)
    {
      if (this.mSoundPlayer == null)
        return;
      this.mSoundPlayer.pause();
      return;
    }
  }

  private void playInternal(Uri paramUri, int paramInt)
  {
    synchronized (this.mPlayerLock)
    {
      this.mSoundPlayer = new AudioFocusableMediaPlayer(paramInt, this.mAudioFocusManager, this.mContext);
      this.mSoundPlayer.setPlaybackListener(this.mPlaybackListener);
      this.mSoundPlayer.play(paramUri, 3);
      return;
    }
  }

  private void resumeInternal()
  {
    synchronized (this.mPlayerLock)
    {
      if (this.mSoundPlayer == null)
        return;
      this.mSoundPlayer.resume();
      return;
    }
  }

  private void stopInternal()
  {
    while (true)
    {
      synchronized (this.mPlayerLock)
      {
        if (this.mSoundPlayer == null)
          return;
        if (this.mSoundPlayer.isPlaying())
        {
          this.mSoundPlayer.stop();
          this.mSoundPlayer = null;
          return;
        }
      }
      this.mSoundPlayer.cancel();
    }
  }

  public boolean isPlaying(T paramT)
  {
    if (this.mCurrenltyPlaying == null);
    while ((!this.mCurrenltyPlaying.equals(paramT)) || (this.mSoundPlayer == null) || (!this.mSoundPlayer.isPlaying()))
      return false;
    return true;
  }

  final void onSoundStarted()
  {
    if (this.mListener == null);
    while (this.mCurrenltyPlaying == null)
      return;
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        MessageSoundPlayer.this.mListener.onSoundStarted(MessageSoundPlayer.this.mCurrenltyPlaying);
      }
    });
  }

  final void onSoundStopped(final int paramInt)
  {
    if (this.mListener == null);
    while (this.mCurrenltyPlaying == null)
      return;
    final Object localObject = this.mCurrenltyPlaying;
    this.mCurrenltyPlaying = null;
    this.mUiHandler.post(new Runnable()
    {
      public void run()
      {
        MessageSoundPlayer.this.mListener.onSoundStopped(localObject, paramInt);
      }
    });
  }

  public void pause(T paramT)
  {
    if (!isPlaying(paramT))
      return;
    pauseInternal();
  }

  public boolean play(T paramT, Uri paramUri)
  {
    if (bw.a(this.mTelephonyManager))
      return false;
    if (this.mCurrenltyPlaying != null)
      stopInternal();
    this.mCurrenltyPlaying = paramT;
    if ((this.mAudioManager.isWiredHeadsetOn()) || (this.mAudioManager.isBluetoothA2dpOn()));
    for (int i = 3; ; i = 5)
    {
      playInternal(paramUri, i);
      return true;
    }
  }

  public void resume(T paramT)
  {
    if (this.mCurrenltyPlaying == null);
    while (isPlaying(paramT))
      return;
    resumeInternal();
  }

  public void stop(T paramT)
  {
    if ((this.mCurrenltyPlaying == null) || (!this.mCurrenltyPlaying.equals(paramT)))
      return;
    stopInternal();
  }

  public static abstract interface Listener<T>
  {
    public abstract void onSoundStarted(T paramT);

    public abstract void onSoundStopped(T paramT, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.MessageSoundPlayer
 * JD-Core Version:    0.6.2
 */