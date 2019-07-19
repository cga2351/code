package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public class FontMetricsUtil
{
  private static final float AMPLIFICATION_FACTOR = 100.0F;
  private static final String CAP_HEIGHT_MEASUREMENT_TEXT = "T";
  private static final String X_HEIGHT_MEASUREMENT_TEXT = "x";

  public static WritableArray getFontMetrics(CharSequence paramCharSequence, Layout paramLayout, TextPaint paramTextPaint, Context paramContext)
  {
    int i = 0;
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    WritableArray localWritableArray = Arguments.createArray();
    TextPaint localTextPaint = new TextPaint(paramTextPaint);
    localTextPaint.setTextSize(100.0F * localTextPaint.getTextSize());
    Rect localRect1 = new Rect();
    localTextPaint.getTextBounds("T", 0, "T".length(), localRect1);
    double d1 = localRect1.height() / 100.0F / localDisplayMetrics.density;
    Rect localRect2 = new Rect();
    localTextPaint.getTextBounds("x", 0, "x".length(), localRect2);
    double d2 = localRect2.height() / 100.0F / localDisplayMetrics.density;
    while (i < paramLayout.getLineCount())
    {
      Rect localRect3 = new Rect();
      paramLayout.getLineBounds(i, localRect3);
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("x", paramLayout.getLineLeft(i) / localDisplayMetrics.density);
      localWritableMap.putDouble("y", localRect3.top / localDisplayMetrics.density);
      localWritableMap.putDouble("width", paramLayout.getLineWidth(i) / localDisplayMetrics.density);
      localWritableMap.putDouble("height", localRect3.height() / localDisplayMetrics.density);
      localWritableMap.putDouble("descender", paramLayout.getLineDescent(i) / localDisplayMetrics.density);
      localWritableMap.putDouble("ascender", -paramLayout.getLineAscent(i) / localDisplayMetrics.density);
      localWritableMap.putDouble("baseline", paramLayout.getLineBaseline(i) / localDisplayMetrics.density);
      localWritableMap.putDouble("capHeight", d1);
      localWritableMap.putDouble("xHeight", d2);
      localWritableMap.putString("text", paramCharSequence.subSequence(paramLayout.getLineStart(i), paramLayout.getLineEnd(i)).toString());
      localWritableArray.pushMap(localWritableMap);
      i++;
    }
    return localWritableArray;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.FontMetricsUtil
 * JD-Core Version:    0.6.2
 */