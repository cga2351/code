package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
public final class zztd extends Surface
{
  private static boolean zzbnu;
  private static boolean zzbnv;
  private final boolean zzaer;
  private final zztf zzbnw;
  private boolean zzbnx;

  private zztd(zztf paramzztf, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.zzbnw = paramzztf;
    this.zzaer = paramBoolean;
  }

  public static zztd zzc(Context paramContext, boolean paramBoolean)
  {
    if (zzsy.SDK_INT < 17)
      throw new UnsupportedOperationException("Unsupported prior to API level 17");
    if ((!paramBoolean) || (zzc(paramContext)));
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      return new zztf().zzm(paramBoolean);
    }
  }

  public static boolean zzc(Context paramContext)
  {
    boolean bool1 = true;
    while (true)
    {
      int i;
      try
      {
        if (!zzbnv)
        {
          if (zzsy.SDK_INT >= 17)
          {
            String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
            if ((str == null) || (!str.contains("EGL_EXT_protected_content")))
              continue;
            if ((zzsy.SDK_INT == 24) && ((zzsy.MODEL.startsWith("SM-G950")) || (zzsy.MODEL.startsWith("SM-G955"))) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")))
            {
              i = bool1;
              break label128;
              zzbnu = bool1;
            }
          }
          else
          {
            zzbnv = true;
          }
        }
        else
        {
          boolean bool2 = zzbnu;
          return bool2;
        }
        i = 0;
        break label128;
        bool1 = false;
        continue;
      }
      finally
      {
      }
      label128: if (i != 0);
    }
  }

  public final void release()
  {
    super.release();
    synchronized (this.zzbnw)
    {
      if (!this.zzbnx)
      {
        this.zzbnw.release();
        this.zzbnx = true;
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztd
 * JD-Core Version:    0.6.2
 */