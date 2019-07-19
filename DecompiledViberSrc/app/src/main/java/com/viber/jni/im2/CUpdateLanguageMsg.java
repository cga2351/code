package com.viber.jni.im2;

public class CUpdateLanguageMsg
{
  public final String osLanguage;
  public final String viberLanguage;

  public CUpdateLanguageMsg(String paramString)
  {
    this.osLanguage = Im2Utils.checkStringValue(paramString);
    this.viberLanguage = null;
    init();
  }

  public CUpdateLanguageMsg(String paramString1, String paramString2)
  {
    this.osLanguage = Im2Utils.checkStringValue(paramString1);
    this.viberLanguage = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CUpdateLanguageMsg{osLanguage='" + this.osLanguage + '\'' + ", viberLanguage='" + this.viberLanguage + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateLanguageMsg(CUpdateLanguageMsg paramCUpdateLanguageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateLanguageMsg
 * JD-Core Version:    0.6.2
 */