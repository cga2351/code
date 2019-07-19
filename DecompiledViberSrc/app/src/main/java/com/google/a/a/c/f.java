package com.google.a.a.c;

import com.google.a.a.f.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class f extends b
{
  private final File a;

  public f(String paramString, File paramFile)
  {
    super(paramString);
    this.a = ((File)z.a(paramFile));
  }

  public long a()
  {
    return this.a.length();
  }

  public f b(String paramString)
  {
    return (f)super.a(paramString);
  }

  public f b(boolean paramBoolean)
  {
    return (f)super.a(paramBoolean);
  }

  public InputStream b()
    throws FileNotFoundException
  {
    return new FileInputStream(this.a);
  }

  public boolean f()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.f
 * JD-Core Version:    0.6.2
 */