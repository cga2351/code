package com.viber.voip.messages.orm.entity.json.gdpr;

import com.google.d.a.a;
import com.google.d.a.c;
import java.util.List;

public class VendorList
{

  @a
  @c(a="features")
  private List<Feature> features = null;

  @a
  @c(a="lastUpdated")
  private String lastUpdated;

  @a
  @c(a="purposes")
  private List<Purpose> purposes = null;

  @a
  @c(a="vendorListVersion")
  private Integer vendorListVersion;

  @a
  @c(a="vendors")
  private List<Vendor> vendors = null;

  public List<Feature> getFeatures()
  {
    return this.features;
  }

  public String getLastUpdated()
  {
    return this.lastUpdated;
  }

  public List<Purpose> getPurposes()
  {
    return this.purposes;
  }

  public Integer getVendorListVersion()
  {
    return this.vendorListVersion;
  }

  public List<Vendor> getVendors()
  {
    return this.vendors;
  }

  public void setFeatures(List<Feature> paramList)
  {
    this.features = paramList;
  }

  public void setLastUpdated(String paramString)
  {
    this.lastUpdated = paramString;
  }

  public void setPurposes(List<Purpose> paramList)
  {
    this.purposes = paramList;
  }

  public void setVendorListVersion(Integer paramInteger)
  {
    this.vendorListVersion = paramInteger;
  }

  public void setVendors(List<Vendor> paramList)
  {
    this.vendors = paramList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.gdpr.VendorList
 * JD-Core Version:    0.6.2
 */