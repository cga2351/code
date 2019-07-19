package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Arrays;

public abstract class d extends h
{
  private a a;

  private static int a(af[] paramArrayOfaf, TrackGroup paramTrackGroup)
    throws com.google.android.exoplayer2.i
  {
    int i = paramArrayOfaf.length;
    int j = 0;
    int k = i;
    int m = 0;
    int n;
    label27: int i3;
    int i2;
    if (m < paramArrayOfaf.length)
    {
      af localaf = paramArrayOfaf[m];
      n = 0;
      if (n < paramTrackGroup.length)
      {
        int i1 = 0x7 & localaf.a(paramTrackGroup.getFormat(n));
        if (i1 <= j)
          break label99;
        if (i1 == 4)
          return m;
        i3 = i1;
        i2 = m;
      }
    }
    while (true)
    {
      n++;
      j = i3;
      k = i2;
      break label27;
      m++;
      break;
      return k;
      label99: i2 = k;
      i3 = j;
    }
  }

  private static int[] a(af paramaf, TrackGroup paramTrackGroup)
    throws com.google.android.exoplayer2.i
  {
    int[] arrayOfInt = new int[paramTrackGroup.length];
    for (int i = 0; i < paramTrackGroup.length; i++)
      arrayOfInt[i] = paramaf.a(paramTrackGroup.getFormat(i));
    return arrayOfInt;
  }

  private static int[] a(af[] paramArrayOfaf)
    throws com.google.android.exoplayer2.i
  {
    int[] arrayOfInt = new int[paramArrayOfaf.length];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = paramArrayOfaf[i].m();
    return arrayOfInt;
  }

  protected abstract Pair<com.google.android.exoplayer2.ag[], e[]> a(a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1)
    throws com.google.android.exoplayer2.i;

  public final i a(af[] paramArrayOfaf, TrackGroupArray paramTrackGroupArray)
    throws com.google.android.exoplayer2.i
  {
    int i = 0;
    int[] arrayOfInt1 = new int[1 + paramArrayOfaf.length];
    TrackGroup[][] arrayOfTrackGroup; = new TrackGroup[1 + paramArrayOfaf.length][];
    int[][][] arrayOfInt = new int[1 + paramArrayOfaf.length][][];
    for (int j = 0; j < arrayOfTrackGroup;.length; j++)
    {
      arrayOfTrackGroup;[j] = new TrackGroup[paramTrackGroupArray.length];
      arrayOfInt[j] = new int[paramTrackGroupArray.length][];
    }
    int[] arrayOfInt2 = a(paramArrayOfaf);
    int k = 0;
    if (k < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(k);
      int i1 = a(paramArrayOfaf, localTrackGroup);
      if (i1 == paramArrayOfaf.length);
      for (int[] arrayOfInt4 = new int[localTrackGroup.length]; ; arrayOfInt4 = a(paramArrayOfaf[i1], localTrackGroup))
      {
        int i2 = arrayOfInt1[i1];
        arrayOfTrackGroup;[i1][i2] = localTrackGroup;
        arrayOfInt[i1][i2] = arrayOfInt4;
        arrayOfInt1[i1] = (1 + arrayOfInt1[i1]);
        k++;
        break;
      }
    }
    TrackGroupArray[] arrayOfTrackGroupArray = new TrackGroupArray[paramArrayOfaf.length];
    int[] arrayOfInt3 = new int[paramArrayOfaf.length];
    while (i < paramArrayOfaf.length)
    {
      int n = arrayOfInt1[i];
      arrayOfTrackGroupArray[i] = new TrackGroupArray((TrackGroup[])com.google.android.exoplayer2.g.ag.a(arrayOfTrackGroup;[i], n));
      arrayOfInt[i] = ((int[][])com.google.android.exoplayer2.g.ag.a(arrayOfInt[i], n));
      arrayOfInt3[i] = paramArrayOfaf[i].a();
      i++;
    }
    int m = arrayOfInt1[paramArrayOfaf.length];
    a locala = new a(arrayOfInt3, arrayOfTrackGroupArray, arrayOfInt2, arrayOfInt, new TrackGroupArray((TrackGroup[])com.google.android.exoplayer2.g.ag.a(arrayOfTrackGroup;[paramArrayOfaf.length], m)));
    Pair localPair = a(locala, arrayOfInt, arrayOfInt2);
    return new i((com.google.android.exoplayer2.ag[])localPair.first, (e[])localPair.second, locala);
  }

  public final void a(Object paramObject)
  {
    this.a = ((a)paramObject);
  }

  public final a b()
  {
    return this.a;
  }

  public static final class a
  {

    @Deprecated
    public final int a;
    private final int b;
    private final int[] c;
    private final TrackGroupArray[] d;
    private final int[] e;
    private final int[][][] f;
    private final TrackGroupArray g;

    a(int[] paramArrayOfInt1, TrackGroupArray[] paramArrayOfTrackGroupArray, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray)
    {
      this.c = paramArrayOfInt1;
      this.d = paramArrayOfTrackGroupArray;
      this.f = paramArrayOfInt;
      this.e = paramArrayOfInt2;
      this.g = paramTrackGroupArray;
      this.b = paramArrayOfInt1.length;
      this.a = this.b;
    }

    public int a()
    {
      return this.b;
    }

    public int a(int paramInt)
    {
      return this.c[paramInt];
    }

    public int a(int paramInt1, int paramInt2, int paramInt3)
    {
      return 0x7 & this.f[paramInt1][paramInt2][paramInt3];
    }

    public int a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = 0;
      int j = this.d[paramInt1].get(paramInt2).length;
      int[] arrayOfInt = new int[j];
      for (int k = 0; k < j; k++)
      {
        int m = a(paramInt1, paramInt2, k);
        if ((m == 4) || ((paramBoolean) && (m == 3)))
        {
          int n = i + 1;
          arrayOfInt[i] = k;
          i = n;
        }
      }
      return a(paramInt1, paramInt2, Arrays.copyOf(arrayOfInt, i));
    }

    public int a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      int k = 16;
      int m = 0;
      while (i < paramArrayOfInt.length)
      {
        int n = paramArrayOfInt[i];
        Object localObject2 = this.d[paramInt1].get(paramInt2).getFormat(n).sampleMimeType;
        int i1 = m + 1;
        int i4;
        if (m == 0)
        {
          i4 = j;
          k = Math.min(k, 0x18 & this.f[paramInt1][paramInt2][i]);
          i++;
          m = i1;
          j = i4;
          localObject1 = localObject2;
        }
        else
        {
          if (!com.google.android.exoplayer2.g.ag.a(localObject1, localObject2));
          for (int i2 = 1; ; i2 = 0)
          {
            int i3 = i2 | j;
            Object localObject3 = localObject1;
            i4 = i3;
            localObject2 = localObject3;
            break;
          }
        }
      }
      if (j != 0)
        k = Math.min(k, this.e[paramInt1]);
      return k;
    }

    public TrackGroupArray b(int paramInt)
    {
      return this.d[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.d
 * JD-Core Version:    0.6.2
 */