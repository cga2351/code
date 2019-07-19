package com.viber.voip.market;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.appnexus.opensdk.AdView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.Carrier;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.ProductId;
import com.viber.voip.billing.l;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.invitelinks.a;
import com.viber.voip.invitelinks.ad;
import com.viber.voip.market.b.i.a;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.extras.b.d.c;
import com.viber.voip.messages.k;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.bk;
import com.viber.voip.util.ax;
import com.viber.voip.viberout.ui.ViberOutDialogsLegacy;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends s
  implements n.a
{
  private static final Logger b = ViberEnv.getLogger();
  private Handler c = av.a(av.e.a);
  private n d;
  private e e;
  private Activity f;
  private final c g = new c();
  private final a h = new a();
  private final d i = new d();
  private final boolean j;
  private final ViberWebApiActivity.b k;
  private final com.viber.voip.messages.controller.manager.o l;
  private final PhoneController m;
  private final GroupController n;
  private final ab o;
  private final Handler p;
  private final o q;

  public b(Activity paramActivity, n paramn, e parame, boolean paramBoolean, ViberWebApiActivity.b paramb)
  {
    super("Market", parame);
    this.f = paramActivity;
    this.e = parame;
    this.d = paramn;
    this.d.a(this);
    this.j = paramBoolean;
    this.k = paramb;
    this.l = com.viber.voip.messages.controller.manager.o.a();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    this.m = localViberApplication.getEngine(false).getPhoneController();
    this.n = localViberApplication.getMessagesManager().d();
    this.o = ab.b();
    this.p = av.a(av.e.d);
    parame.a(new b(null), "App");
    com.viber.voip.messages.controller.manager.o.a().a(this.g);
    ViberApplication.getInstance().getEngine(false).registerDelegate(this.h);
    this.q = o.a(paramActivity, av.a(av.e.a), this.m);
    this.q.a(this.i);
  }

  private void a(ProductId paramProductId, int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramProductId.toString();
    arrayOfObject[1] = Integer.valueOf(paramInt);
    a("onProductStatusChanged", arrayOfObject);
  }

  private void a(Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }

  private void a(String paramString)
  {
    a("onGetSponsoredInfo", new Object[] { paramString });
  }

  private void a(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("group_id", paramString);
      localJSONObject.put("status", paramInt);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONObject.toString();
      a("onFollowPublicGroup", arrayOfObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void a(ArrayList<MarketApi.UserPublicGroupInfo> paramArrayList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    while (true)
    {
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          MarketApi.UserPublicGroupInfo localUserPublicGroupInfo = (MarketApi.UserPublicGroupInfo)localIterator.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("group_id", Long.toString(localUserPublicGroupInfo.groupId, 10));
          if (localUserPublicGroupInfo.role != 3)
            break label154;
          i1 = 1;
          localJSONObject2.put("membership", i1);
          localJSONObject2.put("name", localUserPublicGroupInfo.groupName);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        localJSONObject1.put("groups", localJSONArray);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localJSONObject1.toString();
        a("onGetUserPublicGroups", arrayOfObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        return;
      }
      label154: int i1 = 2;
    }
  }

  private void a(JSONObject paramJSONObject)
  {
    a("onGetClientInfo", new Object[] { paramJSONObject });
  }

  private void a(MarketApi.AppStatusInfo[] paramArrayOfAppStatusInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int i2 = paramArrayOfAppStatusInfo.length;
      while (i1 < i2)
      {
        MarketApi.AppStatusInfo localAppStatusInfo = paramArrayOfAppStatusInfo[i1];
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", localAppStatusInfo.appId);
        localJSONObject2.put("status", localAppStatusInfo.appStatus.ordinal());
        localJSONArray.put(localJSONObject2);
        i1++;
      }
      localJSONObject1.put("app", localJSONArray);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONObject1.toString();
      a("onGetAppsStatus", arrayOfObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void a(MarketApi.ExtendedProductInfo[] paramArrayOfExtendedProductInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int i2 = paramArrayOfExtendedProductInfo.length;
      while (true)
      {
        if (i1 < i2)
        {
          MarketApi.ExtendedProductInfo localExtendedProductInfo = paramArrayOfExtendedProductInfo[i1];
          if (localExtendedProductInfo.priceString != null)
            localJSONArray.put(localExtendedProductInfo.toJson());
        }
        else
        {
          localJSONObject.put("products", localJSONArray);
          a("onGetVOProductsInfo", new Object[] { localJSONObject });
          return;
        }
        i1++;
      }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void a(MarketApi.ProductInfo[] paramArrayOfProductInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int i2 = paramArrayOfProductInfo.length;
      while (i1 < i2)
      {
        MarketApi.ProductInfo localProductInfo = paramArrayOfProductInfo[i1];
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", localProductInfo.id.toString());
        if (localProductInfo.priceString != null)
          localJSONObject2.put("price_string", localProductInfo.priceString);
        localJSONObject2.put("status", localProductInfo.status.ordinal());
        localJSONArray.put(localJSONObject2);
        i1++;
      }
      localJSONObject1.put("products", localJSONArray);
      a("onGetProductsInfo", new Object[] { localJSONObject1 });
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void a(MarketApi.UserProduct[] paramArrayOfUserProduct)
  {
    int i1 = 0;
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int i2 = paramArrayOfUserProduct.length;
      while (i1 < i2)
      {
        MarketApi.UserProduct localUserProduct = paramArrayOfUserProduct[i1];
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("product_id", localUserProduct.productId.getStringId());
        localJSONObject.put("status", localUserProduct.status.ordinal());
        localJSONObject.put("android_status", localUserProduct.androidStatus);
        localJSONArray.put(localJSONObject);
        i1++;
      }
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONArray.toString();
      a("onGetUserProducts", arrayOfObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void b(ProductId paramProductId, int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramProductId.toString();
    arrayOfObject[1] = Integer.valueOf(paramInt);
    a("onGetProductStatus", arrayOfObject);
  }

  private void b(String paramString)
  {
    a("onGetGeoLocation", new Object[] { paramString });
  }

  private void b(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("group_id", paramString);
      localJSONObject.put("status", paramInt);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONObject.toString();
      a("onUnfollowPublicGroup", arrayOfObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void b(MarketApi.ExtendedProductInfo[] paramArrayOfExtendedProductInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      int i2 = paramArrayOfExtendedProductInfo.length;
      while (true)
      {
        if (i1 < i2)
        {
          MarketApi.ExtendedProductInfo localExtendedProductInfo = paramArrayOfExtendedProductInfo[i1];
          if (localExtendedProductInfo.priceString != null)
            localJSONArray.put(localExtendedProductInfo.toJson());
        }
        else
        {
          localJSONObject.put("products", localJSONArray);
          a("onGetExtendedProductsInfo", new Object[] { localJSONObject });
          return;
        }
        i1++;
      }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void c(String paramString)
  {
    a("onCloseAd", new Object[] { paramString });
  }

  private void c(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("community_id", paramString);
      localJSONObject.put("status", paramInt);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONObject.toString();
      a("onFollowCommunity", arrayOfObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void d(String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    a("onShowAd", arrayOfObject);
  }

  public void a()
  {
    com.viber.voip.messages.controller.manager.o.a().b(this.g);
    ViberApplication.getInstance().getEngine(false).removeDelegate(this.h);
    this.q.b(this.i);
  }

  public void a(ProductId paramProductId, MarketApi.k paramk)
  {
    a(paramProductId, paramk.ordinal());
  }

  class a extends PhoneControllerDelegateAdapter
  {
    a()
    {
    }

    private int a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return 0;
      case 1:
        return 1;
      case 2:
      }
      return 2;
    }

    public void onGroupLeave(final long paramLong1, long paramLong2, int paramInt)
    {
      int i = a(paramInt);
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this, Long.toString(paramLong1, 10), this.b);
        }
      });
    }
  }

  private class b
  {
    private b()
    {
    }

    private ArrayList<String> b(String paramString)
    {
      ArrayList localArrayList;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = localJSONArray.length();
        localArrayList = new ArrayList(i);
        for (int j = 0; j < i; j++)
          localArrayList.add(localJSONArray.getJSONObject(j).toString());
      }
      catch (JSONException localJSONException)
      {
        localArrayList = null;
      }
      return localArrayList;
    }

    @JavascriptInterface
    public void abortAd(String paramString)
    {
      b.a(b.this, new d(this, paramString));
    }

    @JavascriptInterface
    public void countriesSelect()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this).i();
        }
      });
    }

    @JavascriptInterface
    public void downloadProduct(String paramString)
    {
      downloadProduct(paramString, null);
    }

    @JavascriptInterface
    public void downloadProduct(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ProductId localProductId = ProductId.fromString(paramString1);
          b.a(b.this).a(localProductId, paramString2);
        }
      });
    }

    @JavascriptInterface
    public void followCommunity(final String paramString1, String paramString2)
    {
      CommunityFollowerData localCommunityFollowerData = new CommunityFollowerData(Long.parseLong(paramString1, 10), "", null, null, 0L, null, 0, 4, 2);
      g.a().c().g().a(Long.parseLong(paramString1, 10), "Download and Join");
      new a(b.e(b.this), b.f(b.this), b.g(b.this), b.h(b.this), b.i(b.this), b.j(b.this), localCommunityFollowerData)
      {
        protected void a(int paramAnonymousInt)
        {
          b.a(b.this, new Runnable()
          {
            public void run()
            {
              b.c(b.this, b.b.8.this.h, 0);
            }
          });
        }

        protected void b(com.viber.voip.model.entity.h paramAnonymoush)
        {
          d();
        }

        protected void c()
        {
          b.a(b.this, new Runnable()
          {
            public void run()
            {
              b.c(b.this, b.b.8.this.h, 1);
            }
          });
        }

        protected void d()
        {
          b.a(b.this, new Runnable()
          {
            public void run()
            {
              b.c(b.this, b.b.8.this.h, 2);
            }
          });
        }
      }
      .h();
    }

    @JavascriptInterface
    public void followPublicGroup(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            MarketPublicGroupInfo localMarketPublicGroupInfo = new MarketPublicGroupInfo(paramString1, paramString2);
            b.a(b.this).b(localMarketPublicGroupInfo);
            return;
          }
          catch (JSONException localJSONException)
          {
            b.a(b.this, new Runnable()
            {
              public void run()
              {
                b.a(b.this, b.b.6.this.a, 0);
              }
            });
          }
        }
      });
    }

    @JavascriptInterface
    public void getAppsStatus()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a(new MarketApi.b()
          {
            public void a(MarketApi.AppStatusInfo[] paramAnonymous2ArrayOfAppStatusInfo)
            {
              b.a(b.this, paramAnonymous2ArrayOfAppStatusInfo);
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getClientInfo()
    {
      av.a(av.e.f).post(new Runnable()
      {
        public void run()
        {
          String str1 = ax.a();
          n localn = b.a(b.this);
          MarketApi.d local1 = new MarketApi.d()
          {
            public void a(JSONObject paramAnonymous2JSONObject)
            {
              b.a(b.this, paramAnonymous2JSONObject);
            }
          };
          if (b.c(b.this));
          for (String str2 = "1"; ; str2 = "0")
          {
            localn.a(local1, str1, str2, b.d(b.this));
            return;
          }
        }
      });
    }

    @JavascriptInterface
    public void getContactListDestinations(final int paramInt)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a(paramInt, new MarketApi.f()
          {
            public void a(String paramAnonymous2String)
            {
              b.this.a("onGetContactListDestinations", new Object[] { paramAnonymous2String });
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getExtendedProductsInfo(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        // ERROR //
        public void run()
        {
          // Byte code:
          //   0: new 31	java/util/ArrayList
          //   3: dup
          //   4: invokespecial 32	java/util/ArrayList:<init>	()V
          //   7: astore_1
          //   8: new 34	org/json/JSONArray
          //   11: dup
          //   12: aload_0
          //   13: getfield 21	com/viber/voip/market/b$b$2:a	Ljava/lang/String;
          //   16: invokespecial 36	org/json/JSONArray:<init>	(Ljava/lang/String;)V
          //   19: astore_2
          //   20: iconst_0
          //   21: istore_3
          //   22: aload_2
          //   23: invokevirtual 40	org/json/JSONArray:length	()I
          //   26: istore 5
          //   28: iload_3
          //   29: iload 5
          //   31: if_icmpge +21 -> 52
          //   34: aload_1
          //   35: aload_2
          //   36: iload_3
          //   37: invokevirtual 44	org/json/JSONArray:getString	(I)Ljava/lang/String;
          //   40: invokevirtual 48	java/util/ArrayList:add	(Ljava/lang/Object;)Z
          //   43: pop
          //   44: iinc 3 1
          //   47: goto -25 -> 22
          //   50: astore 4
          //   52: aload_1
          //   53: invokevirtual 51	java/util/ArrayList:size	()I
          //   56: ifle +26 -> 82
          //   59: aload_0
          //   60: getfield 19	com/viber/voip/market/b$b$2:b	Lcom/viber/voip/market/b$b;
          //   63: getfield 54	com/viber/voip/market/b$b:a	Lcom/viber/voip/market/b;
          //   66: invokestatic 59	com/viber/voip/market/b:a	(Lcom/viber/voip/market/b;)Lcom/viber/voip/market/n;
          //   69: aload_1
          //   70: new 61	com/viber/voip/market/b$b$2$1
          //   73: dup
          //   74: aload_0
          //   75: invokespecial 64	com/viber/voip/market/b$b$2$1:<init>	(Lcom/viber/voip/market/b$b$2;)V
          //   78: invokevirtual 69	com/viber/voip/market/n:a	(Ljava/util/ArrayList;Lcom/viber/voip/market/MarketApi$e;)V
          //   81: return
          //   82: aload_0
          //   83: getfield 19	com/viber/voip/market/b$b$2:b	Lcom/viber/voip/market/b$b;
          //   86: getfield 54	com/viber/voip/market/b$b:a	Lcom/viber/voip/market/b;
          //   89: iconst_0
          //   90: anewarray 71	com/viber/voip/market/MarketApi$ExtendedProductInfo
          //   93: invokestatic 74	com/viber/voip/market/b:a	(Lcom/viber/voip/market/b;[Lcom/viber/voip/market/MarketApi$ExtendedProductInfo;)V
          //   96: return
          //   97: astore 6
          //   99: goto -55 -> 44
          //
          // Exception table:
          //   from	to	target	type
          //   8	20	50	org/json/JSONException
          //   22	28	50	org/json/JSONException
          //   34	44	50	org/json/JSONException
          //   34	44	97	java/lang/IllegalArgumentException
        }
      });
    }

    @JavascriptInterface
    public void getGeoLocation(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            int i = new JSONObject(paramString).getInt("timeout_ms");
            b.a(b.this).a(new i.a()
            {
              public void a(Location paramAnonymous2Location, d.c paramAnonymous2c)
              {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("status", paramAnonymous2c.ordinal());
                  if (paramAnonymous2Location != null)
                  {
                    localJSONObject.put("lat", String.valueOf(paramAnonymous2Location.getLatitude()));
                    localJSONObject.put("lon", String.valueOf(paramAnonymous2Location.getLongitude()));
                  }
                  b.b(b.this, localJSONObject.toString());
                  return;
                }
                catch (JSONException localJSONException)
                {
                }
              }
            }
            , i);
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }

    @JavascriptInterface
    public void getProductStatus(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ProductId localProductId = ProductId.fromString(paramString);
          b.a(b.this).a(localProductId, new MarketApi.l()
          {
            public void a(ProductId paramAnonymous2ProductId, MarketApi.k paramAnonymous2k)
            {
              b.a(b.this, paramAnonymous2ProductId, paramAnonymous2k.ordinal());
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getProductsInfo(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = new ArrayList();
          try
          {
            localJSONArray = new JSONArray(paramString);
            i = 0;
            int k = localJSONArray.length();
            if (i >= k);
          }
          catch (JSONException localJSONException)
          {
            try
            {
              while (true)
              {
                JSONArray localJSONArray;
                int i;
                localArrayList.add(IabProductId.fromString(localJSONArray.getString(i)));
                label47: i++;
              }
              localJSONException = localJSONException;
              String[] arrayOfString = paramString.split(",");
              int j = 0;
              while (true)
              {
                if (j < arrayOfString.length);
                try
                {
                  localArrayList.add(IabProductId.fromString(arrayOfString[j]));
                  label90: j++;
                  continue;
                  if (localArrayList.size() > 0)
                  {
                    b.a(b.this).a(localArrayList, new MarketApi.j()
                    {
                      public void a(MarketApi.ProductInfo[] paramAnonymous2ArrayOfProductInfo)
                      {
                        b.a(b.this, paramAnonymous2ArrayOfProductInfo);
                      }
                    });
                    return;
                  }
                  b.a(b.this, new MarketApi.ProductInfo[0]);
                  return;
                }
                catch (IllegalArgumentException localIllegalArgumentException1)
                {
                  break label90;
                }
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException2)
            {
              break label47;
            }
          }
        }
      });
    }

    @JavascriptInterface
    public void getSponsoredInfo(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ProductId localProductId = ProductId.fromString(paramString1);
          b.a(b.this).a(localProductId, paramString2, new MarketApi.m()
          {
            public void a(String paramAnonymous2String)
            {
              b.a(b.this, paramAnonymous2String);
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getUserProducts()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a(new MarketApi.h()
          {
            public void a(MarketApi.UserProduct[] paramAnonymous2ArrayOfUserProduct)
            {
              b.a(b.this, paramAnonymous2ArrayOfUserProduct);
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getUserPublicGroups()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a(new MarketApi.i()
          {
            public void a(ArrayList<MarketApi.UserPublicGroupInfo> paramAnonymous2ArrayList)
            {
              b.a(b.this, paramAnonymous2ArrayList);
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void getVOProductsInfo(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        // ERROR //
        public void run()
        {
          // Byte code:
          //   0: new 31	java/util/ArrayList
          //   3: dup
          //   4: invokespecial 32	java/util/ArrayList:<init>	()V
          //   7: astore_1
          //   8: new 34	org/json/JSONArray
          //   11: dup
          //   12: aload_0
          //   13: getfield 21	com/viber/voip/market/b$b$15:a	Ljava/lang/String;
          //   16: invokespecial 36	org/json/JSONArray:<init>	(Ljava/lang/String;)V
          //   19: astore_2
          //   20: iconst_0
          //   21: istore_3
          //   22: aload_2
          //   23: invokevirtual 40	org/json/JSONArray:length	()I
          //   26: istore 5
          //   28: iload_3
          //   29: iload 5
          //   31: if_icmpge +21 -> 52
          //   34: aload_1
          //   35: aload_2
          //   36: iload_3
          //   37: invokevirtual 44	org/json/JSONArray:getString	(I)Ljava/lang/String;
          //   40: invokevirtual 48	java/util/ArrayList:add	(Ljava/lang/Object;)Z
          //   43: pop
          //   44: iinc 3 1
          //   47: goto -25 -> 22
          //   50: astore 4
          //   52: aload_1
          //   53: invokevirtual 51	java/util/ArrayList:size	()I
          //   56: ifle +26 -> 82
          //   59: aload_0
          //   60: getfield 19	com/viber/voip/market/b$b$15:b	Lcom/viber/voip/market/b$b;
          //   63: getfield 54	com/viber/voip/market/b$b:a	Lcom/viber/voip/market/b;
          //   66: invokestatic 59	com/viber/voip/market/b:a	(Lcom/viber/voip/market/b;)Lcom/viber/voip/market/n;
          //   69: aload_1
          //   70: new 61	com/viber/voip/market/b$b$15$1
          //   73: dup
          //   74: aload_0
          //   75: invokespecial 64	com/viber/voip/market/b$b$15$1:<init>	(Lcom/viber/voip/market/b$b$15;)V
          //   78: invokevirtual 69	com/viber/voip/market/n:a	(Ljava/util/ArrayList;Lcom/viber/voip/market/MarketApi$e;)V
          //   81: return
          //   82: aload_0
          //   83: getfield 19	com/viber/voip/market/b$b$15:b	Lcom/viber/voip/market/b$b;
          //   86: getfield 54	com/viber/voip/market/b$b:a	Lcom/viber/voip/market/b;
          //   89: iconst_0
          //   90: anewarray 71	com/viber/voip/market/MarketApi$ExtendedProductInfo
          //   93: invokestatic 74	com/viber/voip/market/b:b	(Lcom/viber/voip/market/b;[Lcom/viber/voip/market/MarketApi$ExtendedProductInfo;)V
          //   96: return
          //   97: astore 6
          //   99: goto -55 -> 44
          //
          // Exception table:
          //   from	to	target	type
          //   8	20	50	org/json/JSONException
          //   22	28	50	org/json/JSONException
          //   34	44	50	org/json/JSONException
          //   34	44	97	java/lang/IllegalArgumentException
        }
      });
    }

    @JavascriptInterface
    public void log(String paramString)
    {
    }

    @JavascriptInterface
    public void openApp(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a(paramString, null);
        }
      });
    }

    @JavascriptInterface
    public void openAppEx(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramString);
            String str1 = localJSONObject.getString("app_id");
            String str2 = localJSONObject.optString("origin", null);
            b.a(b.this).a(str1, str2);
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }

    @JavascriptInterface
    public void openBrowser(String paramString)
    {
      Uri localUri = Uri.parse(paramString);
      if (com.viber.voip.api.scheme.e.w.a(localUri, com.viber.voip.api.scheme.e.s))
        localUri = localUri.buildUpon().appendQueryParameter("openHome", Boolean.FALSE.toString()).build();
      b.e(b.this).startActivity(new Intent("android.intent.action.VIEW", localUri));
    }

    @JavascriptInterface
    public void openBrowserAndExit(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this).g();
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
          b.e(b.this).startActivity(localIntent);
        }
      });
    }

    @JavascriptInterface
    public void openMarketPurchaseDialog(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          StickerPurchaseDialogActivity.d(paramString);
        }
      });
    }

    @JavascriptInterface
    public void openVOMoreScreen()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.e(b.this).finish();
          Intent localIntent = ViberActionRunner.bk.a(b.e(b.this), "Web page Dialog (Get Credits)", null);
          localIntent.setFlags(536870912);
          b.e(b.this).startActivity(localIntent);
        }
      });
    }

    @JavascriptInterface
    public void openVOPurchaseDialog(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.e(b.this).finish();
          if (ViberOutDialogsLegacy.a())
          {
            ViberOutDialogsLegacy.b();
            return;
          }
          VOPurchaseDialogActivity.d(paramString);
        }
      });
    }

    @JavascriptInterface
    public void openVORatesScreen()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.e(b.this).finish();
          GenericWebViewActivity.a(b.e(b.this), b.a(b.this).b(), b.e(b.this).getString(R.string.viberout_web_title_rates));
        }
      });
    }

    @JavascriptInterface
    @Deprecated
    public void openVOSelectContactScreen()
    {
    }

    @JavascriptInterface
    @Deprecated
    public void openVOWelcomeFlow(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.e(b.this).finish();
          ViberOutWelcomeActivity.d(paramString);
        }
      });
    }

    @JavascriptInterface
    public void purchaseProduct(String paramString)
    {
      purchaseProduct(paramString, null);
    }

    @JavascriptInterface
    public void purchaseProduct(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          String str = paramString1;
          if ((str.startsWith("[\"")) && (str.endsWith("\"]")))
            str = str.substring(2, -2 + str.length());
          if (str.startsWith("stickers.pack."))
            str = "viber.stickers." + str.substring("stickers.pack.".length());
          try
          {
            IabProductId localIabProductId = IabProductId.fromString(str);
            b.a(b.this).a(localIabProductId, paramString2);
            b.b(b.this).g();
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            l.a().f();
          }
        }
      });
    }

    @JavascriptInterface
    public void purchaseVOProduct(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          if (paramString != null)
          {
            b.a(b.this).a(paramString);
            b.b(b.this).g();
          }
        }
      });
    }

    @JavascriptInterface
    public void purchaseVOProducts(final String paramString, final int paramInt)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = b.b.a(b.b.this, paramString);
          Activity localActivity;
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localActivity = b.e(b.this);
            if (paramInt != 2)
              break label53;
          }
          label53: for (boolean bool = true; ; bool = false)
          {
            ViberActionRunner.a(localActivity, localArrayList, null, bool, true);
            return;
          }
        }
      });
    }

    @JavascriptInterface
    public void purchaseVOProducts(final String paramString1, final int paramInt, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = b.b.a(b.b.this, paramString1);
          Carrier localCarrier;
          Activity localActivity;
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localCarrier = Carrier.parseFromJson(paramString2);
            localActivity = b.e(b.this);
            if (paramInt != 2)
              break label63;
          }
          label63: for (boolean bool = true; ; bool = false)
          {
            ViberActionRunner.a(localActivity, localArrayList, localCarrier, bool, true);
            return;
          }
        }
      });
    }

    @JavascriptInterface
    public void redownloadProduct(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          ProductId localProductId = ProductId.fromString(paramString1);
          b.a(b.this).b(localProductId, paramString2);
        }
      });
    }

    @JavascriptInterface
    public void sendCDR(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          new com.viber.voip.market.b.o().a(paramString1, paramString2, b.this.d());
        }
      });
    }

    @JavascriptInterface
    public void setBarTitle(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this).e_(paramString);
        }
      });
    }

    @JavascriptInterface
    public void setLoadingPageStatus(final int paramInt)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this).a(b.e.a.values()[paramInt]);
        }
      });
    }

    @JavascriptInterface
    public void setStickerShareOptions(final int paramInt, final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.b(b.this).a(paramInt, paramString);
        }
      });
    }

    @JavascriptInterface
    public void setVOPurchaseStatus(final int paramInt1, final int paramInt2, final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.e locale;
          int i;
          if (!b.e(b.this).isFinishing())
          {
            locale = b.b(b.this);
            i = paramInt1;
            if (paramInt2 != 2)
              break label55;
          }
          label55: for (boolean bool = true; ; bool = false)
          {
            locale.a(i, bool, paramString);
            return;
          }
        }
      });
    }

    @JavascriptInterface
    public void showAd(String paramString1, String paramString2, String paramString3)
    {
      b.a(b.this, new c(this, paramString1, paramString2, paramString3));
    }

    @JavascriptInterface
    public void unfollowPublicGroup(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            MarketPublicGroupInfo localMarketPublicGroupInfo = new MarketPublicGroupInfo(paramString1, paramString2);
            b.a(b.this).c(localMarketPublicGroupInfo);
            return;
          }
          catch (JSONException localJSONException)
          {
            b.a(b.this, new Runnable()
            {
              public void run()
              {
                b.b(b.this, b.b.7.this.a, 0);
              }
            });
          }
        }
      });
    }

    @JavascriptInterface
    public void viewCommunity(String paramString1, String paramString2)
    {
      new ad(b.e(b.this), b.f(b.this), b.g(b.this), Long.parseLong(paramString1, 10), 2).h();
    }

    @JavascriptInterface
    public void viewPublicGroup(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            MarketPublicGroupInfo localMarketPublicGroupInfo = new MarketPublicGroupInfo(paramString1, paramString2);
            b.a(b.this).a(localMarketPublicGroupInfo);
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }
  }

  class c extends bv.t
  {
    c()
    {
    }

    private int a(int paramInt)
    {
      switch (paramInt)
      {
      case -2:
      case -1:
      case 1:
      default:
        return 0;
      case 2:
        return 2;
      case 0:
        return 1;
      case -3:
      }
      return 3;
    }

    public void onJoinToPublicGroup(int paramInt1, final long paramLong, int paramInt2, int paramInt3)
    {
      if (paramInt2 == 5)
        return;
      int i = a(paramInt3);
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this, Long.toString(paramLong, 10), this.b);
        }
      });
    }
  }

  class d
    implements o.b
  {
    d()
    {
    }

    public void a()
    {
    }

    public void a(long paramLong)
    {
    }

    public void a(AdView paramAdView, String paramString, int paramInt)
    {
      b.a(b.this, new f(this, paramString, paramInt));
    }

    public void a(String paramString)
    {
      b.a(b.this, new e(this, paramString));
    }
  }

  public static abstract interface e extends s.a
  {
    public abstract void a(int paramInt, String paramString);

    public abstract void a(int paramInt, boolean paramBoolean, String paramString);

    public abstract void a(a parama);

    public abstract void a(Object paramObject, String paramString);

    public abstract void a(String paramString1, String paramString2, String paramString3);

    public abstract void c(String paramString);

    public abstract void e_(String paramString);

    public abstract void g();

    public abstract void i();

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[2];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b
 * JD-Core Version:    0.6.2
 */