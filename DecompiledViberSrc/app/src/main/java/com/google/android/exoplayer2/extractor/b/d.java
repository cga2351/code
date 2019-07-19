package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class d extends e
{
  private long b = -9223372036854775807L;

  public d()
  {
    super(null);
  }

  private static Object a(r paramr, int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 9:
    default:
      return null;
    case 0:
      return d(paramr);
    case 1:
      return c(paramr);
    case 2:
      return e(paramr);
    case 3:
      return g(paramr);
    case 8:
      return h(paramr);
    case 10:
      return f(paramr);
    case 11:
    }
    return i(paramr);
  }

  private static int b(r paramr)
  {
    return paramr.h();
  }

  private static Boolean c(r paramr)
  {
    int i = 1;
    if (paramr.h() == i);
    while (true)
    {
      return Boolean.valueOf(i);
      int j = 0;
    }
  }

  private static Double d(r paramr)
  {
    return Double.valueOf(Double.longBitsToDouble(paramr.r()));
  }

  private static String e(r paramr)
  {
    int i = paramr.i();
    int j = paramr.d();
    paramr.d(i);
    return new String(paramr.a, j, i);
  }

  private static ArrayList<Object> f(r paramr)
  {
    int i = paramr.v();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add(a(paramr, b(paramr)));
    return localArrayList;
  }

  private static HashMap<String, Object> g(r paramr)
  {
    HashMap localHashMap = new HashMap();
    while (true)
    {
      String str = e(paramr);
      int i = b(paramr);
      if (i == 9)
        return localHashMap;
      localHashMap.put(str, a(paramr, i));
    }
  }

  private static HashMap<String, Object> h(r paramr)
  {
    int i = paramr.v();
    HashMap localHashMap = new HashMap(i);
    for (int j = 0; j < i; j++)
      localHashMap.put(e(paramr), a(paramr, b(paramr)));
    return localHashMap;
  }

  private static Date i(r paramr)
  {
    Date localDate = new Date(()d(paramr).doubleValue());
    paramr.d(2);
    return localDate;
  }

  public long a()
  {
    return this.b;
  }

  protected void a(r paramr, long paramLong)
    throws w
  {
    if (b(paramr) != 2)
      throw new w();
    if (!"onMetaData".equals(e(paramr)));
    double d;
    do
    {
      HashMap localHashMap;
      do
      {
        do
          return;
        while (b(paramr) != 8);
        localHashMap = h(paramr);
      }
      while (!localHashMap.containsKey("duration"));
      d = ((Double)localHashMap.get("duration")).doubleValue();
    }
    while (d <= 0.0D);
    this.b = (()(d * 1000000.0D));
  }

  protected boolean a(r paramr)
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b.d
 * JD-Core Version:    0.6.2
 */