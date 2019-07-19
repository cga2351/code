package com.google.android.gms.internal.ads;

final class zzdmv extends zzdna
{
  private final int zzhcv;
  private final int zzhcw;

  zzdmv(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzg(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzhcv = paramInt1;
    this.zzhcw = paramInt2;
  }

  public final int size()
  {
    return this.zzhcw;
  }

  protected final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.zzhcy, zzavr(), paramArrayOfByte, 0, paramInt3);
  }

  protected final int zzavr()
  {
    return this.zzhcv;
  }

  public final byte zzfm(int paramInt)
  {
    int i = size();
    if ((paramInt | i - (paramInt + 1)) < 0)
    {
      if (paramInt < 0)
        throw new ArrayIndexOutOfBoundsException(22 + "Index < 0: " + paramInt);
      throw new ArrayIndexOutOfBoundsException(40 + "Index > length: " + paramInt + ", " + i);
    }
    return this.zzhcy[(paramInt + this.zzhcv)];
  }

  final byte zzfn(int paramInt)
  {
    return this.zzhcy[(paramInt + this.zzhcv)];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmv
 * JD-Core Version:    0.6.2
 */