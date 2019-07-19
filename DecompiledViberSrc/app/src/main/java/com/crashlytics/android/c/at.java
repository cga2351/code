package com.crashlytics.android.c;

import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class at
  implements ap
{
  private final File a;
  private final File[] b;
  private final Map<String, String> c;

  public at(File paramFile)
  {
    this(paramFile, Collections.emptyMap());
  }

  public at(File paramFile, Map<String, String> paramMap)
  {
    this.a = paramFile;
    this.b = new File[] { paramFile };
    this.c = new HashMap(paramMap);
    if (this.a.length() == 0L)
      this.c.putAll(aq.a);
  }

  public String a()
  {
    return c().getName();
  }

  public String b()
  {
    String str = a();
    return str.substring(0, str.lastIndexOf('.'));
  }

  public File c()
  {
    return this.a;
  }

  public File[] d()
  {
    return this.b;
  }

  public Map<String, String> e()
  {
    return Collections.unmodifiableMap(this.c);
  }

  public void f()
  {
    c.g().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
    this.a.delete();
  }

  public ap.a g()
  {
    return ap.a.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.at
 * JD-Core Version:    0.6.2
 */