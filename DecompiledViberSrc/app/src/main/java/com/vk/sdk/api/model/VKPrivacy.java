package com.vk.sdk.api.model;

import org.json.JSONObject;

public class VKPrivacy
{
  public static final int PRIVACY_ALL = 0;
  public static final int PRIVACY_FRIENDS = 1;
  public static final int PRIVACY_FRIENDS_OF_FRIENDS = 2;
  public static final int PRIVACY_NOBODY = 3;
  public static final int PRIVACY_UNKNOWN = 4;

  public static int parsePrivacy(JSONObject paramJSONObject)
  {
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("type");
      if (!"all".equals(str));
    }
    else
    {
      return 0;
    }
    if ("friends".equals(str))
      return 1;
    if ("friends_of_friends".equals(str))
      return 2;
    if ("nobody".equals(str))
      return 3;
    return 4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKPrivacy
 * JD-Core Version:    0.6.2
 */