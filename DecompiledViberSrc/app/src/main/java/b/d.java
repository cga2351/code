package b;

import java.util.Locale;

public class d
{
  private final f a;

  public boolean a()
  {
    return this.a.a();
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = getClass().getName();
    arrayOfObject[1] = Integer.toHexString(hashCode());
    arrayOfObject[2] = Boolean.toString(this.a.a());
    return String.format(localLocale, "%s@%s[cancellationRequested=%s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.d
 * JD-Core Version:    0.6.2
 */