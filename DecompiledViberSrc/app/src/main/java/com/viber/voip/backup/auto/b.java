package com.viber.voip.backup.auto;

import com.viber.common.b.e;
import com.viber.voip.backup.a;
import java.util.concurrent.TimeUnit;

public class b
{
  public static final long a = TimeUnit.HOURS.toMillis(4L);
  private final e b;

  public b(e parame)
  {
    this.b = parame;
  }

  public void a()
  {
    this.b.e();
  }

  public void a(long paramLong)
  {
    this.b.a(paramLong);
  }

  public boolean a(a parama, long paramLong)
  {
    return (parama.b()) && (this.b.d() < paramLong - 1000L * parama.a());
  }

  public boolean b(long paramLong)
  {
    long l = this.b.d();
    return (l != 0L) && (paramLong - l < a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.auto.b
 * JD-Core Version:    0.6.2
 */