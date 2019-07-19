package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.h.b;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.p;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class DeviceInfo
{
  private static final Object a = new Object();
  private static volatile DeviceInfo b;
  public final String appPlatform;
  public final String deviceRootStatus;
  public final List<String> deviceRootStatusMarkers;
  public final String deviceType;
  public String locale;
  public final String manufacturer;
  public final String model;
  public final String osVersion;
  public final String platform;
  public final String platformDeviceId;
  public final float scaleFactor;
  public final int screenDpi;
  public final int screenHeight;
  public final int screenWidth;

  DeviceInfo(Context paramContext, com.yandex.metrica.impl.h paramh)
  {
    this.platform = paramh.a;
    this.appPlatform = paramh.a;
    this.platformDeviceId = paramh.a();
    this.manufacturer = paramh.b;
    this.model = paramh.c;
    this.osVersion = paramh.d;
    this.screenWidth = paramh.f.a;
    this.screenHeight = paramh.f.b;
    this.screenDpi = paramh.f.c;
    this.scaleFactor = paramh.f.d;
    this.deviceType = paramh.g;
    this.deviceRootStatus = paramh.h;
    this.deviceRootStatusMarkers = new ArrayList(paramh.i);
    this.locale = aw.a(paramContext.getResources().getConfiguration().locale);
    com.yandex.metrica.impl.ob.h.a().a(this, p.class, l.a(new k()
    {
      public void a(p paramAnonymousp)
      {
        DeviceInfo.this.locale = paramAnonymousp.a;
      }
    }).a());
  }

  public static DeviceInfo getInstance(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new DeviceInfo(paramContext, com.yandex.metrica.impl.h.a(paramContext));
      return b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.interact.DeviceInfo
 * JD-Core Version:    0.6.2
 */