package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.base.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View zaas;
  private View.OnClickListener zaat = null;

  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      this.mSize = localTypedArray.getInt(R.styleable.SignInButton_buttonSize, 0);
      this.mColor = localTypedArray.getInt(R.styleable.SignInButton_colorScheme, 2);
      localTypedArray.recycle();
      setStyle(this.mSize, this.mColor);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public final void onClick(View paramView)
  {
    if ((this.zaat != null) && (paramView == this.zaas))
      this.zaat.onClick(this);
  }

  public final void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }

  public final void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.zaas.setEnabled(paramBoolean);
  }

  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zaat = paramOnClickListener;
    if (this.zaas != null)
      this.zaas.setOnClickListener(this);
  }

  @Deprecated
  public final void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(this.mSize, this.mColor);
  }

  public final void setSize(int paramInt)
  {
    setStyle(paramInt, this.mColor);
  }

  public final void setStyle(int paramInt1, int paramInt2)
  {
    this.mSize = paramInt1;
    this.mColor = paramInt2;
    Context localContext = getContext();
    if (this.zaas != null)
      removeView(this.zaas);
    try
    {
      this.zaas = SignInButtonCreator.createView(localContext, this.mSize, this.mColor);
      addView(this.zaas);
      this.zaas.setEnabled(isEnabled());
      this.zaas.setOnClickListener(this);
      return;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      while (true)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        int i = this.mSize;
        int j = this.mColor;
        SignInButtonImpl localSignInButtonImpl = new SignInButtonImpl(localContext);
        localSignInButtonImpl.configure(localContext.getResources(), i, j);
        this.zaas = localSignInButtonImpl;
      }
    }
  }

  @Deprecated
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.6.2
 */