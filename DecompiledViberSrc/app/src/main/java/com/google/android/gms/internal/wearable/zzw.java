package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzw
{
  private static final int zzhn = 11;
  private static final int zzho = 12;
  private static final int zzhp = 16;
  private static final int zzhq = 26;
  private static final int[] zzhr = new int[0];
  public static final long[] zzhs = new long[0];
  public static final float[] zzht = new float[0];
  private static final double[] zzhu = new double[0];
  private static final boolean[] zzhv = new boolean[0];
  public static final String[] zzhw = new String[0];
  private static final byte[][] zzhx = new byte[0][];
  public static final byte[] zzhy = new byte[0];

  public static final int zzb(zzk paramzzk, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramzzk.getPosition();
    paramzzk.zzd(paramInt);
    while (paramzzk.zzj() == paramInt)
    {
      paramzzk.zzd(paramInt);
      i++;
    }
    paramzzk.zzc(j, paramInt);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzw
 * JD-Core Version:    0.6.2
 */