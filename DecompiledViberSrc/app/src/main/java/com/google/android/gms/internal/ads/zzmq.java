package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzmq
  implements zzlx
{
  private int zzafu = -1;
  private ByteBuffer zzaws = zzavh;
  private int zzaxh = -1;
  private int[] zzaxi;
  private boolean zzaxj;
  private int[] zzaxk;
  private ByteBuffer zzaxl = zzavh;
  private boolean zzaxm;

  public final void flush()
  {
    this.zzaws = zzavh;
    this.zzaxm = false;
  }

  public final boolean isActive()
  {
    return this.zzaxj;
  }

  public final void reset()
  {
    flush();
    this.zzaxl = zzavh;
    this.zzafu = -1;
    this.zzaxh = -1;
    this.zzaxk = null;
    this.zzaxj = false;
  }

  public final void zzb(int[] paramArrayOfInt)
  {
    this.zzaxi = paramArrayOfInt;
  }

  public final boolean zzb(int paramInt1, int paramInt2, int paramInt3)
    throws zzly
  {
    if (!Arrays.equals(this.zzaxi, this.zzaxk));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.zzaxk = this.zzaxi;
      if (this.zzaxk != null)
        break;
      this.zzaxj = false;
      return bool1;
    }
    if (paramInt3 != 2)
      throw new zzly(paramInt1, paramInt2, paramInt3);
    if ((!bool1) && (this.zzaxh == paramInt1) && (this.zzafu == paramInt2))
      return false;
    this.zzaxh = paramInt1;
    this.zzafu = paramInt2;
    if (paramInt2 != this.zzaxk.length);
    int i;
    int j;
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.zzaxj = bool2;
      i = 0;
      if (i >= this.zzaxk.length)
        break label195;
      j = this.zzaxk[i];
      if (j < paramInt2)
        break;
      throw new zzly(paramInt1, paramInt2, paramInt3);
    }
    boolean bool3 = this.zzaxj;
    if (j != i);
    for (boolean bool4 = true; ; bool4 = false)
    {
      this.zzaxj = (bool4 | bool3);
      i++;
      break;
    }
    label195: return true;
  }

  public final boolean zzdx()
  {
    return (this.zzaxm) && (this.zzaws == zzavh);
  }

  public final int zzhj()
  {
    if (this.zzaxk == null)
      return this.zzafu;
    return this.zzaxk.length;
  }

  public final int zzhk()
  {
    return 2;
  }

  public final void zzhl()
  {
    this.zzaxm = true;
  }

  public final ByteBuffer zzhm()
  {
    ByteBuffer localByteBuffer = this.zzaws;
    this.zzaws = zzavh;
    return localByteBuffer;
  }

  public final void zzi(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit();
    int k = (j - i) / (2 * this.zzafu) * this.zzaxk.length << 1;
    int m;
    if (this.zzaxl.capacity() < k)
    {
      this.zzaxl = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
      m = i;
    }
    while (m < j)
    {
      int[] arrayOfInt = this.zzaxk;
      int n = arrayOfInt.length;
      int i1 = 0;
      while (true)
        if (i1 < n)
        {
          int i2 = arrayOfInt[i1];
          this.zzaxl.putShort(paramByteBuffer.getShort(m + i2 * 2));
          i1++;
          continue;
          this.zzaxl.clear();
          m = i;
          break;
        }
      m += (this.zzafu << 1);
    }
    paramByteBuffer.position(j);
    this.zzaxl.flip();
    this.zzaws = this.zzaxl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmq
 * JD-Core Version:    0.6.2
 */