package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzci
{
  private static boolean zznj = false;
  private static MessageDigest zznk = null;
  private static final Object zznl = new Object();
  private static final Object zznm = new Object();
  static CountDownLatch zznn = new CountDownLatch(1);

  private static zzbp.zza zza(zzbp.zza.zzd paramzzd)
  {
    zzbp.zza.zza localzza = zzbp.zza.zzam();
    localzza.zzau(paramzzd.zzac());
    return (zzbp.zza)localzza.zzaya();
  }

  static String zza(String paramString1, String paramString2, boolean paramBoolean)
  {
    byte[] arrayOfByte = zzb(paramString1, paramString2, true);
    if (arrayOfByte != null)
      return zzcg.zza(arrayOfByte, true);
    return Integer.toString(7);
  }

  private static Vector<byte[]> zza(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      return null;
    int i = (-1 + (255 + paramArrayOfByte.length)) / 255;
    Vector localVector = new Vector();
    int j = 0;
    while (true)
    {
      int k;
      if (j < i)
        k = j * 255;
      try
      {
        if (paramArrayOfByte.length - k > 255);
        for (int m = k + 255; ; m = paramArrayOfByte.length)
        {
          localVector.add(Arrays.copyOfRange(paramArrayOfByte, k, m));
          j++;
          break;
        }
        return localVector;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
      }
    }
    return null;
  }

  private static byte[] zza(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    int i;
    byte[] arrayOfByte4;
    if (paramBoolean)
    {
      i = 239;
      if (paramArrayOfByte.length > i)
        paramArrayOfByte = zza(zzbp.zza.zzd.zziq).toByteArray();
      if (paramArrayOfByte.length >= i)
        break label169;
      arrayOfByte4 = new byte[i - paramArrayOfByte.length];
      new SecureRandom().nextBytes(arrayOfByte4);
    }
    byte[] arrayOfByte2;
    label169: for (byte[] arrayOfByte1 = ByteBuffer.allocate(i + 1).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).put(arrayOfByte4).array(); ; arrayOfByte1 = ByteBuffer.allocate(i + 1).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).array())
    {
      if (paramBoolean)
      {
        byte[] arrayOfByte3 = zzb(arrayOfByte1);
        arrayOfByte1 = ByteBuffer.allocate(256).put(arrayOfByte3).put(arrayOfByte1).array();
      }
      arrayOfByte2 = new byte[256];
      zzcn[] arrayOfzzcn = new zzcl().zzvb;
      int j = arrayOfzzcn.length;
      for (int k = 0; k < j; k++)
        arrayOfzzcn[k].zza(arrayOfByte1, arrayOfByte2);
      i = 255;
      break;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() > 32)
        paramString = paramString.substring(0, 32);
      new zzdmg(paramString.getBytes("UTF-8")).zzy(arrayOfByte2);
    }
    return arrayOfByte2;
  }

  private static byte[] zzb(String paramString1, String paramString2, boolean paramBoolean)
  {
    zzbp.zzc.zza localzza = zzbp.zzc.zzaw();
    try
    {
      byte[] arrayOfByte1;
      if (paramString1.length() < 3)
      {
        arrayOfByte1 = paramString1.getBytes("ISO-8859-1");
        localzza.zzc(zzdmq.zzz(arrayOfByte1));
        if (paramString2.length() >= 3)
          break label80;
      }
      label80: byte[] arrayOfByte2;
      for (Object localObject = paramString2.getBytes("ISO-8859-1"); ; localObject = arrayOfByte2)
      {
        localzza.zzd(zzdmq.zzz((byte[])localObject));
        return ((zzbp.zzc)localzza.zzaya()).toByteArray();
        arrayOfByte1 = zzcg.zza(paramString1, true);
        break;
        arrayOfByte2 = zzcg.zza(paramString2, true);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return null;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      label96: break label96;
    }
  }

  public static byte[] zzb(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest;
    synchronized (zznl)
    {
      localMessageDigest = zzcc();
      if (localMessageDigest == null)
        throw new NoSuchAlgorithmException("Cannot compute hash");
    }
    localMessageDigest.reset();
    localMessageDigest.update(paramArrayOfByte);
    byte[] arrayOfByte = zznk.digest();
    return arrayOfByte;
  }

  static void zzcb()
  {
    synchronized (zznm)
    {
      if (!zznj)
      {
        zznj = true;
        new Thread(new zzck(null)).start();
      }
      return;
    }
  }

  private static MessageDigest zzcc()
  {
    zzcb();
    try
    {
      boolean bool2 = zznn.await(2L, TimeUnit.SECONDS);
      bool1 = bool2;
      if (!bool1);
      while (zznk == null)
        return null;
      return zznk;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  static String zzj(zzbp.zza paramzza, String paramString)
    throws GeneralSecurityException, UnsupportedEncodingException
  {
    byte[] arrayOfByte1 = paramzza.toByteArray();
    zzaci localzzaci = zzact.zzcrn;
    byte[] arrayOfByte3;
    byte[] arrayOfByte2;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      if (zzed.zzya == null)
        throw new GeneralSecurityException();
      if (paramString != null)
      {
        arrayOfByte3 = paramString.getBytes();
        byte[] arrayOfByte4 = zzed.zzya.zzc(arrayOfByte1, arrayOfByte3);
        arrayOfByte2 = ((zzbp.zzg)zzbp.zzg.zzbk().zzn(zzdmq.zzz(arrayOfByte4)).zzb(zzbw.zzkm).zzaya()).toByteArray();
      }
    }
    while (true)
    {
      return zzcg.zza(arrayOfByte2, true);
      arrayOfByte3 = new byte[0];
      break;
      Vector localVector = zza(arrayOfByte1, 255);
      if ((localVector == null) || (localVector.size() == 0))
      {
        arrayOfByte2 = zza(zza(zzbp.zza.zzd.zziq).toByteArray(), paramString, true);
      }
      else
      {
        zzbp.zzg.zza localzza = zzbp.zzg.zzbk();
        Iterator localIterator = localVector.iterator();
        while (localIterator.hasNext())
          localzza.zzn(zzdmq.zzz(zza((byte[])localIterator.next(), paramString, false)));
        localzza.zzo(zzdmq.zzz(zzb(arrayOfByte1)));
        arrayOfByte2 = ((zzbp.zzg)localzza.zzaya()).toByteArray();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzci
 * JD-Core Version:    0.6.2
 */