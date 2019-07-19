package com.crashlytics.android.c;

import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.util.Map;

class ai
  implements ap
{
  private final File a;

  public ai(File paramFile)
  {
    this.a = paramFile;
  }

  public String a()
  {
    return null;
  }

  public String b()
  {
    return this.a.getName();
  }

  public File c()
  {
    return null;
  }

  public File[] d()
  {
    return this.a.listFiles();
  }

  public Map<String, String> e()
  {
    return null;
  }

  public void f()
  {
    for (File localFile : d())
    {
      c.g().a("CrashlyticsCore", "Removing native report file at " + localFile.getPath());
      localFile.delete();
    }
    c.g().a("CrashlyticsCore", "Removing native report directory at " + this.a);
    this.a.delete();
  }

  public ap.a g()
  {
    return ap.a.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ai
 * JD-Core Version:    0.6.2
 */