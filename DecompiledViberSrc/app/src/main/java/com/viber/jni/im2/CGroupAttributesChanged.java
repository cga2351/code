package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGroupAttributesChanged
{
  public final String backgroundDownloadID;
  public final String country;
  public final int flags;
  public final String groupName;
  public final int groupType;
  public final String groupUri;
  public final String iconDownloadID;
  public final Location location;
  public final int revision;
  public final String tagLine;
  public final String[] tags;

  public CGroupAttributesChanged(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, Location paramLocation, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.groupUri = Im2Utils.checkStringValue(paramString2);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString3);
    this.backgroundDownloadID = Im2Utils.checkStringValue(paramString4);
    this.tagLine = Im2Utils.checkStringValue(paramString5);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString6);
    this.groupType = paramInt1;
    this.revision = paramInt2;
    this.flags = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGroupAttributesChanged{groupName='" + this.groupName + '\'' + ", groupUri='" + this.groupUri + '\'' + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", backgroundDownloadID='" + this.backgroundDownloadID + '\'' + ", tagLine='" + this.tagLine + '\'' + ", tags=" + Arrays.toString(this.tags) + ", location=" + this.location + ", country='" + this.country + '\'' + ", groupType=" + this.groupType + ", revision=" + this.revision + ", flags=" + this.flags + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EChangedFlags
  {
    public static final int AUTH_TOKEN_CHANGED = 32768;
    public static final int BACKGROUND_ID_CHANGED = 4;
    public static final int CATEGORY_CHANGED = 512;
    public static final int COUNTRY_CHANGED = 64;
    public static final int CRM_NAME_CHANGED = 2048;
    public static final int EMAIL_CHANGED = 8192;
    public static final int FLAGS_CHANGED = 128;
    public static final int GROUP_NAME_CHANGED = 1;
    public static final int ICON_ID_CHANGED = 2;
    public static final int JOKER_BUTTON_CHANGED = 16384;
    public static final int LOCATION_CHANGED = 32;
    public static final int TAGLINE_CHANGED = 8;
    public static final int TAGS_CHANGED = 16;
    public static final int URI_CHANGED = 256;
    public static final int WEBHOOK_EXIST_CHANGED = 1024;
    public static final int WEBSITE_CHANGED = 4096;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAttributesChanged
 * JD-Core Version:    0.6.2
 */