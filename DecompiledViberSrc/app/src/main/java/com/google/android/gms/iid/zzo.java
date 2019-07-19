package com.google.android.gms.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

final class zzo
{
  private final KeyPair zzcb;
  private final long zzcc;

  @VisibleForTesting
  zzo(KeyPair paramKeyPair, long paramLong)
  {
    this.zzcb = paramKeyPair;
    this.zzcc = paramLong;
  }

  private final String zzq()
  {
    return Base64.encodeToString(this.zzcb.getPublic().getEncoded(), 11);
  }

  private final String zzr()
  {
    return Base64.encodeToString(this.zzcb.getPrivate().getEncoded(), 11);
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzo));
    zzo localzzo;
    do
    {
      return false;
      localzzo = (zzo)paramObject;
    }
    while ((this.zzcc != localzzo.zzcc) || (!this.zzcb.getPublic().equals(localzzo.zzcb.getPublic())) || (!this.zzcb.getPrivate().equals(localzzo.zzcb.getPrivate())));
    return true;
  }

  final long getCreationTime()
  {
    return this.zzcc;
  }

  final KeyPair getKeyPair()
  {
    return this.zzcb;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.zzcb.getPublic();
    arrayOfObject[1] = this.zzcb.getPrivate();
    arrayOfObject[2] = Long.valueOf(this.zzcc);
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzo
 * JD-Core Version:    0.6.2
 */