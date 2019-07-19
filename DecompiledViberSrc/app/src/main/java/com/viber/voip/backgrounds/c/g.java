package com.viber.voip.backgrounds.c;

import com.viber.voip.backgrounds.e;
import com.viber.voip.backgrounds.l;

public abstract class g extends e
{
  private final int a;

  public g(int paramInt)
  {
    this.a = paramInt;
  }

  public void a()
  {
  }

  protected abstract void a(int paramInt);

  public void a(l paraml)
  {
    if (paraml.a != this.a)
      return;
    b(this.a);
  }

  public void a(l paraml, int paramInt)
  {
  }

  protected abstract void b(int paramInt);

  public void b(l paraml)
  {
    if (paraml.a != this.a)
      return;
    a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.g
 * JD-Core Version:    0.6.2
 */