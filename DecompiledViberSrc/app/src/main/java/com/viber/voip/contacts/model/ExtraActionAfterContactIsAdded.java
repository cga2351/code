package com.viber.voip.contacts.model;

import android.app.Activity;
import android.os.Parcelable;

public abstract interface ExtraActionAfterContactIsAdded extends Parcelable
{
  public abstract void onContactAdded(Activity paramActivity);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.model.ExtraActionAfterContactIsAdded
 * JD-Core Version:    0.6.2
 */