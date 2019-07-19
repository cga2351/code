package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzddm
  implements zzdbj<zzdbx>
{
  public final zzdcb<zzdbx> zzanp()
  {
    return new zzddo();
  }

  public final zzdbr<zzdbx> zzb(String paramString1, String paramString2, int paramInt)
    throws GeneralSecurityException
  {
    int i = -1;
    String str = paramString2.toLowerCase();
    switch (str.hashCode())
    {
    default:
    case 107855:
    }
    label32: for (int j = i; ; j = 0)
      switch (j)
      {
      default:
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[] { paramString2 }));
        if (!str.equals("mac"))
          break label32;
      case 0:
      }
    switch (paramString1.hashCode())
    {
    default:
    case 836622442:
    }
    while (true)
      switch (i)
      {
      default:
        throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", new Object[] { paramString1 }));
        if (paramString1.equals("type.googleapis.com/google.crypto.tink.HmacKey"))
          i = 0;
        break;
      case 0:
      }
    zzddk localzzddk = new zzddk();
    if (paramInt > 0)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", arrayOfObject));
    }
    return localzzddk;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddm
 * JD-Core Version:    0.6.2
 */