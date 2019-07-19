package org.onepf.oms.appstore.googleUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails
{
  String mDescription;
  String mItemType;
  String mJson;
  String mPrice;
  long mPriceAmountMicros;
  String mPriceCurrency;
  String mSku;
  String mTitle;
  String mType;

  public SkuDetails(String paramString)
    throws JSONException
  {
    this("inapp", paramString);
  }

  public SkuDetails(String paramString1, String paramString2)
    throws JSONException
  {
    this.mItemType = paramString1;
    this.mJson = paramString2;
    JSONObject localJSONObject = new JSONObject(this.mJson);
    this.mSku = localJSONObject.optString("productId");
    this.mType = localJSONObject.optString("type");
    this.mPrice = localJSONObject.optString("price");
    this.mTitle = localJSONObject.optString("title");
    this.mDescription = localJSONObject.optString("description");
    this.mPriceCurrency = localJSONObject.optString("price_currency_code");
    this.mPriceAmountMicros = localJSONObject.optLong("price_amount_micros");
  }

  public SkuDetails(String paramString1, String paramString2, String paramString3)
  {
    this.mItemType = "inapp";
    this.mSku = paramString1;
    this.mTitle = paramString2;
    this.mPrice = paramString3;
  }

  public SkuDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mItemType = paramString1;
    this.mType = paramString1;
    this.mSku = paramString2;
    this.mTitle = paramString3;
    this.mPrice = paramString4;
    this.mDescription = paramString5;
  }

  public SkuDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
  {
    this.mItemType = paramString1;
    this.mType = paramString1;
    this.mSku = paramString2;
    this.mTitle = paramString3;
    this.mPrice = paramString4;
    this.mDescription = paramString5;
    this.mPriceCurrency = paramString6;
    this.mPriceAmountMicros = paramLong;
    this.mJson = paramString7;
  }

  public String getDescription()
  {
    return this.mDescription;
  }

  public String getItemType()
  {
    return this.mItemType;
  }

  public String getJson()
  {
    return this.mJson;
  }

  public String getPrice()
  {
    return this.mPrice;
  }

  public long getPriceAmountMicros()
  {
    return this.mPriceAmountMicros;
  }

  public String getPriceCurrencyCode()
  {
    return this.mPriceCurrency;
  }

  public String getSku()
  {
    return this.mSku;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getType()
  {
    return this.mType;
  }

  public void setSku(String paramString)
  {
    this.mSku = paramString;
  }

  public String toDeepString()
  {
    return "SkuDetails [mItemType=" + this.mItemType + ", mSku=" + this.mSku + ", mType=" + this.mType + ", mPrice=" + this.mPrice + ", mTitle=" + this.mTitle + ", mDescription=" + this.mDescription + ", mJson=" + this.mJson + "]";
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.mItemType;
    arrayOfObject[1] = this.mSku;
    arrayOfObject[2] = this.mTitle;
    arrayOfObject[3] = this.mPrice;
    arrayOfObject[4] = this.mDescription;
    return String.format("SkuDetails: type = %s, SKU = %s, title = %s, price = %s, description = %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.SkuDetails
 * JD-Core Version:    0.6.2
 */