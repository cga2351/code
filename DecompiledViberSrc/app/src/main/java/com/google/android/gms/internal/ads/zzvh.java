package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzvh extends zzuy
{
  private MessageDigest zzbwd;
  private final int zzbwf;
  private final int zzbwg;

  public zzvh(int paramInt)
  {
    int i = paramInt / 8;
    if (paramInt % 8 > 0)
      i++;
    this.zzbwf = i;
    this.zzbwg = paramInt;
  }

  public final byte[] zzbl(String paramString)
  {
    int i = 0;
    synchronized (this.mLock)
    {
      this.zzbwd = zznf();
      if (this.zzbwd == null)
      {
        byte[] arrayOfByte1 = new byte[0];
        return arrayOfByte1;
      }
      this.zzbwd.reset();
      this.zzbwd.update(paramString.getBytes(Charset.forName("UTF-8")));
      byte[] arrayOfByte2 = this.zzbwd.digest();
      if (arrayOfByte2.length > this.zzbwf);
      byte[] arrayOfByte3;
      long l1;
      for (int j = this.zzbwf; ; j = arrayOfByte2.length)
      {
        arrayOfByte3 = new byte[j];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte3.length);
        if (this.zzbwg % 8 <= 0)
          break label213;
        l1 = 0L;
        while (i < arrayOfByte3.length)
        {
          if (i > 0)
            l1 <<= 8;
          l1 += (0xFF & arrayOfByte3[i]);
          i++;
        }
      }
      long l2 = l1 >>> 8 - this.zzbwg % 8;
      for (int k = -1 + this.zzbwf; k >= 0; k--)
      {
        arrayOfByte3[k] = ((byte)(int)(0xFF & l2));
        l2 >>>= 8;
      }
      label213: return arrayOfByte3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvh
 * JD-Core Version:    0.6.2
 */