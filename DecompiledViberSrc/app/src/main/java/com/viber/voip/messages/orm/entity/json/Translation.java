package com.viber.voip.messages.orm.entity.json;

import com.google.d.a.a;
import com.google.d.a.c;

public class Translation
{

  @a
  @c(a="detectedSourceLanguage")
  private String detectedSourceLanguage;

  @a
  @c(a="translatedText")
  private String translatedText;

  public String getDetectedSourceLanguage()
  {
    return this.detectedSourceLanguage;
  }

  public String getTranslatedText()
  {
    return this.translatedText;
  }

  public void setDetectedSourceLanguage(String paramString)
  {
    this.detectedSourceLanguage = paramString;
  }

  public void setTranslatedText(String paramString)
  {
    this.translatedText = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.Translation
 * JD-Core Version:    0.6.2
 */