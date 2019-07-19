package com.yandex.metrica.impl;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener.Error;
import com.yandex.metrica.impl.ob.fv;
import com.yandex.metrica.impl.ob.lj;
import com.yandex.metrica.impl.ob.lk;
import com.yandex.metrica.impl.ob.ll;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class bb
{
  private final boolean a;
  private final bj b;
  private final fv c;
  private String d;
  private Map<String, String> e;
  private DeferredDeeplinkParametersListener f;
  private Handler g;

  bb(bj parambj, fv paramfv, final ll paramll, Executor paramExecutor)
  {
    this.b = parambj;
    this.c = paramfv;
    this.d = paramfv.c();
    this.a = paramfv.d();
    if (this.a)
    {
      this.c.n(null);
      this.d = null;
    }
    while (true)
    {
      if (!this.c.e())
        paramExecutor.execute(new Runnable()
        {
          public void run()
          {
            paramll.a(new lk()
            {
              private void a()
              {
                bb.b(bb.this).g();
              }

              public void a(lj paramAnonymous2lj)
              {
                bb.a(bb.this).a(paramAnonymous2lj);
                bb.a(bb.this, paramAnonymous2lj.a);
                a();
              }

              public void a(Throwable paramAnonymous2Throwable)
              {
                bb.a(bb.this).a(null);
                a();
              }
            });
          }
        });
      return;
      e(b(this.d));
    }
  }

  public bb(bj parambj, fv paramfv, Executor paramExecutor)
  {
    this(parambj, paramfv, new ll(parambj.b()), paramExecutor);
  }

  private void a()
  {
    if (bw.a(this.e))
      if (this.d != null)
        a(DeferredDeeplinkParametersListener.Error.PARSE_ERROR);
    while (this.f == null)
      return;
    this.f.onParametersLoaded(this.e);
    this.f = null;
  }

  private void a(DeferredDeeplinkParametersListener.Error paramError)
  {
    if (this.f != null)
    {
      this.f.onError(paramError, this.d);
      this.f = null;
    }
  }

  static String b(String paramString)
  {
    return (String)f(paramString).get("appmetrica_deep_link");
  }

  static Map<String, String> c(String paramString)
  {
    Map localMap = f(Uri.decode(paramString));
    HashMap localHashMap = new HashMap(localMap.size());
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(Uri.decode((String)localEntry.getKey()), Uri.decode((String)localEntry.getValue()));
    }
    return localHashMap;
  }

  private void d(String paramString)
  {
    if ((this.a) || (TextUtils.isEmpty(paramString)));
    for (int i = 1; ; i = 0)
    {
      if ((i == 0) && (TextUtils.isEmpty(this.d)))
        try
        {
          this.d = paramString;
          this.c.n(this.d);
          e(b(paramString));
          if (this.g == null)
            this.g = new Handler(Looper.getMainLooper());
          this.g.post(new Runnable()
          {
            public void run()
            {
              bb.c(bb.this);
            }
          });
          return;
        }
        finally
        {
        }
      return;
    }
  }

  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.e = c(paramString);
  }

  private static Map<String, String> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      String str1 = g(paramString);
      if (str1.contains("="))
      {
        String[] arrayOfString = str1.split("&");
        int i = arrayOfString.length;
        int j = 0;
        if (j < i)
        {
          String str2 = arrayOfString[j];
          int k = str2.indexOf("=");
          if (k >= 0)
            localHashMap.put(str2.substring(0, k), str2.substring(k + 1));
          while (true)
          {
            j++;
            break;
            localHashMap.put(str2, "");
          }
        }
      }
    }
    return localHashMap;
  }

  private static String g(String paramString)
  {
    int i = paramString.lastIndexOf('?');
    if (i >= 0)
      paramString = paramString.substring(i + 1);
    return paramString;
  }

  // ERROR //
  public void a(DeferredDeeplinkParametersListener paramDeferredDeeplinkParametersListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 95	com/yandex/metrica/impl/bb:f	Lcom/yandex/metrica/DeferredDeeplinkParametersListener;
    //   7: aload_0
    //   8: getfield 40	com/yandex/metrica/impl/bb:a	Z
    //   11: ifeq +21 -> 32
    //   14: aload_0
    //   15: getstatic 234	com/yandex/metrica/DeferredDeeplinkParametersListener$Error:NOT_A_FIRST_LAUNCH	Lcom/yandex/metrica/DeferredDeeplinkParametersListener$Error;
    //   18: invokespecial 93	com/yandex/metrica/impl/bb:a	(Lcom/yandex/metrica/DeferredDeeplinkParametersListener$Error;)V
    //   21: aload_0
    //   22: getfield 28	com/yandex/metrica/impl/bb:c	Lcom/yandex/metrica/impl/ob/fv;
    //   25: invokevirtual 237	com/yandex/metrica/impl/ob/fv:f	()Lcom/yandex/metrica/impl/ob/fv;
    //   28: pop
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokespecial 170	com/yandex/metrica/impl/bb:a	()V
    //   36: goto -15 -> 21
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 28	com/yandex/metrica/impl/bb:c	Lcom/yandex/metrica/impl/ob/fv;
    //   44: invokevirtual 237	com/yandex/metrica/impl/ob/fv:f	()Lcom/yandex/metrica/impl/ob/fv;
    //   47: pop
    //   48: aload_2
    //   49: athrow
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	21	39	finally
    //   32	36	39	finally
    //   21	29	50	finally
    //   40	50	50	finally
  }

  public void a(String paramString)
  {
    this.b.b(paramString);
    d(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bb
 * JD-Core Version:    0.6.2
 */