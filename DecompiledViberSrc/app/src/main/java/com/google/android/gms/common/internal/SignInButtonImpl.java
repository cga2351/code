package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.base.R.color;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button
{
  public SignInButtonImpl(Context paramContext)
  {
    this(paramContext, null);
  }

  public SignInButtonImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }

  private static int zaa(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalStateException(33 + "Unknown color scheme: " + paramInt1);
    case 1:
      paramInt2 = paramInt3;
    case 0:
      return paramInt2;
    case 2:
    }
    return paramInt4;
  }

  public final void configure(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(0.5F + f * 48.0F));
    setMinWidth((int)(0.5F + f * 48.0F));
    int i = zaa(paramInt2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
    int j = zaa(paramInt2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
    switch (paramInt1)
    {
    default:
      throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
    case 2:
      j = i;
    case 0:
    case 1:
    }
    Drawable localDrawable = DrawableCompat.wrap(paramResources.getDrawable(j));
    DrawableCompat.setTintList(localDrawable, paramResources.getColorStateList(R.color.common_google_signin_btn_tint));
    DrawableCompat.setTintMode(localDrawable, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable(localDrawable);
    setTextColor((ColorStateList)Preconditions.checkNotNull(paramResources.getColorStateList(zaa(paramInt2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
    switch (paramInt1)
    {
    default:
      throw new IllegalStateException(32 + "Unknown button size: " + paramInt1);
    case 0:
      setText(paramResources.getString(R.string.common_signin_button_text));
    case 1:
    case 2:
    }
    while (true)
    {
      setTransformationMethod(null);
      if (DeviceProperties.isWearable(getContext()))
        setGravity(19);
      return;
      setText(paramResources.getString(R.string.common_signin_button_text_long));
      continue;
      setText(null);
    }
  }

  public final void configure(Resources paramResources, SignInButtonConfig paramSignInButtonConfig)
  {
    configure(paramResources, paramSignInButtonConfig.getButtonSize(), paramSignInButtonConfig.getColorScheme());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonImpl
 * JD-Core Version:    0.6.2
 */