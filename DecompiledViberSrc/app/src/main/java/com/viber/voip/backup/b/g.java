package com.viber.voip.backup.b;

import com.google.a.a.c.b;
import com.google.a.a.c.f;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.r;
import com.viber.voip.util.h.a;
import com.viber.voip.util.h.d;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class g extends b
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private final long b;
  private float c;
  private int d;
  private f e;
  private r f;
  private e g;

  public g(f paramf, r paramr, e parame)
  {
    super(paramf.d());
    this.e = paramf;
    this.b = paramf.a();
    this.f = paramr;
    this.g = parame;
  }

  public long a()
  {
    return this.b;
  }

  public void a(long paramLong)
  {
    if (this.f != null)
    {
      int i = (int)(100.0F * (this.c / (float)this.b));
      if (i > this.d)
      {
        this.f.a(i);
        this.d = i;
      }
    }
    this.c = ((float)paramLong);
  }

  public InputStream b()
    throws FileNotFoundException
  {
    return new c(new a(this.e.b(), this), this.g);
  }

  public boolean f()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.g
 * JD-Core Version:    0.6.2
 */