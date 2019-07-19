package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;

public class TextViewWithIndependentDescription extends TextViewWithDescription
{
  private int e = 0;

  public TextViewWithIndependentDescription(Context paramContext)
  {
    super(paramContext);
  }

  public TextViewWithIndependentDescription(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TextViewWithIndependentDescription(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(ViewWithDescription.a parama, CharSequence paramCharSequence)
  {
    if ((parama != ViewWithDescription.a.c) && (this.e != 0))
      paramCharSequence = getResources().getString(this.e);
    super.a(parama, paramCharSequence);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.superState);
    this.e = localSavedState.independentStatusMessage;
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.independentStatusMessage = this.e;
    return localSavedState;
  }

  public void setIndependentStatusMessage(int paramInt)
  {
    this.e = paramInt;
    a(ViewWithDescription.a.a, this.e);
  }

  protected void setTextColorByState(ViewWithDescription.a parama)
  {
    super.setTextColorByState(parama);
    if (parama != ViewWithDescription.a.c)
      setStatusMessageColor(this.a);
  }

  static final class SavedState extends ViewWithDescription.SavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public TextViewWithIndependentDescription.SavedState a(Parcel paramAnonymousParcel)
      {
        return new TextViewWithIndependentDescription.SavedState(paramAnonymousParcel);
      }

      public TextViewWithIndependentDescription.SavedState[] a(int paramAnonymousInt)
      {
        return new TextViewWithIndependentDescription.SavedState[paramAnonymousInt];
      }
    };
    int independentStatusMessage;
    final Parcelable superState;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.superState = paramParcel.readParcelable(ViewWithDescription.SavedState.class.getClassLoader());
      this.independentStatusMessage = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
      this.superState = paramParcelable;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.superState, paramInt);
      paramParcel.writeInt(this.independentStatusMessage);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TextViewWithIndependentDescription
 * JD-Core Version:    0.6.2
 */