package com.viber.voip.backup;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public final class t
{
  private static final Logger a = ViberEnv.getLogger();

  static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("getUriByBackupProcess: unknown BackupProcess = " + paramInt);
    case 1:
      return "backup://export";
    case 2:
      return "backup://restore";
    case 3:
    }
    return "backup://to_secondary_export";
  }

  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.getScheme().equals("backup"));
  }

  public static boolean b(Uri paramUri)
  {
    return (a(paramUri)) && (TextUtils.isEmpty(paramUri.getQuery()));
  }

  public static boolean c(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("backup://export"));
  }

  public static boolean d(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("backup://restore"));
  }

  public static boolean e(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("backup://load_info"));
  }

  public static boolean f(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("backup://update_metadata"));
  }

  public static boolean g(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("backup://to_secondary_export"));
  }

  public static int h(Uri paramUri)
  {
    String str = paramUri.getQuery();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str)));
    switch (Integer.parseInt(str))
    {
    default:
      return 0;
    case 1:
      return 1;
    case 2:
    }
    return 2;
  }

  public static long i(Uri paramUri)
  {
    String str = paramUri.getFragment();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str)))
      return Long.parseLong(str);
    return 0L;
  }

  public static Uri j(Uri paramUri)
  {
    return paramUri.buildUpon().clearQuery().fragment(null).build();
  }

  public static final class a
  {
    private final String a;

    public a(String paramString)
    {
      this.a = paramString;
    }

    public Uri a()
    {
      return Uri.parse(this.a);
    }

    public Uri a(int paramInt)
    {
      return Uri.parse(this.a + "?" + paramInt);
    }

    public Uri a(int paramInt, long paramLong)
    {
      return Uri.parse(this.a + "?" + paramInt + "#" + paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.t
 * JD-Core Version:    0.6.2
 */