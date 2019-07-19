package com.viber.common.d;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import java.io.File;

public class d
{
  public static Uri a(Uri paramUri, Context paramContext, String paramString)
  {
    String str = paramUri.getScheme();
    int i;
    if ((str != null) && (str.startsWith("file")))
      i = 1;
    while (true)
    {
      if (i != 0);
      try
      {
        Uri localUri = FileProvider.getUriForFile(paramContext, paramString, new File(paramUri.getPath()));
        paramUri = localUri;
        return paramUri;
        i = 0;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (Build.VERSION.SDK_INT < 24);
      }
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.d
 * JD-Core Version:    0.6.2
 */