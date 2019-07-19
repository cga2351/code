package com.viber.voip.analytics.a;

import com.adjust.sdk.AdjustEvent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class h extends s
{
  private static final Logger a = ViberEnv.getLogger();
  private AdjustEvent b;
  private boolean c = false;

  public h(String paramString1, String paramString2)
  {
    super(paramString1);
    this.b = new AdjustEvent(paramString2);
  }

  private static String a(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.toLowerCase();
  }

  public h a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
      return this;
    try
    {
      this.b.addCallbackParameter(a(paramString1), a(URLEncoder.encode(paramString2, "utf-8")));
      return this;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return this;
  }

  h a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public h b(String paramString1, String paramString2)
  {
    double d1 = 0.0D;
    try
    {
      double d2 = Double.parseDouble(paramString1);
      d1 = d2;
      this.b.setRevenue(d1, paramString2);
      return this;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        localNumberFormatException.printStackTrace();
    }
  }

  public AdjustEvent c()
  {
    return this.b;
  }

  public boolean d()
  {
    return this.c;
  }

  public String toString()
  {
    return super.toString() + ", singleReporting=" + this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.h
 * JD-Core Version:    0.6.2
 */