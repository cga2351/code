package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator()
  {
    public SpliceInsertCommand a(Parcel paramAnonymousParcel)
    {
      return new SpliceInsertCommand(paramAnonymousParcel, null);
    }

    public SpliceInsertCommand[] a(int paramAnonymousInt)
    {
      return new SpliceInsertCommand[paramAnonymousInt];
    }
  };
  public final boolean autoReturn;
  public final int availNum;
  public final int availsExpected;
  public final long breakDurationUs;
  public final List<a> componentSpliceList;
  public final boolean outOfNetworkIndicator;
  public final boolean programSpliceFlag;
  public final long programSplicePlaybackPositionUs;
  public final long programSplicePts;
  public final boolean spliceEventCancelIndicator;
  public final long spliceEventId;
  public final boolean spliceImmediateFlag;
  public final int uniqueProgramId;

  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<a> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.spliceEventId = paramLong1;
    this.spliceEventCancelIndicator = paramBoolean1;
    this.outOfNetworkIndicator = paramBoolean2;
    this.programSpliceFlag = paramBoolean3;
    this.spliceImmediateFlag = paramBoolean4;
    this.programSplicePts = paramLong2;
    this.programSplicePlaybackPositionUs = paramLong3;
    this.componentSpliceList = Collections.unmodifiableList(paramList);
    this.autoReturn = paramBoolean5;
    this.breakDurationUs = paramLong4;
    this.uniqueProgramId = paramInt1;
    this.availNum = paramInt2;
    this.availsExpected = paramInt3;
  }

  private SpliceInsertCommand(Parcel paramParcel)
  {
    this.spliceEventId = paramParcel.readLong();
    int j;
    int k;
    label40: int m;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.spliceEventCancelIndicator = j;
      if (paramParcel.readByte() != i)
        break label146;
      k = i;
      this.outOfNetworkIndicator = k;
      if (paramParcel.readByte() != i)
        break label152;
      m = i;
      label57: this.programSpliceFlag = m;
      if (paramParcel.readByte() != i)
        break label158;
    }
    ArrayList localArrayList;
    label146: label152: label158: for (int n = i; ; n = 0)
    {
      this.spliceImmediateFlag = n;
      this.programSplicePts = paramParcel.readLong();
      this.programSplicePlaybackPositionUs = paramParcel.readLong();
      int i1 = paramParcel.readInt();
      localArrayList = new ArrayList(i1);
      for (int i2 = 0; i2 < i1; i2++)
        localArrayList.add(a.b(paramParcel));
      j = 0;
      break;
      k = 0;
      break label40;
      m = 0;
      break label57;
    }
    this.componentSpliceList = Collections.unmodifiableList(localArrayList);
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.autoReturn = i;
      this.breakDurationUs = paramParcel.readLong();
      this.uniqueProgramId = paramParcel.readInt();
      this.availNum = paramParcel.readInt();
      this.availsExpected = paramParcel.readInt();
      return;
      i = 0;
    }
  }

  static SpliceInsertCommand parseFromSection(r paramr, long paramLong, ad paramad)
  {
    long l1 = paramr.n();
    boolean bool1;
    Object localObject;
    boolean bool6;
    label48: boolean bool7;
    label59: int n;
    label70: boolean bool8;
    if ((0x80 & paramr.h()) != 0)
    {
      bool1 = true;
      localObject = Collections.emptyList();
      if (bool1)
        break label380;
      int m = paramr.h();
      if ((m & 0x80) == 0)
        break label191;
      bool6 = true;
      if ((m & 0x40) == 0)
        break label197;
      bool7 = true;
      if ((m & 0x20) == 0)
        break label203;
      n = 1;
      if ((m & 0x10) == 0)
        break label209;
      bool8 = true;
    }
    label81: long l5;
    label191: label197: label203: label209: boolean bool10;
    label241: boolean bool9;
    long l6;
    label271: int i;
    int j;
    int k;
    long l3;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    long l2;
    boolean bool5;
    while (true)
      if ((bool7) && (!bool8))
      {
        l5 = TimeSignalCommand.parseSpliceTime(paramr, paramLong);
        if (!bool7)
        {
          int i1 = paramr.h();
          localObject = new ArrayList(i1);
          int i2 = 0;
          while (true)
            if (i2 < i1)
            {
              int i3 = paramr.h();
              long l9 = -9223372036854775807L;
              if (!bool8)
                l9 = TimeSignalCommand.parseSpliceTime(paramr, paramLong);
              ((List)localObject).add(new a(i3, l9, paramad.b(l9), null));
              i2++;
              continue;
              bool1 = false;
              break;
              bool6 = false;
              break label48;
              bool7 = false;
              break label59;
              n = 0;
              break label70;
              bool8 = false;
              break label81;
            }
        }
        if (n != 0)
        {
          long l7 = paramr.h();
          if ((0x80 & l7) != 0L)
          {
            bool10 = true;
            long l8 = 1000L * ((l7 & 1L) << 32 | paramr.n()) / 90L;
            bool9 = bool10;
            l6 = l8;
            i = paramr.i();
            j = paramr.h();
            k = paramr.h();
            l3 = l5;
            bool4 = bool8;
            bool3 = bool7;
            bool2 = bool6;
            l2 = l6;
            bool5 = bool9;
          }
        }
      }
    while (true)
    {
      long l4 = paramad.b(l3);
      return new SpliceInsertCommand(l1, bool1, bool2, bool3, bool4, l3, l4, (List)localObject, bool5, l2, i, j, k);
      bool10 = false;
      break label241;
      l6 = -9223372036854775807L;
      bool9 = false;
      break label271;
      l5 = -9223372036854775807L;
      break;
      label380: l2 = -9223372036854775807L;
      l3 = -9223372036854775807L;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      bool5 = false;
      i = 0;
      j = 0;
      k = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.spliceEventId);
    int j;
    int k;
    label37: int m;
    if (this.spliceEventCancelIndicator)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.outOfNetworkIndicator)
        break label151;
      k = i;
      paramParcel.writeByte((byte)k);
      if (!this.programSpliceFlag)
        break label157;
      m = i;
      label54: paramParcel.writeByte((byte)m);
      if (!this.spliceImmediateFlag)
        break label163;
    }
    label151: label157: label163: for (int n = i; ; n = 0)
    {
      paramParcel.writeByte((byte)n);
      paramParcel.writeLong(this.programSplicePts);
      paramParcel.writeLong(this.programSplicePlaybackPositionUs);
      int i1 = this.componentSpliceList.size();
      paramParcel.writeInt(i1);
      for (int i2 = 0; i2 < i1; i2++)
        ((a)this.componentSpliceList.get(i2)).a(paramParcel);
      j = 0;
      break;
      k = 0;
      break label37;
      m = 0;
      break label54;
    }
    if (this.autoReturn);
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeLong(this.breakDurationUs);
      paramParcel.writeInt(this.uniqueProgramId);
      paramParcel.writeInt(this.availNum);
      paramParcel.writeInt(this.availsExpected);
      return;
      i = 0;
    }
  }

  public static final class a
  {
    public final int a;
    public final long b;
    public final long c;

    private a(int paramInt, long paramLong1, long paramLong2)
    {
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
    }

    public static a b(Parcel paramParcel)
    {
      return new a(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong());
    }

    public void a(Parcel paramParcel)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeLong(this.b);
      paramParcel.writeLong(this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.6.2
 */