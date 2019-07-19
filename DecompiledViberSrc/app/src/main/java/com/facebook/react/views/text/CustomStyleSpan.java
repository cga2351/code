package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import javax.annotation.Nullable;

public class CustomStyleSpan extends MetricAffectingSpan
  implements ReactSpan
{
  private final AssetManager mAssetManager;

  @Nullable
  private final String mFontFamily;
  private final int mStyle;
  private final int mWeight;

  public CustomStyleSpan(int paramInt1, int paramInt2, @Nullable String paramString, AssetManager paramAssetManager)
  {
    this.mStyle = paramInt1;
    this.mWeight = paramInt2;
    this.mFontFamily = paramString;
    this.mAssetManager = paramAssetManager;
  }

  private static void apply(Paint paramPaint, int paramInt1, int paramInt2, @Nullable String paramString, AssetManager paramAssetManager)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    int i;
    int j;
    if (localTypeface == null)
    {
      i = 0;
      if (paramInt2 != 1)
      {
        int k = i & 0x1;
        j = 0;
        if (k != 0)
        {
          j = 0;
          if (paramInt2 != -1);
        }
      }
      else
      {
        j = 1;
      }
      if ((paramInt1 == 2) || (((i & 0x2) != 0) && (paramInt1 == -1)))
        j |= 2;
      if (paramString == null)
        break label112;
      localTypeface = ReactFontManager.getInstance().getTypeface(paramString, j, paramAssetManager);
      label84: if (localTypeface == null)
        break label129;
      paramPaint.setTypeface(localTypeface);
    }
    while (true)
    {
      paramPaint.setSubpixelText(true);
      return;
      i = localTypeface.getStyle();
      break;
      label112: if (localTypeface == null)
        break label84;
      localTypeface = Typeface.create(localTypeface, j);
      break label84;
      label129: paramPaint.setTypeface(Typeface.defaultFromStyle(j));
    }
  }

  @Nullable
  public String getFontFamily()
  {
    return this.mFontFamily;
  }

  public int getStyle()
  {
    if (this.mStyle == -1)
      return 0;
    return this.mStyle;
  }

  public int getWeight()
  {
    if (this.mWeight == -1)
      return 0;
    return this.mWeight;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
  }

  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.CustomStyleSpan
 * JD-Core Version:    0.6.2
 */