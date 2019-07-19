package com.appnexus.opensdk;

import android.view.View;

class j
  implements m
{
  private long a;
  private i b;
  private boolean c;
  private MediatedAdViewController d;

  j(i parami, Long paramLong, boolean paramBoolean, MediatedAdViewController paramMediatedAdViewController)
  {
    this.a = paramLong.longValue();
    this.b = parami;
    this.c = paramBoolean;
    this.d = paramMediatedAdViewController;
  }

  public long a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.c;
  }

  public MediatedAdViewController c()
  {
    return this.d;
  }

  public View d()
  {
    if (this.b == null)
      return null;
    return this.b.i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.j
 * JD-Core Version:    0.6.2
 */