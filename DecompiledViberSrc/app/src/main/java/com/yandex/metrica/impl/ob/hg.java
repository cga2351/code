package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.w;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class hg
{
  private static hf a(Context paramContext, String paramString, File paramFile)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      if (localApplicationInfo != null)
      {
        String str1 = paramContext.getApplicationInfo().dataDir;
        String str2 = localApplicationInfo.dataDir;
        hf localhf = d(paramContext, paramFile.getAbsolutePath().replace(str1, str2));
        return localhf;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  private hf b(Context paramContext)
  {
    hf localhf1 = b(paramContext, paramContext.getPackageName());
    if (localhf1 == null)
      localhf1 = null;
    hf localhf2;
    do
    {
      do
        return localhf1;
      while (!a());
      localhf2 = c(paramContext, paramContext.getPackageName());
    }
    while (localhf2 == null);
    return localhf2;
  }

  private static hf d(Context paramContext, String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        String str = w.a(paramContext, localFile);
        if (str == null)
          return null;
        hf localhf = new hf(new JSONObject(str), localFile.lastModified());
        return localhf;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public he a(Context paramContext)
  {
    hf localhf = b(paramContext);
    if (localhf == null)
      return null;
    return localhf.b();
  }

  public void a(Context paramContext, he paramhe, iv paramiv)
  {
    try
    {
      hf localhf = b(paramContext);
      String str1 = null;
      if (localhf != null)
      {
        hh localhh = localhf.c();
        str1 = null;
        if (localhh != null)
          str1 = localhf.c().a();
      }
      String str2 = new hf(paramhe, new hh(paramContext, str1, paramiv), System.currentTimeMillis()).a();
      if (a())
        a(paramContext, str2);
      w.a(paramContext, "credentials.dat", str2);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  void a(Context paramContext, String paramString)
  {
    w.b(paramContext, "credentials.dat", paramString);
  }

  boolean a()
  {
    return bw.a(21);
  }

  hf b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, paramContext.getFileStreamPath("credentials.dat"));
  }

  @TargetApi(21)
  hf c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, new File(paramContext.getNoBackupFilesDir(), "credentials.dat"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hg
 * JD-Core Version:    0.6.2
 */