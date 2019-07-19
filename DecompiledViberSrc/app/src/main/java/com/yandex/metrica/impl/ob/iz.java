package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.Collection;
import java.util.List;

public class iz
{
  ix a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new ja(paramContext);
    return new jd(paramContext);
  }

  public List<iy> a(Context paramContext, Collection<iy> paramCollection)
  {
    List localList = a(paramContext).a();
    if (nu.a(localList, paramCollection))
      localList = null;
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.iz
 * JD-Core Version:    0.6.2
 */