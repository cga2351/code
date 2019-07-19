package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class b
  implements s
{
  private final Context a;

  public b(Context paramContext)
  {
    this.a = paramContext;
  }

  private static int a(Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    int i = localParcel.dataSize();
    localParcel.recycle();
    return i;
  }

  private static String a(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.get(paramString);
    if ((localObject == null) || ((localObject instanceof Integer)) || ((localObject instanceof Long)) || ((localObject instanceof Double)) || ((localObject instanceof String)) || ((localObject instanceof Boolean)))
      return null;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    Class localClass = null;
    if (localObject == null);
    while (true)
    {
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = paramString;
      return String.format(localLocale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", arrayOfObject);
      localClass = localObject.getClass();
    }
  }

  private List<String> a(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return c("Service can't be empty");
    if (this.a == null)
      return c("Context is null, can't query PackageManager");
    PackageManager localPackageManager = this.a.getPackageManager();
    if (localPackageManager == null)
      return c("PackageManager is null, can't validate service");
    String str = "Couldn't find a registered service with the name " + paramString + ". Is it declared in the manifest with the right intent-filter?";
    Intent localIntent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
    localIntent.setClassName(this.a, paramString);
    List localList = localPackageManager.queryIntentServices(localIntent, 0);
    if ((localList == null) || (localList.isEmpty()))
      return c(str);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ((localResolveInfo.serviceInfo != null) && (localResolveInfo.serviceInfo.enabled))
        return null;
    }
    return c(str);
  }

  private static List<String> a(List<String> paramList, String paramString)
  {
    if (paramString == null)
      return paramList;
    if (paramList == null)
      return c(paramString);
    Collections.addAll(paramList, new String[] { paramString });
    return paramList;
  }

  private static List<String> a(List<String> paramList1, List<String> paramList2)
  {
    if (paramList1 == null)
      paramList1 = paramList2;
    while (paramList2 == null)
      return paramList1;
    paramList1.addAll(paramList2);
    return paramList1;
  }

  private static List<String> a(boolean paramBoolean, List<String> paramList, String paramString)
  {
    if (paramBoolean)
      paramList = a(paramList, paramString);
    return paramList;
  }

  private static List<String> b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      for (localList = null; localIterator.hasNext(); localList = a(localList, a(paramBundle, (String)localIterator.next())));
    }
    List localList = null;
    return localList;
  }

  private static List<String> b(String paramString)
  {
    if (paramString == null)
      return c("Tag can't be null");
    if (paramString.length() > 100)
      return c("Tag must be shorter than 100");
    return null;
  }

  private static List<String> c(Bundle paramBundle)
  {
    if (paramBundle == null);
    int i;
    do
    {
      return null;
      i = a(paramBundle);
    }
    while (i <= 10240);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(10240);
    return c(String.format(localLocale, "Extras too large: %d bytes is > the max (%d bytes)", arrayOfObject));
  }

  private static List<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return localArrayList;
  }

  public List<String> a(p paramp)
  {
    List localList1 = a(a(null, a(paramp.f())), a(paramp.c()));
    if ((paramp.h()) && (paramp.f() == v.a))
      localList1 = a(localList1, "ImmediateTriggers can't be used with recurring jobs");
    List localList2 = a(localList1, c(paramp.b()));
    if (paramp.g() > 1)
      localList2 = a(localList2, b(paramp.b()));
    return a(a(localList2, b(paramp.e())), a(paramp.i()));
  }

  public List<String> a(r paramr)
  {
    if ((paramr != v.a) && (!(paramr instanceof r.b)) && (!(paramr instanceof r.a)))
      return c("Unknown trigger provided");
    return null;
  }

  public List<String> a(u paramu)
  {
    int i = 1;
    int j = paramu.a();
    int k = paramu.b();
    int m = paramu.c();
    label53: label76: List localList3;
    if ((j != i) && (j != 2))
    {
      int n = i;
      List localList1 = a(n, null, "Unknown retry policy provided");
      if (m >= k)
        break label111;
      int i2 = i;
      List localList2 = a(i2, localList1, "Maximum backoff must be greater than or equal to initial backoff");
      if (300 <= m)
        break label117;
      int i4 = i;
      localList3 = a(i4, localList2, "Maximum backoff must be greater than 300s (5 minutes)");
      if (k >= 30)
        break label123;
    }
    while (true)
    {
      return a(i, localList3, "Initial backoff must be at least 30s");
      int i1 = 0;
      break;
      label111: int i3 = 0;
      break label53;
      label117: int i5 = 0;
      break label76;
      label123: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.b
 * JD-Core Version:    0.6.2
 */