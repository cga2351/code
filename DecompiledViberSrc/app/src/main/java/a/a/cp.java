package a.a;

import com.appboy.f.c;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class cp
{
  private static final String a = c.a(cp.class);
  private final Random b = new Random();
  private final int c;
  private final int d;
  private int e = 0;

  public cp(int paramInt)
  {
    this(paramInt, (int)TimeUnit.SECONDS.toMillis(1L));
  }

  public cp(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }

  static int a(Random paramRandom, int paramInt1, int paramInt2)
  {
    return paramRandom.nextInt(Math.abs(paramInt1 - paramInt2)) + Math.min(paramInt1, paramInt2);
  }

  public int a(int paramInt)
  {
    c.b(a, "Computing new sleep delay. Previous sleep delay: " + this.e);
    int i = a(this.b, paramInt, 3 * this.e);
    this.e = Math.min(this.c, i);
    c.b(a, "New sleep duration: " + this.e + " ms. Default sleep duration: " + paramInt + " ms. Max sleep: " + this.c + " ms.");
    return this.e;
  }

  public void a()
  {
    this.e = 0;
  }

  public boolean b()
  {
    return this.e != 0;
  }

  public int c()
  {
    return a(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cp
 * JD-Core Version:    0.6.2
 */