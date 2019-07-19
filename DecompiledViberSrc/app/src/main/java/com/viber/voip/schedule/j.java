package com.viber.voip.schedule;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends h
{
  private static final Logger a = ViberEnv.getLogger();

  protected String a()
  {
    return ap.c().J;
  }

  protected void a(String paramString)
    throws JSONException
  {
    String str1 = ViberApplication.getInstance().getUserManager().getRegistrationValues().b();
    JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("onboarding_packs");
    String str2 = "+" + str1;
    JSONArray localJSONArray;
    if (localJSONObject.has(str2))
      localJSONArray = localJSONObject.getJSONArray(str2);
    while (true)
    {
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
        d.p.r.a(localJSONArray.toString());
      return;
      boolean bool = localJSONObject.has("");
      localJSONArray = null;
      if (bool)
        localJSONArray = localJSONObject.getJSONArray("");
    }
  }

  protected com.viber.common.b.h b()
  {
    return d.p.q;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.j
 * JD-Core Version:    0.6.2
 */