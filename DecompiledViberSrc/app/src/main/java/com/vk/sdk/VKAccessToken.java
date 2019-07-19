package com.vk.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.util.HashMap;
import java.util.Map;

public class VKAccessToken
{
  public static final String ACCESS_TOKEN = "access_token";
  public static final String CREATED = "created";
  public static final String EMAIL = "email";
  public static final String EXPIRES_IN = "expires_in";
  public static final String HTTPS_REQUIRED = "https_required";
  public static final String SCOPE = "scope";
  public static final String SECRET = "secret";
  public static final String SUCCESS = "success";
  public static final String USER_ID = "user_id";
  private static final String VK_SDK_ACCESS_TOKEN_PREF_KEY = "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH";
  private static volatile VKAccessToken sCurrentToken;
  public String accessToken = null;
  public long created = 0L;
  public String email = null;
  public int expiresIn = 0;
  public boolean httpsRequired = false;
  private Map<String, Boolean> scope = null;
  public String secret = null;
  public String userId = null;

  public static VKAccessToken currentToken()
  {
    if (sCurrentToken == null);
    try
    {
      if (sCurrentToken == null)
        sCurrentToken = tokenFromSharedPreferences(VKUIHelper.getApplicationContext(), "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
      return sCurrentToken;
    }
    finally
    {
    }
  }

  public static void removeTokenAtKey(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }

  static VKAccessToken replaceToken(Context paramContext, VKAccessToken paramVKAccessToken)
  {
    VKAccessToken localVKAccessToken = sCurrentToken;
    sCurrentToken = paramVKAccessToken;
    if (sCurrentToken != null)
    {
      sCurrentToken.save();
      return localVKAccessToken;
    }
    removeTokenAtKey(paramContext, "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
    return localVKAccessToken;
  }

  public static VKAccessToken tokenFromFile(String paramString)
  {
    try
    {
      VKAccessToken localVKAccessToken = tokenFromUrlString(VKUtil.fileToString(paramString));
      return localVKAccessToken;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static VKAccessToken tokenFromParameters(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
      return null;
    VKAccessToken localVKAccessToken1 = new VKAccessToken();
    try
    {
      localVKAccessToken1.accessToken = ((String)paramMap.get("access_token"));
      localVKAccessToken1.userId = ((String)paramMap.get("user_id"));
      localVKAccessToken1.secret = ((String)paramMap.get("secret"));
      localVKAccessToken1.email = ((String)paramMap.get("email"));
      localVKAccessToken1.httpsRequired = false;
      if (paramMap.get("expires_in") != null)
        localVKAccessToken1.expiresIn = Integer.parseInt((String)paramMap.get("expires_in"));
      String str = (String)paramMap.get("scope");
      if (str != null)
      {
        HashMap localHashMap = new HashMap();
        String[] arrayOfString = str.split(",");
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
          localHashMap.put(arrayOfString[j], Boolean.valueOf(true));
        localVKAccessToken1.scope = localHashMap;
      }
      if (paramMap.containsKey("https_required"))
      {
        localVKAccessToken1.httpsRequired = ((String)paramMap.get("https_required")).equals("1");
        if (!paramMap.containsKey("created"))
          break label280;
      }
      label280: for (localVKAccessToken1.created = Long.parseLong((String)paramMap.get("created")); ; localVKAccessToken1.created = System.currentTimeMillis())
      {
        if (localVKAccessToken1.accessToken == null)
          break label290;
        localVKAccessToken2 = localVKAccessToken1;
        break label293;
        if (localVKAccessToken1.secret != null)
          break;
        localVKAccessToken1.httpsRequired = true;
        break;
      }
      label290: VKAccessToken localVKAccessToken2 = null;
      label293: return localVKAccessToken2;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static VKAccessToken tokenFromSharedPreferences(Context paramContext, String paramString)
  {
    return tokenFromUrlString(PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, null));
  }

  public static VKAccessToken tokenFromUrlString(String paramString)
  {
    if (paramString == null)
      return null;
    return tokenFromParameters(VKUtil.explodeQueryString(paramString));
  }

  public VKAccessToken copyWithToken(VKAccessToken paramVKAccessToken)
  {
    Map localMap = tokenParams();
    localMap.putAll(paramVKAccessToken.tokenParams());
    return tokenFromParameters(localMap);
  }

  public boolean hasScope(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (this.scope.get(str) == null)
        return false;
    }
    return true;
  }

  public boolean isExpired()
  {
    return (this.expiresIn > 0) && (1000 * this.expiresIn + this.created < System.currentTimeMillis());
  }

  public void save()
  {
    saveTokenToSharedPreferences(VKUIHelper.getApplicationContext(), "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
  }

  public void saveTokenToFile(String paramString)
  {
    VKUtil.stringToFile(paramString, serialize());
  }

  public void saveTokenToSharedPreferences(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putString(paramString, serialize());
    localEditor.apply();
  }

  protected String serialize()
  {
    return VKStringJoiner.joinParams(tokenParams());
  }

  protected Map<String, String> tokenParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("access_token", this.accessToken);
    localHashMap.put("expires_in", "" + this.expiresIn);
    localHashMap.put("user_id", this.userId);
    localHashMap.put("created", "" + this.created);
    if (this.scope != null)
      localHashMap.put("scope", TextUtils.join(",", this.scope.keySet()));
    if (this.secret != null)
      localHashMap.put("secret", this.secret);
    if (this.httpsRequired)
      localHashMap.put("https_required", "1");
    if (this.email != null)
      localHashMap.put("email", this.email);
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKAccessToken
 * JD-Core Version:    0.6.2
 */