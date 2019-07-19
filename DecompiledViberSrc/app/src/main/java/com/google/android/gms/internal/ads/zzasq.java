package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

@zzare
public final class zzasq extends zzast
{
  private final String type;
  private final int zzdqo;

  public zzasq(String paramString, int paramInt)
  {
    this.type = paramString;
    this.zzdqo = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzasq)));
    zzasq localzzasq;
    do
    {
      return false;
      localzzasq = (zzasq)paramObject;
    }
    while ((!Objects.equal(this.type, localzzasq.type)) || (!Objects.equal(Integer.valueOf(this.zzdqo), Integer.valueOf(localzzasq.zzdqo))));
    return true;
  }

  public final int getAmount()
  {
    return this.zzdqo;
  }

  public final String getType()
  {
    return this.type;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasq
 * JD-Core Version:    0.6.2
 */