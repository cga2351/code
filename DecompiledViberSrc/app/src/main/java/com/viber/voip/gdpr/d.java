package com.viber.voip.gdpr;

import android.content.Context;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.ViberActionRunner.i;
import com.viber.voip.util.av;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public final class d
{
  public static final long a;
  public static final long b;
  public static final int c = localCalendar.get(1);
  public static final int d = localCalendar.get(2);
  public static final int e = localCalendar.get(5);
  private static final Logger f = ViberEnv.getLogger();

  static
  {
    a = TimeUnit.DAYS.toMillis(14L);
    b = TimeUnit.MINUTES.toMillis(1L);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(1, -28);
  }

  public static int a()
  {
    int i;
    int k;
    label26: int m;
    if (d.f.b.d())
    {
      i = 1;
      int j = 0x0 | i;
      if (!d.f.c.d())
        break label79;
      k = 2;
      m = j | k;
      if (!d.f.d.d())
        break label84;
    }
    label79: label84: for (int n = 4; ; n = 0)
    {
      int i1 = n | m;
      boolean bool = d.f.e.d();
      int i2 = 0;
      if (bool)
        i2 = 8;
      return i1 | i2;
      i = 0;
      break;
      k = 0;
      break label26;
    }
  }

  public static void a(Context paramContext)
  {
    if (f())
      b(paramContext);
  }

  public static void a(boolean paramBoolean)
  {
    a(paramBoolean, 15);
  }

  public static void a(boolean paramBoolean, int paramInt)
  {
    if ((av.d(1, paramInt)) && (d.f.b.d() != paramBoolean))
      d.f.b.a(paramBoolean);
    if ((av.d(2, paramInt)) && (d.f.c.d() != paramBoolean))
      d.f.c.a(paramBoolean);
    if ((av.d(4, paramInt)) && (d.f.d.d() != paramBoolean))
    {
      if (!c.j.b.e())
        break label111;
      d.f.d.a(true);
    }
    while (true)
    {
      if ((av.d(8, paramInt)) && (d.f.e.d() != paramBoolean))
        d.f.e.a(paramBoolean);
      return;
      label111: d.f.d.a(paramBoolean);
    }
  }

  public static long b()
  {
    long l1 = 0L;
    long l2 = 0;
    long l3;
    long l5;
    label39: long l6;
    if (!d.f.b.d())
    {
      l3 = 1L;
      long l4 = (int)(l3 | l2);
      if (d.f.c.d())
        break label97;
      l5 = 2L;
      l6 = (int)(l5 | l4);
      if (d.f.d.d())
        break label103;
    }
    label97: label103: for (long l7 = 4L; ; l7 = l1)
    {
      long l8 = (int)(l7 | l6);
      if (!d.f.e.d())
        l1 = 8L;
      return (int)(l8 | l1);
      l3 = l1;
      break;
      l5 = l1;
      break label39;
    }
  }

  private static void b(Context paramContext)
  {
    ViberActionRunner.i.b(paramContext, false);
  }

  public static void c()
  {
    if ((c.j.c.e()) && (1 == d.v.h.d()))
    {
      a(false);
      return;
    }
    d.f.b.e();
    d.f.c.e();
    d.f.d.e();
    if (c.j.c.e())
    {
      a(false, 8);
      return;
    }
    d.f.e.e();
  }

  public static long d()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(1, -130);
    return localCalendar.getTimeInMillis();
  }

  public static long e()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(1, -13);
    return localCalendar.getTimeInMillis();
  }

  public static boolean f()
  {
    return (c.j.c.e()) && (d.v.h.d() == 0) && (!d.bf.m.d()) && (d.at.b.d() != 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.d
 * JD-Core Version:    0.6.2
 */