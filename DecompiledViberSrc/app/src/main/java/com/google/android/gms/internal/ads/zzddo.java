package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public final class zzddo
  implements zzdcb<zzdbx>
{
  private static final Logger logger = Logger.getLogger(zzddo.class.getName());

  public final Class<zzdbx> zzanr()
  {
    return zzdbx.class;
  }

  static final class zza
    implements zzdbx
  {
    private final zzdbz<zzdbx> zzgqa;
    private final byte[] zzgqj = { 0 };

    private zza(zzdbz<zzdbx> paramzzdbz)
    {
      this.zzgqa = paramzzdbz;
    }

    public final byte[] zzk(byte[] paramArrayOfByte)
      throws GeneralSecurityException
    {
      if (this.zzgqa.zzanu().zzanw().equals(zzdhl.zzgvs))
      {
        byte[][] arrayOfByte2 = new byte[2][];
        arrayOfByte2[0] = this.zzgqa.zzanu().zzanx();
        zzdbx localzzdbx = (zzdbx)this.zzgqa.zzanu().zzanv();
        byte[][] arrayOfByte3 = new byte[2][];
        arrayOfByte3[0] = paramArrayOfByte;
        arrayOfByte3[1] = this.zzgqj;
        arrayOfByte2[1] = localzzdbx.zzk(zzdjr.zza(arrayOfByte3));
        return zzdjr.zza(arrayOfByte2);
      }
      byte[][] arrayOfByte1 = new byte[2][];
      arrayOfByte1[0] = this.zzgqa.zzanu().zzanx();
      arrayOfByte1[1] = ((zzdbx)this.zzgqa.zzanu().zzanv()).zzk(paramArrayOfByte);
      return zzdjr.zza(arrayOfByte1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddo
 * JD-Core Version:    0.6.2
 */