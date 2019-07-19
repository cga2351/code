package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class PublicAccountAttributes
{
  public String authenticationToken;
  public String categoryId;
  public String crmName;
  public String email;
  public int isSubscribed;
  public JokerButton[] jokerButtons;
  public String subCategoryId;
  public int webHookExists;
  public String website;

  public PublicAccountAttributes()
  {
  }

  PublicAccountAttributes(Bundle paramBundle)
  {
    this.categoryId = paramBundle.getString("categoryId");
    this.subCategoryId = paramBundle.getString("subCategoryId");
    this.webHookExists = paramBundle.getInt("webHookExists");
    this.crmName = paramBundle.getString("crmName");
    this.website = paramBundle.getString("website");
    this.email = paramBundle.getString("email");
    this.authenticationToken = paramBundle.getString("authenticationToken");
    this.isSubscribed = paramBundle.getInt("isSubscribed");
    int i = paramBundle.getInt("JokerButtonsSize");
    this.jokerButtons = new JokerButton[i];
    for (int j = 0; j < i; j++)
    {
      Bundle localBundle = paramBundle.getBundle("JokerButton" + j);
      this.jokerButtons[j] = new JokerButton(localBundle);
    }
  }

  public String getAuthenticationToken()
  {
    return this.authenticationToken;
  }

  public String getCategoryId()
  {
    return this.categoryId;
  }

  public String getCrmName()
  {
    return this.crmName;
  }

  public String getEmail()
  {
    return this.email;
  }

  public int getIsSubscribed()
  {
    return this.isSubscribed;
  }

  public JokerButton[] getJokerButtons()
  {
    return this.jokerButtons;
  }

  public String getSubCategoryId()
  {
    return this.subCategoryId;
  }

  public int getWebHookExists()
  {
    return this.webHookExists;
  }

  public String getWebsite()
  {
    return this.website;
  }

  public boolean hasSubscription()
  {
    return this.isSubscribed == 1;
  }

  public String toString()
  {
    return "PublicAccountAttributes{categoryId='" + this.categoryId + '\'' + ", subCategoryId='" + this.subCategoryId + '\'' + ", webHookExists=" + this.webHookExists + ", crmName='" + this.crmName + '\'' + ", website='" + this.website + '\'' + ", email='" + this.email + '\'' + ", authenticationToken='" + this.authenticationToken + '\'' + ", isSubscribed=" + this.isSubscribed + ", jokerButtons=" + Arrays.toString(this.jokerButtons) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicAccountAttributes
 * JD-Core Version:    0.6.2
 */