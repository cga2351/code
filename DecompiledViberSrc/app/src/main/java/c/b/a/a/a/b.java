package c.b.a.a.a;

import c.b.a.a.k.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  implements a
{
  private final c a = new c(100);

  public static a a()
  {
    return new b();
  }

  private static boolean a(CharSequence paramCharSequence, Pattern paramPattern, boolean paramBoolean)
  {
    Matcher localMatcher = paramPattern.matcher(paramCharSequence);
    if (!localMatcher.lookingAt())
      paramBoolean = false;
    while (!localMatcher.matches())
      return paramBoolean;
    return true;
  }

  public boolean a(CharSequence paramCharSequence, k.d paramd, boolean paramBoolean)
  {
    String str = paramd.a();
    if (str.length() == 0)
      return false;
    return a(paramCharSequence, this.a.a(str), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.a.b
 * JD-Core Version:    0.6.2
 */