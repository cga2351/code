package com.viber.voip.settings.b;

import android.content.res.Resources;
import com.viber.common.b.g;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class a
{
  private static final Logger b = ViberEnv.getLogger();
  protected final String a;

  public a(Resources paramResources, int paramInt)
  {
    this.a = paramResources.getString(paramInt);
  }

  public a(String paramString)
  {
    this.a = paramString;
  }

  public boolean a()
  {
    return ViberApplication.preferences().a(this.a);
  }

  public void b()
  {
    ViberApplication.preferences().b(this.a);
  }

  public String c()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.a
 * JD-Core Version:    0.6.2
 */