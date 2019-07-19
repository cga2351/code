package com.viber.voip.analytics.e;

import android.text.TextUtils;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.MixpanelAPI.c;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ca;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private final d b;
  private MixpanelAPI c;
  private String d;
  private String e;
  private String f;

  public e(d paramd)
  {
    this.b = paramd;
  }

  private void a()
  {
    if (this.c == null);
    int i;
    do
    {
      do
      {
        do
          return;
        while ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)));
        this.d = this.c.getDistinctId();
      }
      while (this.d == null);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.d.hashCode();
      arrayOfInt[1] = this.e.hashCode();
      arrayOfInt[2] = this.f.hashCode();
      i = ca.a(arrayOfInt);
    }
    while (i == this.b.d());
    this.c.alias(this.e, this.d);
    this.c.getPeople().a("$braze_device_id", this.e);
    this.c.alias(this.f, this.d);
    this.c.getPeople().a("$braze_external_id", this.f);
    this.b.a(i);
  }

  void a(MixpanelAPI paramMixpanelAPI)
  {
    try
    {
      if ((!paramMixpanelAPI.getDistinctId().equals(this.d)) || (this.c != paramMixpanelAPI))
      {
        this.c = paramMixpanelAPI;
        a();
      }
      return;
    }
    finally
    {
    }
  }

  public void a(String paramString1, String paramString2)
  {
    try
    {
      if ((!paramString1.equals(this.e)) || (!paramString2.equals(this.f)))
      {
        this.e = paramString1;
        this.f = paramString2;
        a();
      }
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.e.e
 * JD-Core Version:    0.6.2
 */