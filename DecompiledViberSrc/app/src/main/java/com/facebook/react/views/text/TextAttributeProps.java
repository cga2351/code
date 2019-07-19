package com.facebook.react.views.text;

import android.os.Build.VERSION;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.yoga.YogaDirection;
import javax.annotation.Nullable;

public class TextAttributeProps
{
  private static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String INLINE_IMAGE_PLACEHOLDER = "I";
  private static final String PROP_SHADOW_COLOR = "textShadowColor";
  private static final String PROP_SHADOW_OFFSET = "textShadowOffset";
  private static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
  private static final String PROP_SHADOW_OFFSET_WIDTH = "width";
  private static final String PROP_SHADOW_RADIUS = "textShadowRadius";
  private static final String PROP_TEXT_TRANSFORM = "textTransform";
  public static final int UNSET = -1;
  protected boolean mAllowFontScaling = true;
  protected int mBackgroundColor;
  protected int mColor;
  protected boolean mContainsImages;

  @Nullable
  protected String mFontFamily;
  protected int mFontSize = -1;
  protected float mFontSizeInput = -1.0F;
  protected int mFontStyle;
  protected int mFontWeight;
  protected float mHeightOfTallestInlineImage;
  protected boolean mIncludeFontPadding;
  protected boolean mIsBackgroundColorSet = false;
  protected boolean mIsColorSet = false;
  protected boolean mIsLineThroughTextDecorationSet;
  protected boolean mIsUnderlineTextDecorationSet;
  protected int mJustificationMode;
  protected float mLetterSpacing = (0.0F / 0.0F);
  protected float mLetterSpacingInput = (0.0F / 0.0F);
  protected float mLineHeight = (0.0F / 0.0F);
  protected float mLineHeightInput = -1.0F;
  protected int mNumberOfLines = -1;
  private final ReactStylesDiffMap mProps;
  protected int mTextAlign = 0;
  protected int mTextBreakStrategy;
  protected int mTextShadowColor;
  protected float mTextShadowOffsetDx;
  protected float mTextShadowOffsetDy;
  protected float mTextShadowRadius;
  protected TextTransform mTextTransform;

  public TextAttributeProps(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    int i;
    Integer localInteger1;
    label254: Integer localInteger2;
    if (Build.VERSION.SDK_INT < 23)
    {
      i = 0;
      this.mTextBreakStrategy = i;
      if (Build.VERSION.SDK_INT < 26);
      this.mJustificationMode = 0;
      this.mTextTransform = TextTransform.UNSET;
      this.mTextShadowOffsetDx = 0.0F;
      this.mTextShadowOffsetDy = 0.0F;
      this.mTextShadowRadius = 1.0F;
      this.mTextShadowColor = 1426063360;
      this.mIsUnderlineTextDecorationSet = false;
      this.mIsLineThroughTextDecorationSet = false;
      this.mIncludeFontPadding = true;
      this.mFontStyle = -1;
      this.mFontWeight = -1;
      this.mFontFamily = null;
      this.mContainsImages = false;
      this.mHeightOfTallestInlineImage = (0.0F / 0.0F);
      this.mProps = paramReactStylesDiffMap;
      setNumberOfLines(getIntProp("numberOfLines", -1));
      setLineHeight(getFloatProp("lineHeight", -1.0F));
      setLetterSpacing(getFloatProp("letterSpacing", (0.0F / 0.0F)));
      setAllowFontScaling(getBooleanProp("allowFontScaling", true));
      setTextAlign(getStringProp("textAlign"));
      setFontSize(getFloatProp("fontSize", -1.0F));
      if (!paramReactStylesDiffMap.hasKey("color"))
        break label444;
      localInteger1 = Integer.valueOf(paramReactStylesDiffMap.getInt("color", 0));
      setColor(localInteger1);
      if (!paramReactStylesDiffMap.hasKey("foregroundColor"))
        break label449;
      localInteger2 = Integer.valueOf(paramReactStylesDiffMap.getInt("foregroundColor", 0));
      label280: setColor(localInteger2);
      if (!paramReactStylesDiffMap.hasKey("backgroundColor"))
        break label455;
    }
    label444: label449: label455: for (Integer localInteger3 = Integer.valueOf(paramReactStylesDiffMap.getInt("backgroundColor", 0)); ; localInteger3 = null)
    {
      setBackgroundColor(localInteger3);
      setFontFamily(getStringProp("fontFamily"));
      setFontWeight(getStringProp("fontWeight"));
      setFontStyle(getStringProp("fontStyle"));
      setIncludeFontPadding(getBooleanProp("includeFontPadding", true));
      setTextDecorationLine(getStringProp("textDecorationLine"));
      setTextBreakStrategy(getStringProp("textBreakStrategy"));
      boolean bool = paramReactStylesDiffMap.hasKey("textShadowOffset");
      ReadableMap localReadableMap = null;
      if (bool)
        localReadableMap = paramReactStylesDiffMap.getMap("textShadowOffset");
      setTextShadowOffset(localReadableMap);
      setTextShadowRadius(getIntProp("textShadowRadius", 1));
      setTextShadowColor(getIntProp("textShadowColor", 1426063360));
      setTextTransform(getStringProp("textTransform"));
      return;
      i = 1;
      break;
      localInteger1 = null;
      break label254;
      localInteger2 = null;
      break label280;
    }
  }

  private boolean getBooleanProp(String paramString, boolean paramBoolean)
  {
    if (this.mProps.hasKey(paramString))
      paramBoolean = this.mProps.getBoolean(paramString, paramBoolean);
    return paramBoolean;
  }

  private float getFloatProp(String paramString, float paramFloat)
  {
    if (this.mProps.hasKey(paramString))
      paramFloat = this.mProps.getFloat(paramString, paramFloat);
    return paramFloat;
  }

  private int getIntProp(String paramString, int paramInt)
  {
    if (this.mProps.hasKey(paramString))
      paramInt = this.mProps.getInt(paramString, paramInt);
    return paramInt;
  }

  private YogaDirection getLayoutDirection()
  {
    return YogaDirection.LTR;
  }

  private float getPaddingProp(String paramString)
  {
    if (this.mProps.hasKey("padding"))
      return PixelUtil.toPixelFromDIP(getFloatProp("padding", 0.0F));
    return PixelUtil.toPixelFromDIP(getFloatProp(paramString, 0.0F));
  }

  private String getStringProp(String paramString)
  {
    if (this.mProps.hasKey(paramString))
      return this.mProps.getString(paramString);
    return null;
  }

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return 100 * ('￐' + paramString.charAt(0));
    return -1;
  }

  public float getBottomPadding()
  {
    return getPaddingProp("paddingBottom");
  }

  public float getEffectiveLineHeight()
  {
    if ((!Float.isNaN(this.mLineHeight)) && (!Float.isNaN(this.mHeightOfTallestInlineImage)) && (this.mHeightOfTallestInlineImage > this.mLineHeight));
    for (int i = 1; i != 0; i = 0)
      return this.mHeightOfTallestInlineImage;
    return this.mLineHeight;
  }

  public float getEndPadding()
  {
    return getPaddingProp("paddingEnd");
  }

  public float getLeftPadding()
  {
    return getPaddingProp("paddingLeft");
  }

  public float getRightPadding()
  {
    return getPaddingProp("paddingRight");
  }

  public float getStartPadding()
  {
    return getPaddingProp("paddingStart");
  }

  public int getTextAlign()
  {
    int i = this.mTextAlign;
    if (getLayoutDirection() == YogaDirection.RTL)
    {
      if (i == 8388613)
        return 8388611;
      if (i == 8388611)
        return 8388613;
    }
    return i;
  }

  public float getTopPadding()
  {
    return getPaddingProp("paddingTop");
  }

  public void setAllowFontScaling(boolean paramBoolean)
  {
    if (paramBoolean != this.mAllowFontScaling)
    {
      this.mAllowFontScaling = paramBoolean;
      setFontSize(this.mFontSizeInput);
      setLineHeight(this.mLineHeightInput);
      setLetterSpacing(this.mLetterSpacingInput);
    }
  }

  public void setBackgroundColor(Integer paramInteger)
  {
    if (paramInteger != null);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsBackgroundColorSet = bool;
      if (this.mIsBackgroundColorSet)
        this.mBackgroundColor = paramInteger.intValue();
      return;
    }
  }

  public void setColor(@Nullable Integer paramInteger)
  {
    if (paramInteger != null);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsColorSet = bool;
      if (this.mIsColorSet)
        this.mColor = paramInteger.intValue();
      return;
    }
  }

  public void setFontFamily(@Nullable String paramString)
  {
    this.mFontFamily = paramString;
  }

  public void setFontSize(float paramFloat)
  {
    this.mFontSizeInput = paramFloat;
    float f;
    if (paramFloat != -1.0F)
      if (this.mAllowFontScaling)
        f = (float)Math.ceil(PixelUtil.toPixelFromSP(paramFloat));
    while (true)
    {
      this.mFontSize = ((int)f);
      return;
      f = (float)Math.ceil(PixelUtil.toPixelFromDIP(paramFloat));
      continue;
      f = paramFloat;
    }
  }

  public void setFontStyle(@Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString))
      i = 2;
    while (true)
    {
      if (i != this.mFontStyle)
        this.mFontStyle = i;
      return;
      if ("normal".equals(paramString))
        i = 0;
    }
  }

  public void setFontWeight(@Nullable String paramString)
  {
    int i = -1;
    int j;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      if ((j < 500) && (!"bold".equals(paramString)))
        break label49;
    }
    for (i = 1; ; i = 0)
      label49: 
      do
      {
        if (i != this.mFontWeight)
          this.mFontWeight = i;
        return;
        j = i;
        break;
      }
      while ((!"normal".equals(paramString)) && ((j == i) || (j >= 500)));
  }

  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }

  public void setLetterSpacing(float paramFloat)
  {
    this.mLetterSpacingInput = paramFloat;
    if (this.mAllowFontScaling);
    for (float f = PixelUtil.toPixelFromSP(this.mLetterSpacingInput); ; f = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput))
    {
      this.mLetterSpacing = f;
      return;
    }
  }

  public void setLineHeight(float paramFloat)
  {
    this.mLineHeightInput = paramFloat;
    if (paramFloat == -1.0F)
    {
      this.mLineHeight = (0.0F / 0.0F);
      return;
    }
    if (this.mAllowFontScaling);
    for (float f = PixelUtil.toPixelFromSP(paramFloat); ; f = PixelUtil.toPixelFromDIP(paramFloat))
    {
      this.mLineHeight = f;
      return;
    }
  }

  public void setNumberOfLines(int paramInt)
  {
    if (paramInt == 0)
      paramInt = -1;
    this.mNumberOfLines = paramInt;
  }

  public void setTextAlign(@Nullable String paramString)
  {
    if ("justify".equals(paramString))
    {
      if (Build.VERSION.SDK_INT >= 26)
        this.mJustificationMode = 1;
      this.mTextAlign = 8388611;
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
      this.mJustificationMode = 0;
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      this.mTextAlign = 0;
      return;
    }
    if ("left".equals(paramString))
    {
      this.mTextAlign = 8388611;
      return;
    }
    if ("right".equals(paramString))
    {
      this.mTextAlign = 8388613;
      return;
    }
    if ("center".equals(paramString))
    {
      this.mTextAlign = 1;
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  public void setTextBreakStrategy(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 23)
      return;
    if ((paramString == null) || ("highQuality".equals(paramString)))
    {
      this.mTextBreakStrategy = 1;
      return;
    }
    if ("simple".equals(paramString))
    {
      this.mTextBreakStrategy = 0;
      return;
    }
    if ("balanced".equals(paramString))
    {
      this.mTextBreakStrategy = 2;
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + paramString);
  }

  public void setTextDecorationLine(@Nullable String paramString)
  {
    int i = 0;
    this.mIsUnderlineTextDecorationSet = false;
    this.mIsLineThroughTextDecorationSet = false;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split(" ");
      int j = arrayOfString.length;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ("underline".equals(str))
          this.mIsUnderlineTextDecorationSet = true;
        while (true)
        {
          i++;
          break;
          if ("line-through".equals(str))
            this.mIsLineThroughTextDecorationSet = true;
        }
      }
    }
  }

  public void setTextShadowColor(int paramInt)
  {
    if (paramInt != this.mTextShadowColor)
      this.mTextShadowColor = paramInt;
  }

  public void setTextShadowOffset(ReadableMap paramReadableMap)
  {
    this.mTextShadowOffsetDx = 0.0F;
    this.mTextShadowOffsetDy = 0.0F;
    if (paramReadableMap != null)
    {
      if ((paramReadableMap.hasKey("width")) && (!paramReadableMap.isNull("width")))
        this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("width"));
      if ((paramReadableMap.hasKey("height")) && (!paramReadableMap.isNull("height")))
        this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("height"));
    }
  }

  public void setTextShadowRadius(float paramFloat)
  {
    if (paramFloat != this.mTextShadowRadius)
      this.mTextShadowRadius = paramFloat;
  }

  public void setTextTransform(@Nullable String paramString)
  {
    if ((paramString == null) || ("none".equals(paramString)))
    {
      this.mTextTransform = TextTransform.NONE;
      return;
    }
    if ("uppercase".equals(paramString))
    {
      this.mTextTransform = TextTransform.UPPERCASE;
      return;
    }
    if ("lowercase".equals(paramString))
    {
      this.mTextTransform = TextTransform.LOWERCASE;
      return;
    }
    if ("capitalize".equals(paramString))
    {
      this.mTextTransform = TextTransform.CAPITALIZE;
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.TextAttributeProps
 * JD-Core Version:    0.6.2
 */