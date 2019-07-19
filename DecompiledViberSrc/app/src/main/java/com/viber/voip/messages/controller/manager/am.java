package com.viber.voip.messages.controller.manager;

import android.support.v4.util.SimpleArrayMap;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class am<T, F extends b>
{
  private static final e a = ViberEnv.getLogger();
  private final Map<String, T> b = new ConcurrentHashMap();
  private final SimpleArrayMap<String, a<T, F>> c;

  @SafeVarargs
  public am(a<T, F>[] paramArrayOfa)
  {
    this.c = new SimpleArrayMap(paramArrayOfa.length);
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      a<T, F> locala = paramArrayOfa[j];
      this.c.put(locala.d().a(), locala);
    }
  }

  static <T, F extends b> a<T, F> a(F paramF, final T paramT)
  {
    return new a()
    {
      public T c()
      {
        return paramT;
      }

      public F d()
      {
        return this.a;
      }
    };
  }

  private T b(F paramF)
  {
    a locala = (a)this.c.get(paramF.a());
    if (locala != null)
      return locala.c();
    return null;
  }

  public T a(F paramF)
  {
    String str = paramF.a();
    Object localObject1 = this.b.get(str);
    if (localObject1 == null)
      synchronized (this.b)
      {
        Object localObject3 = this.b.get(str);
        if (localObject3 == null)
        {
          localObject3 = b(paramF);
          if (localObject3 != null)
            this.b.put(str, localObject3);
        }
        return localObject3;
      }
    return localObject1;
  }

  public static abstract interface a<T, F extends am.b>
  {
    public abstract T c();

    public abstract F d();
  }

  public static abstract interface b
  {
    public abstract String a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.am
 * JD-Core Version:    0.6.2
 */