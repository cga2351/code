package com.mopub.common.privacy;

import android.content.Context;
import android.text.TextUtils;
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

class ConsentDialogRequest extends MoPubRequest<b>
{
  private Listener a;

  ConsentDialogRequest(Context paramContext, String paramString, Listener paramListener)
  {
    super(paramContext, paramString, paramListener);
    this.a = paramListener;
    setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
    setShouldCache(false);
  }

  protected Response<b> a(NetworkResponse paramNetworkResponse)
  {
    String str1 = b(paramNetworkResponse);
    String str2;
    try
    {
      str2 = new JSONObject(str1).getString("dialog_html");
      if (TextUtils.isEmpty(str2))
        throw new JSONException("Empty HTML body");
    }
    catch (JSONException localJSONException)
    {
      return Response.error(new MoPubNetworkError("Unable to parse consent dialog request network response.", MoPubNetworkError.Reason.BAD_BODY, null));
    }
    b localb = new b(str2);
    return Response.success(localb, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }

  protected void a(b paramb)
  {
    if (this.a != null)
      this.a.onSuccess(paramb);
  }

  public static abstract interface Listener extends Response.ErrorListener
  {
    public abstract void onSuccess(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentDialogRequest
 * JD-Core Version:    0.6.2
 */