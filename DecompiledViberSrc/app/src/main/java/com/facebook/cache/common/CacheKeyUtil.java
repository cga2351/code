package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class CacheKeyUtil
{
  public static String getFirstResourceId(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
        return secureHashKey((CacheKey)((MultiCacheKey)paramCacheKey).getCacheKeys().get(0));
      String str = secureHashKey(paramCacheKey);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static List<String> getResourceIds(CacheKey paramCacheKey)
  {
    ArrayList localArrayList2;
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
      {
        List localList = ((MultiCacheKey)paramCacheKey).getCacheKeys();
        localArrayList2 = new ArrayList(localList.size());
        for (int i = 0; i < localList.size(); i++)
          localArrayList2.add(secureHashKey((CacheKey)localList.get(i)));
      }
      ArrayList localArrayList1 = new ArrayList(1);
      localArrayList1.add(secureHashKey(paramCacheKey));
      return localArrayList1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
    return localArrayList2;
  }

  private static String secureHashKey(CacheKey paramCacheKey)
    throws UnsupportedEncodingException
  {
    return SecureHashUtil.makeSHA1HashBase64(paramCacheKey.getUriString().getBytes("UTF-8"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheKeyUtil
 * JD-Core Version:    0.6.2
 */