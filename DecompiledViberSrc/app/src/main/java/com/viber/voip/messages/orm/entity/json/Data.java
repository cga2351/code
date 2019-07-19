package com.viber.voip.messages.orm.entity.json;

import com.google.d.a.c;
import java.util.List;

public class Data
{

  @c(a="translations")
  private List<Translation> translations;

  public List<Translation> getTranslations()
  {
    return this.translations;
  }

  public void setTranslations(List<Translation> paramList)
  {
    this.translations = paramList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.Data
 * JD-Core Version:    0.6.2
 */