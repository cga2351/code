package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class GcmNetworkManager
{
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS;

  @GuardedBy("GcmNetworkManager.class")
  private static GcmNetworkManager zzh;
  private final Context zzi;

  @GuardedBy("this")
  private final Map<String, Map<String, Boolean>> zzj = new ArrayMap();

  private GcmNetworkManager(Context paramContext)
  {
    this.zzi = paramContext;
  }

  public static GcmNetworkManager getInstance(Context paramContext)
  {
    try
    {
      if (zzh == null)
        zzh = new GcmNetworkManager(paramContext.getApplicationContext());
      GcmNetworkManager localGcmNetworkManager = zzh;
      return localGcmNetworkManager;
    }
    finally
    {
    }
  }

  static void zzd(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Must provide a valid tag.");
    if (100 < paramString.length())
      throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
  }

  private final zzn zze()
  {
    if (GoogleCloudMessaging.zzf(this.zzi) < 5000000)
    {
      Log.e("GcmNetworkManager", "Google Play services is not available, dropping all GcmNetworkManager requests");
      return new zzo();
    }
    return new zzm(this.zzi);
  }

  private final boolean zze(String paramString)
  {
    Preconditions.checkNotNull(paramString, "GcmTaskService must not be null.");
    PackageManager localPackageManager = this.zzi.getPackageManager();
    List localList;
    if (localPackageManager == null)
    {
      localList = Collections.emptyList();
      if (CollectionUtils.isEmpty(localList))
      {
        Log.e("GcmNetworkManager", String.valueOf(paramString).concat(" is not available. This may cause the task to be lost."));
        return true;
      }
    }
    else
    {
      if (paramString != null);
      for (Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY").setClassName(this.zzi, paramString); ; localIntent = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY").setPackage(this.zzi.getPackageName()))
      {
        localList = localPackageManager.queryIntentServices(localIntent, 0);
        break;
      }
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ((localResolveInfo.serviceInfo != null) && (localResolveInfo.serviceInfo.enabled))
        return true;
    }
    throw new IllegalArgumentException(118 + String.valueOf(paramString).length() + "The GcmTaskService class you provided " + paramString + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY");
  }

  // ERROR //
  public void cancelAllTasks(java.lang.Class<? extends GcmTaskService> paramClass)
  {
    // Byte code:
    //   0: new 210	android/content/ComponentName
    //   3: dup
    //   4: aload_0
    //   5: getfield 33	com/google/android/gms/gcm/GcmNetworkManager:zzi	Landroid/content/Context;
    //   8: aload_1
    //   9: invokespecial 213	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12: astore_2
    //   13: new 72	com/google/android/gms/gcm/zzp
    //   16: dup
    //   17: ldc 215
    //   19: invokespecial 216	com/google/android/gms/gcm/zzp:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual 219	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   28: invokespecial 221	com/google/android/gms/gcm/GcmNetworkManager:zze	(Ljava/lang/String;)Z
    //   31: pop
    //   32: aload_0
    //   33: invokespecial 223	com/google/android/gms/gcm/GcmNetworkManager:zze	()Lcom/google/android/gms/gcm/zzn;
    //   36: aload_2
    //   37: invokeinterface 228 2 0
    //   42: pop
    //   43: aconst_null
    //   44: aload_3
    //   45: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   48: return
    //   49: astore 6
    //   51: aload 6
    //   53: athrow
    //   54: astore 7
    //   56: aload 6
    //   58: astore 5
    //   60: aload 7
    //   62: astore 4
    //   64: aload 5
    //   66: aload_3
    //   67: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   70: aload 4
    //   72: athrow
    //   73: astore 4
    //   75: aconst_null
    //   76: astore 5
    //   78: goto -14 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   23	43	49	java/lang/Throwable
    //   51	54	54	finally
    //   23	43	73	finally
  }

  // ERROR //
  public void cancelTask(String paramString, java.lang.Class<? extends GcmTaskService> paramClass)
  {
    // Byte code:
    //   0: new 210	android/content/ComponentName
    //   3: dup
    //   4: aload_0
    //   5: getfield 33	com/google/android/gms/gcm/GcmNetworkManager:zzi	Landroid/content/Context;
    //   8: aload_2
    //   9: invokespecial 213	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12: astore_3
    //   13: ldc 234
    //   15: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore 4
    //   20: aload_1
    //   21: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 65	java/lang/String:length	()I
    //   31: ifeq +55 -> 86
    //   34: aload 4
    //   36: aload 5
    //   38: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 6
    //   43: new 72	com/google/android/gms/gcm/zzp
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 216	com/google/android/gms/gcm/zzp:<init>	(Ljava/lang/String;)V
    //   52: astore 7
    //   54: aload_1
    //   55: invokestatic 236	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 219	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   63: invokespecial 221	com/google/android/gms/gcm/GcmNetworkManager:zze	(Ljava/lang/String;)Z
    //   66: pop
    //   67: aload_0
    //   68: invokespecial 223	com/google/android/gms/gcm/GcmNetworkManager:zze	()Lcom/google/android/gms/gcm/zzn;
    //   71: aload_3
    //   72: aload_1
    //   73: invokeinterface 239 3 0
    //   78: pop
    //   79: aconst_null
    //   80: aload 7
    //   82: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   85: return
    //   86: new 61	java/lang/String
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 240	java/lang/String:<init>	(Ljava/lang/String;)V
    //   95: astore 6
    //   97: goto -54 -> 43
    //   100: astore 10
    //   102: aload 10
    //   104: athrow
    //   105: astore 11
    //   107: aload 10
    //   109: astore 9
    //   111: aload 11
    //   113: astore 8
    //   115: aload 9
    //   117: aload 7
    //   119: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   122: aload 8
    //   124: athrow
    //   125: astore 8
    //   127: aconst_null
    //   128: astore 9
    //   130: goto -15 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   54	79	100	java/lang/Throwable
    //   102	105	105	finally
    //   54	79	125	finally
  }

  // ERROR //
  public void schedule(Task paramTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 244
    //   4: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 249	com/google/android/gms/gcm/Task:getTag	()Ljava/lang/String;
    //   12: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 65	java/lang/String:length	()I
    //   22: ifeq +106 -> 128
    //   25: aload_3
    //   26: aload 4
    //   28: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: new 72	com/google/android/gms/gcm/zzp
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 216	com/google/android/gms/gcm/zzp:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 252	com/google/android/gms/gcm/Task:getServiceName	()Ljava/lang/String;
    //   49: invokespecial 221	com/google/android/gms/gcm/GcmNetworkManager:zze	(Ljava/lang/String;)Z
    //   52: pop
    //   53: aload_0
    //   54: invokespecial 223	com/google/android/gms/gcm/GcmNetworkManager:zze	()Lcom/google/android/gms/gcm/zzn;
    //   57: aload_1
    //   58: invokeinterface 255 2 0
    //   63: ifeq +56 -> 119
    //   66: aload_0
    //   67: getfield 31	com/google/android/gms/gcm/GcmNetworkManager:zzj	Ljava/util/Map;
    //   70: aload_1
    //   71: invokevirtual 252	com/google/android/gms/gcm/Task:getServiceName	()Ljava/lang/String;
    //   74: invokeinterface 261 2 0
    //   79: checkcast 257	java/util/Map
    //   82: astore 12
    //   84: aload 12
    //   86: ifnull +33 -> 119
    //   89: aload 12
    //   91: aload_1
    //   92: invokevirtual 249	com/google/android/gms/gcm/Task:getTag	()Ljava/lang/String;
    //   95: invokeinterface 265 2 0
    //   100: ifeq +19 -> 119
    //   103: aload 12
    //   105: aload_1
    //   106: invokevirtual 249	com/google/android/gms/gcm/Task:getTag	()Ljava/lang/String;
    //   109: iconst_1
    //   110: invokestatic 270	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: invokeinterface 273 3 0
    //   118: pop
    //   119: aconst_null
    //   120: aload 6
    //   122: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: new 61	java/lang/String
    //   131: dup
    //   132: aload_3
    //   133: invokespecial 240	java/lang/String:<init>	(Ljava/lang/String;)V
    //   136: astore 5
    //   138: goto -105 -> 33
    //   141: astore_2
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore 9
    //   148: aload 9
    //   150: athrow
    //   151: astore 10
    //   153: aload 9
    //   155: astore 8
    //   157: aload 10
    //   159: astore 7
    //   161: aload 8
    //   163: aload 6
    //   165: invokestatic 230	com/google/android/gms/gcm/GcmNetworkManager:zzd	(Ljava/lang/Throwable;Lcom/google/android/gms/gcm/zzp;)V
    //   168: aload 7
    //   170: athrow
    //   171: astore 7
    //   173: aconst_null
    //   174: astore 8
    //   176: goto -15 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   2	33	141	finally
    //   33	44	141	finally
    //   119	125	141	finally
    //   128	138	141	finally
    //   161	171	141	finally
    //   44	84	146	java/lang/Throwable
    //   89	119	146	java/lang/Throwable
    //   148	151	151	finally
    //   44	84	171	finally
    //   89	119	171	finally
  }

  final boolean zzd(String paramString1, String paramString2)
  {
    try
    {
      Object localObject2 = (Map)this.zzj.get(paramString2);
      if (localObject2 == null)
      {
        localObject2 = new ArrayMap();
        this.zzj.put(paramString2, localObject2);
      }
      Object localObject3 = ((Map)localObject2).put(paramString1, Boolean.valueOf(false));
      if (localObject3 == null);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  final void zze(String paramString1, String paramString2)
  {
    try
    {
      Map localMap = (Map)this.zzj.get(paramString2);
      if (localMap != null)
        if (localMap.remove(paramString1) == null)
          break label65;
      label65: for (int i = 1; ; i = 0)
      {
        if ((i != 0) && (localMap.isEmpty()))
          this.zzj.remove(paramString2);
        return;
      }
    }
    finally
    {
    }
  }

  final boolean zzf(String paramString)
  {
    try
    {
      boolean bool = this.zzj.containsKey(paramString);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final boolean zzf(String paramString1, String paramString2)
  {
    try
    {
      Map localMap = (Map)this.zzj.get(paramString2);
      Boolean localBoolean;
      boolean bool2;
      if (localMap != null)
      {
        localBoolean = (Boolean)localMap.get(paramString1);
        if (localBoolean == null)
          bool2 = false;
      }
      while (true)
      {
        return bool2;
        boolean bool1 = localBoolean.booleanValue();
        bool2 = bool1;
        continue;
        bool2 = false;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmNetworkManager
 * JD-Core Version:    0.6.2
 */