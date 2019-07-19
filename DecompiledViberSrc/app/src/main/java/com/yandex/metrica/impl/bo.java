package com.yandex.metrica.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.ob.am;
import com.yandex.metrica.impl.ob.fj;
import com.yandex.metrica.impl.ob.fn;
import com.yandex.metrica.impl.ob.fx;
import com.yandex.metrica.impl.ob.fy;
import com.yandex.metrica.impl.ob.fz;
import com.yandex.metrica.impl.ob.ge;
import com.yandex.metrica.impl.ob.hd;
import com.yandex.metrica.impl.ob.hd.a;
import com.yandex.metrica.impl.ob.he;
import com.yandex.metrica.impl.ob.hg;
import com.yandex.metrica.impl.ob.ir;
import com.yandex.metrica.impl.ob.iv;
import com.yandex.metrica.impl.ob.iy;
import com.yandex.metrica.impl.ob.je;
import com.yandex.metrica.impl.ob.jj;
import com.yandex.metrica.impl.ob.jk;
import com.yandex.metrica.impl.ob.jl;
import com.yandex.metrica.impl.ob.jm;
import com.yandex.metrica.impl.ob.jn;
import com.yandex.metrica.impl.ob.jo;
import com.yandex.metrica.impl.ob.jp;
import com.yandex.metrica.impl.ob.mi;
import com.yandex.metrica.impl.ob.mw;
import com.yandex.metrica.impl.ob.mw.a;
import com.yandex.metrica.impl.ob.oq;
import com.yandex.metrica.impl.ob.y;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bo extends ao
{
  private final fy a;
  private final Context b;

  public bo(Context paramContext)
  {
    this.b = paramContext;
    this.a = new fy(fj.a(paramContext).c());
  }

  protected int a(jk paramjk)
  {
    int i = paramjk.a();
    if (i == -1)
      i = this.a.a(-1);
    return i;
  }

  SparseArray<ao.a> a()
  {
    return new SparseArray()
    {
    };
  }

  protected void a(jk paramjk, int paramInt)
  {
    this.a.b(paramInt).i();
    paramjk.b().j();
  }

  static class a
    implements ao.a
  {
    private final ge<Collection<iy>> a;
    private final ge<mw> b;
    private final hg c;

    public a(ge<Collection<iy>> paramge, ge<mw> paramge1, hg paramhg)
    {
      this.a = paramge;
      this.b = paramge1;
      this.c = paramhg;
    }

    public void a(Context paramContext)
    {
      fn localfn = fj.a(paramContext).d();
      List localList = localfn.a();
      if (localList != null)
      {
        this.a.a(localList);
        localfn.b();
      }
      mw.a locala = ((mw)this.b.a()).a();
      he localhe = this.c.a(paramContext);
      if (localhe != null)
        locala.b(localhe.a).c(localhe.b);
      locala.c(true);
      this.b.a(locala.a());
      paramContext.getSharedPreferences("com.yandex.metrica.configuration", 0).edit().clear().apply();
    }
  }

  static class b
    implements ao.a
  {
    private ge a;
    private fz b;

    public b(ge paramge, fz paramfz)
    {
      this.a = paramge;
      this.b = paramfz;
    }

    public void a(Context paramContext)
    {
      mw localmw = this.b.a();
      this.a.a(localmw);
    }
  }

  static class c
    implements ao.a
  {
    private jm a;
    private fz b;

    c(Context paramContext)
    {
      this.a = new jm(paramContext);
      this.b = new fz(fj.a(paramContext).e(), paramContext.getPackageName());
    }

    public void a(Context paramContext)
    {
      String str = this.a.a(null);
      if (!TextUtils.isEmpty(str))
      {
        this.b.b(str).i();
        jm.a(paramContext);
      }
    }
  }

  private static class d
    implements ao.a
  {
    public void a(Context paramContext)
    {
      jj localjj = new jj(paramContext, paramContext.getPackageName());
      SharedPreferences localSharedPreferences = jp.a(paramContext, "_boundentrypreferences");
      String str = localSharedPreferences.getString(jj.d.a(), null);
      long l = localSharedPreferences.getLong(jj.e.a(), -1L);
      if ((str != null) && (l != -1L))
      {
        localjj.a(new b.a(str, l)).j();
        localSharedPreferences.edit().remove(jj.d.a()).remove(jj.e.a()).apply();
      }
    }
  }

  static class e
    implements ao.a
  {
    public void a(Context paramContext)
    {
      fy localfy = new fy(fj.a(paramContext).c());
      jn localjn = new jn(paramContext);
      if (localjn.a())
      {
        localfy.a(true);
        localjn.b();
      }
      jl localjl = new jl(paramContext, paramContext.getPackageName());
      long l = localjl.a(0);
      if (l != 0L)
        localfy.a(l);
      localjl.a();
      jj localjj = new jj(paramContext, new am(paramContext.getPackageName(), null).toString());
      CounterConfiguration.a locala = localjj.b();
      if (locala != CounterConfiguration.a.a)
        localfy.a(locala);
      String str = localjj.b(null);
      if (!TextUtils.isEmpty(str))
        localfy.a(str);
      localjj.d().c().j();
      localfy.i();
      je localje = new je(paramContext);
      localje.a();
      localje.b();
      fz localfz = new fz(fj.a(paramContext).e(), paramContext.getPackageName());
      new hg().a(paramContext, new he(oq.b(localfz.a().b, ""), null), new iv(new ir()));
    }
  }

  static class f
    implements ao.a
  {
    public void a(Context paramContext)
    {
      int i = 1;
      fy localfy = new fy(fj.a(paramContext).c());
      int j;
      if (new fz(fj.a(paramContext).e(), paramContext.getPackageName()).a().s > 0L)
      {
        j = i;
        if (localfy.c(-1) <= 0L)
          break label83;
      }
      while (true)
      {
        if ((j != 0) || (i != 0))
          localfy.c(false).i();
        return;
        j = 0;
        break;
        label83: i = 0;
      }
    }
  }

  static class g
    implements ao.a
  {
    public void a(Context paramContext)
    {
      fz localfz = new fz(fj.a(paramContext).e(), paramContext.getPackageName());
      String str1 = localfz.i(null);
      if (str1 != null)
        localfz.a(Collections.singletonList(str1));
      String str2 = localfz.j(null);
      if (str2 != null)
        localfz.b(Collections.singletonList(str2));
    }
  }

  static class h
    implements ao.a
  {
    public void a(Context paramContext)
    {
      b(paramContext);
      new fz(fj.a(paramContext).e(), paramContext.getPackageName()).p(new jo("LAST_STARTUP_CLIDS_SAVE_TIME").b()).i();
    }

    void b(Context paramContext)
    {
      File localFile1 = c(paramContext);
      FilenameFilter[] arrayOfFilenameFilter = new FilenameFilter[2];
      arrayOfFilenameFilter[0] = new b(new d(paramContext.getPackageName()));
      arrayOfFilenameFilter[1] = new b(new c());
      File[] arrayOfFile = localFile1.listFiles(new a(Arrays.asList(arrayOfFilenameFilter)));
      int i = arrayOfFile.length;
      int j = 0;
      while (true)
        if (j < i)
        {
          File localFile2 = arrayOfFile[j];
          try
          {
            if (!localFile2.delete())
              mi.a(paramContext).reportEvent("Can not delete file", new JSONObject().put("fileName", localFile2.getName()).toString());
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              mi.a(paramContext).reportError("Can not delete file", localException);
          }
        }
    }

    File c(Context paramContext)
    {
      if (bw.a(21))
        return paramContext.getNoBackupFilesDir();
      return new File(paramContext.getFilesDir().getParentFile(), "databases");
    }

    static class a
      implements FilenameFilter
    {
      final Iterable<FilenameFilter> a;

      a(Iterable<FilenameFilter> paramIterable)
      {
        this.a = paramIterable;
      }

      public boolean accept(File paramFile, String paramString)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
          if (((FilenameFilter)localIterator.next()).accept(paramFile, paramString))
            return true;
        return false;
      }
    }

    static class b
      implements FilenameFilter
    {
      private final FilenameFilter a;

      b(FilenameFilter paramFilenameFilter)
      {
        this.a = paramFilenameFilter;
      }

      public boolean accept(File paramFile, String paramString)
      {
        if (paramString.startsWith("db_metrica_"))
          try
          {
            FilenameFilter localFilenameFilter = this.a;
            if (paramString.endsWith("-journal"))
              paramString = paramString.replace("-journal", "");
            boolean bool = localFilenameFilter.accept(paramFile, paramString);
            return bool;
          }
          catch (Exception localException)
          {
          }
        return false;
      }
    }

    static class c
      implements FilenameFilter
    {
      public boolean accept(File paramFile, String paramString)
      {
        return paramString.endsWith("null");
      }
    }

    static class d
      implements FilenameFilter
    {
      private final String a;

      d(String paramString)
      {
        this.a = paramString;
      }

      public boolean accept(File paramFile, String paramString)
      {
        return !paramString.contains(this.a);
      }
    }
  }

  static class i
    implements ao.a
  {
    public void a(Context paramContext)
    {
      ge localge = hd.a.a(mw.class).a(paramContext);
      mw localmw = (mw)localge.a();
      mw.a locala = localmw.a();
      if (localmw.s > 0L);
      for (boolean bool = true; ; bool = false)
      {
        localge.a(locala.a(bool).c(true).a());
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bo
 * JD-Core Version:    0.6.2
 */