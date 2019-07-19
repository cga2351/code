package com.yandex.mobile.ads.impl;

import android.content.Intent;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class nf
{
  static Intent a(lt paramlt)
  {
    String str1 = paramlt.b();
    String str2 = paramlt.a();
    Map localMap = paramlt.c();
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    localIntent.addFlags(1342177280);
    localIntent.setPackage(str2);
    a(localIntent, localMap);
    return localIntent;
  }

  private static void a(Intent paramIntent, Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        Object localObject = localEntry.getValue();
        if ((localObject instanceof Boolean))
          paramIntent.putExtra(str, (Boolean)localObject);
        else if ((localObject instanceof Integer))
          paramIntent.putExtra(str, (Integer)localObject);
        else if ((localObject instanceof String))
          paramIntent.putExtra(str, (String)localObject);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nf
 * JD-Core Version:    0.6.2
 */