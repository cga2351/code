package android.support.v7.app;

class j
{
  private static j d;
  public long a;
  public long b;
  public int c;

  static j a()
  {
    if (d == null)
      d = new j();
    return d;
  }

  public void a(long paramLong, double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(paramLong - 946728000000L) / 86400000.0F;
    float f2 = 6.24006F + 0.01720197F * f1;
    double d1 = 3.141592653589793D + (1.796593063D + (f2 + 0.03341960161924362D * Math.sin(f2) + 0.0003490659873933D * Math.sin(2.0F * f2) + 5.236000106378924E-006D * Math.sin(3.0F * f2)));
    double d2 = -paramDouble2 / 360.0D;
    double d3 = d2 + (0.0009F + (float)Math.round(f1 - 0.0009F - d2)) + 0.0053D * Math.sin(f2) + -0.0069D * Math.sin(2.0D * d1);
    double d4 = Math.asin(Math.sin(d1) * Math.sin(0.4092797040939331D));
    double d5 = 0.0174532923847437D * paramDouble1;
    double d6 = (Math.sin(-0.1047197580337524D) - Math.sin(d5) * Math.sin(d4)) / (Math.cos(d5) * Math.cos(d4));
    if (d6 >= 1.0D)
    {
      this.c = 1;
      this.a = -1L;
      this.b = -1L;
      return;
    }
    if (d6 <= -1.0D)
    {
      this.c = 0;
      this.a = -1L;
      this.b = -1L;
      return;
    }
    float f3 = (float)(Math.acos(d6) / 6.283185307179586D);
    this.a = (946728000000L + Math.round(86400000.0D * (d3 + f3)));
    this.b = (946728000000L + Math.round(86400000.0D * (d3 - f3)));
    if ((this.b < paramLong) && (this.a > paramLong))
    {
      this.c = 0;
      return;
    }
    this.c = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.6.2
 */