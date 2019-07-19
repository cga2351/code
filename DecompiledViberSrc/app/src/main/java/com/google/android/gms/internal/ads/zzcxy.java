package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class zzcxy
{
  public static Bundle zza(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle.getBundle(paramString);
    if (localBundle == null)
      localBundle = new Bundle();
    return localBundle;
  }

  public static void zza(Bundle paramBundle1, String paramString, Bundle paramBundle2)
  {
    if (paramBundle2 != null)
      paramBundle1.putBundle(paramString, paramBundle2);
  }

  public static void zza(Bundle paramBundle, String paramString, Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean1)
      paramBundle.putBoolean(paramString, paramBoolean.booleanValue());
  }

  public static void zza(Bundle paramBundle, String paramString, Integer paramInteger, boolean paramBoolean)
  {
    if (paramBoolean)
      paramBundle.putInt(paramString, paramInteger.intValue());
  }

  public static void zza(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramString2 != null)
      paramBundle.putString(paramString1, paramString2);
  }

  public static void zza(Bundle paramBundle, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
      paramBundle.putString(paramString1, paramString2);
  }

  public static void zza(Bundle paramBundle, String paramString, List<String> paramList)
  {
    if (paramList != null)
      paramBundle.putStringArrayList(paramString, new ArrayList(paramList));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxy
 * JD-Core Version:    0.6.2
 */