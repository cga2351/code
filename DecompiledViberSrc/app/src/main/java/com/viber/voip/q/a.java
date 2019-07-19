package com.viber.voip.q;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.d;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.l;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.s;
import java.util.Arrays;

public class a
{
  private static final Logger d = ViberEnv.getLogger();
  private static PttUtils.AudioBarsInfo e;
  h a = new h()
  {
    private long b;
    private boolean c = true;

    private void a()
    {
      this.b = 0L;
      this.c = true;
    }

    protected void a(long paramAnonymousLong)
    {
      if ((a.a(a.this) != null) && (a.d(a.this)) && (a.e(a.this).c(a.b(a.this).p())))
      {
        long l1 = Math.round((float)paramAnonymousLong / 1000.0F);
        if (this.b != l1)
        {
          this.b = l1;
          if (a.f(a.this))
            a.a(a.this).a(paramAnonymousLong);
        }
        if (this.c)
          break label184;
      }
      label184: for (boolean bool = true; ; bool = false)
      {
        if (this.c)
        {
          this.c = false;
          a.a(a.this).a(a.a(a.this, paramAnonymousLong, a.b(a.this, a.b(a.this))));
        }
        long l2 = a.b(a.this).s() - paramAnonymousLong;
        if (l2 > 0L)
          a.a(a.this).a(l2, bool);
        return;
      }
    }

    public void a(String paramAnonymousString, int paramAnonymousInt)
    {
      if (!a.a(a.this, paramAnonymousString))
        return;
      a();
      if (3 == paramAnonymousInt)
      {
        if ((!a.b(a.this).ao()) || (a.b(a.this).s() != 0L) || (System.currentTimeMillis() - a.b(a.this).e() <= 1209600000L))
          break label143;
        a.a(a.this).f();
      }
      while (true)
      {
        a.a(a.this).a(a.b(a.this).s());
        a.a(a.this).a(0.0F);
        a.a(a.this).a(false);
        a.a(a.this).d();
        return;
        label143: if ((a.b(a.this).ap()) || (System.currentTimeMillis() - a.b(a.this).e() > 1209600000L))
          a.a(a.this).g();
        else
          a.c(a.this);
      }
    }

    public void a(String paramAnonymousString, long paramAnonymousLong)
    {
      if (!a.a(a.this, paramAnonymousString))
        return;
      a();
      a.a(a.this).a();
      a.a(a.this, a.b(a.this));
      a.a(a.this).a(a.b(a.this).s() - paramAnonymousLong, false);
    }

    public void b(String paramAnonymousString, long paramAnonymousLong)
    {
      if (!a.a(a.this, paramAnonymousString))
        return;
      a.a(a.this).a(false);
      a.a(a.this).d();
    }

    public void c(String paramAnonymousString, long paramAnonymousLong)
    {
      if (!a.a(a.this, paramAnonymousString))
        return;
      a.a(a.this).a();
      a.a(a.this).a(a.b(a.this).s() - paramAnonymousLong, false);
    }
  };
  m b = new m()
  {
    public void a(Uri paramAnonymousUri, int paramAnonymousInt)
    {
      if (paramAnonymousUri.equals(a.g(a.this)))
      {
        a.a(a.this, paramAnonymousInt);
        a.h(a.this).removeCallbacks(a.this.c);
        a.h(a.this).post(a.this.c);
      }
    }
  };
  Runnable c = new Runnable()
  {
    public void run()
    {
      if (a.a(a.this) == null)
        return;
      a.a(a.this).a(a.i(a.this));
    }
  };
  private final ai f;
  private final i g;
  private final Handler h;
  private final d i;
  private aa j;
  private a k;
  private Uri l;
  private int m;
  private long n;
  private boolean o = true;

  public a(ai paramai, i parami, Handler paramHandler, d paramd)
  {
    this.f = paramai;
    this.g = parami;
    this.h = paramHandler;
    this.i = paramd;
  }

  private float a(long paramLong1, long paramLong2)
  {
    return 1.0F * (float)paramLong1 / (float)paramLong2;
  }

  private PttUtils.AudioBarsInfo a(aa paramaa)
  {
    PttUtils.AudioBarsInfo localAudioBarsInfo = paramaa.by();
    if ((localAudioBarsInfo == null) && (paramaa.z() == 3))
      localAudioBarsInfo = c();
    return localAudioBarsInfo;
  }

  private boolean a(String paramString)
  {
    return (this.j != null) && (this.j.p() != null) && (this.j.p().equals(paramString));
  }

  private long b(aa paramaa)
  {
    long l1 = this.g.e(paramaa.p());
    float f1 = a(l1, c(paramaa));
    if (this.k != null)
    {
      if (this.o)
        this.k.a(l1);
      this.k.a(f1);
    }
    return l1;
  }

  private void b(boolean paramBoolean)
  {
    if (this.k == null)
      return;
    this.k.b(paramBoolean);
    f();
  }

  private boolean b(aa paramaa, boolean paramBoolean)
  {
    return (!paramBoolean) && (this.j != null) && (this.j.z() == 4) && (paramaa.z() == 3);
  }

  private boolean b(String paramString)
  {
    return (this.k != null) && (a(paramString));
  }

  private long c(aa paramaa)
  {
    if (paramaa == null);
    PttUtils.AudioBarsInfo localAudioBarsInfo;
    do
    {
      return 0L;
      localAudioBarsInfo = a(paramaa);
    }
    while (localAudioBarsInfo == null);
    return paramaa.s() / localAudioBarsInfo.count;
  }

  private PttUtils.AudioBarsInfo c()
  {
    if (e == null)
    {
      e = new PttUtils.AudioBarsInfo(30);
      e.count = 30;
      e.peakVolume = 127;
      e.volumes = new short[e.count];
      Arrays.fill(e.volumes, (short)(e.peakVolume / 2));
    }
    return e;
  }

  private boolean c(aa paramaa, boolean paramBoolean)
  {
    return (!paramBoolean) && (this.j != null) && (a(this.j) == null) && (a(paramaa) != null);
  }

  private void d()
  {
    this.h.removeCallbacks(this.c);
    l.a(this.b);
  }

  private void e()
  {
    l.b(this.b);
    this.h.removeCallbacks(this.c);
  }

  private void f()
  {
    Integer localInteger = l.e(this.l);
    if (localInteger != null);
    for (this.m = localInteger.intValue(); ; this.m = 0)
    {
      this.c.run();
      return;
    }
  }

  private boolean g()
  {
    return (this.j != null) && ((this.j.z() == 4) || (this.j.z() == 7));
  }

  private boolean h()
  {
    return (this.j != null) && (this.g.b() != null) && (this.g.b().equals(this.j.p()));
  }

  private void i()
  {
    if (this.j == null)
      return;
    d();
    if (!this.j.be());
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      this.f.a(this.j.a(), this.j.B());
      return;
    }
  }

  public void a()
  {
    if (this.k == null)
      return;
    this.k = null;
    this.g.b(this.a);
    e();
  }

  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.j == null);
    long l1;
    do
    {
      do
      {
        PttUtils.AudioBarsInfo localAudioBarsInfo;
        do
        {
          return;
          localAudioBarsInfo = a(this.j);
        }
        while (localAudioBarsInfo == null);
        int i1 = localAudioBarsInfo.count;
        l1 = Math.round(paramFloat2 * (float)this.j.s() / i1);
        if ((this.k != null) && (this.o))
          this.k.a(l1);
      }
      while (!paramBoolean);
      String str = this.j.p();
      if (!this.g.c(str))
        break;
      this.g.c(str, l1);
    }
    while (this.k == null);
    this.k.a(this.j.s() - l1, false);
    return;
    this.n = l1;
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.k == null)
      return;
    if (paramBoolean)
      this.n = 0L;
    PttUtils.AudioBarsInfo localAudioBarsInfo = a(paramaa);
    this.k.a(localAudioBarsInfo);
    this.l = dx.a(paramaa);
    if (s.a(this.l))
    {
      d();
      if (!paramaa.be())
        b(bool);
    }
    String str;
    while (true)
    {
      this.j = paramaa;
      return;
      bool = false;
      break;
      e();
      str = paramaa.p();
      if (!this.g.c(str))
        break label140;
      this.k.a();
      long l1 = b(paramaa);
      this.k.a(paramaa.s() - l1, false);
    }
    label140: if (this.g.d(str))
    {
      b(paramaa);
      label158: if (paramaa.be())
        break label251;
    }
    while (true)
    {
      this.k.a(bool);
      if (b(paramaa, paramBoolean))
        this.k.b();
      if ((!c(paramaa, paramBoolean)) && (paramaa.a() != -1L))
        break;
      this.k.c();
      break;
      this.k.a(paramaa.s());
      this.k.a(0.0F);
      break label158;
      label251: bool = false;
    }
  }

  public void a(a parama)
  {
    if (this.k == parama);
    do
    {
      return;
      this.k = parama;
      this.g.a(this.a);
      this.m = 0;
    }
    while (!s.a(this.l));
    d();
  }

  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public void b()
  {
    if ((this.j == null) || (this.k == null));
    String str;
    do
    {
      return;
      if ((this.j.ap()) && (this.j.z() == 7))
      {
        this.k.e();
        this.i.a(this.j, false);
        return;
      }
      str = this.j.p();
      if (!TextUtils.isEmpty(str))
        break;
    }
    while (!g());
    this.k.a(this.j.s());
    this.g.a();
    i();
    this.i.a(this.j, false);
    return;
    if (this.g.c(str))
    {
      this.g.a(str);
      this.i.a(this.j, false);
      return;
    }
    if (this.g.d(str))
    {
      this.g.b(str, this.n);
      this.n = 0L;
      this.i.a(this.j, false);
      return;
    }
    if (g())
    {
      i();
      this.i.a(this.j, false);
      return;
    }
    this.g.a(str, this.n);
    this.n = 0L;
    this.i.a(this.j, true);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(float paramFloat);

    public abstract void a(int paramInt);

    public abstract void a(long paramLong);

    public abstract void a(long paramLong, boolean paramBoolean);

    public abstract void a(PttUtils.AudioBarsInfo paramAudioBarsInfo);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void b(boolean paramBoolean);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.a
 * JD-Core Version:    0.6.2
 */