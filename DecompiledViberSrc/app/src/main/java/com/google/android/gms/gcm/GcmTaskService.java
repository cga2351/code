package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gcm.zzf;
import com.google.android.gms.internal.gcm.zzj;
import com.google.android.gms.internal.gcm.zzl;
import com.google.android.gms.internal.gcm.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

public abstract class GcmTaskService extends Service
{
  public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
  public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  private ComponentName componentName;
  private final Object lock = new Object();
  private zzl zzg;

  @GuardedBy("lock")
  private int zzu;
  private ExecutorService zzv;
  private Messenger zzw;
  private GcmNetworkManager zzx;

  private final void zzd(int paramInt)
  {
    synchronized (this.lock)
    {
      this.zzu = paramInt;
      if (!this.zzx.zzf(this.componentName.getClassName()))
        stopSelf(this.zzu);
      return;
    }
  }

  private final void zzd(zze paramzze)
  {
    try
    {
      this.zzv.execute(paramzze);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", localRejectedExecutionException);
      zze.zzd(paramzze, 1);
    }
  }

  private final boolean zzg(String paramString)
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (!this.zzx.zzd(paramString, this.componentName.getClassName()))
        {
          bool = true;
          if (bool)
          {
            String str = getPackageName();
            Log.w("GcmTaskService", 44 + String.valueOf(str).length() + String.valueOf(paramString).length() + str + " " + paramString + ": Task already running, won't start another");
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent == null) || (!PlatformVersion.isAtLeastLollipop()) || (!"com.google.android.gms.gcm.ACTION_TASK_READY".equals(paramIntent.getAction())))
      return null;
    return this.zzw.getBinder();
  }

  public void onCreate()
  {
    super.onCreate();
    this.zzx = GcmNetworkManager.getInstance(this);
    this.zzv = com.google.android.gms.internal.gcm.zzg.zzaa().zzd(10, new zze(this), 10);
    this.zzw = new Messenger(new zzd(Looper.getMainLooper()));
    this.componentName = new ComponentName(this, getClass());
    zzm.zzab();
    getClass();
    this.zzg = zzm.zzdk;
  }

  public void onDestroy()
  {
    super.onDestroy();
    List localList = this.zzv.shutdownNow();
    if (!localList.isEmpty())
    {
      int i = localList.size();
      Log.e("GcmTaskService", 79 + "Shutting down, but not all tasks are finished executing. Remaining: " + i);
    }
  }

  public void onInitializeTasks()
  {
  }

  public abstract int onRunTask(TaskParams paramTaskParams);

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      zzd(paramInt2);
      return 2;
    }
    while (true)
    {
      String str1;
      try
      {
        paramIntent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        str1 = paramIntent.getAction();
        if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(str1))
        {
          String str2 = paramIntent.getStringExtra("tag");
          Parcelable localParcelable = paramIntent.getParcelableExtra("callback");
          Bundle localBundle = paramIntent.getBundleExtra("extras");
          ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("triggered_uris");
          long l = paramIntent.getLongExtra("max_exec_duration", 180L);
          if (!(localParcelable instanceof PendingCallback))
          {
            String str3 = getPackageName();
            Log.e("GcmTaskService", 47 + String.valueOf(str3).length() + String.valueOf(str2).length() + str3 + " " + str2 + ": Could not process request, invalid callback.");
            return 2;
          }
          boolean bool = zzg(str2);
          if (bool)
            return 2;
          zzd(new zze(str2, ((PendingCallback)localParcelable).zzan, localBundle, l, localArrayList));
          return 2;
        }
        if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(str1))
        {
          onInitializeTasks();
          continue;
        }
      }
      finally
      {
        zzd(paramInt2);
      }
      Log.e("GcmTaskService", 37 + String.valueOf(str1).length() + "Unknown action received " + str1 + ", terminating");
    }
  }

  @TargetApi(21)
  @VisibleForTesting
  final class zzd extends zzj
  {
    zzd(Looper arg2)
    {
      super();
    }

    public final void handleMessage(Message paramMessage)
    {
      if (!UidVerifier.uidHasPackageName(GcmTaskService.this, paramMessage.sendingUid, "com.google.android.gms"))
        Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
      do
      {
        Bundle localBundle1;
        Messenger localMessenger;
        String str2;
        ArrayList localArrayList;
        long l;
        do
        {
          do
          {
            do
            {
              return;
              switch (paramMessage.what)
              {
              case 3:
              default:
                String str3 = String.valueOf(paramMessage);
                Log.e("GcmTaskService", 31 + String.valueOf(str3).length() + "Unrecognized message received: " + str3);
                return;
              case 1:
                localBundle1 = paramMessage.getData();
              case 2:
              case 4:
              }
            }
            while (localBundle1.isEmpty());
            localMessenger = paramMessage.replyTo;
          }
          while (localMessenger == null);
          str2 = localBundle1.getString("tag");
          localArrayList = localBundle1.getParcelableArrayList("triggered_uris");
          l = localBundle1.getLong("max_exec_duration", 180L);
        }
        while (GcmTaskService.zzd(GcmTaskService.this, str2));
        Bundle localBundle2 = localBundle1.getBundle("extras");
        GcmTaskService.zze localzze = new GcmTaskService.zze(GcmTaskService.this, str2, localMessenger, localBundle2, l, localArrayList);
        GcmTaskService.zzd(GcmTaskService.this, localzze);
        return;
      }
      while (!Log.isLoggable("GcmTaskService", 3));
      String str1 = String.valueOf(paramMessage);
      Log.d("GcmTaskService", 45 + String.valueOf(str1).length() + "ignoring unimplemented stop message for now: " + str1);
      return;
      GcmTaskService.this.onInitializeTasks();
    }
  }

  final class zze
    implements Runnable
  {
    private final Bundle extras;
    private final String tag;
    private final List<Uri> zzaa;
    private final long zzab;
    private final zzg zzac;
    private final Messenger zzad;

    zze(IBinder paramBundle, Bundle paramLong, long arg4, List<Uri> arg6)
    {
      this.tag = paramBundle;
      Object localObject2;
      if (paramLong == null)
        localObject2 = null;
      while (true)
      {
        this.zzac = ((zzg)localObject2);
        this.extras = ???;
        this.zzab = paramList;
        Object localObject1;
        this.zzaa = localObject1;
        this.zzad = null;
        return;
        IInterface localIInterface = paramLong.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
        if ((localIInterface instanceof zzg))
          localObject2 = (zzg)localIInterface;
        else
          localObject2 = new zzh(paramLong);
      }
    }

    zze(Messenger paramBundle, Bundle paramLong, long arg4, List<Uri> arg6)
    {
      this.tag = paramBundle;
      this.zzad = paramLong;
      this.extras = ???;
      this.zzab = paramList;
      Object localObject;
      this.zzaa = localObject;
      this.zzac = null;
    }

    private final void zze(int paramInt)
    {
      Object localObject1 = GcmTaskService.zze(GcmTaskService.this);
      try
      {
        boolean bool = GcmTaskService.zzg(GcmTaskService.this).zzf(this.tag, GcmTaskService.zzf(GcmTaskService.this).getClassName());
        if (bool);
        while (true)
        {
          try
          {
            GcmTaskService.zzg(GcmTaskService.this).zze(this.tag, GcmTaskService.zzf(GcmTaskService.this).getClassName());
            if ((!zzg()) && (!GcmTaskService.zzg(GcmTaskService.this).zzf(GcmTaskService.zzf(GcmTaskService.this).getClassName())))
              GcmTaskService.this.stopSelf(GcmTaskService.zzh(GcmTaskService.this));
            return;
            if (zzg())
            {
              Messenger localMessenger = this.zzad;
              Message localMessage = Message.obtain();
              localMessage.what = 3;
              localMessage.arg1 = paramInt;
              Bundle localBundle = new Bundle();
              localBundle.putParcelable("component", GcmTaskService.zzf(GcmTaskService.this));
              localBundle.putString("tag", this.tag);
              localMessage.setData(localBundle);
              localMessenger.send(localMessage);
              GcmTaskService.zzg(GcmTaskService.this).zze(this.tag, GcmTaskService.zzf(GcmTaskService.this).getClassName());
              if ((!zzg()) && (!GcmTaskService.zzg(GcmTaskService.this).zzf(GcmTaskService.zzf(GcmTaskService.this).getClassName())))
                GcmTaskService.this.stopSelf(GcmTaskService.zzh(GcmTaskService.this));
              return;
            }
          }
          finally
          {
          }
          this.zzac.zzf(paramInt);
        }
      }
      catch (RemoteException localRemoteException)
      {
        String str1 = String.valueOf(this.tag);
        if (str1.length() != 0);
        for (String str2 = "Error reporting result of operation to scheduler for ".concat(str1); ; str2 = new String("Error reporting result of operation to scheduler for "))
        {
          Log.e("GcmTaskService", str2);
          GcmTaskService.zzg(GcmTaskService.this).zze(this.tag, GcmTaskService.zzf(GcmTaskService.this).getClassName());
          if ((zzg()) || (GcmTaskService.zzg(GcmTaskService.this).zzf(GcmTaskService.zzf(GcmTaskService.this).getClassName())))
            break;
          GcmTaskService.this.stopSelf(GcmTaskService.zzh(GcmTaskService.this));
          break;
        }
      }
      finally
      {
        GcmTaskService.zzg(GcmTaskService.this).zze(this.tag, GcmTaskService.zzf(GcmTaskService.this).getClassName());
        if ((!zzg()) && (!GcmTaskService.zzg(GcmTaskService.this).zzf(GcmTaskService.zzf(GcmTaskService.this).getClassName())))
          GcmTaskService.this.stopSelf(GcmTaskService.zzh(GcmTaskService.this));
      }
    }

    private final boolean zzg()
    {
      return this.zzad != null;
    }

    public final void run()
    {
      String str1 = String.valueOf("nts:client:onRunTask:");
      String str2 = String.valueOf(this.tag);
      String str3;
      if (str2.length() != 0)
        str3 = str1.concat(str2);
      while (true)
      {
        zzp localzzp = new zzp(str3);
        try
        {
          TaskParams localTaskParams = new TaskParams(this.tag, this.extras, this.zzab, this.zzaa);
          GcmTaskService.zzd(GcmTaskService.this).zzd("onRunTask", com.google.android.gms.internal.gcm.zzp.zzdo);
          try
          {
            int i = GcmTaskService.this.onRunTask(localTaskParams);
            zze(i);
            zzd(null, localzzp);
            return;
            str3 = new String(str1);
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3 = localThrowable3;
            throw localThrowable3;
          }
          finally
          {
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          try
          {
            throw localThrowable2;
          }
          finally
          {
            localThrowable1 = localThrowable2;
          }
          zzd(localThrowable1, localzzp);
          throw localObject1;
        }
        finally
        {
          while (true)
            Throwable localThrowable1 = null;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService
 * JD-Core Version:    0.6.2
 */