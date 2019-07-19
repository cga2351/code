package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ImpressionData
  implements Serializable
{
  public static final String ADGROUP_ID = "adgroup_id";
  public static final String ADGROUP_NAME = "adgroup_name";
  public static final String ADGROUP_PRIORITY = "adgroup_priority";
  public static final String ADGROUP_TYPE = "adgroup_type";
  public static final String ADUNIT_FORMAT = "adunit_format";
  public static final String ADUNIT_ID = "adunit_id";
  public static final String ADUNIT_NAME = "adunit_name";
  public static final String COUNTRY = "country";
  public static final String CURRENCY = "currency";
  public static final String IMPRESSION_ID = "id";
  public static final String NETWORK_NAME = "network_name";
  public static final String NETWORK_PLACEMENT_ID = "network_placement_id";
  public static final String PRECISION = "precision";
  public static final String PUBLISHER_REVENUE = "publisher_revenue";
  private a a;

  private ImpressionData(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = new a(paramJSONObject);
  }

  static ImpressionData a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    try
    {
      ImpressionData localImpressionData = new ImpressionData(paramJSONObject);
      return localImpressionData;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.toString();
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return null;
  }

  public String getAdGroupId()
  {
    return this.a.optString("adgroup_id", null);
  }

  public String getAdGroupName()
  {
    return this.a.optString("adgroup_name", null);
  }

  public Integer getAdGroupPriority()
  {
    try
    {
      Integer localInteger = Integer.valueOf(this.a.getInt("adgroup_priority"));
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String getAdGroupType()
  {
    return this.a.optString("adgroup_type", null);
  }

  public String getAdUnitFormat()
  {
    return this.a.optString("adunit_format", null);
  }

  public String getAdUnitId()
  {
    return this.a.optString("adunit_id", null);
  }

  public String getAdUnitName()
  {
    return this.a.optString("adunit_name", null);
  }

  public String getCountry()
  {
    return this.a.optString("country", null);
  }

  public String getCurrency()
  {
    return this.a.optString("currency", null);
  }

  public String getImpressionId()
  {
    return this.a.optString("id", null);
  }

  public JSONObject getJsonRepresentation()
  {
    return this.a;
  }

  public String getNetworkName()
  {
    return this.a.optString("network_name", null);
  }

  public String getNetworkPlacementId()
  {
    return this.a.optString("network_placement_id", null);
  }

  public String getPrecision()
  {
    return this.a.optString("precision", null);
  }

  public Double getPublisherRevenue()
  {
    try
    {
      Double localDouble = Double.valueOf(this.a.getDouble("publisher_revenue"));
      return localDouble;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static class a extends JSONObject
    implements Serializable
  {
    a(JSONObject paramJSONObject)
      throws JSONException
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.ImpressionData
 * JD-Core Version:    0.6.2
 */