package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class CGroupAttributesChanged
{
  private String backgroundDownloadID;
  private String country;
  private int flags;
  private String groupName;
  private int groupType;
  private String groupUri;
  private String iconDownloadID;
  private LocationInfo location;
  private int revision;
  private String tagLine;
  private String[] tags;

  CGroupAttributesChanged(Bundle paramBundle)
  {
    this.groupName = paramBundle.getString("GroupName");
    this.groupUri = paramBundle.getString("GroupUri");
    this.iconDownloadID = paramBundle.getString("IconDownloadID");
    this.backgroundDownloadID = paramBundle.getString("BackgroundDownloadID");
    this.tagLine = paramBundle.getString("TagLine");
    this.tags = paramBundle.getStringArray("Tags");
    this.location = new LocationInfo(paramBundle.getInt("LocationLat"), paramBundle.getInt("LocationLong"));
    this.country = paramBundle.getString("Country");
    this.groupType = paramBundle.getInt("GroupType");
    this.revision = paramBundle.getInt("Revision");
    this.flags = paramBundle.getInt("Flags");
  }

  CGroupAttributesChanged(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.groupName = paramString1;
    this.groupUri = paramString2;
    this.iconDownloadID = paramString3;
    this.backgroundDownloadID = paramString4;
    this.tagLine = paramString5;
    this.tags = paramArrayOfString;
    this.location = paramLocationInfo;
    this.country = paramString6;
    this.groupType = paramInt1;
    this.revision = paramInt2;
    this.flags = paramInt3;
  }

  public String getBackgroundDownloadID()
  {
    return this.backgroundDownloadID;
  }

  public String getCountry()
  {
    return this.country;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public String getGroupName()
  {
    return this.groupName;
  }

  public int getGroupType()
  {
    return this.groupType;
  }

  public String getGroupUri()
  {
    return this.groupUri;
  }

  public String getIconDownloadID()
  {
    return this.iconDownloadID;
  }

  public LocationInfo getLocation()
  {
    return this.location;
  }

  public int getRevision()
  {
    return this.revision;
  }

  public String getTagLine()
  {
    return this.tagLine;
  }

  public String[] getTags()
  {
    return this.tags;
  }

  public void setBackgroundDownloadID(String paramString)
  {
    this.backgroundDownloadID = paramString;
  }

  public void setCountry(String paramString)
  {
    this.country = paramString;
  }

  public void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }

  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }

  public void setGroupType(int paramInt)
  {
    this.groupType = paramInt;
  }

  public void setGroupUri(String paramString)
  {
    this.groupUri = paramString;
  }

  public void setIconDownloadID(String paramString)
  {
    this.iconDownloadID = paramString;
  }

  public void setLocation(LocationInfo paramLocationInfo)
  {
    this.location = paramLocationInfo;
  }

  public void setRevision(int paramInt)
  {
    this.revision = paramInt;
  }

  public void setTagLine(String paramString)
  {
    this.tagLine = paramString;
  }

  public void setTags(String[] paramArrayOfString)
  {
    this.tags = paramArrayOfString;
  }

  public String toString()
  {
    return "CGroupAttributesChanged [groupName=" + this.groupName + ", groupUri=" + this.groupUri + ", iconDownloadID=" + this.iconDownloadID + ", backgroundDownloadID=" + this.backgroundDownloadID + ", tagLine=" + this.tagLine + ", tags=" + Arrays.toString(this.tags) + ", location=" + this.location + ", country=" + this.country + ", groupType=" + this.groupType + ", revision=" + this.revision + ", flags=" + this.flags + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CGroupAttributesChanged
 * JD-Core Version:    0.6.2
 */