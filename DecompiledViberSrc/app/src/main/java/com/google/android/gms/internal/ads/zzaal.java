package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

@zzare
public final class zzaal
  implements MuteThisAdReason
{
  private final String description;
  private zzaai zzcir;

  public zzaal(zzaai paramzzaai)
  {
    this.zzcir = paramzzaai;
    try
    {
      String str2 = paramzzaai.getDescription();
      str1 = str2;
      this.description = str1;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zzc("", localRemoteException);
        String str1 = null;
      }
    }
  }

  public final String getDescription()
  {
    return this.description;
  }

  public final zzaai zzpu()
  {
    return this.zzcir;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaal
 * JD-Core Version:    0.6.2
 */