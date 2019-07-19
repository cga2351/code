package com.viber.common.dialogs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class DefaultDialogCodeProvider
  implements DialogCodeProvider
{
  public static final Parcelable.Creator<DefaultDialogCodeProvider> CREATOR = new Parcelable.Creator()
  {
    public DefaultDialogCodeProvider a(Parcel paramAnonymousParcel)
    {
      return new DefaultDialogCodeProvider();
    }

    public DefaultDialogCodeProvider[] a(int paramAnonymousInt)
    {
      return new DefaultDialogCodeProvider[paramAnonymousInt];
    }
  };

  public String code()
  {
    return "unknown";
  }

  public int describeContents()
  {
    return 0;
  }

  public String managerTag()
  {
    return "com.viber.common.dialogs#manager_tag." + code();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.DefaultDialogCodeProvider
 * JD-Core Version:    0.6.2
 */