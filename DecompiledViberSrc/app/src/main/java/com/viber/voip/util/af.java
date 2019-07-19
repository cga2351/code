package com.viber.voip.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;

public class af
{
  private static final Logger a = ViberEnv.getLogger();

  public static Cursor a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2)
  {
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return localCursor;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static final void a(Cursor paramCursor)
  {
    if (!b(paramCursor));
    try
    {
      paramCursor.close();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public static void a(b paramb, Runnable paramRunnable)
  {
    if (paramb.d())
    {
      paramRunnable.run();
      return;
    }
    paramb.a();
    try
    {
      paramRunnable.run();
      paramb.c();
      return;
    }
    finally
    {
      paramb.b();
    }
  }

  public static final boolean b(Cursor paramCursor)
  {
    return (paramCursor == null) || (paramCursor.isClosed());
  }

  public static final boolean c(Cursor paramCursor)
  {
    return (!b(paramCursor)) && (paramCursor.moveToFirst());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.af
 * JD-Core Version:    0.6.2
 */