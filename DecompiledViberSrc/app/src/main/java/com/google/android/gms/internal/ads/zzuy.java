package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public abstract class zzuy
{
  private static MessageDigest zzbvw = null;
  protected Object mLock = new Object();

  abstract byte[] zzbl(String paramString);

  protected final MessageDigest zznf()
  {
    while (true)
    {
      int i;
      synchronized (this.mLock)
      {
        if (zzbvw != null)
        {
          MessageDigest localMessageDigest2 = zzbvw;
          return localMessageDigest2;
        }
        i = 0;
        if (i >= 2);
      }
      try
      {
        zzbvw = MessageDigest.getInstance("MD5");
        label38: i++;
        continue;
        MessageDigest localMessageDigest1 = zzbvw;
        return localMessageDigest1;
        localObject2 = finally;
        throw localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label38;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzuy
 * JD-Core Version:    0.6.2
 */