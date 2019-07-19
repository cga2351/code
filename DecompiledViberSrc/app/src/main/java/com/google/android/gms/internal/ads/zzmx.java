package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzmx
  implements zzlx
{
  private int zzafu = -1;
  private float zzauh = 1.0F;
  private float zzaui = 1.0F;
  private ByteBuffer zzaws = zzavh;
  private int zzaxh = -1;
  private ByteBuffer zzaxl = zzavh;
  private boolean zzaxm;
  private zzmw zzays;
  private ShortBuffer zzayt = this.zzaxl.asShortBuffer();
  private long zzayu;
  private long zzayv;

  public final void flush()
  {
    this.zzays = new zzmw(this.zzaxh, this.zzafu);
    this.zzays.setSpeed(this.zzauh);
    this.zzays.zza(this.zzaui);
    this.zzaws = zzavh;
    this.zzayu = 0L;
    this.zzayv = 0L;
    this.zzaxm = false;
  }

  public final boolean isActive()
  {
    return (Math.abs(this.zzauh - 1.0F) >= 0.01F) || (Math.abs(this.zzaui - 1.0F) >= 0.01F);
  }

  public final void reset()
  {
    this.zzays = null;
    this.zzaxl = zzavh;
    this.zzayt = this.zzaxl.asShortBuffer();
    this.zzaws = zzavh;
    this.zzafu = -1;
    this.zzaxh = -1;
    this.zzayu = 0L;
    this.zzayv = 0L;
    this.zzaxm = false;
  }

  public final float zzb(float paramFloat)
  {
    this.zzauh = zzsy.zza(paramFloat, 0.1F, 8.0F);
    return this.zzauh;
  }

  public final boolean zzb(int paramInt1, int paramInt2, int paramInt3)
    throws zzly
  {
    if (paramInt3 != 2)
      throw new zzly(paramInt1, paramInt2, paramInt3);
    if ((this.zzaxh == paramInt1) && (this.zzafu == paramInt2))
      return false;
    this.zzaxh = paramInt1;
    this.zzafu = paramInt2;
    return true;
  }

  public final float zzc(float paramFloat)
  {
    this.zzaui = zzsy.zza(paramFloat, 0.1F, 8.0F);
    return paramFloat;
  }

  public final boolean zzdx()
  {
    return (this.zzaxm) && ((this.zzays == null) || (this.zzays.zzhx() == 0));
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
    this.zzays.zzhl();
    this.zzaxm = true;
  }

  public final ByteBuffer zzhm()
  {
    ByteBuffer localByteBuffer = this.zzaws;
    this.zzaws = zzavh;
    return localByteBuffer;
  }

  public final long zzhz()
  {
    return this.zzayu;
  }

  public final void zzi(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      ShortBuffer localShortBuffer = paramByteBuffer.asShortBuffer();
      int j = paramByteBuffer.remaining();
      this.zzayu += j;
      this.zzays.zza(localShortBuffer);
      paramByteBuffer.position(j + paramByteBuffer.position());
    }
    int i = this.zzays.zzhx() * this.zzafu << 1;
    if (i > 0)
    {
      if (this.zzaxl.capacity() >= i)
        break label147;
      this.zzaxl = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.zzayt = this.zzaxl.asShortBuffer();
    }
    while (true)
    {
      this.zzays.zzb(this.zzayt);
      this.zzayv += i;
      this.zzaxl.limit(i);
      this.zzaws = this.zzaxl;
      return;
      label147: this.zzaxl.clear();
      this.zzayt.clear();
    }
  }

  public final long zzia()
  {
    return this.zzayv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmx
 * JD-Core Version:    0.6.2
 */