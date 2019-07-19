package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTTextShadowNode extends ARTShapeShadowNode
{
  private static final int DEFAULT_FONT_SIZE = 12;
  private static final String PROP_FONT = "font";
  private static final String PROP_FONT_FAMILY = "fontFamily";
  private static final String PROP_FONT_SIZE = "fontSize";
  private static final String PROP_FONT_STYLE = "fontStyle";
  private static final String PROP_FONT_WEIGHT = "fontWeight";
  private static final String PROP_LINES = "lines";
  private static final int TEXT_ALIGNMENT_CENTER = 2;
  private static final int TEXT_ALIGNMENT_LEFT = 0;
  private static final int TEXT_ALIGNMENT_RIGHT = 1;

  @Nullable
  private ReadableMap mFrame;
  private int mTextAlignment = 0;

  private void applyTextPropertiesToPaint(Paint paramPaint)
  {
    int i = 1;
    ReadableMap localReadableMap;
    int j;
    label136: int k;
    switch (this.mTextAlignment)
    {
    default:
      if ((this.mFrame != null) && (this.mFrame.hasKey("font")))
      {
        localReadableMap = this.mFrame.getMap("font");
        if (localReadableMap != null)
        {
          float f = 12.0F;
          if (localReadableMap.hasKey("fontSize"))
            f = (float)localReadableMap.getDouble("fontSize");
          paramPaint.setTextSize(f * this.mScale);
          if ((!localReadableMap.hasKey("fontWeight")) || (!"bold".equals(localReadableMap.getString("fontWeight"))))
            break label226;
          j = i;
          if ((!localReadableMap.hasKey("fontStyle")) || (!"italic".equals(localReadableMap.getString("fontStyle"))))
            break label232;
          k = i;
          label166: if ((j == 0) || (k == 0))
            break label238;
          i = 3;
        }
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      paramPaint.setTypeface(Typeface.create(localReadableMap.getString("fontFamily"), i));
      return;
      paramPaint.setTextAlign(Paint.Align.LEFT);
      break;
      paramPaint.setTextAlign(Paint.Align.RIGHT);
      break;
      paramPaint.setTextAlign(Paint.Align.CENTER);
      break;
      label226: j = 0;
      break label136;
      label232: k = 0;
      break label166;
      label238: if (j == 0)
        if (k != 0)
          i = 2;
        else
          i = 0;
    }
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    if (this.mFrame == null);
    float f;
    ReadableArray localReadableArray;
    do
    {
      do
      {
        return;
        f = paramFloat * this.mOpacity;
      }
      while ((f <= 0.01F) || (!this.mFrame.hasKey("lines")));
      localReadableArray = this.mFrame.getArray("lines");
    }
    while ((localReadableArray == null) || (localReadableArray.size() == 0));
    saveAndSetupCanvas(paramCanvas);
    String[] arrayOfString = new String[localReadableArray.size()];
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString[i] = localReadableArray.getString(i);
    String str = TextUtils.join("\n", arrayOfString);
    if (setupStrokePaint(paramPaint, f))
    {
      applyTextPropertiesToPaint(paramPaint);
      if (this.mPath == null)
        paramCanvas.drawText(str, 0.0F, -paramPaint.ascent(), paramPaint);
    }
    else if (setupFillPaint(paramPaint, f))
    {
      applyTextPropertiesToPaint(paramPaint);
      if (this.mPath != null)
        break label219;
      paramCanvas.drawText(str, 0.0F, -paramPaint.ascent(), paramPaint);
    }
    while (true)
    {
      restoreCanvas(paramCanvas);
      markUpdateSeen();
      return;
      paramCanvas.drawTextOnPath(str, this.mPath, 0.0F, 0.0F, paramPaint);
      break;
      label219: paramCanvas.drawTextOnPath(str, this.mPath, 0.0F, 0.0F, paramPaint);
    }
  }

  @ReactProp(defaultInt=0, name="alignment")
  public void setAlignment(int paramInt)
  {
    this.mTextAlignment = paramInt;
  }

  @ReactProp(name="frame")
  public void setFrame(@Nullable ReadableMap paramReadableMap)
  {
    this.mFrame = paramReadableMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTTextShadowNode
 * JD-Core Version:    0.6.2
 */