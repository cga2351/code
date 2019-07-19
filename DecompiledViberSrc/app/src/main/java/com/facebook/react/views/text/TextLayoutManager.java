package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextLayoutManager
{
  private static LruCache<String, Spannable> sSpannableCache = new LruCache(100);
  private static final Object sSpannableCacheLock;
  private static final TextPaint sTextPaintInstance = new TextPaint(1);
  private static final int spannableCacheSize = 100;

  static
  {
    sSpannableCacheLock = new Object();
  }

  private static void buildSpannableFromFragment(Context paramContext, ReadableArray paramReadableArray, SpannableStringBuilder paramSpannableStringBuilder, List<SetSpanOperation> paramList)
  {
    int i = 0;
    int j = paramReadableArray.size();
    while (i < j)
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      int k = paramSpannableStringBuilder.length();
      TextAttributeProps localTextAttributeProps = new TextAttributeProps(new ReactStylesDiffMap(localReadableMap.getMap("textAttributes")));
      paramSpannableStringBuilder.append(TextTransform.apply(localReadableMap.getString("string"), localTextAttributeProps.mTextTransform));
      int m = paramSpannableStringBuilder.length();
      if (m >= k)
      {
        if (localTextAttributeProps.mIsColorSet)
          paramList.add(new SetSpanOperation(k, m, new ReactForegroundColorSpan(localTextAttributeProps.mColor)));
        if (localTextAttributeProps.mIsBackgroundColorSet)
          paramList.add(new SetSpanOperation(k, m, new ReactBackgroundColorSpan(localTextAttributeProps.mBackgroundColor)));
        if ((Build.VERSION.SDK_INT >= 21) && (!Float.isNaN(localTextAttributeProps.mLetterSpacing)))
          paramList.add(new SetSpanOperation(k, m, new CustomLetterSpacingSpan(localTextAttributeProps.mLetterSpacing)));
        paramList.add(new SetSpanOperation(k, m, new ReactAbsoluteSizeSpan(localTextAttributeProps.mFontSize)));
        if ((localTextAttributeProps.mFontStyle != -1) || (localTextAttributeProps.mFontWeight != -1) || (localTextAttributeProps.mFontFamily != null))
          paramList.add(new SetSpanOperation(k, m, new CustomStyleSpan(localTextAttributeProps.mFontStyle, localTextAttributeProps.mFontWeight, localTextAttributeProps.mFontFamily, paramContext.getAssets())));
        if (localTextAttributeProps.mIsUnderlineTextDecorationSet)
          paramList.add(new SetSpanOperation(k, m, new ReactUnderlineSpan()));
        if (localTextAttributeProps.mIsLineThroughTextDecorationSet)
          paramList.add(new SetSpanOperation(k, m, new ReactStrikethroughSpan()));
        if ((localTextAttributeProps.mTextShadowOffsetDx != 0.0F) || (localTextAttributeProps.mTextShadowOffsetDy != 0.0F))
          paramList.add(new SetSpanOperation(k, m, new ShadowStyleSpan(localTextAttributeProps.mTextShadowOffsetDx, localTextAttributeProps.mTextShadowOffsetDy, localTextAttributeProps.mTextShadowRadius, localTextAttributeProps.mTextShadowColor)));
        if (!Float.isNaN(localTextAttributeProps.getEffectiveLineHeight()))
          paramList.add(new SetSpanOperation(k, m, new CustomLineHeightSpan(localTextAttributeProps.getEffectiveLineHeight())));
        paramList.add(new SetSpanOperation(k, m, new ReactTagSpan(localReadableMap.getInt("reactTag"))));
      }
      i++;
    }
  }

  private static Spannable createSpannableFromAttributedString(Context paramContext, ReadableMap paramReadableMap)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    buildSpannableFromFragment(paramContext, paramReadableMap.getArray("fragments"), localSpannableStringBuilder, localArrayList);
    Iterator localIterator = localArrayList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      ((SetSpanOperation)localIterator.next()).execute(localSpannableStringBuilder, i);
    return localSpannableStringBuilder;
  }

  protected static Spannable getOrCreateSpannableForText(Context paramContext, ReadableMap paramReadableMap)
  {
    String str = paramReadableMap.toString();
    synchronized (sSpannableCacheLock)
    {
      Spannable localSpannable1 = (Spannable)sSpannableCache.get(str);
      if (localSpannable1 != null)
        return localSpannable1;
      Spannable localSpannable2 = createSpannableFromAttributedString(paramContext, paramReadableMap);
      synchronized (sSpannableCacheLock)
      {
        sSpannableCache.put(str, localSpannable2);
        return localSpannable2;
      }
    }
  }

  public static long measureText(ReactContext paramReactContext, ReadableNativeMap paramReadableNativeMap1, ReadableNativeMap paramReadableNativeMap2, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    TextPaint localTextPaint = sTextPaintInstance;
    Spannable localSpannable = getOrCreateSpannableForText(paramReactContext, paramReadableNativeMap1);
    if (localSpannable == null)
      throw new IllegalStateException("Spannable element has not been prepared in onBeforeLayout");
    BoringLayout.Metrics localMetrics = BoringLayout.isBoring(localSpannable, localTextPaint);
    float f1;
    int i;
    label68: int k;
    Object localObject;
    label131: int j;
    label150: float f2;
    if (localMetrics == null)
    {
      f1 = Layout.getDesiredWidth(localSpannable, localTextPaint);
      if ((paramYogaMeasureMode1 != YogaMeasureMode.UNDEFINED) && (paramFloat1 >= 0.0F))
        break label213;
      i = 1;
      if ((localMetrics != null) || ((i == 0) && ((YogaConstants.isUndefined(f1)) || (f1 > paramFloat1))))
        break label267;
      k = (int)Math.ceil(f1);
      if (Build.VERSION.SDK_INT >= 23)
        break label219;
      localObject = new StaticLayout(localSpannable, localTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      if (!paramReadableNativeMap2.hasKey("maximumNumberOfLines"))
        break label393;
      j = paramReadableNativeMap2.getInt("maximumNumberOfLines");
      f2 = ((Layout)localObject).getWidth();
      if ((j == -1) || (j == 0) || (j >= ((Layout)localObject).getLineCount()))
        break label399;
    }
    label267: label399: for (float f3 = ((Layout)localObject).getLineBottom(j - 1); ; f3 = ((Layout)localObject).getHeight())
    {
      return YogaMeasureOutput.make(PixelUtil.toSPFromPixel(f2), PixelUtil.toSPFromPixel(f3));
      f1 = (0.0F / 0.0F);
      break;
      label213: i = 0;
      break label68;
      label219: localObject = StaticLayout.Builder.obtain(localSpannable, 0, localSpannable.length(), localTextPaint, k).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0F, 1.0F).setIncludePad(true).setBreakStrategy(1).setHyphenationFrequency(1).build();
      break label131;
      if ((localMetrics != null) && ((i != 0) || (localMetrics.width <= paramFloat1)))
      {
        localObject = BoringLayout.make(localSpannable, localTextPaint, localMetrics.width, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, localMetrics, true);
        break label131;
      }
      if (Build.VERSION.SDK_INT < 23)
      {
        localObject = new StaticLayout(localSpannable, localTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        break label131;
      }
      localObject = StaticLayout.Builder.obtain(localSpannable, 0, localSpannable.length(), localTextPaint, (int)paramFloat1).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0F, 1.0F).setIncludePad(true).setBreakStrategy(1).setHyphenationFrequency(1).build();
      break label131;
      j = -1;
      break label150;
    }
  }

  public static class SetSpanOperation
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
 * Qualified Name:     com.facebook.react.views.text.TextLayoutManager
 * JD-Core Version:    0.6.2
 */