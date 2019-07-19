package com.viber.voip.camera.e;

import java.io.Serializable;

public final class d
  implements Serializable
{
  private long a;
  private long b;
  private boolean c;

  private d()
  {
    b();
  }

  public static d a()
  {
    return new d();
  }

  public void a(String paramString)
  {
  }

  public void b()
  {
    this.a = System.nanoTime();
    this.b = 0L;
    this.c = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.e.d
 * JD-Core Version:    0.6.2
 */