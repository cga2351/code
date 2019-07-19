package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzvf
{
  @VisibleForTesting
  private static long zza(long paramLong, int paramInt)
  {
    if (paramInt == 0)
      paramLong = 1L;
    while (paramInt == 1)
      return paramLong;
    if (paramInt % 2 == 0)
      return zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
    return paramLong * (zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L) % 1073807359L;
  }

  @VisibleForTesting
  private static String zza(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString.length < paramInt1 + paramInt2)
    {
      zzaxa.zzen("Unable to construct shingle");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = paramInt1; i < -1 + (paramInt1 + paramInt2); i++)
    {
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(paramArrayOfString[(-1 + (paramInt1 + paramInt2))]);
    return localStringBuilder.toString();
  }

  @VisibleForTesting
  private static void zza(int paramInt1, long paramLong, String paramString, int paramInt2, PriorityQueue<zzvg> paramPriorityQueue)
  {
    zzvg localzzvg = new zzvg(paramLong, paramString, paramInt2);
    if ((paramPriorityQueue.size() == paramInt1) && ((((zzvg)paramPriorityQueue.peek()).zzbvx > localzzvg.zzbvx) || (((zzvg)paramPriorityQueue.peek()).value > localzzvg.value)));
    do
    {
      do
        return;
      while (paramPriorityQueue.contains(localzzvg));
      paramPriorityQueue.add(localzzvg);
    }
    while (paramPriorityQueue.size() <= paramInt1);
    paramPriorityQueue.poll();
  }

  public static void zza(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue<zzvg> paramPriorityQueue)
  {
    if (paramArrayOfString.length < paramInt2)
      zza(paramInt1, zzb(paramArrayOfString, 0, paramArrayOfString.length), zza(paramArrayOfString, 0, paramArrayOfString.length), paramArrayOfString.length, paramPriorityQueue);
    while (true)
    {
      return;
      long l1 = zzb(paramArrayOfString, 0, paramInt2);
      zza(paramInt1, l1, zza(paramArrayOfString, 0, paramInt2), paramInt2, paramPriorityQueue);
      long l2 = zza(16785407L, paramInt2 - 1);
      for (int i = 1; i < 1 + (paramArrayOfString.length - paramInt2); i++)
      {
        int j = zzvc.zzbn(paramArrayOfString[(i - 1)]);
        int k = zzvc.zzbn(paramArrayOfString[(-1 + (i + paramInt2))]);
        long l3 = l2 * ((2147483647L + j) % 1073807359L) % 1073807359L;
        l1 = (16785407L * ((l1 + 1073807359L - l3) % 1073807359L) % 1073807359L + (2147483647L + k) % 1073807359L) % 1073807359L;
        zza(paramInt1, l1, zza(paramArrayOfString, i, paramInt2), paramArrayOfString.length, paramPriorityQueue);
      }
    }
  }

  private static long zzb(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    long l = (2147483647L + zzvc.zzbn(paramArrayOfString[0])) % 1073807359L;
    for (int i = 1; i < paramInt2; i++)
      l = (l * 16785407L % 1073807359L + (2147483647L + zzvc.zzbn(paramArrayOfString[i])) % 1073807359L) % 1073807359L;
    return l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvf
 * JD-Core Version:    0.6.2
 */