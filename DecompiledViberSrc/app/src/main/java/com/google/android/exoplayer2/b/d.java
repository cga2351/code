package com.google.android.exoplayer2.b;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;

public final class d
{
  private final AudioManager a;
  private final a b;
  private final b c;
  private b d;
  private int e;
  private int f;
  private float g = 1.0F;
  private AudioFocusRequest h;
  private boolean i;

  public d(Context paramContext, b paramb)
  {
    if (paramContext == null);
    for (AudioManager localAudioManager = null; ; localAudioManager = (AudioManager)paramContext.getApplicationContext().getSystemService("audio"))
    {
      this.a = localAudioManager;
      this.c = paramb;
      this.b = new a(null);
      this.e = 0;
      return;
    }
  }

  private static int a(b paramb)
  {
    if (paramb == null)
      return 0;
    switch (paramb.d)
    {
    case 3:
    case 15:
    default:
      l.c("AudioFocusManager", "Unidentified audio usage: " + paramb.d);
      return 0;
    case 1:
    case 14:
      return 1;
    case 0:
      l.c("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
      return 1;
    case 2:
    case 4:
      return 2;
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 12:
    case 13:
      return 3;
    case 16:
      if (ag.a >= 19)
        return 4;
      return 2;
    case 11:
    }
    if (paramb.b == 1)
      return 2;
    return 3;
  }

  private int b(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1;
    return -1;
  }

  private int c()
  {
    if (this.f == 0)
    {
      if (this.e != 0)
        c(true);
      return 1;
    }
    int m;
    if (this.e == 0)
    {
      if (ag.a < 26)
        break label64;
      m = f();
      if (m != 1)
        break label72;
    }
    label64: label72: for (int n = 1; ; n = 0)
    {
      this.e = n;
      if (this.e != 0)
        break label78;
      return -1;
      m = e();
      break;
    }
    label78: int j = this.e;
    int k = 0;
    if (j == 2);
    while (true)
    {
      return k;
      k = 1;
    }
  }

  private void c(boolean paramBoolean)
  {
    if ((this.f == 0) && (this.e == 0));
    while ((this.f == 1) && (this.e != -1) && (!paramBoolean))
      return;
    if (ag.a >= 26)
      h();
    while (true)
    {
      this.e = 0;
      return;
      g();
    }
  }

  private void d()
  {
    c(false);
  }

  private int e()
  {
    return ((AudioManager)a.a(this.a)).requestAudioFocus(this.b, ag.f(((b)a.a(this.d)).d), this.f);
  }

  private int f()
  {
    if ((this.h == null) || (this.i))
      if (this.h != null)
        break label96;
    label96: for (AudioFocusRequest.Builder localBuilder = new AudioFocusRequest.Builder(this.f); ; localBuilder = new AudioFocusRequest.Builder(this.h))
    {
      boolean bool = i();
      this.h = localBuilder.setAudioAttributes(((b)a.a(this.d)).a()).setWillPauseWhenDucked(bool).setOnAudioFocusChangeListener(this.b).build();
      this.i = false;
      return ((AudioManager)a.a(this.a)).requestAudioFocus(this.h);
    }
  }

  private void g()
  {
    ((AudioManager)a.a(this.a)).abandonAudioFocus(this.b);
  }

  private void h()
  {
    if (this.h != null)
      ((AudioManager)a.a(this.a)).abandonAudioFocusRequest(this.h);
  }

  private boolean i()
  {
    return (this.d != null) && (this.d.b == 1);
  }

  public float a()
  {
    return this.g;
  }

  public int a(b paramb, boolean paramBoolean, int paramInt)
  {
    if ((this.d == null) && (paramb == null))
    {
      if (paramBoolean)
        return 1;
      return -1;
    }
    a.a(this.a, "SimpleExoPlayer must be created with a context to handle audio focus.");
    if (!ag.a(this.d, paramb))
    {
      this.d = paramb;
      this.f = a(paramb);
      if ((this.f == 1) || (this.f == 0));
      for (boolean bool = true; ; bool = false)
      {
        a.a(bool, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        if ((!paramBoolean) || ((paramInt != 2) && (paramInt != 3)))
          break;
        return c();
      }
    }
    if (paramInt == 1)
      return b(paramBoolean);
    return a(paramBoolean);
  }

  public int a(boolean paramBoolean)
  {
    if (this.a == null)
      return 1;
    if (paramBoolean)
      return c();
    return -1;
  }

  public int a(boolean paramBoolean, int paramInt)
  {
    if (this.a == null)
      return 1;
    if (!paramBoolean)
    {
      d();
      return -1;
    }
    if (paramInt == 1)
      return b(paramBoolean);
    return c();
  }

  public void b()
  {
    if (this.a == null)
      return;
    c(true);
  }

  private class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    private a()
    {
    }

    public void onAudioFocusChange(int paramInt)
    {
      switch (paramInt)
      {
      case 0:
      default:
        l.c("AudioFocusManager", "Unknown focus change type: " + paramInt);
        return;
      case -1:
        d.a(d.this, -1);
      case -2:
      case -3:
      case 1:
      }
      while (true)
        switch (d.b(d.this))
        {
        default:
          throw new IllegalStateException("Unknown audio focus state: " + d.b(d.this));
          d.a(d.this, 2);
          continue;
          if (d.a(d.this))
          {
            d.a(d.this, 2);
          }
          else
          {
            d.a(d.this, 3);
            continue;
            d.a(d.this, 1);
          }
          break;
        case -1:
        case 0:
        case 3:
        case 2:
        case 1:
        }
      d.c(d.this).b(-1);
      d.a(d.this, true);
      label224: if (d.b(d.this) == 3);
      for (float f = 0.2F; d.d(d.this) != f; f = 1.0F)
      {
        d.a(d.this, f);
        d.c(d.this).a(f);
        return;
        d.c(d.this).b(0);
        break label224;
        d.c(d.this).b(1);
        break label224;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void a(float paramFloat);

    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.d
 * JD-Core Version:    0.6.2
 */