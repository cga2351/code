package com.facebook.react.views.text;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;

public class TextAttributes
{
  public static final float DEFAULT_MAX_FONT_SIZE_MULTIPLIER;
  private boolean mAllowFontScaling = true;
  private float mFontSize = (0.0F / 0.0F);
  private float mHeightOfTallestInlineImage = (0.0F / 0.0F);
  private float mLetterSpacing = (0.0F / 0.0F);
  private float mLineHeight = (0.0F / 0.0F);
  private float mMaxFontSizeMultiplier = (0.0F / 0.0F);
  private TextTransform mTextTransform = TextTransform.UNSET;

  public TextAttributes applyChild(TextAttributes paramTextAttributes)
  {
    TextAttributes localTextAttributes = new TextAttributes();
    localTextAttributes.mAllowFontScaling = this.mAllowFontScaling;
    float f1;
    float f2;
    label52: float f3;
    label74: float f4;
    label96: float f5;
    if (!Float.isNaN(paramTextAttributes.mFontSize))
    {
      f1 = paramTextAttributes.mFontSize;
      localTextAttributes.mFontSize = f1;
      if (Float.isNaN(paramTextAttributes.mLineHeight))
        break label156;
      f2 = paramTextAttributes.mLineHeight;
      localTextAttributes.mLineHeight = f2;
      if (Float.isNaN(paramTextAttributes.mLetterSpacing))
        break label165;
      f3 = paramTextAttributes.mLetterSpacing;
      localTextAttributes.mLetterSpacing = f3;
      if (Float.isNaN(paramTextAttributes.mMaxFontSizeMultiplier))
        break label174;
      f4 = paramTextAttributes.mMaxFontSizeMultiplier;
      localTextAttributes.mMaxFontSizeMultiplier = f4;
      if (Float.isNaN(paramTextAttributes.mHeightOfTallestInlineImage))
        break label183;
      f5 = paramTextAttributes.mHeightOfTallestInlineImage;
      label118: localTextAttributes.mHeightOfTallestInlineImage = f5;
      if (paramTextAttributes.mTextTransform == TextTransform.UNSET)
        break label192;
    }
    label156: label165: label174: label183: label192: for (TextTransform localTextTransform = paramTextAttributes.mTextTransform; ; localTextTransform = this.mTextTransform)
    {
      localTextAttributes.mTextTransform = localTextTransform;
      return localTextAttributes;
      f1 = this.mFontSize;
      break;
      f2 = this.mLineHeight;
      break label52;
      f3 = this.mLetterSpacing;
      break label74;
      f4 = this.mMaxFontSizeMultiplier;
      break label96;
      f5 = this.mHeightOfTallestInlineImage;
      break label118;
    }
  }

  public boolean getAllowFontScaling()
  {
    return this.mAllowFontScaling;
  }

  public int getEffectiveFontSize()
  {
    if (!Float.isNaN(this.mFontSize));
    for (float f = this.mFontSize; this.mAllowFontScaling; f = 14.0F)
      return (int)Math.ceil(PixelUtil.toPixelFromSP(f, getEffectiveMaxFontSizeMultiplier()));
    return (int)Math.ceil(PixelUtil.toPixelFromDIP(f));
  }

  public float getEffectiveLetterSpacing()
  {
    if (Float.isNaN(this.mLetterSpacing))
      return (0.0F / 0.0F);
    if (this.mAllowFontScaling);
    for (float f = PixelUtil.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier()); ; f = PixelUtil.toPixelFromDIP(this.mLetterSpacing))
      return f / getEffectiveFontSize();
  }

  public float getEffectiveLineHeight()
  {
    float f;
    if (Float.isNaN(this.mLineHeight))
      f = (0.0F / 0.0F);
    label75: label78: 
    while (true)
    {
      return f;
      if (this.mAllowFontScaling)
      {
        f = PixelUtil.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        if ((Float.isNaN(this.mHeightOfTallestInlineImage)) || (this.mHeightOfTallestInlineImage <= f))
          break label75;
      }
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label78;
        return this.mHeightOfTallestInlineImage;
        f = PixelUtil.toPixelFromDIP(this.mLineHeight);
        break;
      }
    }
  }

  public float getEffectiveMaxFontSizeMultiplier()
  {
    if (!Float.isNaN(this.mMaxFontSizeMultiplier))
      return this.mMaxFontSizeMultiplier;
    return 0.0F;
  }

  public float getFontSize()
  {
    return this.mFontSize;
  }

  public float getHeightOfTallestInlineImage()
  {
    return this.mHeightOfTallestInlineImage;
  }

  public float getLetterSpacing()
  {
    return this.mLetterSpacing;
  }

  public float getLineHeight()
  {
    return this.mLineHeight;
  }

  public float getMaxFontSizeMultiplier()
  {
    return this.mMaxFontSizeMultiplier;
  }

  public TextTransform getTextTransform()
  {
    return this.mTextTransform;
  }

  public void setAllowFontScaling(boolean paramBoolean)
  {
    this.mAllowFontScaling = paramBoolean;
  }

  public void setFontSize(float paramFloat)
  {
    this.mFontSize = paramFloat;
  }

  public void setHeightOfTallestInlineImage(float paramFloat)
  {
    this.mHeightOfTallestInlineImage = paramFloat;
  }

  public void setLetterSpacing(float paramFloat)
  {
    this.mLetterSpacing = paramFloat;
  }

  public void setLineHeight(float paramFloat)
  {
    this.mLineHeight = paramFloat;
  }

  public void setMaxFontSizeMultiplier(float paramFloat)
  {
    if ((paramFloat != 0.0F) && (paramFloat < 1.0F))
      throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    this.mMaxFontSizeMultiplier = paramFloat;
  }

  public void setTextTransform(TextTransform paramTextTransform)
  {
    this.mTextTransform = paramTextTransform;
  }

  public String toString()
  {
    return "TextAttributes {\n  getAllowFontScaling(): " + getAllowFontScaling() + "\n  getFontSize(): " + getFontSize() + "\n  getEffectiveFontSize(): " + getEffectiveFontSize() + "\n  getHeightOfTallestInlineImage(): " + getHeightOfTallestInlineImage() + "\n  getLetterSpacing(): " + getLetterSpacing() + "\n  getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n  getLineHeight(): " + getLineHeight() + "\n  getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n  getTextTransform(): " + getTextTransform() + "\n  getMaxFontSizeMultiplier(): " + getMaxFontSizeMultiplier() + "\n  getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.TextAttributes
 * JD-Core Version:    0.6.2
 */