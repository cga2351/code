package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface zzlx
{
  public static final ByteBuffer zzavh = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

  public abstract void flush();

  public abstract boolean isActive();

  public abstract void reset();

  public abstract boolean zzb(int paramInt1, int paramInt2, int paramInt3)
    throws zzly;

  public abstract boolean zzdx();

  public abstract int zzhj();

  public abstract int zzhk();

  public abstract void zzhl();

  public abstract ByteBuffer zzhm();

  public abstract void zzi(ByteBuffer paramByteBuffer);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlx
 * JD-Core Version:    0.6.2
 */