package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public final class zzcz
  implements DataItemAsset
{
  private final String zzdm;
  private final String zzdn;

  public zzcz(DataItemAsset paramDataItemAsset)
  {
    this.zzdm = paramDataItemAsset.getId();
    this.zzdn = paramDataItemAsset.getDataItemKey();
  }

  public final String getDataItemKey()
  {
    return this.zzdn;
  }

  public final String getId()
  {
    return this.zzdm;
  }

  public final boolean isDataValid()
  {
    return true;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzdm == null)
      localStringBuilder.append(",noid");
    while (true)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.zzdn);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.zzdm);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcz
 * JD-Core Version:    0.6.2
 */