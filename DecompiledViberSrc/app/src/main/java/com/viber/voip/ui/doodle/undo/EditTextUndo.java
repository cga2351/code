package com.viber.voip.ui.doodle.undo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.objects.TextObject;

public class EditTextUndo extends Undo
{
  public static final Parcelable.Creator<EditTextUndo> CREATOR = new Parcelable.Creator()
  {
    public EditTextUndo a(Parcel paramAnonymousParcel)
    {
      return new EditTextUndo(paramAnonymousParcel);
    }

    public EditTextUndo[] a(int paramAnonymousInt)
    {
      return new EditTextUndo[paramAnonymousInt];
    }
  };
  private final TextInfo mTextInfo;

  public EditTextUndo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mTextInfo = ((TextInfo)paramParcel.readParcelable(TextInfo.class.getClassLoader()));
  }

  public EditTextUndo(TextInfo paramTextInfo)
  {
    super(paramTextInfo.geId());
    this.mTextInfo = paramTextInfo;
  }

  public void execute(com.viber.voip.ui.doodle.objects.c.a parama, com.viber.voip.ui.doodle.scene.a parama1)
  {
    TextObject localTextObject = (TextObject)parama.a(this.mTextInfo.geId());
    if (localTextObject != null)
      localTextObject.update(this.mTextInfo);
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + this.mTextInfo.getSavedStateSizeInBytes();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mTextInfo, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.EditTextUndo
 * JD-Core Version:    0.6.2
 */