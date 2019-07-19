package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.g.ag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class i<T extends n>
  implements a.c<T>, l<T>
{
  volatile i<T>.a a;
  private final UUID b;
  private final o<T> c;
  private final r d;
  private final HashMap<String, String> e;
  private final com.google.android.exoplayer2.g.h<h> f;
  private final boolean g;
  private final int h;
  private final List<a<T>> i;
  private final List<a<T>> j;
  private Looper k;
  private int l;
  private byte[] m;

  private static List<DrmInitData.SchemeData> a(DrmInitData paramDrmInitData, UUID paramUUID, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramDrmInitData.schemeDataCount);
    int n = 0;
    if (n < paramDrmInitData.schemeDataCount)
    {
      DrmInitData.SchemeData localSchemeData = paramDrmInitData.get(n);
      if ((localSchemeData.matches(paramUUID)) || ((c.c.equals(paramUUID)) && (localSchemeData.matches(c.b))));
      for (int i1 = 1; ; i1 = 0)
      {
        if ((i1 != 0) && ((localSchemeData.data != null) || (paramBoolean)))
          localArrayList.add(localSchemeData);
        n++;
        break;
      }
    }
    return localArrayList;
  }

  public k<T> a(Looper paramLooper, DrmInitData paramDrmInitData)
  {
    if ((this.k == null) || (this.k == paramLooper));
    for (boolean bool1 = true; ; bool1 = false)
    {
      com.google.android.exoplayer2.g.a.b(bool1);
      if (this.i.isEmpty())
      {
        this.k = paramLooper;
        if (this.a == null)
          this.a = new a(paramLooper);
      }
      if (this.m != null)
        break;
      localList = a(paramDrmInitData, this.b, false);
      if (!localList.isEmpty())
        break label141;
      b localb = new b(this.b, null);
      this.f.a(new j(localb));
      return new m(new k.a(localb));
    }
    List localList = null;
    label141: a locala2;
    a locala1;
    if (!this.g)
    {
      boolean bool2 = this.i.isEmpty();
      locala2 = null;
      if (bool2)
        locala1 = locala2;
    }
    while (true)
    {
      if (locala1 == null)
      {
        locala1 = new a(this.b, this.c, this, localList, this.l, this.m, this.e, this.d, paramLooper, this.f, this.h);
        this.i.add(locala1);
      }
      locala1.a();
      return locala1;
      locala2 = (a)this.i.get(0);
      break;
      Iterator localIterator = this.i.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          locala1 = (a)localIterator.next();
          if (ag.a(locala1.a, localList))
            break;
        }
      locala1 = null;
    }
  }

  public void a()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).d();
    this.j.clear();
  }

  public final void a(Handler paramHandler, h paramh)
  {
    this.f.a(paramHandler, paramh);
  }

  public void a(a<T> parama)
  {
    this.j.add(parama);
    if (this.j.size() == 1)
      parama.c();
  }

  public void a(k<T> paramk)
  {
    if ((paramk instanceof m));
    a locala;
    do
    {
      return;
      locala = (a)paramk;
    }
    while (!locala.b());
    this.i.remove(locala);
    if ((this.j.size() > 1) && (this.j.get(0) == locala))
      ((a)this.j.get(1)).c();
    this.j.remove(locala);
  }

  public void a(Exception paramException)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(paramException);
    this.j.clear();
  }

  public boolean a(DrmInitData paramDrmInitData)
  {
    if (this.m != null);
    String str;
    do
    {
      return true;
      if (a(paramDrmInitData, this.b, true).isEmpty())
      {
        if ((paramDrmInitData.schemeDataCount != 1) || (!paramDrmInitData.get(0).matches(c.b)))
          break;
        com.google.android.exoplayer2.g.l.c("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.b);
      }
      str = paramDrmInitData.schemeType;
    }
    while ((str == null) || ("cenc".equals(str)) || ((!"cbc1".equals(str)) && (!"cbcs".equals(str)) && (!"cens".equals(str))) || (ag.a >= 25));
    return false;
    return false;
  }

  @SuppressLint({"HandlerLeak"})
  private class a extends Handler
  {
    public a(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      Iterator localIterator = i.a(i.this).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a(arrayOfByte))
          locala.a(paramMessage.what);
      }
    }
  }

  public static final class b extends Exception
  {
    private b(UUID paramUUID)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.i
 * JD-Core Version:    0.6.2
 */