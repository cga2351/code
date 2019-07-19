package com.viber.voip.stickers.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;
import com.appnexus.opensdk.NativeAdRequest;
import com.appnexus.opensdk.NativeAdRequestListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.utils.Settings;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.StickerClickerWebViewActivity;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.q;
import com.viber.voip.ads.q.a;
import com.viber.voip.ads.r;
import com.viber.voip.ads.s;
import com.viber.voip.ads.t;
import com.viber.voip.av.e;
import com.viber.voip.banner.c.a.a;
import com.viber.voip.banner.datatype.StickerClickerMetaInfoItem;
import com.viber.voip.i.c.b;
import com.viber.voip.messages.controller.cb;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.p;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.f;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.ax;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.upload.ObjectId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class b extends cb
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final SparseIntArray b = new SparseIntArray();
  private final Engine c;
  private final com.viber.voip.util.e.e d;
  private final c.a e;
  private Set<String> f;
  private Set<b> g = Collections.synchronizedSet(new HashSet());
  private o h;
  private com.viber.voip.banner.d i;
  private final Handler j;
  private s k;
  private final q l;
  private final com.viber.voip.banner.a.a.g m;
  private dagger.a<com.viber.voip.ads.h> n;
  private dagger.a<com.viber.voip.ads.h> o;
  private final com.viber.common.permission.c p;
  private final String q;
  private NativeAdRequest r;
  private d.al s;

  static
  {
    b.put(0, 0);
    b.put(1, 1);
    b.put(2, 2);
  }

  public b(final Context paramContext, c.a parama, Handler paramHandler)
  {
    Handler localHandler = com.viber.voip.av.a(av.e.a);
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[2];
    arrayOfa[0] = d.ax.q;
    arrayOfa[1] = d.f.d;
    this.s = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (paramAnonymousa == d.ax.q)
          b.a(b.this);
        while (paramAnonymousa != d.f.d)
          return;
        b.b(b.this);
      }
    };
    this.e = parama;
    this.h = o.a();
    this.i = new com.viber.voip.banner.d(ViberApplication.getApplication());
    this.k = new t(ViberApplication.getApplication(), paramHandler);
    this.l = new r(ViberApplication.getInstance().getDownloadValve());
    this.j = paramHandler;
    this.m = new com.viber.voip.banner.a.a.g(0);
    this.c = ViberApplication.getInstance().getEngine(false);
    this.d = ViberApplication.getInstance().getImageFetcher();
    com.viber.voip.e.a.e.b().a("APP START", "Settings.getSettings()");
    final Settings localSettings = Settings.getSettings();
    com.viber.voip.e.a.e.b().b("APP START", "Settings.getSettings()");
    this.q = com.viber.voip.util.k.a.a(com.viber.voip.ads.b.b.b.c.f, true);
    this.n = new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.ads.h a()
      {
        Context localContext = paramContext;
        PhoneController localPhoneController = b.c(b.this).getPhoneController();
        ICdrController localICdrController = b.c(b.this).getCdrController();
        Handler localHandler = b.d(b.this);
        localSettings.getClass();
        com.viber.voip.ads.h localh = new com.viber.voip.ads.h(localContext, localPhoneController, localICdrController, 3, localHandler, "4.11.2");
        localh.a(CdrConst.AdTypes.fromAdType("Story"));
        localh.a(b.e(b.this));
        localh.b(0);
        return localh;
      }
    };
    this.o = new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.ads.h a()
      {
        com.viber.voip.ads.h localh = new com.viber.voip.ads.h(paramContext, b.c(b.this).getPhoneController(), b.c(b.this).getCdrController(), 1, b.d(b.this), "");
        localh.a(CdrConst.AdTypes.fromAdType("Story"));
        localh.b(0);
        return localh;
      }
    };
    this.p = com.viber.common.permission.c.a(ViberApplication.getApplication());
    SDKSettings.useHttps(true);
    c();
    com.viber.voip.settings.d.a(this.s);
  }

  private void a(int paramInt, StickerClickerMetaInfoItem paramStickerClickerMetaInfoItem)
  {
    int i1 = 3;
    int i2;
    if ((da.a(paramStickerClickerMetaInfoItem.getId())) && (da.a(paramStickerClickerMetaInfoItem.getUuid())))
      i2 = 1;
    Object localObject;
    switch (paramInt)
    {
    default:
    case 0:
      for (localObject = null; ; localObject = paramStickerClickerMetaInfoItem.getImpressionUrls())
      {
        if (localObject != null)
          b().a((String[])localObject);
        return;
        i2 = 0;
        break;
      }
    case 1:
      String[] arrayOfString = paramStickerClickerMetaInfoItem.getViewUrls();
      ICdrController localICdrController2 = this.c.getCdrController();
      long l2 = this.c.getPhoneController().generateSequence();
      String str5 = paramStickerClickerMetaInfoItem.getId();
      String str6 = paramStickerClickerMetaInfoItem.getSessionId();
      int i4 = CdrConst.AdTypes.fromAdType(paramStickerClickerMetaInfoItem.getAdType());
      label143: String str7;
      if (i2 != 0)
      {
        if (i2 == 0)
          break label208;
        str7 = this.q;
        label154: if (i2 == 0)
          break label216;
        Settings.getSettings().getClass();
      }
      label208: label216: for (String str8 = "4.11.2"; ; str8 = "")
      {
        localICdrController2.handleReportStickerClickerDisplay(l2, str5, str6, i4, 0, i1, "", str7, str8);
        localObject = arrayOfString;
        break;
        i1 = 1;
        break label143;
        str7 = "";
        break label154;
      }
    case 2:
    }
    ICdrController localICdrController1 = this.c.getCdrController();
    long l1 = this.c.getPhoneController().generateSequence();
    String str1 = paramStickerClickerMetaInfoItem.getId();
    String str2 = paramStickerClickerMetaInfoItem.getSessionId();
    int i3 = CdrConst.AdTypes.fromAdType(paramStickerClickerMetaInfoItem.getAdType());
    label274: String str3;
    if (i2 != 0)
    {
      if (i2 == 0)
        break label341;
      str3 = this.q;
      label285: if (i2 == 0)
        break label349;
      Settings.getSettings().getClass();
    }
    label341: label349: for (String str4 = "4.11.2"; ; str4 = "")
    {
      localICdrController1.handleReportStickerClickerClick(l1, 1, str1, str2, i3, i1, "", str3, str4);
      localObject = paramStickerClickerMetaInfoItem.getClickUrls();
      break;
      i1 = 1;
      break label274;
      str3 = "";
      break label285;
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    ICdrController localICdrController = this.c.getCdrController();
    long l1 = this.c.getPhoneController().generateSequence();
    int i1;
    String str1;
    if (paramBoolean)
    {
      i1 = 3;
      if (!paramBoolean)
        break label89;
      str1 = this.q;
      label40: if (!paramBoolean)
        break label97;
      Settings.getSettings().getClass();
    }
    label89: label97: for (String str2 = "4.11.2"; ; str2 = "")
    {
      localICdrController.handleReportStickerClickerDisplay(l1, "", "", 1, paramInt, i1, "", str1, str2);
      return;
      i1 = 1;
      break;
      str1 = "";
      break label40;
    }
  }

  private void a(long paramLong, int paramInt, a parama)
  {
    switch (this.e.a(com.viber.voip.ads.b.b.b.c.f))
    {
    case 2:
    default:
      return;
    case 3:
      c(paramLong, paramInt, parama);
      return;
    case 1:
    }
    b(paramLong, paramInt, parama);
  }

  private void a(String paramString)
  {
  }

  private boolean a(long paramLong, int paramInt)
  {
    return this.i.a(com.viber.voip.banner.d.g.c, Long.toString(paramLong), paramInt) != null;
  }

  private void b(int paramInt, List<aa> paramList)
  {
    int i1 = b.get(paramInt, -1);
    if (i1 < 0)
      return;
    Iterator localIterator = paramList.iterator();
    label22: label173: 
    while (true)
    {
      aa localaa;
      int i2;
      long l1;
      com.viber.voip.banner.d.d locald;
      if (localIterator.hasNext())
      {
        localaa = (aa)localIterator.next();
        i2 = localaa.r().toStickerId();
        l1 = localaa.b();
        locald = this.i.a(com.viber.voip.banner.d.g.c, Long.toString(l1), i2);
        if (locald != null)
          if (com.viber.voip.util.av.c(locald.g(), i1));
      }
      else
      {
        for (int i3 = 1; ; i3 = 0)
        {
          if (i3 == 0)
            break label173;
          StickerClickerMetaInfoItem localStickerClickerMetaInfoItem = com.viber.voip.banner.e.a.c(locald.c());
          if (localStickerClickerMetaInfoItem == null)
            break label22;
          a(paramInt, localStickerClickerMetaInfoItem);
          this.i.a(com.viber.voip.banner.d.g.c, i2, Long.toString(l1), i1, true);
          this.h.a(localaa.b(), localaa.y(), false);
          break label22;
          break;
        }
      }
    }
  }

  private void b(long paramLong, int paramInt, a parama)
  {
    a("Ad request");
    Uri localUri = this.m.b(paramInt);
    q.a locala = this.l.a(localUri);
    switch (locala.b)
    {
    default:
      a(4, false);
      parama.a(false);
      ((com.viber.voip.ads.h)this.o.get()).a(4, 14);
      return;
    case 0:
      com.viber.voip.h.a.b().post(new a.a(0, paramLong, paramInt, locala.a, false, ""));
      a("Ad response");
      parama.a(true);
      ((com.viber.voip.ads.h)this.o.get()).a(100, 14);
      return;
    case 1:
    }
    a(2, false);
    parama.a(false);
    ((com.viber.voip.ads.h)this.o.get()).a(3, 14);
  }

  private void c()
  {
    SDKSettings.setAAIDEnabled(d.f.d.d());
  }

  private void c(final long paramLong, int paramInt, final a parama)
  {
    NativeAdRequestListener local5 = new NativeAdRequestListener()
    {
      public void onAdFailed(ResultCode paramAnonymousResultCode)
      {
        b.d(b.this).post(new f(this, paramAnonymousResultCode, paramLong, parama, this.c));
      }

      public void onAdLoaded(NativeAdResponse paramAnonymousNativeAdResponse)
      {
        b.d(b.this).post(new e(this, paramLong, parama, paramAnonymousNativeAdResponse, this.c));
      }
    };
    if (!com.viber.common.d.a.g())
      CookieSyncManager.createInstance(ViberApplication.getApplication());
    com.viber.voip.util.k.a.a(this.p);
    NativeAdRequest localNativeAdRequest = new NativeAdRequest(ViberApplication.getApplication(), this.q);
    this.r = localNativeAdRequest;
    localNativeAdRequest.setListener(local5);
    localNativeAdRequest.addCustomKeywords("viber_version", p.d());
    localNativeAdRequest.addCustomKeywords("sticker_id", Integer.toString(paramInt));
    localNativeAdRequest.addCustomKeywords("sticker_pack_id", Integer.toString(com.viber.voip.stickers.c.g.f(paramInt)));
    if (d.f.d.d())
      localNativeAdRequest.addCustomKeywords("advertising_id", ax.a());
    localNativeAdRequest.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAppNexusGender());
    Calendar localCalendar = com.viber.voip.util.k.a.b();
    if (localCalendar != null)
      localNativeAdRequest.setAge(String.valueOf(localCalendar.get(1)));
    if (localNativeAdRequest.loadAd())
      return;
    parama.a(false);
  }

  private void c(Context paramContext, aa paramaa, int paramInt)
  {
    if (!cj.c(paramContext));
    StickerClickerMetaInfoItem localStickerClickerMetaInfoItem;
    Uri localUri;
    do
    {
      do
      {
        com.viber.voip.banner.d.d locald;
        do
        {
          return;
          int i1 = paramaa.r().toStickerId();
          locald = this.i.a(com.viber.voip.banner.d.g.c, Long.toString(paramaa.b()), i1);
        }
        while (locald == null);
        a(2, Collections.singletonList(paramaa));
        localStickerClickerMetaInfoItem = com.viber.voip.banner.e.a.c(locald.c());
      }
      while (da.a(localStickerClickerMetaInfoItem.getClickerUrl()));
      localUri = Uri.parse(localStickerClickerMetaInfoItem.getClickerUrl());
      if (dk.g(localUri))
      {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", localUri));
        return;
      }
    }
    while (!dk.f(localUri));
    StickerClickerWebViewActivity.a(paramContext, localUri, localStickerClickerMetaInfoItem);
  }

  private Set<String> d()
  {
    if (this.f == null)
      this.f = new HashSet(Arrays.asList(d.ax.q.d().split(",")));
    return this.f;
  }

  private void e()
  {
    this.f = null;
  }

  public void a(final int paramInt, final List<aa> paramList)
  {
    this.j.post(new Runnable()
    {
      public void run()
      {
        b.a(b.this, paramInt, paramList);
      }
    });
  }

  public void a(Context paramContext, aa paramaa, int paramInt)
  {
    this.j.post(new c(this, paramContext, paramaa, paramInt));
  }

  public void a(aa paramaa, ImageView paramImageView, com.viber.voip.util.e.f paramf, h.a parama)
  {
    this.d.a(Uri.parse(paramaa.I()), paramImageView, paramf, parama);
  }

  public void a(List<aa> paramList)
  {
    final ArrayList localArrayList = new ArrayList(paramList.size());
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      aa localaa = (aa)paramList.get(0);
      b localb = new b(localaa.r().toStickerId(), localaa.b());
      if (!this.g.contains(localb))
      {
        this.g.add(localb);
        localArrayList.add(localaa);
      }
    }
    if (localArrayList.isEmpty())
      return;
    this.j.post(new Runnable()
    {
      public void run()
      {
        for (int i = 0; ; i++)
        {
          aa localaa;
          long l;
          int j;
          b.b localb;
          if (i < localArrayList.size())
          {
            localaa = (aa)localArrayList.get(0);
            l = localaa.b();
            j = localaa.r().toStickerId();
            localb = new b.b(b.this, j, l);
            if (b.a(b.this, l, j))
              b.f(b.this).remove(localb);
          }
          else
          {
            return;
          }
          d locald = new d(this, localaa, l, localb);
          b.a(b.this, l, j, locald);
        }
      }
    });
  }

  public boolean a(aa paramaa)
  {
    return (c(paramaa)) && (paramaa.ai());
  }

  public boolean a(MessageEntity paramMessageEntity)
  {
    boolean bool1 = paramMessageEntity.isSticker();
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = paramMessageEntity.isSecretMessage();
      bool2 = false;
      if (!bool3)
      {
        int i1 = paramMessageEntity.getConversationType();
        bool2 = false;
        if (i1 != 3)
          if (!ab_())
          {
            boolean bool4 = d().contains(Integer.toString(com.viber.voip.stickers.c.g.f(paramMessageEntity.getObjectId().toStickerId())));
            bool2 = false;
            if (!bool4);
          }
          else
          {
            bool2 = true;
          }
      }
    }
    return bool2;
  }

  public boolean ab_()
  {
    return (c.b.e.e()) && (this.e.a(com.viber.voip.ads.b.b.b.c.f) != 0);
  }

  public s b()
  {
    return this.k;
  }

  public boolean c(aa paramaa)
  {
    boolean bool1 = paramaa.ag();
    boolean bool2 = false;
    if (!bool1)
    {
      int i1 = paramaa.A();
      bool2 = false;
      if (i1 != 3)
        if (!paramaa.aq())
        {
          boolean bool4 = paramaa.ao();
          bool2 = false;
          if (!bool4);
        }
        else if (!ab_())
        {
          boolean bool3 = d().contains(Integer.toString(com.viber.voip.stickers.c.g.f(paramaa.bn().id)));
          bool2 = false;
          if (!bool3);
        }
        else
        {
          bool2 = true;
        }
    }
    return bool2;
  }

  private static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }

  private class b
  {
    private int b;
    private long c;

    public b(int paramLong, long arg3)
    {
      this.b = paramLong;
      Object localObject;
      this.c = localObject;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      b localb;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localb = (b)paramObject;
      }
      while ((this.b == localb.b) && (this.c == localb.c));
      return false;
    }

    public int hashCode()
    {
      return 31 * this.b + (int)(this.c ^ this.c >>> 32);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.a.b
 * JD-Core Version:    0.6.2
 */