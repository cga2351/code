package com.viber.voip.messages.a;

public class g
{
  public static class a
  {
    public final String a;

    public a(String paramString)
    {
      this.a = paramString;
    }

    public String toString()
    {
      return "LanguageChangedEvent{languageCode='" + this.a + '\'' + '}';
    }
  }

  public static class b
  {
    public final String a;
    public boolean b;

    public b(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }

    public String toString()
    {
      return "LanguageSelectedInSettingsEvent{languageCode='" + this.a + '\'' + ", fromUrlScheme=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.g
 * JD-Core Version:    0.6.2
 */