package com.crashlytics.android.c;

import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class aa
  implements ap
{
  private final File[] a;
  private final Map<String, String> b;
  private final String c;

  public aa(String paramString, File[] paramArrayOfFile)
  {
    this.a = paramArrayOfFile;
    this.b = new HashMap(aq.a);
    this.c = paramString;
  }

  public String a()
  {
    return this.a[0].getName();
  }

  public String b()
  {
    return this.c;
  }

  public File c()
  {
    return this.a[0];
  }

  public File[] d()
  {
    return this.a;
  }

  public Map<String, String> e()
  {
    return Collections.unmodifiableMap(this.b);
  }

  public void f()
  {
    for (File localFile : this.a)
    {
      c.g().a("CrashlyticsCore", "Removing invalid report file at " + localFile.getPath());
      localFile.delete();
    }
  }

  public ap.a g()
  {
    return ap.a.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.aa
 * JD-Core Version:    0.6.2
 */