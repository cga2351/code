package com.viber.voip.b.c.a.a;

import java.io.File;

public class h extends d
{
  b c;
  private final long d;

  public h(b paramb, long paramLong)
  {
    this.c = paramb;
    this.d = paramLong;
  }

  protected boolean a(File paramFile)
  {
    return (this.c.a(paramFile)) || ((this.d > 0L) && (System.currentTimeMillis() - paramFile.lastModified() < this.d));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a.h
 * JD-Core Version:    0.6.2
 */