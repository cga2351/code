package com.viber.common.d;

import android.graphics.Matrix;
import android.graphics.Path;

public class h
{
  private static final Matrix a = new Matrix();

  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Path paramPath)
  {
    paramPath.reset();
    paramPath.moveTo(262.28F, 33.863998F);
    paramPath.rCubicTo(-7.649F, -7.639F, -33.723F, -33.605999F, -114.196F, -33.862F);
    paramPath.cubicTo(147.748F, 0.001F, 147.411F, 0.0F, 147.073F, 0.0F);
    paramPath.rCubicTo(-0.348F, 0.0F, -0.695F, 0.001F, -1.042F, 0.002F);
    paramPath.cubicTo(65.591003F, 0.264F, 40.571999F, 26.226F, 32.924F, 33.863998F);
    paramPath.cubicTo(12.654F, 52.948002F, -1.035F, 90.846001F, 0.063F, 149.0F);
    paramPath.rCubicTo(-1.099F, 57.077F, 12.374F, 95.385002F, 32.666F, 114.468F);
    paramPath.rCubicTo(7.671F, 7.653F, 33.095001F, 33.372002F, 113.364F, 33.529999F);
    paramPath.rLineTo(0.0F, 0.0F);
    paramPath.rCubicTo(-0.551F, 0.001F, 0.336F, 0.0F, 0.98F, 0.0F);
    paramPath.rCubicTo(0.341F, 0.0F, 0.98F, 0.0F, 0.98F, 0.0F);
    paramPath.rCubicTo(80.268997F, -0.158F, 106.751F, -25.878F, 114.423F, -33.529999F);
    paramPath.rCubicTo(20.292F, -19.084F, 33.685001F, -57.390999F, 32.587002F, -114.468F);
    paramPath.rLineTo(0.0F, 0.0F);
    paramPath.cubicTo(296.16F, 90.846001F, 282.54999F, 52.948002F, 262.28F, 33.863998F);
    paramPath.close();
    a.reset();
    Matrix localMatrix = a;
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = (paramFloat1 / 295.125F);
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (paramFloat2 / 296.99899F);
    arrayOfFloat[5] = paramFloat4;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    localMatrix.setValues(arrayOfFloat);
    paramPath.transform(a);
  }

  public static void a(float paramFloat1, float paramFloat2, Path paramPath)
  {
    paramPath.reset();
    paramPath.moveTo(24.742188F, 0.0F);
    paramPath.cubicTo(11.200054F, 0.0441079F, 6.988719F, 4.415309F, 5.701172F, 5.701172F);
    paramPath.cubicTo(2.288702F, 8.913978F, -0.01688036F, 15.293715F, 0.1679688F, 25.083984F);
    paramPath.cubicTo(0.1679304F, 25.085978F, 0.1680069F, 25.087851F, 0.1679688F, 25.089844F);
    paramPath.lineTo(24.921875F, 25.089844F);
    paramPath.lineTo(24.921875F, 0.0F);
    paramPath.cubicTo(24.920567F, -1.758919E-007F, 24.919277F, 1.661613E-021F, 24.917969F, 0.0F);
    paramPath.cubicTo(24.859383F, 0.0F, 24.800606F, -0.0001683507F, 24.742188F, 0.0F);
    paramPath.close();
    a.reset();
    Matrix localMatrix = a;
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = (5.93998F * (paramFloat1 / 295.125F));
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (5.93998F * (paramFloat2 / 296.99899F));
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    localMatrix.setValues(arrayOfFloat);
    paramPath.transform(a);
  }

  public static void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Path paramPath)
  {
    paramPath.reset();
    paramPath.moveTo(70.924423F, 17.731005F);
    paramPath.cubicTo(78.339218F, 10.490925F, 88.520813F, 1.010168F, 99.754723F, 1.000011F);
    paramPath.cubicTo(122.4582F, 0.979695F, 140.88344F, 19.14691F, 140.91386F, 41.598469F);
    paramPath.cubicTo(140.99306F, 93.18911F, 70.924423F, 124.85743F, 70.924423F, 124.85743F);
    paramPath.cubicTo(70.924423F, 124.85743F, 1.067037F, 93.357689F, 0.999998F, 41.775196F);
    paramPath.cubicTo(0.9817144F, 19.325693F, 19.362246F, 1.093459F, 42.059582F, 1.071111F);
    paramPath.cubicTo(53.309746F, 1.058922F, 63.499474F, 10.513274F, 70.924423F, 17.731005F);
    paramPath.close();
    float f1 = paramFloat1 / 140.914F;
    float f2 = paramFloat2 / 140.914F;
    float f3 = paramFloat3 + -0.4999847F * f1;
    float f4 = paramFloat4 + 9.509614F * f2;
    a.set(null);
    a.setValues(new float[] { f1, 0.0F, f3, 0.0F, f2, f4, 0.0F, 0.0F, 1.0F });
    paramPath.transform(a);
  }

  public static void b(float paramFloat1, float paramFloat2, Path paramPath)
  {
    paramPath.reset();
    paramPath.moveTo(23.568359F, 0.0273438F);
    paramPath.cubicTo(10.975155F, 0.316775F, 6.949872F, 4.454104F, 5.701172F, 5.701172F);
    paramPath.cubicTo(2.600493F, 8.62043F, 0.4204479F, 14.164715F, 0.1855469F, 22.496094F);
    paramPath.lineTo(0.1855469F, 27.660156F);
    paramPath.cubicTo(0.4193141F, 35.849415F, 2.567742F, 41.439953F, 5.667969F, 44.355469F);
    paramPath.cubicTo(6.919031F, 45.603596F, 11.001143F, 49.693291F, 23.539063F, 49.972656F);
    paramPath.lineTo(24.888672F, 49.972656F);
    paramPath.lineTo(24.888672F, 0.0273438F);
    paramPath.lineTo(23.568359F, 0.0273438F);
    paramPath.close();
    a.reset();
    Matrix localMatrix = a;
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = (5.93998F * (paramFloat1 / 295.125F));
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (5.93998F * (paramFloat2 / 296.99899F));
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    localMatrix.setValues(arrayOfFloat);
    paramPath.transform(a);
  }

  public static void c(float paramFloat1, float paramFloat2, Path paramPath)
  {
    a(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPath);
  }

  public static void d(float paramFloat1, float paramFloat2, Path paramPath)
  {
    b(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPath);
  }

  public static void e(float paramFloat1, float paramFloat2, Path paramPath)
  {
    paramPath.reset();
    paramPath.moveTo(21.0F, 9.8F);
    paramPath.lineTo(30.1F, 9.8F);
    paramPath.moveTo(21.0F, 9.8F);
    paramPath.quadTo(12.3F, 9.8F, 6.15F, 15.8F);
    paramPath.quadTo(0.0F, 21.85F, 0.0F, 30.35F);
    paramPath.quadTo(0.0F, 38.849998F, 6.15F, 44.849998F);
    paramPath.quadTo(12.3F, 50.849998F, 21.0F, 50.849998F);
    paramPath.quadTo(29.65F, 50.849998F, 35.849998F, 44.849998F);
    paramPath.quadTo(42.0F, 38.799999F, 42.0F, 30.35F);
    paramPath.moveTo(31.1F, 9.9F);
    paramPath.lineTo(19.85F, 19.6F);
    paramPath.moveTo(31.1F, 9.9F);
    paramPath.lineTo(20.0F, 0.0F);
    a.set(null);
    Matrix localMatrix = a;
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = (paramFloat1 / 278.0F);
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (paramFloat2 / 278.0F);
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    localMatrix.setValues(arrayOfFloat);
    paramPath.transform(a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.h
 * JD-Core Version:    0.6.2
 */