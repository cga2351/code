package com.appnexus.opensdk.ut.adresponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CSMVASTAdResponse extends BaseAdResponse
{
  private int a;
  private String b;
  private int c;
  private String d = String.valueOf(1 + new Random().nextInt(65536));
  private JSONObject e;

  public CSMVASTAdResponse(int paramInt1, int paramInt2, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    super(paramInt1, paramInt2, paramString1, paramArrayList, paramString2);
  }

  public JSONObject getAdJSONContent()
  {
    return this.e;
  }

  public String getAuction_id()
  {
    return this.b;
  }

  public String getCSMVASTAdResponse()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject.put("uuid", getUuid());
      localJSONObject.put("auction_id", getAuction_id());
      localJSONObject.put("tag_id", getTag_id());
      localJSONObject.put("timeout_ms", getTimeout_ms());
      localJSONArray.put(getAdJSONContent());
      localJSONObject.put("ads", localJSONArray);
      try
      {
        String str = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public int getTag_id()
  {
    return this.a;
  }

  public int getTimeout_ms()
  {
    return this.c;
  }

  public String getUuid()
  {
    return this.d;
  }

  public void setAdJSONContent(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }

  public void setAuction_id(String paramString)
  {
    this.b = paramString;
  }

  public void setTag_id(int paramInt)
  {
    this.a = paramInt;
  }

  public void setTimeout_ms(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.CSMVASTAdResponse
 * JD-Core Version:    0.6.2
 */