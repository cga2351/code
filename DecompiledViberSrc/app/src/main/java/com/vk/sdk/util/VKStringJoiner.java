package com.vk.sdk.util;

import android.net.Uri;
import android.text.TextUtils;
import com.vk.sdk.api.model.VKAttachments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VKStringJoiner
{
  public static String join(Collection<?> paramCollection, String paramString)
  {
    return TextUtils.join(paramString, paramCollection);
  }

  public static String join(String[] paramArrayOfString, String paramString)
  {
    return join(Arrays.asList(paramArrayOfString), paramString);
  }

  public static String joinParams(Map<String, ?> paramMap)
  {
    return joinParams(paramMap, false);
  }

  public static String joinParams(Map<String, ?> paramMap, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof VKAttachments))
        localObject = ((VKAttachments)localObject).toAttachmentsString();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localEntry.getKey();
      if (paramBoolean);
      for (String str = Uri.encode(String.valueOf(localObject)); ; str = String.valueOf(localObject))
      {
        arrayOfObject[1] = str;
        localArrayList.add(String.format("%s=%s", arrayOfObject));
        break;
      }
    }
    return join(localArrayList, "&");
  }

  public static String joinUriParams(Map<String, ?> paramMap)
  {
    return joinParams(paramMap, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.util.VKStringJoiner
 * JD-Core Version:    0.6.2
 */