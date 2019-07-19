package com.viber.voip.backup.d.a.a;

public class a extends b
{
  private a(String paramString)
  {
    super(paramString);
  }

  public static class a
  {
    private StringBuilder a = new StringBuilder();

    private void b()
    {
      if (this.a.length() > 0)
        this.a.append(", ");
    }

    public a a(String paramString)
    {
      b();
      this.a.append(paramString).append(" DESC");
      return this;
    }

    public a a()
    {
      return new a(this.a.toString(), null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a.a.a
 * JD-Core Version:    0.6.2
 */