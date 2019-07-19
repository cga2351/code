package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzux
{
  private final float bottom;
  private final float left;
  private final float right;
  private final float top;
  private final int zzbvv;

  @VisibleForTesting
  public zzux(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = (paramFloat1 + paramFloat3);
    this.bottom = (paramFloat2 + paramFloat4);
    this.zzbvv = paramInt;
  }

  final float zzna()
  {
    return this.left;
  }

  final float zznb()
  {
    return this.top;
  }

  final float zznc()
  {
    return this.right;
  }

  final float zznd()
  {
    return this.bottom;
  }

  final int zzne()
  {
    return this.zzbvv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzux
 * JD-Core Version:    0.6.2
 */