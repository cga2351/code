package com.viber.voip.phone.vptt.v2;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.aj;
import com.google.android.exoplayer2.aj.b;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.b.b.a;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.mp4.h;
import com.google.android.exoplayer2.f.n;
import com.google.android.exoplayer2.f.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.a.a;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.y;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.vptt.VideoPttPlayer;
import com.viber.voip.phone.vptt.VideoPttPlayer.Completion;
import com.viber.voip.phone.vptt.VideoPttPlayerProxy;
import com.viber.voip.util.da;
import com.viber.voip.widget.d.a;

public class ExoVideoPttPlayer
  implements aa.a, aj.b, VideoPttPlayer
{
  private static Logger L = ViberEnv.getLogger();
  private static final float defaultVolume = 1.0F;
  private Context context;
  private boolean mIsBuffering;
  private aj mPlayer;
  private boolean muted;
  private VideoPttPlayer.Completion startedCompletion;
  private VideoPttPlayer.Completion stoppedCompletion;
  private PlayerView target;

  public ExoVideoPttPlayer(Context paramContext)
  {
    this.context = paramContext;
  }

  public static VideoPttPlayer create()
  {
    Handler localHandler = av.a(av.e.a);
    return new VideoPttPlayerProxy(new ExoVideoPttPlayer(ViberApplication.getApplication()), localHandler);
  }

  private void reset()
  {
    this.target = null;
    this.startedCompletion = null;
    this.stoppedCompletion = null;
    this.muted = false;
  }

  public void dispose()
  {
    stop();
    if (this.mPlayer != null)
    {
      this.mPlayer.q();
      this.mPlayer = null;
    }
    reset();
  }

  public boolean isPlaying()
  {
    if (this.mPlayer == null)
      return false;
    switch (this.mPlayer.j())
    {
    default:
      return false;
    case 2:
    case 3:
    }
    return this.mPlayer.l();
  }

  public void onCompletion()
  {
    if (this.mPlayer != null)
    {
      this.mPlayer.a(0L);
      this.mPlayer.a(false);
      this.mPlayer.b(null);
    }
    if (this.stoppedCompletion != null)
      this.stoppedCompletion.onCompletion(null);
  }

  public void onLoadingChanged(boolean paramBoolean)
  {
  }

  public void onPlaybackParametersChanged(y paramy)
  {
  }

  public void onPlayerError(i parami)
  {
  }

  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    if (this.mIsBuffering)
      switch (paramInt)
      {
      default:
      case 3:
      case 4:
      }
    while (true)
      switch (paramInt)
      {
      case 1:
      case 3:
      default:
        return;
        this.mIsBuffering = false;
      case 2:
      case 4:
      }
    this.mIsBuffering = true;
    return;
    onCompletion();
  }

  public void onPositionDiscontinuity(int paramInt)
  {
  }

  public void onRenderedFirstFrame()
  {
  }

  public void onRepeatModeChanged(int paramInt)
  {
  }

  public void onSeekProcessed()
  {
  }

  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
  }

  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    com.google.android.exoplayer2.video.g.a(this, paramInt1, paramInt2);
  }

  public void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
  {
  }

  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g paramg)
  {
  }

  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
  }

  public void pause()
  {
    if (isPlaying())
      this.mPlayer.a(false);
  }

  public void play()
  {
    if (!isPlaying())
      this.mPlayer.a(true);
  }

  public void prepareVideoPlayer(Uri paramUri)
  {
    if (this.mPlayer != null)
    {
      this.mPlayer.c();
      this.mPlayer.q();
      this.mPlayer = null;
    }
    DefaultTrackSelector localDefaultTrackSelector = new DefaultTrackSelector(new a.a(new n()));
    this.mPlayer = k.a(this.context, localDefaultTrackSelector);
    com.google.android.exoplayer2.b.b localb = new b.a().a(3).b(1).a();
    this.mPlayer.a(localb);
    this.target.setPlayer(this.mPlayer);
    l locall = new l(paramUri, new q(this.context, ag.a(this.context, "Viber")), new j()
    {
      public com.google.android.exoplayer2.extractor.g[] createExtractors()
      {
        com.google.android.exoplayer2.extractor.g[] arrayOfg = new com.google.android.exoplayer2.extractor.g[1];
        arrayOfg[0] = new h();
        return arrayOfg;
      }
    }
    , null, null);
    this.mPlayer.a(locall);
    this.mPlayer.a(this);
    this.mPlayer.a(this);
    this.mPlayer.a(1.0F);
  }

  public void restartUnmuted(VideoPttPlayer.Completion paramCompletion)
  {
    stop();
    this.mPlayer.a(1.0F);
    paramCompletion.onCompletion(null);
    play();
  }

  public void startVideoPttPlay(int paramInt, String paramString, a parama, boolean paramBoolean, VideoPttPlayer.Completion paramCompletion1, VideoPttPlayer.Completion paramCompletion2)
  {
    if (da.a(paramString))
      return;
    this.target = ((com.viber.voip.widget.d.a.b)parama).getPlayerView();
    this.startedCompletion = paramCompletion1;
    this.stoppedCompletion = paramCompletion2;
    this.muted = paramBoolean;
    prepareVideoPlayer(Uri.parse(paramString));
    if (paramBoolean)
      this.mPlayer.a(0.0F);
    play();
    paramCompletion1.onCompletion(null);
  }

  public void stop()
  {
    this.mPlayer.a(false);
    this.mPlayer.a(0L);
  }

  public void stopVideoPttPlay(VideoPttPlayer.Completion paramCompletion)
  {
    stop();
    paramCompletion.onCompletion(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.v2.ExoVideoPttPlayer
 * JD-Core Version:    0.6.2
 */