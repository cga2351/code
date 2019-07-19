package com.viber.voip.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.BaseBehavior.BaseDragCallback;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.AppBarLayout.Behavior.DragCallback;
import android.util.AttributeSet;

public class NoDraggingAppBarScrollBehavior extends AppBarLayout.Behavior
{
  public NoDraggingAppBarScrollBehavior()
  {
    init();
  }

  public NoDraggingAppBarScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  private void init()
  {
    super.setDragCallback(new AppBarLayout.Behavior.DragCallback()
    {
      public boolean canDrag(AppBarLayout paramAnonymousAppBarLayout)
      {
        return false;
      }
    });
  }

  public void setDragCallback(AppBarLayout.BaseBehavior.BaseDragCallback paramBaseDragCallback)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.NoDraggingAppBarScrollBehavior
 * JD-Core Version:    0.6.2
 */