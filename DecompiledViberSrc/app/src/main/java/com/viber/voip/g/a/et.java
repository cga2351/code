package com.viber.voip.g.a;

import android.content.Context;
import com.viber.common.permission.c;
import com.viber.voip.h.a;
import com.viber.voip.permissions.i;
import com.viber.voip.permissions.j;
import javax.inject.Singleton;

public abstract class et
{
  @Singleton
  static c a(Context paramContext)
  {
    j localj = new j(paramContext, a.d());
    localj.a(new i());
    return localj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.et
 * JD-Core Version:    0.6.2
 */