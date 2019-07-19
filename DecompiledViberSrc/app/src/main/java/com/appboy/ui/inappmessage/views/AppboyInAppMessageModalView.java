package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.f.c;
import com.appboy.ui.R.dimen;
import com.appboy.ui.R.id;
import com.appboy.ui.inappmessage.AppboyInAppMessageImageView;
import com.appboy.ui.inappmessage.IInAppMessageImageView;
import com.appboy.ui.inappmessage.config.AppboyInAppMessageParams;
import com.appboy.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class AppboyInAppMessageModalView extends AppboyInAppMessageImmersiveBaseView
{
  private static final String TAG = c.a(AppboyInAppMessageModalView.class);
  private AppboyInAppMessageImageView mAppboyInAppMessageImageView;

  public AppboyInAppMessageModalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void resizeGraphicFrameIfAppropriate(Context paramContext, com.appboy.e.d paramd, final double paramDouble)
  {
    if (!paramd.C().equals(com.appboy.b.a.d.a))
      return;
    Resources localResources = paramContext.getResources();
    post(new Runnable()
    {
      public void run()
      {
        double d1 = Math.min(AppboyInAppMessageModalView.this.getMeasuredWidth() - this.val$marginPixels, this.val$maxModalWidth);
        double d2 = Math.min(AppboyInAppMessageModalView.this.getMeasuredHeight() - this.val$marginPixels, this.val$maxModalHeight);
        double d3 = d1 / d2;
        View localView = AppboyInAppMessageModalView.this.findViewById(R.id.com_appboy_inappmessage_modal_graphic_bound);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        if (paramDouble >= d3)
          localLayoutParams.width = ((int)d1);
        for (localLayoutParams.height = ((int)(d1 / paramDouble)); ; localLayoutParams.height = ((int)d2))
        {
          localView.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams.width = ((int)(d2 * paramDouble));
        }
      }
    });
  }

  private void setInAppMessageImageViewAttributes(Context paramContext, com.appboy.e.d paramd, IInAppMessageImageView paramIInAppMessageImageView)
  {
    float f = (float)ViewUtils.convertDpToPixels(paramContext, AppboyInAppMessageParams.getModalizedImageRadiusDp());
    if (paramd.C().equals(com.appboy.b.a.d.a))
      paramIInAppMessageImageView.setCornersRadiusPx(f);
    while (true)
    {
      paramIInAppMessageImageView.setInAppMessageImageCropType(paramd.u());
      return;
      paramIInAppMessageImageView.setCornersRadiiPx(f, f, 0.0F, 0.0F);
    }
  }

  public void applyInAppMessageParameters(Context paramContext, com.appboy.e.d paramd)
  {
    this.mAppboyInAppMessageImageView = ((AppboyInAppMessageImageView)findViewById(R.id.com_appboy_inappmessage_modal_imageview));
    setInAppMessageImageViewAttributes(paramContext, paramd, this.mAppboyInAppMessageImageView);
    if ((paramd.C().equals(com.appboy.b.a.d.a)) && (paramd.p() != null))
      resizeGraphicFrameIfAppropriate(paramContext, paramd, paramd.p().getWidth() / paramd.p().getHeight());
  }

  public View getFrameView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal_frame);
  }

  public Drawable getMessageBackgroundObject()
  {
    return getMessageClickableView().getBackground();
  }

  public List<View> getMessageButtonViews(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      View localView4 = findViewById(R.id.com_appboy_inappmessage_modal_button_layout_single);
      if (localView4 != null)
        localView4.setVisibility(0);
      View localView5 = findViewById(R.id.com_appboy_inappmessage_modal_button_single_one);
      if (localView5 != null)
        localArrayList.add(localView5);
    }
    View localView3;
    do
    {
      do
        return localArrayList;
      while (paramInt != 2);
      View localView1 = findViewById(R.id.com_appboy_inappmessage_modal_button_layout_dual);
      if (localView1 != null)
        localView1.setVisibility(0);
      View localView2 = findViewById(R.id.com_appboy_inappmessage_modal_button_dual_one);
      localView3 = findViewById(R.id.com_appboy_inappmessage_modal_button_dual_two);
      if (localView2 != null)
        localArrayList.add(localView2);
    }
    while (localView3 == null);
    localArrayList.add(localView3);
    return localArrayList;
  }

  public View getMessageClickableView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal);
  }

  public View getMessageCloseButtonView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal_close_button);
  }

  public TextView getMessageHeaderTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_header_text);
  }

  public TextView getMessageIconView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_icon);
  }

  public ImageView getMessageImageView()
  {
    return this.mAppboyInAppMessageImageView;
  }

  public TextView getMessageTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_message);
  }

  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(R.id.com_appboy_inappmessage_modal_image_layout);
    if (((paramBoolean) || (getMessageIconView() != null)) && (localRelativeLayout != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(0, 0, 0, 0);
      localRelativeLayout.setLayoutParams(localLayoutParams);
    }
    findViewById(R.id.com_appboy_inappmessage_modal_text_layout).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.b(AppboyInAppMessageModalView.TAG, "Passing scrollView click event to message clickable view.");
        AppboyInAppMessageModalView.this.getMessageClickableView().performClick();
      }
    });
  }

  public void setMessageBackgroundColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColorFilter(findViewById(R.id.com_appboy_inappmessage_modal), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageModalView
 * JD-Core Version:    0.6.2
 */