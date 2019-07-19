package com.google.a.a.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class u
  implements ac
{
  private final ac a;
  private final int b;
  private final Level c;
  private final Logger d;

  public u(ac paramac, Logger paramLogger, Level paramLevel, int paramInt)
  {
    this.a = paramac;
    this.d = paramLogger;
    this.c = paramLevel;
    this.b = paramInt;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    t localt = new t(paramOutputStream, this.d, this.c, this.b);
    try
    {
      this.a.a(localt);
      localt.a().close();
      paramOutputStream.flush();
      return;
    }
    finally
    {
      localt.a().close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.u
 * JD-Core Version:    0.6.2
 */