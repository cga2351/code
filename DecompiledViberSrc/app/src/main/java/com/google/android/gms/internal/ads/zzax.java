package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class zzax extends zzr<String>
{
  private final Object mLock = new Object();
  private zzaa<String> zzcm;

  public zzax(int paramInt, String paramString, zzaa<String> paramzzaa, zzz paramzzz)
  {
    super(paramInt, paramString, paramzzz);
    this.zzcm = paramzzaa;
  }

  protected final zzy<String> zza(zzp paramzzp)
  {
    try
    {
      byte[] arrayOfByte = paramzzp.data;
      String str2 = (String)paramzzp.zzab.get("Content-Type");
      int i;
      String[] arrayOfString2;
      if (str2 != null)
      {
        String[] arrayOfString1 = str2.split(";", 0);
        i = 1;
        if (i < arrayOfString1.length)
        {
          arrayOfString2 = arrayOfString1[i].trim().split("=", 0);
          if ((arrayOfString2.length != 2) || (!arrayOfString2[0].equals("charset")));
        }
      }
      for (String str3 = arrayOfString2[1]; ; str3 = "ISO-8859-1")
      {
        String str4 = new String(arrayOfByte, str3);
        str1 = str4;
        return zzy.zza(str1, zzaq.zzb(paramzzp));
        i++;
        break;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str1 = new String(paramzzp.data);
    }
  }

  protected void zzh(String paramString)
  {
    synchronized (this.mLock)
    {
      zzaa localzzaa = this.zzcm;
      if (localzzaa != null)
        localzzaa.zzb(paramString);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzax
 * JD-Core Version:    0.6.2
 */