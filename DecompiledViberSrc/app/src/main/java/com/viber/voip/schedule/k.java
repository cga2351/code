package com.viber.voip.schedule;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.t;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends h
{
  private static final Logger a = ViberEnv.getLogger();

  protected String a()
  {
    return ap.c().P;
  }

  protected void a(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = bk.a(ViberApplication.getInstance().getUserManager().getRegistrationValues(), paramString, "sayhi", "");
    if (localJSONObject != null)
      d.t.f.a(localJSONObject.toString());
  }

  protected com.viber.common.b.h b()
  {
    return d.t.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.k
 * JD-Core Version:    0.6.2
 */