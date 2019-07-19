package com.viber.voip.messages.orm.entity.json;

import com.google.d.a.a;
import com.google.d.a.c;
import java.util.List;

public class Languages
{

  @a
  @c(a="language")
  private List<Language> language = null;

  public List<Language> getLanguage()
  {
    return this.language;
  }

  public void setLanguage(List<Language> paramList)
  {
    this.language = paramList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.Languages
 * JD-Core Version:    0.6.2
 */