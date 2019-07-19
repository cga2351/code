package com.viber.voip.settings.b;

import com.viber.common.b.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.bk;

public class b extends a
{
  private boolean b;

  public b(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.b = paramBoolean;
  }

  public void a(boolean paramBoolean)
  {
    ViberApplication.preferences(bk.b()).b(this.a, paramBoolean);
  }

  public boolean d()
  {
    return ViberApplication.preferences(bk.b()).a(this.a, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.b
 * JD-Core Version:    0.6.2
 */