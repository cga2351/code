package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract interface hd<T>
{
  public abstract ge<T> a(Context paramContext);

  public static class a
  {
    private final HashMap<Class<?>, hd<?>> a = new HashMap();
    private final hd<mw> b = new hd()
    {
      public ge<mw> a(Context paramAnonymousContext)
      {
        return new gf("startup_state", fj.a(paramAnonymousContext).b(), new hc(paramAnonymousContext).a(), new ha());
      }
    };
    private final hd<ku.a> c = new hd()
    {
      public ge<ku.a> a(Context paramAnonymousContext)
      {
        return new gf("provided_request_state", fj.a(paramAnonymousContext).b(), new hc(paramAnonymousContext).d(), new gv());
      }
    };
    private final hd<List<iy>> d = new hd()
    {
      public ge<List<iy>> a(Context paramAnonymousContext)
      {
        return new gf("permission_list", fj.a(paramAnonymousContext).b(), new hc(paramAnonymousContext).b(), new gu());
      }
    };
    private final hd<mb> e = new hd()
    {
      public ge<mb> a(Context paramAnonymousContext)
      {
        return new gf("sdk_fingerprinting", fj.a(paramAnonymousContext).b(), new hc(paramAnonymousContext).c(), new gy());
      }
    };

    private a()
    {
      this.a.put(mw.class, this.b);
      this.a.put(ku.a.class, this.c);
      this.a.put(iy.class, this.d);
      this.a.put(mb.class, this.e);
    }

    public static <T> hd<T> a(Class<T> paramClass)
    {
      return a.a.c(paramClass);
    }

    public static <T> hd<Collection<T>> b(Class<T> paramClass)
    {
      return a.a.d(paramClass);
    }

    <T> hd<T> c(Class<T> paramClass)
    {
      return (hd)this.a.get(paramClass);
    }

    <T> hd<Collection<T>> d(Class<T> paramClass)
    {
      return (hd)this.a.get(paramClass);
    }

    private static final class a
    {
      static final hd.a a = new hd.a((byte)0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hd
 * JD-Core Version:    0.6.2
 */