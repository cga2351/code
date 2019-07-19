package com.viber.voip.market.b;

import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.market.MarketApi.g;
import com.viber.voip.model.a;
import com.viber.voip.util.dd;
import java.util.Iterator;
import java.util.Set;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private MarketApi.g b;

  private String a(String paramString)
  {
    Iterator localIterator = ViberApplication.getInstance().getContactManager().c().c(paramString).iterator();
    if (localIterator.hasNext())
      paramString = ((a)localIterator.next()).k();
    return paramString;
  }

  private String b(String paramString)
  {
    CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName(paramString);
    if (localCountryNameInfo != null)
      return localCountryNameInfo.countryShortName;
    return "";
  }

  public void a(String paramString, MarketApi.g paramg)
  {
    this.b = paramg;
    if (paramString == null)
      paramString = "";
    final String str = b(paramString);
    dd.a(new Runnable()
    {
      public void run()
      {
        f.a(f.this).a(this.a, str);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.f
 * JD-Core Version:    0.6.2
 */