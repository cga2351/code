package com.viber.voip.registration;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.viber.dexshared.Logger;
import com.viber.voip.R.raw;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import java.io.InputStream;
import java.util.Locale;

public class k
  implements p
{
  private static final Logger a = ViberEnv.getLogger();
  private final String b;
  private final Resources c;
  private final Context d;
  private final Resources e;

  public k(Context paramContext)
  {
    this.d = paramContext;
    this.c = paramContext.getResources();
    this.b = paramContext.getPackageName();
    this.e = b();
  }

  private String a(String paramString, Resources paramResources)
  {
    if (!paramString.trim().startsWith("@string/"))
      paramString = "@string/" + paramString;
    try
    {
      String str = b(paramString, paramResources);
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return this.c.getString(R.string.unknown);
  }

  private Resources b()
  {
    Configuration localConfiguration1 = this.c.getConfiguration();
    if (localConfiguration1.locale.getLanguage().equals("en"));
    Configuration localConfiguration2;
    do
    {
      return null;
      localConfiguration2 = new Configuration(localConfiguration1);
    }
    while (Build.VERSION.SDK_INT < 17);
    localConfiguration2.setLocale(Locale.ENGLISH);
    return this.d.createConfigurationContext(localConfiguration2).getResources();
  }

  private String b(String paramString, Resources paramResources)
  {
    if (!paramString.trim().startsWith("@string/"))
      throw new IllegalArgumentException("Invalid title value = " + paramString + ", required \"@string/<value>\"");
    String str = paramString.replace("@string/", "");
    int i = paramResources.getIdentifier(str, "string", this.b);
    if (i == 0)
      throw new IllegalArgumentException("Cant find string by idName = " + str);
    return paramResources.getString(i);
  }

  public InputStream a()
  {
    return this.c.openRawResource(R.raw.phonecodes);
  }

  public String a(String paramString)
  {
    return a(paramString, this.c);
  }

  public String b(String paramString)
  {
    if (this.e == null)
      return null;
    return a(paramString, this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.k
 * JD-Core Version:    0.6.2
 */