package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzaec extends NativeAd.AdChoicesInfo
{
  private String zzbhy;
  private final List<NativeAd.Image> zzcyd = new ArrayList();
  private final zzadz zzcyo;

  public zzaec(zzadz paramzzadz)
  {
    this.zzcyo = paramzzadz;
    try
    {
      this.zzbhy = this.zzcyo.getText();
      try
      {
        Iterator localIterator = paramzzadz.zzra().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if (!(localObject1 instanceof IBinder))
            break label180;
          localIBinder = (IBinder)localObject1;
          if (localIBinder == null)
            break label180;
          IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
          if (!(localIInterface instanceof zzaeh))
            break label162;
          localObject2 = (zzaeh)localIInterface;
          if (localObject2 != null)
            this.zzcyd.add(new zzaek((zzaeh)localObject2));
        }
      }
      catch (RemoteException localRemoteException2)
      {
        zzbae.zzc("", localRemoteException2);
      }
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      while (true)
      {
        IBinder localIBinder;
        zzbae.zzc("", localRemoteException1);
        this.zzbhy = "";
        continue;
        label162: zzaej localzzaej = new zzaej(localIBinder);
        Object localObject2 = localzzaej;
        continue;
        label180: localObject2 = null;
      }
    }
  }

  public final List<NativeAd.Image> getImages()
  {
    return this.zzcyd;
  }

  public final CharSequence getText()
  {
    return this.zzbhy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaec
 * JD-Core Version:    0.6.2
 */