package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;

public final class zzgj
{
  public static IntentFilter zza(String paramString, Uri paramUri, int paramInt)
  {
    IntentFilter localIntentFilter = new IntentFilter(paramString);
    if (paramUri.getScheme() != null)
      localIntentFilter.addDataScheme(paramUri.getScheme());
    if (paramUri.getAuthority() != null)
      localIntentFilter.addDataAuthority(paramUri.getAuthority(), Integer.toString(paramUri.getPort()));
    if (paramUri.getPath() != null)
      localIntentFilter.addDataPath(paramUri.getPath(), paramInt);
    return localIntentFilter;
  }

  public static IntentFilter zzc(String paramString)
  {
    IntentFilter localIntentFilter = new IntentFilter(paramString);
    localIntentFilter.addDataScheme("wear");
    localIntentFilter.addDataAuthority("*", null);
    return localIntentFilter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgj
 * JD-Core Version:    0.6.2
 */