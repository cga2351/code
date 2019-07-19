package com.mopub.network;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public abstract class MoPubRequest<T> extends Request<T>
{
  private final String a;
  private final Context b;

  public MoPubRequest(Context paramContext, String paramString, Response.ErrorListener paramErrorListener)
  {
    super(MoPubRequestUtils.chooseMethod(paramString), MoPubRequestUtils.truncateQueryParamsIfPost(paramString), paramErrorListener);
    this.a = paramString;
    this.b = paramContext.getApplicationContext();
  }

  protected Map<String, String> a()
  {
    if (!MoPubRequestUtils.isMoPubRequest(getUrl()))
      return null;
    return MoPubRequestUtils.convertQueryToMap(this.b, this.a);
  }

  protected String b(NetworkResponse paramNetworkResponse)
  {
    Preconditions.checkNotNull(paramNetworkResponse);
    try
    {
      String str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(paramNetworkResponse.data);
  }

  public byte[] getBody()
  {
    String str = MoPubRequestUtils.generateBodyFromParams(a(), getUrl());
    if (str == null)
      return null;
    return str.getBytes();
  }

  public String getBodyContentType()
  {
    if (MoPubRequestUtils.isMoPubRequest(getUrl()))
      return "application/json; charset=UTF-8";
    return super.getBodyContentType();
  }

  public Map<String, String> getHeaders()
  {
    TreeMap localTreeMap = new TreeMap();
    Locale localLocale;
    String str1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = this.b.getResources().getConfiguration().getLocales();
      int i = localLocaleList.size();
      localLocale = null;
      if (i > 0)
        localLocale = localLocaleList.get(0);
      if ((localLocale == null) || (TextUtils.isEmpty(localLocale.toString().trim())))
        break label160;
      str1 = localLocale.getLanguage().trim();
    }
    for (String str2 = localLocale.getCountry().trim(); ; str2 = Locale.getDefault().getCountry().trim())
    {
      if (!TextUtils.isEmpty(str1))
      {
        if (!TextUtils.isEmpty(str2))
          str1 = str1 + "-" + str2.toLowerCase();
        localTreeMap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), str1);
      }
      return localTreeMap;
      localLocale = this.b.getResources().getConfiguration().locale;
      break;
      label160: str1 = Locale.getDefault().getLanguage().trim();
    }
  }

  public String getOriginalUrl()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MoPubRequest
 * JD-Core Version:    0.6.2
 */