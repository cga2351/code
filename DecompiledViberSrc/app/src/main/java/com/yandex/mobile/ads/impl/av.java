package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class av<T>
{
  private final bb a;
  private final aq b;
  private final ay c;
  private int d;

  public av(bb parambb, aq paramaq, ay paramay)
  {
    this.a = parambb;
    this.b = paramaq;
    this.c = paramay;
  }

  private void a(Context paramContext, bc parambc, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("reason", paramString);
    this.c.f(paramContext, parambc, localHashMap);
  }

  public final ar<T> a(Context paramContext, Class<T> paramClass)
  {
    List localList = this.a.a();
    Object localObject1 = null;
    while ((localObject1 == null) && (this.d < localList.size()))
    {
      int i = this.d;
      this.d = (i + 1);
      bc localbc = (bc)localList.get(i);
      String str = localbc.a();
      try
      {
        Object[] arrayOfObject = new Object[0];
        localObject2 = paramClass.cast(fn.a(Class.forName(str), arrayOfObject));
        if (localObject2 == null)
          a(paramContext, localbc, "could_not_create_adapter");
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject2;
        a(paramContext, localbc, "does_not_conform_to_protocol");
        continue;
        ar localar = new ar(localObject2, localbc, this.b);
        localObject1 = localar;
      }
      catch (Exception localException)
      {
        a(paramContext, localbc, "could_not_create_adapter");
      }
    }
    return localObject1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.av
 * JD-Core Version:    0.6.2
 */