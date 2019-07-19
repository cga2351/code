package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import org.json.JSONObject;

public class AdjustAttribution
  implements Serializable
{
  private static final ObjectStreamField[] serialPersistentFields = arrayOfObjectStreamField;
  private static final long serialVersionUID = 1L;
  public String adgroup;
  public String adid;
  public String campaign;
  public String clickLabel;
  public String creative;
  public String network;
  public String trackerName;
  public String trackerToken;

  static
  {
    ObjectStreamField[] arrayOfObjectStreamField = new ObjectStreamField[8];
    arrayOfObjectStreamField[0] = new ObjectStreamField("trackerToken", String.class);
    arrayOfObjectStreamField[1] = new ObjectStreamField("trackerName", String.class);
    arrayOfObjectStreamField[2] = new ObjectStreamField("network", String.class);
    arrayOfObjectStreamField[3] = new ObjectStreamField("campaign", String.class);
    arrayOfObjectStreamField[4] = new ObjectStreamField("adgroup", String.class);
    arrayOfObjectStreamField[5] = new ObjectStreamField("creative", String.class);
    arrayOfObjectStreamField[6] = new ObjectStreamField("clickLabel", String.class);
    arrayOfObjectStreamField[7] = new ObjectStreamField("adid", String.class);
  }

  public static AdjustAttribution fromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject == null)
      return null;
    AdjustAttribution localAdjustAttribution = new AdjustAttribution();
    if ("unity".equals(paramString2))
    {
      localAdjustAttribution.trackerToken = paramJSONObject.optString("tracker_token", "");
      localAdjustAttribution.trackerName = paramJSONObject.optString("tracker_name", "");
      localAdjustAttribution.network = paramJSONObject.optString("network", "");
      localAdjustAttribution.campaign = paramJSONObject.optString("campaign", "");
      localAdjustAttribution.adgroup = paramJSONObject.optString("adgroup", "");
      localAdjustAttribution.creative = paramJSONObject.optString("creative", "");
      localAdjustAttribution.clickLabel = paramJSONObject.optString("click_label", "");
      if (paramString1 == null);
    }
    for (localAdjustAttribution.adid = paramString1; ; localAdjustAttribution.adid = paramString1)
    {
      return localAdjustAttribution;
      paramString1 = "";
      break;
      localAdjustAttribution.trackerToken = paramJSONObject.optString("tracker_token", null);
      localAdjustAttribution.trackerName = paramJSONObject.optString("tracker_name", null);
      localAdjustAttribution.network = paramJSONObject.optString("network", null);
      localAdjustAttribution.campaign = paramJSONObject.optString("campaign", null);
      localAdjustAttribution.adgroup = paramJSONObject.optString("adgroup", null);
      localAdjustAttribution.creative = paramJSONObject.optString("creative", null);
      localAdjustAttribution.clickLabel = paramJSONObject.optString("click_label", null);
    }
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws ClassNotFoundException, IOException
  {
    paramObjectInputStream.defaultReadObject();
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    AdjustAttribution localAdjustAttribution;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAdjustAttribution = (AdjustAttribution)paramObject;
      if (!Util.equalString(this.trackerToken, localAdjustAttribution.trackerToken))
        return false;
      if (!Util.equalString(this.trackerName, localAdjustAttribution.trackerName))
        return false;
      if (!Util.equalString(this.network, localAdjustAttribution.network))
        return false;
      if (!Util.equalString(this.campaign, localAdjustAttribution.campaign))
        return false;
      if (!Util.equalString(this.adgroup, localAdjustAttribution.adgroup))
        return false;
      if (!Util.equalString(this.creative, localAdjustAttribution.creative))
        return false;
      if (!Util.equalString(this.clickLabel, localAdjustAttribution.clickLabel))
        return false;
    }
    while (Util.equalString(this.adid, localAdjustAttribution.adid));
    return false;
  }

  public int hashCode()
  {
    return 37 * (37 * (37 * (37 * (37 * (37 * (37 * (629 + Util.hashString(this.trackerToken)) + Util.hashString(this.trackerName)) + Util.hashString(this.network)) + Util.hashString(this.campaign)) + Util.hashString(this.adgroup)) + Util.hashString(this.creative)) + Util.hashString(this.clickLabel)) + Util.hashString(this.adid);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = this.trackerToken;
    arrayOfObject[1] = this.trackerName;
    arrayOfObject[2] = this.network;
    arrayOfObject[3] = this.campaign;
    arrayOfObject[4] = this.adgroup;
    arrayOfObject[5] = this.creative;
    arrayOfObject[6] = this.clickLabel;
    arrayOfObject[7] = this.adid;
    return Util.formatString("tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s adid:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustAttribution
 * JD-Core Version:    0.6.2
 */