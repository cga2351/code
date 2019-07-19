package com.viber.voip.api.scheme.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ViberActionRunner;

public class o extends aa
{
  private static final Logger f = ViberEnv.getLogger();
  private final Intent g;

  public o()
  {
    this(null);
  }

  public o(Intent paramIntent)
  {
    this.g = paramIntent;
  }

  void a(Context paramContext)
  {
    if (this.g == null);
    do
    {
      do
        return;
      while (ViberApplication.isActivated());
      if (!(paramContext instanceof Activity))
        this.g.addFlags(268435456);
    }
    while (!ViberActionRunner.a(this.g, paramContext));
    paramContext.startActivity(this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.o
 * JD-Core Version:    0.6.2
 */