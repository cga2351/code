package android.support.design.widget;

public final class MathUtils
{
  public static final float DEFAULT_EPSILON = 1.0E-004F;

  public static float dist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    return (float)Math.hypot(f1, f2);
  }

  public static float distanceToFurthestCorner(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return max(dist(paramFloat1, paramFloat2, paramFloat3, paramFloat4), dist(paramFloat1, paramFloat2, paramFloat5, paramFloat4), dist(paramFloat1, paramFloat2, paramFloat5, paramFloat6), dist(paramFloat1, paramFloat2, paramFloat3, paramFloat6));
  }

  public static boolean geq(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 >= paramFloat2;
  }

  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * (1.0F - paramFloat3) + paramFloat3 * paramFloat2;
  }

  private static float max(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 > paramFloat2) && (paramFloat1 > paramFloat3) && (paramFloat1 > paramFloat4))
      return paramFloat1;
    if ((paramFloat2 > paramFloat3) && (paramFloat2 > paramFloat4))
      return paramFloat2;
    if (paramFloat3 > paramFloat4)
      return paramFloat3;
    return paramFloat4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.MathUtils
 * JD-Core Version:    0.6.2
 */