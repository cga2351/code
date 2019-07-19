package com.my.target;

import android.content.Context;
import android.webkit.URLUtil;
import java.util.Iterator;
import java.util.List;

public class bi
{
  private static final bi a = new bi();

  private String a(String paramString)
  {
    String str = bk.a(paramString);
    if (URLUtil.isNetworkUrl(str))
      return str;
    dp.a("invalid stat url: " + str);
    return null;
  }

  private void a(p paramp)
  {
    if ((paramp instanceof o))
    {
      float f4 = ((o)paramp).a();
      dp.a("tracking progress stat value:" + f4 + " url:" + paramp.d());
      return;
    }
    if ((paramp instanceof n))
    {
      n localn = (n)paramp;
      int j = localn.g();
      float f3 = localn.e();
      boolean bool = localn.a();
      dp.a("tracking ovv stat percent:" + j + " value:" + f3 + " ovv:" + bool + " url:" + paramp.d());
      return;
    }
    if ((paramp instanceof m))
    {
      m localm = (m)paramp;
      int i = localm.g();
      float f1 = localm.e();
      float f2 = localm.a();
      dp.a("tracking mrc stat percent: value:" + f1 + " percent " + i + " duration:" + f2 + " url:" + paramp.d());
      return;
    }
    dp.a("tracking stat type:" + paramp.c() + " url:" + paramp.d());
  }

  public static void a(p paramp, Context paramContext)
  {
    a.b(paramp, paramContext);
  }

  public static void a(List<p> paramList, Context paramContext)
  {
    a.c(paramList, paramContext);
  }

  public static void b(List<String> paramList, Context paramContext)
  {
    a.d(paramList, paramContext);
  }

  void b(final p paramp, Context paramContext)
  {
    if (paramp != null)
      dq.b(new Runnable()
      {
        public void run()
        {
          bi.a(bi.this, paramp);
          String str = bi.a(bi.this, paramp.d());
          if (str != null)
            w.a().c(str, this.b);
        }
      });
  }

  void c(final List<p> paramList, Context paramContext)
  {
    if ((paramList != null) && (paramList.size() > 0))
      dq.b(new Runnable()
      {
        public void run()
        {
          w localw = w.a();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            p localp = (p)localIterator.next();
            bi.a(bi.this, localp);
            String str = bi.a(bi.this, localp.d());
            if (str != null)
              localw.c(str, this.b);
          }
        }
      });
  }

  void d(final List<String> paramList, Context paramContext)
  {
    if ((paramList != null) && (paramList.size() > 0))
      dq.b(new Runnable()
      {
        public void run()
        {
          w localw = w.a();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = bi.a(bi.this, str1);
            if (str2 != null)
              localw.c(str2, this.b);
          }
        }
      });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bi
 * JD-Core Version:    0.6.2
 */