package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class m extends c
{
  public static final long d = TimeUnit.DAYS.toMillis(1L);
  private static final Logger e = ViberEnv.getLogger();

  public m(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = new f(new g(new a()), 256);
  }

  protected void b()
  {
    long l1 = 0L;
    File localFile1 = dv.E.a(this.c);
    List localList1 = this.b.a(localFile1);
    ArrayList localArrayList1 = new ArrayList();
    long l2 = System.currentTimeMillis();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      File localFile3 = (File)localIterator1.next();
      long l3 = l2 - localFile3.lastModified();
      if ((l3 < l1) || (l3 > d))
        localArrayList1.add(localFile3);
    }
    this.b.a(localArrayList1);
    if (at.b(localFile1) > 52428800L)
    {
      List localList2 = this.b.a(localFile1);
      Collections.sort(localList2, new a(null));
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext())
      {
        File localFile2 = (File)localIterator2.next();
        if (l1 >= 26214400L)
          break;
        localArrayList2.add(localFile2);
        l1 += localFile2.length();
      }
      this.b.a(localArrayList2);
    }
  }

  private static class a
    implements Comparator<File>
  {
    public int a(File paramFile1, File paramFile2)
    {
      long l1 = paramFile1.lastModified();
      long l2 = paramFile2.lastModified();
      if (l1 < l2)
        return -1;
      if (l1 == l2)
        return 0;
      return 1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.m
 * JD-Core Version:    0.6.2
 */