package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import com.yandex.mobile.ads.nativeads.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class jy
{
  static void a(o paramo, Map<String, Bitmap> paramMap)
  {
    Iterator localIterator1 = paramo.c().c().iterator();
    while (localIterator1.hasNext())
    {
      ll localll = (ll)localIterator1.next();
      List localList = localll.c();
      if ((localList != null) && (!localList.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          le localle = (le)localIterator2.next();
          Object localObject = localle.c();
          String str = localle.b();
          if (("image".equals(str)) && ((localObject instanceof lh)))
          {
            if (a((lh)localObject, paramMap))
              localArrayList.add(localle);
          }
          else
          {
            if (("media".equals(str)) && ((localObject instanceof lk)) && (((lk)localObject).b() != null));
            for (int i = 1; ; i = 0)
            {
              if (i == 0)
                break label230;
              lh locallh = ((lk)localObject).b();
              if ((locallh == null) || (!a(locallh, paramMap)))
                break;
              localArrayList.add(localle);
              break;
            }
            label230: localArrayList.add(localle);
          }
        }
        localll.a(localArrayList);
      }
    }
  }

  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (paramBitmap.getWidth() > 1) && (paramBitmap.getHeight() > 1);
  }

  private static boolean a(lh paramlh, Map<String, Bitmap> paramMap)
  {
    return a((Bitmap)paramMap.get(paramlh.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jy
 * JD-Core Version:    0.6.2
 */