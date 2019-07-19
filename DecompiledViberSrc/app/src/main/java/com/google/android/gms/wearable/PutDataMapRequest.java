package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzt;
import java.util.List;

@VisibleForTesting
public class PutDataMapRequest
{
  private final DataMap zzr;
  private final PutDataRequest zzs;

  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.zzs = paramPutDataRequest;
    this.zzr = new DataMap();
    if (paramDataMap != null)
      this.zzr.putAll(paramDataMap);
  }

  public static PutDataMapRequest create(String paramString)
  {
    Asserts.checkNotNull(paramString, "path must not be null");
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }

  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    Asserts.checkNotNull(paramDataMapItem, "source must not be null");
    return new PutDataMapRequest(PutDataRequest.zza(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }

  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    Asserts.checkNotNull(paramString, "pathPrefix must not be null");
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }

  public PutDataRequest asPutDataRequest()
  {
    zzf localzzf = zze.zza(this.zzr);
    this.zzs.setData(zzt.zzb(localzzf.zzfw));
    int i = localzzf.zzfx.size();
    for (int j = 0; j < i; j++)
    {
      String str1 = Integer.toString(j);
      Asset localAsset = (Asset)localzzf.zzfx.get(j);
      if (str1 == null)
      {
        String str5 = String.valueOf(localAsset);
        throw new IllegalStateException(26 + String.valueOf(str5).length() + "asset key cannot be null: " + str5);
      }
      if (localAsset == null)
      {
        String str3 = String.valueOf(str1);
        if (str3.length() != 0);
        for (String str4 = "asset cannot be null: key=".concat(str3); ; str4 = new String("asset cannot be null: key="))
          throw new IllegalStateException(str4);
      }
      if (Log.isLoggable("DataMap", 3))
      {
        String str2 = String.valueOf(localAsset);
        Log.d("DataMap", 33 + String.valueOf(str1).length() + String.valueOf(str2).length() + "asPutDataRequest: adding asset: " + str1 + " " + str2);
      }
      this.zzs.putAsset(str1, localAsset);
    }
    return this.zzs;
  }

  public DataMap getDataMap()
  {
    return this.zzr;
  }

  public Uri getUri()
  {
    return this.zzs.getUri();
  }

  public boolean isUrgent()
  {
    return this.zzs.isUrgent();
  }

  public PutDataMapRequest setUrgent()
  {
    this.zzs.setUrgent();
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataMapRequest
 * JD-Core Version:    0.6.2
 */