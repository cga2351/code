package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import org.json.JSONException;
import org.json.JSONObject;

public class SyncRequest extends MoPubRequest<SyncResponse>
{
  private Listener a;

  public SyncRequest(Context paramContext, String paramString, Listener paramListener)
  {
    super(paramContext, paramString, paramListener);
    this.a = paramListener;
    setRetryPolicy(new DefaultRetryPolicy(2500, 0, 1.0F));
    setShouldCache(false);
  }

  protected Response<SyncResponse> a(NetworkResponse paramNetworkResponse)
  {
    SyncResponse.Builder localBuilder = new SyncResponse.Builder();
    String str = b(paramNetworkResponse);
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      localBuilder.setIsGdprRegion(localJSONObject.getString(PrivacyKey.IS_GDPR_REGION.getKey())).setForceExplicitNo(localJSONObject.optString(PrivacyKey.FORCE_EXPLICIT_NO.getKey())).setInvalidateConsent(localJSONObject.optString(PrivacyKey.INVALIDATE_CONSENT.getKey())).setReacquireConsent(localJSONObject.optString(PrivacyKey.REACQUIRE_CONSENT.getKey())).setIsWhitelisted(localJSONObject.getString(PrivacyKey.IS_WHITELISTED.getKey())).setForceGdprApplies(localJSONObject.optString(PrivacyKey.FORCE_GDPR_APPLIES.getKey())).setCurrentVendorListVersion(localJSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_VERSION.getKey())).setCurrentVendorListLink(localJSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_LINK.getKey())).setCurrentPrivacyPolicyLink(localJSONObject.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_LINK.getKey())).setCurrentPrivacyPolicyVersion(localJSONObject.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_VERSION.getKey())).setCurrentVendorListIabFormat(localJSONObject.optString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_FORMAT.getKey())).setCurrentVendorListIabHash(localJSONObject.getString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_HASH.getKey())).setCallAgainAfterSecs(localJSONObject.optString(PrivacyKey.CALL_AGAIN_AFTER_SECS.getKey())).setExtras(localJSONObject.optString(PrivacyKey.EXTRAS.getKey())).setConsentChangeReason(localJSONObject.optString(PrivacyKey.CONSENT_CHANGE_REASON.getKey()));
      return Response.success(localBuilder.build(), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    catch (JSONException localJSONException)
    {
    }
    return Response.error(new MoPubNetworkError("Unable to parse sync request network response.", MoPubNetworkError.Reason.BAD_BODY, null));
  }

  protected void a(SyncResponse paramSyncResponse)
  {
    if (this.a != null)
      this.a.onSuccess(paramSyncResponse);
  }

  public static abstract interface Listener extends Response.ErrorListener
  {
    public abstract void onSuccess(SyncResponse paramSyncResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.SyncRequest
 * JD-Core Version:    0.6.2
 */