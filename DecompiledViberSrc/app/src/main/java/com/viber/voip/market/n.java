package com.viber.voip.market;

import android.app.Application;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.ProductId;
import com.viber.voip.billing.b.g;
import com.viber.voip.billing.b.j;
import com.viber.voip.billing.l;
import com.viber.voip.i.c.j;
import com.viber.voip.market.b.c;
import com.viber.voip.market.b.e;
import com.viber.voip.market.b.i.a;
import com.viber.voip.market.b.q;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.registration.o;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.v;
import com.viber.voip.settings.d.z;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.dd;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.ViberOutDialogs;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private com.viber.voip.stickers.e.b c = new com.viber.voip.stickers.e.b()
  {
    private ProductId a(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      return ProductId.fromStickerPackageId(paramAnonymousa.e());
    }

    private void a(final com.viber.voip.stickers.entity.a paramAnonymousa, final MarketApi.k paramAnonymousk)
    {
      dd.a(new Runnable()
      {
        public void run()
        {
          if (n.a(n.this) != null)
            n.a(n.this).a(n.1.a(n.1.this, paramAnonymousa), paramAnonymousk);
        }
      });
    }

    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
    }

    public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a(paramAnonymousa, MarketApi.k.e);
    }

    public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      if (paramAnonymousBoolean);
      for (MarketApi.k localk = MarketApi.k.b; ; localk = MarketApi.k.c)
      {
        a(paramAnonymousa, localk);
        return;
      }
    }

    public void onStickerPackageDownloadScheduled(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a(paramAnonymousa, MarketApi.k.c);
    }

    public void onStickerPackageDownloadStarted(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      a(paramAnonymousa, MarketApi.k.d);
    }

    public void onStickerPackageDownloading(com.viber.voip.stickers.entity.a paramAnonymousa, int paramAnonymousInt)
    {
    }
  };
  private final MarketApi d = MarketApi.a();

  public n()
  {
    com.viber.voip.stickers.i.a().a(this.c);
  }

  private int a(ViberWebApiActivity.b paramb)
  {
    int i = 1000;
    com.viber.common.b.d locald;
    int j;
    switch (9.a[paramb.ordinal()])
    {
    default:
      locald = null;
      j = 0;
      if (locald == null)
        break label155;
      j = locald.d();
      if (j < i)
      {
        i = j + 1;
        locald.a(i);
      }
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (j > i)
    {
      return i;
      locald = d.z.f;
      break;
      locald = d.z.g;
      break;
      locald = d.z.h;
      break;
      locald = d.z.i;
      break;
      locald = d.z.j;
      break;
      locald = d.z.k;
      break;
      locald = d.z.l;
      break;
      locald = d.z.m;
      break;
    }
    label155: return j;
  }

  private JSONObject a(String paramString1, String paramString2, ViberWebApiActivity.b paramb)
  {
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    af localaf = UserManager.from(localApplication).getRegistrationValues();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", p.d());
      localJSONObject.put("system", o.b());
      localJSONObject.put("language", Locale.getDefault());
      localJSONObject.put("country", localaf.e());
      localJSONObject.put("mcc", localViberApplication.getHardwareParameters().getMCC());
      localJSONObject.put("mnc", localViberApplication.getHardwareParameters().getMNC());
      localJSONObject.put("sim_mcc", localViberApplication.getHardwareParameters().getSimMCC());
      localJSONObject.put("sim_mnc", localViberApplication.getHardwareParameters().getSimMNC());
      localJSONObject.put("phone_prefix", localaf.i());
      localJSONObject.put("visit_count", a(paramb));
      localJSONObject.put("sponsored_api_ver", "1");
      localJSONObject.put("api_ver", "2");
      localJSONObject.put("open_market", paramString2);
      localJSONObject.put("inapp_support", "1");
      localJSONObject.put("vo_api_version", "2");
      localJSONObject.put("store", l.d());
      localJSONObject.put("keyboard_languages", new JSONArray(dj.j(localApplication)));
      localJSONObject.put("sticker_cluster_id", d.ax.t.d());
      localJSONObject.put("public_chats_support", d.ap.d.d());
      localJSONObject.put("google_ad_id", paramString1);
      String str = d.z.n.d();
      if (!TextUtils.isEmpty(str))
        localJSONObject.put("web_flags", str);
      localJSONObject.put("privacy_flags", com.viber.voip.gdpr.d.a());
      Set localSet = r.a();
      if (!localSet.isEmpty())
        localJSONObject.put("supported_features", new JSONArray(localSet));
      if (c.j.a.e())
        localJSONObject.put("euconsent", d.v.q.d());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public void a()
  {
    com.viber.voip.stickers.i.a().b(this.c);
  }

  public void a(int paramInt, MarketApi.f paramf)
  {
    new e().a(paramInt, paramf);
  }

  public void a(IabProductId paramIabProductId, String paramString)
  {
    this.d.a(paramIabProductId, paramString);
  }

  public void a(ProductId paramProductId, final MarketApi.l paraml)
  {
    this.d.a(paramProductId, new MarketApi.l()
    {
      public void a(final ProductId paramAnonymousProductId, final MarketApi.k paramAnonymousk)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            n.3.this.a.a(paramAnonymousProductId, paramAnonymousk);
          }
        });
      }
    });
  }

  public void a(ProductId paramProductId, String paramString)
  {
    this.d.a(paramProductId, paramString);
  }

  public void a(ProductId paramProductId, String paramString, final MarketApi.m paramm)
  {
    com.viber.voip.billing.b.a().a(paramProductId, paramString, new MarketApi.m()
    {
      public void a(final String paramAnonymousString)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            n.6.this.a.a(paramAnonymousString);
          }
        });
      }
    });
  }

  public void a(MarketApi.b paramb)
  {
    new c().a(paramb);
  }

  public void a(final MarketApi.d paramd, final String paramString1, final String paramString2, final ViberWebApiActivity.b paramb)
  {
    dd.a(new Runnable()
    {
      public void run()
      {
        paramd.a(n.a(n.this, paramString1, paramString2, paramb));
      }
    });
  }

  public void a(final MarketApi.h paramh)
  {
    MarketApi.a().a(new MarketApi.h()
    {
      public void a(final MarketApi.UserProduct[] paramAnonymousArrayOfUserProduct)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            n.8.this.a.a(paramAnonymousArrayOfUserProduct);
          }
        });
      }
    });
  }

  public void a(final MarketApi.i parami)
  {
    new com.viber.voip.market.b.g().a(new MarketApi.i()
    {
      public void a(final ArrayList<MarketApi.UserPublicGroupInfo> paramAnonymousArrayList)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            n.5.this.a.a(paramAnonymousArrayList);
          }
        });
      }
    });
  }

  public void a(MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    new q().b(paramMarketPublicGroupInfo);
  }

  public void a(i.a parama, int paramInt)
  {
    new com.viber.voip.market.b.i().a(parama, paramInt);
  }

  public void a(a parama)
  {
    this.b = parama;
  }

  public void a(String paramString)
  {
    ViberOutDialogs.a(paramString);
    com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.h.c());
  }

  public void a(String paramString1, String paramString2)
  {
    new com.viber.voip.market.b.n().a(paramString1, paramString2);
  }

  public void a(ArrayList<String> paramArrayList, final MarketApi.e parame)
  {
    com.viber.voip.billing.b.a().a(new b.g(paramArrayList), new b.j()
    {
      public void a(b.g paramAnonymousg)
      {
        com.viber.voip.billing.f[] arrayOff = paramAnonymousg.d();
        final MarketApi.ExtendedProductInfo[] arrayOfExtendedProductInfo = new MarketApi.ExtendedProductInfo[arrayOff.length];
        for (int i = 0; i < arrayOff.length; i++)
        {
          com.viber.voip.billing.f localf = arrayOff[i];
          arrayOfExtendedProductInfo[i] = new MarketApi.ExtendedProductInfo(localf.b(), MarketApi.k.b, localf.a(), (float)localf.e(), localf.d());
        }
        dd.a(new Runnable()
        {
          public void run()
          {
            n.7.this.a.a(arrayOfExtendedProductInfo);
          }
        });
      }
    });
  }

  public void a(ArrayList<IabProductId> paramArrayList, final MarketApi.j paramj)
  {
    this.d.a((IabProductId[])paramArrayList.toArray(new IabProductId[paramArrayList.size()]), new MarketApi.j()
    {
      public void a(final MarketApi.ProductInfo[] paramAnonymousArrayOfProductInfo)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            n.2.this.a.a(paramAnonymousArrayOfProductInfo);
          }
        });
      }
    });
  }

  public String b()
  {
    return com.viber.voip.billing.b.a().c();
  }

  public void b(ProductId paramProductId, String paramString)
  {
    this.d.b(paramProductId, paramString);
  }

  public void b(MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    new com.viber.voip.market.b.a().a(paramMarketPublicGroupInfo, true, true, ae.d);
  }

  public void c(MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    new com.viber.voip.market.b.a().a(paramMarketPublicGroupInfo, false, false, ae.d);
  }

  public static abstract interface a
  {
    public abstract void a(ProductId paramProductId, MarketApi.k paramk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.n
 * JD-Core Version:    0.6.2
 */