package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzta
{
  private final int height;
  private final int width;
  public final List<byte[]> zzafw;
  public final int zzamf;
  public final float zzbne;

  private zzta(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.zzafw = paramList;
    this.zzamf = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.zzbne = paramFloat;
  }

  public static zzta zzf(zzst paramzzst)
    throws zzlm
  {
    int i = -1;
    int j = 0;
    int k;
    try
    {
      paramzzst.zzac(4);
      k = 1 + (0x3 & paramzzst.readUnsignedByte());
      if (k == 3)
        throw new IllegalStateException();
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new zzlm("Error parsing AVC config", localArrayIndexOutOfBoundsException);
    }
    ArrayList localArrayList = new ArrayList();
    int m = 0x1F & paramzzst.readUnsignedByte();
    for (int n = 0; n < m; n++)
      localArrayList.add(zzg(paramzzst));
    int i1 = paramzzst.readUnsignedByte();
    while (j < i1)
    {
      localArrayList.add(zzg(paramzzst));
      j++;
    }
    float f = 1.0F;
    int i2;
    if (m > 0)
    {
      byte[] arrayOfByte = (byte[])localArrayList.get(0);
      zzsr localzzsr = zzsq.zze((byte[])localArrayList.get(0), k, arrayOfByte.length);
      i2 = localzzsr.width;
      i = localzzsr.height;
      f = localzzsr.zzbne;
    }
    while (true)
    {
      zzta localzzta = new zzta(localArrayList, k, i2, i, f);
      return localzzta;
      i2 = i;
    }
  }

  private static byte[] zzg(zzst paramzzst)
  {
    int i = paramzzst.readUnsignedShort();
    int j = paramzzst.getPosition();
    paramzzst.zzac(i);
    return zzsl.zza(paramzzst.data, j, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzta
 * JD-Core Version:    0.6.2
 */