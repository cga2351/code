package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.util.Base64;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
{
  private final JSONObject a = new JSONObject();

  static <T> T a(JSONObject paramJSONObject, String paramString, T paramT)
    throws JSONException
  {
    if (!paramJSONObject.has(paramString))
      paramJSONObject.put(paramString, paramT);
    return paramJSONObject.get(paramString);
  }

  public y a()
  {
    try
    {
      c();
      b();
      return this;
    }
    catch (Exception localException)
    {
    }
    return this;
  }

  y a(Context paramContext)
    throws JSONException
  {
    JSONObject localJSONObject = (JSONObject)a((JSONObject)a(this.a, "dfid", new JSONObject()), "apps", new JSONObject());
    JSONArray localJSONArray1 = (JSONArray)a(localJSONObject, "names", new JSONArray());
    JSONArray localJSONArray2 = (JSONArray)a(localJSONObject, "system_flags", new JSONArray());
    JSONArray localJSONArray3 = (JSONArray)a(localJSONObject, "disabled_flags", new JSONArray());
    JSONArray localJSONArray4 = (JSONArray)a(localJSONObject, "first_install_time", new JSONArray());
    JSONArray localJSONArray5 = (JSONArray)a(localJSONObject, "last_update_time", new JSONArray());
    localJSONObject.put("version", 0);
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(0).iterator();
    if (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      localJSONArray1.put(localPackageInfo.packageName);
      boolean bool1;
      if ((0x1 & localPackageInfo.applicationInfo.flags) == 1)
      {
        bool1 = true;
        label196: localJSONArray2.put(bool1);
        if (localPackageInfo.applicationInfo.enabled)
          break label265;
      }
      label265: for (boolean bool2 = true; ; bool2 = false)
      {
        localJSONArray3.put(bool2);
        localJSONArray4.put(localPackageInfo.firstInstallTime / 1000L);
        localJSONArray5.put(localPackageInfo.lastUpdateTime / 1000L);
        break;
        bool1 = false;
        break label196;
      }
    }
    return this;
  }

  y a(Context paramContext, boolean paramBoolean)
    throws JSONException, UnsupportedEncodingException
  {
    JSONObject localJSONObject = (JSONObject)a((JSONObject)a(this.a, "dfid", new JSONObject()), "au", new JSONObject());
    JSONArray localJSONArray1 = (JSONArray)a(localJSONObject, "aun", new JSONArray());
    JSONArray localJSONArray2 = (JSONArray)a(localJSONObject, "ausf", new JSONArray());
    JSONArray localJSONArray3 = (JSONArray)a(localJSONObject, "audf", new JSONArray());
    JSONArray localJSONArray4 = (JSONArray)a(localJSONObject, "aulu", new JSONArray());
    JSONArray localJSONArray5 = new JSONArray();
    if (paramBoolean)
      a(localJSONObject, "aufi", localJSONArray5);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = bw.a(paramContext, new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0), "UTF-8"), new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuTEFVTkNIRVI=", 0), "UTF-8")).iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = ((ResolveInfo)localIterator.next()).activityInfo.applicationInfo;
      if (localHashSet.add(localApplicationInfo.packageName))
      {
        localJSONArray1.put(localApplicationInfo.packageName);
        boolean bool1;
        if ((0x1 & localApplicationInfo.flags) == 1)
        {
          bool1 = true;
          label245: localJSONArray2.put(bool1);
          localJSONArray4.put(new File(localApplicationInfo.sourceDir).lastModified());
          if (localApplicationInfo.enabled)
            break label318;
        }
        label318: for (boolean bool2 = true; ; bool2 = false)
        {
          localJSONArray3.put(bool2);
          if (!paramBoolean)
            break;
          if (!bool1)
            break label324;
          localJSONArray5.put(0);
          break;
          bool1 = false;
          break label245;
        }
        label324: PackageInfo localPackageInfo = bw.d(paramContext, localApplicationInfo.packageName);
        if (localPackageInfo == null)
          localJSONArray5.put(0);
        else
          localJSONArray5.put(localPackageInfo.firstInstallTime / 1000L);
      }
    }
    return this;
  }

  y b()
    throws JSONException
  {
    ((JSONObject)a(this.a, "dfid", new JSONObject())).put("boot_time", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000L);
    return this;
  }

  y c()
    throws JSONException
  {
    JSONObject localJSONObject = (JSONObject)a(this.a, "dfid", new JSONObject());
    long l1 = aw.a(true);
    long l2 = aw.a(false);
    long l3 = aw.c(true);
    long l4 = aw.c(false);
    localJSONObject.put("tds", l1 + l2);
    localJSONObject.put("fds", l3 + l4);
    return this;
  }

  public String d()
  {
    return this.a.toString();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.y
 * JD-Core Version:    0.6.2
 */