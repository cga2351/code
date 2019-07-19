package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VastMacroHelper
{
  private final List<String> a;
  private final Map<l, String> b;

  public VastMacroHelper(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList, "uris cannot be null");
    this.a = paramList;
    this.b = new HashMap();
    this.b.put(l.CACHEBUSTING, a());
  }

  private String a()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(Math.round(100000000.0D * Math.random()));
    return String.format(localLocale, "%08d", arrayOfObject);
  }

  private String a(int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(TimeUnit.MILLISECONDS.toHours(paramInt));
    arrayOfObject[1] = Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(paramInt) % TimeUnit.HOURS.toMinutes(1L));
    arrayOfObject[2] = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(paramInt) % TimeUnit.MINUTES.toSeconds(1L));
    arrayOfObject[3] = Integer.valueOf(paramInt % 1000);
    return String.format("%02d:%02d:%02d.%03d", arrayOfObject);
  }

  public List<String> getUris()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        l[] arrayOfl = l.values();
        int i = arrayOfl.length;
        int j = 0;
        String str2 = str1;
        while (j < i)
        {
          l locall = arrayOfl[j];
          String str3 = (String)this.b.get(locall);
          if (str3 == null)
            str3 = "";
          str2 = str2.replaceAll("\\[" + locall.name() + "\\]", str3);
          j++;
        }
        localArrayList.add(str2);
      }
    }
    return localArrayList;
  }

  public VastMacroHelper withAssetUri(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      paramString = str;
      this.b.put(l.ASSETURI, paramString);
      return this;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to encode url", localUnsupportedEncodingException });
    }
  }

  public VastMacroHelper withContentPlayHead(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      String str = a(paramInteger.intValue());
      if (!TextUtils.isEmpty(str))
        this.b.put(l.CONTENTPLAYHEAD, str);
    }
    return this;
  }

  public VastMacroHelper withErrorCode(VastErrorCode paramVastErrorCode)
  {
    if (paramVastErrorCode != null)
      this.b.put(l.ERRORCODE, paramVastErrorCode.a());
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastMacroHelper
 * JD-Core Version:    0.6.2
 */