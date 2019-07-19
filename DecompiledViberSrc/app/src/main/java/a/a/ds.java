package a.a;

public final class ds
{
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = Math.toRadians(paramDouble3 - paramDouble1);
    double d2 = Math.toRadians(paramDouble4 - paramDouble2);
    double d3 = Math.toRadians(paramDouble1);
    double d4 = Math.toRadians(paramDouble3);
    return 6371000.0D * (2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(d1 / 2.0D), 2.0D) + Math.pow(Math.sin(d2 / 2.0D), 2.0D) * Math.cos(d3) * Math.cos(d4))));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ds
 * JD-Core Version:    0.6.2
 */