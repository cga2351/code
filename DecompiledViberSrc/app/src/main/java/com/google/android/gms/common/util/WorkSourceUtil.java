package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil
{
  private static final int zzhh = Process.myUid();
  private static final Method zzhi = zzw();
  private static final Method zzhj = zzx();
  private static final Method zzhk = zzy();
  private static final Method zzhl = zzz();
  private static final Method zzhm = zzaa();
  private static final Method zzhn = zzab();
  private static final Method zzho = zzac();

  @KeepForSdk
  public static WorkSource fromPackage(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getPackageManager() == null) || (paramString == null))
      return null;
    ApplicationInfo localApplicationInfo;
    try
    {
      localApplicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (localApplicationInfo == null)
      {
        String str3 = String.valueOf(paramString);
        if (str3.length() != 0)
        {
          str4 = "Could not get applicationInfo from package: ".concat(str3);
          Log.e("WorkSourceUtil", str4);
          return null;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0);
        for (String str2 = "Could not find package: ".concat(str1); ; str2 = new String("Could not find package: "))
        {
          Log.e("WorkSourceUtil", str2);
          return null;
        }
        String str4 = new String("Could not get applicationInfo from package: ");
      }
    }
    return zza(localApplicationInfo.uid, paramString);
  }

  @KeepForSdk
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramContext.getPackageManager() == null) || (paramString2 == null) || (paramString1 == null))
      Log.w("WorkSourceUtil", "Unexpected null arguments");
    int i;
    do
    {
      return null;
      i = zzd(paramContext, paramString1);
    }
    while (i < 0);
    WorkSource localWorkSource = new WorkSource();
    if ((zzhn == null) || (zzho == null))
    {
      zza(localWorkSource, i, paramString1);
      return localWorkSource;
    }
    try
    {
      Object localObject = zzhn.invoke(localWorkSource, new Object[0]);
      if (i != zzhh)
      {
        Method localMethod2 = zzho;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(i);
        arrayOfObject2[1] = paramString1;
        localMethod2.invoke(localObject, arrayOfObject2);
      }
      Method localMethod1 = zzho;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(zzhh);
      arrayOfObject1[1] = paramString2;
      localMethod1.invoke(localObject, arrayOfObject1);
      return localWorkSource;
    }
    catch (Exception localException)
    {
      Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", localException);
    }
    return localWorkSource;
  }

  @KeepForSdk
  public static List<String> getNames(WorkSource paramWorkSource)
  {
    int i = 0;
    int j;
    Object localObject;
    if (paramWorkSource == null)
    {
      j = 0;
      if (j != 0)
        break label26;
      localObject = Collections.emptyList();
    }
    while (true)
    {
      return localObject;
      j = zza(paramWorkSource);
      break;
      label26: localObject = new ArrayList();
      while (i < j)
      {
        String str = zza(paramWorkSource, i);
        if (!Strings.isEmptyOrWhitespace(str))
          ((List)localObject).add(str);
        i++;
      }
    }
  }

  @KeepForSdk
  public static boolean hasWorkSourcePermission(Context paramContext)
  {
    if (paramContext == null);
    while ((paramContext.getPackageManager() == null) || (Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) != 0))
      return false;
    return true;
  }

  private static int zza(WorkSource paramWorkSource)
  {
    if (zzhk != null)
      try
      {
        int i = ((Integer)zzhk.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception localException)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", localException);
      }
    return 0;
  }

  private static WorkSource zza(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    zza(localWorkSource, paramInt, paramString);
    return localWorkSource;
  }

  private static String zza(WorkSource paramWorkSource, int paramInt)
  {
    if (zzhm != null)
      try
      {
        Method localMethod = zzhm;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        String str = (String)localMethod.invoke(paramWorkSource, arrayOfObject);
        return str;
      }
      catch (Exception localException)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", localException);
      }
    return null;
  }

  private static void zza(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    if (zzhj != null)
      if (paramString == null)
        paramString = "";
    while (zzhi == null)
      try
      {
        Method localMethod2 = zzhj;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        arrayOfObject2[1] = paramString;
        localMethod2.invoke(paramWorkSource, arrayOfObject2);
        return;
      }
      catch (Exception localException2)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", localException2);
        return;
      }
    try
    {
      Method localMethod1 = zzhi;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt);
      localMethod1.invoke(paramWorkSource, arrayOfObject1);
      return;
    }
    catch (Exception localException1)
    {
      Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", localException1);
    }
  }

  private static Method zzaa()
  {
    boolean bool = PlatformVersion.isAtLeastJellyBeanMR2();
    Object localObject = null;
    if (bool);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = WorkSource.class.getMethod("getName", arrayOfClass);
      localObject = localMethod;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static final Method zzab()
  {
    boolean bool = PlatformVersion.isAtLeastP();
    Object localObject = null;
    if (bool);
    try
    {
      Method localMethod = WorkSource.class.getMethod("createWorkChain", new Class[0]);
      localObject = localMethod;
      return localObject;
    }
    catch (Exception localException)
    {
      Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", localException);
    }
    return null;
  }

  @SuppressLint({"PrivateApi"})
  private static final Method zzac()
  {
    boolean bool = PlatformVersion.isAtLeastP();
    Object localObject = null;
    if (bool);
    try
    {
      Class localClass = Class.forName("android.os.WorkSource$WorkChain");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = String.class;
      Method localMethod = localClass.getMethod("addNode", arrayOfClass);
      localObject = localMethod;
      return localObject;
    }
    catch (Exception localException)
    {
      Log.w("WorkSourceUtil", "Missing WorkChain class", localException);
    }
    return null;
  }

  private static int zzd(Context paramContext, String paramString)
  {
    ApplicationInfo localApplicationInfo;
    try
    {
      localApplicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (localApplicationInfo == null)
      {
        String str3 = String.valueOf(paramString);
        if (str3.length() != 0)
        {
          str4 = "Could not get applicationInfo from package: ".concat(str3);
          Log.e("WorkSourceUtil", str4);
          return -1;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0);
        for (String str2 = "Could not find package: ".concat(str1); ; str2 = new String("Could not find package: "))
        {
          Log.e("WorkSourceUtil", str2);
          return -1;
        }
        String str4 = new String("Could not get applicationInfo from package: ");
      }
    }
    return localApplicationInfo.uid;
  }

  private static Method zzw()
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = WorkSource.class.getMethod("add", arrayOfClass);
      return localMethod;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Method zzx()
  {
    boolean bool = PlatformVersion.isAtLeastJellyBeanMR2();
    Object localObject = null;
    if (bool);
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = String.class;
      Method localMethod = WorkSource.class.getMethod("add", arrayOfClass);
      localObject = localMethod;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Method zzy()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      return localMethod;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Method zzz()
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = WorkSource.class.getMethod("get", arrayOfClass);
      return localMethod;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.WorkSourceUtil
 * JD-Core Version:    0.6.2
 */