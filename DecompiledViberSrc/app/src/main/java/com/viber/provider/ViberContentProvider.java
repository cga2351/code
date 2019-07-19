package com.viber.provider;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;

public abstract class ViberContentProvider extends ContentProvider
{
  private static UriMatcher a;

  private static UriMatcher c()
  {
    if (a == null);
    try
    {
      if (a == null)
      {
        UriMatcher localUriMatcher = new UriMatcher(-1);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "method/*", 1500);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "method/*", 1500);
        a = localUriMatcher;
      }
      return a;
    }
    finally
    {
    }
  }

  protected abstract b a();

  public boolean a(Uri paramUri, String paramString, Bundle paramBundle)
  {
    if ((1500 == c().match(paramUri)) && ("updateLanguage".equals((String)paramUri.getPathSegments().get(1))))
    {
      b localb = a();
      if ((localb != null) && (localb.f()))
        localb.a(Resources.getSystem().getConfiguration().locale);
      return true;
    }
    return false;
  }

  protected abstract b b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.ViberContentProvider
 * JD-Core Version:    0.6.2
 */