package com.google.android.gms.internal.measurement;

final class zztj extends zzto
{
  private final int zzbtw;
  private final int zzbtx;

  zztj(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzbtw = paramInt1;
    this.zzbtx = paramInt2;
  }

  public final int size()
  {
    return this.zzbtx;
  }

  public final byte zzam(int paramInt)
  {
    int i = size();
    if ((paramInt | i - (paramInt + 1)) < 0)
    {
      if (paramInt < 0)
        throw new ArrayIndexOutOfBoundsException(22 + "Index < 0: " + paramInt);
      throw new ArrayIndexOutOfBoundsException(40 + "Index > length: " + paramInt + ", " + i);
    }
    return this.zzbtz[(paramInt + this.zzbtw)];
  }

  final byte zzan(int paramInt)
  {
    return this.zzbtz[(paramInt + this.zzbtw)];
  }

  protected final int zzug()
  {
    return this.zzbtw;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztj
 * JD-Core Version:    0.6.2
 */