package com.my.target;

import android.content.Context;
import android.view.TextureView;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.aj;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.y;
import com.my.target.common.a.c;

public class bo
  implements aa.a, bn
{
  private final bh a = bh.a(200);
  private final aj b;
  private final a c;
  private bn.a d;
  private boolean e;
  private boolean f;
  private n g;
  private c h;

  private bo(Context paramContext)
  {
    this(k.a(paramContext, new DefaultTrackSelector()), new a());
  }

  bo(aj paramaj, a parama)
  {
    this.b = paramaj;
    this.c = parama;
    this.b.a(this);
    parama.a(this.b);
  }

  public static bo a(Context paramContext)
  {
    return new bo(paramContext);
  }

  public void a(long paramLong)
  {
    this.b.a(paramLong);
  }

  public void a(bn.a parama)
  {
    this.d = parama;
    this.c.a(parama);
  }

  public void a(c paramc, TextureView paramTextureView)
  {
    dp.a("Play video in ExoPlayer");
    this.h = paramc;
    this.f = false;
    if (this.d != null)
      this.d.f();
    this.b.a(paramTextureView);
    if ((this.h != paramc) || (!this.e))
    {
      this.g = bp.a(paramc, paramTextureView.getContext());
      this.b.a(this.g);
    }
    this.b.a(true);
  }

  public boolean a()
  {
    return this.e;
  }

  public void b()
  {
    this.h = null;
    this.e = false;
    this.f = false;
    this.b.a(null);
    this.b.c();
    this.b.q();
    this.b.b(this);
    this.a.b(this.c);
  }

  public boolean c()
  {
    return (this.e) && (this.f);
  }

  public void d()
  {
    this.b.c();
  }

  public void e()
  {
    this.b.a(0.2F);
  }

  public void f()
  {
    this.b.a(0.0F);
    if (this.d != null)
      this.d.a(0.0F);
  }

  public void g()
  {
    this.b.a(1.0F);
    if (this.d != null)
      this.d.a(1.0F);
  }

  public void h()
  {
    if (this.e)
      this.b.a(true);
    while (this.g == null)
      return;
    this.b.a(this.g, true, true);
  }

  public void i()
  {
    if ((this.e) && (!this.f))
      this.b.a(false);
  }

  public boolean j()
  {
    return (this.e) && (!this.f);
  }

  public c k()
  {
    return this.h;
  }

  public boolean l()
  {
    return this.b.p() == 0.0F;
  }

  public long m()
  {
    return this.b.t();
  }

  public void onLoadingChanged(boolean paramBoolean)
  {
  }

  public void onPlaybackParametersChanged(y paramy)
  {
  }

  public void onPlayerError(i parami)
  {
    this.f = false;
    this.e = false;
    if (this.d != null)
    {
      String str = parami.getMessage();
      if (str == null)
        str = "Unknown video error";
      this.d.a(str);
    }
    this.b.q();
  }

  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return;
    case 3:
      if (paramBoolean)
      {
        if (this.d != null)
          this.d.c();
        if (!this.e)
          this.e = true;
        while (true)
        {
          this.a.a(this.c);
          return;
          if (this.f)
          {
            this.f = false;
            if (this.d != null)
              this.d.e();
          }
        }
      }
      if ((!this.f) && (this.d != null))
      {
        this.f = true;
        this.d.d();
      }
      this.a.b(this.c);
      return;
    case 4:
      this.f = false;
      this.e = false;
      float f1 = (float)this.b.s() / 1000.0F;
      if (this.d != null)
      {
        this.d.a(f1, f1);
        this.d.g();
      }
      this.a.b(this.c);
      return;
    case 1:
    }
    if (this.e)
    {
      this.e = false;
      if (this.d != null)
        this.d.b();
    }
    this.a.b(this.c);
  }

  public void onPositionDiscontinuity(int paramInt)
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

  public void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
  {
  }

  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, g paramg)
  {
  }

  public static class a
    implements Runnable
  {
    private aj a;
    private bn.a b;

    void a(aj paramaj)
    {
      this.a = paramaj;
    }

    void a(bn.a parama)
    {
      this.b = parama;
    }

    public void run()
    {
      if ((this.b != null) && (this.a != null))
      {
        float f1 = (float)this.a.t() / 1000.0F;
        float f2 = (float)this.a.s() / 1000.0F;
        this.b.a(f1, f2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bo
 * JD-Core Version:    0.6.2
 */