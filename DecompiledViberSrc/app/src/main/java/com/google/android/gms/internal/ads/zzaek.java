package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzaek extends NativeAd.Image
{
  private final int height;
  private final Uri uri;
  private final int width;
  private final double zzcyl;
  private final zzaeh zzcyq;
  private final Drawable zzcyr;

  public zzaek(zzaeh paramzzaeh)
  {
    this.zzcyq = paramzzaeh;
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzcyq.zzrf();
      if (localIObjectWrapper != null)
      {
        localDrawable = (Drawable)ObjectWrapper.unwrap(localIObjectWrapper);
        this.zzcyr = localDrawable;
      }
    }
    catch (RemoteException localRemoteException4)
    {
      try
      {
        Uri localUri2 = this.zzcyq.getUri();
        localUri1 = localUri2;
        this.uri = localUri1;
        d1 = 1.0D;
      }
      catch (RemoteException localRemoteException4)
      {
        try
        {
          double d2 = this.zzcyq.getScale();
          double d1 = d2;
          this.zzcyl = d1;
        }
        catch (RemoteException localRemoteException4)
        {
          try
          {
            int m = this.zzcyq.getWidth();
            j = m;
            this.width = j;
          }
          catch (RemoteException localRemoteException4)
          {
            try
            {
              while (true)
              {
                int k = this.zzcyq.getHeight();
                i = k;
                this.height = i;
                return;
                localRemoteException1 = localRemoteException1;
                zzbae.zzc("", localRemoteException1);
                Drawable localDrawable = null;
                continue;
                localRemoteException2 = localRemoteException2;
                zzbae.zzc("", localRemoteException2);
                Uri localUri1 = null;
                continue;
                localRemoteException3 = localRemoteException3;
                zzbae.zzc("", localRemoteException3);
              }
              localRemoteException4 = localRemoteException4;
              zzbae.zzc("", localRemoteException4);
              int j = i;
            }
            catch (RemoteException localRemoteException5)
            {
              while (true)
                zzbae.zzc("", localRemoteException5);
            }
          }
        }
      }
    }
  }

  public final Drawable getDrawable()
  {
    return this.zzcyr;
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
  {
    return this.uri;
  }

  public final int getWidth()
  {
    return this.width;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaek
 * JD-Core Version:    0.6.2
 */