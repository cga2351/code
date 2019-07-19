package com.viber.voip.messages.ui.media.player;

import com.viber.voip.util.ch;

public abstract class b
  implements MediaPlayerControls.a
{
  private MediaPlayer a = MediaPlayer.b;

  public void a()
  {
    this.a.a();
  }

  public void a(int paramInt)
  {
    ch.a(this.a, paramInt);
  }

  public final void a(MediaPlayer paramMediaPlayer)
  {
    this.a = paramMediaPlayer;
  }

  public void b()
  {
    this.a.b();
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
  }

  public void g()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.b
 * JD-Core Version:    0.6.2
 */