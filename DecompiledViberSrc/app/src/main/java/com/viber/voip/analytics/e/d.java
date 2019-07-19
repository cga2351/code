package com.viber.voip.analytics.e;

import android.text.TextUtils;
import com.mixpanel.android.mpmetrics.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private static String b = "/track";
  private static String c = "/engage";
  private static String d = "/decide";
  private f e;
  private String f;
  private String g;
  private String h;

  public d(f paramf)
  {
    this.e = paramf;
  }

  private void a()
  {
    this.f = "";
    this.g = "";
    this.h = "";
    String str = this.e.a();
    if (!TextUtils.isEmpty(str))
    {
      this.f = (str + b);
      this.g = (str + c);
      this.h = (str + d);
    }
  }

  void a(i parami)
  {
    while (true)
    {
      try
      {
        a();
        if (TextUtils.isEmpty(this.f))
        {
          parami.l();
          if (TextUtils.isEmpty(this.g))
          {
            parami.n();
            if (!TextUtils.isEmpty(this.h))
              break label78;
            parami.p();
          }
        }
        else
        {
          parami.a(this.f);
          continue;
        }
      }
      finally
      {
      }
      parami.b(this.g);
      continue;
      label78: parami.c(this.h);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.e.d
 * JD-Core Version:    0.6.2
 */