package com.viber.voip.billing;

import android.text.TextUtils;
import com.viber.dexshared.BillingHost;
import com.viber.dexshared.Logger;
import com.viber.dexshared.OpenIabHelper;
import com.viber.voip.ViberEnv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class IabProductId
{
  public static final String GOOGLE_PLAY = "google_play";
  private static final Logger L = ViberEnv.getBillingHost().getBillingLogger(IabProductId.class.getSimpleName());
  private static Pattern sPattern = Pattern.compile("viber.([a-zA-Z_]+\\.[0-9]+)");
  private String backendProductId;
  private ProductId mProductId;
  private String mProductType = "inapp";
  private String mSku;
  private String merchantProductId;
  private String providerId = getProvider();
  private String providerInappSecret;
  private String srcJson;

  private IabProductId(ProductId paramProductId, String paramString)
  {
    this.mProductId = paramProductId;
    this.mSku = paramString;
    this.merchantProductId = paramString;
    this.backendProductId = paramString;
  }

  private IabProductId(ProductId paramProductId, String paramString1, String paramString2)
  {
    this(paramProductId, paramString1);
    this.mProductType = paramString2;
  }

  private IabProductId(String paramString)
  {
    this(paramString, null);
  }

  private IabProductId(String paramString, ProductCategory paramProductCategory)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str1 = localJSONObject.getString("product_id");
      this.backendProductId = str1;
      this.mSku = str1;
      String str2 = localJSONObject.optString("provider_id");
      if (!TextUtils.isEmpty(str2))
        this.providerId = str2;
      if (localJSONObject.optBoolean("is_subscription"))
        this.mProductType = "subs";
      this.merchantProductId = localJSONObject.optString("merchant_product_id");
      this.providerInappSecret = localJSONObject.optString("provider_inapp_secret");
      this.srcJson = paramString;
      if (this.mSku.startsWith("stickers."))
        this.mSku = ("viber." + this.backendProductId);
      if (TextUtils.isEmpty(this.mSku))
        throw new IllegalArgumentException("Empty: SKU in product: " + paramString);
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalArgumentException("invalid json product id: " + paramString);
    }
    Matcher localMatcher = sPattern.matcher(this.mSku);
    if (localMatcher.matches())
    {
      this.mProductId = ProductId.fromString(localMatcher.group(1));
      return;
    }
    if (paramProductCategory != null)
    {
      this.mProductId = ProductId.fromCustomProductId(this.mSku, paramProductCategory);
      return;
    }
    this.mProductId = ProductId.fromViberOutProductId(this.mSku);
  }

  public static IabProductId fromString(String paramString)
  {
    return fromString(paramString, null);
  }

  public static IabProductId fromString(String paramString, ProductCategory paramProductCategory)
  {
    return fromStringAndType(paramString, "inapp", paramProductCategory);
  }

  public static IabProductId fromStringAndType(String paramString1, String paramString2)
  {
    return fromStringAndType(paramString1, paramString2, null);
  }

  public static IabProductId fromStringAndType(String paramString1, String paramString2, ProductCategory paramProductCategory)
  {
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("invalid merchant product id: " + paramString1);
    if (paramString1.charAt(0) == '{')
      return new IabProductId(paramString1, paramProductCategory);
    Matcher localMatcher = sPattern.matcher(paramString1);
    if (localMatcher.matches())
      return new IabProductId(ProductId.fromString(localMatcher.group(1)), paramString1, paramString2);
    if (paramProductCategory != null)
      return new IabProductId(ProductId.fromCustomProductId(paramString1, paramProductCategory), paramString1, paramString2);
    return new IabProductId(ProductId.fromViberOutProductId(paramString1), paramString1, paramString2);
  }

  private static String getProvider()
  {
    try
    {
      String str = ViberEnv.getOpenIabHelper().getDefaultProvider();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "google_play";
  }

  private static IabProductId viberOutFromString(String paramString)
  {
    ViberEnv.getBillingHost().setIsViberOutProduct(paramString);
    return new IabProductId(ProductId.fromViberOutProductId(paramString), paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IabProductId))
      return false;
    return this.merchantProductId.equals(paramObject.toString());
  }

  public String getBackendProductId()
  {
    return this.backendProductId;
  }

  public String getItemType()
  {
    return this.mProductType;
  }

  public String getJson()
  {
    return this.srcJson;
  }

  public String getMerchantProductId()
  {
    return this.merchantProductId;
  }

  public ProductId getProductId()
  {
    return this.mProductId;
  }

  public String getProviderId()
  {
    return this.providerId;
  }

  public String getProviderInappSecret()
  {
    return this.providerInappSecret;
  }

  public int hashCode()
  {
    return this.merchantProductId.hashCode();
  }

  public String toDeepString()
  {
    return "IabProductId [mSku=" + this.mSku + ", backendProductId=" + this.backendProductId + ", mProductId=" + this.mProductId + ", merchantProductId=" + this.merchantProductId + ", providerId=" + this.providerId + ", providerInappSecret=" + this.providerInappSecret + ", srcJson=" + this.srcJson + "]";
  }

  public String toString()
  {
    return this.merchantProductId;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.IabProductId
 * JD-Core Version:    0.6.2
 */