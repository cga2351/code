package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class bb
{
  private final HashMap<String, WeakReference> a = new HashMap();
  private final Context b;

  public bb(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  public <T extends ac> T a(y paramy, t paramt, ad<T> paramad)
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)this.a.get(paramy.toString());
      ac localac;
      if (localWeakReference != null)
      {
        localac = (ac)localWeakReference.get();
        if ((localac != null) && (!localac.d()));
      }
      else
      {
        localac = (ac)paramad.b(this.b, paramy, paramt);
        this.a.put(paramy.toString(), new WeakReference(localac));
      }
      return localac;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bb
 * JD-Core Version:    0.6.2
 */