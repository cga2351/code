package com.viber.voip.market;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.av.e;
import com.viber.voip.billing.IabInventory;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.ProductDetails;
import com.viber.voip.billing.ProductId;
import com.viber.voip.billing.PurchaseSupportActivity;
import com.viber.voip.billing.b;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.ui.dialogs.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class MarketApi
{
  private static final Logger a = b.a(MarketApi.class);
  private static MarketApi c;
  private ArrayList<i> b = new ArrayList();

  private MarketApi()
  {
    this.b.add(new l(this));
  }

  public static MarketApi a()
  {
    try
    {
      if (c == null)
        c = new MarketApi();
      MarketApi localMarketApi = c;
      return localMarketApi;
    }
    finally
    {
    }
  }

  private String a(String paramString)
  {
    Object localObject = "";
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("custom_data"))
      {
        String str = localJSONObject.getString("custom_data");
        localObject = str;
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localObject;
  }

  private UserProduct[] b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localArrayList.addAll(((i)localIterator.next()).a());
    return (UserProduct[])localArrayList.toArray(new UserProduct[localArrayList.size()]);
  }

  private g c(ProductId paramProductId, String paramString)
  {
    if (paramString != null)
      return g.a(paramString);
    return g.b(paramProductId);
  }

  private i c(ProductId paramProductId)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.a(paramProductId))
        return locali;
    }
    return null;
  }

  public k a(ProductId paramProductId)
  {
    return c(paramProductId).c(paramProductId);
  }

  public void a(IabProductId paramIabProductId, String paramString)
  {
    c(paramIabProductId.getProductId(), paramString);
    if (!com.viber.voip.billing.l.a().i())
    {
      af.a("security").d(true).a(PurchaseSupportActivity.class);
      return;
    }
    if (!b.d())
    {
      f.b().d();
      return;
    }
    com.viber.voip.billing.l.a().a(paramIabProductId, null, a(paramString));
  }

  public void a(ProductId paramProductId, l paraml)
  {
    paraml.a(paramProductId, a(paramProductId));
  }

  public void a(ProductId paramProductId, String paramString)
  {
    c(paramProductId).a(paramProductId, a(paramString));
  }

  public void a(final h paramh)
  {
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        paramh.a(MarketApi.a(MarketApi.this));
      }
    });
  }

  public void a(final IabProductId[] paramArrayOfIabProductId, final j paramj)
  {
    List localList = Arrays.asList(paramArrayOfIabProductId);
    com.viber.voip.billing.l.a().c().queryProductDetailsAsync(localList, new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        int i = 0;
        MarketApi localMarketApi = MarketApi.a();
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousIabResult.isSuccess())
        {
          IabProductId[] arrayOfIabProductId2 = paramArrayOfIabProductId;
          int k = arrayOfIabProductId2.length;
          int m = 0;
          if (m < k)
          {
            IabProductId localIabProductId2 = arrayOfIabProductId2[m];
            ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(localIabProductId2);
            ProductId localProductId;
            MarketApi.k localk;
            if (localMarketApi.b(localIabProductId2.getProductId()))
            {
              localProductId = localIabProductId2.getProductId();
              localk = localMarketApi.a(localIabProductId2.getProductId());
              if (localProductDetails == null)
                break label128;
            }
            label128: for (String str = localProductDetails.getPriceString(); ; str = null)
            {
              localArrayList.add(new MarketApi.ProductInfo(localProductId, localk, str));
              m++;
              break;
            }
          }
        }
        else
        {
          IabProductId[] arrayOfIabProductId1 = paramArrayOfIabProductId;
          int j = arrayOfIabProductId1.length;
          while (i < j)
          {
            IabProductId localIabProductId1 = arrayOfIabProductId1[i];
            if (localMarketApi.b(localIabProductId1.getProductId()))
              localArrayList.add(new MarketApi.ProductInfo(localIabProductId1.getProductId(), localMarketApi.a(localIabProductId1.getProductId()), null));
            i++;
          }
        }
        paramj.a((MarketApi.ProductInfo[])localArrayList.toArray(new MarketApi.ProductInfo[localArrayList.size()]));
      }
    });
  }

  public void b(ProductId paramProductId, String paramString)
  {
    c(paramProductId).b(paramProductId);
  }

  public boolean b(ProductId paramProductId)
  {
    return c(paramProductId) != null;
  }

  public static class AppStatusInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<AppStatusInfo> CREATOR = new Parcelable.Creator()
    {
      public MarketApi.AppStatusInfo a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.AppStatusInfo(paramAnonymousParcel);
      }

      public MarketApi.AppStatusInfo[] a(int paramAnonymousInt)
      {
        return new MarketApi.AppStatusInfo[paramAnonymousInt];
      }
    };
    public final String appId;
    public final MarketApi.a appStatus;

    public AppStatusInfo(Parcel paramParcel)
    {
      this.appId = paramParcel.readString();
      this.appStatus = MarketApi.a.values()[paramParcel.readInt()];
    }

    public AppStatusInfo(String paramString, MarketApi.a parama)
    {
      this.appId = paramString;
      this.appStatus = parama;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.appStatus.ordinal());
    }
  }

  public static class ExtendedProductInfo extends MarketApi.ProductInfo
  {
    public static final Parcelable.Creator<ExtendedProductInfo> CREATOR = new Parcelable.Creator()
    {
      public MarketApi.ExtendedProductInfo a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.ExtendedProductInfo(paramAnonymousParcel);
      }

      public MarketApi.ExtendedProductInfo[] a(int paramAnonymousInt)
      {
        return new MarketApi.ExtendedProductInfo[paramAnonymousInt];
      }
    };
    public final String backendProductId;
    public final String currency;
    public final boolean isSubscription;
    public final String merchantProductId;
    public final float price;
    public final String providerId;
    public final String providerInappSecret;

    public ExtendedProductInfo(Parcel paramParcel)
    {
      super();
      this.price = paramParcel.readFloat();
      this.currency = paramParcel.readString();
      this.merchantProductId = paramParcel.readString();
      this.providerInappSecret = paramParcel.readString();
      this.providerId = paramParcel.readString();
      this.backendProductId = paramParcel.readString();
      if (paramParcel.readInt() == 0)
      {
        this.isSubscription = false;
        return;
      }
      this.isSubscription = true;
    }

    public ExtendedProductInfo(IabProductId paramIabProductId, MarketApi.k paramk, String paramString1, float paramFloat, String paramString2)
    {
      super(paramk, paramString1);
      this.merchantProductId = paramIabProductId.getMerchantProductId();
      this.providerInappSecret = paramIabProductId.getProviderInappSecret();
      this.providerId = paramIabProductId.getProviderId();
      this.backendProductId = paramIabProductId.getBackendProductId();
      this.price = paramFloat;
      this.currency = paramString2;
      this.isSubscription = false;
    }

    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", this.backendProductId);
      localJSONObject.put("merchant_product_id", this.merchantProductId);
      localJSONObject.put("provider_id", this.providerId);
      localJSONObject.put("provider_inapp_secret", this.providerInappSecret);
      localJSONObject.put("price", this.price);
      localJSONObject.put("currency", this.currency);
      localJSONObject.put("price_string", this.priceString);
      localJSONObject.put("status", this.status.ordinal());
      localJSONObject.put("is_subscription", this.isSubscription);
      return localJSONObject;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.price);
      paramParcel.writeString(this.currency);
      paramParcel.writeString(this.merchantProductId);
      paramParcel.writeString(this.providerInappSecret);
      paramParcel.writeString(this.providerId);
      paramParcel.writeString(this.backendProductId);
      if (this.isSubscription);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }

  public static class ProductInfo
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MarketApi.ProductInfo a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.ProductInfo(paramAnonymousParcel);
      }

      public MarketApi.ProductInfo[] a(int paramAnonymousInt)
      {
        return new MarketApi.ProductInfo[paramAnonymousInt];
      }
    };
    public final ProductId id;
    public final String priceString;
    public final MarketApi.k status;

    public ProductInfo(Parcel paramParcel)
    {
      this.id = ProductId.fromString(paramParcel.readString());
      this.priceString = paramParcel.readString();
      this.status = MarketApi.k.values()[paramParcel.readInt()];
    }

    public ProductInfo(ProductId paramProductId, MarketApi.k paramk, String paramString)
    {
      this.id = paramProductId;
      this.status = paramk;
      this.priceString = paramString;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.id.toString());
      paramParcel.writeString(this.priceString);
      paramParcel.writeInt(this.status.ordinal());
    }
  }

  public static class UserProduct
    implements Parcelable
  {
    public static final String ANDROID_STATUS_HIDDEN = "hidden";
    public static final Parcelable.Creator<UserProduct> CREATOR = new Parcelable.Creator()
    {
      public MarketApi.UserProduct a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.UserProduct(paramAnonymousParcel);
      }

      public MarketApi.UserProduct[] a(int paramAnonymousInt)
      {
        return new MarketApi.UserProduct[paramAnonymousInt];
      }
    };
    public final String androidStatus;
    public final ProductId productId;
    public final MarketApi.k status;

    protected UserProduct(Parcel paramParcel)
    {
      this.productId = ProductId.fromString(paramParcel.readString());
      this.status = MarketApi.k.values()[paramParcel.readInt()];
      this.androidStatus = paramParcel.readString();
    }

    public UserProduct(ProductId paramProductId, MarketApi.k paramk)
    {
      this(paramProductId, paramk, null);
    }

    public UserProduct(ProductId paramProductId, MarketApi.k paramk, String paramString)
    {
      this.productId = paramProductId;
      this.status = paramk;
      this.androidStatus = paramString;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.productId.getStringId());
      paramParcel.writeInt(this.status.ordinal());
      paramParcel.writeString(this.androidStatus);
    }
  }

  public static class UserPublicGroupInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<UserPublicGroupInfo> CREATOR = new Parcelable.Creator()
    {
      public MarketApi.UserPublicGroupInfo a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.UserPublicGroupInfo(paramAnonymousParcel, null);
      }

      public MarketApi.UserPublicGroupInfo[] a(int paramAnonymousInt)
      {
        return new MarketApi.UserPublicGroupInfo[paramAnonymousInt];
      }
    };
    public final long groupId;
    public final String groupName;
    public final int role;

    private UserPublicGroupInfo(Parcel paramParcel)
    {
      this.groupId = paramParcel.readLong();
      this.role = paramParcel.readInt();
      this.groupName = paramParcel.readString();
    }

    public UserPublicGroupInfo(h paramh)
    {
      this.groupId = paramh.k();
      this.role = paramh.p();
      this.groupName = paramh.o();
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "UserPublicGroupInfo{groupId=" + this.groupId + ", role=" + this.role + ", name=" + this.groupName + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.groupId);
      paramParcel.writeInt(this.role);
      paramParcel.writeString(this.groupName);
    }
  }

  public static class VOProductInfoRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<VOProductInfoRequest> CREATOR = new Parcelable.Creator()
    {
      public MarketApi.VOProductInfoRequest a(Parcel paramAnonymousParcel)
      {
        return new MarketApi.VOProductInfoRequest(paramAnonymousParcel);
      }

      public MarketApi.VOProductInfoRequest[] a(int paramAnonymousInt)
      {
        return new MarketApi.VOProductInfoRequest[paramAnonymousInt];
      }
    };
    public final String merchantProductId;
    public final String productId;
    public final String providerId;

    public VOProductInfoRequest(Parcel paramParcel)
    {
      this.productId = paramParcel.readString();
      this.merchantProductId = paramParcel.readString();
      this.providerId = paramParcel.readString();
    }

    public VOProductInfoRequest(JSONObject paramJSONObject)
      throws JSONException
    {
      this.productId = paramJSONObject.getString("product_id");
      this.merchantProductId = paramJSONObject.getString("merchant_product_id");
      this.providerId = "google_play";
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "VOProductInfo{productId='" + this.productId + '\'' + ", merchantProductId='" + this.merchantProductId + '\'' + ", providerId='" + this.providerId + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.productId);
      paramParcel.writeString(this.merchantProductId);
      paramParcel.writeString(this.providerId);
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a(MarketApi.AppStatusInfo[] paramArrayOfAppStatusInfo);
  }

  public static abstract interface c
  {
    public abstract void a(String paramString);

    public abstract void a(String paramString1, String paramString2, long paramLong);
  }

  public static abstract interface d
  {
    public abstract void a(JSONObject paramJSONObject);
  }

  public static abstract interface e
  {
    public abstract void a(MarketApi.ExtendedProductInfo[] paramArrayOfExtendedProductInfo);
  }

  public static abstract interface f
  {
    public abstract void a(String paramString);
  }

  public static abstract interface g
  {
    public abstract void a(String paramString1, String paramString2);
  }

  public static abstract interface h
  {
    public abstract void a(MarketApi.UserProduct[] paramArrayOfUserProduct);
  }

  public static abstract interface i
  {
    public abstract void a(ArrayList<MarketApi.UserPublicGroupInfo> paramArrayList);
  }

  public static abstract interface j
  {
    public abstract void a(MarketApi.ProductInfo[] paramArrayOfProductInfo);
  }

  public static enum k
  {
    static
    {
      k[] arrayOfk = new k[5];
      arrayOfk[0] = a;
      arrayOfk[1] = b;
      arrayOfk[2] = c;
      arrayOfk[3] = d;
      arrayOfk[4] = e;
    }
  }

  public static abstract interface l
  {
    public abstract void a(ProductId paramProductId, MarketApi.k paramk);
  }

  public static abstract interface m
  {
    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.MarketApi
 * JD-Core Version:    0.6.2
 */