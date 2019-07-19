package com.viber.voip.billing;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
{
  public static final String GOOGLE_STORE = "android";
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String ITEM_TYPE_SUBS = "subs";
  boolean isCallingPlanPurchase;
  long lastAction;
  Bundle mAdditionalParams;
  boolean mConsumed;
  String mDeveloperPayload;
  boolean mFromDB;
  String mItemType;
  String mOrderId;
  String mOriginalJson;
  String mPackageName;
  boolean mPending;
  IabProductId mProductId;
  int mPurchaseState;
  long mPurchaseTime;
  boolean mRetrying;
  String mSignature;
  String mStore;
  String mToken;
  String mUserId;
  boolean mVerified;
  long nextRetryDelay;

  Purchase(String paramString1, String paramString2)
    throws JSONException
  {
    this.mOriginalJson = paramString1;
    JSONObject localJSONObject = new JSONObject(this.mOriginalJson);
    this.mOrderId = localJSONObject.optString("orderId");
    this.mPackageName = localJSONObject.optString("packageName");
    this.mProductId = IabProductId.fromString(localJSONObject.optString("productId"));
    this.mPurchaseTime = localJSONObject.optLong("purchaseTime");
    this.mPurchaseState = localJSONObject.optInt("purchaseState");
    this.mDeveloperPayload = localJSONObject.optString("developerPayload");
    this.mToken = localJSONObject.optString("token", localJSONObject.optString("purchaseToken"));
    this.mUserId = localJSONObject.optString("userId");
    this.mSignature = paramString2;
    this.mStore = localJSONObject.optString("store");
    if (TextUtils.isEmpty(this.mStore))
      this.mStore = "android";
    this.mPending = true;
  }

  public Purchase(String paramString1, String paramString2, IabProductId paramIabProductId, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mOrderId = paramString1;
    this.mPackageName = paramString2;
    this.mProductId = paramIabProductId;
    this.mItemType = paramString3;
    this.mPurchaseTime = paramLong;
    this.mPurchaseState = paramInt;
    this.mDeveloperPayload = paramString4;
    this.mToken = paramString5;
    this.mOriginalJson = paramString6;
    this.mSignature = paramString7;
    this.mVerified = paramBoolean1;
    this.mConsumed = paramBoolean2;
    this.mPending = paramBoolean3;
    if (!TextUtils.isEmpty(this.mOriginalJson));
    try
    {
      JSONObject localJSONObject = new JSONObject(this.mOriginalJson);
      this.mUserId = localJSONObject.optString("userId");
      this.mStore = localJSONObject.optString("store");
      label124: if (!TextUtils.isEmpty(this.mSignature))
        this.mStore = "android";
      return;
    }
    catch (JSONException localJSONException)
    {
      break label124;
    }
  }

  public Bundle getAdditionalParams()
  {
    return this.mAdditionalParams;
  }

  public String getDeveloperPayload()
  {
    return this.mDeveloperPayload;
  }

  public String getItemType()
  {
    if (this.mItemType != null)
      return this.mItemType;
    return this.mProductId.getItemType();
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

  public IabProductId getProductId()
  {
    return this.mProductId;
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

  public String getStore()
  {
    return this.mStore;
  }

  public String getToken()
  {
    return this.mToken;
  }

  public String getUserId()
  {
    return this.mUserId;
  }

  public boolean isCallingPlanPurchase()
  {
    return this.isCallingPlanPurchase;
  }

  public boolean isConsumed()
  {
    return this.mConsumed;
  }

  boolean isFromDB()
  {
    return this.mFromDB;
  }

  public boolean isPending()
  {
    return this.mPending;
  }

  boolean isRetrying()
  {
    return this.mRetrying;
  }

  public boolean isSubscription()
  {
    return "subs".equals(this.mItemType);
  }

  public boolean isVerified()
  {
    return this.mVerified;
  }

  public void setAdditionalParams(Bundle paramBundle)
  {
    this.mAdditionalParams = paramBundle;
  }

  public void setCallingPlanPurchase(boolean paramBoolean)
  {
    this.isCallingPlanPurchase = paramBoolean;
  }

  public void setConsumed(boolean paramBoolean)
  {
    this.mConsumed = paramBoolean;
  }

  void setFromDB(boolean paramBoolean)
  {
    this.mFromDB = true;
  }

  public void setPending(boolean paramBoolean)
  {
    this.mPending = paramBoolean;
  }

  void setRetrying(boolean paramBoolean)
  {
    this.mRetrying = true;
  }

  public void setVerified(boolean paramBoolean)
  {
    this.mVerified = paramBoolean;
  }

  public String toString()
  {
    return "Purchase(itemType:" + getItemType() + ", category:" + getProductId().getProductId().getCategory() + ", verified:" + this.mVerified + ", consumed:" + this.mConsumed + " userId:" + this.mUserId + " orderId:" + this.mOrderId + " store:" + this.mStore + " pending:" + this.mPending + "):" + this.mOriginalJson;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.Purchase
 * JD-Core Version:    0.6.2
 */