package com.yandex.metrica.impl.ob;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class jc
  implements it
{
  private Set<String> a;

  public jc(List<iy> paramList)
  {
    if (paramList == null)
      this.a = new HashSet();
    while (true)
    {
      return;
      this.a = new HashSet(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        iy localiy = (iy)localIterator.next();
        if (localiy.b)
          this.a.add(localiy.a);
      }
    }
  }

  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }

  public String toString()
  {
    return "StartupBasedPermissionStrategy{mEnabledPermissions=" + this.a + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jc
 * JD-Core Version:    0.6.2
 */