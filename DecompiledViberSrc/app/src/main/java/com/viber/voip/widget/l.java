package com.viber.voip.widget;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.util.Property;

public class l extends CharacterStyle
  implements UpdateAppearance
{
  private final float a;
  private final int[] b;
  private Shader c = null;
  private Matrix d = new Matrix();
  private float e;

  public l(float paramFloat, int[] paramArrayOfInt)
  {
    this.a = paramFloat;
    this.b = paramArrayOfInt;
  }

  public float a()
  {
    return this.e;
  }

  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setStyle(Paint.Style.FILL);
    if (this.c == null)
      this.c = new LinearGradient(0.0F, 0.0F, this.a, 0.0F, this.b, null, Shader.TileMode.REPEAT);
    this.d.reset();
    this.d.postTranslate(this.a * this.e, 0.0F);
    this.c.setLocalMatrix(this.d);
    paramTextPaint.setShader(this.c);
  }

  public static class a extends Property<l, Float>
  {
    public a()
    {
      super("GRADIENT_TRANSLATE_PROPERTY");
    }

    public Float a(l paraml)
    {
      return Float.valueOf(paraml.a());
    }

    public void a(l paraml, Float paramFloat)
    {
      paraml.a(paramFloat.floatValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.l
 * JD-Core Version:    0.6.2
 */