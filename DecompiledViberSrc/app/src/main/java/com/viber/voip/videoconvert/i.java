package com.viber.voip.videoconvert;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Build.VERSION;
import com.viber.voip.videoconvert.gpu.a.b;
import com.viber.voip.videoconvert.gpu.c.a;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import com.viber.voip.videoconvert.gpu.encoders.c.c;
import com.viber.voip.videoconvert.gpu.encoders.c.d;
import com.viber.voip.videoconvert.gpu.f.d.a;

public abstract class i
  implements c
{
  private static String a = "VideoConverterGPU";

  private c.c a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      e.a().b("Unknown ConversionMode detected, defaulting to CM_SCALE");
      return c.c.a;
    case 0:
      return c.c.a;
    case 1:
      return c.c.b;
    case 2:
    }
    return c.c.c;
  }

  public boolean a()
  {
    e.a().a("checking video converter availability");
    e.a().a("manufacturer: " + Build.MANUFACTURER + ", device: " + Build.DEVICE + ", model: " + Build.MODEL + ", sdk: " + Build.VERSION.SDK_INT);
    return c().a();
  }

  @TargetApi(16)
  public boolean a(g paramg)
  {
    return a(paramg.a, paramg.b, paramg.c, paramg.d, paramg.e, paramg.f, paramg.g, paramg.h, paramg.i, paramg.j, paramg.k, paramg.l, paramg.m, paramg.n, paramg);
  }

  @TargetApi(16)
  boolean a(String paramString1, String paramString2, double paramDouble, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, VideoConverterNative.IVideoConverterProgressObserver paramIVideoConverterProgressObserver, Integer paramInteger, boolean paramBoolean, g paramg)
  {
    int i = 16 * ((paramInt4 + 8) / 16);
    int j = 16 * ((paramInt5 + 8) / 16);
    e.a().b("starting GPU-assisted conversion");
    c.a locala = new c.a();
    locala.a = paramString3;
    locala.b = i;
    locala.c = j;
    locala.d = paramInt6;
    locala.e = 30;
    locala.f = paramInt1;
    locala.g = a(paramInt7);
    locala.h = paramBoolean;
    locala.i = paramg;
    d.a locala1 = new d.a();
    if (paramg.o != null)
      locala1.a = new a(paramInt2, paramInt3, paramg.o.c, paramg.o.b, paramg.o.d, paramg.o.a);
    com.viber.voip.videoconvert.gpu.b.e locale = c();
    if (locale != null)
    {
      com.viber.voip.videoconvert.gpu.encoders.c localc = locale.a(paramString1, paramString2, locala, locala1);
      localc.a(b.a());
      long l;
      if (paramInteger == null)
      {
        l = -1L;
        localc.b(l);
        if (localc.a() != c.d.f)
          break label292;
      }
      label292: for (boolean bool = true; ; bool = false)
      {
        e.a().b("conversion completed, successfull=" + bool);
        return bool;
        l = paramInteger.intValue();
        break;
      }
    }
    e.a().a("no available video encoder configurations on this device");
    return false;
  }

  abstract com.viber.voip.videoconvert.gpu.b.e c();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.i
 * JD-Core Version:    0.6.2
 */