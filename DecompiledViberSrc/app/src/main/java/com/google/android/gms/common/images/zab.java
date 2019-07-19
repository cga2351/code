package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class zab
{
  public final Uri uri;

  public zab(Uri paramUri)
  {
    this.uri = paramUri;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zab))
      return false;
    if (this == paramObject)
      return true;
    return Objects.equal(((zab)paramObject).uri, this.uri);
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.uri;
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.zab
 * JD-Core Version:    0.6.2
 */