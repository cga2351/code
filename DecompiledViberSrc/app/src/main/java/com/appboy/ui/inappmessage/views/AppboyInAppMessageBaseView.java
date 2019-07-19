package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appboy.e.b;
import com.appboy.ui.inappmessage.IInAppMessageView;
import com.appboy.ui.support.ViewUtils;

public abstract class AppboyInAppMessageBaseView extends RelativeLayout
  implements IInAppMessageView
{
  public AppboyInAppMessageBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public String getAppropriateImageUrl(b paramb)
  {
    if (!com.appboy.f.i.c(paramb.k()))
      return paramb.k();
    return paramb.j();
  }

  public abstract Object getMessageBackgroundObject();

  public View getMessageClickableView()
  {
    return this;
  }

  public abstract TextView getMessageIconView();

  public abstract ImageView getMessageImageView();

  public abstract TextView getMessageTextView();

  public void resetMessageMargins(boolean paramBoolean)
  {
    ImageView localImageView = getMessageImageView();
    if (localImageView != null)
    {
      if (paramBoolean)
        break label48;
      ViewUtils.removeViewFromParent(localImageView);
    }
    while (true)
    {
      if ((getMessageIconView() != null) && (com.appboy.f.i.c((String)getMessageIconView().getText())))
        ViewUtils.removeViewFromParent(getMessageIconView());
      return;
      label48: ViewUtils.removeViewFromParent(getMessageIconView());
    }
  }

  public void setMessage(String paramString)
  {
    getMessageTextView().setText(paramString);
  }

  public void setMessageBackgroundColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColor((View)getMessageBackgroundObject(), paramInt);
  }

  public void setMessageIcon(String paramString, int paramInt1, int paramInt2)
  {
    if (getMessageIconView() != null)
      InAppMessageViewUtils.setIcon(getContext(), paramString, paramInt1, paramInt2, getMessageIconView());
  }

  public void setMessageImageView(Bitmap paramBitmap)
  {
    InAppMessageViewUtils.setImage(paramBitmap, getMessageImageView());
  }

  public void setMessageTextAlign(com.appboy.b.a.i parami)
  {
    InAppMessageViewUtils.setTextAlignment(getMessageTextView(), parami);
  }

  public void setMessageTextColor(int paramInt)
  {
    InAppMessageViewUtils.setTextViewColor(getMessageTextView(), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageBaseView
 * JD-Core Version:    0.6.2
 */