package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;

public final class zzayt
{
  public final int count;
  public final String name;
  private final double zzdxd;
  private final double zzdxe;
  public final double zzdxf;

  public zzayt(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
  {
    this.name = paramString;
    this.zzdxe = paramDouble1;
    this.zzdxd = paramDouble2;
    this.zzdxf = paramDouble3;
    this.count = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzayt));
    zzayt localzzayt;
    do
    {
      return false;
      localzzayt = (zzayt)paramObject;
    }
    while ((!Objects.equal(this.name, localzzayt.name)) || (this.zzdxd != localzzayt.zzdxd) || (this.zzdxe != localzzayt.zzdxe) || (this.count != localzzayt.count) || (Double.compare(this.zzdxf, localzzayt.zzdxf) != 0));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = Double.valueOf(this.zzdxd);
    arrayOfObject[2] = Double.valueOf(this.zzdxe);
    arrayOfObject[3] = Double.valueOf(this.zzdxf);
    arrayOfObject[4] = Integer.valueOf(this.count);
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzdxe)).add("maxBound", Double.valueOf(this.zzdxd)).add("percent", Double.valueOf(this.zzdxf)).add("count", Integer.valueOf(this.count)).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayt
 * JD-Core Version:    0.6.2
 */