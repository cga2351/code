package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class zzmv
  implements zzlx
{
  private int zzafu = -1;
  private int zzagi = 0;
  private ByteBuffer zzaws = zzavh;
  private int zzaxh = -1;
  private ByteBuffer zzaxl = zzavh;
  private boolean zzaxm;

  public final void flush()
  {
    this.zzaws = zzavh;
    this.zzaxm = false;
  }

  public final boolean isActive()
  {
    return (this.zzagi != 0) && (this.zzagi != 2);
  }

  public final void reset()
  {
    flush();
    this.zzaxl = zzavh;
    this.zzaxh = -1;
    this.zzafu = -1;
    this.zzagi = 0;
  }

  public final boolean zzb(int paramInt1, int paramInt2, int paramInt3)
    throws zzly
  {
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824))
      throw new zzly(paramInt1, paramInt2, paramInt3);
    if ((this.zzaxh == paramInt1) && (this.zzafu == paramInt2) && (this.zzagi == paramInt3))
      return false;
    this.zzaxh = paramInt1;
    this.zzafu = paramInt2;
    this.zzagi = paramInt3;
    if (paramInt3 == 2)
      this.zzaxl = zzavh;
    return true;
  }

  public final boolean zzdx()
  {
    return (this.zzaxm) && (this.zzaws == zzavh);
  }

  public final int zzhj()
  {
    return this.zzafu;
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
    int k = j - i;
    int m;
    switch (this.zzagi)
    {
    default:
      throw new IllegalStateException();
    case 3:
      m = k << 1;
      label66: if (this.zzaxl.capacity() < m)
        this.zzaxl = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
      break;
    case -2147483648:
    case 1073741824:
    }
    while (true)
      switch (this.zzagi)
      {
      default:
        throw new IllegalStateException();
        m = k / 3 << 1;
        break label66;
        m = k / 2;
        break label66;
        this.zzaxl.clear();
      case 3:
      case -2147483648:
      case 1073741824:
      }
    while (i < j)
    {
      this.zzaxl.put((byte)0);
      this.zzaxl.put((byte)(-128 + (0xFF & paramByteBuffer.get(i))));
      i++;
      continue;
      while (i < j)
      {
        this.zzaxl.put(paramByteBuffer.get(i + 1));
        this.zzaxl.put(paramByteBuffer.get(i + 2));
        i += 3;
        continue;
        for (int n = i; n < j; n += 4)
        {
          this.zzaxl.put(paramByteBuffer.get(n + 2));
          this.zzaxl.put(paramByteBuffer.get(n + 3));
        }
      }
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    this.zzaxl.flip();
    this.zzaws = this.zzaxl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmv
 * JD-Core Version:    0.6.2
 */