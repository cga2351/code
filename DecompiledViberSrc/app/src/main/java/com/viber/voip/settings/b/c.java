package com.viber.voip.settings.b;

import com.viber.common.b.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.bk;

public class c extends a
{
  private int b;

  public c(String paramString, int paramInt)
  {
    super(paramString);
    this.b = paramInt;
  }

  public void a(int paramInt)
  {
    ViberApplication.preferences(bk.b()).b(this.a, paramInt);
  }

  public int d()
  {
    return ViberApplication.preferences(bk.b()).a(this.a, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.c
 * JD-Core Version:    0.6.2
 */