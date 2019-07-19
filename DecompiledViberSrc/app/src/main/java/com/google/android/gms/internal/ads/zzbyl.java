package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

@zzare
public final class zzbyl extends zzaee
{
  private final zzbys zzfmq;

  public zzbyl(zzbys paramzzbys)
  {
    this.zzfmq = paramzzbys;
  }

  private final float zzahq()
  {
    try
    {
      float f = this.zzfmq.getVideoController().getAspectRatio();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzc("Remote exception getting video controller aspect ratio.", localRemoteException);
    }
    return 0.0F;
  }

  private final float zzahr()
  {
    zzadv localzzadv = (zzadv)this.zzfmq.getImages().get(0);
    if ((localzzadv.getWidth() != -1) && (localzzadv.getHeight() != -1))
      return localzzadv.getWidth() / localzzadv.getHeight();
    try
    {
      Drawable localDrawable = (Drawable)ObjectWrapper.unwrap(localzzadv.zzrf());
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() != -1) && (localDrawable.getIntrinsicHeight() != -1))
      {
        float f = localDrawable.getIntrinsicWidth();
        int i = localDrawable.getIntrinsicHeight();
        return f / i;
      }
      return 0.0F;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzc("RemoteException getting Drawable for aspect ratio calculation.", localRemoteException);
    }
    return 0.0F;
  }

  public final float getAspectRatio()
  {
    zzaci localzzaci = zzact.zzcwx;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return 0.0F;
    if (this.zzfmq.zzsq() != 0.0F)
      return this.zzfmq.zzsq();
    if (this.zzfmq.getVideoController() != null)
      return zzahq();
    return zzahr();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbyl
 * JD-Core Version:    0.6.2
 */