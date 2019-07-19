package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

final class zzdcg
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");

  public static zzdhb zzc(zzdgz paramzzdgz)
  {
    zzdhb.zza localzza = zzdhb.zzass().zzev(paramzzdgz.zzash());
    Iterator localIterator = paramzzdgz.zzasi().iterator();
    while (localIterator.hasNext())
    {
      zzdgz.zzb localzzb = (zzdgz.zzb)localIterator.next();
      localzza.zzb((zzdhb.zzb)zzdhb.zzb.zzasu().zzgq(localzzb.zzasn().zzart()).zzc(localzzb.zzaso()).zzc(localzzb.zzanw()).zzew(localzzb.zzasp()).zzaya());
    }
    return (zzdhb)localzza.zzaya();
  }

  public static void zzd(zzdgz paramzzdgz)
    throws GeneralSecurityException
  {
    int i = paramzzdgz.zzash();
    Iterator localIterator = paramzzdgz.zzasi().iterator();
    int j = 0;
    int k = 1;
    int m = 0;
    while (localIterator.hasNext())
    {
      zzdgz.zzb localzzb = (zzdgz.zzb)localIterator.next();
      if (localzzb.zzaso() != zzdgt.zzgun)
      {
        j++;
        if (!localzzb.zzasm())
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(localzzb.zzasp());
          throw new GeneralSecurityException(String.format("key %d has no key data", arrayOfObject3));
        }
        if (localzzb.zzanw() == zzdhl.zzgvq)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(localzzb.zzasp());
          throw new GeneralSecurityException(String.format("key %d has unknown prefix", arrayOfObject2));
        }
        if (localzzb.zzaso() == zzdgt.zzguk)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(localzzb.zzasp());
          throw new GeneralSecurityException(String.format("key %d has unknown status", arrayOfObject1));
        }
        if ((localzzb.zzaso() == zzdgt.zzgul) && (localzzb.zzasp() == i))
        {
          if (m != 0)
            throw new GeneralSecurityException("keyset contains multiple primary keys");
          m = 1;
        }
        if (localzzb.zzasn().zzarv() == zzdgq.zzb.zzgug)
          break label283;
      }
    }
    label283: for (int n = 0; ; n = k)
    {
      k = n;
      break;
      if (j == 0)
        throw new GeneralSecurityException("empty keyset");
      if ((m == 0) && (k == 0))
        throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
      return;
    }
  }

  public static byte[] zzg(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdcg
 * JD-Core Version:    0.6.2
 */