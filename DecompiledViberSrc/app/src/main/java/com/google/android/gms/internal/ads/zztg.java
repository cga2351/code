package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zztg
{
  public final List<byte[]> zzafw;
  public final int zzamf;

  private zztg(List<byte[]> paramList, int paramInt)
  {
    this.zzafw = paramList;
    this.zzamf = paramInt;
  }

  public static zztg zzh(zzst paramzzst)
    throws zzlm
  {
    while (true)
    {
      int m;
      int i3;
      int i5;
      int i8;
      Object localObject;
      try
      {
        paramzzst.zzac(21);
        int i = 0x3 & paramzzst.readUnsignedByte();
        int j = paramzzst.readUnsignedByte();
        int k = paramzzst.getPosition();
        m = 0;
        n = 0;
        if (m < j)
        {
          paramzzst.zzac(1);
          int i1 = paramzzst.readUnsignedShort();
          int i2 = 0;
          i3 = n;
          if (i2 < i1)
          {
            int i4 = paramzzst.readUnsignedShort();
            i3 += i4 + 4;
            paramzzst.zzac(i4);
            i2++;
            continue;
          }
        }
        else
        {
          paramzzst.setPosition(k);
          byte[] arrayOfByte = new byte[n];
          i5 = 0;
          i6 = 0;
          if (i5 >= j)
            break label262;
          paramzzst.zzac(1);
          int i7 = paramzzst.readUnsignedShort();
          i8 = i6;
          int i9 = 0;
          if (i9 >= i7)
            break label252;
          int i10 = paramzzst.readUnsignedShort();
          System.arraycopy(zzsq.zzaqt, 0, arrayOfByte, i8, zzsq.zzaqt.length);
          int i11 = i8 + zzsq.zzaqt.length;
          System.arraycopy(paramzzst.data, paramzzst.getPosition(), arrayOfByte, i11, i10);
          i8 = i11 + i10;
          paramzzst.zzac(i10);
          i9++;
          continue;
          return new zztg((List)localObject, i + 1);
          List localList = Collections.singletonList(arrayOfByte);
          localObject = localList;
          continue;
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new zzlm("Error parsing HEVC config", localArrayIndexOutOfBoundsException);
      }
      m++;
      int n = i3;
      continue;
      label252: i5++;
      int i6 = i8;
      continue;
      label262: if (n == 0)
        localObject = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztg
 * JD-Core Version:    0.6.2
 */