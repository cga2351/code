package com.viber.jni.im2;

public class CGroupAttributes
{
  public final Long backgroundID;
  public final String country;
  public final String filler;
  public final String groupName;
  public final Integer groupType;
  public final String groupUri;
  public final Long iconID;
  public final Location location;
  public final Integer pgAndSearchFlags;
  public final Integer pgAndSearchFlagsToSet;
  public final String tagLine;
  public final String[] tags;

  public CGroupAttributes(String paramString)
  {
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.filler = null;
    this.groupUri = null;
    this.iconID = null;
    this.backgroundID = null;
    this.tagLine = null;
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = null;
    this.iconID = null;
    this.backgroundID = null;
    this.tagLine = null;
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = null;
    this.backgroundID = null;
    this.tagLine = null;
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong);
    this.backgroundID = null;
    this.tagLine = null;
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = null;
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = null;
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = null;
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, Location paramLocation)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = null;
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, Location paramLocation, String paramString5)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString5);
    this.groupType = null;
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, Location paramLocation, String paramString5, int paramInt)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString5);
    this.groupType = Integer.valueOf(paramInt);
    this.pgAndSearchFlags = null;
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, Location paramLocation, String paramString5, int paramInt1, int paramInt2)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString5);
    this.groupType = Integer.valueOf(paramInt1);
    this.pgAndSearchFlags = Integer.valueOf(paramInt2);
    this.pgAndSearchFlagsToSet = null;
    init();
  }

  public CGroupAttributes(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, Location paramLocation, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.filler = Im2Utils.checkStringValue(paramString2);
    this.groupUri = Im2Utils.checkStringValue(paramString3);
    this.iconID = Long.valueOf(paramLong1);
    this.backgroundID = Long.valueOf(paramLong2);
    this.tagLine = Im2Utils.checkStringValue(paramString4);
    this.tags = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.location = ((Location)Im2Utils.checkStructValue(paramLocation));
    this.country = Im2Utils.checkStringValue(paramString5);
    this.groupType = Integer.valueOf(paramInt1);
    this.pgAndSearchFlags = Integer.valueOf(paramInt2);
    this.pgAndSearchFlagsToSet = Integer.valueOf(paramInt3);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAttributes
 * JD-Core Version:    0.6.2
 */