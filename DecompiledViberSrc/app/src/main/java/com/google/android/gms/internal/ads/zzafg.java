package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;
import java.util.WeakHashMap;

@zzare
public final class zzafg
  implements NativeCustomTemplateAd
{
  private static WeakHashMap<IBinder, zzafg> zzcyy = new WeakHashMap();
  private final VideoController zzcjf;
  private final zzafd zzcyz;
  private final MediaView zzcza;

  // ERROR //
  @com.google.android.gms.common.util.VisibleForTesting
  private zzafg(zzafd paramzzafd)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 34	com/google/android/gms/ads/VideoController
    //   8: dup
    //   9: invokespecial 35	com/google/android/gms/ads/VideoController:<init>	()V
    //   12: putfield 37	com/google/android/gms/internal/ads/zzafg:zzcjf	Lcom/google/android/gms/ads/VideoController;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 39	com/google/android/gms/internal/ads/zzafg:zzcyz	Lcom/google/android/gms/internal/ads/zzafd;
    //   20: aload_1
    //   21: invokeinterface 45 1 0
    //   26: invokestatic 51	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   29: checkcast 53	android/content/Context
    //   32: astore 8
    //   34: aload 8
    //   36: astore_3
    //   37: aconst_null
    //   38: astore 4
    //   40: aload_3
    //   41: ifnull +41 -> 82
    //   44: new 55	com/google/android/gms/ads/formats/MediaView
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 58	com/google/android/gms/ads/formats/MediaView:<init>	(Landroid/content/Context;)V
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 39	com/google/android/gms/internal/ads/zzafg:zzcyz	Lcom/google/android/gms/internal/ads/zzafd;
    //   58: aload 5
    //   60: invokestatic 62	com/google/android/gms/dynamic/ObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   63: invokeinterface 66 2 0
    //   68: istore 7
    //   70: iload 7
    //   72: ifne +6 -> 78
    //   75: aconst_null
    //   76: astore 5
    //   78: aload 5
    //   80: astore 4
    //   82: aload_0
    //   83: aload 4
    //   85: putfield 68	com/google/android/gms/internal/ads/zzafg:zzcza	Lcom/google/android/gms/ads/formats/MediaView;
    //   88: return
    //   89: astore_2
    //   90: ldc 70
    //   92: aload_2
    //   93: invokestatic 76	com/google/android/gms/internal/ads/zzbae:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: aconst_null
    //   97: astore_3
    //   98: goto -61 -> 37
    //   101: astore 6
    //   103: ldc 70
    //   105: aload 6
    //   107: invokestatic 76	com/google/android/gms/internal/ads/zzbae:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aconst_null
    //   111: astore 4
    //   113: goto -31 -> 82
    //   116: astore_2
    //   117: goto -27 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   20	34	89	android/os/RemoteException
    //   54	70	101	android/os/RemoteException
    //   20	34	116	java/lang/NullPointerException
  }

  public static zzafg zza(zzafd paramzzafd)
  {
    synchronized (zzcyy)
    {
      zzafg localzzafg1 = (zzafg)zzcyy.get(paramzzafd.asBinder());
      if (localzzafg1 != null)
        return localzzafg1;
      zzafg localzzafg2 = new zzafg(paramzzafd);
      zzcyy.put(paramzzafd.asBinder(), localzzafg2);
      return localzzafg2;
    }
  }

  public final void destroy()
  {
    try
    {
      this.zzcyz.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final List<String> getAvailableAssetNames()
  {
    try
    {
      List localList = this.zzcyz.getAvailableAssetNames();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final String getCustomTemplateId()
  {
    try
    {
      String str = this.zzcyz.getCustomTemplateId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final NativeAd.Image getImage(String paramString)
  {
    try
    {
      zzaeh localzzaeh = this.zzcyz.zzck(paramString);
      if (localzzaeh != null)
      {
        zzaek localzzaek = new zzaek(localzzaeh);
        return localzzaek;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final CharSequence getText(String paramString)
  {
    try
    {
      String str = this.zzcyz.zzcj(paramString);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final VideoController getVideoController()
  {
    try
    {
      zzaap localzzaap = this.zzcyz.getVideoController();
      if (localzzaap != null)
        this.zzcjf.zza(localzzaap);
      return this.zzcjf;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Exception occurred while getting video controller", localRemoteException);
    }
  }

  public final MediaView getVideoMediaView()
  {
    return this.zzcza;
  }

  public final void performClick(String paramString)
  {
    try
    {
      this.zzcyz.performClick(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void recordImpression()
  {
    try
    {
      this.zzcyz.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final zzafd zzrn()
  {
    return this.zzcyz;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzafg
 * JD-Core Version:    0.6.2
 */