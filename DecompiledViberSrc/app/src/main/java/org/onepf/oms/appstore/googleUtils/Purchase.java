package org.onepf.oms.appstore.googleUtils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
  implements Cloneable
{
  String appstoreName;
  String mDeveloperPayload;
  String mItemType;
  String mOrderId;
  String mOriginalJson;
  String mPackageName;
  int mPurchaseState;
  long mPurchaseTime;
  String mSignature;
  String mSku;
  String mToken;

  public Purchase(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("appstoreName must be defined");
    this.appstoreName = paramString;
  }

  public Purchase(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.mOrderId = paramString1;
    this.mPackageName = paramString2;
    this.mSku = paramString3;
    this.mPurchaseTime = paramLong;
    this.mPurchaseState = paramInt;
    this.mDeveloperPayload = paramString4;
    this.mToken = paramString5;
    this.mOriginalJson = paramString6;
    this.mSignature = paramString7;
    this.appstoreName = "com.google.play";
    if ((!TextUtils.isEmpty(this.mOriginalJson)) && (TextUtils.isEmpty(this.mSignature)))
      this.appstoreName = "com.amazon.apps";
  }

  public Purchase(String paramString1, String paramString2, String paramString3, String paramString4)
    throws JSONException
  {
    this.appstoreName = paramString4;
    this.mItemType = paramString1;
    this.mOriginalJson = paramString2;
    JSONObject localJSONObject = new JSONObject(this.mOriginalJson);
    this.mOrderId = localJSONObject.optString("orderId");
    this.mPackageName = localJSONObject.optString("packageName");
    this.mSku = localJSONObject.optString("productId");
    this.mPurchaseTime = localJSONObject.optLong("purchaseTime");
    this.mPurchaseState = localJSONObject.optInt("purchaseState");
    this.mDeveloperPayload = localJSONObject.optString("developerPayload");
    this.mToken = localJSONObject.optString("token", localJSONObject.optString("purchaseToken"));
    this.mSignature = paramString3;
  }

  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException("Somebody forgot to add Cloneable to class", localCloneNotSupportedException);
    }
  }

  public String getAppstoreName()
  {
    return this.appstoreName;
  }

  public String getDeveloperPayload()
  {
    return this.mDeveloperPayload;
  }

  public String getItemType()
  {
    return this.mItemType;
  }

  public String getOrderId()
  {
    return this.mOrderId;
  }

  public String getOriginalJson()
  {
    return this.mOriginalJson;
  }

  public String getPackageName()
  {
    return this.mPackageName;
  }

  public int getPurchaseState()
  {
    return this.mPurchaseState;
  }

  public long getPurchaseTime()
  {
    return this.mPurchaseTime;
  }

  public String getSignature()
  {
    return this.mSignature;
  }

  public String getSku()
  {
    return this.mSku;
  }

  public String getToken()
  {
    return this.mToken;
  }

  public void setDeveloperPayload(String paramString)
  {
    this.mDeveloperPayload = paramString;
  }

  public void setItemType(String paramString)
  {
    this.mItemType = paramString;
  }

  public void setOrderId(String paramString)
  {
    this.mOrderId = paramString;
  }

  public void setOriginalJson(String paramString)
  {
    this.mOriginalJson = paramString;
  }

  public void setPackageName(String paramString)
  {
    this.mPackageName = paramString;
  }

  public void setPurchaseState(int paramInt)
  {
    this.mPurchaseState = paramInt;
  }

  public void setPurchaseTime(long paramLong)
  {
    this.mPurchaseTime = paramLong;
  }

  public void setSku(String paramString)
  {
    this.mSku = paramString;
  }

  public void setToken(String paramString)
  {
    this.mToken = paramString;
  }

  public String toString()
  {
    return "PurchaseInfo(type:" + this.mItemType + "): {\"orderId\":" + this.mOrderId + ",\"packageName\":" + this.mPackageName + ",\"productId\":" + this.mSku + ",\"purchaseTime\":" + this.mPurchaseTime + ",\"purchaseState\":" + this.mPurchaseState + ",\"developerPayload\":" + this.mDeveloperPayload + ",\"token\":" + this.mToken + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.Purchase
 * JD-Core Version:    0.6.2
 */