package com.google.android.exoplayer2.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.p;
import java.util.Collections;
import java.util.List;

public final class l extends com.google.android.exoplayer2.b
  implements Handler.Callback
{
  private final Handler a;
  private final k b;
  private final h c;
  private final p d;
  private boolean e;
  private boolean f;
  private int g;
  private Format h;
  private f i;
  private i j;
  private j k;
  private j l;
  private int m;

  public l(k paramk, Looper paramLooper)
  {
    this(paramk, paramLooper, h.a);
  }

  public l(k paramk, Looper paramLooper, h paramh)
  {
    super(3);
    this.b = ((k)a.a(paramk));
    if (paramLooper == null);
    for (Handler localHandler = null; ; localHandler = ag.a(paramLooper, this))
    {
      this.a = localHandler;
      this.c = paramh;
      this.d = new p();
      return;
    }
  }

  private void A()
  {
    a(Collections.emptyList());
  }

  private void a(List<b> paramList)
  {
    if (this.a != null)
    {
      this.a.obtainMessage(0, paramList).sendToTarget();
      return;
    }
    b(paramList);
  }

  private void b(List<b> paramList)
  {
    this.b.a(paramList);
  }

  private void w()
  {
    this.j = null;
    this.m = -1;
    if (this.k != null)
    {
      this.k.e();
      this.k = null;
    }
    if (this.l != null)
    {
      this.l.e();
      this.l = null;
    }
  }

  private void x()
  {
    w();
    this.i.d();
    this.i = null;
    this.g = 0;
  }

  private void y()
  {
    x();
    this.i = this.c.b(this.h);
  }

  private long z()
  {
    if ((this.m == -1) || (this.m >= this.k.b()))
      return 9223372036854775807L;
    return this.k.a(this.m);
  }

  public int a(Format paramFormat)
  {
    if (this.c.a(paramFormat))
    {
      if (a(null, paramFormat.drmInitData))
        return 4;
      return 2;
    }
    if (o.c(paramFormat.sampleMimeType))
      return 1;
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
    throws com.google.android.exoplayer2.i
  {
    if (this.f);
    int n;
    label154: 
    do
    {
      while (true)
      {
        return;
        if (this.l == null)
          this.i.a(paramLong1);
        try
        {
          this.l = ((j)this.i.b());
          if (g_() == 2)
            if (this.k != null)
            {
              long l1 = z();
              for (n = 0; l1 <= paramLong1; n = 1)
              {
                this.m = (1 + this.m);
                l1 = z();
              }
            }
        }
        catch (g localg2)
        {
          throw com.google.android.exoplayer2.i.a(localg2, s());
        }
      }
      n = 0;
      if (this.l != null)
      {
        if (!this.l.c())
          break label280;
        if ((n == 0) && (z() == 9223372036854775807L))
        {
          if (this.g != 2)
            break;
          y();
        }
      }
      if (n != 0)
        a(this.k.b(paramLong1));
    }
    while (this.g == 2);
    label280: label337: int i1;
    do
    {
      try
      {
        if (this.e)
          break;
        if (this.j == null)
        {
          this.j = ((i)this.i.a());
          if (this.j == null)
            break;
        }
        if (this.g != 1)
          break label337;
        this.j.a_(4);
        this.i.a(this.j);
        this.j = null;
        this.g = 2;
        return;
      }
      catch (g localg1)
      {
        throw com.google.android.exoplayer2.i.a(localg1, s());
      }
      w();
      this.f = true;
      break label154;
      if (this.l.a > paramLong1)
        break label154;
      if (this.k != null)
        this.k.e();
      this.k = this.l;
      this.l = null;
      this.m = this.k.a(paramLong1);
      n = 1;
      break label154;
      i1 = a(this.d, this.j, false);
      if (i1 == -4)
      {
        if (this.j.c())
          this.e = true;
        while (true)
        {
          this.i.a(this.j);
          this.j = null;
          break;
          this.j.d = this.d.a.subsampleOffsetUs;
          this.j.h();
        }
      }
    }
    while (i1 != -3);
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
    A();
    this.e = false;
    this.f = false;
    if (this.g != 0)
    {
      y();
      return;
    }
    w();
    this.i.c();
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws com.google.android.exoplayer2.i
  {
    this.h = paramArrayOfFormat[0];
    if (this.i != null)
    {
      this.g = 1;
      return;
    }
    this.i = this.c.b(this.h);
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      throw new IllegalStateException();
    case 0:
    }
    b((List)paramMessage.obj);
    return true;
  }

  protected void p()
  {
    this.h = null;
    A();
    x();
  }

  public boolean u()
  {
    return true;
  }

  public boolean v()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.l
 * JD-Core Version:    0.6.2
 */