package com.viber.voip.messages.orm.entity.json;

public enum ImageType
{
  private final String mValue;

  static
  {
    GROUP_ICON = new ImageType("GROUP_ICON", 1, "groupIcon");
    GROUP_PHOTO = new ImageType("GROUP_PHOTO", 2, "groupPhoto");
    PROFILE_ICON = new ImageType("PROFILE_ICON", 3, "profileIcon");
    ImageType[] arrayOfImageType = new ImageType[4];
    arrayOfImageType[0] = REGULAR;
    arrayOfImageType[1] = GROUP_ICON;
    arrayOfImageType[2] = GROUP_PHOTO;
    arrayOfImageType[3] = PROFILE_ICON;
  }

  private ImageType(String paramString)
  {
    this.mValue = paramString;
  }

  public static ImageType toEnum(String paramString)
  {
    for (ImageType localImageType : values())
      if (localImageType.mValue.equalsIgnoreCase(paramString))
        return localImageType;
    return REGULAR;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.ImageType
 * JD-Core Version:    0.6.2
 */