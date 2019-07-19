package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbsr extends zzbtr<AdMetadataListener>
  implements zzagu
{
  private Bundle zzfke = new Bundle();

  public zzbsr(Set<zzbuy<AdMetadataListener>> paramSet)
  {
    super(paramSet);
  }

  public final Bundle getAdMetadata()
  {
    try
    {
      Bundle localBundle = new Bundle(this.zzfke);
      return localBundle;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, Bundle paramBundle)
  {
    try
    {
      this.zzfke.putAll(paramBundle);
      zza(zzbss.zzfka);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbsr
 * JD-Core Version:    0.6.2
 */