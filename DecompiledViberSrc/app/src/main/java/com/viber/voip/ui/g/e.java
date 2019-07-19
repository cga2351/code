package com.viber.voip.ui.g;

import com.viber.voip.ui.g.a.a;

public abstract class e<I extends c, S extends a>
  implements d<I, S>
{
  private I a;
  private S b;

  public void a()
  {
    this.a = null;
    this.b = null;
  }

  public void a(I paramI, S paramS)
  {
    this.a = paramI;
    this.b = paramS;
  }

  public I d()
  {
    return this.a;
  }

  public S e()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.g.e
 * JD-Core Version:    0.6.2
 */