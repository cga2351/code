package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class zzceb extends FrameLayout
{
  private final zzayc zzftq;

  public zzceb(Context paramContext, View paramView, zzayc paramzzayc)
  {
    super(paramContext);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramView);
    this.zzftq = paramzzayc;
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.zzftq.zzd(paramMotionEvent);
    return false;
  }

  public final void removeAllViews()
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    for (int j = 0; j < getChildCount(); j++)
    {
      View localView = getChildAt(j);
      if ((localView != null) && ((localView instanceof zzbha)))
        localArrayList1.add((zzbha)localView);
    }
    super.removeAllViews();
    ArrayList localArrayList2 = (ArrayList)localArrayList1;
    int k = localArrayList2.size();
    while (i < k)
    {
      Object localObject = localArrayList2.get(i);
      i++;
      ((zzbha)localObject).destroy();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzceb
 * JD-Core Version:    0.6.2
 */