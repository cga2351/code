package com.appboy.ui.actions;

import android.net.Uri;
import android.os.Bundle;
import com.appboy.b.e;
import com.appboy.f.i;

public class ActionFactory
{
  public static UriAction createUriActionFromUri(Uri paramUri, Bundle paramBundle, boolean paramBoolean, e parame)
  {
    if (paramUri != null)
      return new UriAction(paramUri, paramBundle, paramBoolean, parame);
    return null;
  }

  public static UriAction createUriActionFromUrlString(String paramString, Bundle paramBundle, boolean paramBoolean, e parame)
  {
    if (!i.c(paramString))
      return createUriActionFromUri(Uri.parse(paramString), paramBundle, paramBoolean, parame);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.actions.ActionFactory
 * JD-Core Version:    0.6.2
 */