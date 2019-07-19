package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import java.io.InputStream;

final class zzcu extends DataClient.GetFdForAssetResponse
  implements Releasable
{
  private final DataApi.GetFdForAssetResult zzdj;

  zzcu(DataApi.GetFdForAssetResult paramGetFdForAssetResult)
  {
    this.zzdj = paramGetFdForAssetResult;
  }

  public final ParcelFileDescriptor getFdForAsset()
  {
    return this.zzdj.getFd();
  }

  public final InputStream getInputStream()
  {
    return this.zzdj.getInputStream();
  }

  public final void release()
  {
    this.zzdj.release();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcu
 * JD-Core Version:    0.6.2
 */