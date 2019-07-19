package com.viber.voip.analytics.e;

import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import org.json.JSONObject;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private static String b = "vesEnabled";
  private static String c = "vesProxyAddress";
  private final String d;
  private final h e;
  private String f;
  private boolean g;
  private boolean h;

  public f(String paramString, h paramh)
  {
    this.d = paramString;
    this.e = paramh;
  }

  private void c()
  {
    if ((!this.h) && (!TextUtils.isEmpty(this.d)));
    try
    {
      JSONObject localJSONObject = new JSONObject(this.d);
      this.g = localJSONObject.optBoolean(b);
      if (this.g)
        this.f = localJSONObject.getJSONObject(c).optString(d(), "");
      label67: this.h = true;
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }

  private String d()
  {
    String str = ap.d();
    if ("prod".equals(str))
      return str;
    return "int";
  }

  public String a()
  {
    try
    {
      c();
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b()
  {
    try
    {
      c();
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String toString()
  {
    return "MixpanelVesProxy{mProxyJson='" + this.d + '\'' + ", mProxyAddress='" + this.f + '\'' + ", mIsEnabled=" + this.g + ", mIsParsed=" + this.h + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.e.f
 * JD-Core Version:    0.6.2
 */