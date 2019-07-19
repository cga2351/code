package com.viber.voip.banner.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.viber.voip.R.id;
import com.viber.voip.banner.datatype.Banner;
import com.viber.voip.util.ViberActionRunner;

public class b extends FrameLayout
  implements View.OnClickListener
{
  public static final int CLICK_SOURCE_BANNER = 0;
  public static final int CLICK_SOURCE_BUTTON = 1;
  protected ImageView mBackgroundImageView;
  protected Banner mBannerMeta;
  private boolean mIsInitiated = false;
  protected LinearLayout mItemsViewGroup;

  public b(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  @TargetApi(21)
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }

  protected ViewGroup.LayoutParams getBackgroundImageDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }

  public ImageView getBackgroundImageView()
  {
    return this.mBackgroundImageView;
  }

  protected ViewGroup.LayoutParams getItemsDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }

  public LinearLayout getItemsViewGroup()
  {
    return this.mItemsViewGroup;
  }

  protected void init()
  {
    if (this.mIsInitiated)
      return;
    this.mBackgroundImageView = new ImageView(getContext());
    this.mBackgroundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.mBackgroundImageView, getBackgroundImageDefaultLayoutParams());
    this.mItemsViewGroup = new LinearLayout(getContext());
    addView(this.mItemsViewGroup, getItemsDefaultLayoutParams());
    this.mIsInitiated = true;
  }

  protected void onAction(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString));
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }
    while (!ViberActionRunner.a(localIntent, getContext()));
    getContext().startActivity(localIntent);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.after_call_ad_text) || (i == R.id.after_call_ad_title) || (i == R.id.after_call_ad_app_icon) || (i == R.id.after_call_ad_image) || (i == R.id.after_call_ad_media) || (i == R.id.remote_banner_container))
      onAction((String)paramView.getTag(R.id.tag_action), 0);
    do
    {
      return;
      if (i == R.id.remote_banner_button)
      {
        onAction((String)paramView.getTag(R.id.tag_action), 1);
        return;
      }
    }
    while (i != R.id.remote_banner_dismiss);
    onClose();
  }

  protected void onClose()
  {
  }

  public void setBannerMeta(Banner paramBanner)
  {
    this.mBannerMeta = paramBanner;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.b
 * JD-Core Version:    0.6.2
 */