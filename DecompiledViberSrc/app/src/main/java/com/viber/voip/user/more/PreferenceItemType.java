package com.viber.voip.user.more;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PreferenceItemType
{
  public static final int DEFAULT_ITEM_TYPE = 0;
  public static final int DIVIDER_ITEM_TYPE = 1;
  public static final int PROFILE_BANNER_ITEM_TYPE = 2;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.PreferenceItemType
 * JD-Core Version:    0.6.2
 */