package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Array;

public class MatrixMathHelper
{
  private static final double EPSILON = 1.E-005D;

  public static void applyPerspective(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[11] = (-1.0D / paramDouble);
  }

  public static void applyRotateX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[5] = Math.cos(paramDouble);
    paramArrayOfDouble[6] = Math.sin(paramDouble);
    paramArrayOfDouble[9] = (-Math.sin(paramDouble));
    paramArrayOfDouble[10] = Math.cos(paramDouble);
  }

  public static void applyRotateY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = Math.cos(paramDouble);
    paramArrayOfDouble[2] = (-Math.sin(paramDouble));
    paramArrayOfDouble[8] = Math.sin(paramDouble);
    paramArrayOfDouble[10] = Math.cos(paramDouble);
  }

  public static void applyRotateZ(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = Math.cos(paramDouble);
    paramArrayOfDouble[1] = Math.sin(paramDouble);
    paramArrayOfDouble[4] = (-Math.sin(paramDouble));
    paramArrayOfDouble[5] = Math.cos(paramDouble);
  }

  public static void applyScaleX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[0] = paramDouble;
  }

  public static void applyScaleY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[5] = paramDouble;
  }

  public static void applyScaleZ(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[10] = paramDouble;
  }

  public static void applySkewX(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[4] = Math.tan(paramDouble);
  }

  public static void applySkewY(double[] paramArrayOfDouble, double paramDouble)
  {
    paramArrayOfDouble[1] = Math.tan(paramDouble);
  }

  public static void applyTranslate2D(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    paramArrayOfDouble[12] = paramDouble1;
    paramArrayOfDouble[13] = paramDouble2;
  }

  public static void applyTranslate3D(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramArrayOfDouble[12] = paramDouble1;
    paramArrayOfDouble[13] = paramDouble2;
    paramArrayOfDouble[14] = paramDouble3;
  }

  public static double[] createIdentityMatrix()
  {
    double[] arrayOfDouble = new double[16];
    resetIdentityMatrix(arrayOfDouble);
    return arrayOfDouble;
  }

  public static void decomposeMatrix(double[] paramArrayOfDouble, MatrixDecompositionContext paramMatrixDecompositionContext)
  {
    boolean bool;
    double[] arrayOfDouble1;
    double[] arrayOfDouble2;
    double[] arrayOfDouble3;
    double[] arrayOfDouble4;
    double[] arrayOfDouble5;
    if (paramArrayOfDouble.length == 16)
    {
      bool = true;
      Assertions.assertCondition(bool);
      arrayOfDouble1 = paramMatrixDecompositionContext.perspective;
      arrayOfDouble2 = paramMatrixDecompositionContext.scale;
      arrayOfDouble3 = paramMatrixDecompositionContext.skew;
      arrayOfDouble4 = paramMatrixDecompositionContext.translation;
      arrayOfDouble5 = paramMatrixDecompositionContext.rotationDegrees;
      if (!isZero(paramArrayOfDouble[15]))
        break label58;
    }
    label58: double[][] arrayOfDouble6;
    double[] arrayOfDouble7;
    do
    {
      return;
      bool = false;
      break;
      int[] arrayOfInt1 = { 4, 4 };
      arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, arrayOfInt1);
      arrayOfDouble7 = new double[16];
      for (int i = 0; i < 4; i++)
        for (int n = 0; n < 4; n++)
        {
          double d = paramArrayOfDouble[(n + i * 4)] / paramArrayOfDouble[15];
          arrayOfDouble6[i][n] = d;
          int i1 = n + i * 4;
          if (n == 3)
            d = 0.0D;
          arrayOfDouble7[i1] = d;
        }
      arrayOfDouble7[15] = 1.0D;
    }
    while (isZero(determinant(arrayOfDouble7)));
    if ((!isZero(arrayOfDouble6[0][3])) || (!isZero(arrayOfDouble6[1][3])) || (!isZero(arrayOfDouble6[2][3])))
    {
      double[] arrayOfDouble8 = new double[4];
      arrayOfDouble8[0] = arrayOfDouble6[0][3];
      arrayOfDouble8[1] = arrayOfDouble6[1][3];
      arrayOfDouble8[2] = arrayOfDouble6[2][3];
      arrayOfDouble8[3] = arrayOfDouble6[3][3];
      multiplyVectorByMatrix(arrayOfDouble8, transpose(inverse(arrayOfDouble7)), arrayOfDouble1);
    }
    while (true)
    {
      for (int j = 0; j < 3; j++)
        arrayOfDouble4[j] = arrayOfDouble6[3][j];
      arrayOfDouble1[2] = 0.0D;
      arrayOfDouble1[1] = 0.0D;
      arrayOfDouble1[0] = 0.0D;
      arrayOfDouble1[3] = 1.0D;
    }
    int[] arrayOfInt2 = { 3, 3 };
    double[][] arrayOfDouble9 = (double[][])Array.newInstance(Double.TYPE, arrayOfInt2);
    for (int k = 0; k < 3; k++)
    {
      arrayOfDouble9[k][0] = arrayOfDouble6[k][0];
      arrayOfDouble9[k][1] = arrayOfDouble6[k][1];
      arrayOfDouble9[k][2] = arrayOfDouble6[k][2];
    }
    arrayOfDouble2[0] = v3Length(arrayOfDouble9[0]);
    arrayOfDouble9[0] = v3Normalize(arrayOfDouble9[0], arrayOfDouble2[0]);
    arrayOfDouble3[0] = v3Dot(arrayOfDouble9[0], arrayOfDouble9[1]);
    arrayOfDouble9[1] = v3Combine(arrayOfDouble9[1], arrayOfDouble9[0], 1.0D, -arrayOfDouble3[0]);
    arrayOfDouble3[0] = v3Dot(arrayOfDouble9[0], arrayOfDouble9[1]);
    arrayOfDouble9[1] = v3Combine(arrayOfDouble9[1], arrayOfDouble9[0], 1.0D, -arrayOfDouble3[0]);
    arrayOfDouble2[1] = v3Length(arrayOfDouble9[1]);
    arrayOfDouble9[1] = v3Normalize(arrayOfDouble9[1], arrayOfDouble2[1]);
    arrayOfDouble3[0] /= arrayOfDouble2[1];
    arrayOfDouble3[1] = v3Dot(arrayOfDouble9[0], arrayOfDouble9[2]);
    arrayOfDouble9[2] = v3Combine(arrayOfDouble9[2], arrayOfDouble9[0], 1.0D, -arrayOfDouble3[1]);
    arrayOfDouble3[2] = v3Dot(arrayOfDouble9[1], arrayOfDouble9[2]);
    arrayOfDouble9[2] = v3Combine(arrayOfDouble9[2], arrayOfDouble9[1], 1.0D, -arrayOfDouble3[2]);
    arrayOfDouble2[2] = v3Length(arrayOfDouble9[2]);
    arrayOfDouble9[2] = v3Normalize(arrayOfDouble9[2], arrayOfDouble2[2]);
    arrayOfDouble3[1] /= arrayOfDouble2[2];
    arrayOfDouble3[2] /= arrayOfDouble2[2];
    double[] arrayOfDouble10 = v3Cross(arrayOfDouble9[1], arrayOfDouble9[2]);
    if (v3Dot(arrayOfDouble9[0], arrayOfDouble10) < 0.0D)
      for (int m = 0; m < 3; m++)
      {
        arrayOfDouble2[m] = (-1.0D * arrayOfDouble2[m]);
        double[] arrayOfDouble11 = arrayOfDouble9[m];
        arrayOfDouble11[0] = (-1.0D * arrayOfDouble11[0]);
        double[] arrayOfDouble12 = arrayOfDouble9[m];
        arrayOfDouble12[1] = (-1.0D * arrayOfDouble12[1]);
        double[] arrayOfDouble13 = arrayOfDouble9[m];
        arrayOfDouble13[2] = (-1.0D * arrayOfDouble13[2]);
      }
    arrayOfDouble5[0] = roundTo3Places(57.295779513082323D * -Math.atan2(arrayOfDouble9[2][1], arrayOfDouble9[2][2]));
    arrayOfDouble5[1] = roundTo3Places(57.295779513082323D * -Math.atan2(-arrayOfDouble9[2][0], Math.sqrt(arrayOfDouble9[2][1] * arrayOfDouble9[2][1] + arrayOfDouble9[2][2] * arrayOfDouble9[2][2])));
    arrayOfDouble5[2] = roundTo3Places(57.295779513082323D * -Math.atan2(arrayOfDouble9[1][0], arrayOfDouble9[0][0]));
  }

  public static double degreesToRadians(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }

  public static double determinant(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    double d3 = paramArrayOfDouble[2];
    double d4 = paramArrayOfDouble[3];
    double d5 = paramArrayOfDouble[4];
    double d6 = paramArrayOfDouble[5];
    double d7 = paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[7];
    double d9 = paramArrayOfDouble[8];
    double d10 = paramArrayOfDouble[9];
    double d11 = paramArrayOfDouble[10];
    double d12 = paramArrayOfDouble[11];
    double d13 = paramArrayOfDouble[12];
    double d14 = paramArrayOfDouble[13];
    double d15 = paramArrayOfDouble[14];
    double d16 = paramArrayOfDouble[15];
    return d13 * (d10 * (d4 * d7)) - d13 * (d10 * (d3 * d8)) - d13 * (d11 * (d4 * d6)) + d13 * (d11 * (d2 * d8)) + d13 * (d12 * (d3 * d6)) - d13 * (d12 * (d2 * d7)) - d14 * (d9 * (d4 * d7)) + d14 * (d9 * (d3 * d8)) + d14 * (d11 * (d4 * d5)) - d14 * (d11 * (d1 * d8)) - d14 * (d12 * (d3 * d5)) + d14 * (d12 * (d1 * d7)) + d15 * (d9 * (d4 * d6)) - d15 * (d9 * (d2 * d8)) - d15 * (d10 * (d4 * d5)) + d15 * (d10 * (d8 * d1)) + d15 * (d12 * (d2 * d5)) - d15 * (d12 * (d1 * d6)) - d16 * (d9 * (d3 * d6)) + d16 * (d9 * (d2 * d7)) + d16 * (d10 * (d3 * d5)) - d16 * (d10 * (d1 * d7)) - d16 * (d11 * (d2 * d5)) + d16 * (d11 * (d1 * d6));
  }

  public static double[] inverse(double[] paramArrayOfDouble)
  {
    double d1 = determinant(paramArrayOfDouble);
    if (isZero(d1))
      return paramArrayOfDouble;
    double d2 = paramArrayOfDouble[0];
    double d3 = paramArrayOfDouble[1];
    double d4 = paramArrayOfDouble[2];
    double d5 = paramArrayOfDouble[3];
    double d6 = paramArrayOfDouble[4];
    double d7 = paramArrayOfDouble[5];
    double d8 = paramArrayOfDouble[6];
    double d9 = paramArrayOfDouble[7];
    double d10 = paramArrayOfDouble[8];
    double d11 = paramArrayOfDouble[9];
    double d12 = paramArrayOfDouble[10];
    double d13 = paramArrayOfDouble[11];
    double d14 = paramArrayOfDouble[12];
    double d15 = paramArrayOfDouble[13];
    double d16 = paramArrayOfDouble[14];
    double d17 = paramArrayOfDouble[15];
    double[] arrayOfDouble = new double[16];
    arrayOfDouble[0] = ((d15 * (d8 * d13) - d15 * (d9 * d12) + d16 * (d9 * d11) - d16 * (d7 * d13) - d17 * (d8 * d11) + d17 * (d7 * d12)) / d1);
    arrayOfDouble[1] = ((d15 * (d5 * d12) - d15 * (d4 * d13) - d16 * (d5 * d11) + d16 * (d3 * d13) + d17 * (d4 * d11) - d17 * (d3 * d12)) / d1);
    arrayOfDouble[2] = ((d15 * (d4 * d9) - d15 * (d5 * d8) + d16 * (d5 * d7) - d16 * (d3 * d9) - d17 * (d4 * d7) + d17 * (d3 * d8)) / d1);
    arrayOfDouble[3] = ((d11 * (d5 * d8) - d11 * (d4 * d9) - d12 * (d5 * d7) + d12 * (d3 * d9) + d13 * (d4 * d7) - d13 * (d3 * d8)) / d1);
    arrayOfDouble[4] = ((d14 * (d9 * d12) - d14 * (d8 * d13) - d16 * (d9 * d10) + d16 * (d6 * d13) + d17 * (d8 * d10) - d17 * (d6 * d12)) / d1);
    arrayOfDouble[5] = ((d14 * (d4 * d13) - d14 * (d5 * d12) + d16 * (d5 * d10) - d16 * (d2 * d13) - d17 * (d4 * d10) + d17 * (d2 * d12)) / d1);
    arrayOfDouble[6] = ((d14 * (d5 * d8) - d14 * (d4 * d9) - d16 * (d5 * d6) + d16 * (d2 * d9) + d17 * (d4 * d6) - d17 * (d2 * d8)) / d1);
    arrayOfDouble[7] = ((d10 * (d4 * d9) - d10 * (d5 * d8) + d12 * (d5 * d6) - d12 * (d2 * d9) - d13 * (d4 * d6) + d13 * (d2 * d8)) / d1);
    arrayOfDouble[8] = ((d14 * (d7 * d13) - d14 * (d9 * d11) + d15 * (d9 * d10) - d15 * (d6 * d13) - d17 * (d7 * d10) + d17 * (d6 * d11)) / d1);
    arrayOfDouble[9] = ((d14 * (d5 * d11) - d14 * (d3 * d13) - d15 * (d5 * d10) + d15 * (d2 * d13) + d17 * (d3 * d10) - d17 * (d2 * d11)) / d1);
    arrayOfDouble[10] = ((d14 * (d3 * d9) - d14 * (d5 * d7) + d15 * (d5 * d6) - d15 * (d2 * d9) - d17 * (d3 * d6) + d17 * (d2 * d7)) / d1);
    arrayOfDouble[11] = ((d10 * (d5 * d7) - d10 * (d3 * d9) - d11 * (d5 * d6) + d11 * (d9 * d2) + d13 * (d3 * d6) - d13 * (d2 * d7)) / d1);
    arrayOfDouble[12] = ((d14 * (d8 * d11) - d14 * (d7 * d12) - d15 * (d8 * d10) + d15 * (d6 * d12) + d16 * (d7 * d10) - d16 * (d6 * d11)) / d1);
    arrayOfDouble[13] = ((d14 * (d3 * d12) - d14 * (d4 * d11) + d15 * (d4 * d10) - d15 * (d2 * d12) - d16 * (d3 * d10) + d16 * (d2 * d11)) / d1);
    arrayOfDouble[14] = ((d14 * (d4 * d7) - d14 * (d3 * d8) - d15 * (d4 * d6) + d15 * (d2 * d8) + d16 * (d3 * d6) - d16 * (d2 * d7)) / d1);
    arrayOfDouble[15] = ((d10 * (d3 * d8) - d10 * (d4 * d7) + d11 * (d4 * d6) - d11 * (d8 * d2) - d12 * (d3 * d6) + d12 * (d2 * d7)) / d1);
    return arrayOfDouble;
  }

  private static boolean isZero(double paramDouble)
  {
    if (Double.isNaN(paramDouble));
    while (Math.abs(paramDouble) >= 1.E-005D)
      return false;
    return true;
  }

  public static void multiplyInto(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    double d1 = paramArrayOfDouble2[0];
    double d2 = paramArrayOfDouble2[1];
    double d3 = paramArrayOfDouble2[2];
    double d4 = paramArrayOfDouble2[3];
    double d5 = paramArrayOfDouble2[4];
    double d6 = paramArrayOfDouble2[5];
    double d7 = paramArrayOfDouble2[6];
    double d8 = paramArrayOfDouble2[7];
    double d9 = paramArrayOfDouble2[8];
    double d10 = paramArrayOfDouble2[9];
    double d11 = paramArrayOfDouble2[10];
    double d12 = paramArrayOfDouble2[11];
    double d13 = paramArrayOfDouble2[12];
    double d14 = paramArrayOfDouble2[13];
    double d15 = paramArrayOfDouble2[14];
    double d16 = paramArrayOfDouble2[15];
    double d17 = paramArrayOfDouble3[0];
    double d18 = paramArrayOfDouble3[1];
    double d19 = paramArrayOfDouble3[2];
    double d20 = paramArrayOfDouble3[3];
    paramArrayOfDouble1[0] = (d17 * d1 + d18 * d5 + d19 * d9 + d20 * d13);
    paramArrayOfDouble1[1] = (d17 * d2 + d18 * d6 + d19 * d10 + d20 * d14);
    paramArrayOfDouble1[2] = (d17 * d3 + d18 * d7 + d19 * d11 + d20 * d15);
    paramArrayOfDouble1[3] = (d17 * d4 + d18 * d8 + d19 * d12 + d20 * d16);
    double d21 = paramArrayOfDouble3[4];
    double d22 = paramArrayOfDouble3[5];
    double d23 = paramArrayOfDouble3[6];
    double d24 = paramArrayOfDouble3[7];
    paramArrayOfDouble1[4] = (d21 * d1 + d22 * d5 + d23 * d9 + d24 * d13);
    paramArrayOfDouble1[5] = (d21 * d2 + d22 * d6 + d23 * d10 + d24 * d14);
    paramArrayOfDouble1[6] = (d21 * d3 + d22 * d7 + d23 * d11 + d24 * d15);
    paramArrayOfDouble1[7] = (d21 * d4 + d22 * d8 + d23 * d12 + d24 * d16);
    double d25 = paramArrayOfDouble3[8];
    double d26 = paramArrayOfDouble3[9];
    double d27 = paramArrayOfDouble3[10];
    double d28 = paramArrayOfDouble3[11];
    paramArrayOfDouble1[8] = (d25 * d1 + d26 * d5 + d27 * d9 + d28 * d13);
    paramArrayOfDouble1[9] = (d25 * d2 + d26 * d6 + d27 * d10 + d28 * d14);
    paramArrayOfDouble1[10] = (d25 * d3 + d26 * d7 + d27 * d11 + d28 * d15);
    paramArrayOfDouble1[11] = (d25 * d4 + d26 * d8 + d27 * d12 + d28 * d16);
    double d29 = paramArrayOfDouble3[12];
    double d30 = paramArrayOfDouble3[13];
    double d31 = paramArrayOfDouble3[14];
    double d32 = paramArrayOfDouble3[15];
    paramArrayOfDouble1[12] = (d1 * d29 + d5 * d30 + d31 * d9 + d32 * d13);
    paramArrayOfDouble1[13] = (d2 * d29 + d30 * d6 + d31 * d10 + d32 * d14);
    paramArrayOfDouble1[14] = (d29 * d3 + d30 * d7 + d31 * d11 + d32 * d15);
    paramArrayOfDouble1[15] = (d29 * d4 + d30 * d8 + d31 * d12 + d32 * d16);
  }

  public static void multiplyVectorByMatrix(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    double d1 = paramArrayOfDouble1[0];
    double d2 = paramArrayOfDouble1[1];
    double d3 = paramArrayOfDouble1[2];
    double d4 = paramArrayOfDouble1[3];
    paramArrayOfDouble3[0] = (d1 * paramArrayOfDouble2[0] + d2 * paramArrayOfDouble2[4] + d3 * paramArrayOfDouble2[8] + d4 * paramArrayOfDouble2[12]);
    paramArrayOfDouble3[1] = (d1 * paramArrayOfDouble2[1] + d2 * paramArrayOfDouble2[5] + d3 * paramArrayOfDouble2[9] + d4 * paramArrayOfDouble2[13]);
    paramArrayOfDouble3[2] = (d1 * paramArrayOfDouble2[2] + d2 * paramArrayOfDouble2[6] + d3 * paramArrayOfDouble2[10] + d4 * paramArrayOfDouble2[14]);
    paramArrayOfDouble3[3] = (d1 * paramArrayOfDouble2[3] + d2 * paramArrayOfDouble2[7] + d3 * paramArrayOfDouble2[11] + d4 * paramArrayOfDouble2[15]);
  }

  public static void resetIdentityMatrix(double[] paramArrayOfDouble)
  {
    paramArrayOfDouble[14] = 0.0D;
    paramArrayOfDouble[13] = 0.0D;
    paramArrayOfDouble[12] = 0.0D;
    paramArrayOfDouble[11] = 0.0D;
    paramArrayOfDouble[9] = 0.0D;
    paramArrayOfDouble[8] = 0.0D;
    paramArrayOfDouble[7] = 0.0D;
    paramArrayOfDouble[6] = 0.0D;
    paramArrayOfDouble[4] = 0.0D;
    paramArrayOfDouble[3] = 0.0D;
    paramArrayOfDouble[2] = 0.0D;
    paramArrayOfDouble[1] = 0.0D;
    paramArrayOfDouble[15] = 1.0D;
    paramArrayOfDouble[10] = 1.0D;
    paramArrayOfDouble[5] = 1.0D;
    paramArrayOfDouble[0] = 1.0D;
  }

  public static double roundTo3Places(double paramDouble)
  {
    return 0.001D * Math.round(1000.0D * paramDouble);
  }

  public static double[] transpose(double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = new double[16];
    arrayOfDouble[0] = paramArrayOfDouble[0];
    arrayOfDouble[1] = paramArrayOfDouble[4];
    arrayOfDouble[2] = paramArrayOfDouble[8];
    arrayOfDouble[3] = paramArrayOfDouble[12];
    arrayOfDouble[4] = paramArrayOfDouble[1];
    arrayOfDouble[5] = paramArrayOfDouble[5];
    arrayOfDouble[6] = paramArrayOfDouble[9];
    arrayOfDouble[7] = paramArrayOfDouble[13];
    arrayOfDouble[8] = paramArrayOfDouble[2];
    arrayOfDouble[9] = paramArrayOfDouble[6];
    arrayOfDouble[10] = paramArrayOfDouble[10];
    arrayOfDouble[11] = paramArrayOfDouble[14];
    arrayOfDouble[12] = paramArrayOfDouble[3];
    arrayOfDouble[13] = paramArrayOfDouble[7];
    arrayOfDouble[14] = paramArrayOfDouble[11];
    arrayOfDouble[15] = paramArrayOfDouble[15];
    return arrayOfDouble;
  }

  public static double[] v3Combine(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble1, double paramDouble2)
  {
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = (paramDouble1 * paramArrayOfDouble1[0] + paramDouble2 * paramArrayOfDouble2[0]);
    arrayOfDouble[1] = (paramDouble1 * paramArrayOfDouble1[1] + paramDouble2 * paramArrayOfDouble2[1]);
    arrayOfDouble[2] = (paramDouble1 * paramArrayOfDouble1[2] + paramDouble2 * paramArrayOfDouble2[2]);
    return arrayOfDouble;
  }

  public static double[] v3Cross(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = (paramArrayOfDouble1[1] * paramArrayOfDouble2[2] - paramArrayOfDouble1[2] * paramArrayOfDouble2[1]);
    arrayOfDouble[1] = (paramArrayOfDouble1[2] * paramArrayOfDouble2[0] - paramArrayOfDouble1[0] * paramArrayOfDouble2[2]);
    arrayOfDouble[2] = (paramArrayOfDouble1[0] * paramArrayOfDouble2[1] - paramArrayOfDouble1[1] * paramArrayOfDouble2[0]);
    return arrayOfDouble;
  }

  public static double v3Dot(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return paramArrayOfDouble1[0] * paramArrayOfDouble2[0] + paramArrayOfDouble1[1] * paramArrayOfDouble2[1] + paramArrayOfDouble1[2] * paramArrayOfDouble2[2];
  }

  public static double v3Length(double[] paramArrayOfDouble)
  {
    return Math.sqrt(paramArrayOfDouble[0] * paramArrayOfDouble[0] + paramArrayOfDouble[1] * paramArrayOfDouble[1] + paramArrayOfDouble[2] * paramArrayOfDouble[2]);
  }

  public static double[] v3Normalize(double[] paramArrayOfDouble, double paramDouble)
  {
    if (isZero(paramDouble))
      paramDouble = v3Length(paramArrayOfDouble);
    double d = 1.0D / paramDouble;
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = (d * paramArrayOfDouble[0]);
    arrayOfDouble[1] = (d * paramArrayOfDouble[1]);
    arrayOfDouble[2] = (d * paramArrayOfDouble[2]);
    return arrayOfDouble;
  }

  public static class MatrixDecompositionContext
  {
    double[] perspective = new double[4];
    double[] rotationDegrees = new double[3];
    double[] scale = new double[3];
    double[] skew = new double[3];
    double[] translation = new double[3];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.MatrixMathHelper
 * JD-Core Version:    0.6.2
 */