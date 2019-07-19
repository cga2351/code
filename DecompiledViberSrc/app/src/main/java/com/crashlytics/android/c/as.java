package com.crashlytics.android.c;

import android.app.ActivityManager.RunningAppProcessInfo;
import c.a.a.a.a.b.s.a;
import c.a.a.a.c;
import c.a.a.a.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class as
{
  private static final d a = d.a("0");
  private static final d b = d.a("Unity");

  private static int a()
  {
    return 0 + g.b(1, a) + g.b(2, a) + g.b(3, 0L);
  }

  private static int a(int paramInt1, d paramd1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<s.a, String> paramMap, int paramInt3, d paramd2, d paramd3)
  {
    int i = 0 + g.e(3, paramInt1);
    if (paramd1 == null);
    int k;
    for (int j = 0; ; j = g.b(4, paramd1))
    {
      k = j + i + g.d(5, paramInt2) + g.b(6, paramLong1) + g.b(7, paramLong2) + g.b(10, paramBoolean);
      if (paramMap == null)
        break;
      Iterator localIterator = paramMap.entrySet().iterator();
      m = k;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i4 = a((s.a)localEntry.getKey(), (String)localEntry.getValue());
        m += i4 + (g.j(11) + g.l(i4));
      }
    }
    int m = k;
    int n = m + g.d(12, paramInt3);
    int i1;
    int i2;
    if (paramd2 == null)
    {
      i1 = 0;
      i2 = n + i1;
      if (paramd3 != null)
        break label211;
    }
    label211: for (int i3 = 0; ; i3 = g.b(14, paramd3))
    {
      return i3 + i2;
      i1 = g.b(13, paramd2);
      break;
    }
  }

  private static int a(long paramLong1, String paramString, aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2, d paramd1, d paramd2, Float paramFloat, int paramInt3, boolean paramBoolean, long paramLong2, long paramLong3, d paramd3)
  {
    int i = 0 + g.b(1, paramLong1) + g.b(2, d.a(paramString));
    int j = a(paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramd1, paramd2, paramMap, paramRunningAppProcessInfo, paramInt2);
    int k = i + (j + (g.j(3) + g.l(j)));
    int m = a(paramFloat, paramInt3, paramBoolean, paramInt2, paramLong2, paramLong3);
    int n = k + (m + (g.j(5) + g.l(m)));
    if (paramd3 != null)
    {
      int i1 = b(paramd3);
      n += i1 + (g.j(6) + g.l(i1));
    }
    return n;
  }

  private static int a(s.a parama, String paramString)
  {
    return g.e(1, parama.h) + g.b(2, d.a(paramString));
  }

  private static int a(aw paramaw, int paramInt1, int paramInt2)
  {
    int i = 0 + g.b(1, d.a(paramaw.b));
    String str = paramaw.a;
    if (str != null)
      i += g.b(3, d.a(str));
    StackTraceElement[] arrayOfStackTraceElement = paramaw.c;
    int j = arrayOfStackTraceElement.length;
    int k = 0;
    while (k < j)
    {
      int i1 = a(arrayOfStackTraceElement[k], true);
      int i2 = i + (i1 + (g.j(4) + g.l(i1)));
      k++;
      i = i2;
    }
    aw localaw = paramaw.d;
    int m;
    if (localaw != null)
    {
      m = 0;
      if (paramInt1 < paramInt2)
      {
        int n = a(localaw, paramInt1 + 1, paramInt2);
        i += n + (g.j(6) + g.l(n));
      }
    }
    else
    {
      return i;
    }
    while (localaw != null)
    {
      localaw = localaw.d;
      m++;
    }
    return i + g.d(7, m);
  }

  private static int a(aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt, d paramd1, d paramd2)
  {
    int i = a(paramThread, paramArrayOfStackTraceElement, 4, true);
    int j = 0 + (i + (g.j(1) + g.l(i)));
    int k = paramArrayOfThread.length;
    int m = j;
    for (int n = 0; n < k; n++)
    {
      int i6 = a(paramArrayOfThread[n], (StackTraceElement[])paramList.get(n), 0, false);
      m += i6 + (g.j(1) + g.l(i6));
    }
    int i1 = a(paramaw, 1, paramInt);
    int i2 = m + (i1 + (g.j(2) + g.l(i1)));
    int i3 = a();
    int i4 = i2 + (i3 + (g.j(3) + g.l(i3)));
    int i5 = a(paramd1, paramd2);
    return i4 + (i5 + (g.j(3) + g.l(i5)));
  }

  private static int a(aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, d paramd1, d paramd2, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
  {
    int i = a(paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramd1, paramd2);
    int j = 0 + (i + (g.j(1) + g.l(i)));
    int n;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      n = j;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i1 = a((String)localEntry.getKey(), (String)localEntry.getValue());
        n += i1 + (g.j(2) + g.l(i1));
      }
    }
    for (int k = n; ; k = j)
    {
      boolean bool;
      if (paramRunningAppProcessInfo != null)
        if (paramRunningAppProcessInfo.importance != 100)
          bool = true;
      for (int m = k + g.b(3, bool); ; m = k)
      {
        return m + g.d(4, paramInt2);
        bool = false;
        break;
      }
    }
  }

  private static int a(d paramd)
  {
    return 0 + g.b(1, paramd);
  }

  private static int a(d paramd1, d paramd2)
  {
    int i = 0 + g.b(1, 0L) + g.b(2, 0L) + g.b(3, paramd1);
    if (paramd2 != null)
      i += g.b(4, paramd2);
    return i;
  }

  private static int a(d paramd1, d paramd2, d paramd3, d paramd4, d paramd5, int paramInt, d paramd6)
  {
    int i = 0 + g.b(1, paramd1) + g.b(2, paramd3) + g.b(3, paramd4);
    int j = a(paramd2);
    int k = i + (j + (g.j(5) + g.l(j))) + g.b(6, paramd5);
    if (paramd6 != null)
      k = k + g.b(8, b) + g.b(9, paramd6);
    return k + g.e(10, paramInt);
  }

  private static int a(d paramd1, d paramd2, boolean paramBoolean)
  {
    return 0 + g.e(1, 3) + g.b(2, paramd1) + g.b(3, paramd2) + g.b(4, paramBoolean);
  }

  private static int a(Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (paramFloat != null)
      i = 0 + g.b(1, paramFloat.floatValue());
    return i + g.f(2, paramInt1) + g.b(3, paramBoolean) + g.d(4, paramInt2) + g.b(5, paramLong1) + g.b(6, paramLong2);
  }

  private static int a(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramStackTraceElement.isNativeMethod())
    {
      i = 0 + g.b(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      j = i + g.b(2, d.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null)
        j += g.b(3, d.a(paramStackTraceElement.getFileName()));
      if ((paramStackTraceElement.isNativeMethod()) || (paramStackTraceElement.getLineNumber() <= 0))
        break label144;
    }
    label144: for (int k = j + g.b(4, paramStackTraceElement.getLineNumber()); ; k = j)
    {
      if (paramBoolean);
      for (int m = 2; ; m = 0)
      {
        return k + g.d(5, m);
        i = 0 + g.b(1, 0L);
        break;
      }
    }
  }

  private static int a(String paramString1, String paramString2)
  {
    int i = g.b(1, d.a(paramString1));
    if (paramString2 == null)
      paramString2 = "";
    return i + g.b(2, d.a(paramString2));
  }

  private static int a(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int i = g.b(1, d.a(paramThread.getName())) + g.d(2, paramInt);
    int j = paramArrayOfStackTraceElement.length;
    for (int k = 0; k < j; k++)
    {
      int m = a(paramArrayOfStackTraceElement[k], paramBoolean);
      i += m + (g.j(3) + g.l(m));
    }
    return i;
  }

  private static d a(String paramString)
  {
    if (paramString == null)
      return null;
    return d.a(paramString);
  }

  private static void a(g paramg, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    int i = 4;
    paramg.g(paramInt, 2);
    paramg.k(a(paramStackTraceElement, paramBoolean));
    if (paramStackTraceElement.isNativeMethod())
    {
      paramg.a(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      paramg.a(2, d.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null)
        paramg.a(3, d.a(paramStackTraceElement.getFileName()));
      if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0))
        paramg.a(i, paramStackTraceElement.getLineNumber());
      if (!paramBoolean)
        break label141;
    }
    while (true)
    {
      paramg.a(5, i);
      return;
      paramg.a(1, 0L);
      break;
      label141: i = 0;
    }
  }

  public static void a(g paramg, int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<s.a, String> paramMap, int paramInt3, String paramString2, String paramString3)
    throws Exception
  {
    d locald1 = a(paramString1);
    d locald2 = a(paramString3);
    d locald3 = a(paramString2);
    paramg.g(9, 2);
    paramg.k(a(paramInt1, locald1, paramInt2, paramLong1, paramLong2, paramBoolean, paramMap, paramInt3, locald3, locald2));
    paramg.b(3, paramInt1);
    paramg.a(4, locald1);
    paramg.a(5, paramInt2);
    paramg.a(6, paramLong1);
    paramg.a(7, paramLong2);
    paramg.a(10, paramBoolean);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramg.g(11, 2);
      paramg.k(a((s.a)localEntry.getKey(), (String)localEntry.getValue()));
      paramg.b(1, ((s.a)localEntry.getKey()).h);
      paramg.a(2, d.a((String)localEntry.getValue()));
    }
    paramg.a(12, paramInt3);
    if (locald3 != null)
      paramg.a(13, locald3);
    if (locald2 != null)
      paramg.a(14, locald2);
  }

  public static void a(g paramg, long paramLong1, String paramString1, aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, Map<String, String> paramMap, ab paramab, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt1, String paramString2, String paramString3, Float paramFloat, int paramInt2, boolean paramBoolean, long paramLong2, long paramLong3)
    throws Exception
  {
    d locald1 = d.a(paramString2);
    if (paramString3 == null);
    for (d locald2 = null; ; locald2 = d.a(paramString3.replace("-", "")))
    {
      d locald3 = paramab.a();
      if (locald3 == null)
        c.g().a("CrashlyticsCore", "No log data to include with this event.");
      paramab.c();
      paramg.g(10, 2);
      paramg.k(a(paramLong1, paramString1, paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, 8, paramMap, paramRunningAppProcessInfo, paramInt1, locald1, locald2, paramFloat, paramInt2, paramBoolean, paramLong2, paramLong3, locald3));
      paramg.a(1, paramLong1);
      paramg.a(2, d.a(paramString1));
      a(paramg, paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, 8, locald1, locald2, paramMap, paramRunningAppProcessInfo, paramInt1);
      a(paramg, paramFloat, paramInt2, paramBoolean, paramInt1, paramLong2, paramLong3);
      a(paramg, locald3);
      return;
    }
  }

  private static void a(g paramg, aw paramaw, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    paramg.g(paramInt3, 2);
    paramg.k(a(paramaw, 1, paramInt2));
    paramg.a(1, d.a(paramaw.b));
    String str = paramaw.a;
    if (str != null)
      paramg.a(3, d.a(str));
    StackTraceElement[] arrayOfStackTraceElement = paramaw.c;
    int i = arrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++)
      a(paramg, 4, arrayOfStackTraceElement[j], true);
    aw localaw = paramaw.d;
    int k;
    if (localaw != null)
    {
      k = 0;
      if (paramInt1 < paramInt2)
        a(paramg, localaw, paramInt1 + 1, paramInt2, 6);
    }
    else
    {
      return;
    }
    while (localaw != null)
    {
      localaw = localaw.d;
      k++;
    }
    paramg.a(7, k);
  }

  private static void a(g paramg, aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt, d paramd1, d paramd2)
    throws Exception
  {
    paramg.g(1, 2);
    paramg.k(a(paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt, paramd1, paramd2));
    a(paramg, paramThread, paramArrayOfStackTraceElement, 4, true);
    int i = paramArrayOfThread.length;
    for (int j = 0; j < i; j++)
      a(paramg, paramArrayOfThread[j], (StackTraceElement[])paramList.get(j), 0, false);
    a(paramg, paramaw, 1, paramInt, 2);
    paramg.g(3, 2);
    paramg.k(a());
    paramg.a(1, a);
    paramg.a(2, a);
    paramg.a(3, 0L);
    paramg.g(4, 2);
    paramg.k(a(paramd1, paramd2));
    paramg.a(1, 0L);
    paramg.a(2, 0L);
    paramg.a(3, paramd1);
    if (paramd2 != null)
      paramg.a(4, paramd2);
  }

  private static void a(g paramg, aw paramaw, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List<StackTraceElement[]> paramList, int paramInt1, d paramd1, d paramd2, Map<String, String> paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
    throws Exception
  {
    paramg.g(3, 2);
    paramg.k(a(paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramd1, paramd2, paramMap, paramRunningAppProcessInfo, paramInt2));
    a(paramg, paramaw, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramd1, paramd2);
    if ((paramMap != null) && (!paramMap.isEmpty()))
      a(paramg, paramMap);
    if (paramRunningAppProcessInfo != null)
      if (paramRunningAppProcessInfo.importance == 100)
        break label103;
    label103: for (boolean bool = true; ; bool = false)
    {
      paramg.a(3, bool);
      paramg.a(4, paramInt2);
      return;
    }
  }

  private static void a(g paramg, d paramd)
    throws Exception
  {
    if (paramd != null)
    {
      paramg.g(6, 2);
      paramg.k(b(paramd));
      paramg.a(1, paramd);
    }
  }

  private static void a(g paramg, Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
    throws Exception
  {
    paramg.g(5, 2);
    paramg.k(a(paramFloat, paramInt1, paramBoolean, paramInt2, paramLong1, paramLong2));
    if (paramFloat != null)
      paramg.a(1, paramFloat.floatValue());
    paramg.c(2, paramInt1);
    paramg.a(3, paramBoolean);
    paramg.a(4, paramInt2);
    paramg.a(5, paramLong1);
    paramg.a(6, paramLong2);
  }

  public static void a(g paramg, String paramString1, String paramString2, long paramLong)
    throws Exception
  {
    paramg.a(1, d.a(paramString2));
    paramg.a(2, d.a(paramString1));
    paramg.a(3, paramLong);
  }

  public static void a(g paramg, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    if (paramString1 == null)
      paramString1 = "";
    d locald1 = d.a(paramString1);
    d locald2 = a(paramString2);
    d locald3 = a(paramString3);
    int i = 0 + g.b(1, locald1);
    if (paramString2 != null)
      i += g.b(2, locald2);
    if (paramString3 != null)
      i += g.b(3, locald3);
    paramg.g(6, 2);
    paramg.k(i);
    paramg.a(1, locald1);
    if (paramString2 != null)
      paramg.a(2, locald2);
    if (paramString3 != null)
      paramg.a(3, locald3);
  }

  public static void a(g paramg, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
    throws Exception
  {
    d locald1 = d.a(paramString1);
    d locald2 = d.a(paramString2);
    d locald3 = d.a(paramString3);
    d locald4 = d.a(paramString4);
    d locald5 = d.a(paramString5);
    if (paramString6 != null);
    for (d locald6 = d.a(paramString6); ; locald6 = null)
    {
      paramg.g(7, 2);
      paramg.k(a(locald1, locald2, locald3, locald4, locald5, paramInt, locald6));
      paramg.a(1, locald1);
      paramg.a(2, locald3);
      paramg.a(3, locald4);
      paramg.g(5, 2);
      paramg.k(a(locald2));
      paramg.a(1, locald2);
      paramg.a(6, locald5);
      if (locald6 != null)
      {
        paramg.a(8, b);
        paramg.a(9, locald6);
      }
      paramg.b(10, paramInt);
      return;
    }
  }

  public static void a(g paramg, String paramString1, String paramString2, boolean paramBoolean)
    throws Exception
  {
    d locald1 = d.a(paramString1);
    d locald2 = d.a(paramString2);
    paramg.g(8, 2);
    paramg.k(a(locald1, locald2, paramBoolean));
    paramg.b(1, 3);
    paramg.a(2, locald1);
    paramg.a(3, locald2);
    paramg.a(4, paramBoolean);
  }

  private static void a(g paramg, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramg.g(1, 2);
    paramg.k(a(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramg.a(1, d.a(paramThread.getName()));
    paramg.a(2, paramInt);
    int i = paramArrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++)
      a(paramg, 3, paramArrayOfStackTraceElement[j], paramBoolean);
  }

  private static void a(g paramg, Map<String, String> paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramg.g(2, 2);
      paramg.k(a((String)localEntry.getKey(), (String)localEntry.getValue()));
      paramg.a(1, d.a((String)localEntry.getKey()));
      String str = (String)localEntry.getValue();
      if (str == null)
        str = "";
      paramg.a(2, d.a(str));
    }
  }

  private static int b(d paramd)
  {
    return g.b(1, paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.as
 * JD-Core Version:    0.6.2
 */