package com.viber.voip.billing;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.dexshared.BillingHost;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.ah;
import com.viber.voip.settings.d.bj;
import com.viber.voip.user.UserManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.onepf.oms.appstore.googleUtils.IabHelper;

public class a
  implements BillingHost
{
  private static final Logger a = b.a(a.class);
  private static volatile Set<String> b;

  private static Set<String> a()
  {
    if (b == null);
    try
    {
      HashSet localHashSet = new HashSet();
      String str = d.bj.b.d();
      if (str != null)
      {
        String[] arrayOfString = str.split(",");
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
          localHashSet.add(arrayOfString[j]);
      }
      b = localHashSet;
      return b;
    }
    finally
    {
    }
  }

  private static void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(str2);
    }
    String str1 = localStringBuilder.toString();
    d.bj.b.a(str1);
  }

  public Logger getBillingLogger(String paramString)
  {
    return b.a(paramString);
  }

  public String getInstallerPackageName()
  {
    Application localApplication = ViberApplication.getApplication();
    return localApplication.getPackageManager().getInstallerPackageName(localApplication.getPackageName());
  }

  public int getPreferredStoreIndex()
  {
    return d.ah.a.d();
  }

  public String getRegNumberCanonized()
  {
    return UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
  }

  public String getResponseDesc(int paramInt)
  {
    return IabHelper.getResponseDesc(paramInt);
  }

  public boolean isViberOutProduct(String paramString)
  {
    try
    {
      boolean bool = a().contains(paramString);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setIsViberOutProduct(String paramString)
  {
    try
    {
      if (!a().contains(paramString))
      {
        a().add(paramString);
        b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.a
 * JD-Core Version:    0.6.2
 */