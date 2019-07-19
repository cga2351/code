package android.support.design.a;

import android.animation.TypeEvaluator;

public class c
  implements TypeEvaluator<Integer>
{
  private static final c a = new c();

  public static c a()
  {
    return a;
  }

  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    float f1 = (0xFF & i >> 24) / 255.0F;
    float f2 = (0xFF & i >> 16) / 255.0F;
    float f3 = (0xFF & i >> 8) / 255.0F;
    float f4 = (i & 0xFF) / 255.0F;
    int j = paramInteger2.intValue();
    float f5 = (0xFF & j >> 24) / 255.0F;
    float f6 = (0xFF & j >> 16) / 255.0F;
    float f7 = (0xFF & j >> 8) / 255.0F;
    float f8 = (j & 0xFF) / 255.0F;
    float f9 = (float)Math.pow(f2, 2.2D);
    float f10 = (float)Math.pow(f3, 2.2D);
    float f11 = (float)Math.pow(f4, 2.2D);
    float f12 = (float)Math.pow(f6, 2.2D);
    float f13 = (float)Math.pow(f7, 2.2D);
    float f14 = (float)Math.pow(f8, 2.2D);
    float f15 = f1 + paramFloat * (f5 - f1);
    float f16 = f9 + paramFloat * (f12 - f9);
    float f17 = f10 + paramFloat * (f13 - f10);
    float f18 = f11 + paramFloat * (f14 - f11);
    float f19 = f15 * 255.0F;
    float f20 = 255.0F * (float)Math.pow(f16, 0.4545454545454545D);
    float f21 = 255.0F * (float)Math.pow(f17, 0.4545454545454545D);
    float f22 = 255.0F * (float)Math.pow(f18, 0.4545454545454545D);
    return Integer.valueOf(Math.round(f19) << 24 | Math.round(f20) << 16 | Math.round(f21) << 8 | Math.round(f22));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.c
 * JD-Core Version:    0.6.2
 */