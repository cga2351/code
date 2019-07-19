package com.viber.voip.widget;

import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

public class t extends LinearSnapHelper
{
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = super.findTargetSnapPosition(paramLayoutManager, paramInt1, paramInt2);
    if (i == -1);
    int j;
    do
    {
      return i;
      View localView = findSnapView(paramLayoutManager);
      if (localView == null)
        return -1;
      j = paramLayoutManager.getPosition(localView);
      if (j == -1)
        return -1;
      if (i < j)
        return j - 1;
    }
    while (i <= j);
    return j + 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.t
 * JD-Core Version:    0.6.2
 */