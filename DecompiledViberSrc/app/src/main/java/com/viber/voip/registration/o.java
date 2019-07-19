package com.viber.voip.registration;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class o
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b;

  public o(Context paramContext)
  {
    a(paramContext);
  }

  private a a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      while (paramXmlPullParser.getEventType() != 1)
      {
        if ((paramXmlPullParser.getEventType() == 2) && (paramXmlPullParser.getName().equals("device")))
        {
          String str1 = paramXmlPullParser.getAttributeValue(null, "model");
          String str2 = paramXmlPullParser.getAttributeValue(null, "status");
          if (TextUtils.isEmpty(str2));
          for (int i = 1; Build.MODEL.equalsIgnoreCase(str1); i = Integer.parseInt(str2))
            return new a(str1, i);
        }
        paramXmlPullParser.next();
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
      label111: break label111;
    }
  }

  public static String a(int paramInt, Resources paramResources)
  {
    switch (paramInt)
    {
    default:
      return paramResources.getString(R.string.devicetype_UNKNOWN);
    case 65535:
      return paramResources.getString(R.string.devicetype_UNKNOWN);
    case 0:
      return paramResources.getString(R.string.devicetype_APPLE);
    case 1:
      return paramResources.getString(R.string.devicetype_ANDROID);
    case 3:
      return paramResources.getString(R.string.devicetype_WP7);
    case 4:
      return paramResources.getString(R.string.devicetype_WINDOWS);
    case 5:
      return paramResources.getString(R.string.devicetype_WINDOWS8);
    case 6:
      return paramResources.getString(R.string.devicetype_LINUX);
    case 7:
      return paramResources.getString(R.string.devicetype_OSX);
    case 8:
      return paramResources.getString(R.string.devicetype_IOS3);
    case 9:
      return paramResources.getString(R.string.devicetype_WP8);
    case 10:
      return paramResources.getString(R.string.devicetype_BLACKBERRY10);
    case 21:
      return paramResources.getString(R.string.devicetype_ANDROID_TABLET);
    case 99:
      return paramResources.getString(R.string.devicetype_IOSE);
    case 101:
      return paramResources.getString(R.string.devicetype_NOKIAS60);
    case 102:
      return paramResources.getString(R.string.devicetype_BLACKBERRY);
    case 103:
      return paramResources.getString(R.string.devicetype_WP7_API);
    case 109:
      return paramResources.getString(R.string.devicetype_NOKIAS40);
    case 110:
      return paramResources.getString(R.string.devicetype_BADA3);
    case 20:
    case 98:
    }
    return paramResources.getString(R.string.devicetype_IPAD);
  }

  private void a(Context paramContext)
  {
    boolean bool = true;
    if (a.g())
    {
      this.b = bool;
      return;
    }
    if (a(paramContext.getResources().getXml(R.xml.proximitywhitelist)) != null);
    while (true)
    {
      this.b = bool;
      return;
      bool = false;
    }
  }

  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 4:
    case 5:
    case 6:
    case 7:
    case 21:
    }
    return true;
  }

  public static int b()
  {
    if (ao.f())
      return 21;
    return 1;
  }

  public boolean a()
  {
    return this.b;
  }

  public static class a
  {
    public final String a;
    public final int b;

    public a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.o
 * JD-Core Version:    0.6.2
 */