package android.support.design.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g
  implements TypeEvaluator<Matrix>
{
  private final float[] a = new float[9];
  private final float[] b = new float[9];
  private final Matrix c = new Matrix();

  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.a);
    paramMatrix2.getValues(this.b);
    for (int i = 0; i < 9; i++)
    {
      float f = this.b[i] - this.a[i];
      this.b[i] = (this.a[i] + f * paramFloat);
    }
    this.c.setValues(this.b);
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.g
 * JD-Core Version:    0.6.2
 */