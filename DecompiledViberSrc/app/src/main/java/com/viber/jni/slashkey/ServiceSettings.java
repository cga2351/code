package com.viber.jni.slashkey;

import java.util.Arrays;

public class ServiceSettings
{
  private String authAccessToken;
  private String authCookieName;
  private String authFinishedRedirectLink;
  private String authLink;
  private String authRedirectLink;
  private boolean authRequired;
  private String[] categories;
  private String defaultCategory;
  private boolean locationRequired;
  private String serviceName;

  public String getAuthAccessToken()
  {
    return this.authAccessToken;
  }

  public String getAuthCookieName()
  {
    return this.authCookieName;
  }

  public String getAuthFinishedRedirectLink()
  {
    return this.authFinishedRedirectLink;
  }

  public String getAuthLink()
  {
    return this.authLink;
  }

  public String getAuthRedirectLink()
  {
    return this.authRedirectLink;
  }

  public String[] getCategories()
  {
    return this.categories;
  }

  public String getDefaultCategory()
  {
    return this.defaultCategory;
  }

  public String getServiceName()
  {
    return this.serviceName;
  }

  public boolean isAuthRequired()
  {
    return this.authRequired;
  }

  public boolean isLocationRequired()
  {
    return this.locationRequired;
  }

  public void setAuthAccessToken(String paramString)
  {
    this.authAccessToken = paramString;
  }

  public void setAuthRedirectLink(String paramString)
  {
    this.authRedirectLink = paramString;
  }

  public String toString()
  {
    return "ServiceSettings{serviceName='" + this.serviceName + '\'' + ", authRequired=" + this.authRequired + ", locationRequired=" + this.locationRequired + ", authLink='" + this.authLink + '\'' + ", authFinishedRedirectLink='" + this.authFinishedRedirectLink + '\'' + ", authCookieName='" + this.authCookieName + '\'' + ", authRedirectLink='" + this.authRedirectLink + '\'' + ", authAccessToken='" + this.authAccessToken + '\'' + ", categories=" + Arrays.toString(this.categories) + ", defaultCategory='" + this.defaultCategory + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.ServiceSettings
 * JD-Core Version:    0.6.2
 */