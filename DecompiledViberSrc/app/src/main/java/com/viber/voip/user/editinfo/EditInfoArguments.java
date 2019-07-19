package com.viber.voip.user.editinfo;

import android.os.Bundle;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class EditInfoArguments
{
  private int mAction = 0;
  private int mCdrEntryPoint;
  private int mDetailsMode = 0;
  private String mMixpanelEntryPoint;

  public static EditInfoArguments extract(Bundle paramBundle1, Bundle paramBundle2)
  {
    EditInfoArguments localEditInfoArguments = new EditInfoArguments();
    int i;
    String str;
    if (paramBundle1 != null)
    {
      i = paramBundle1.getInt("details_mode_extra_key", 0);
      localEditInfoArguments.mDetailsMode = i;
      int j = 0;
      if (paramBundle1 != null)
        j = paramBundle1.getInt("action_extra_key", 0);
      localEditInfoArguments.mAction = j;
      if (paramBundle2 != null)
        break label80;
      str = null;
      label54: localEditInfoArguments.mMixpanelEntryPoint = str;
      if (paramBundle2 != null)
        break label91;
    }
    label80: label91: for (int k = 1; ; k = paramBundle2.getInt("extra_cdr_entry_point", 1))
    {
      localEditInfoArguments.mCdrEntryPoint = k;
      return localEditInfoArguments;
      i = 0;
      break;
      str = paramBundle2.getString("extra_entry_point");
      break label54;
    }
  }

  public int getAction()
  {
    return this.mAction;
  }

  public int getCdrEntryPoint()
  {
    return this.mCdrEntryPoint;
  }

  public int getDetailsMode()
  {
    return this.mDetailsMode;
  }

  public String getMixpanelEntryPoint()
  {
    return this.mMixpanelEntryPoint;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Action
  {
    public static final int ADD_PHOTO = 1;
    public static final int DEFAULT = 0;
    public static final int SHOW_AS_DIALOG = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface DetailsMode
  {
    public static final int DEFAULT = 0;
    public static final int REGISTRATION = 1;
  }

  static abstract interface Extras
  {
    public static final String ACTION = "action_extra_key";
    public static final String DETAILS_MODE = "details_mode_extra_key";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoArguments
 * JD-Core Version:    0.6.2
 */