package com.google.android.gms.wearable;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzas;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzen;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzhp;
import com.google.android.gms.wearable.internal.zzi;
import java.util.List;

public class WearableListenerService extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private ComponentName service;
  private zzc zzad;
  private IBinder zzae;
  private Intent zzaf;
  private Looper zzag;
  private final Object zzah = new Object();
  private boolean zzai;
  private zzas zzaj = new zzas(new zza(null));

  public Looper getLooper()
  {
    if (this.zzag == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
      localHandlerThread.start();
      this.zzag = localHandlerThread.getLooper();
    }
    return this.zzag;
  }

  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction()))
      return this.zzae;
    return null;
  }

  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
  }

  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onChannelOpened(Channel paramChannel)
  {
  }

  public void onChannelOpened(ChannelClient.Channel paramChannel)
  {
  }

  public void onConnectedNodes(List<Node> paramList)
  {
  }

  public void onCreate()
  {
    super.onCreate();
    this.service = new ComponentName(this, getClass().getName());
    if (Log.isLoggable("WearableLS", 3))
    {
      String str = String.valueOf(this.service);
      Log.d("WearableLS", 10 + String.valueOf(str).length() + "onCreate: " + str);
    }
    this.zzad = new zzc(getLooper());
    this.zzaf = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.zzaf.setComponent(this.service);
    this.zzae = new zzd(null);
  }

  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
  }

  public void onDestroy()
  {
    if (Log.isLoggable("WearableLS", 3))
    {
      String str2 = String.valueOf(this.service);
      Log.d("WearableLS", 11 + String.valueOf(str2).length() + "onDestroy: " + str2);
    }
    synchronized (this.zzah)
    {
      this.zzai = true;
      if (this.zzad == null)
      {
        String str1 = String.valueOf(this.service);
        throw new IllegalStateException(111 + String.valueOf(str1).length() + "onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + str1);
      }
    }
    this.zzad.quit();
    super.onDestroy();
  }

  public void onEntityUpdate(zzb paramzzb)
  {
  }

  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
  }

  public void onNotificationReceived(zzd paramzzd)
  {
  }

  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onPeerConnected(Node paramNode)
  {
  }

  public void onPeerDisconnected(Node paramNode)
  {
  }

  final class zza extends ChannelClient.ChannelCallback
  {
    private zza()
    {
    }

    public final void onChannelClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      WearableListenerService.this.onChannelClosed(paramChannel, paramInt1, paramInt2);
    }

    public final void onChannelOpened(ChannelClient.Channel paramChannel)
    {
      WearableListenerService.this.onChannelOpened(paramChannel);
    }

    public final void onInputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      WearableListenerService.this.onInputClosed(paramChannel, paramInt1, paramInt2);
    }

    public final void onOutputClosed(ChannelClient.Channel paramChannel, int paramInt1, int paramInt2)
    {
      WearableListenerService.this.onOutputClosed(paramChannel, paramInt1, paramInt2);
    }
  }

  final class zzb
    implements ServiceConnection
  {
    private zzb()
    {
    }

    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
    }

    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
    }
  }

  final class zzc extends Handler
  {
    private boolean started;
    private final WearableListenerService.zzb zzal = new WearableListenerService.zzb(WearableListenerService.this, null);

    zzc(Looper arg2)
    {
      super();
    }

    @SuppressLint({"UntrackedBindService"})
    private final void zzb()
    {
      try
      {
        boolean bool = this.started;
        if (bool);
        while (true)
        {
          return;
          if (Log.isLoggable("WearableLS", 2))
          {
            String str = String.valueOf(WearableListenerService.zza(WearableListenerService.this));
            Log.v("WearableLS", 13 + String.valueOf(str).length() + "bindService: " + str);
          }
          WearableListenerService.this.bindService(WearableListenerService.zzb(WearableListenerService.this), this.zzal, 1);
          this.started = true;
        }
      }
      finally
      {
      }
    }

    // ERROR //
    @SuppressLint({"UntrackedBindService"})
    private final void zzb(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 31	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   6: istore_3
      //   7: iload_3
      //   8: ifne +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: ldc 33
      //   16: iconst_2
      //   17: invokestatic 39	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   20: ifeq +69 -> 89
      //   23: aload_0
      //   24: getfield 14	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   27: invokestatic 45	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
      //   30: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   33: astore 6
      //   35: ldc 33
      //   37: new 53	java/lang/StringBuilder
      //   40: dup
      //   41: bipush 17
      //   43: aload_1
      //   44: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   47: invokevirtual 57	java/lang/String:length	()I
      //   50: iadd
      //   51: aload 6
      //   53: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   56: invokevirtual 57	java/lang/String:length	()I
      //   59: iadd
      //   60: invokespecial 60	java/lang/StringBuilder:<init>	(I)V
      //   63: ldc 86
      //   65: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: aload_1
      //   69: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 88
      //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: aload 6
      //   79: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   85: invokestatic 74	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   88: pop
      //   89: aload_0
      //   90: getfield 14	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
      //   93: aload_0
      //   94: getfield 24	com/google/android/gms/wearable/WearableListenerService$zzc:zzal	Lcom/google/android/gms/wearable/WearableListenerService$zzb;
      //   97: invokevirtual 92	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
      //   100: aload_0
      //   101: iconst_0
      //   102: putfield 31	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
      //   105: goto -94 -> 11
      //   108: astore_2
      //   109: aload_0
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: astore 4
      //   115: ldc 33
      //   117: ldc 94
      //   119: aload 4
      //   121: invokestatic 98	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   124: pop
      //   125: goto -25 -> 100
      //
      // Exception table:
      //   from	to	target	type
      //   2	7	108	finally
      //   14	89	108	finally
      //   89	100	108	finally
      //   100	105	108	finally
      //   115	125	108	finally
      //   89	100	113	java/lang/RuntimeException
    }

    public final void dispatchMessage(Message paramMessage)
    {
      zzb();
      try
      {
        super.dispatchMessage(paramMessage);
        return;
      }
      finally
      {
        if (!hasMessages(0))
          zzb("dispatch");
      }
    }

    final void quit()
    {
      getLooper().quit();
      zzb("quit");
    }
  }

  final class zzd extends zzen
  {
    private volatile int zzam = -1;

    private zzd()
    {
    }

    private final boolean zza(Runnable paramRunnable, String paramString, Object paramObject)
    {
      if (Log.isLoggable("WearableLS", 3))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = WearableListenerService.zza(WearableListenerService.this).toString();
        arrayOfObject[2] = paramObject;
        Log.d("WearableLS", String.format("%s: %s %s", arrayOfObject));
      }
      int i = Binder.getCallingUid();
      int j;
      if (i == this.zzam)
        j = 1;
      while (j == 0)
      {
        return false;
        if ((zzhp.zza(WearableListenerService.this).zze("com.google.android.wearable.app.cn")) && (UidVerifier.uidHasPackageName(WearableListenerService.this, i, "com.google.android.wearable.app.cn")))
        {
          this.zzam = i;
          j = 1;
        }
        else if (UidVerifier.isGooglePlayServicesUid(WearableListenerService.this, i))
        {
          this.zzam = i;
          j = 1;
        }
        else
        {
          Log.e("WearableLS", 57 + "Caller is not GooglePlayServices; caller UID: " + i);
          j = 0;
        }
      }
      synchronized (WearableListenerService.zzd(WearableListenerService.this))
      {
        if (WearableListenerService.zze(WearableListenerService.this))
          return false;
      }
      WearableListenerService.zzf(WearableListenerService.this).post(paramRunnable);
      return true;
    }

    public final void onConnectedNodes(List<zzfo> paramList)
    {
      zza(new zzp(this, paramList), "onConnectedNodes", paramList);
    }

    public final void zza(DataHolder paramDataHolder)
    {
      zzl localzzl = new zzl(this, paramDataHolder);
      try
      {
        String str = String.valueOf(paramDataHolder);
        int i = paramDataHolder.getCount();
        boolean bool = zza(localzzl, "onDataItemChanged", 18 + String.valueOf(str).length() + str + ", rows=" + i);
        if (!bool);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }

    public final void zza(zzah paramzzah)
    {
      zza(new zzq(this, paramzzah), "onConnectedCapabilityChanged", paramzzah);
    }

    public final void zza(zzaw paramzzaw)
    {
      zza(new zzt(this, paramzzaw), "onChannelEvent", paramzzaw);
    }

    public final void zza(zzfe paramzzfe)
    {
      zza(new zzm(this, paramzzfe), "onMessageReceived", paramzzfe);
    }

    public final void zza(zzfo paramzzfo)
    {
      zza(new zzn(this, paramzzfo), "onPeerConnected", paramzzfo);
    }

    public final void zza(zzi paramzzi)
    {
      zza(new zzs(this, paramzzi), "onEntityUpdate", paramzzi);
    }

    public final void zza(com.google.android.gms.wearable.internal.zzl paramzzl)
    {
      zza(new zzr(this, paramzzl), "onNotificationReceived", paramzzl);
    }

    public final void zzb(zzfo paramzzfo)
    {
      zza(new zzo(this, paramzzfo), "onPeerDisconnected", paramzzfo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.6.2
 */