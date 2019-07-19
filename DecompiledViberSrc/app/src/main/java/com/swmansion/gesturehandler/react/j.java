package com.swmansion.gesturehandler.react;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.l;
import com.swmansion.gesturehandler.p;

public class j
  implements p
{
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramViewGroup instanceof ReactViewGroup))
      return paramViewGroup.getChildAt(((ReactViewGroup)paramViewGroup).getZIndexMappedChildIndex(paramInt));
    return paramViewGroup.getChildAt(paramInt);
  }

  public l a(View paramView)
  {
    PointerEvents localPointerEvents;
    if ((paramView instanceof ReactPointerEventsView))
      localPointerEvents = ((ReactPointerEventsView)paramView).getPointerEvents();
    while (!paramView.isEnabled())
      if (localPointerEvents == PointerEvents.AUTO)
      {
        return l.b;
        localPointerEvents = PointerEvents.AUTO;
      }
      else if (localPointerEvents == PointerEvents.BOX_ONLY)
      {
        return l.a;
      }
    switch (1.a[localPointerEvents.ordinal()])
    {
    default:
      return l.d;
    case 1:
      return l.c;
    case 2:
      return l.b;
    case 3:
    }
    return l.a;
  }

  public boolean a(ViewGroup paramViewGroup)
  {
    if ((Build.VERSION.SDK_INT >= 18) && (!paramViewGroup.getClipChildren()))
    {
      if ((paramViewGroup instanceof ReactViewGroup))
        return "hidden".equals(((ReactViewGroup)paramViewGroup).getOverflow());
      return false;
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.j
 * JD-Core Version:    0.6.2
 */