package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequestUtils;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PositioningRequest extends JsonRequest<MoPubNativeAdPositioning.MoPubClientPositioning>
{
  private final String a;
  private final Context b;

  public PositioningRequest(Context paramContext, String paramString, Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(MoPubRequestUtils.chooseMethod(paramString), MoPubRequestUtils.truncateQueryParamsIfPost(paramString), null, paramListener, paramErrorListener);
    this.a = paramString;
    this.b = paramContext.getApplicationContext();
  }

  private void a(JSONArray paramJSONArray, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
    throws JSONException
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      int j = localJSONObject.optInt("section", 0);
      if (j < 0)
        throw new JSONException("Invalid section " + j + " in JSON response");
      if (j > 0);
      while (true)
      {
        i++;
        break;
        int k = localJSONObject.getInt("position");
        if ((k < 0) || (k > 65536))
          throw new JSONException("Invalid position " + k + " in JSON response");
        paramMoPubClientPositioning.addFixedPosition(k);
      }
    }
  }

  private void a(JSONObject paramJSONObject, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
    throws JSONException
  {
    int i = paramJSONObject.getInt("interval");
    if ((i < 2) || (i > 65536))
      throw new JSONException("Invalid interval " + i + " in JSON response");
    paramMoPubClientPositioning.enableRepeatingPositions(i);
  }

  @VisibleForTesting
  MoPubNativeAdPositioning.MoPubClientPositioning a(String paramString)
    throws JSONException, MoPubNetworkError
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    String str = localJSONObject1.optString("error", null);
    if (str != null)
    {
      if (str.equalsIgnoreCase("WARMING_UP"))
        throw new MoPubNetworkError(MoPubNetworkError.Reason.WARMING_UP);
      throw new JSONException(str);
    }
    JSONArray localJSONArray = localJSONObject1.optJSONArray("fixed");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("repeating");
    if ((localJSONArray == null) && (localJSONObject2 == null))
      throw new JSONException("Must contain fixed or repeating positions");
    MoPubNativeAdPositioning.MoPubClientPositioning localMoPubClientPositioning = new MoPubNativeAdPositioning.MoPubClientPositioning();
    if (localJSONArray != null)
      a(localJSONArray, localMoPubClientPositioning);
    if (localJSONObject2 != null)
      a(localJSONObject2, localMoPubClientPositioning);
    return localMoPubClientPositioning;
  }

  protected Response<MoPubNativeAdPositioning.MoPubClientPositioning> a(NetworkResponse paramNetworkResponse)
  {
    if (paramNetworkResponse.statusCode != 200)
      return Response.error(new VolleyError(paramNetworkResponse));
    if (paramNetworkResponse.data.length == 0)
      return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
    try
    {
      Response localResponse = Response.success(a(new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers))), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return localResponse;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return Response.error(new VolleyError("Couldn't parse JSON from Charset", localUnsupportedEncodingException));
    }
    catch (JSONException localJSONException)
    {
      return Response.error(new VolleyError("JSON Parsing Error", localJSONException));
    }
    catch (MoPubNetworkError localMoPubNetworkError)
    {
      return Response.error(localMoPubNetworkError);
    }
  }

  protected Map<String, String> a()
  {
    if (!MoPubRequestUtils.isMoPubRequest(getUrl()))
      return null;
    return MoPubRequestUtils.convertQueryToMap(this.b, this.a);
  }

  protected void a(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    super.deliverResponse(paramMoPubClientPositioning);
  }

  public byte[] getBody()
  {
    String str = MoPubRequestUtils.generateBodyFromParams(a(), getUrl());
    if (str == null)
      return null;
    return str.getBytes();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.PositioningRequest
 * JD-Core Version:    0.6.2
 */