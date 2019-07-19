package com.viber.voip.camrecorder.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.CamcorderProfile;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.c.b;
import com.viber.voip.camera.e.c;
import com.viber.voip.camera.e.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static final String a = "";

  protected Point a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      Rect localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return new Point(localRect.width(), localRect.bottom);
    }
    return e.a(paramContext);
  }

  public Pair<Integer, Integer> a(b paramb, List<a.h> paramList, List<String> paramList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    int i2;
    for (int i = 0; localIterator1.hasNext(); i = i2)
    {
      a.h localh = (a.h)localIterator1.next();
      Point localPoint4 = new Point(Math.min(localh.a, localh.b), Math.max(localh.a, localh.b));
      i2 = i + 1;
      localArrayList1.add(new Pair(localPoint4, Integer.valueOf(i)));
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator2 = paramList1.iterator();
    int i1;
    for (int j = 0; localIterator2.hasNext(); j = i1)
    {
      CamcorderProfile localCamcorderProfile = paramb.a((String)localIterator2.next());
      Point localPoint3 = new Point(Math.min(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight), Math.max(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight));
      i1 = j + 1;
      localArrayList2.add(new Pair(localPoint3, Integer.valueOf(j)));
    }
    Point localPoint1 = a(paramb.b());
    int k = Math.min(localPoint1.x, localPoint1.y);
    int m = Math.max(localPoint1.x, localPoint1.y);
    Point localPoint2 = c.a(new Point(750, 1300), new Point(k, m));
    final int n = localPoint2.x * localPoint2.y;
    Collections.sort(localArrayList2, new Comparator()
    {
      public int a(Pair<Point, Integer> paramAnonymousPair1, Pair<Point, Integer> paramAnonymousPair2)
      {
        int i = 2147483647;
        int j = ((Point)paramAnonymousPair1.first).x * ((Point)paramAnonymousPair1.first).y - n;
        int k;
        int m;
        if (j > 0)
        {
          k = i;
          m = ((Point)paramAnonymousPair2.first).x * ((Point)paramAnonymousPair2.first).y - n;
          if (m <= 0)
            break label87;
        }
        while (true)
        {
          return k - i;
          k = Math.abs(j);
          break;
          label87: i = Math.abs(m);
        }
      }
    });
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator3 = localArrayList2.iterator();
    do
    {
      Pair localPair6;
      do
      {
        if (!localIterator3.hasNext())
          break;
        localPair6 = (Pair)localIterator3.next();
      }
      while ((((Point)localPair6.first).x * ((Point)localPair6.first).y - n > 0) || (((Point)localPair6.first).x > k) || (((Point)localPair6.first).y > m));
      localArrayList3.add(localPair6);
    }
    while (localArrayList3.size() < 4);
    double d1 = -1.0D;
    Object localObject1 = null;
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator4 = localArrayList3.iterator();
    label533: double d7;
    Object localObject4;
    if (localIterator4.hasNext())
    {
      Pair localPair4 = (Pair)localIterator4.next();
      double d6 = (0.0D + ((Point)localPair4.first).y) / ((Point)localPair4.first).x;
      Iterator localIterator6 = localArrayList1.iterator();
      if (localIterator6.hasNext())
      {
        Pair localPair5 = (Pair)localIterator6.next();
        if (Math.abs(d6 - (0.0D + ((Point)localPair5.first).y) / ((Point)localPair5.first).x) > 0.05D)
          break label908;
        d7 = c.a(((Point)localPair5.first).x, ((Point)localPair5.first).y, k, m);
        localArrayList4.add(new Pair(Double.valueOf(d7), new Pair(localPair5, localPair4)));
        if ((localObject1 != null) && (d7 <= d1))
          break label908;
        localObject4 = new Pair(localPair5, localPair4);
      }
    }
    while (true)
    {
      localObject1 = localObject4;
      d1 = d7;
      break label533;
      break;
      double d2 = -1.0D;
      Object localObject2 = null;
      double d5;
      Object localObject3;
      if (localObject1 != null)
      {
        Iterator localIterator5 = localArrayList4.iterator();
        if (localIterator5.hasNext())
        {
          Pair localPair1 = (Pair)localIterator5.next();
          double d3 = ((Double)localPair1.first).doubleValue();
          Pair localPair2 = (Pair)((Pair)localPair1.second).first;
          Pair localPair3 = (Pair)((Pair)localPair1.second).second;
          if (Math.abs(d1 - d3) > 16.0D * m)
            break label897;
          d5 = c.a((Point)localPair2.first);
          if ((localObject2 != null) && (d5 <= d2))
            break label897;
          localObject3 = new Pair(localPair2, localPair3);
        }
      }
      for (double d4 = d5; ; d4 = d2)
      {
        d2 = d4;
        localObject2 = localObject3;
        break;
        if (localObject2 != null)
          return new Pair(((Pair)localObject2.first).second, ((Pair)localObject2.second).second);
        return null;
        label897: localObject3 = localObject2;
      }
      label908: localObject4 = localObject1;
      d7 = d1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.a.a
 * JD-Core Version:    0.6.2
 */