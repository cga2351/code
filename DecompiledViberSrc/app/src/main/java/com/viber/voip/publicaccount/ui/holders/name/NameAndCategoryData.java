package com.viber.voip.publicaccount.ui.holders.name;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;
import com.viber.voip.validation.FormValidator.InstanceState;
import com.viber.voip.widget.ViewWithDescription.ValidationState;
import com.viber.voip.widget.ViewWithDescription.a;

class NameAndCategoryData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<NameAndCategoryData> CREATOR = new Parcelable.Creator()
  {
    public NameAndCategoryData a(Parcel paramAnonymousParcel)
    {
      return new NameAndCategoryData(paramAnonymousParcel);
    }

    public NameAndCategoryData[] a(int paramAnonymousInt)
    {
      return new NameAndCategoryData[paramAnonymousInt];
    }
  };
  public static final String NO_SUBCATEGORIES_ID = "-2";
  public static final String SUBCATEGORY_NOT_SELECTED_ID = "-1";
  boolean mAllFieldsValid = true;
  String mCategoryId;
  int mCategoryIndex = -1;
  String mCategoryName;
  ViewWithDescription.a mCategoryState = ViewWithDescription.a.a;
  boolean mIsNameValid = true;
  String mName;
  ViewWithDescription.ValidationState mNameViewState;
  String mSubCategoryId;
  int mSubCategoryIndex = -1;
  String mSubCategoryName;
  ViewWithDescription.a mSubCategoryState = ViewWithDescription.a.a;
  FormValidator.InstanceState mValidatorState;

  public NameAndCategoryData()
  {
  }

  protected NameAndCategoryData(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mCategoryIndex = paramParcel.readInt();
    int i = paramParcel.readInt();
    ViewWithDescription.a locala1;
    int j;
    ViewWithDescription.a locala2;
    if (i == -1)
    {
      locala1 = null;
      this.mCategoryState = locala1;
      this.mCategoryId = paramParcel.readString();
      this.mCategoryName = paramParcel.readString();
      this.mSubCategoryIndex = paramParcel.readInt();
      j = paramParcel.readInt();
      locala2 = null;
      if (j != -1)
        break label190;
      label110: this.mSubCategoryState = locala2;
      this.mSubCategoryId = paramParcel.readString();
      this.mSubCategoryName = paramParcel.readString();
      if (paramParcel.readByte() == 0)
        break label201;
    }
    label190: label201: for (boolean bool = true; ; bool = false)
    {
      this.mAllFieldsValid = bool;
      this.mValidatorState = ((FormValidator.InstanceState)paramParcel.readParcelable(FormValidator.InstanceState.class.getClassLoader()));
      this.mNameViewState = ((ViewWithDescription.ValidationState)paramParcel.readParcelable(ViewWithDescription.ValidationState.class.getClassLoader()));
      return;
      locala1 = ViewWithDescription.a.values()[i];
      break;
      locala2 = ViewWithDescription.a.values()[j];
      break label110;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setName(this.mName);
    paramPublicAccount.setSelectedCategory(this.mCategoryId, this.mCategoryName);
    paramPublicAccount.setSelectedSubcategory(this.mSubCategoryId, this.mSubCategoryName);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mName = paramPublicAccount.getName();
    this.mCategoryId = paramPublicAccount.getCategoryId();
    this.mCategoryName = paramPublicAccount.getCategoryName();
    this.mSubCategoryId = paramPublicAccount.getSubCategoryId();
    this.mSubCategoryName = paramPublicAccount.getSubcategoryName();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mCategoryIndex);
    int j;
    if (this.mCategoryState == null)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeString(this.mCategoryId);
      paramParcel.writeString(this.mCategoryName);
      paramParcel.writeInt(this.mSubCategoryIndex);
      if (this.mSubCategoryState != null)
        break label133;
      label65: paramParcel.writeInt(i);
      paramParcel.writeString(this.mSubCategoryId);
      paramParcel.writeString(this.mSubCategoryName);
      if (!this.mAllFieldsValid)
        break label144;
    }
    label133: label144: for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.mValidatorState, paramInt);
      paramParcel.writeParcelable(this.mNameViewState, paramInt);
      return;
      j = this.mCategoryState.ordinal();
      break;
      i = this.mSubCategoryState.ordinal();
      break label65;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.name.NameAndCategoryData
 * JD-Core Version:    0.6.2
 */