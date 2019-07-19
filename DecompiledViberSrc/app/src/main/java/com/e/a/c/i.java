package com.e.a.c;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class i
{
  static Map<h, Set<f>> a = Collections.unmodifiableMap(localHashMap);

  static
  {
    HashMap localHashMap = new HashMap();
    h localh1 = h.a;
    f[] arrayOff1 = new f[2];
    arrayOff1[0] = f.a;
    arrayOff1[1] = f.b;
    localHashMap.put(localh1, new HashSet(Arrays.asList(arrayOff1)));
    h localh2 = h.b;
    f[] arrayOff2 = new f[4];
    arrayOff2[0] = f.c;
    arrayOff2[1] = f.d;
    arrayOff2[2] = f.e;
    arrayOff2[3] = f.f;
    localHashMap.put(localh2, new HashSet(Arrays.asList(arrayOff2)));
  }

  static boolean a(h paramh, Set<f> paramSet)
  {
    if ((paramh == null) || (paramSet == null))
      return true;
    return ((Set)a.get(paramh)).containsAll(paramSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.i
 * JD-Core Version:    0.6.2
 */