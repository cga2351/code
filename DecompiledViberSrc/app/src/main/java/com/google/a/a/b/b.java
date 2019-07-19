package com.google.a.a.b;

import com.google.a.a.c.ad;
import com.google.a.a.c.e;
import com.google.a.a.c.h;
import com.google.a.a.c.l;
import com.google.a.a.c.m;
import com.google.a.a.c.p;
import com.google.a.a.c.r;
import com.google.a.a.c.w;
import java.io.IOException;

public final class b
  implements l, r
{
  private final boolean a;

  public b()
  {
    this(false);
  }

  b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  private boolean c(p paramp)
    throws IOException
  {
    boolean bool = true;
    String str = paramp.b();
    if (str.equals("POST"));
    do
    {
      bool = false;
      while (!paramp.a().a(str))
        do
        {
          return bool;
          if (!str.equals("GET"))
            break;
        }
        while (paramp.c().b().length() > 2048);
      return false;
    }
    while (!this.a);
    return bool;
  }

  public void a(p paramp)
  {
    paramp.a(this);
  }

  public void b(p paramp)
    throws IOException
  {
    if (c(paramp))
    {
      String str = paramp.b();
      paramp.a("POST");
      paramp.g().a("X-HTTP-Method-Override", str);
      if (!str.equals("GET"))
        break label67;
      paramp.a(new ad(paramp.c().a()));
      paramp.c().clear();
    }
    label67: 
    while (paramp.d() != null)
      return;
    paramp.a(new e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.b
 * JD-Core Version:    0.6.2
 */