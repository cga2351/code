package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzrh
{
  public final int viewportHeight = 2147483647;
  public final int viewportWidth = 2147483647;
  public final String zzble = null;
  public final String zzblf = null;
  public final boolean zzblg = false;
  public final boolean zzblh = true;
  public final int zzbli = 2147483647;
  public final int zzblj = 2147483647;
  public final int zzblk = 2147483647;
  public final boolean zzbll = true;
  public final boolean zzblm = true;
  public final boolean zzbln = true;

  public zzrh()
  {
    this(null, null, false, true, 2147483647, 2147483647, 2147483647, true, true, 2147483647, 2147483647, true);
  }

  private zzrh(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, int paramInt4, int paramInt5, boolean paramBoolean5)
  {
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzrh localzzrh;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzrh = (zzrh)paramObject;
    }
    while ((this.zzblh == localzzrh.zzblh) && (this.zzbli == localzzrh.zzbli) && (this.zzblj == localzzrh.zzblj) && (this.zzbll == localzzrh.zzbll) && (this.zzblm == localzzrh.zzblm) && (this.zzbln == localzzrh.zzbln) && (this.viewportWidth == localzzrh.viewportWidth) && (this.viewportHeight == localzzrh.viewportHeight) && (this.zzblk == localzzrh.zzblk) && (TextUtils.equals(null, null)) && (TextUtils.equals(null, null)));
    return false;
  }

  public final int hashCode()
  {
    int i = 1;
    int j = 31 * (31 * (31 * null.hashCode() + null.hashCode()));
    int k;
    int n;
    label72: int i2;
    label92: int i3;
    if (this.zzblh)
    {
      k = i;
      int m = 31 * (31 * (31 * (31 * (k + j) + this.zzbli) + this.zzblj) + this.zzblk);
      if (!this.zzbll)
        break label135;
      n = i;
      int i1 = 31 * (n + m);
      if (!this.zzblm)
        break label141;
      i2 = i;
      i3 = 31 * (i2 + i1);
      if (!this.zzbln)
        break label147;
    }
    while (true)
    {
      return 31 * (31 * (i3 + i) + this.viewportWidth) + this.viewportHeight;
      k = 0;
      break;
      label135: n = 0;
      break label72;
      label141: i2 = 0;
      break label92;
      label147: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrh
 * JD-Core Version:    0.6.2
 */