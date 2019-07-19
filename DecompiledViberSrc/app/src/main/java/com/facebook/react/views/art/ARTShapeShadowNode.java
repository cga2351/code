package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTShapeShadowNode extends ARTVirtualNode
{
  private static final int CAP_BUTT = 0;
  private static final int CAP_ROUND = 1;
  private static final int CAP_SQUARE = 2;
  private static final int COLOR_TYPE_LINEAR_GRADIENT = 1;
  private static final int COLOR_TYPE_PATTERN = 3;
  private static final int COLOR_TYPE_RADIAL_GRADIENT = 2;
  private static final int COLOR_TYPE_SOLID_COLOR = 0;
  private static final int JOIN_BEVEL = 2;
  private static final int JOIN_MITER = 0;
  private static final int JOIN_ROUND = 1;
  private static final int PATH_TYPE_ARC = 4;
  private static final int PATH_TYPE_CLOSE = 1;
  private static final int PATH_TYPE_CURVETO = 3;
  private static final int PATH_TYPE_LINETO = 2;
  private static final int PATH_TYPE_MOVETO;

  @Nullable
  private float[] mBrushData;

  @Nullable
  protected Path mPath;
  private int mStrokeCap = 1;

  @Nullable
  private float[] mStrokeColor;

  @Nullable
  private float[] mStrokeDash;
  private int mStrokeJoin = 1;
  private float mStrokeWidth = 1.0F;

  private Path createPath(float[] paramArrayOfFloat)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    int i = 0;
    float f1;
    float f2;
    float f3;
    float f4;
    int i4;
    label409: label461: label469: float f7;
    while (i < paramArrayOfFloat.length)
    {
      int j = i + 1;
      int k = (int)paramArrayOfFloat[i];
      switch (k)
      {
      default:
        throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + k);
      case 0:
        int i13 = j + 1;
        float f15 = paramArrayOfFloat[j] * this.mScale;
        i = i13 + 1;
        localPath.moveTo(f15, paramArrayOfFloat[i13] * this.mScale);
        break;
      case 1:
        localPath.close();
        i = j;
        break;
      case 2:
        int i12 = j + 1;
        float f14 = paramArrayOfFloat[j] * this.mScale;
        i = i12 + 1;
        localPath.lineTo(f14, paramArrayOfFloat[i12] * this.mScale);
        break;
      case 3:
        int i6 = j + 1;
        float f9 = paramArrayOfFloat[j] * this.mScale;
        int i7 = i6 + 1;
        float f10 = paramArrayOfFloat[i6] * this.mScale;
        int i8 = i7 + 1;
        float f11 = paramArrayOfFloat[i7] * this.mScale;
        int i9 = i8 + 1;
        float f12 = paramArrayOfFloat[i8] * this.mScale;
        int i10 = i9 + 1;
        float f13 = paramArrayOfFloat[i9] * this.mScale;
        int i11 = i10 + 1;
        localPath.cubicTo(f9, f10, f11, f12, f13, paramArrayOfFloat[i10] * this.mScale);
        i = i11;
        break;
      case 4:
        int m = j + 1;
        f1 = paramArrayOfFloat[j] * this.mScale;
        int n = m + 1;
        f2 = paramArrayOfFloat[m] * this.mScale;
        int i1 = n + 1;
        f3 = paramArrayOfFloat[n] * this.mScale;
        int i2 = i1 + 1;
        f4 = (float)Math.toDegrees(paramArrayOfFloat[i1]);
        int i3 = i2 + 1;
        float f5 = (float)Math.toDegrees(paramArrayOfFloat[i2]);
        i4 = i3 + 1;
        int i5;
        float f6;
        if (paramArrayOfFloat[i3] != 1.0F)
        {
          i5 = 1;
          f6 = f5 - f4;
          if (Math.abs(f6) < 360.0F)
            break label469;
          if (i5 == 0)
            break label461;
        }
        for (Path.Direction localDirection = Path.Direction.CCW; ; localDirection = Path.Direction.CW)
        {
          localPath.addCircle(f1, f2, f3, localDirection);
          i = i4;
          break;
          i5 = 0;
          break label409;
        }
        f7 = modulus(f6, 360.0F);
        if ((i5 == 0) || (f7 >= 360.0F))
          break label545;
      }
    }
    label545: for (float f8 = -1.0F * (360.0F - f7); ; f8 = f7)
    {
      localPath.arcTo(new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3), f4, f8);
      i = i4;
      break;
      return localPath;
    }
  }

  private float modulus(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1 % paramFloat2;
    if (f < 0.0F)
      f += paramFloat2;
    return f;
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    float f = paramFloat * this.mOpacity;
    if (f > 0.01F)
    {
      saveAndSetupCanvas(paramCanvas);
      if (this.mPath == null)
        throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
      if (setupFillPaint(paramPaint, f))
        paramCanvas.drawPath(this.mPath, paramPaint);
      if (setupStrokePaint(paramPaint, f))
        paramCanvas.drawPath(this.mPath, paramPaint);
      restoreCanvas(paramCanvas);
    }
    markUpdateSeen();
  }

  @ReactProp(name="fill")
  public void setFill(@Nullable ReadableArray paramReadableArray)
  {
    this.mBrushData = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(name="d")
  public void setShapePath(@Nullable ReadableArray paramReadableArray)
  {
    this.mPath = createPath(PropHelper.toFloatArray(paramReadableArray));
    markUpdated();
  }

  @ReactProp(name="stroke")
  public void setStroke(@Nullable ReadableArray paramReadableArray)
  {
    this.mStrokeColor = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="strokeCap")
  public void setStrokeCap(int paramInt)
  {
    this.mStrokeCap = paramInt;
    markUpdated();
  }

  @ReactProp(name="strokeDash")
  public void setStrokeDash(@Nullable ReadableArray paramReadableArray)
  {
    this.mStrokeDash = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="strokeJoin")
  public void setStrokeJoin(int paramInt)
  {
    this.mStrokeJoin = paramInt;
    markUpdated();
  }

  @ReactProp(defaultFloat=1.0F, name="strokeWidth")
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    markUpdated();
  }

  protected boolean setupFillPaint(Paint paramPaint, float paramFloat)
  {
    if ((this.mBrushData != null) && (this.mBrushData.length > 0))
    {
      paramPaint.reset();
      paramPaint.setFlags(1);
      paramPaint.setStyle(Paint.Style.FILL);
      int i = (int)this.mBrushData[0];
      switch (i)
      {
      default:
        FLog.w("ReactNative", "ART: Color type " + i + " not supported!");
      case 0:
      case 1:
      }
      while (true)
      {
        return true;
        if (this.mBrushData.length > 4);
        for (float f5 = 255.0F * (paramFloat * this.mBrushData[4]); ; f5 = 255.0F * paramFloat)
        {
          paramPaint.setARGB((int)f5, (int)(255.0F * this.mBrushData[1]), (int)(255.0F * this.mBrushData[2]), (int)(255.0F * this.mBrushData[3]));
          break;
        }
        if (this.mBrushData.length < 5)
        {
          FLog.w("ReactNative", "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received " + this.mBrushData.length);
          return false;
        }
        float f1 = this.mBrushData[1] * this.mScale;
        float f2 = this.mBrushData[2] * this.mScale;
        float f3 = this.mBrushData[3] * this.mScale;
        float f4 = this.mBrushData[4] * this.mScale;
        int j = (-5 + this.mBrushData.length) / 5;
        int[] arrayOfInt = null;
        float[] arrayOfFloat = null;
        if (j > 0)
        {
          arrayOfInt = new int[j];
          arrayOfFloat = new float[j];
          for (int k = 0; k < j; k++)
          {
            arrayOfFloat[k] = this.mBrushData[(k + (5 + j * 4))];
            int m = (int)(255.0F * this.mBrushData[(0 + (5 + k * 4))]);
            int n = (int)(255.0F * this.mBrushData[(1 + (5 + k * 4))]);
            int i1 = (int)(255.0F * this.mBrushData[(2 + (5 + k * 4))]);
            arrayOfInt[k] = Color.argb((int)(255.0F * this.mBrushData[(3 + (5 + k * 4))]), m, n, i1);
          }
        }
        paramPaint.setShader(new LinearGradient(f1, f2, f3, f4, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP));
      }
    }
    return false;
  }

  protected boolean setupStrokePaint(Paint paramPaint, float paramFloat)
  {
    if ((this.mStrokeWidth == 0.0F) || (this.mStrokeColor == null) || (this.mStrokeColor.length == 0))
      return false;
    paramPaint.reset();
    paramPaint.setFlags(1);
    paramPaint.setStyle(Paint.Style.STROKE);
    switch (this.mStrokeCap)
    {
    default:
      throw new JSApplicationIllegalArgumentException("strokeCap " + this.mStrokeCap + " unrecognized");
    case 0:
      paramPaint.setStrokeCap(Paint.Cap.BUTT);
    case 2:
    case 1:
    }
    while (true)
      switch (this.mStrokeJoin)
      {
      default:
        throw new JSApplicationIllegalArgumentException("strokeJoin " + this.mStrokeJoin + " unrecognized");
        paramPaint.setStrokeCap(Paint.Cap.SQUARE);
        continue;
        paramPaint.setStrokeCap(Paint.Cap.ROUND);
      case 0:
      case 2:
      case 1:
      }
    paramPaint.setStrokeJoin(Paint.Join.MITER);
    paramPaint.setStrokeWidth(this.mStrokeWidth * this.mScale);
    if (this.mStrokeColor.length > 3);
    for (float f = 255.0F * (paramFloat * this.mStrokeColor[3]); ; f = paramFloat * 255.0F)
    {
      paramPaint.setARGB((int)f, (int)(255.0F * this.mStrokeColor[0]), (int)(255.0F * this.mStrokeColor[1]), (int)(255.0F * this.mStrokeColor[2]));
      if ((this.mStrokeDash != null) && (this.mStrokeDash.length > 0))
        paramPaint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0F));
      return true;
      paramPaint.setStrokeJoin(Paint.Join.BEVEL);
      break;
      paramPaint.setStrokeJoin(Paint.Join.ROUND);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTShapeShadowNode
 * JD-Core Version:    0.6.2
 */