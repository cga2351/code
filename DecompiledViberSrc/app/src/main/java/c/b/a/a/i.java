package c.b.a.a;

public class i extends Exception
{
  private a a;
  private String b;

  public i(a parama, String paramString)
  {
    super(paramString);
    this.b = paramString;
    this.a = parama;
  }

  public a a()
  {
    return this.a;
  }

  public String toString()
  {
    return "Error type: " + this.a + ". " + this.b;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.i
 * JD-Core Version:    0.6.2
 */