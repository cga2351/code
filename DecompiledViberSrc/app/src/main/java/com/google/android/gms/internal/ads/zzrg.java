package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzrg extends zzrj
{
  private static final int[] zzblb = new int[0];
  private final zzrn zzblc = null;
  private final AtomicReference<zzrh> zzbld = new AtomicReference(new zzrh());

  public zzrg()
  {
    this(null);
  }

  private zzrg(zzrn paramzzrn)
  {
  }

  private static boolean zza(zzlh paramzzlh, String paramString)
  {
    return (paramString != null) && (TextUtils.equals(paramString, zzsy.zzbg(paramzzlh.zzauc)));
  }

  private static int zzf(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == i)
    {
      if (paramInt2 == i)
        i = 0;
      return i;
    }
    if (paramInt2 == i)
      return 1;
    return paramInt1 - paramInt2;
  }

  private static boolean zzf(int paramInt, boolean paramBoolean)
  {
    int i = paramInt & 0x3;
    return (i == 3) || ((paramBoolean) && (i == 2));
  }

  protected final zzrm[] zza(zzlp[] paramArrayOfzzlp, zzrb[] paramArrayOfzzrb, int[][][] paramArrayOfInt)
    throws zzku
  {
    int i = paramArrayOfzzlp.length;
    zzrm[] arrayOfzzrm = new zzrm[i];
    zzrh localzzrh = (zzrh)this.zzbld.get();
    int j = 0;
    int k = 0;
    int i34;
    int i35;
    boolean bool4;
    Object localObject5;
    int i36;
    int i37;
    int i38;
    int i39;
    int i40;
    label140: zzra localzzra4;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label221: int i42;
    int i43;
    int i44;
    int i45;
    label243: zzlh localzzlh3;
    int i47;
    label350: int i48;
    label368: int i49;
    label400: int i50;
    label429: label447: Object localObject6;
    int i46;
    if (j < i)
      if (2 == paramArrayOfzzlp[j].getTrackType())
        if (k == 0)
        {
          zzrb localzzrb4 = paramArrayOfzzrb[j];
          int[][] arrayOfInt7 = paramArrayOfInt[j];
          int i31 = localzzrh.zzbli;
          int i32 = localzzrh.zzblj;
          int i33 = localzzrh.zzblk;
          i34 = localzzrh.viewportWidth;
          i35 = localzzrh.viewportHeight;
          bool4 = localzzrh.zzbln;
          boolean bool5 = localzzrh.zzbll;
          boolean bool6 = localzzrh.zzblm;
          localObject5 = null;
          i36 = 0;
          i37 = 0;
          i38 = -1;
          i39 = -1;
          i40 = 0;
          if (i40 < localzzrb4.length)
          {
            localzzra4 = localzzrb4.zzbg(i40);
            localArrayList1 = new ArrayList(localzzra4.length);
            for (int i41 = 0; i41 < localzzra4.length; i41++)
              localArrayList1.add(Integer.valueOf(i41));
            if ((i34 == 2147483647) || (i35 == 2147483647))
            {
              localArrayList2 = localArrayList1;
              int[] arrayOfInt8 = arrayOfInt7[i40];
              i42 = 0;
              i43 = i39;
              i44 = i38;
              i45 = i37;
              if (i42 >= localzzra4.length)
                break label862;
              if (!zzf(arrayOfInt8[i42], bool6))
                break label1904;
              localzzlh3 = localzzra4.zzbf(i42);
              if ((!localArrayList2.contains(Integer.valueOf(i42))) || ((localzzlh3.width != -1) && (localzzlh3.width > i31)) || ((localzzlh3.height != -1) && (localzzlh3.height > i32)) || ((localzzlh3.zzatm != -1) && (localzzlh3.zzatm > i33)))
                break label806;
              i47 = 1;
              if ((i47 == 0) && (!bool5))
                break label1904;
              if (i47 == 0)
                break label812;
              i48 = 2;
              boolean bool7 = zzf(arrayOfInt8[i42], false);
              if (bool7)
                i48 += 1000;
              if (i48 <= i45)
                break label818;
              i49 = 1;
              if (i48 == i45)
              {
                if (localzzlh3.zzhc() == i43)
                  break label824;
                i50 = zzf(localzzlh3.zzhc(), i43);
                if ((!bool7) || (i47 == 0))
                  break label845;
                if (i50 <= 0)
                  break label839;
                i49 = 1;
              }
              if (i49 == 0)
                break label1904;
              i44 = localzzlh3.zzatm;
              i43 = localzzlh3.zzhc();
              i45 = i48;
              localObject6 = localzzra4;
              i46 = i42;
            }
          }
        }
    while (true)
    {
      i42++;
      localObject5 = localObject6;
      i36 = i46;
      break label243;
      int i51 = 2147483647;
      int i52 = 0;
      zzlh localzzlh4;
      int i55;
      int i56;
      int i61;
      label563: int i62;
      label573: int i57;
      if (i52 < localzzra4.length)
      {
        localzzlh4 = localzzra4.zzbf(i52);
        if ((localzzlh4.width > 0) && (localzzlh4.height > 0))
        {
          i55 = localzzlh4.width;
          i56 = localzzlh4.height;
          if (!bool4)
            break label1893;
          if (i55 <= i56)
            break label692;
          i61 = 1;
          if (i34 <= i35)
            break label698;
          i62 = 1;
          if (i61 == i62)
            break label1893;
          i57 = i34;
        }
      }
      for (int i58 = i35; ; i58 = i34)
      {
        int i60;
        if (i55 * i57 >= i56 * i58)
          i60 = zzsy.zzb(i58 * i56, i55);
        for (Point localPoint = new Point(i58, i60); ; localPoint = new Point(zzsy.zzb(i57 * i55, i56), i57))
        {
          int i59 = localzzlh4.width * localzzlh4.height;
          if ((localzzlh4.width >= (int)(0.98F * localPoint.x)) && (localzzlh4.height >= (int)(0.98F * localPoint.y)) && (i59 < i51))
            i51 = i59;
          i52++;
          break;
          label692: i61 = 0;
          break label563;
          label698: i62 = 0;
          break label573;
        }
        if (i51 != 2147483647)
          for (int i53 = -1 + localArrayList1.size(); i53 >= 0; i53--)
          {
            int i54 = localzzra4.zzbf(((Integer)localArrayList1.get(i53)).intValue()).zzhc();
            if ((i54 == -1) || (i54 > i51))
              localArrayList1.remove(i53);
          }
        localArrayList2 = localArrayList1;
        break label221;
        label806: i47 = 0;
        break label350;
        label812: i48 = 1;
        break label368;
        label818: i49 = 0;
        break label400;
        label824: i50 = zzf(localzzlh3.zzatm, i44);
        break label429;
        label839: i49 = 0;
        break label447;
        label845: if (i50 < 0)
        {
          i49 = 1;
          break label447;
        }
        i49 = 0;
        break label447;
        label862: i40++;
        i37 = i45;
        i38 = i44;
        i39 = i43;
        break label140;
        zzri localzzri4;
        if (localObject5 == null)
        {
          localzzri4 = null;
          label888: arrayOfzzrm[j] = localzzri4;
          if (arrayOfzzrm[j] == null)
            break label936;
        }
        label936: for (k = 1; ; k = 0)
        {
          j++;
          break;
          localzzri4 = new zzri(localObject5, i36);
          break label888;
        }
        int m = 0;
        int n = 0;
        int i1 = 0;
        Object localObject3;
        int i24;
        int i25;
        int i26;
        int i30;
        label1103: int i28;
        label1111: int i29;
        Object localObject4;
        label1144: int i2;
        int i3;
        zzrb localzzrb2;
        int i12;
        int i13;
        int i14;
        int i15;
        label1220: int i17;
        label1249: int i22;
        label1301: int i23;
        label1318: int i20;
        int i19;
        int i18;
        while (true)
          if (i1 < i)
          {
            boolean bool3;
            zzra localzzra3;
            int[] arrayOfInt6;
            int i27;
            switch (paramArrayOfzzlp[i1].getTrackType())
            {
            default:
              paramArrayOfzzlp[i1].getTrackType();
              zzrb localzzrb3 = paramArrayOfzzrb[i1];
              int[][] arrayOfInt5 = paramArrayOfInt[i1];
              bool3 = localzzrh.zzblm;
              localObject3 = null;
              i24 = 0;
              i25 = 0;
              i26 = 0;
              if (i26 < localzzrb3.length)
              {
                localzzra3 = localzzrb3.zzbg(i26);
                arrayOfInt6 = arrayOfInt5[i26];
                i27 = 0;
              }
              break;
            case 2:
            case 1:
              while (true)
                if (i27 < localzzra3.length)
                {
                  if (!zzf(arrayOfInt6[i27], bool3))
                    break label1852;
                  if ((0x1 & localzzra3.zzbf(i27).zzaub) != 0)
                  {
                    i30 = 1;
                    if (i30 == 0)
                      break label1795;
                    i28 = 2;
                    if (zzf(arrayOfInt6[i27], false))
                      i28 += 1000;
                    if (i28 <= i25)
                      break label1852;
                    i29 = i27;
                    localObject4 = localzzra3;
                    i27++;
                    localObject3 = localObject4;
                    i24 = i29;
                    i25 = i28;
                    continue;
                    i2 = n;
                    i3 = m;
                    i1++;
                    n = i2;
                    m = i3;
                    break;
                    if (m != 0)
                      break label1822;
                    localzzrb2 = paramArrayOfzzrb[i1];
                    int[][] arrayOfInt3 = paramArrayOfInt[i1];
                    boolean bool2 = localzzrh.zzblm;
                    i12 = -1;
                    i13 = -1;
                    i14 = 0;
                    i15 = 0;
                    if (i15 < localzzrb2.length)
                    {
                      zzra localzzra2 = localzzrb2.zzbg(i15);
                      int[] arrayOfInt4 = arrayOfInt3[i15];
                      i17 = 0;
                      if (i17 < localzzra2.length)
                      {
                        if (!zzf(arrayOfInt4[i17], bool2))
                          break label1878;
                        zzlh localzzlh2 = localzzra2.zzbf(i17);
                        int i21 = arrayOfInt4[i17];
                        if ((0x1 & localzzlh2.zzaub) != 0)
                        {
                          i22 = 1;
                          if (!zza(localzzlh2, null))
                            break label1382;
                          if (i22 == 0)
                            break label1376;
                          i23 = 4;
                          if (zzf(i21, false))
                            i23 += 1000;
                          if (i23 <= i14)
                            break label1878;
                          i20 = i23;
                          i19 = i17;
                          i18 = i15;
                        }
                      }
                    }
                  }
                }
            case 3:
            }
          }
        while (true)
        {
          i17++;
          i14 = i20;
          i13 = i19;
          i12 = i18;
          break label1249;
          i22 = 0;
          break label1301;
          label1376: i23 = 3;
          break label1318;
          label1382: if (i22 != 0)
          {
            i23 = 2;
            break label1318;
          }
          i23 = 1;
          break label1318;
          i15++;
          break label1220;
          zzri localzzri2;
          if (i12 == -1)
          {
            localzzri2 = null;
            label1414: arrayOfzzrm[i1] = localzzri2;
            if (arrayOfzzrm[i1] == null)
              break label1464;
          }
          label1464: for (int i16 = 1; ; i16 = 0)
          {
            i3 = i16;
            i2 = n;
            break;
            localzzri2 = new zzri(localzzrb2.zzbg(i12), i13);
            break label1414;
          }
          Object localObject1;
          int i4;
          int i5;
          label1506: int i7;
          label1535: zzlh localzzlh1;
          int i9;
          label1580: int i10;
          label1593: int i11;
          label1611: Object localObject2;
          int i8;
          if (n == 0)
          {
            zzrb localzzrb1 = paramArrayOfzzrb[i1];
            int[][] arrayOfInt1 = paramArrayOfInt[i1];
            boolean bool1 = localzzrh.zzblm;
            localObject1 = null;
            i4 = 0;
            i5 = 0;
            int i6 = 0;
            if (i5 < localzzrb1.length)
            {
              zzra localzzra1 = localzzrb1.zzbg(i5);
              int[] arrayOfInt2 = arrayOfInt1[i5];
              i7 = 0;
              if (i7 < localzzra1.length)
              {
                if (!zzf(arrayOfInt2[i7], bool1))
                  break label1867;
                localzzlh1 = localzzra1.zzbf(i7);
                if ((0x1 & localzzlh1.zzaub) != 0)
                {
                  i9 = 1;
                  if ((0x2 & localzzlh1.zzaub) == 0)
                    break label1668;
                  i10 = 1;
                  if (!zza(localzzlh1, null))
                    break label1691;
                  if (i9 == 0)
                    break label1674;
                  i11 = 6;
                  if (zzf(arrayOfInt2[i7], false))
                    i11 += 1000;
                  if (i11 <= i6)
                    break label1867;
                  i6 = i11;
                  localObject2 = localzzra1;
                  i8 = i7;
                }
              }
            }
          }
          while (true)
          {
            i7++;
            localObject1 = localObject2;
            i4 = i8;
            break label1535;
            i9 = 0;
            break label1580;
            label1668: i10 = 0;
            break label1593;
            label1674: if (i10 == 0)
            {
              i11 = 5;
              break label1611;
            }
            i11 = 4;
            break label1611;
            label1691: if (i9 != 0)
            {
              i11 = 3;
              break label1611;
            }
            if (i10 != 0)
            {
              if (zza(localzzlh1, null))
              {
                i11 = 2;
                break label1611;
              }
              i11 = 1;
              break label1611;
              i5++;
              break label1506;
              zzri localzzri1;
              if (localObject1 == null)
              {
                localzzri1 = null;
                label1742: arrayOfzzrm[i1] = localzzri1;
                if (arrayOfzzrm[i1] == null)
                  break label1783;
              }
              label1783: for (i2 = 1; ; i2 = 0)
              {
                i3 = m;
                break;
                localzzri1 = new zzri(localObject1, i4);
                break label1742;
              }
              i30 = 0;
              break label1103;
              label1795: i28 = 1;
              break label1111;
              i26++;
              break;
              if (localObject3 == null);
              for (zzri localzzri3 = null; ; localzzri3 = new zzri(localObject3, i24))
              {
                arrayOfzzrm[i1] = localzzri3;
                label1822: i2 = n;
                i3 = m;
                break;
              }
              return arrayOfzzrm;
              label1852: i28 = i25;
              i29 = i24;
              localObject4 = localObject3;
              break label1144;
            }
            label1867: i8 = i4;
            localObject2 = localObject1;
          }
          label1878: i18 = i12;
          i19 = i13;
          i20 = i14;
        }
        label1893: i57 = i35;
      }
      label1904: i46 = i36;
      localObject6 = localObject5;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrg
 * JD-Core Version:    0.6.2
 */