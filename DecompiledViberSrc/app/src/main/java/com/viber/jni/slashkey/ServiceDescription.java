package com.viber.jni.slashkey;

import java.util.Arrays;

public class ServiceDescription
{
  private String[] aliases;
  private int authType;
  private String description;
  private String displayName;
  private boolean hidden;
  private String id;
  private String searchName;

  public String[] getAliases()
  {
    return this.aliases;
  }

  public int getAuthType()
  {
    return this.authType;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getId()
  {
    return this.id;
  }

  public String getSearchName()
  {
    return this.searchName;
  }

  public boolean isHidden()
  {
    return this.hidden;
  }

  public String toString()
  {
    return "ServiceDescription{displayName='" + this.displayName + '\'' + ", searchName='" + this.searchName + '\'' + ", id='" + this.id + '\'' + ", aliases='" + Arrays.toString(this.aliases) + '\'' + ", description='" + this.description + '\'' + ", authType=" + this.authType + ", hidden=" + this.hidden + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.ServiceDescription
 * JD-Core Version:    0.6.2
 */