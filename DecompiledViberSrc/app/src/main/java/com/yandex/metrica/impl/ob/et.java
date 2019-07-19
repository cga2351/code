package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bw;
import java.util.List;

public class et
{
  private final oa a;
  private final ev b;

  public et(Context paramContext)
  {
    this(new oa(), new ev(paramContext));
  }

  et(oa paramoa, ev paramev)
  {
    this.a = paramoa;
    this.b = paramev;
  }

  public Long a(List<hr> paramList)
  {
    boolean bool = bw.a(paramList);
    Long localLong = null;
    hr localhr;
    if (!bool)
    {
      localhr = (hr)paramList.get(-1 + Math.min(this.b.a(), paramList.size()));
      if (localhr.a != localhr.b)
        break label69;
    }
    label69: for (long l = localhr.a; ; l = this.a.a(localhr.a, localhr.b))
    {
      localLong = Long.valueOf(l);
      return localLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.et
 * JD-Core Version:    0.6.2
 */