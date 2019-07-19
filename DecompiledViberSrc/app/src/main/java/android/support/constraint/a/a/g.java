package android.support.constraint.a.a;

import java.util.Arrays;

public class g extends d
{
  protected d[] ab = new d[4];
  protected int ac = 0;

  public void K()
  {
    this.ac = 0;
  }

  public void c(d paramd)
  {
    if (1 + this.ac > this.ab.length)
      this.ab = ((d[])Arrays.copyOf(this.ab, 2 * this.ab.length));
    this.ab[this.ac] = paramd;
    this.ac = (1 + this.ac);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.g
 * JD-Core Version:    0.6.2
 */