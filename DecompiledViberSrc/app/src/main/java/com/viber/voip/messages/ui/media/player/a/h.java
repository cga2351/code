package com.viber.voip.messages.ui.media.player.a;

import android.widget.SeekBar.OnSeekBarChangeListener;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.util.ag;
import com.viber.voip.util.ak;
import com.viber.voip.util.cl;

public abstract interface h
{
  public static final h q = (h)cl.b(h.class);
  public static final a r = (a)cl.b(a.class);

  public abstract void a();

  public abstract void a(int paramInt, long paramLong1, long paramLong2);

  public abstract void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener);

  public abstract void a(g paramg);

  public abstract void a(MediaPlayerControls.VisualSpec paramVisualSpec);

  public abstract void a(a parama);

  public abstract void b();

  public abstract void b(int paramInt);

  public abstract void b(boolean paramBoolean);

  @ak(a=MediaPlayerControls.VisualSpec.class)
  public abstract MediaPlayerControls.VisualSpec c();

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  public abstract void h();

  @ag(a=true)
  public abstract boolean i();

  public static abstract interface a
  {
    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.h
 * JD-Core Version:    0.6.2
 */