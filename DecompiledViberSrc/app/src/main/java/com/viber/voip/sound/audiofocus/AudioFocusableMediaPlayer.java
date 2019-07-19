package com.viber.voip.sound.audiofocus;

import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.IOException;

public class AudioFocusableMediaPlayer
  implements AudioFocusable
{
  private static final Logger L = ViberEnv.getLogger();
  private final AudioFocusManager mAudioFocusManager;
  private int mAudioFocusMode = 0;
  private final Context mContext;
  private Uri mDataSource;
  private boolean mIsCancelled;
  private boolean mIsPrepared;
  private float mLeftVolume = 1.0F;
  private final MediaPlayer mMediaPlayer;
  private PlaybackListener mPlaybackListener;
  private float mRightVolume = 1.0F;
  private final int mStreamType;

  public AudioFocusableMediaPlayer(int paramInt, AudioFocusManager paramAudioFocusManager, Context paramContext)
  {
    this.mAudioFocusManager = paramAudioFocusManager;
    this.mContext = paramContext;
    this.mMediaPlayer = new MediaPlayer();
    this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AudioFocusableMediaPlayer.this.onMediaPrepared();
      }
    });
    this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        if (!AudioFocusableMediaPlayer.this.mMediaPlayer.isLooping())
          AudioFocusableMediaPlayer.this.onMediaComplete(0);
      }
    });
    this.mMediaPlayer.setAudioStreamType(paramInt);
    if (a.g())
      this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(paramInt).build());
    this.mStreamType = paramInt;
  }

  private void stop(int paramInt)
  {
    if (isPlaying());
    try
    {
      this.mMediaPlayer.stop();
      label14: onMediaComplete(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label14;
    }
  }

  public void cancel()
  {
    this.mIsCancelled = true;
    onMediaComplete(0);
  }

  public int getAudioStreamType()
  {
    return this.mStreamType;
  }

  public float getLeftVolume()
  {
    return this.mLeftVolume;
  }

  public float getRightVolume()
  {
    return this.mRightVolume;
  }

  public boolean isPlaying()
  {
    try
    {
      boolean bool = this.mMediaPlayer.isPlaying();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return false;
  }

  public void onGainAudioFocus()
  {
    if (!this.mIsPrepared)
      if (this.mDataSource != null);
    while (true)
    {
      return;
      try
      {
        this.mMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
        this.mMediaPlayer.start();
        if (this.mPlaybackListener != null)
        {
          this.mPlaybackListener.onPlayStarted();
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
      }
    }
  }

  public void onGainAudioFocusMayDuck()
  {
    this.mMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
  }

  public void onGainAudioFocusTransient()
  {
    onGainAudioFocus();
  }

  public void onLossAudioFocus()
  {
    stop(1);
  }

  public void onLossAudioFocusCanDuck()
  {
    this.mMediaPlayer.setVolume(0.2F, 0.2F);
  }

  public void onLossAudioFocusTransient()
  {
    onLossAudioFocus();
  }

  final void onMediaComplete(int paramInt)
  {
    if ((this.mIsPrepared) && (this.mAudioFocusMode != 0))
      this.mAudioFocusManager.abandonAudioFocus();
    this.mAudioFocusMode = 0;
    if (this.mIsPrepared);
    try
    {
      this.mMediaPlayer.reset();
      label40: this.mMediaPlayer.release();
      if (this.mPlaybackListener != null)
        this.mPlaybackListener.onPlayStopped(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label40;
    }
  }

  final void onMediaPrepared()
  {
    if (this.mIsCancelled)
    {
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
    }
    do
    {
      return;
      this.mIsPrepared = true;
    }
    while ((this.mAudioFocusMode != 0) && (!this.mAudioFocusManager.requestAudioFocus(this, this.mStreamType, this.mAudioFocusMode)));
    onGainAudioFocus();
  }

  public void pause()
  {
    if (!isPlaying())
      return;
    try
    {
      this.mMediaPlayer.pause();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void play(Uri paramUri, int paramInt)
  {
    if (isPlaying())
      return;
    this.mIsCancelled = false;
    this.mIsPrepared = false;
    this.mAudioFocusMode = paramInt;
    try
    {
      this.mDataSource = paramUri;
      this.mMediaPlayer.setDataSource(this.mContext, paramUri);
      this.mMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void resume()
  {
    if (isPlaying())
      return;
    try
    {
      this.mMediaPlayer.start();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void setLooping(boolean paramBoolean)
  {
    this.mMediaPlayer.setLooping(paramBoolean);
  }

  public void setPlaybackListener(PlaybackListener paramPlaybackListener)
  {
    this.mPlaybackListener = paramPlaybackListener;
  }

  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mLeftVolume = paramFloat1;
    this.mRightVolume = paramFloat2;
    this.mMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }

  public void stop()
  {
    stop(0);
  }

  public String toString()
  {
    return "MediaPlayer {audioFocusMode = " + this.mAudioFocusMode + ", uri = " + this.mDataSource + ", prepared = " + this.mIsPrepared + ", cancelled = " + this.mIsCancelled + ", volume = [" + this.mLeftVolume + ", " + this.mRightVolume + "], streamType = " + this.mStreamType + "}";
  }

  public static abstract interface PlaybackListener
  {
    public abstract void onPlayStarted();

    public abstract void onPlayStopped(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer
 * JD-Core Version:    0.6.2
 */