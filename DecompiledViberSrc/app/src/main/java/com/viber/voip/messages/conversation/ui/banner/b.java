package com.viber.voip.messages.conversation.ui.banner;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.anim;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.banner.a.a;

public abstract class b
{
  public final View layout;
  private a mAlertViewUiCustomizer;
  protected Bundle mBundle;
  protected a mResourceProvider;
  private b mVisibilityListener;
  protected final Resources resources;

  public b(int paramInt, ViewGroup paramViewGroup, Bundle paramBundle, LayoutInflater paramLayoutInflater)
  {
    this(paramInt, paramViewGroup, paramLayoutInflater);
    this.mBundle = paramBundle;
  }

  public b(int paramInt, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    this(paramLayoutInflater.inflate(paramInt, paramViewGroup, false));
  }

  public b(int paramInt, ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    this(paramInt, paramViewGroup, paramLayoutInflater);
    this.mResourceProvider = parama;
  }

  public b(int paramInt, ViewGroup paramViewGroup, a parama, b paramb, LayoutInflater paramLayoutInflater)
  {
    this(paramInt, paramViewGroup, parama, paramLayoutInflater);
    this.mVisibilityListener = paramb;
  }

  public b(View paramView)
  {
    this.layout = paramView;
    this.resources = paramView.getResources();
  }

  private a getAlertViewUiCustomizer()
  {
    if (this.mAlertViewUiCustomizer == null)
      this.mAlertViewUiCustomizer = createAlertViewUiCustomizer();
    return this.mAlertViewUiCustomizer;
  }

  protected void applyUiSettings(at paramat)
  {
    if (paramat != null)
      getAlertViewUiCustomizer().a(paramat);
  }

  protected a createAlertViewUiCustomizer()
  {
    return new com.viber.voip.messages.conversation.ui.banner.a.b(this.layout);
  }

  protected int getAppearanceOrder()
  {
    return 0;
  }

  public int getEmptyViewHeight()
  {
    return 0;
  }

  final int getHideAnimationResId()
  {
    if (this.mResourceProvider != null)
      return this.mResourceProvider.b();
    return R.anim.alert_slide_out;
  }

  public int getMeasuredHeight()
  {
    return 0;
  }

  public abstract AlertView.a getMode();

  final int getShowAnimationResId()
  {
    if (this.mResourceProvider != null)
      return this.mResourceProvider.a();
    return R.anim.alert_slide_in;
  }

  final boolean isLaidNextOrOver(int paramInt)
  {
    return getAppearanceOrder() >= paramInt;
  }

  public boolean isPriorityAlert()
  {
    return false;
  }

  public void onHide()
  {
    if (this.mVisibilityListener != null)
      this.mVisibilityListener.onAlertBannerVisibilityChanged(false);
  }

  public void onShow()
  {
    if (this.mVisibilityListener != null)
      this.mVisibilityListener.onAlertBannerVisibilityChanged(true);
  }

  public void setBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }

  public static abstract interface a
  {
    public abstract int a();

    public abstract int b();
  }

  public static abstract interface b
  {
    public abstract void onAlertBannerVisibilityChanged(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.b
 * JD-Core Version:    0.6.2
 */