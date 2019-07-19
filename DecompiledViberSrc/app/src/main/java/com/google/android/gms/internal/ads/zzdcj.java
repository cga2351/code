package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public class zzdcj
  implements zzdcb<zzdbi>
{
  private static final Logger logger = Logger.getLogger(zzdcj.class.getName());

  public final Class<zzdbi> zzanr()
  {
    return zzdbi.class;
  }

  static final class zza
    implements zzdbi
  {
    private final zzdbz<zzdbi> zzgpw;

    private zza(zzdbz<zzdbi> paramzzdbz)
    {
      this.zzgpw = paramzzdbz;
    }

    public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      throws GeneralSecurityException
    {
      byte[][] arrayOfByte = new byte[2][];
      arrayOfByte[0] = this.zzgpw.zzanu().zzanx();
      arrayOfByte[1] = ((zzdbi)this.zzgpw.zzanu().zzanv()).zzc(paramArrayOfByte1, paramArrayOfByte2);
      return zzdjr.zza(arrayOfByte);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdcj
 * JD-Core Version:    0.6.2
 */