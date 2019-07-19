package com.viber.voip.widget.toolbar;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;

public class ContactDetailsToolbarBehavior extends ToolbarCustomViewBehavior
{
  private ToolbarCustomView mToolbarView;

  public ContactDetailsToolbarBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void adjustViews(float paramFloat1, float paramFloat2)
  {
    CharSequence localCharSequence;
    if (this.mTitleContainerVisibleRect != null)
    {
      localCharSequence = this.mToolbarView.b.getText();
      if (this.mTitle == null)
        break label128;
      if (!this.mTitle.equals(localCharSequence))
      {
        this.mTitle = localCharSequence;
        if (TextUtils.isEmpty(this.mTitle))
          break label135;
      }
    }
    label128: label135: for (float f1 = this.mToolbarView.b.getPaint().measureText(this.mTitle.toString()); ; f1 = 0.0F)
    {
      this.mTitleWidth = f1;
      do
      {
        if (this.mTitleWidth > 0.0F)
        {
          float f2 = this.mTitleContainerVisibleRect.width();
          if (paramFloat2 * this.mTitleWidth <= f2)
            break;
          this.mToolbarView.b.setWidth((int)(f2 / paramFloat2));
        }
        return;
      }
      while (localCharSequence == null);
      break;
    }
    this.mToolbarView.b.setWidth((int)(paramFloat2 * this.mTitleWidth));
  }

  protected TextView getSubtitleView()
  {
    return this.mToolbarView.c;
  }

  protected TextView getTitleView()
  {
    return this.mToolbarView.b;
  }

  protected void shouldInitProperties(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, View paramView)
  {
    super.shouldInitProperties(paramCoordinatorLayout, paramViewGroup, paramView);
    if (this.mToolbarView == null)
    {
      if ((paramViewGroup instanceof ToolbarCustomView))
        this.mToolbarView = ((ToolbarCustomView)paramViewGroup);
    }
    else
      return;
    this.mToolbarView = ((ToolbarCustomView)paramViewGroup.findViewById(R.id.float_toolbar_custom));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.ContactDetailsToolbarBehavior
 * JD-Core Version:    0.6.2
 */