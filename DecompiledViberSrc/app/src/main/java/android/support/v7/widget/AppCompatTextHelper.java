package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private boolean mAsyncFontPending;
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mStyle = 0;
  private final TextView mView;

  AppCompatTextHelper(TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }

  private void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null))
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
  }

  private static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    ColorStateList localColorStateList = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (localColorStateList != null)
    {
      TintInfo localTintInfo = new TintInfo();
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = localColorStateList;
      return localTintInfo;
    }
    return null;
  }

  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }

  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    int i = 1;
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    int j;
    if ((paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily)) || (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      this.mFontTypeface = null;
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily))
        j = R.styleable.TextAppearance_fontFamily;
    }
    while (true)
    {
      ResourcesCompat.FontCallback local1;
      if (!paramContext.isRestricted())
        local1 = new ResourcesCompat.FontCallback()
        {
          public void onFontRetrievalFailed(int paramAnonymousInt)
          {
          }

          public void onFontRetrieved(Typeface paramAnonymousTypeface)
          {
            AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, paramAnonymousTypeface);
          }
        };
      try
      {
        this.mFontTypeface = paramTintTypedArray.getFont(j, this.mStyle, local1);
        if (this.mFontTypeface == null)
        {
          label108: this.mAsyncFontPending = i;
          label113: if (this.mFontTypeface == null)
          {
            String str = paramTintTypedArray.getString(j);
            if (str != null)
              this.mFontTypeface = Typeface.create(str, this.mStyle);
          }
        }
        do
        {
          return;
          j = R.styleable.TextAppearance_android_fontFamily;
          break;
          i = 0;
          break label108;
        }
        while (!paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface));
        this.mAsyncFontPending = false;
        switch (paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, i))
        {
        default:
          return;
        case 1:
          this.mFontTypeface = Typeface.SANS_SERIF;
          return;
        case 2:
          this.mFontTypeface = Typeface.SERIF;
          return;
        case 3:
        }
        this.mFontTypeface = Typeface.MONOSPACE;
        return;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        break label113;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label113;
      }
    }
  }

  void applyCompoundDrawablesTints()
  {
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      Drawable[] arrayOfDrawable1 = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable1[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable1[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable1[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable1[3], this.mDrawableBottomTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null)))
    {
      Drawable[] arrayOfDrawable2 = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable2[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable2[2], this.mDrawableEndTint);
    }
  }

  void autoSizeText()
  {
    this.mAutoSizeTextHelper.autoSizeText();
  }

  int getAutoSizeMaxTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }

  int getAutoSizeMinTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }

  int getAutoSizeStepGranularity()
  {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }

  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }

  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }

  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }

  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    TintTypedArray localTintTypedArray1 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft))
      this.mDrawableLeftTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop))
      this.mDrawableTopTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight))
      this.mDrawableRightTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom))
      this.mDrawableBottomTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart))
        this.mDrawableStartTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
      if (localTintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd))
        this.mDrawableEndTint = createTintInfo(localContext, localAppCompatDrawableManager, localTintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    }
    localTintTypedArray1.recycle();
    boolean bool1 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool2;
    int j;
    ColorStateList localColorStateList1;
    label324: ColorStateList localColorStateList3;
    label345: ColorStateList localColorStateList2;
    if (i != -1)
    {
      TintTypedArray localTintTypedArray4 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if ((!bool1) && (localTintTypedArray4.hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool2 = localTintTypedArray4.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        j = 1;
        updateTypefaceAndStyle(localContext, localTintTypedArray4);
        if (Build.VERSION.SDK_INT < 23)
          if (localTintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColor))
          {
            localColorStateList1 = localTintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (localTintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColorHint))
            {
              localColorStateList3 = localTintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
              boolean bool3 = localTintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColorLink);
              localColorStateList2 = null;
              if (bool3)
                localColorStateList2 = localTintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
              label373: localTintTypedArray4.recycle();
            }
          }
      }
    }
    while (true)
    {
      TintTypedArray localTintTypedArray2 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
      if ((!bool1) && (localTintTypedArray2.hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool2 = localTintTypedArray2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        j = 1;
      }
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localTintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColor))
          localColorStateList1 = localTintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColor);
        if (localTintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorHint))
          localColorStateList3 = localTintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        if (localTintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorLink))
          localColorStateList2 = localTintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
      }
      if ((Build.VERSION.SDK_INT >= 28) && (localTintTypedArray2.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray2.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0))
        this.mView.setTextSize(0, 0.0F);
      updateTypefaceAndStyle(localContext, localTintTypedArray2);
      localTintTypedArray2.recycle();
      if (localColorStateList1 != null)
        this.mView.setTextColor(localColorStateList1);
      if (localColorStateList3 != null)
        this.mView.setHintTextColor(localColorStateList3);
      if (localColorStateList2 != null)
        this.mView.setLinkTextColor(localColorStateList2);
      if ((!bool1) && (j != 0))
        setAllCaps(bool2);
      if (this.mFontTypeface != null)
        this.mView.setTypeface(this.mFontTypeface, this.mStyle);
      this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
      int[] arrayOfInt;
      if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
      {
        arrayOfInt = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (arrayOfInt.length > 0)
        {
          if (this.mView.getAutoSizeStepGranularity() == -1.0F)
            break label801;
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        }
      }
      while (true)
      {
        TintTypedArray localTintTypedArray3 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextView);
        int k = localTintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int m = localTintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int n = localTintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        localTintTypedArray3.recycle();
        if (k != -1)
          TextViewCompat.setFirstBaselineToTopHeight(this.mView, k);
        if (m != -1)
          TextViewCompat.setLastBaselineToBottomHeight(this.mView, m);
        if (n != -1)
          TextViewCompat.setLineHeight(this.mView, n);
        return;
        label801: this.mView.setAutoSizeTextTypeUniformWithPresetSizes(arrayOfInt, 0);
      }
      localColorStateList3 = null;
      break label345;
      localColorStateList1 = null;
      break label324;
      localColorStateList1 = null;
      localColorStateList2 = null;
      localColorStateList3 = null;
      break label373;
      j = 0;
      bool2 = false;
      break;
      j = 0;
      bool2 = false;
      localColorStateList1 = null;
      localColorStateList2 = null;
      localColorStateList3 = null;
    }
  }

  void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mFontTypeface = paramTypeface;
      TextView localTextView = (TextView)paramWeakReference.get();
      if (localTextView != null)
        localTextView.setTypeface(paramTypeface, this.mStyle);
    }
  }

  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE)
      autoSizeText();
  }

  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
      setAllCaps(localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    if ((Build.VERSION.SDK_INT < 23) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null)
        this.mView.setTextColor(localColorStateList);
    }
    if ((localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0))
      this.mView.setTextSize(0, 0.0F);
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (this.mFontTypeface != null)
      this.mView.setTypeface(this.mFontTypeface, this.mStyle);
  }

  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }

  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }

  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }

  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled()))
      setTextSizeInternal(paramInt, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelper
 * JD-Core Version:    0.6.2
 */