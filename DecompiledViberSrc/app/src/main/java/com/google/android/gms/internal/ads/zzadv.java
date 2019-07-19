package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzadv extends zzaei
{
  private final int height;
  private final Uri uri;
  private final int width;
  private final Drawable zzcyk;
  private final double zzcyl;

  public zzadv(Drawable paramDrawable, Uri paramUri, double paramDouble, int paramInt1, int paramInt2)
  {
    this.zzcyk = paramDrawable;
    this.uri = paramUri;
    this.zzcyl = paramDouble;
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public final int getHeight()
  {
    return this.height;
  }

  public final double getScale()
  {
    return this.zzcyl;
  }

  public final Uri getUri()
    throws RemoteException
  {
    return this.uri;
  }

  public final int getWidth()
  {
    return this.width;
  }

  public final IObjectWrapper zzrf()
    throws RemoteException
  {
    return ObjectWrapper.wrap(this.zzcyk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadv
 * JD-Core Version:    0.6.2
 */