package com.viber.voip.gdpr;

import com.viber.voip.util.d;

public abstract class a
  implements Runnable
{
  private final d a;

  protected a(d paramd)
  {
    this.a = paramd;
  }

  public abstract void a();

  public abstract void b();

  public final void run()
  {
    if (this.a.b())
    {
      a();
      return;
    }
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a
 * JD-Core Version:    0.6.2
 */