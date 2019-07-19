package c.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import c.a.a.a.l;

class c
{
  private final Context a;
  private final c.a.a.a.a.f.c b;

  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new c.a.a.a.a.f.d(paramContext, "TwitterAdvertisingInfoPreferences");
  }

  private void a(final b paramb)
  {
    new Thread(new h()
    {
      public void a()
      {
        b localb = c.a(c.this);
        if (!paramb.equals(localb))
        {
          c.a.a.a.c.g().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
          c.a(c.this, localb);
        }
      }
    }).start();
  }

  @SuppressLint({"CommitPrefEdits"})
  private void b(b paramb)
  {
    if (c(paramb))
    {
      this.b.a(this.b.b().putString("advertising_id", paramb.a).putBoolean("limit_ad_tracking_enabled", paramb.b));
      return;
    }
    this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
  }

  private boolean c(b paramb)
  {
    return (paramb != null) && (!TextUtils.isEmpty(paramb.a));
  }

  private b e()
  {
    b localb1 = c().a();
    if (!c(localb1))
    {
      b localb2 = d().a();
      if (!c(localb2))
      {
        c.a.a.a.c.g().a("Fabric", "AdvertisingInfo not present");
        return localb2;
      }
      c.a.a.a.c.g().a("Fabric", "Using AdvertisingInfo from Service Provider");
      return localb2;
    }
    c.a.a.a.c.g().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
    return localb1;
  }

  public b a()
  {
    b localb1 = b();
    if (c(localb1))
    {
      c.a.a.a.c.g().a("Fabric", "Using AdvertisingInfo from Preference Store");
      a(localb1);
      return localb1;
    }
    b localb2 = e();
    b(localb2);
    return localb2;
  }

  protected b b()
  {
    return new b(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
  }

  public f c()
  {
    return new d(this.a);
  }

  public f d()
  {
    return new e(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.c
 * JD-Core Version:    0.6.2
 */