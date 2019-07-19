package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@TargetApi(23)
public abstract class ReactBaseTextShadowNode extends LayoutShadowNode
{
  public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String INLINE_IMAGE_PLACEHOLDER = "I";
  public static final String PROP_SHADOW_COLOR = "textShadowColor";
  public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
  public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
  public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
  public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
  public static final String PROP_TEXT_TRANSFORM = "textTransform";
  public static final int UNSET = -1;
  protected int mBackgroundColor;
  protected int mColor;
  protected boolean mContainsImages;

  @Nullable
  protected String mFontFamily;
  protected int mFontStyle;
  protected int mFontWeight;
  protected float mHeightOfTallestInlineImage;
  protected boolean mIncludeFontPadding;
  protected boolean mIsBackgroundColorSet = false;
  protected boolean mIsColorSet = false;
  protected boolean mIsLineThroughTextDecorationSet;
  protected boolean mIsUnderlineTextDecorationSet;
  protected int mJustificationMode;
  protected int mNumberOfLines = -1;
  protected int mTextAlign = 0;
  protected TextAttributes mTextAttributes;
  protected int mTextBreakStrategy;
  protected int mTextShadowColor;
  protected float mTextShadowOffsetDx;
  protected float mTextShadowOffsetDy;
  protected float mTextShadowRadius;
  protected TextTransform mTextTransform;

  public ReactBaseTextShadowNode()
  {
    if (Build.VERSION.SDK_INT < 23);
    for (int i = 0; ; i = 1)
    {
      this.mTextBreakStrategy = i;
      if (Build.VERSION.SDK_INT < 26);
      this.mJustificationMode = 0;
      this.mTextTransform = TextTransform.UNSET;
      this.mTextShadowOffsetDx = 0.0F;
      this.mTextShadowOffsetDy = 0.0F;
      this.mTextShadowRadius = 0.0F;
      this.mTextShadowColor = 1426063360;
      this.mIsUnderlineTextDecorationSet = false;
      this.mIsLineThroughTextDecorationSet = false;
      this.mIncludeFontPadding = true;
      this.mFontStyle = -1;
      this.mFontWeight = -1;
      this.mFontFamily = null;
      this.mContainsImages = false;
      this.mHeightOfTallestInlineImage = (0.0F / 0.0F);
      this.mTextAttributes = new TextAttributes();
      return;
    }
  }

  private static void buildSpannedFromShadowNode(ReactBaseTextShadowNode paramReactBaseTextShadowNode, SpannableStringBuilder paramSpannableStringBuilder, List<SetSpanOperation> paramList, TextAttributes paramTextAttributes, int paramInt)
  {
    TextAttributes localTextAttributes;
    int j;
    label23: ReactShadowNodeImpl localReactShadowNodeImpl;
    if (paramTextAttributes != null)
    {
      localTextAttributes = paramTextAttributes.applyChild(paramReactBaseTextShadowNode.mTextAttributes);
      int i = paramReactBaseTextShadowNode.getChildCount();
      j = 0;
      if (j >= i)
        break label201;
      localReactShadowNodeImpl = paramReactBaseTextShadowNode.getChildAt(j);
      if (!(localReactShadowNodeImpl instanceof ReactRawTextShadowNode))
        break label89;
      paramSpannableStringBuilder.append(TextTransform.apply(((ReactRawTextShadowNode)localReactShadowNodeImpl).getText(), localTextAttributes.getTextTransform()));
    }
    while (true)
    {
      localReactShadowNodeImpl.markUpdateSeen();
      j++;
      break label23;
      localTextAttributes = paramReactBaseTextShadowNode.mTextAttributes;
      break;
      label89: if ((localReactShadowNodeImpl instanceof ReactBaseTextShadowNode))
      {
        buildSpannedFromShadowNode((ReactBaseTextShadowNode)localReactShadowNodeImpl, paramSpannableStringBuilder, paramList, localTextAttributes, paramSpannableStringBuilder.length());
      }
      else
      {
        if (!(localReactShadowNodeImpl instanceof ReactTextInlineImageShadowNode))
          break label170;
        paramSpannableStringBuilder.append("I");
        paramList.add(new SetSpanOperation(paramSpannableStringBuilder.length() - "I".length(), paramSpannableStringBuilder.length(), ((ReactTextInlineImageShadowNode)localReactShadowNodeImpl).buildInlineImageSpan()));
      }
    }
    label170: throw new IllegalViewOperationException("Unexpected view type nested under text node: " + localReactShadowNodeImpl.getClass());
    label201: int k = paramSpannableStringBuilder.length();
    if (k >= paramInt)
    {
      if (paramReactBaseTextShadowNode.mIsColorSet)
        paramList.add(new SetSpanOperation(paramInt, k, new ReactForegroundColorSpan(paramReactBaseTextShadowNode.mColor)));
      if (paramReactBaseTextShadowNode.mIsBackgroundColorSet)
        paramList.add(new SetSpanOperation(paramInt, k, new ReactBackgroundColorSpan(paramReactBaseTextShadowNode.mBackgroundColor)));
      if (Build.VERSION.SDK_INT >= 21)
      {
        float f2 = localTextAttributes.getEffectiveLetterSpacing();
        if ((!Float.isNaN(f2)) && ((paramTextAttributes == null) || (paramTextAttributes.getEffectiveLetterSpacing() != f2)))
          paramList.add(new SetSpanOperation(paramInt, k, new CustomLetterSpacingSpan(f2)));
      }
      int m = localTextAttributes.getEffectiveFontSize();
      if ((paramTextAttributes == null) || (paramTextAttributes.getEffectiveFontSize() != m))
        paramList.add(new SetSpanOperation(paramInt, k, new ReactAbsoluteSizeSpan(m)));
      if ((paramReactBaseTextShadowNode.mFontStyle != -1) || (paramReactBaseTextShadowNode.mFontWeight != -1) || (paramReactBaseTextShadowNode.mFontFamily != null))
        paramList.add(new SetSpanOperation(paramInt, k, new CustomStyleSpan(paramReactBaseTextShadowNode.mFontStyle, paramReactBaseTextShadowNode.mFontWeight, paramReactBaseTextShadowNode.mFontFamily, paramReactBaseTextShadowNode.getThemedContext().getAssets())));
      if (paramReactBaseTextShadowNode.mIsUnderlineTextDecorationSet)
        paramList.add(new SetSpanOperation(paramInt, k, new ReactUnderlineSpan()));
      if (paramReactBaseTextShadowNode.mIsLineThroughTextDecorationSet)
        paramList.add(new SetSpanOperation(paramInt, k, new ReactStrikethroughSpan()));
      if (((paramReactBaseTextShadowNode.mTextShadowOffsetDx != 0.0F) || (paramReactBaseTextShadowNode.mTextShadowOffsetDy != 0.0F) || (paramReactBaseTextShadowNode.mTextShadowRadius != 0.0F)) && (Color.alpha(paramReactBaseTextShadowNode.mTextShadowColor) != 0))
        paramList.add(new SetSpanOperation(paramInt, k, new ShadowStyleSpan(paramReactBaseTextShadowNode.mTextShadowOffsetDx, paramReactBaseTextShadowNode.mTextShadowOffsetDy, paramReactBaseTextShadowNode.mTextShadowRadius, paramReactBaseTextShadowNode.mTextShadowColor)));
      float f1 = localTextAttributes.getEffectiveLineHeight();
      if ((!Float.isNaN(f1)) && ((paramTextAttributes == null) || (paramTextAttributes.getEffectiveLineHeight() != f1)))
        paramList.add(new SetSpanOperation(paramInt, k, new CustomLineHeightSpan(f1)));
      paramList.add(new SetSpanOperation(paramInt, k, new ReactTagSpan(paramReactBaseTextShadowNode.getReactTag())));
    }
  }

  private int getTextAlign()
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

  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1'))
      return 100 * ('￐' + paramString.charAt(0));
    return -1;
  }

  protected static Spannable spannedFromShadowNode(ReactBaseTextShadowNode paramReactBaseTextShadowNode, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
      localSpannableStringBuilder.append(TextTransform.apply(paramString, paramReactBaseTextShadowNode.mTextAttributes.getTextTransform()));
    buildSpannedFromShadowNode(paramReactBaseTextShadowNode, localSpannableStringBuilder, localArrayList, null, 0);
    paramReactBaseTextShadowNode.mContainsImages = false;
    Iterator localIterator = localArrayList.iterator();
    int i = 0;
    float f1 = (0.0F / 0.0F);
    SetSpanOperation localSetSpanOperation;
    int j;
    if (localIterator.hasNext())
    {
      localSetSpanOperation = (SetSpanOperation)localIterator.next();
      if (!(localSetSpanOperation.what instanceof TextInlineImageSpan))
        break label166;
      j = ((TextInlineImageSpan)localSetSpanOperation.what).getHeight();
      paramReactBaseTextShadowNode.mContainsImages = true;
      if ((!Float.isNaN(f1)) && (j <= f1))
        break label166;
    }
    label166: for (float f2 = j; ; f2 = f1)
    {
      localSetSpanOperation.execute(localSpannableStringBuilder, i);
      i++;
      f1 = f2;
      break;
      paramReactBaseTextShadowNode.mTextAttributes.setHeightOfTallestInlineImage(f1);
      return localSpannableStringBuilder;
    }
  }

  @ReactProp(defaultBoolean=true, name="allowFontScaling")
  public void setAllowFontScaling(boolean paramBoolean)
  {
    if (paramBoolean != this.mTextAttributes.getAllowFontScaling())
    {
      this.mTextAttributes.setAllowFontScaling(paramBoolean);
      markUpdated();
    }
  }

  @ReactProp(name="backgroundColor")
  public void setBackgroundColor(Integer paramInteger)
  {
    if (!isVirtualAnchor())
      if (paramInteger == null)
        break label38;
    label38: for (boolean bool = true; ; bool = false)
    {
      this.mIsBackgroundColorSet = bool;
      if (this.mIsBackgroundColorSet)
        this.mBackgroundColor = paramInteger.intValue();
      markUpdated();
      return;
    }
  }

  @ReactProp(name="color")
  public void setColor(@Nullable Integer paramInteger)
  {
    if (paramInteger != null);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsColorSet = bool;
      if (this.mIsColorSet)
        this.mColor = paramInteger.intValue();
      markUpdated();
      return;
    }
  }

  @ReactProp(name="fontFamily")
  public void setFontFamily(@Nullable String paramString)
  {
    this.mFontFamily = paramString;
    markUpdated();
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="fontSize")
  public void setFontSize(float paramFloat)
  {
    this.mTextAttributes.setFontSize(paramFloat);
    markUpdated();
  }

  @ReactProp(name="fontStyle")
  public void setFontStyle(@Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString))
      i = 2;
    while (true)
    {
      if (i != this.mFontStyle)
      {
        this.mFontStyle = i;
        markUpdated();
      }
      return;
      if ("normal".equals(paramString))
        i = 0;
    }
  }

  @ReactProp(name="fontWeight")
  public void setFontWeight(@Nullable String paramString)
  {
    int i = -1;
    int j;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      if ((j < 500) && (!"bold".equals(paramString)))
        break label53;
    }
    for (i = 1; ; i = 0)
      label53: 
      do
      {
        if (i != this.mFontWeight)
        {
          this.mFontWeight = i;
          markUpdated();
        }
        return;
        j = i;
        break;
      }
      while ((!"normal".equals(paramString)) && ((j == i) || (j >= 500)));
  }

  @ReactProp(defaultBoolean=true, name="includeFontPadding")
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="letterSpacing")
  public void setLetterSpacing(float paramFloat)
  {
    this.mTextAttributes.setLetterSpacing(paramFloat);
    markUpdated();
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="lineHeight")
  public void setLineHeight(float paramFloat)
  {
    this.mTextAttributes.setLineHeight(paramFloat);
    markUpdated();
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="maxFontSizeMultiplier")
  public void setMaxFontSizeMultiplier(float paramFloat)
  {
    if (paramFloat != this.mTextAttributes.getMaxFontSizeMultiplier())
    {
      this.mTextAttributes.setMaxFontSizeMultiplier(paramFloat);
      markUpdated();
    }
  }

  @ReactProp(defaultInt=-1, name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    if (paramInt == 0)
      paramInt = -1;
    this.mNumberOfLines = paramInt;
    markUpdated();
  }

  @ReactProp(name="textAlign")
  public void setTextAlign(@Nullable String paramString)
  {
    if ("justify".equals(paramString))
    {
      if (Build.VERSION.SDK_INT >= 26)
        this.mJustificationMode = 1;
      this.mTextAlign = 8388611;
    }
    while (true)
    {
      markUpdated();
      return;
      if (Build.VERSION.SDK_INT >= 26)
        this.mJustificationMode = 0;
      if ((paramString == null) || ("auto".equals(paramString)))
      {
        this.mTextAlign = 0;
      }
      else if ("left".equals(paramString))
      {
        this.mTextAlign = 8388611;
      }
      else if ("right".equals(paramString))
      {
        this.mTextAlign = 8388613;
      }
      else
      {
        if (!"center".equals(paramString))
          break;
        this.mTextAlign = 1;
      }
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + paramString);
  }

  @ReactProp(name="textBreakStrategy")
  public void setTextBreakStrategy(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT < 23)
      return;
    if ((paramString == null) || ("highQuality".equals(paramString)))
      this.mTextBreakStrategy = 1;
    while (true)
    {
      markUpdated();
      return;
      if ("simple".equals(paramString))
      {
        this.mTextBreakStrategy = 0;
      }
      else
      {
        if (!"balanced".equals(paramString))
          break;
        this.mTextBreakStrategy = 2;
      }
    }
    throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + paramString);
  }

  @ReactProp(name="textDecorationLine")
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
    markUpdated();
  }

  @ReactProp(customType="Color", defaultInt=1426063360, name="textShadowColor")
  public void setTextShadowColor(int paramInt)
  {
    if (paramInt != this.mTextShadowColor)
    {
      this.mTextShadowColor = paramInt;
      markUpdated();
    }
  }

  @ReactProp(name="textShadowOffset")
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
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="textShadowRadius")
  public void setTextShadowRadius(float paramFloat)
  {
    if (paramFloat != this.mTextShadowRadius)
    {
      this.mTextShadowRadius = paramFloat;
      markUpdated();
    }
  }

  @ReactProp(name="textTransform")
  public void setTextTransform(@Nullable String paramString)
  {
    if (paramString == null)
      this.mTextAttributes.setTextTransform(TextTransform.UNSET);
    while (true)
    {
      markUpdated();
      return;
      if ("none".equals(paramString))
      {
        this.mTextAttributes.setTextTransform(TextTransform.NONE);
      }
      else if ("uppercase".equals(paramString))
      {
        this.mTextAttributes.setTextTransform(TextTransform.UPPERCASE);
      }
      else if ("lowercase".equals(paramString))
      {
        this.mTextAttributes.setTextTransform(TextTransform.LOWERCASE);
      }
      else
      {
        if (!"capitalize".equals(paramString))
          break;
        this.mTextAttributes.setTextTransform(TextTransform.CAPITALIZE);
      }
    }
    throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + paramString);
  }

  private static class SetSpanOperation
  {
    protected int end;
    protected int start;
    protected ReactSpan what;

    SetSpanOperation(int paramInt1, int paramInt2, ReactSpan paramReactSpan)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.what = paramReactSpan;
    }

    public void execute(SpannableStringBuilder paramSpannableStringBuilder, int paramInt)
    {
      int i = 34;
      if (this.start == 0)
        i = 18;
      int j = i & 0xFF00FFFF | 0xFF0000 & paramInt << 16;
      paramSpannableStringBuilder.setSpan(this.what, this.start, this.end, j);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactBaseTextShadowNode
 * JD-Core Version:    0.6.2
 */