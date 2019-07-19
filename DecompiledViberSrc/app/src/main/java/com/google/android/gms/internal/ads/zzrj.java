package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

public abstract class zzrj extends zzrp
{
  private int zzaul = 0;
  private final SparseArray<Map<zzrb, zzrl>> zzblo = new SparseArray();
  private final SparseBooleanArray zzblp = new SparseBooleanArray();
  private zzrk zzblq;

  public final zzrr zza(zzlp[] paramArrayOfzzlp, zzrb paramzzrb)
    throws zzku
  {
    int[] arrayOfInt1 = new int[1 + paramArrayOfzzlp.length];
    zzra[][] arrayOfzzra; = new zzra[1 + paramArrayOfzzlp.length][];
    int[][][] arrayOfInt = new int[1 + paramArrayOfzzlp.length][][];
    for (int i = 0; i < arrayOfzzra;.length; i++)
    {
      arrayOfzzra;[i] = new zzra[paramzzrb.length];
      arrayOfInt[i] = new int[paramzzrb.length][];
    }
    int[] arrayOfInt2 = new int[paramArrayOfzzlp.length];
    for (int j = 0; j < arrayOfInt2.length; j++)
      arrayOfInt2[j] = paramArrayOfzzlp[j].zzgp();
    int k = 0;
    zzra localzzra;
    int i4;
    int i5;
    int i6;
    label133: int i9;
    label149: int i12;
    int i11;
    if (k < paramzzrb.length)
    {
      localzzra = paramzzrb.zzbg(k);
      i4 = paramArrayOfzzlp.length;
      i5 = 0;
      i6 = 0;
      if (i6 < paramArrayOfzzlp.length)
      {
        zzlp localzzlp2 = paramArrayOfzzlp[i6];
        i9 = 0;
        if (i9 < localzzra.length)
        {
          int i10 = 0x3 & localzzlp2.zza(localzzra.zzbf(i9));
          if (i10 <= i5)
            break label654;
          if (i10 == 3)
            break label222;
          i12 = i10;
          i11 = i6;
        }
      }
    }
    while (true)
    {
      i9++;
      i5 = i12;
      i4 = i11;
      break label149;
      i6++;
      break label133;
      i6 = i4;
      label222: if (i6 == paramArrayOfzzlp.length);
      int[] arrayOfInt4;
      for (Object localObject = new int[localzzra.length]; ; localObject = arrayOfInt4)
      {
        int i8 = arrayOfInt1[i6];
        arrayOfzzra;[i6][i8] = localzzra;
        arrayOfInt[i6][i8] = localObject;
        arrayOfInt1[i6] = (1 + arrayOfInt1[i6]);
        k++;
        break;
        zzlp localzzlp1 = paramArrayOfzzlp[i6];
        arrayOfInt4 = new int[localzzra.length];
        for (int i7 = 0; i7 < localzzra.length; i7++)
          arrayOfInt4[i7] = localzzlp1.zza(localzzra.zzbf(i7));
      }
      zzrb[] arrayOfzzrb = new zzrb[paramArrayOfzzlp.length];
      int[] arrayOfInt3 = new int[paramArrayOfzzlp.length];
      for (int m = 0; m < paramArrayOfzzlp.length; m++)
      {
        int i3 = arrayOfInt1[m];
        arrayOfzzrb[m] = new zzrb((zzra[])Arrays.copyOf(arrayOfzzra;[m], i3));
        arrayOfInt[m] = ((int[][])Arrays.copyOf(arrayOfInt[m], i3));
        arrayOfInt3[m] = paramArrayOfzzlp[m].getTrackType();
      }
      int n = arrayOfInt1[paramArrayOfzzlp.length];
      zzrb localzzrb1 = new zzrb((zzra[])Arrays.copyOf(arrayOfzzra;[paramArrayOfzzlp.length], n));
      zzrm[] arrayOfzzrm = zza(paramArrayOfzzlp, arrayOfzzrb, arrayOfInt);
      int i1 = 0;
      if (i1 < paramArrayOfzzlp.length)
      {
        if (this.zzblp.get(i1))
          arrayOfzzrm[i1] = null;
        while (true)
        {
          i1++;
          break;
          zzrb localzzrb2 = arrayOfzzrb[i1];
          Map localMap = (Map)this.zzblo.get(i1);
          if (localMap == null);
          for (zzrl localzzrl = null; localzzrl != null; localzzrl = (zzrl)localMap.get(localzzrb2))
            throw new NoSuchMethodError();
        }
      }
      zzrk localzzrk = new zzrk(arrayOfInt3, arrayOfzzrb, arrayOfInt2, arrayOfInt, localzzrb1);
      zzlq[] arrayOfzzlq = new zzlq[paramArrayOfzzlp.length];
      int i2 = 0;
      if (i2 < paramArrayOfzzlp.length)
      {
        if (arrayOfzzrm[i2] != null);
        for (zzlq localzzlq = zzlq.zzauk; ; localzzlq = null)
        {
          arrayOfzzlq[i2] = localzzlq;
          i2++;
          break;
        }
      }
      return new zzrr(paramzzrb, new zzro(arrayOfzzrm), localzzrk, arrayOfzzlq);
      label654: i11 = i4;
      i12 = i5;
    }
  }

  protected abstract zzrm[] zza(zzlp[] paramArrayOfzzlp, zzrb[] paramArrayOfzzrb, int[][][] paramArrayOfInt)
    throws zzku;

  public final void zzd(Object paramObject)
  {
    this.zzblq = ((zzrk)paramObject);
  }

  public final void zzg(int paramInt, boolean paramBoolean)
  {
    if (this.zzblp.get(paramInt) == paramBoolean)
      return;
    this.zzblp.put(paramInt, paramBoolean);
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrj
 * JD-Core Version:    0.6.2
 */