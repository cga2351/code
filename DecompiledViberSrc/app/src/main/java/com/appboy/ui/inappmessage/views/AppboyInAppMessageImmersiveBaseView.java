package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import com.appboy.e.n;
import com.appboy.f.c;
import com.appboy.ui.inappmessage.IInAppMessageImmersiveView;
import com.appboy.ui.support.ViewUtils;
import java.util.List;

public abstract class AppboyInAppMessageImmersiveBaseView extends AppboyInAppMessageBaseView
  implements IInAppMessageImmersiveView
{
  private static final String TAG = c.a(AppboyInAppMessageImmersiveBaseView.class);

  public AppboyInAppMessageImmersiveBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void setLargerCloseButtonClickArea(final View paramView)
  {
    if ((paramView == null) || (paramView.getParent() == null))
      c.d(TAG, "Cannot increase click area for view if view and/or parent are null.");
    while (!(paramView.getParent() instanceof View))
      return;
    ((View)paramView.getParent()).post(new Runnable()
    {
      public void run()
      {
        Rect localRect = new Rect();
        paramView.getHitRect(localRect);
        int i = (int)ViewUtils.convertDpToPixels(AppboyInAppMessageImmersiveBaseView.this.getContext(), 15.0D);
        int j = (int)ViewUtils.convertDpToPixels(AppboyInAppMessageImmersiveBaseView.this.getContext(), 10.0D);
        localRect.right = (i + localRect.right);
        localRect.bottom = (j + localRect.bottom);
        localRect.left -= j;
        localRect.top -= i;
        TouchDelegate localTouchDelegate = new TouchDelegate(localRect, paramView);
        ((View)paramView.getParent()).setTouchDelegate(localTouchDelegate);
      }
    });
  }

  public abstract View getFrameView();

  public abstract List<View> getMessageButtonViews(int paramInt);

  public abstract TextView getMessageHeaderTextView();

  public abstract TextView getMessageTextView();

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    if (com.appboy.f.i.c(getMessageTextView().getText().toString()))
      ViewUtils.removeViewFromParent(getMessageTextView());
    if (com.appboy.f.i.c(getMessageHeaderTextView().getText().toString()))
      ViewUtils.removeViewFromParent(getMessageHeaderTextView());
    InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
    setLargerCloseButtonClickArea(getMessageCloseButtonView());
  }

  public void setFrameColor(Integer paramInteger)
  {
    InAppMessageViewUtils.setFrameColor(getFrameView(), paramInteger);
  }

  public void setMessageButtons(List<n> paramList)
  {
    if (paramList != null);
    for (int i = paramList.size(); ; i = 0)
    {
      InAppMessageViewUtils.setButtons(getMessageButtonViews(i), paramList);
      return;
    }
  }

  public void setMessageCloseButtonColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColorFilter(getMessageCloseButtonView(), paramInt);
  }

  public void setMessageHeaderText(String paramString)
  {
    getMessageHeaderTextView().setText(paramString);
  }

  public void setMessageHeaderTextAlignment(com.appboy.b.a.i parami)
  {
    InAppMessageViewUtils.setTextAlignment(getMessageHeaderTextView(), parami);
  }

  public void setMessageHeaderTextColor(int paramInt)
  {
    InAppMessageViewUtils.setTextViewColor(getMessageHeaderTextView(), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageImmersiveBaseView
 * JD-Core Version:    0.6.2
 */