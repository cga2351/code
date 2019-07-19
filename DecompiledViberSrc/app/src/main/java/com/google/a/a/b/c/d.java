package com.google.a.a.b.c;

import com.google.a.a.c.n;
import com.google.a.a.c.p;
import com.google.a.a.c.s;
import com.google.a.a.c.x;
import com.google.a.a.f.z;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class d
  implements n, x
{
  static final Logger a = Logger.getLogger(d.class.getName());
  private final b b;
  private final n c;
  private final x d;

  public d(b paramb, p paramp)
  {
    this.b = ((b)z.a(paramb));
    this.c = paramp.j();
    this.d = paramp.i();
    paramp.a(this);
    paramp.a(this);
  }

  public boolean a(p paramp, s params, boolean paramBoolean)
    throws IOException
  {
    boolean bool;
    if ((this.d != null) && (this.d.a(paramp, params, paramBoolean)))
      bool = true;
    while (true)
    {
      if ((bool) && (paramBoolean) && (params.d() / 100 == 5));
      try
      {
        this.b.a();
        return bool;
        bool = false;
      }
      catch (IOException localIOException)
      {
        a.log(Level.WARNING, "exception thrown while calling server callback", localIOException);
      }
    }
    return bool;
  }

  public boolean a(p paramp, boolean paramBoolean)
    throws IOException
  {
    boolean bool;
    if ((this.c != null) && (this.c.a(paramp, paramBoolean)))
      bool = true;
    while (true)
    {
      if (bool);
      try
      {
        this.b.a();
        return bool;
        bool = false;
      }
      catch (IOException localIOException)
      {
        a.log(Level.WARNING, "exception thrown while calling server callback", localIOException);
      }
    }
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.c.d
 * JD-Core Version:    0.6.2
 */