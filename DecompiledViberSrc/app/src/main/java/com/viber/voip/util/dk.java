package com.viber.voip.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import java.io.File;

public final class dk
{
  public static Uri a(int paramInt, Context paramContext)
  {
    return Uri.parse("android.resource://" + paramContext.getPackageName() + "/" + paramInt);
  }

  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "content"));
  }

  public static boolean a(Uri paramUri1, Uri paramUri2)
  {
    if (paramUri1 == null)
      return paramUri2 == null;
    return paramUri1.equals(paramUri2);
  }

  private static boolean a(Uri paramUri, String paramString)
  {
    String str = paramUri.getScheme();
    return (str != null) && (str.startsWith(paramString));
  }

  public static boolean a(String paramString)
  {
    return (!da.a(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")));
  }

  public static boolean b(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "file"));
  }

  public static boolean c(Uri paramUri)
  {
    if (!b(paramUri));
    File localFile;
    do
    {
      return false;
      localFile = Environment.getExternalStorageDirectory();
    }
    while ((localFile == null) || (!paramUri.getPath().startsWith(localFile.getPath())));
    return true;
  }

  public static boolean d(Uri paramUri)
  {
    if (!b(paramUri));
    String str;
    do
    {
      return false;
      str = paramUri.getPath();
    }
    while ((str == null) || (!str.startsWith(Environment.getExternalStoragePublicDirectory("viber").getPath())));
    return true;
  }

  public static boolean e(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "android.resource"));
  }

  public static boolean f(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "http"));
  }

  public static boolean g(Uri paramUri)
  {
    return (paramUri != null) && ((a(paramUri, "viber")) || (a(paramUri, "viber.soc")));
  }

  public static boolean h(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "market"));
  }

  public static boolean i(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "tel"));
  }

  public static boolean j(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "mailto"));
  }

  public static boolean k(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "rakutenbank"));
  }

  public static boolean l(Uri paramUri)
  {
    return (paramUri != null) && (a(paramUri, "viber-test"));
  }

  public static String m(Uri paramUri)
  {
    if (paramUri != null)
      return paramUri.toString();
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dk
 * JD-Core Version:    0.6.2
 */