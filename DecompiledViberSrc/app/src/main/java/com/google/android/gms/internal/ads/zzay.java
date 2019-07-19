package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzay
  implements zzba
{
  private static Logger zzcn = Logger.getLogger(zzay.class.getName());
  private ThreadLocal<ByteBuffer> zzco = new zzaz(this);

  public final zzbd zza(zzdsv paramzzdsv, zzbe paramzzbe)
    throws IOException
  {
    long l1 = paramzzdsv.position();
    ((ByteBuffer)this.zzco.get()).rewind().limit(8);
    int i;
    do
    {
      i = paramzzdsv.read((ByteBuffer)this.zzco.get());
      if (i == 8)
        break;
    }
    while (i >= 0);
    paramzzdsv.zzff(l1);
    throw new EOFException();
    ((ByteBuffer)this.zzco.get()).rewind();
    long l2 = zzbc.zza((ByteBuffer)this.zzco.get());
    if ((l2 < 8L) && (l2 > 1L))
    {
      zzcn.logp(Level.SEVERE, "com.coremedia.iso.AbstractBoxParser", "parseBox", 80 + "Plausibility check failed: size < 8 (size = " + l2 + "). Stop parsing!");
      return null;
    }
    String str1 = zzbc.zzf((ByteBuffer)this.zzco.get());
    long l3;
    if (l2 == 1L)
    {
      ((ByteBuffer)this.zzco.get()).limit(16);
      paramzzdsv.read((ByteBuffer)this.zzco.get());
      ((ByteBuffer)this.zzco.get()).position(8);
      l3 = zzbc.zzc((ByteBuffer)this.zzco.get()) - 16L;
    }
    byte[] arrayOfByte2;
    long l4;
    while ("uuid".equals(str1))
    {
      ((ByteBuffer)this.zzco.get()).limit(16 + ((ByteBuffer)this.zzco.get()).limit());
      paramzzdsv.read((ByteBuffer)this.zzco.get());
      arrayOfByte2 = new byte[16];
      int j = -16 + ((ByteBuffer)this.zzco.get()).position();
      while (true)
        if (j < ((ByteBuffer)this.zzco.get()).position())
        {
          arrayOfByte2[(j - (-16 + ((ByteBuffer)this.zzco.get()).position()))] = ((ByteBuffer)this.zzco.get()).get(j);
          j++;
          continue;
          if (l2 == 0L)
          {
            l3 = paramzzdsv.size() - paramzzdsv.position();
            break;
          }
          l3 = l2 - 8L;
          break;
        }
      l4 = l3 - 16L;
    }
    for (byte[] arrayOfByte1 = arrayOfByte2; ; arrayOfByte1 = null)
    {
      if ((paramzzbe instanceof zzbd));
      for (String str2 = ((zzbd)paramzzbe).getType(); ; str2 = "")
      {
        zzbd localzzbd = zza(str1, arrayOfByte1, str2);
        localzzbd.zza(paramzzbe);
        ((ByteBuffer)this.zzco.get()).rewind();
        localzzbd.zza(paramzzdsv, (ByteBuffer)this.zzco.get(), l4, this);
        return localzzbd;
      }
      l4 = l3;
    }
  }

  public abstract zzbd zza(String paramString1, byte[] paramArrayOfByte, String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzay
 * JD-Core Version:    0.6.2
 */