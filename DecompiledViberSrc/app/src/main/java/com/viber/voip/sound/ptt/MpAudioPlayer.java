package com.viber.voip.sound.ptt;

import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.q.e;
import com.viber.voip.q.g;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class MpAudioPlayer
  implements AudioPlayer
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int PROGRESS_REPORT_PERIOD_IN_MS = 200;
  ReportListener defaultListener = new ReportListener();
  private Handler handler = av.a(av.e.f);
  private boolean isPlayerPaused = false;
  private boolean isPlayerStopped = false;
  private final int mDefaultAudioStream;
  private MpWrapper mMediaPlayer;
  private boolean mPlayToSpeaker = true;
  private String pathToFile;
  private Runnable playProcessUpdater = new Runnable()
  {
    public void run()
    {
      if ((MpAudioPlayer.this.mMediaPlayer != null) && (MpAudioPlayer.this.isPlaying()))
      {
        MpAudioPlayer.this.playerBus.post(new e(MpAudioPlayer.this.pttId, MpAudioPlayer.this.mMediaPlayer.getCurrentPosition()));
        MpAudioPlayer.this.handler.postDelayed(this, 200L);
      }
    }
  };
  private EventBus playerBus;
  private String pttId;

  public MpAudioPlayer(EventBus paramEventBus, String paramString, File paramFile, int paramInt)
  {
    this.pathToFile = paramFile.getAbsolutePath();
    this.playerBus = paramEventBus;
    this.pttId = paramString;
    this.mDefaultAudioStream = paramInt;
  }

  private void createPlayer(int paramInt)
  {
    this.mMediaPlayer = new MpWrapper(paramInt, ViberApplication.getApplication());
    this.mMediaPlayer.setVolume(1.0F, 1.0F);
    this.mMediaPlayer.setPlaybackListener(this.defaultListener);
  }

  public long getPlayingPositionInMillis()
  {
    return this.mMediaPlayer.getCurrentPosition();
  }

  public void interruptPlay(int paramInt)
  {
    trackProgress(false);
    this.mMediaPlayer.setPlaybackListener(null);
    this.mMediaPlayer.reset();
    this.playerBus.post(g.a(this.pttId, paramInt));
  }

  public boolean isPaused()
  {
    return this.isPlayerPaused;
  }

  public boolean isPlaying()
  {
    return (this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying());
  }

  public boolean isStopped()
  {
    return this.isPlayerStopped;
  }

  public void pause()
  {
    this.mMediaPlayer.pause();
  }

  public void resume(long paramLong)
  {
    if (paramLong > 0L)
      this.mMediaPlayer.seekTo((int)paramLong);
    this.mMediaPlayer.resume();
  }

  public void seek(long paramLong)
  {
    this.mMediaPlayer.seekTo((int)paramLong);
  }

  public void startPlay()
  {
    startPlay(0L);
  }

  public void startPlay(long paramLong)
  {
    try
    {
      createPlayer(this.mDefaultAudioStream);
      SetPositionListener localSetPositionListener = new SetPositionListener((int)paramLong);
      this.mMediaPlayer.setPlaybackListener(localSetPositionListener);
      this.mMediaPlayer.play(Uri.parse(this.pathToFile));
      this.playerBus.post(g.a(this.pttId, paramLong));
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.playerBus.post(g.a(this.pttId, 3));
        localException.printStackTrace();
      }
    }
    finally
    {
    }
  }

  public void stopPlay()
  {
    this.mMediaPlayer.stop();
  }

  public void switchStreams(boolean paramBoolean)
  {
    try
    {
      int i;
      if (this.mPlayToSpeaker != paramBoolean)
      {
        this.mPlayToSpeaker = paramBoolean;
        if (!this.mPlayToSpeaker)
          break label41;
        i = this.mDefaultAudioStream;
        MpWrapper localMpWrapper = this.mMediaPlayer;
        if (localMpWrapper != null)
          break label46;
      }
      while (true)
      {
        return;
        label41: i = 0;
        break;
        label46: int j = (int)this.mMediaPlayer.getCurrentPosition();
        this.mMediaPlayer.setPlaybackListener(null);
        this.mMediaPlayer.reset();
        createPlayer(i);
        this.mMediaPlayer.setPlaybackListener(new SetPositionListener(j));
        this.mMediaPlayer.play(Uri.parse(this.pathToFile));
      }
    }
    finally
    {
    }
  }

  void trackProgress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.handler.post(this.playProcessUpdater);
      return;
    }
    this.handler.removeCallbacks(this.playProcessUpdater);
  }

  class ReportListener
    implements MpWrapper.PlaybackListener
  {
    ReportListener()
    {
    }

    public void onMediaPrepared()
    {
    }

    public void onPlayPaused()
    {
      MpAudioPlayer.this.playerBus.post(g.b(MpAudioPlayer.this.pttId, MpAudioPlayer.this.mMediaPlayer.getCurrentPosition()));
      MpAudioPlayer.this.trackProgress(false);
      MpAudioPlayer.access$502(MpAudioPlayer.this, true);
      MpAudioPlayer.access$402(MpAudioPlayer.this, false);
    }

    public void onPlayResumed()
    {
      MpAudioPlayer.this.playerBus.post(g.c(MpAudioPlayer.this.pttId, MpAudioPlayer.this.mMediaPlayer.getCurrentPosition()));
      MpAudioPlayer.this.trackProgress(true);
      MpAudioPlayer.access$402(MpAudioPlayer.this, false);
      MpAudioPlayer.access$502(MpAudioPlayer.this, false);
    }

    public void onPlayStarted()
    {
      MpAudioPlayer.this.trackProgress(true);
      MpAudioPlayer.access$402(MpAudioPlayer.this, false);
      MpAudioPlayer.access$502(MpAudioPlayer.this, false);
    }

    public void onPlayStopped(int paramInt)
    {
      MpAudioPlayer.this.playerBus.post(g.a(MpAudioPlayer.this.pttId, paramInt));
      MpAudioPlayer.this.trackProgress(false);
      MpAudioPlayer.access$402(MpAudioPlayer.this, true);
      MpAudioPlayer.access$502(MpAudioPlayer.this, false);
    }
  }

  class SetPositionListener
    implements MpWrapper.PlaybackListener
  {
    private int pos;

    SetPositionListener(int arg2)
    {
      int i;
      this.pos = i;
    }

    public void onMediaPrepared()
    {
      MpAudioPlayer.this.mMediaPlayer.seekTo(this.pos);
      MpAudioPlayer.this.mMediaPlayer.setPlaybackListener(MpAudioPlayer.this.defaultListener);
    }

    public void onPlayPaused()
    {
    }

    public void onPlayResumed()
    {
    }

    public void onPlayStarted()
    {
      MpAudioPlayer.this.mMediaPlayer.setPlaybackListener(MpAudioPlayer.this.defaultListener);
    }

    public void onPlayStopped(int paramInt)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.MpAudioPlayer
 * JD-Core Version:    0.6.2
 */