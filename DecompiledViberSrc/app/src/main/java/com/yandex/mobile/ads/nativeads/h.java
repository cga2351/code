package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.impl.db;
import com.yandex.mobile.ads.impl.le;
import com.yandex.mobile.ads.impl.lg;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.impl.lz;
import com.yandex.mobile.ads.impl.nd;
import com.yandex.mobile.ads.impl.nh;
import com.yandex.mobile.ads.impl.nl;
import com.yandex.mobile.ads.impl.ov;
import com.yandex.mobile.ads.impl.pc;
import com.yandex.mobile.ads.impl.pc.c;
import com.yandex.mobile.ads.impl.pc.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
{
  private final nh a = new nh();
  private final nl b;
  private final nd c;
  private final pc d;

  public h(Context paramContext)
  {
    this.b = new nl(paramContext);
    this.c = new nd();
    this.d = lz.a(paramContext).b();
  }

  public final Set<lh> a(List<ll> paramList)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ll localll = (ll)localIterator.next();
      localHashSet.addAll(nd.a(localll));
      ArrayList localArrayList = new ArrayList();
      le localle = localll.b("feedback");
      if ((localle != null) && ((localle.c() instanceof lg)))
      {
        lh locallh = ((lg)localle.c()).a();
        if (locallh != null)
          localArrayList.add(locallh);
      }
      localHashSet.addAll(localArrayList);
      localHashSet.addAll(this.b.a(localll));
    }
    return localHashSet;
  }

  public final void a(Set<lh> paramSet, j paramj)
  {
    if (paramSet.size() == 0)
    {
      paramj.a(Collections.emptyMap());
      return;
    }
    new a(this.d, paramSet, paramj).a();
  }

  static final class a
  {
    private final Handler a;
    private final pc b;
    private final AtomicInteger c;
    private final Set<lh> d;
    private final j e;
    private final db f;

    a(pc parampc, Set<lh> paramSet, j paramj)
    {
      this.b = parampc;
      this.d = paramSet;
      this.e = paramj;
      this.a = new Handler(Looper.getMainLooper());
      this.c = new AtomicInteger(paramSet.size());
      this.f = new db();
    }

    private void a(Map<String, Bitmap> paramMap)
    {
      if (this.c.decrementAndGet() == 0)
        this.e.a(paramMap);
    }

    final void a()
    {
      final HashMap localHashMap = new HashMap();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        final lh locallh = (lh)localIterator.next();
        final String str = locallh.c();
        final int i = locallh.b();
        final int j = locallh.a();
        new Object[] { str };
        int k = locallh.b();
        int m = locallh.a();
        float f1 = (float)Runtime.getRuntime().totalMemory();
        float f2 = (float)Runtime.getRuntime().maxMemory() - f1;
        float f3 = 1048576.0F + 4 * (k * m);
        if (f2 < f3)
          new StringBuilder("Not enough free memory to create bitmap. FreeMemory = ").append(f2).append(", RequiredMemory = ").append(f3);
        for (int n = 0; ; n = 1)
        {
          if (n == 0)
            break label185;
          this.a.post(new Runnable()
          {
            public final void run()
            {
              h.a.a(h.a.this).a(str, new pc.d()
              {
                public final void a(ov paramAnonymous2ov)
                {
                  new Object[] { paramAnonymous2ov };
                  h.a.a(h.a.this, h.a.1.this.b);
                }

                public final void a(pc.c paramAnonymous2c)
                {
                  String str = h.a.1.this.c.c();
                  Bitmap localBitmap = paramAnonymous2c.a();
                  if (localBitmap != null)
                  {
                    if (str != null)
                      h.a.1.this.b.put(str, localBitmap);
                    h.a.a(h.a.this, h.a.1.this.b);
                  }
                }
              }
              , j, i);
            }
          });
          break;
        }
        label185: a(localHashMap);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.h
 * JD-Core Version:    0.6.2
 */