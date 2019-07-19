package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.b.a.a;
import com.appboy.e.b;
import com.appboy.ui.R.dimen;
import com.appboy.ui.R.id;
import com.appboy.ui.inappmessage.AppboyInAppMessageImageView;
import com.appboy.ui.support.ViewUtils;

public class AppboyInAppMessageSlideupView extends AppboyInAppMessageBaseView
{
  private AppboyInAppMessageImageView mAppboyInAppMessageImageView;

  public AppboyInAppMessageSlideupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void applyInAppMessageParameters(b paramb)
  {
    this.mAppboyInAppMessageImageView = ((AppboyInAppMessageImageView)findViewById(R.id.com_appboy_inappmessage_slideup_imageview));
    this.mAppboyInAppMessageImageView.setInAppMessageImageCropType(paramb.u());
  }

  public View getMessageBackgroundObject()
  {
    return findViewById(R.id.com_appboy_inappmessage_slideup_container);
  }

  public View getMessageChevronView()
  {
    return findViewById(R.id.com_appboy_inappmessage_slideup_chevron);
  }

  public TextView getMessageIconView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_slideup_icon);
  }

  public ImageView getMessageImageView()
  {
    return this.mAppboyInAppMessageImageView;
  }

  public TextView getMessageTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_slideup_message);
  }

  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    if ((getMessageIconView() == null) || (getMessageIconView().getText() == null) || (getMessageIconView().getText().length() == 0));
    for (int i = 1; ; i = 0)
    {
      if ((!paramBoolean) && (i != 0))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(R.id.com_appboy_inappmessage_slideup_image_layout);
        if (localRelativeLayout != null)
          ViewUtils.removeViewFromParent(localRelativeLayout);
        TextView localTextView = (TextView)findViewById(R.id.com_appboy_inappmessage_slideup_message);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.com_appboy_in_app_message_slideup_left_message_margin_no_image);
        localTextView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }

  public void setMessageBackgroundColor(int paramInt)
  {
    if ((getMessageBackgroundObject().getBackground() instanceof GradientDrawable))
    {
      InAppMessageViewUtils.setViewBackgroundColorFilter(getMessageBackgroundObject(), paramInt);
      return;
    }
    super.setMessageBackgroundColor(paramInt);
  }

  public void setMessageChevron(int paramInt, a parama)
  {
    switch (1.$SwitchMap$com$appboy$enums$inappmessage$ClickAction[parama.ordinal()])
    {
    default:
      InAppMessageViewUtils.setViewBackgroundColorFilter(getMessageChevronView(), paramInt);
      return;
    case 1:
    }
    getMessageChevronView().setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageSlideupView
 * JD-Core Version:    0.6.2
 */