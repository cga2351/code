package com.viber.common.dialogs;

import android.os.Parcelable;

public abstract interface DialogCodeProvider extends Parcelable
{
  public static final DialogCodeProvider UNKNOWN = new DefaultDialogCodeProvider();

  public abstract String code();

  public abstract String managerTag();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.DialogCodeProvider
 * JD-Core Version:    0.6.2
 */