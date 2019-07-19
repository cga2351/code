package com.viber.voip.camrecorder.preview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DoodleDataContainer
  implements Parcelable
{
  public static final Parcelable.Creator<DoodleDataContainer> CREATOR = new Parcelable.Creator()
  {
    public DoodleDataContainer a(Parcel paramAnonymousParcel)
    {
      return new DoodleDataContainer(paramAnonymousParcel);
    }

    public DoodleDataContainer[] a(int paramAnonymousInt)
    {
      return new DoodleDataContainer[paramAnonymousInt];
    }
  };
  public boolean doodle;
  public long doodleSize;
  public int emoticons;
  public boolean emptyBackground;
  public String filter;
  public boolean save;
  public boolean stickerPackPurchased;
  public int stickers;
  public boolean text;
  public int timebomb;

  public DoodleDataContainer(Parcel paramParcel)
  {
    int j;
    int k;
    label40: int m;
    label65: int n;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.doodle = j;
      this.doodleSize = paramParcel.readLong();
      if (paramParcel.readByte() != i)
        break label131;
      k = i;
      this.text = k;
      this.timebomb = paramParcel.readInt();
      if (paramParcel.readByte() != i)
        break label137;
      m = i;
      this.save = m;
      this.stickers = paramParcel.readInt();
      this.emoticons = paramParcel.readInt();
      this.filter = paramParcel.readString();
      if (paramParcel.readByte() != i)
        break label143;
      n = i;
      label106: this.stickerPackPurchased = n;
      if (paramParcel.readByte() != i)
        break label149;
    }
    while (true)
    {
      this.emptyBackground = i;
      return;
      j = 0;
      break;
      label131: k = 0;
      break label40;
      label137: m = 0;
      break label65;
      label143: n = 0;
      break label106;
      label149: i = 0;
    }
  }

  public DoodleDataContainer(boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, int paramInt2, int paramInt3, String paramString, boolean paramBoolean4)
  {
    this.doodle = paramBoolean1;
    this.doodleSize = paramLong;
    this.text = paramBoolean2;
    this.timebomb = paramInt1;
    this.save = paramBoolean3;
    this.stickers = paramInt2;
    this.emoticons = paramInt3;
    this.filter = paramString;
    this.stickerPackPurchased = paramBoolean4;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "DoodleDataContainer{ doodle: " + this.doodle + ", doodleSize: " + this.doodleSize + ", text: " + this.text + ", timebomb: " + this.timebomb + ", save: " + this.save + ", stickers: " + this.stickers + ", emoticons: " + this.emoticons + ", filter: " + this.filter + ", stickerPackPurchased: " + this.stickerPackPurchased + " }";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    int j;
    int k;
    label37: int m;
    label62: int n;
    if (this.doodle)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      paramParcel.writeLong(this.doodleSize);
      if (!this.text)
        break label130;
      k = i;
      paramParcel.writeByte((byte)k);
      paramParcel.writeInt(this.timebomb);
      if (!this.save)
        break label136;
      m = i;
      paramParcel.writeByte((byte)m);
      paramParcel.writeInt(this.stickers);
      paramParcel.writeInt(this.emoticons);
      paramParcel.writeString(this.filter);
      if (!this.stickerPackPurchased)
        break label142;
      n = i;
      label103: paramParcel.writeByte((byte)n);
      if (!this.emptyBackground)
        break label148;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label130: k = 0;
      break label37;
      label136: m = 0;
      break label62;
      label142: n = 0;
      break label103;
      label148: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.DoodleDataContainer
 * JD-Core Version:    0.6.2
 */