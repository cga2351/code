package com.viber.voip.banner.b;

import android.content.Context;
import android.net.Uri;
import com.appnexus.opensdk.utils.Settings;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.banner.BannerController;
import com.viber.jni.banner.BannerDelegate;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.c.a.a;
import com.viber.voip.banner.d.b;
import com.viber.voip.banner.d.c;
import com.viber.voip.banner.d.f;
import com.viber.voip.banner.d.i;
import com.viber.voip.banner.d.j;
import com.viber.voip.banner.datatype.AppNexusStickerClickerMetaInfo;
import com.viber.voip.banner.datatype.StickerClickerMetaInfo;
import com.viber.voip.banner.datatype.StickerClickerMetaInfoItem;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.util.bg;
import com.viber.voip.util.da;
import com.viber.voip.util.e.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements BannerDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final BannerController b = ViberApplication.getInstance().getEngine(false).getBannerController();
  private final com.viber.voip.banner.d c;
  private final com.viber.voip.banner.g d = com.viber.voip.banner.h.a();

  public a(Context paramContext)
  {
    this.c = new com.viber.voip.banner.d(paramContext);
    com.viber.voip.h.a.b().register(this);
  }

  private void a(int paramInt, boolean paramBoolean, String paramString)
  {
    ICdrController localICdrController = ViberApplication.getInstance().getEngine(false).getCdrController();
    long l = ViberApplication.getInstance().getEngine(false).getPhoneController().generateSequence();
    int i;
    if (paramBoolean)
    {
      i = 3;
      if (!paramBoolean)
        break label82;
      Settings.getSettings().getClass();
    }
    label82: for (String str = "4.11.2"; ; str = "")
    {
      localICdrController.handleReportStickerClickerDisplay(l, "", "", 1, paramInt, i, "", paramString, str);
      return;
      i = 1;
      break;
    }
  }

  private void a(long paramLong, int paramInt, i parami, Uri paramUri)
  {
    ab.b().g(paramLong, paramInt);
    e.a(paramUri);
    a(parami);
  }

  private void a(a.a parama, String paramString, int paramInt)
  {
    ab.b().g(parama.b, parama.c);
    a(paramInt, parama.e, parama.f);
  }

  private void a(i parami)
  {
    if (parami != null)
      this.c.a(parami);
    this.c.a(com.viber.voip.banner.d.g.c);
  }

  public void onBannerOrSplashReceived(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject;
    com.viber.voip.banner.d.g localg;
    c localc;
    boolean bool;
    int i;
    int j;
    try
    {
      localJSONObject = new JSONObject(paramString1);
      localg = com.viber.voip.banner.d.g.a(localJSONObject.getString("type"));
      localc = c.a(localJSONObject.optString("position"));
      bool = localJSONObject.optBoolean("dummy", false);
      JSONArray localJSONArray = localJSONObject.optJSONArray("location");
      i = 0;
      if (localJSONArray == null)
        break label575;
      j = localJSONArray.length();
      if (i >= j)
        break label219;
      if (localg == com.viber.voip.banner.d.g.b)
      {
        com.viber.voip.banner.d.h localh1 = (com.viber.voip.banner.d.h)localg.c();
        localh1.a(j.a(localJSONArray.getString(i)));
        localh1.a(bool);
        localArrayList.add(localh1);
      }
      else if (localg == com.viber.voip.banner.d.g.a)
      {
        f localf1 = (f)localg.c();
        localf1.a(b.a(localJSONArray.getString(i)));
        localf1.a(localc);
        localf1.a(bool);
        localArrayList.add(localf1);
      }
    }
    catch (JSONException localJSONException)
    {
      this.b.handleBannerOrSplashAck(paramLong1, 1);
    }
    this.c.a();
    return;
    label219: int k;
    Iterator localIterator;
    if (localArrayList.isEmpty())
    {
      if (localg == com.viber.voip.banner.d.g.b)
      {
        com.viber.voip.banner.d.h localh2 = (com.viber.voip.banner.d.h)localg.c();
        localh2.a(j.a);
        localh2.a(bool);
        localArrayList.add(localh2);
      }
    }
    else
    {
      localJSONObject.remove("type");
      localJSONObject.remove("position");
      localJSONObject.remove("location");
      localJSONObject.remove("dummy");
      k = 0;
      localIterator = localArrayList.iterator();
    }
    while (true)
    {
      int i1;
      if (localIterator.hasNext())
      {
        com.viber.voip.banner.d.d locald = (com.viber.voip.banner.d.d)localIterator.next();
        locald.a(paramLong1);
        locald.b(1000L * paramLong2);
        locald.b(paramString2);
        locald.a(localJSONObject.toString());
        long l = -1L;
        if (localg == com.viber.voip.banner.d.g.b)
          l = this.c.a((com.viber.voip.banner.d.h)locald);
        while (true)
        {
          if (l <= 0L)
            break label562;
          i1 = k + 1;
          if (localg != com.viber.voip.banner.d.g.a)
            break label584;
          this.d.a(paramLong1, ((f)locald).i(), localc);
          break label584;
          if (localg != com.viber.voip.banner.d.g.a)
            break;
          f localf2 = (f)localg.c();
          localf2.a(b.b);
          localf2.a(localc);
          localf2.a(bool);
          localArrayList.add(localf2);
          break;
          if (localg == com.viber.voip.banner.d.g.a)
            l = this.c.a((f)locald);
        }
      }
      if ((k > 0) && (k == localArrayList.size()));
      for (int m = 0; ; m = 2)
      {
        this.b.handleBannerOrSplashAck(paramLong1, m);
        break;
      }
      label562: int n = k;
      break label588;
      i++;
      break;
      label575: j = 0;
      i = 0;
      break;
      label584: n = i1;
      label588: k = n;
    }
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onStickerClickerReceived(a.a parama)
  {
    if (parama.a == 1)
    {
      a(parama, "No ads", 1);
      return;
    }
    StickerClickerMetaInfoItem localStickerClickerMetaInfoItem;
    label79: String str;
    try
    {
      if (parama.e)
      {
        localStickerClickerMetaInfoItem = com.viber.voip.banner.e.a.b(parama.d).getItem();
        if (localStickerClickerMetaInfoItem != null)
          break label79;
        a(parama, "No ads", 1);
      }
    }
    catch (p localp)
    {
      while (true)
      {
        a(parama, "Unable to parse ads metadata", 3);
        return;
        localStickerClickerMetaInfoItem = com.viber.voip.banner.e.a.a(parama.d).getItem(0);
      }
      str = localStickerClickerMetaInfoItem.getClickerImageUrl();
      if (da.a(str))
      {
        a(parama, "Ads without image", 1);
        return;
      }
    }
    catch (Exception localException)
    {
      a(parama, "Unable to parse ads metadata", 4);
      return;
    }
    Uri localUri = Uri.parse(str);
    i locali = new i();
    locali.a(parama.c);
    locali.b(localStickerClickerMetaInfoItem.getClickerImageUrl());
    locali.c(parama.b);
    locali.b(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(localStickerClickerMetaInfoItem.getTtl().longValue()));
    localStickerClickerMetaInfoItem.setClickerUrl(bg.b(localStickerClickerMetaInfoItem.getClickerUrl()));
    localStickerClickerMetaInfoItem.removeTtl();
    locali.a(com.viber.voip.banner.e.a.a(localStickerClickerMetaInfoItem));
    a(parama.b, parama.c, locali, localUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.b.a
 * JD-Core Version:    0.6.2
 */