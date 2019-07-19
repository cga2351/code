package com.my.target;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.my.target.b.c.a.h;
import com.my.target.b.c.b.c;
import com.my.target.common.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cq extends cu<c>
{
  private static b a(List<b> paramList, int paramInt1, int paramInt2)
  {
    if (paramList.size() == 0)
      return null;
    if ((paramInt2 == 0) || (paramInt1 == 0))
    {
      dp.a("[InterstitialAdResultProcessor] display size is zero");
      return null;
    }
    float f1 = paramInt1 / paramInt2;
    Iterator localIterator = paramList.iterator();
    float f2 = 0.0F;
    Object localObject = null;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.b() > 0) && (localb.c() > 0))
      {
        float f3 = localb.b() / localb.c();
        float f5;
        float f4;
        if (f1 < f3)
        {
          float f7 = localb.b();
          if (f7 > paramInt1)
            f7 = paramInt1;
          float f8 = f7 / f3;
          f5 = f7;
          f4 = f8;
        }
        while (true)
        {
          float f6 = f4 * f5;
          if (f6 <= f2)
            break label197;
          localObject = localb;
          f2 = f6;
          break;
          f4 = localb.c();
          if (f4 > paramInt2)
            f4 = paramInt2;
          f5 = f3 * f4;
        }
      }
    }
    label197: return localObject;
  }

  public static cq a()
  {
    return new cq();
  }

  private static boolean a(h paramh, Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    if (localWindowManager != null);
    label213: label238: for (Display localDisplay = localWindowManager.getDefaultDisplay(); ; localDisplay = null)
    {
      Point localPoint = new Point();
      if (localDisplay != null)
      {
        if (Build.VERSION.SDK_INT < 17)
          break label213;
        localDisplay.getRealSize(localPoint);
      }
      b localb2;
      while (true)
      {
        int i = localPoint.x;
        int j = localPoint.y;
        b localb1 = a(paramh.I(), Math.min(i, j), Math.max(i, j));
        if (localb1 != null)
        {
          localArrayList.add(localb1);
          paramh.d(localb1);
        }
        localb2 = a(paramh.J(), Math.max(i, j), Math.min(i, j));
        if (localb2 != null)
        {
          localArrayList.add(localb2);
          paramh.e(localb2);
        }
        if ((localb1 != null) || (localb2 != null))
        {
          b localb3 = paramh.D();
          if (localb3 != null)
            localArrayList.add(localb3);
        }
        if (localArrayList.size() <= 0)
          break label238;
        be.a(localArrayList).b(paramContext);
        if ((localb1 == null) || (localb1.e() == null))
          break;
        return true;
        localDisplay.getSize(localPoint);
      }
      return (localb2 != null) && (localb2.e() != null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cq
 * JD-Core Version:    0.6.2
 */