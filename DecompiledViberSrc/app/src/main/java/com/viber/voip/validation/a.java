package com.viber.voip.validation;

public class a
  implements h
{
  public final a a;
  public final CharSequence b;
  public final int c;

  public a(a parama)
  {
    this(parama, null, 0);
  }

  public a(a parama, int paramInt)
  {
    this(parama, null, paramInt);
  }

  public a(a parama, CharSequence paramCharSequence)
  {
    this(parama, paramCharSequence, 0);
  }

  private a(a parama, CharSequence paramCharSequence, int paramInt)
  {
    this.a = parama;
    this.b = paramCharSequence;
    this.c = paramInt;
  }

  public boolean a()
  {
    return this.a == a.c;
  }

  public String toString()
  {
    return "CommonValidationResult{state=" + this.a + ", message='" + this.b + '\'' + ", messageResId=" + this.c + '}';
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.a
 * JD-Core Version:    0.6.2
 */