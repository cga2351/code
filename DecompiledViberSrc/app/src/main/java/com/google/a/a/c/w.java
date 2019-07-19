package com.google.a.a.c;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public abstract class w
{
  static final Logger a = Logger.getLogger(w.class.getName());
  private static final String[] b = { "DELETE", "GET", "POST", "PUT" };

  static
  {
    Arrays.sort(b);
  }

  public final q a()
  {
    return a(null);
  }

  public final q a(r paramr)
  {
    return new q(this, paramr);
  }

  protected abstract z a(String paramString1, String paramString2)
    throws IOException;

  public boolean a(String paramString)
    throws IOException
  {
    return Arrays.binarySearch(b, paramString) >= 0;
  }

  p b()
  {
    return new p(this, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.w
 * JD-Core Version:    0.6.2
 */