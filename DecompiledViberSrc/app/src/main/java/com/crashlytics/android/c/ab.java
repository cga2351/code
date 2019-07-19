package com.crashlytics.android.c;

import android.content.Context;
import c.a.a.a.a.b.i;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.util.Set;

class ab
{
  private static final b a = new b(null);
  private final Context b;
  private final a c;
  private z d;

  ab(Context paramContext, a parama)
  {
    this(paramContext, parama, null);
  }

  ab(Context paramContext, a parama, String paramString)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = a;
    a(paramString);
  }

  private String a(File paramFile)
  {
    String str = paramFile.getName();
    int i = str.lastIndexOf(".temp");
    if (i == -1)
      return str;
    return str.substring("crashlytics-userlog-".length(), i);
  }

  private File b(String paramString)
  {
    String str = "crashlytics-userlog-" + paramString + ".temp";
    return new File(this.c.a(), str);
  }

  d a()
  {
    return this.d.a();
  }

  void a(long paramLong, String paramString)
  {
    this.d.a(paramLong, paramString);
  }

  void a(File paramFile, int paramInt)
  {
    this.d = new an(paramFile, paramInt);
  }

  final void a(String paramString)
  {
    this.d.c();
    this.d = a;
    if (paramString == null)
      return;
    if (!i.a(this.b, "com.crashlytics.CollectCustomLogs", true))
    {
      c.g().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
      return;
    }
    a(b(paramString), 65536);
  }

  void a(Set<String> paramSet)
  {
    File[] arrayOfFile = this.c.a().listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        if (!paramSet.contains(a(localFile)))
          localFile.delete();
      }
    }
  }

  byte[] b()
  {
    return this.d.b();
  }

  void c()
  {
    this.d.d();
  }

  public static abstract interface a
  {
    public abstract File a();
  }

  private static final class b
    implements z
  {
    public d a()
    {
      return null;
    }

    public void a(long paramLong, String paramString)
    {
    }

    public byte[] b()
    {
      return null;
    }

    public void c()
    {
    }

    public void d()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ab
 * JD-Core Version:    0.6.2
 */