package com.viber.voip.banner.a.a;

import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import com.appboy.f.i;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.common.permission.c;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.messages.extras.b.a;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.ax;
import com.viber.voip.util.bg;
import java.util.Locale;

public final class g
{
  private final int a;
  private final c b;

  public g(int paramInt)
  {
    this.a = paramInt;
    this.b = c.a(ViberApplication.getApplication());
  }

  private Uri.Builder c(int paramInt)
  {
    Uri.Builder localBuilder = Uri.parse(ap.c().aL).buildUpon().appendQueryParameter("appId", String.valueOf(902)).appendQueryParameter("appSecret", "d8c7d85fb4430f497a844ac776b7db24").appendQueryParameter("ua", bg.a()).appendQueryParameter("loc", Locale.getDefault().getLanguage()).appendQueryParameter("adloc", String.valueOf(paramInt)).appendQueryParameter("count", String.valueOf(1)).appendQueryParameter("ver", p.d());
    if (c.j.a.e())
      localBuilder.appendQueryParameter("euconsent", d.v.q.d());
    if (d.f.d.d())
      localBuilder.appendQueryParameter("aid", ax.a());
    if (this.b.a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
    {
      Location localLocation = ViberApplication.getInstance().getLocationManager().b(0);
      if (localLocation != null)
        localBuilder.appendQueryParameter("lat", String.valueOf(localLocation.getLatitude())).appendQueryParameter("long", String.valueOf(localLocation.getLongitude()));
    }
    localBuilder.appendQueryParameter("adapter", String.valueOf(this.a));
    return localBuilder;
  }

  public Uri a()
  {
    return c(12).build();
  }

  public Uri a(int paramInt)
  {
    Uri.Builder localBuilder = c(paramInt);
    String str1 = ViberApplication.getInstance().getHardwareParameters().getMCC();
    if (!i.b(str1))
      localBuilder.appendQueryParameter("mcc", str1);
    String str2 = ViberApplication.getInstance().getHardwareParameters().getMNC();
    if (!i.b(str2))
      localBuilder.appendQueryParameter("mnc", str2);
    String str3 = ViberApplication.getInstance().getHardwareParameters().getCN();
    if (!i.b(str3))
      localBuilder.appendQueryParameter("carrier", str3);
    return localBuilder.build();
  }

  public Uri a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(ap.c().aN).buildUpon().appendQueryParameter("tp", "viber").appendQueryParameter("click_id", paramString).appendQueryParameter("ua", bg.a());
    if (d.f.d.d())
      localBuilder.appendQueryParameter("gaid", ax.a());
    return localBuilder.build();
  }

  public Uri b()
  {
    return c(22).build();
  }

  public Uri b(int paramInt)
  {
    Uri.Builder localBuilder = c(14);
    localBuilder.appendQueryParameter("stickerId", String.valueOf(paramInt));
    localBuilder.appendQueryParameter("stickerPackId", String.valueOf(com.viber.voip.stickers.c.g.f(paramInt)));
    return localBuilder.build();
  }

  public Uri c()
  {
    Uri.Builder localBuilder = Uri.parse(ap.c().aM).buildUpon().appendQueryParameter("segment_token", "LAPS5BBM").appendQueryParameter("utype", "gaid").appendQueryParameter("action", "add");
    if (d.f.d.d())
      localBuilder.appendQueryParameter("uuid", ax.a());
    return localBuilder.build();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.g
 * JD-Core Version:    0.6.2
 */