package com.adsnative.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

public class g
{
  public static Intent a(Uri paramUri)
    throws n
  {
    if (paramUri == null)
      throw new NullPointerException("Uri is null");
    if (!l.c.a(paramUri))
      throw new n("URL does not have http:// or https:// scheme.");
    return new Intent("android.intent.action.VIEW", paramUri);
  }

  public static void a(Context paramContext, Intent paramIntent)
    throws f
  {
    if (paramContext == null)
      throw new NullPointerException("Context is null");
    if (paramIntent == null)
      throw new NullPointerException("Intent is null");
    if (!(paramContext instanceof Activity))
      paramIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      throw new f(localActivityNotFoundException);
    }
  }

  public static void a(Context paramContext, Intent paramIntent, String paramString)
    throws f
  {
    if (paramContext == null)
      throw new NullPointerException("Context is null");
    if (paramIntent == null)
      throw new NullPointerException("Intent is null");
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (f localf)
    {
      throw new f(paramString + "\n" + localf.getMessage());
    }
  }

  public static void a(Context paramContext, Uri paramUri, String paramString)
    throws f
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    a(paramContext, localIntent, paramString);
  }

  public static boolean a(Context paramContext, Uri paramUri)
  {
    return a(paramContext, paramUri, true);
  }

  public static boolean a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    if (!b(paramContext, new Intent("android.intent.action.VIEW", paramUri)))
    {
      if (paramBoolean)
        i.d("Could not handle application specific action: " + paramUri + ". You may be running in the emulator or another device which does not have the required application.");
      return false;
    }
    return true;
  }

  public static void b(Context paramContext, Uri paramUri)
    throws f
  {
    if (a(paramContext, paramUri))
    {
      a(paramContext, paramUri, "Unable to open intent for: " + paramUri);
      return;
    }
    throw new f("Could not handle application specific action: " + paramUri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
  }

  public static boolean b(Context paramContext, Intent paramIntent)
  {
    try
    {
      boolean bool1 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return bool2;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.g
 * JD-Core Version:    0.6.2
 */