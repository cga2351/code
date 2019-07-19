package c.a.a.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import c.a.a.a.c;
import c.a.a.a.l;

public class r
{
  String a(Context paramContext)
  {
    int i = i.a(paramContext, "google_app_id", "string");
    if (i != 0)
    {
      c.g().a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
      return a(paramContext.getResources().getString(i));
    }
    return null;
  }

  String a(String paramString)
  {
    return i.b(paramString).substring(0, 40);
  }

  public boolean b(Context paramContext)
  {
    if (i.a(paramContext, "com.crashlytics.useFirebaseAppId", false));
    while ((e(paramContext)) && (!c(paramContext)))
      return true;
    return false;
  }

  boolean c(Context paramContext)
  {
    if (!TextUtils.isEmpty(new g().c(paramContext)));
    while (!TextUtils.isEmpty(new g().d(paramContext)))
      return true;
    return false;
  }

  public boolean d(Context paramContext)
  {
    int i = i.a(paramContext, "io.fabric.auto_initialize", "bool");
    boolean bool;
    if (i == 0)
      bool = false;
    do
    {
      return bool;
      bool = paramContext.getResources().getBoolean(i);
    }
    while (!bool);
    c.g().a("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
    return bool;
  }

  boolean e(Context paramContext)
  {
    int i = i.a(paramContext, "google_app_id", "string");
    if (i == 0);
    while (TextUtils.isEmpty(paramContext.getResources().getString(i)))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.r
 * JD-Core Version:    0.6.2
 */