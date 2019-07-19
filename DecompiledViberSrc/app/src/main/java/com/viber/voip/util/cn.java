package com.viber.voip.util;

import android.content.res.Resources;
import com.viber.common.d.c;

public class cn
{
  private Resources a;

  public cn(Resources paramResources)
  {
    this.a = paramResources;
  }

  public String a(int paramInt)
  {
    return this.a.getString(paramInt);
  }

  public String a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.a.getString(paramInt, paramArrayOfObject);
  }

  public String b(int paramInt, Object[] paramArrayOfObject)
  {
    return c.a(this.a, paramInt, paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cn
 * JD-Core Version:    0.6.2
 */