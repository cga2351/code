package com.viber.voip.engagement.carousel;

import android.net.Uri;
import com.viber.voip.engagement.data.GifsMediaViewData;
import com.viber.voip.engagement.data.GifsMediaViewData.GifItem;
import com.viber.voip.engagement.data.StickersMediaViewData;
import com.viber.voip.engagement.data.StickersMediaViewData.StickerItem;
import com.viber.voip.util.b.a;
import com.viber.voip.util.b.a.a;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public GifsMediaViewData a(a parama)
  {
    List localList = parama.a();
    int i = parama.c();
    int j = parama.d();
    if ((!u.a(localList)) && (j > 0) && (i > 0))
    {
      ArrayList localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!da.a(str))
          localArrayList.add(new GifsMediaViewData.GifItem(Uri.parse(str), i, j));
      }
      if (localArrayList.size() > 0)
        return new GifsMediaViewData(localArrayList, i / j);
    }
    return new GifsMediaViewData();
  }

  public StickersMediaViewData b(a parama)
  {
    List localList = parama.b();
    int i = parama.e();
    int j = parama.f();
    if ((!u.a(localList)) && (j > 0) && (i > 0))
    {
      ArrayList localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala != null)
          localArrayList.add(new StickersMediaViewData.StickerItem(locala.a(), locala.b()));
      }
      if (localArrayList.size() > 0)
        return new StickersMediaViewData(localArrayList, i / j);
    }
    return new StickersMediaViewData();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.b
 * JD-Core Version:    0.6.2
 */