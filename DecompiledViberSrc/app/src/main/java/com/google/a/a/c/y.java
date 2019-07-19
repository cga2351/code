package com.google.a.a.c;

import com.google.a.a.f.z;
import java.io.InputStream;

public final class y extends b
{
  private long a = -1L;
  private boolean b;
  private final InputStream c;

  public y(String paramString, InputStream paramInputStream)
  {
    super(paramString);
    this.c = ((InputStream)z.a(paramInputStream));
  }

  public long a()
  {
    return this.a;
  }

  public y a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }

  public y b(String paramString)
  {
    return (y)super.a(paramString);
  }

  public y b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public InputStream b()
  {
    return this.c;
  }

  public y c(boolean paramBoolean)
  {
    return (y)super.a(paramBoolean);
  }

  public boolean f()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.y
 * JD-Core Version:    0.6.2
 */