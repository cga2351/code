package com.viber.voip.analytics.g;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.viber.common.permission.c;
import com.viber.jni.Version;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a.d;
import com.viber.voip.p;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.b;
import com.viber.voip.settings.d.bj;
import com.viber.voip.settings.d.n;
import com.viber.voip.user.UserManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class j
{
  protected final com.viber.common.a.e a = ViberEnv.getLogger("WasabiUserProperties");
  private final com.viber.voip.messages.extras.b.a b;
  private final c c;
  private final UserManager d;
  private String e;
  private com.viber.voip.g.b.b<Map<String, Object>> f;
  private com.viber.voip.model.a.a g;

  public j(com.viber.voip.messages.extras.b.a parama, c paramc, UserManager paramUserManager)
  {
    this.b = parama;
    this.c = paramc;
    this.d = paramUserManager;
    this.f = new com.viber.voip.g.b.b()
    {
      protected Map<String, Object> a()
      {
        HashMap localHashMap = new HashMap();
        j.a(j.this, localHashMap);
        return localHashMap;
      }
    };
    this.g = new a(new com.viber.voip.g.b.b()
    {
      protected d a()
      {
        return com.viber.voip.model.a.b.c();
      }
    }
    , "wasabi_location_country_cache", TimeUnit.HOURS.toMillis(23L));
  }

  private void a(Map<String, Object> paramMap)
  {
    String str1 = this.d.getRegistrationValues().e();
    if (!TextUtils.isEmpty(str1))
    {
      paramMap.put("CountryCode", str1);
      paramMap.put("OS", "android");
      paramMap.put("OSVersionCode", Integer.valueOf(Build.VERSION.SDK_INT));
      if (!ao.f())
        break label236;
    }
    label236: for (String str2 = "secondary"; ; str2 = "primary")
    {
      paramMap.put("DeviceType", str2);
      paramMap.put("UserId", this.e);
      paramMap.put("DeviceManufacturer", Build.MANUFACTURER);
      paramMap.put("DeviceCodename", Build.DEVICE);
      paramMap.put("DeviceModel", Build.MODEL);
      Version localVersion = Version.parseVersionString(p.d());
      paramMap.put("VersionMajor", Integer.valueOf(localVersion.Major));
      paramMap.put("VersionMinor", Integer.valueOf(localVersion.Minor));
      paramMap.put("VersionPatch", Integer.valueOf(localVersion.MinorMinor));
      paramMap.put("IsNewUser", Boolean.toString(d()));
      paramMap.put("ChatexRedesignUser", Boolean.toString(d.n.k.d()));
      paramMap.put("ViberOutUser", Boolean.toString(d.bj.a.d()));
      return;
    }
  }

  private boolean d()
  {
    long l = d.b.f.d();
    if (l == 0L);
    while (System.currentTimeMillis() - l >= TimeUnit.DAYS.toMillis(30L))
      return false;
    return true;
  }

  private void e()
  {
    while (true)
    {
      String str1;
      try
      {
        str1 = this.g.a(System.currentTimeMillis());
        if (TextUtils.isEmpty(str1))
        {
          str2 = this.d.getRegistrationValues().e();
          ((Map)this.f.get()).put("userLoc", str2);
          return;
        }
      }
      finally
      {
      }
      String str2 = str1;
    }
  }

  public String a()
  {
    return this.e;
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public String b()
  {
    if (ao.f())
      return this.e + "_s_android";
    return this.e;
  }

  public Map<String, Object> c()
  {
    e();
    return (Map)this.f.get();
  }

  private class a extends com.viber.voip.model.a.a
  {
    public a(String paramLong, long arg3)
    {
      super(str, localObject);
    }

    private String b()
    {
      boolean bool = j.a(j.this).a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
      String str = null;
      if (bool)
        str = j.b(j.this).a();
      return str;
    }

    protected String a()
    {
      return b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g.j
 * JD-Core Version:    0.6.2
 */