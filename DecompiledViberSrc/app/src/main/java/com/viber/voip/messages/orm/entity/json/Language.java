package com.viber.voip.messages.orm.entity.json;

import com.google.d.a.a;
import com.google.d.a.c;

public class Language
{

  @a
  @c(a="code")
  private String code;

  @a
  @c(a="id")
  private Integer id;

  @a
  @c(a="language")
  private String language;

  @a
  @c(a="visibleName")
  private String visibleName;

  public Language(Integer paramInteger, String paramString1, String paramString2, String paramString3)
  {
    this.id = paramInteger;
    this.language = paramString1;
    this.visibleName = paramString2;
    this.code = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    Language localLanguage = (Language)paramObject;
    return this.code.equals(localLanguage.code);
  }

  public String getCode()
  {
    return this.code;
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getLanguage()
  {
    return this.language;
  }

  public String getVisibleName()
  {
    return this.visibleName;
  }

  public int hashCode()
  {
    return this.code.hashCode();
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }

  public void setVisibleName(String paramString)
  {
    this.visibleName = paramString;
  }

  public String toString()
  {
    return this.code;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.Language
 * JD-Core Version:    0.6.2
 */