package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzdi
{
  private static final Method zzacv = zzfu();
  private static final Method zzacw = zzfv();
  private static volatile zzdk zzacx = zzdj.zzacy;
  private final JobScheduler zzacu;

  private zzdi(JobScheduler paramJobScheduler)
  {
    this.zzacu = paramJobScheduler;
  }

  private final int zza(JobInfo paramJobInfo, String paramString1, int paramInt, String paramString2)
  {
    if (zzacv != null);
    try
    {
      Method localMethod = zzacv;
      JobScheduler localJobScheduler = this.zzacu;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramJobInfo;
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = Integer.valueOf(paramInt);
      arrayOfObject[3] = paramString2;
      int i = ((Integer)localMethod.invoke(localJobScheduler, arrayOfObject)).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e(paramString2, "error calling scheduleAsPackage", localIllegalAccessException);
      return this.zzacu.schedule(paramJobInfo);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label69: break label69;
    }
  }

  public static int zza(Context paramContext, JobInfo paramJobInfo, String paramString1, String paramString2)
  {
    JobScheduler localJobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
    if ((zzacv == null) || (!zzacx.zzfy()) || (paramContext.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0))
      return localJobScheduler.schedule(paramJobInfo);
    return new zzdi(localJobScheduler).zza(paramJobInfo, paramString1, zzfw(), paramString2);
  }

  private static Method zzfu()
  {
    if (Build.VERSION.SDK_INT >= 24)
      try
      {
        Class[] arrayOfClass = new Class[4];
        arrayOfClass[0] = JobInfo.class;
        arrayOfClass[1] = String.class;
        arrayOfClass[2] = Integer.TYPE;
        arrayOfClass[3] = String.class;
        Method localMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", arrayOfClass);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        if (Log.isLoggable("JobSchedulerCompat", 6))
          Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
      }
    return null;
  }

  private static Method zzfv()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i >= 24);
    try
    {
      Method localMethod = UserHandle.class.getDeclaredMethod("myUserId", null);
      localObject = localMethod;
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      boolean bool;
      do
      {
        bool = Log.isLoggable("JobSchedulerCompat", 6);
        localObject = null;
      }
      while (!bool);
      Log.e("JobSchedulerCompat", "No myUserId method available");
    }
    return null;
  }

  private static int zzfw()
  {
    if (zzacw != null);
    try
    {
      int i = ((Integer)zzacw.invoke(null, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      if (Log.isLoggable("JobSchedulerCompat", 6))
        Log.e("JobSchedulerCompat", "myUserId invocation illegal", localIllegalAccessException);
      return 0;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label27: break label27;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdi
 * JD-Core Version:    0.6.2
 */