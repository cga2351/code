package com.viber.voip.messages.ui.media.player;

import com.viber.voip.util.ch;

public abstract class a
  implements MediaPlayer.a
{
  private MediaPlayerControls a = MediaPlayerControls.b;

  public void a(MediaPlayer paramMediaPlayer)
  {
    MediaPlayerControls localMediaPlayerControls = this.a;
    if (ch.a(paramMediaPlayer));
    for (int i = 4; ; i = 3)
    {
      localMediaPlayerControls.setVisibilityMode(i);
      this.a.a();
      return;
    }
  }

  public void a(MediaPlayer paramMediaPlayer, int paramInt)
  {
    MediaPlayerControls localMediaPlayerControls = this.a;
    if (ch.a(paramMediaPlayer));
    for (int i = 2; ; i = 1)
    {
      localMediaPlayerControls.setVisibilityMode(i);
      this.a.b();
      return;
    }
  }

  public void a(MediaPlayer paramMediaPlayer, long paramLong1, long paramLong2)
  {
    ch.a(this.a, paramLong1, paramLong2);
  }

  public final void a(MediaPlayerControls paramMediaPlayerControls)
  {
    this.a = paramMediaPlayerControls;
  }

  public void b(MediaPlayer paramMediaPlayer)
  {
    MediaPlayerControls localMediaPlayerControls = this.a;
    if (ch.a(paramMediaPlayer));
    for (int i = 6; ; i = 5)
    {
      localMediaPlayerControls.setVisibilityMode(i);
      this.a.a();
      return;
    }
  }

  public void b(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.a.setVisibilityMode(-1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a
 * JD-Core Version:    0.6.2
 */