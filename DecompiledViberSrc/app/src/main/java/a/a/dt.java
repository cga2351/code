package a.a;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class dt
{
  private static final BigDecimal a = new BigDecimal("100");

  public static BigDecimal a(BigDecimal paramBigDecimal)
  {
    return paramBigDecimal.setScale(2, RoundingMode.HALF_UP);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dt
 * JD-Core Version:    0.6.2
 */