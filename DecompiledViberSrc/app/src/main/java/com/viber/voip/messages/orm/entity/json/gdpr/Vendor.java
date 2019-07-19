package com.viber.voip.messages.orm.entity.json.gdpr;

import com.google.d.a.a;
import com.google.d.a.c;
import java.util.List;

public class Vendor
{

  @a
  @c(a="featureIds")
  private List<Integer> featureIds = null;

  @a
  @c(a="id")
  private Integer id;

  @a
  @c(a="legIntPurposeIds")
  private List<Integer> legIntPurposeIds = null;

  @a
  @c(a="name")
  private String name;

  @a
  @c(a="policyUrl")
  private String policyUrl;

  @a
  @c(a="purposeIds")
  private List<Integer> purposeIds = null;

  public List<Integer> getFeatureIds()
  {
    return this.featureIds;
  }

  public Integer getId()
  {
    return this.id;
  }

  public List<Integer> getLegIntPurposeIds()
  {
    return this.legIntPurposeIds;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPolicyUrl()
  {
    return this.policyUrl;
  }

  public List<Integer> getPurposeIds()
  {
    return this.purposeIds;
  }

  public void setFeatureIds(List<Integer> paramList)
  {
    this.featureIds = paramList;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public void setLegIntPurposeIds(List<Integer> paramList)
  {
    this.legIntPurposeIds = paramList;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setPolicyUrl(String paramString)
  {
    this.policyUrl = paramString;
  }

  public void setPurposeIds(List<Integer> paramList)
  {
    this.purposeIds = paramList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.gdpr.Vendor
 * JD-Core Version:    0.6.2
 */