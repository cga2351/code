package com.viber.voip.storage.conversation;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.styleable;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.util.at;

public class MediaStorageCategoryLayout extends LinearLayout
  implements Checkable
{
  private TextView a;
  private CompoundButton b;

  public MediaStorageCategoryLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public MediaStorageCategoryLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public MediaStorageCategoryLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  public MediaStorageCategoryLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    inflate(paramContext, R.layout.list_item_manage_storage_category, this);
    TextView localTextView = (TextView)findViewById(R.id.media_category_name);
    this.b = ((CompoundButton)findViewById(R.id.media_category_selector));
    this.a = ((TextView)findViewById(R.id.media_category_size));
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MediaStorageCategoryLayout);
    try
    {
      localTextView.setText(localTypedArray.getText(R.styleable.MediaStorageCategoryLayout_android_text));
      localTypedArray.recycle();
      setMediaSize(0L);
      setGravity(16);
      setOrientation(0);
      setClickable(true);
      setFocusable(true);
      setSaveFromParentEnabled(false);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void a(MediaFileType paramMediaFileType, a parama)
  {
    setOnClickListener(new h(parama, paramMediaFileType));
  }

  public boolean isChecked()
  {
    return this.b.isChecked();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    if ((paramParcelable instanceof SavedState))
    {
      SavedState localSavedState = (SavedState)paramParcelable;
      setChecked(localSavedState.isChecked);
      this.a.setText(localSavedState.sizeText);
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), isChecked(), this.a.getText().toString());
  }

  public void setChecked(boolean paramBoolean)
  {
    this.b.setChecked(paramBoolean);
  }

  public void setMediaSize(long paramLong)
  {
    this.a.setText(at.a(paramLong, false));
  }

  public void toggle()
  {
    this.b.toggle();
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public MediaStorageCategoryLayout.SavedState a(Parcel paramAnonymousParcel)
      {
        return new MediaStorageCategoryLayout.SavedState(paramAnonymousParcel);
      }

      public MediaStorageCategoryLayout.SavedState[] a(int paramAnonymousInt)
      {
        return new MediaStorageCategoryLayout.SavedState[paramAnonymousInt];
      }
    };
    final boolean isChecked;
    final String sizeText;

    SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isChecked = bool;
        this.sizeText = paramParcel.readString();
        return;
      }
    }

    SavedState(Parcelable paramParcelable, boolean paramBoolean, String paramString)
    {
      super();
      this.isChecked = paramBoolean;
      this.sizeText = paramString;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.isChecked);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeString(this.sizeText);
        return;
      }
    }
  }

  static abstract interface a
  {
    public abstract void a(MediaFileType paramMediaFileType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.MediaStorageCategoryLayout
 * JD-Core Version:    0.6.2
 */