package com.viber.voip.messages.orm.entity.json.gdpr;

import com.google.d.a.a;
import com.google.d.a.c;

public class Purpose
{

  @a
  @c(a="description")
  private String description;

  @a
  @c(a="id")
  private Integer id;

  @a
  @c(a="name")
  private String name;

  public String getDescription()
  {
    return this.description;
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.gdpr.Purpose
 * JD-Core Version:    0.6.2
 */