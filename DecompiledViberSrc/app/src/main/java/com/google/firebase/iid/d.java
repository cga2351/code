package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

final class d
{
  private final KeyPair a;
  private final long b;

  @VisibleForTesting
  d(KeyPair paramKeyPair, long paramLong)
  {
    this.a = paramKeyPair;
    this.b = paramLong;
  }

  private final String c()
  {
    return Base64.encodeToString(this.a.getPublic().getEncoded(), 11);
  }

  private final String d()
  {
    return Base64.encodeToString(this.a.getPrivate().getEncoded(), 11);
  }

  final KeyPair a()
  {
    return this.a;
  }

  final long b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d));
    d locald;
    do
    {
      return false;
      locald = (d)paramObject;
    }
    while ((this.b != locald.b) || (!this.a.getPublic().equals(locald.a.getPublic())) || (!this.a.getPrivate().equals(locald.a.getPrivate())));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.a.getPublic();
    arrayOfObject[1] = this.a.getPrivate();
    arrayOfObject[2] = Long.valueOf(this.b);
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.d
 * JD-Core Version:    0.6.2
 */