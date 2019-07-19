package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zznd extends zzmy
{
  public long zzaga;
  private final int zzagb = 0;
  public final zzmz zzaze = new zzmz();
  public ByteBuffer zzde;

  public zznd(int paramInt)
  {
  }

  private final ByteBuffer zzao(int paramInt)
  {
    if (this.zzde == null);
    for (int i = 0; ; i = this.zzde.capacity())
      throw new IllegalStateException(44 + "Buffer too small (" + i + " < " + paramInt + ")");
  }

  public final void clear()
  {
    super.clear();
    if (this.zzde != null)
      this.zzde.clear();
  }

  public final void zzan(int paramInt)
    throws IllegalStateException
  {
    if (this.zzde == null)
      this.zzde = zzao(paramInt);
    int i;
    int j;
    int k;
    do
    {
      return;
      i = this.zzde.capacity();
      j = this.zzde.position();
      k = j + paramInt;
    }
    while (i >= k);
    ByteBuffer localByteBuffer = zzao(k);
    if (j > 0)
    {
      this.zzde.position(0);
      this.zzde.limit(j);
      localByteBuffer.put(this.zzde);
    }
    this.zzde = localByteBuffer;
  }

  public final boolean zzeo()
  {
    return zzam(1073741824);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznd
 * JD-Core Version:    0.6.2
 */