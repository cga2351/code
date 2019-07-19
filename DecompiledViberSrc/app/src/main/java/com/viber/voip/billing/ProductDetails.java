package com.viber.voip.billing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetails
{
  String mDescription;
  String mItemType;
  String mJson;
  String mPrice;
  private long mPriceAmountMicros;
  private String mPriceCurrencyCode;
  IabProductId mProductId;
  String mTitle;
  String mType;

  public ProductDetails(String paramString)
    throws JSONException
  {
    this("inapp", null, paramString);
  }

  public ProductDetails(String paramString1, IabProductId paramIabProductId, String paramString2)
    throws JSONException
  {
    this.mItemType = paramString1;
    this.mJson = paramString2;
    JSONObject localJSONObject = new JSONObject(this.mJson);
    if (paramIabProductId != null);
    while (true)
    {
      this.mProductId = paramIabProductId;
      this.mType = localJSONObject.optString("type");
      this.mPrice = localJSONObject.optString("price");
      this.mTitle = localJSONObject.optString("title");
      this.mDescription = localJSONObject.optString("description");
      this.mPriceCurrencyCode = localJSONObject.optString("price_currency_code");
      this.mPriceAmountMicros = localJSONObject.optLong("price_amount_micros");
      return;
      paramIabProductId = IabProductId.fromString(localJSONObject.optString("productId"));
    }
  }

  public ProductDetails(String paramString1, IabProductId paramIabProductId, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    this.mItemType = paramString1;
    this.mProductId = paramIabProductId;
    this.mTitle = paramString2;
    this.mPrice = paramString3;
    this.mDescription = paramString4;
    this.mPriceAmountMicros = paramLong;
    this.mPriceCurrencyCode = paramString5;
  }

  public ProductDetails(String paramString1, String paramString2)
    throws JSONException
  {
    this(paramString1, null, paramString2);
  }

  public String getDescription()
  {
    return this.mDescription;
  }

  public String getJson()
  {
    return this.mJson;
  }

  public long getPriceAmountMicros()
  {
    return this.mPriceAmountMicros;
  }

  public String getPriceCurrencyCode()
  {
    return this.mPriceCurrencyCode;
  }

  public String getPriceString()
  {
    return this.mPrice;
  }

  public IabProductId getProductId()
  {
    return this.mProductId;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getType()
  {
    return this.mType;
  }

  public a parsePrice()
  {
    return new a(this.mPrice);
  }

  public String toDeepString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ProductDetails [mItemType=").append(this.mItemType).append(", mProductId=");
    if (this.mProductId != null);
    for (Object localObject = this.mProductId.toDeepString(); ; localObject = this.mProductId)
      return localObject + ", mType=" + this.mType + ", mPrice=" + this.mPrice + ", mTitle=" + this.mTitle + ", mDescription=" + this.mDescription + ", mJson=" + this.mJson + ", mPriceCurrencyCode=" + this.mPriceCurrencyCode + ", mPriceAmountMicros=" + this.mPriceAmountMicros + "]";
  }

  public String toString()
  {
    return "ProductDetails: ProductId=" + this.mProductId + ", Price=" + this.mPrice;
  }

  public static class a
  {
    private static final Pattern a = Pattern.compile("^([^0-9]*)([0-9]( ?[0-9])*([\\.,][0-9]+)?)(.*)$");
    private String b = null;
    private String c = null;

    public a(String paramString)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      StringBuilder localStringBuilder2;
      if (paramString != null)
      {
        Matcher localMatcher = a.matcher(paramString);
        if (localMatcher.matches())
        {
          str1 = localMatcher.group(1);
          str2 = localMatcher.group(2);
          str3 = localMatcher.group(4);
          if ((str1 != null) || (str3 != null))
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            if (str1 != null)
              break label174;
            str4 = "";
            localStringBuilder2 = localStringBuilder1.append(str4);
            if (str3 != null)
              break label183;
          }
        }
      }
      label174: label183: for (String str5 = ""; ; str5 = str3.trim())
      {
        this.c = str5;
        if (str2 != null)
        {
          this.b = a(str2.replace(" ", "").replace(',', '.').trim());
          if (!paramString.replace(" ", "").replace(',', '.').contains(this.b))
            this.b = null;
        }
        return;
        str4 = str1.trim();
        break;
      }
    }

    private String a(String paramString)
    {
      if ((paramString == null) || (paramString.length() == 0));
      String[] arrayOfString;
      do
      {
        return paramString;
        arrayOfString = paramString.split("[\\.,]");
      }
      while (arrayOfString.length < 2);
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[(-1 + arrayOfString.length)];
      int i = paramString.length();
      int j = str1.length();
      int k = 0;
      label53: if ((k >= j - 1) || (str1.charAt(k) != '0'));
      for (int m = str2.length(); ; m--)
        if ((1 >= m - 1) || (str2.charAt(m - 1) != '0'))
        {
          int n = i - (str2.length() - m);
          if ((k <= 0) && (n >= i))
            break;
          return paramString.substring(k, n);
          k++;
          break label53;
        }
    }

    public String a()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ProductDetails
 * JD-Core Version:    0.6.2
 */