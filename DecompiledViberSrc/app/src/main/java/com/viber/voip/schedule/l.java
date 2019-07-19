package com.viber.voip.schedule;

import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ax;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends h
{
  protected static boolean a = false;

  protected String a()
  {
    if (a)
      return d.ad.y.d();
    return ap.c().at;
  }

  protected void a(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    d.a().a(localJSONObject);
  }

  protected com.viber.common.b.h b()
  {
    return d.ax.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.l
 * JD-Core Version:    0.6.2
 */