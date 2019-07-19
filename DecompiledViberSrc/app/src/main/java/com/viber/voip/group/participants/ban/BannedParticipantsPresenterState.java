package com.viber.voip.group.participants.ban;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class BannedParticipantsPresenterState extends State
{
  public static final Parcelable.Creator<BannedParticipantsPresenterState> CREATOR = new Parcelable.Creator()
  {
    public BannedParticipantsPresenterState a(Parcel paramAnonymousParcel)
    {
      return new BannedParticipantsPresenterState(paramAnonymousParcel);
    }

    public BannedParticipantsPresenterState[] a(int paramAnonymousInt)
    {
      return new BannedParticipantsPresenterState[paramAnonymousInt];
    }
  };
  private final int mActionSequence;
  private final boolean mEditModeEnabled;
  private final boolean mListWasRequested;

  public BannedParticipantsPresenterState(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mActionSequence = paramInt;
    this.mListWasRequested = paramBoolean1;
    this.mEditModeEnabled = paramBoolean2;
  }

  public BannedParticipantsPresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mActionSequence = paramParcel.readInt();
    int j;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.mListWasRequested = j;
      if (paramParcel.readByte() != i)
        break label49;
    }
    while (true)
    {
      this.mEditModeEnabled = i;
      return;
      j = 0;
      break;
      label49: i = 0;
    }
  }

  public int getActionSequence()
  {
    return this.mActionSequence;
  }

  public boolean isEditModeEnabled()
  {
    return this.mEditModeEnabled;
  }

  public boolean isListWasRequested()
  {
    return this.mListWasRequested;
  }

  public String toString()
  {
    return "BannedParticipantsPresenterState{mActionSequence=" + this.mActionSequence + ", mListWasRequested=" + this.mListWasRequested + ", mEditModeEnabled=" + this.mEditModeEnabled + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mActionSequence);
    int j;
    if (this.mListWasRequested)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.mEditModeEnabled)
        break label53;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label53: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.BannedParticipantsPresenterState
 * JD-Core Version:    0.6.2
 */