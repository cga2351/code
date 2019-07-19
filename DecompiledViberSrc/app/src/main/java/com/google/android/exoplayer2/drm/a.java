package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.g.l;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
class a<T extends n>
  implements k<T>
{
  public final List<DrmInitData.SchemeData> a;
  final r b;
  final UUID c;
  final a<T>.b d;
  private final o<T> e;
  private final c<T> f;
  private final int g;
  private final HashMap<String, String> h;
  private final com.google.android.exoplayer2.g.h<h> i;
  private final int j;
  private int k;
  private int l;
  private HandlerThread m;
  private a<T>.a n;
  private T o;
  private k.a p;
  private byte[] q;
  private byte[] r;
  private o.a s;
  private o.b t;

  public a(UUID paramUUID, o<T> paramo, c<T> paramc, List<DrmInitData.SchemeData> paramList, int paramInt1, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, r paramr, Looper paramLooper, com.google.android.exoplayer2.g.h<h> paramh, int paramInt2)
  {
    this.c = paramUUID;
    this.f = paramc;
    this.e = paramo;
    this.g = paramInt1;
    this.r = paramArrayOfByte;
    if (paramArrayOfByte == null);
    for (List localList = Collections.unmodifiableList(paramList); ; localList = null)
    {
      this.a = localList;
      this.h = paramHashMap;
      this.b = paramr;
      this.j = paramInt2;
      this.i = paramh;
      this.k = 2;
      this.d = new b(paramLooper);
      this.m = new HandlerThread("DrmRequestHandler");
      this.m.start();
      this.n = new a(this.m.getLooper());
      return;
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte;
    if (paramInt == 3)
      arrayOfByte = this.r;
    try
    {
      while (true)
      {
        this.s = this.e.a(arrayOfByte, this.a, paramInt, this.h);
        this.n.a(1, this.s, paramBoolean);
        return;
        arrayOfByte = this.q;
      }
    }
    catch (Exception localException)
    {
      b(localException);
    }
  }

  private void a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != this.t) || ((this.k != 2) && (!l())))
      return;
    this.t = null;
    if ((paramObject2 instanceof Exception))
    {
      this.f.a((Exception)paramObject2);
      return;
    }
    try
    {
      this.e.b((byte[])paramObject2);
      this.f.a();
      return;
    }
    catch (Exception localException)
    {
      this.f.a(localException);
    }
  }

  private boolean a(boolean paramBoolean)
  {
    if (l())
      return true;
    try
    {
      this.q = this.e.a();
      this.i.a(c.a);
      this.o = this.e.d(this.q);
      this.k = 3;
      return true;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      if (paramBoolean)
        this.f.a(this);
      while (true)
      {
        return false;
        c(localNotProvisionedException);
      }
    }
    catch (Exception localException)
    {
      while (true)
        c(localException);
    }
  }

  private void b(Exception paramException)
  {
    if ((paramException instanceof NotProvisionedException))
    {
      this.f.a(this);
      return;
    }
    c(paramException);
  }

  private void b(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != this.s) || (!l()))
      return;
    this.s = null;
    if ((paramObject2 instanceof Exception))
    {
      b((Exception)paramObject2);
      return;
    }
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = (byte[])paramObject2;
      if (this.g == 3)
      {
        this.e.a(this.r, arrayOfByte1);
        this.i.a(e.a);
        return;
      }
    }
    catch (Exception localException)
    {
      b(localException);
      return;
    }
    byte[] arrayOfByte2 = this.e.a(this.q, arrayOfByte1);
    if (((this.g == 2) || ((this.g == 0) && (this.r != null))) && (arrayOfByte2 != null) && (arrayOfByte2.length != 0))
      this.r = arrayOfByte2;
    this.k = 4;
    this.i.a(f.a);
  }

  private void b(boolean paramBoolean)
  {
    switch (this.g)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.r == null)
          {
            a(1, paramBoolean);
            return;
          }
        }
        while ((this.k != 4) && (!i()));
        long l1 = j();
        if ((this.g == 0) && (l1 <= 60L))
        {
          l.a("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + l1);
          a(2, paramBoolean);
          return;
        }
        if (l1 <= 0L)
        {
          c(new q());
          return;
        }
        this.k = 4;
        this.i.a(d.a);
        return;
        if (this.r == null)
        {
          a(2, paramBoolean);
          return;
        }
      }
      while (!i());
      a(2, paramBoolean);
      return;
    }
    while (!i());
    a(3, paramBoolean);
  }

  private void c(Exception paramException)
  {
    this.p = new k.a(paramException);
    this.i.a(new g(paramException));
    if (this.k != 4)
      this.k = 1;
  }

  private boolean i()
  {
    try
    {
      this.e.b(this.q, this.r);
      return true;
    }
    catch (Exception localException)
    {
      l.b("DefaultDrmSession", "Error trying to restore Widevine keys.", localException);
      c(localException);
    }
    return false;
  }

  private long j()
  {
    if (!com.google.android.exoplayer2.c.d.equals(this.c))
      return 9223372036854775807L;
    Pair localPair = s.a(this);
    return Math.min(((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
  }

  private void k()
  {
    if (this.k == 4)
    {
      this.k = 3;
      c(new q());
    }
  }

  private boolean l()
  {
    return (this.k == 3) || (this.k == 4);
  }

  public void a()
  {
    int i1 = 1 + this.l;
    this.l = i1;
    if ((i1 != 1) || (this.k == 1));
    while (!a(true))
      return;
    b(true);
  }

  public void a(int paramInt)
  {
    if (!l())
      return;
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.k = 3;
      this.f.a(this);
      return;
    case 2:
      b(false);
      return;
    case 3:
    }
    k();
  }

  public void a(Exception paramException)
  {
    c(paramException);
  }

  public boolean a(byte[] paramArrayOfByte)
  {
    return Arrays.equals(this.q, paramArrayOfByte);
  }

  public boolean b()
  {
    int i1 = -1 + this.l;
    this.l = i1;
    boolean bool = false;
    if (i1 == 0)
    {
      this.k = 0;
      this.d.removeCallbacksAndMessages(null);
      this.n.removeCallbacksAndMessages(null);
      this.n = null;
      this.m.quit();
      this.m = null;
      this.o = null;
      this.p = null;
      this.s = null;
      this.t = null;
      if (this.q != null)
      {
        this.e.a(this.q);
        this.q = null;
        this.i.a(b.a);
      }
      bool = true;
    }
    return bool;
  }

  public void c()
  {
    this.t = this.e.b();
    this.n.a(0, this.t, true);
  }

  public void d()
  {
    if (a(false))
      b(true);
  }

  public final int e()
  {
    return this.k;
  }

  public final k.a f()
  {
    if (this.k == 1)
      return this.p;
    return null;
  }

  public final T g()
  {
    return this.o;
  }

  public Map<String, String> h()
  {
    if (this.q == null)
      return null;
    return this.e.c(this.q);
  }

  @SuppressLint({"HandlerLeak"})
  private class a extends Handler
  {
    public a(Looper arg2)
    {
      super();
    }

    private long a(int paramInt)
    {
      return Math.min(1000 * (paramInt - 1), 5000);
    }

    private boolean a(Message paramMessage)
    {
      int i;
      if (paramMessage.arg1 == 1)
      {
        i = 1;
        if (i != 0)
          break label21;
      }
      label21: int j;
      do
      {
        return false;
        i = 0;
        break;
        j = 1 + paramMessage.arg2;
      }
      while (j > a.a(a.this));
      Message localMessage = Message.obtain(paramMessage);
      localMessage.arg2 = j;
      sendMessageDelayed(localMessage, a(j));
      return true;
    }

    void a(int paramInt, Object paramObject, boolean paramBoolean)
    {
      if (paramBoolean);
      for (int i = 1; ; i = 0)
      {
        obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
        return;
      }
    }

    public void handleMessage(Message paramMessage)
    {
      Object localObject1 = paramMessage.obj;
      Object localObject2;
      try
      {
        switch (paramMessage.what)
        {
        default:
          throw new RuntimeException();
        case 0:
        case 1:
        }
      }
      catch (Exception localException)
      {
        if (a(paramMessage))
        {
          return;
          byte[] arrayOfByte2 = a.this.b.a(a.this.c, (o.b)localObject1);
          localObject2 = arrayOfByte2;
        }
      }
      while (true)
      {
        a.this.d.obtainMessage(paramMessage.what, Pair.create(localObject1, localObject2)).sendToTarget();
        return;
        byte[] arrayOfByte1 = a.this.b.a(a.this.c, (o.a)localObject1);
        localObject2 = arrayOfByte1;
      }
    }
  }

  @SuppressLint({"HandlerLeak"})
  private class b extends Handler
  {
    public b(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      Pair localPair = (Pair)paramMessage.obj;
      Object localObject1 = localPair.first;
      Object localObject2 = localPair.second;
      switch (paramMessage.what)
      {
      default:
        return;
      case 0:
        a.a(a.this, localObject1, localObject2);
        return;
      case 1:
      }
      a.b(a.this, localObject1, localObject2);
    }
  }

  public static abstract interface c<T extends n>
  {
    public abstract void a();

    public abstract void a(a<T> parama);

    public abstract void a(Exception paramException);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.a
 * JD-Core Version:    0.6.2
 */