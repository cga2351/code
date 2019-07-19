package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import com.yandex.metrica.impl.bw;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class fj
{

  @SuppressLint({"StaticFieldLeak"})
  private static volatile fj a;
  private final Map<String, fi> b = new HashMap();
  private final Map<String, fk> c = new HashMap();
  private final Map<String, fe> d = new HashMap();
  private final Context e;
  private fi f;
  private fe g;
  private fk h;
  private fk i;
  private fk j;
  private fm k;
  private fl l;
  private fn m;

  public fj(Context paramContext)
  {
    this.e = paramContext;
  }

  public static fj a(Context paramContext)
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new fj(paramContext.getApplicationContext());
      return a;
    }
    finally
    {
    }
  }

  private String a(String paramString)
  {
    if (bw.a(21))
      paramString = b(paramString);
    return paramString;
  }

  private boolean a(File paramFile, String paramString)
  {
    File localFile = this.e.getDatabasePath(paramString);
    if (localFile.exists())
      return localFile.renameTo(new File(paramFile, paramString));
    return false;
  }

  @TargetApi(21)
  private String b(String paramString)
  {
    try
    {
      File localFile1 = this.e.getNoBackupFilesDir();
      File localFile2 = new File(localFile1, paramString);
      if ((!localFile2.exists()) && (a(localFile1, paramString)))
      {
        a(localFile1, paramString + "-journal");
        a(localFile1, paramString + "-shm");
        a(localFile1, paramString + "-wal");
      }
      String str = localFile2.getAbsolutePath();
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public fi a()
  {
    try
    {
      if (this.f == null)
        this.f = a("metrica_data.db", ff.b());
      fi localfi = this.f;
      return localfi;
    }
    finally
    {
    }
  }

  public fi a(y paramy)
  {
    try
    {
      String str = "db_metrica_".concat(String.valueOf(paramy));
      fi localfi = (fi)this.b.get(str);
      if (localfi == null)
      {
        localfi = a(str, ff.a());
        this.b.put(str, localfi);
      }
      return localfi;
    }
    finally
    {
    }
  }

  fi a(String paramString, fo paramfo)
  {
    return new fi(this.e, a(paramString), paramfo);
  }

  public fe b()
  {
    try
    {
      if (this.g == null)
        this.g = new fe(new ft(a()), "binary_data");
      fe localfe = this.g;
      return localfe;
    }
    finally
    {
    }
  }

  public fk b(y paramy)
  {
    try
    {
      String str = paramy.toString();
      fk localfk = (fk)this.c.get(str);
      if (localfk == null)
      {
        localfk = new fk(a(paramy), "preferences");
        this.c.put(str, localfk);
      }
      return localfk;
    }
    finally
    {
    }
  }

  public fe c(y paramy)
  {
    try
    {
      String str = paramy.toString();
      fe localfe = (fe)this.d.get(str);
      if (localfe == null)
      {
        localfe = new fe(new ft(a(paramy)), "binary_data");
        this.d.put(str, localfe);
      }
      return localfe;
    }
    finally
    {
    }
  }

  public fk c()
  {
    try
    {
      if (this.h == null)
        this.h = new fk(a(), "preferences");
      fk localfk = this.h;
      return localfk;
    }
    finally
    {
    }
  }

  public fn d()
  {
    try
    {
      if (this.m == null)
        this.m = new fn(a(), "permissions");
      fn localfn = this.m;
      return localfn;
    }
    finally
    {
    }
  }

  public fk e()
  {
    try
    {
      if (this.i == null)
        this.i = new fk(a(), "startup");
      fk localfk = this.i;
      return localfk;
    }
    finally
    {
    }
  }

  public fk f()
  {
    try
    {
      if (this.j == null)
      {
        String str = a("metrica_client_data.db");
        this.j = new fk("preferences", new fs(this.e, str));
      }
      fk localfk = this.j;
      return localfk;
    }
    finally
    {
    }
  }

  public fm g()
  {
    try
    {
      if (this.k == null)
        this.k = new fm(this.e, a());
      fm localfm = this.k;
      return localfm;
    }
    finally
    {
    }
  }

  public fl h()
  {
    try
    {
      if (this.l == null)
        this.l = new fl(this.e, a());
      fl localfl = this.l;
      return localfl;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fj
 * JD-Core Version:    0.6.2
 */