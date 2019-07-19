package com.viber.voip.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class y extends d
{
  private static final Logger L = ViberEnv.getLogger();
  protected final Context mContext;
  private LayoutInflater mInflater;
  private boolean mIsViewAdded;
  protected final a mResourceProvider;
  protected final Resources mResources;
  protected View mView;
  protected final View.OnClickListener mViewClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      y.this.onClick(paramAnonymousView);
    }
  };
  protected final WindowManager mWindowManager;

  public y(Context paramContext, a parama, LayoutInflater paramLayoutInflater)
  {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mResourceProvider = parama;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mInflater = paramLayoutInflater;
  }

  @SuppressLint({"RtlHardcoded"})
  private WindowManager.LayoutParams createMinimizedAlertWindowLayoutParams()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = this.mResourceProvider.width();
    localLayoutParams.height = this.mResourceProvider.height();
    localLayoutParams.y = this.mResourceProvider.topMargin();
    if (a.m());
    for (int i = 2038; ; i = 2007)
    {
      localLayoutParams.type = i;
      localLayoutParams.gravity = 53;
      localLayoutParams.format = -3;
      localLayoutParams.flags = 262184;
      return localLayoutParams;
    }
  }

  protected void addMinimizedView()
  {
    if (this.mIsViewAdded)
      return;
    if (this.mView == null)
      initMinimizedView();
    try
    {
      this.mWindowManager.addView(this.mView, createMinimizedAlertWindowLayoutParams());
      this.mIsViewAdded = true;
      notifyOnVisibilityChanged(isAlertWindowVisible());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      this.mView = null;
    }
  }

  public void hideAlertWindow()
  {
    hideInternally();
  }

  protected void hideInternally()
  {
    if ((this.mView != null) && (this.mView.getVisibility() != 8))
    {
      this.mView.startAnimation(AnimationUtils.loadAnimation(this.mContext, 17432577));
      this.mView.setVisibility(8);
      notifyOnVisibilityChanged(false);
    }
  }

  @SuppressLint({"InflateParams"})
  protected void initMinimizedView()
  {
    this.mView = this.mInflater.inflate(this.mResourceProvider.layoutId(), null);
    this.mView.setOnClickListener(this.mViewClickListener);
  }

  public boolean isAlertWindowVisible()
  {
    return (this.mView != null) && (8 != this.mView.getVisibility());
  }

  protected void onClick(View paramView)
  {
    notifyOnClick();
  }

  protected void removeMinimizedView()
  {
    if (this.mView != null)
    {
      this.mView.setOnClickListener(null);
      if (this.mIsViewAdded)
        this.mWindowManager.removeView(this.mView);
      this.mView = null;
      this.mIsViewAdded = false;
      notifyOnVisibilityChanged(false);
    }
  }

  public void showAlertWindow()
  {
    showInternally();
  }

  protected void showInternally()
  {
    if ((this.mView != null) && (this.mView.getVisibility() != 0))
    {
      this.mView.startAnimation(AnimationUtils.loadAnimation(this.mContext, 17432576));
      this.mView.setVisibility(0);
      notifyOnVisibilityChanged(true);
    }
  }

  public static abstract class a
  {
    protected final Context mContext;
    protected final Resources mResources;

    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mResources = paramContext.getResources();
    }

    public abstract int height();

    public abstract int layoutId();

    public abstract int topMargin();

    public abstract int width();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.y
 * JD-Core Version:    0.6.2
 */