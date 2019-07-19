package com.viber.voip.settings.b;

import com.viber.common.b.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.bk;

public class d extends a
{
  private long b;

  public d(String paramString, long paramLong)
  {
    super(paramString);
    this.b = paramLong;
  }

  public void a(long paramLong)
  {
    ViberApplication.preferences(bk.b()).b(this.a, paramLong);
  }

  public long d()
  {
    return ViberApplication.preferences(bk.b()).a(this.a, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.d
 * JD-Core Version:    0.6.2
 */