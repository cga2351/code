package com.facebook.react.views.modal;

import android.graphics.Point;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

class ModalHostShadowNode extends LayoutShadowNode
{
  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    Point localPoint = ModalHostHelper.getModalHostSize(getThemedContext());
    paramReactShadowNodeImpl.setStyleWidth(localPoint.x);
    paramReactShadowNodeImpl.setStyleHeight(localPoint.y);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ModalHostShadowNode
 * JD-Core Version:    0.6.2
 */