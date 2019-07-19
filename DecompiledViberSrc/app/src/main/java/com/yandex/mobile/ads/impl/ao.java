package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.yandex.mobile.ads.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ao
{
  private final Context a;
  private final b b;
  private final c c;
  private final String d;
  private final List<a> e;
  private final List<a> f;
  private final cb g;
  private final cj h;
  private an i;
  private boolean j;
  private int k;
  private boolean l;
  private boolean m;

  public ao(Context paramContext, b paramb, c paramc, String paramString)
  {
    this.a = paramContext;
    this.c = paramc;
    this.b = new b(Looper.getMainLooper());
    this.d = paramString;
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new cb(paramContext, paramb);
    this.h = new cj(paramContext);
  }

  private ak a(a parama)
  {
    ak localak = this.c.a(parama.c);
    new StringBuilder("validateTrackingState(), validationResult = ").append(localak.b().a());
    return localak;
  }

  private void a(a parama, ak paramak)
  {
    try
    {
      b(parama, paramak);
      if ((!this.m) && (!c(paramak)))
      {
        this.g.b(paramak);
        this.m = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(List<bd> paramList)
  {
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bd localbd = (bd)localIterator.next();
        String str = localbd.b();
        long l1 = localbd.a();
        int n = localbd.c();
        this.f.add(new a(str, l1, n));
      }
    }
    finally
    {
    }
  }

  private void b(a parama, ak paramak)
  {
    try
    {
      if (c(paramak))
        this.h.a(parama.a);
      while (true)
      {
        return;
        a(paramak);
      }
    }
    finally
    {
    }
  }

  private static boolean c(ak paramak)
  {
    return paramak.b() == ak.a.a;
  }

  private boolean d()
  {
    try
    {
      int n = this.f.size();
      int i1 = this.e.size();
      if (n > i1)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final void a()
  {
    try
    {
      new StringBuilder("startTrackingIfNeeded(), clazz = ").append(this.d);
      if (ae.a().a(this.a))
      {
        Collection[] arrayOfCollection = new Collection[1];
        arrayOfCollection[0] = this.f;
        if ((!fl.a(arrayOfCollection)) && (d()))
          this.b.sendMessage(Message.obtain(this.b, 2, new WeakReference(this)));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(Intent paramIntent, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        new StringBuilder("handleIntent(), intent = ").append(paramIntent).append(", isAdVisible = ").append(paramBoolean).append(", clazz = ").append(this.d);
        String str = paramIntent.getAction();
        int n = -1;
        int i1 = str.hashCode();
        switch (i1)
        {
        default:
          switch (n)
          {
          default:
            return;
          case 0:
          case 1:
          case 2:
          }
        case -2128145023:
          if (!str.equals("android.intent.action.SCREEN_OFF"))
            continue;
          n = 0;
          break;
        case -1454123155:
          if (!str.equals("android.intent.action.SCREEN_ON"))
            continue;
          n = 1;
          break;
        case 823795052:
        }
        if (!str.equals("android.intent.action.USER_PRESENT"))
          continue;
        n = 2;
        continue;
        b();
        continue;
      }
      finally
      {
      }
      if (paramBoolean)
        a();
    }
  }

  final void a(ak paramak)
  {
    try
    {
      this.k = (1 + this.k);
      if (this.k == 20)
      {
        this.g.a(paramak);
        this.j = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(an paraman)
  {
    this.i = paraman;
  }

  public final void a(fd.a parama)
  {
    this.g.a(parama);
  }

  final void a(fd.b paramb)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("failure_tracked", Boolean.valueOf(this.j));
      this.g.a(paramb, localHashMap);
      if (this.i != null)
        this.i.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(String paramString, List<bd> paramList)
  {
    try
    {
      new StringBuilder("updateNotices(), clazz = ").append(this.d);
      this.g.a(paramString);
      this.f.clear();
      this.k = 0;
      this.j = false;
      this.l = false;
      this.m = false;
      b();
      a(paramList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void b()
  {
    try
    {
      new StringBuilder("stopTracking(), clazz = ").append(this.d);
      this.b.removeMessages(2);
      this.b.removeMessages(1);
      this.e.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final void b(fd.b paramb)
  {
    try
    {
      if (!this.l)
      {
        this.g.a(paramb);
        fq.a("Ad binding successful", new Object[0]);
        this.l = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void c()
  {
    while (true)
    {
      try
      {
        new StringBuilder("forceTracking(), mNotTrackedNotices.size = ").append(this.f.size()).append(", clazz = ").append(this.d);
        b();
        localObject2 = fd.b.l;
        ArrayList localArrayList = new ArrayList();
        this.m = false;
        Iterator localIterator = this.f.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          ak localak = a(locala);
          a(locala, localak);
          if (c(localak))
          {
            localArrayList.add(locala);
            localObject3 = localak.c();
            b(localak.d());
            break label199;
          }
        }
        else
        {
          if (!localArrayList.isEmpty())
          {
            this.f.removeAll(localArrayList);
            if (this.f.isEmpty())
              a((fd.b)localObject2);
          }
          a();
          return;
        }
      }
      finally
      {
      }
      Object localObject3 = localObject2;
      label199: Object localObject2 = localObject3;
    }
  }

  static final class a
  {
    String a;
    long b;
    int c;

    a(String paramString, long paramLong, int paramInt)
    {
      this.a = paramString;
      this.b = paramLong;
      this.c = paramInt;
    }
  }

  private static final class b extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }

    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 2:
      }
      ao localao1;
      label353: 
      do
      {
        do
        {
          ao localao2;
          ak localak2;
          do
          {
            Pair localPair;
            do
            {
              return;
              localPair = (Pair)paramMessage.obj;
              localao2 = (ao)((WeakReference)localPair.first).get();
            }
            while (localao2 == null);
            ao.a locala2 = (ao.a)localPair.second;
            new StringBuilder("handleMessage, clazz = ").append(ao.a(localao2));
            ao.b(localao2).remove(locala2);
            localak2 = ao.a(localao2, locala2);
            ao.a(localao2, locala2, localak2);
            if (!ao.b(localak2))
              break;
            ao.c(localao2).remove(locala2);
          }
          while (!ao.c(localao2).isEmpty());
          localao2.a(localak2.c());
          return;
          localao2.a();
          return;
          localao1 = (ao)((WeakReference)paramMessage.obj).get();
        }
        while (localao1 == null);
        new StringBuilder("mNoticeTrackingChecker mNotTrackedNotices.size = ").append(ao.c(localao1).size()).append(", clazz = ").append(ao.a(localao1));
        int i = ao.c(localao1).size();
        int j = 0;
        if (j < i)
        {
          ao.a locala1 = (ao.a)ao.c(localao1).get(j);
          ak localak1;
          if (!ao.b(localao1).contains(locala1))
          {
            localak1 = ao.a(localao1, locala1);
            if (!ao.b(localak1))
              break label353;
            ao.d(localao1).sendMessageDelayed(Message.obtain(ao.d(localao1), 1, new Pair(new WeakReference(localao1), locala1)), locala1.b);
            ao.b(localao1).add(locala1);
            localao1.b(localak1.d());
          }
          while (true)
          {
            j++;
            break;
            localao1.a(localak1);
          }
        }
      }
      while (!ao.e(localao1));
      ao.d(localao1).sendMessageDelayed(Message.obtain(ao.d(localao1), 2, new WeakReference(localao1)), 300L);
    }
  }

  public static abstract interface c
  {
    public abstract ak a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ao
 * JD-Core Version:    0.6.2
 */