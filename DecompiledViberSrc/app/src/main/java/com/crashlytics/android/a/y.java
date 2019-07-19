package com.crashlytics.android.a;

import java.util.HashSet;
import java.util.Set;

class y
  implements p
{
  static final Set<ad.b> b = new HashSet()
  {
  };
  final int a;

  public y(int paramInt)
  {
    this.a = paramInt;
  }

  public boolean a(ad paramad)
  {
    int i;
    if ((b.contains(paramad.c)) && (paramad.a.e == null))
    {
      i = 1;
      if (Math.abs(paramad.a.c.hashCode() % this.a) == 0)
        break label65;
    }
    label65: for (int j = 1; ; j = 0)
    {
      if ((i == 0) || (j == 0))
        break label70;
      return true;
      i = 0;
      break;
    }
    label70: return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.y
 * JD-Core Version:    0.6.2
 */