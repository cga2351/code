package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import c.a.a.a.a.b.r;
import c.a.a.a.c;
import c.a.a.a.i;
import c.a.a.a.l;

public class CrashlyticsInitProvider extends ContentProvider
{
  boolean a(Context paramContext, r paramr, a parama)
  {
    if (paramr.b(paramContext))
      return parama.a(paramContext);
    return paramr.d(paramContext);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public String getType(Uri paramUri)
  {
    return null;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public boolean onCreate()
  {
    Context localContext = getContext();
    if (a(localContext, new r(), new b()));
    while (true)
    {
      try
      {
        i[] arrayOfi = new i[1];
        arrayOfi[0] = new a();
        c.a(localContext, arrayOfi);
        c.g().c("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization successful");
        return true;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        c.g().c("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization unsuccessful");
        return false;
      }
      c.g().c("CrashlyticsInitProvider", "CrashlyticsInitProvider skipping initialization");
    }
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  static abstract interface a
  {
    public abstract boolean a(Context paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.CrashlyticsInitProvider
 * JD-Core Version:    0.6.2
 */