package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzdmi<MessageType extends zzdmh<MessageType, BuilderType>, BuilderType extends zzdmi<MessageType, BuilderType>>
  implements zzdpk
{
  protected abstract BuilderType zza(MessageType paramMessageType);

  public abstract BuilderType zza(zzdnc paramzzdnc, zzdnn paramzzdnn)
    throws IOException;

  public BuilderType zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzdnn paramzzdnn)
    throws zzdoj
  {
    try
    {
      zzdnc localzzdnc = zzdnc.zzc(paramArrayOfByte, 0, paramInt2, false);
      zza(localzzdnc, paramzzdnn);
      localzzdnc.zzfp(0);
      return this;
    }
    catch (zzdoj localzzdoj)
    {
      throw localzzdoj;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      throw new RuntimeException(60 + String.valueOf(str).length() + String.valueOf("byte array").length() + "Reading " + str + " from a " + "byte array" + " threw an IOException (should never happen).", localIOException);
    }
  }

  public abstract BuilderType zzavh();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmi
 * JD-Core Version:    0.6.2
 */