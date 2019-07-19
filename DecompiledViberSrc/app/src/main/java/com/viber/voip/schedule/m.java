package com.viber.voip.schedule;

import com.viber.common.a.e;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.bg;
import com.viber.voip.stickers.i;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends h
{
  private static final e a = ViberEnv.getLogger();

  protected String a()
  {
    return ap.c().N;
  }

  protected void a(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = bk.a(ViberApplication.getInstance().getUserManager().getRegistrationValues(), paramString, "viberid_packs", "");
    String str1 = d.bg.d.d();
    if (localJSONObject != null)
    {
      String str2 = localJSONObject.toString();
      if (!str2.equals(str1))
        new ViberIdPromoStickerPackHelper().setNewJsonConfig(str2, i.a());
    }
  }

  protected com.viber.common.b.h b()
  {
    return d.bg.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.m
 * JD-Core Version:    0.6.2
 */