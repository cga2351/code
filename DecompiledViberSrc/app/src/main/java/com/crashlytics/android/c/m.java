package com.crashlytics.android.c;

import c.a.a.a.a.f.a;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.io.IOException;

class m
{
  private final String a;
  private final a b;

  public m(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
  }

  private File d()
  {
    return new File(this.b.a(), this.a);
  }

  public boolean a()
  {
    try
    {
      boolean bool = d().createNewFile();
      return bool;
    }
    catch (IOException localIOException)
    {
      c.g().e("CrashlyticsCore", "Error creating marker: " + this.a, localIOException);
    }
    return false;
  }

  public boolean b()
  {
    return d().exists();
  }

  public boolean c()
  {
    return d().delete();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.m
 * JD-Core Version:    0.6.2
 */