package com.appnexus.opensdk.viewability;

import android.content.Context;
import com.appnexus.opensdk.R.string;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import com.iab.omid.library.appnexus.Omid;
import com.iab.omid.library.appnexus.adsession.Partner;

public class ANOmidViewabilty
{
  private static ANOmidViewabilty a = null;
  private static String b = "";
  private static Partner c = null;

  private void a()
  {
    new HTTPGet()
    {
      protected HTTPResponse a(Void[] paramAnonymousArrayOfVoid)
      {
        return super.a(paramAnonymousArrayOfVoid);
      }

      protected String a()
      {
        return "https://acdn.adnxs.com/mobile/omsdk/v1/omsdk.js";
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()))
          ANOmidViewabilty.a(paramAnonymousHTTPResponse.getResponseBody());
      }
    }
    .execute(new Void[0]);
  }

  public static ANOmidViewabilty getInstance()
  {
    if (a == null)
    {
      a = new ANOmidViewabilty();
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.init));
    }
    return a;
  }

  public void activateOmidAndCreatePartner(Context paramContext)
  {
    try
    {
      if (!Omid.isActive())
        Omid.activateWithOmidApiVersion(Omid.getVersion(), paramContext);
      if ((!Omid.isActive()) || (c != null));
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      try
      {
        Settings.getSettings().getClass();
        c = Partner.createPartner("Appnexus", "4.11.2");
        if (StringUtil.isEmpty(b))
          a();
        return;
        localIllegalArgumentException1 = localIllegalArgumentException1;
        localIllegalArgumentException1.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        while (true)
          localIllegalArgumentException2.printStackTrace();
      }
    }
  }

  public Partner getAppnexusPartner()
  {
    return c;
  }

  public String getOmidJsServiceContent()
  {
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.viewability.ANOmidViewabilty
 * JD-Core Version:    0.6.2
 */