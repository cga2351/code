package d.d.b;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public abstract class i<R>
  implements f<R>, Serializable
{
  private final int a;

  public i(int paramInt)
  {
    this.a = paramInt;
  }

  @NotNull
  public String toString()
  {
    String str = m.a(this);
    h.a(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.i
 * JD-Core Version:    0.6.2
 */