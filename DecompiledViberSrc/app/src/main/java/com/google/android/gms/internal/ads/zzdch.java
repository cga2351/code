package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdch
  implements zzdbj<zzdbi>
{
  public final zzdcb<zzdbi> zzanp()
  {
    return new zzdcj();
  }

  public final zzdbr<zzdbi> zzb(String paramString1, String paramString2, int paramInt)
    throws GeneralSecurityException
  {
    int i = -1;
    String str = paramString2.toLowerCase();
    switch (str.hashCode())
    {
    default:
    case 2989895:
    }
    label32: for (int j = i; ; j = 0)
      switch (j)
      {
      default:
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[] { paramString2 }));
        if (!str.equals("aead"))
          break label32;
      case 0:
      }
    switch (paramString1.hashCode())
    {
    default:
    case 1215885937:
    case 1797113348:
    case 1855890991:
    case 360753376:
    case 1469984853:
    case 2079211877:
    case 245054116:
    }
    while (true)
      switch (i)
      {
      default:
        throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[] { paramString1 }));
        if (paramString1.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey"))
        {
          i = 0;
          continue;
          if (paramString1.equals("type.googleapis.com/google.crypto.tink.AesEaxKey"))
          {
            i = 1;
            continue;
            if (paramString1.equals("type.googleapis.com/google.crypto.tink.AesGcmKey"))
            {
              i = 2;
              continue;
              if (paramString1.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key"))
              {
                i = 3;
                continue;
                if (paramString1.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey"))
                {
                  i = 4;
                  continue;
                  if (paramString1.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey"))
                  {
                    i = 5;
                    continue;
                    if (paramString1.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key"))
                      i = 6;
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    Object localObject = new zzdcl();
    while (((zzdbr)localObject).getVersion() < paramInt)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", arrayOfObject));
      localObject = new zzdcn();
      continue;
      localObject = new zzdco();
      continue;
      localObject = new zzdcp();
      continue;
      localObject = new zzdcq();
      continue;
      localObject = new zzdcs();
      continue;
      localObject = new zzdct();
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdch
 * JD-Core Version:    0.6.2
 */