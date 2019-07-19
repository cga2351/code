package com.viber.voip.phone.viber.conference.ui.controls;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.av;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ControlState
  implements Parcelable
{
  public static final Parcelable.Creator<ControlState> CREATOR = new Parcelable.Creator()
  {
    public ControlState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ControlState(paramAnonymousParcel);
    }

    public ControlState[] newArray(int paramAnonymousInt)
    {
      return new ControlState[paramAnonymousInt];
    }
  };
  public static final ControlState DISABLED_INACTIVE;
  public static final ControlState ENABLED_ACTIVE = new ControlState(true, true);
  public static final ControlState ENABLED_INACTIVE = new ControlState(true, false);
  public final boolean checked;
  public final boolean enabled;

  static
  {
    DISABLED_INACTIVE = new ControlState(false, false);
  }

  protected ControlState(Parcel paramParcel)
  {
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.enabled = bool2;
      if (paramParcel.readByte() == 0)
        break label38;
    }
    while (true)
    {
      this.checked = bool1;
      return;
      bool2 = false;
      break;
      label38: bool1 = false;
    }
  }

  public ControlState(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.enabled = paramBoolean1;
    this.checked = paramBoolean2;
  }

  public ControlState apply(int paramInt)
  {
    int i = 1;
    boolean bool1 = this.enabled;
    boolean bool2;
    if (av.d(2, paramInt))
    {
      bool1 = i;
      bool2 = this.checked;
      if (!av.d(8, paramInt))
        break label55;
    }
    while (true)
    {
      return new ControlState(bool1, i);
      if (!av.d(i, paramInt))
        break;
      bool1 = false;
      break;
      label55: int j;
      if (av.d(4, paramInt))
        j = 0;
      else
        j = bool2;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ControlState{enabled=" + this.enabled + ", checked=" + this.checked + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    byte b2;
    if (this.enabled)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.checked)
        break label37;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label37: b1 = 0;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PartialChange
  {
    public static final int CHECK = 8;
    public static final int DISABLE = 1;
    public static final int ENABLE = 2;
    public static final int UNCHECK = 4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ControlState
 * JD-Core Version:    0.6.2
 */