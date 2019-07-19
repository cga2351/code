package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

public abstract class kz<T extends ky>
{
  private HashMap<String, T> a = new HashMap();
  private lb b = new lb();
  private final Executor c;

  protected kz(Executor paramExecutor)
  {
    this.c = paramExecutor;
  }

  public T a(final Context paramContext, String paramString)
  {
    ky localky1 = (ky)this.a.get(paramString);
    if (localky1 == null)
      synchronized (this.a)
      {
        ky localky2 = (ky)this.a.get(paramString);
        if (localky2 == null)
        {
          if (this.b.f() == null)
            this.c.execute(new Runnable()
            {
              public void run()
              {
                kz.a(kz.this).a(paramContext);
              }
            });
          localky2 = a(this.c, paramContext, paramString);
          this.a.put(paramString, localky2);
        }
        return localky2;
      }
    return localky1;
  }

  protected abstract T a(Executor paramExecutor, Context paramContext, String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kz
 * JD-Core Version:    0.6.2
 */