package com.viber.common.c.a.a;

import android.net.Uri;

public final class a
{
  public static Uri a(int paramInt1, int paramInt2, String paramString)
  {
    return Uri.parse("viber://auth?app-id=" + paramInt1 + "&scope=" + paramInt2 + "&identifier=" + paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.c.a.a.a
 * JD-Core Version:    0.6.2
 */