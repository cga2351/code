package com.viber.voip.sound.ptt;

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

public class MpWrapper
{
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;
  private Uri mDataSource;
  private boolean mIsCancelled;
  private boolean mIsPrepared;
  private float mLeftVolume = 1.0F;
  private final MediaPlayer mMediaPlayer;
  private PlaybackListener mPlaybackListener;
  private float mRightVolume = 1.0F;
  private final int mStreamType;

  public MpWrapper(int paramInt, Context paramContext)
  {
    this.mContext = paramContext;
    this.mMediaPlayer = new MediaPlayer();
    this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        MpWrapper.this.onMediaPrepared();
      }
    });
    this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        if (!MpWrapper.this.mMediaPlayer.isLooping())
          MpWrapper.this.onMediaComplete(2);
      }
    });
    this.mMediaPlayer.setAudioStreamType(paramInt);
    if (a.g())
      this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(paramInt).build());
    this.mStreamType = paramInt;
  }

  private void pauseMp()
  {
    if (this.mPlaybackListener != null)
      this.mPlaybackListener.onPlayPaused();
  }

  private void resumeMp()
  {
    if (this.mPlaybackListener != null)
      this.mPlaybackListener.onPlayResumed();
  }

  private void startMp()
  {
    if (this.mPlaybackListener != null)
      this.mPlaybackListener.onPlayStarted();
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

  private void stopMp(int paramInt)
  {
    if (this.mPlaybackListener != null)
      this.mPlaybackListener.onPlayStopped(paramInt);
  }

  public void cancel()
  {
    this.mIsCancelled = true;
    onMediaComplete(0);
  }

  public long getCurrentPosition()
  {
    try
    {
      int i = this.mMediaPlayer.getCurrentPosition();
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return 0L;
  }

  public boolean isPlaying()
  {
    try
    {
      boolean bool = this.mMediaPlayer.isPlaying();
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      return false;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return false;
  }

  final void onMediaComplete(int paramInt)
  {
    if (this.mIsPrepared);
    try
    {
      this.mMediaPlayer.reset();
      label14: this.mMediaPlayer.release();
      stopMp(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label14;
    }
  }

  final void onMediaPrepared()
  {
    if (this.mPlaybackListener != null)
      this.mPlaybackListener.onMediaPrepared();
    if (this.mIsCancelled)
    {
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      return;
    }
    this.mIsPrepared = true;
    startPlay();
  }

  public void pause()
  {
    if (!isPlaying())
      return;
    try
    {
      this.mMediaPlayer.pause();
      pauseMp();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void play(Uri paramUri)
  {
    if (isPlaying())
      return;
    this.mIsCancelled = false;
    this.mIsPrepared = false;
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

  final void reset()
  {
    try
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      return;
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
      resumeMp();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void seekTo(int paramInt)
  {
    this.mMediaPlayer.seekTo(paramInt);
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

  public void startPlay()
  {
    if (!this.mIsPrepared)
    {
      if (this.mDataSource == null);
      return;
    }
    try
    {
      this.mMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
      this.mMediaPlayer.start();
      startMp();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void stop()
  {
    stop(0);
  }

  public String toString()
  {
    return "MediaPlayer {, uri = " + this.mDataSource + ", prepared = " + this.mIsPrepared + ", cancelled = " + this.mIsCancelled + ", volume = [" + this.mLeftVolume + ", " + this.mRightVolume + "], streamType = " + this.mStreamType + "}";
  }

  public static abstract interface PlaybackListener
  {
    public abstract void onMediaPrepared();

    public abstract void onPlayPaused();

    public abstract void onPlayResumed();

    public abstract void onPlayStarted();

    public abstract void onPlayStopped(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.MpWrapper
 * JD-Core Version:    0.6.2
 */