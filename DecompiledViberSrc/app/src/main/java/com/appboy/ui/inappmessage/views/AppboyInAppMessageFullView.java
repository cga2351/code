package com.appboy.ui.inappmessage.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.f.c;
import com.appboy.ui.R.id;
import com.appboy.ui.inappmessage.AppboyInAppMessageImageView;
import com.appboy.ui.inappmessage.IInAppMessageImageView;
import com.appboy.ui.inappmessage.config.AppboyInAppMessageParams;
import com.appboy.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class AppboyInAppMessageFullView extends AppboyInAppMessageImmersiveBaseView
{
  private static final String TAG = c.a(AppboyInAppMessageFullView.class);
  private AppboyInAppMessageImageView mAppboyInAppMessageImageView;

  public AppboyInAppMessageFullView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void setInAppMessageImageViewAttributes(Activity paramActivity, com.appboy.e.d paramd, IInAppMessageImageView paramIInAppMessageImageView)
  {
    paramIInAppMessageImageView.setInAppMessageImageCropType(paramd.u());
    if (ViewUtils.isRunningOnTablet(paramActivity))
    {
      float f = (float)ViewUtils.convertDpToPixels(paramActivity, AppboyInAppMessageParams.getModalizedImageRadiusDp());
      if (paramd.C().equals(com.appboy.b.a.d.a))
      {
        paramIInAppMessageImageView.setCornersRadiusPx(f);
        return;
      }
      paramIInAppMessageImageView.setCornersRadiiPx(f, f, 0.0F, 0.0F);
      return;
    }
    paramIInAppMessageImageView.setCornersRadiusPx(0.0F);
  }

  public void createAppropriateViews(Activity paramActivity, com.appboy.e.d paramd)
  {
    this.mAppboyInAppMessageImageView = ((AppboyInAppMessageImageView)findViewById(R.id.com_appboy_inappmessage_full_imageview));
    setInAppMessageImageViewAttributes(paramActivity, paramd, this.mAppboyInAppMessageImageView);
  }

  public View getFrameView()
  {
    return findViewById(R.id.com_appboy_inappmessage_full_frame);
  }

  public int getLongEdge()
  {
    return findViewById(R.id.com_appboy_inappmessage_full).getLayoutParams().height;
  }

  public View getMessageBackgroundObject()
  {
    return findViewById(R.id.com_appboy_inappmessage_full);
  }

  public List<View> getMessageButtonViews(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      View localView4 = findViewById(R.id.com_appboy_inappmessage_full_button_layout_single);
      if (localView4 != null)
        localView4.setVisibility(0);
      View localView5 = findViewById(R.id.com_appboy_inappmessage_full_button_single_one);
      if (localView5 != null)
        localArrayList.add(localView5);
    }
    View localView3;
    do
    {
      do
        return localArrayList;
      while (paramInt != 2);
      View localView1 = findViewById(R.id.com_appboy_inappmessage_full_button_layout_dual);
      if (localView1 != null)
        localView1.setVisibility(0);
      View localView2 = findViewById(R.id.com_appboy_inappmessage_full_button_dual_one);
      localView3 = findViewById(R.id.com_appboy_inappmessage_full_button_dual_two);
      if (localView2 != null)
        localArrayList.add(localView2);
    }
    while (localView3 == null);
    localArrayList.add(localView3);
    return localArrayList;
  }

  public View getMessageClickableView()
  {
    return findViewById(R.id.com_appboy_inappmessage_full);
  }

  public View getMessageCloseButtonView()
  {
    return findViewById(R.id.com_appboy_inappmessage_full_close_button);
  }

  public TextView getMessageHeaderTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_full_header_text);
  }

  public TextView getMessageIconView()
  {
    return null;
  }

  public ImageView getMessageImageView()
  {
    return this.mAppboyInAppMessageImageView;
  }

  public TextView getMessageTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_full_message);
  }

  public int getShortEdge()
  {
    return findViewById(R.id.com_appboy_inappmessage_full).getLayoutParams().width;
  }

  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    findViewById(R.id.com_appboy_inappmessage_full_text_layout).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.b(AppboyInAppMessageFullView.TAG, "Passing scrollView click event to message clickable view.");
        AppboyInAppMessageFullView.this.getMessageClickableView().performClick();
      }
    });
  }

  public void setMessageBackgroundColor(int paramInt)
  {
    if ((getMessageBackgroundObject().getBackground() instanceof GradientDrawable))
    {
      InAppMessageViewUtils.setViewBackgroundColorFilter(findViewById(R.id.com_appboy_inappmessage_full), paramInt);
      return;
    }
    super.setMessageBackgroundColor(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageFullView
 * JD-Core Version:    0.6.2
 */