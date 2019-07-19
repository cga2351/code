package com.viber.voip.bot.item;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class KeyboardItem
  implements Parcelable
{
  protected int colSpan = 0;
  protected int genericColPos = 0;
  protected int genericRowPos = 0;
  protected int landColPos = 0;
  protected int landRowPos = 0;
  protected int portColPos = 0;
  protected int portRowPos = 0;
  protected int rowSpan = 0;

  protected KeyboardItem()
  {
  }

  protected KeyboardItem(Parcel paramParcel)
  {
    this.colSpan = paramParcel.readInt();
    this.rowSpan = paramParcel.readInt();
    this.genericColPos = paramParcel.readInt();
    this.genericRowPos = paramParcel.readInt();
    this.portColPos = paramParcel.readInt();
    this.portRowPos = paramParcel.readInt();
    this.landColPos = paramParcel.readInt();
    this.landRowPos = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getColSpan()
  {
    return this.colSpan;
  }

  public int getGenericColPos()
  {
    return this.genericColPos;
  }

  public int getGenericRowPos()
  {
    return this.genericRowPos;
  }

  public int getLandColPos()
  {
    return this.landColPos;
  }

  public int getLandRowPos()
  {
    return this.landRowPos;
  }

  public int getPortColPos()
  {
    return this.portColPos;
  }

  public int getPortRowPos()
  {
    return this.portRowPos;
  }

  public int getRowSpan()
  {
    return this.rowSpan;
  }

  public void setColSpan(int paramInt)
  {
    this.colSpan = paramInt;
  }

  public void setGenericColPos(int paramInt)
  {
    this.genericColPos = paramInt;
  }

  public void setGenericRowPos(int paramInt)
  {
    this.genericRowPos = paramInt;
  }

  public void setLandColPos(int paramInt)
  {
    this.landColPos = paramInt;
  }

  public void setLandRowPos(int paramInt)
  {
    this.landRowPos = paramInt;
  }

  public void setPortColPos(int paramInt)
  {
    this.portColPos = paramInt;
  }

  public void setPortRowPos(int paramInt)
  {
    this.portRowPos = paramInt;
  }

  public void setRowSpan(int paramInt)
  {
    this.rowSpan = paramInt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.colSpan);
    paramParcel.writeInt(this.rowSpan);
    paramParcel.writeInt(this.genericColPos);
    paramParcel.writeInt(this.genericRowPos);
    paramParcel.writeInt(this.portColPos);
    paramParcel.writeInt(this.portRowPos);
    paramParcel.writeInt(this.landColPos);
    paramParcel.writeInt(this.landRowPos);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.item.KeyboardItem
 * JD-Core Version:    0.6.2
 */