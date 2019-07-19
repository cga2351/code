package com.google.android.gms.internal.wearable;

import java.util.Arrays;

final class zzv
{
  final int tag;
  final byte[] zzhm;

  zzv(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzhm = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzv localzzv;
    do
    {
      return true;
      if (!(paramObject instanceof zzv))
        return false;
      localzzv = (zzv)paramObject;
    }
    while ((this.tag == localzzv.tag) && (Arrays.equals(this.zzhm, localzzv.zzhm)));
    return false;
  }

  public final int hashCode()
  {
    return 31 * (527 + this.tag) + Arrays.hashCode(this.zzhm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzv
 * JD-Core Version:    0.6.2
 */