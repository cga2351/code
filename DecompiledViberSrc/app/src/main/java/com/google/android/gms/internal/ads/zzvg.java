package com.google.android.gms.internal.ads;

public final class zzvg
{
  final long value;
  final int zzbvx;
  final String zzbwe;

  zzvg(long paramLong, String paramString, int paramInt)
  {
    this.value = paramLong;
    this.zzbwe = paramString;
    this.zzbvx = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzvg)))
      return false;
    return (((zzvg)paramObject).value == this.value) && (((zzvg)paramObject).zzbvx == this.zzbvx);
  }

  public final int hashCode()
  {
    return (int)this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvg
 * JD-Core Version:    0.6.2
 */