package com.viber.voip.messages.conversation.ui.presenter.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class InputFieldState extends State
{
  public static final Parcelable.Creator<InputFieldState> CREATOR = new Parcelable.Creator()
  {
    public InputFieldState a(Parcel paramAnonymousParcel)
    {
      return new InputFieldState(paramAnonymousParcel);
    }

    public InputFieldState[] a(int paramAnonymousInt)
    {
      return new InputFieldState[paramAnonymousInt];
    }
  };
  private boolean mChatExEnabled;
  private Parcelable mInputState;

  protected InputFieldState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mChatExEnabled = i;
      this.mInputState = paramParcel.readParcelable(InputFieldState.class.getClassLoader());
      return;
      i = 0;
    }
  }

  public InputFieldState(boolean paramBoolean, Parcelable paramParcelable)
  {
    this.mChatExEnabled = paramBoolean;
    this.mInputState = paramParcelable;
  }

  public Parcelable getInputState()
  {
    return this.mInputState;
  }

  public boolean isChatExEnabled()
  {
    return this.mChatExEnabled;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.mChatExEnabled);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.mInputState, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.input.InputFieldState
 * JD-Core Version:    0.6.2
 */