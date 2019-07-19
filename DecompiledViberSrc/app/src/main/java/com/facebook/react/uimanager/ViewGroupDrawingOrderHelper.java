package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;

public class ViewGroupDrawingOrderHelper
{

  @Nullable
  private int[] mDrawingOrderIndices;
  private int mNumberOfChildrenWithZIndex = 0;
  private final ViewGroup mViewGroup;

  public ViewGroupDrawingOrderHelper(ViewGroup paramViewGroup)
  {
    this.mViewGroup = paramViewGroup;
  }

  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mDrawingOrderIndices == null)
    {
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < paramInt1; i++)
        localArrayList.add(this.mViewGroup.getChildAt(i));
      Collections.sort(localArrayList, new Comparator()
      {
        public int compare(View paramAnonymousView1, View paramAnonymousView2)
        {
          Integer localInteger1 = ViewGroupManager.getViewZIndex(paramAnonymousView1);
          if (localInteger1 == null)
            localInteger1 = Integer.valueOf(0);
          Integer localInteger2 = ViewGroupManager.getViewZIndex(paramAnonymousView2);
          if (localInteger2 == null)
            localInteger2 = Integer.valueOf(0);
          return localInteger1.intValue() - localInteger2.intValue();
        }
      });
      this.mDrawingOrderIndices = new int[paramInt1];
      for (int j = 0; j < paramInt1; j++)
      {
        View localView = (View)localArrayList.get(j);
        this.mDrawingOrderIndices[j] = this.mViewGroup.indexOfChild(localView);
      }
    }
    return this.mDrawingOrderIndices[paramInt2];
  }

  public void handleAddView(View paramView)
  {
    if (ViewGroupManager.getViewZIndex(paramView) != null)
      this.mNumberOfChildrenWithZIndex = (1 + this.mNumberOfChildrenWithZIndex);
    this.mDrawingOrderIndices = null;
  }

  public void handleRemoveView(View paramView)
  {
    if (ViewGroupManager.getViewZIndex(paramView) != null)
      this.mNumberOfChildrenWithZIndex = (-1 + this.mNumberOfChildrenWithZIndex);
    this.mDrawingOrderIndices = null;
  }

  public boolean shouldEnableCustomDrawingOrder()
  {
    return this.mNumberOfChildrenWithZIndex > 0;
  }

  public void update()
  {
    int i = 0;
    this.mNumberOfChildrenWithZIndex = 0;
    while (i < this.mViewGroup.getChildCount())
    {
      if (ViewGroupManager.getViewZIndex(this.mViewGroup.getChildAt(i)) != null)
        this.mNumberOfChildrenWithZIndex = (1 + this.mNumberOfChildrenWithZIndex);
      i++;
    }
    this.mDrawingOrderIndices = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewGroupDrawingOrderHelper
 * JD-Core Version:    0.6.2
 */