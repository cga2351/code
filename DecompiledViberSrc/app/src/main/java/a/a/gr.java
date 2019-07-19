package a.a;

public enum gr
{
  private final String d;

  static
  {
    gr[] arrayOfgr = new gr[3];
    arrayOfgr[0] = a;
    arrayOfgr[1] = b;
    arrayOfgr[2] = c;
  }

  private gr(String paramString)
  {
    this.d = paramString;
  }

  public String a()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gr
 * JD-Core Version:    0.6.2
 */