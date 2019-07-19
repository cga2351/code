package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator()
  {
    public SpliceScheduleCommand a(Parcel paramAnonymousParcel)
    {
      return new SpliceScheduleCommand(paramAnonymousParcel, null);
    }

    public SpliceScheduleCommand[] a(int paramAnonymousInt)
    {
      return new SpliceScheduleCommand[paramAnonymousInt];
    }
  };
  public final List<b> events;

  private SpliceScheduleCommand(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add(b.a(paramParcel));
    this.events = Collections.unmodifiableList(localArrayList);
  }

  private SpliceScheduleCommand(List<b> paramList)
  {
    this.events = Collections.unmodifiableList(paramList);
  }

  static SpliceScheduleCommand parseFromSection(r paramr)
  {
    int i = paramr.h();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add(b.a(paramr));
    return new SpliceScheduleCommand(localArrayList);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.events.size();
    paramParcel.writeInt(i);
    for (int j = 0; j < i; j++)
      b.a((b)this.events.get(j), paramParcel);
  }

  public static final class a
  {
    public final int a;
    public final long b;

    private a(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }

    private static a b(Parcel paramParcel)
    {
      return new a(paramParcel.readInt(), paramParcel.readLong());
    }

    private void c(Parcel paramParcel)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeLong(this.b);
    }
  }

  public static final class b
  {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final long e;
    public final List<SpliceScheduleCommand.a> f;
    public final boolean g;
    public final long h;
    public final int i;
    public final int j;
    public final int k;

    private b(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.a> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramLong1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.f = Collections.unmodifiableList(paramList);
      this.e = paramLong2;
      this.g = paramBoolean4;
      this.h = paramLong3;
      this.i = paramInt1;
      this.j = paramInt2;
      this.k = paramInt3;
    }

    private b(Parcel paramParcel)
    {
      this.a = paramParcel.readLong();
      int n;
      int i1;
      if (paramParcel.readByte() == m)
      {
        n = m;
        this.b = n;
        if (paramParcel.readByte() != m)
          break label111;
        i1 = m;
        label40: this.c = i1;
        if (paramParcel.readByte() != m)
          break label117;
      }
      ArrayList localArrayList;
      label111: label117: for (int i2 = m; ; i2 = 0)
      {
        this.d = i2;
        int i3 = paramParcel.readInt();
        localArrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++)
          localArrayList.add(SpliceScheduleCommand.a.a(paramParcel));
        n = 0;
        break;
        i1 = 0;
        break label40;
      }
      this.f = Collections.unmodifiableList(localArrayList);
      this.e = paramParcel.readLong();
      if (paramParcel.readByte() == m);
      while (true)
      {
        this.g = m;
        this.h = paramParcel.readLong();
        this.i = paramParcel.readInt();
        this.j = paramParcel.readInt();
        this.k = paramParcel.readInt();
        return;
        m = 0;
      }
    }

    private static b b(r paramr)
    {
      long l1 = paramr.n();
      boolean bool1;
      long l2;
      Object localObject1;
      long l3;
      boolean bool5;
      label59: boolean bool6;
      label70: int i3;
      if ((0x80 & paramr.h()) != 0)
      {
        bool1 = true;
        l2 = -9223372036854775807L;
        localObject1 = new ArrayList();
        l3 = -9223372036854775807L;
        if (bool1)
          break label333;
        int i2 = paramr.h();
        if ((i2 & 0x80) == 0)
          break label169;
        bool5 = true;
        if ((i2 & 0x40) == 0)
          break label175;
        bool6 = true;
        if ((i2 & 0x20) == 0)
          break label181;
        i3 = 1;
      }
      long l5;
      label169: label175: label181: boolean bool8;
      label220: int m;
      int n;
      int i1;
      boolean bool3;
      long l4;
      boolean bool4;
      boolean bool2;
      while (true)
        if (bool6)
        {
          l5 = paramr.n();
          if (!bool6)
          {
            int i4 = paramr.h();
            localObject2 = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++)
            {
              int i6 = paramr.h();
              long l8 = paramr.n();
              SpliceScheduleCommand.a locala = new SpliceScheduleCommand.a(i6, l8, null);
              ((ArrayList)localObject2).add(locala);
            }
            bool1 = false;
            break;
            bool5 = false;
            break label59;
            bool6 = false;
            break label70;
            i3 = 0;
            continue;
          }
          Object localObject2 = localObject1;
          boolean bool7 = false;
          if (i3 != 0)
          {
            long l6 = paramr.h();
            if ((0x80 & l6) != 0L)
            {
              bool8 = true;
              long l7 = 1000L * ((l6 & 1L) << 32 | paramr.n()) / 90L;
              bool7 = bool8;
              l3 = l7;
            }
          }
          else
          {
            m = paramr.i();
            n = paramr.h();
            i1 = paramr.h();
            localObject1 = localObject2;
            bool3 = bool6;
            l2 = l5;
            l4 = l3;
            bool4 = bool7;
            bool2 = bool5;
          }
        }
      while (true)
      {
        return new b(l1, bool1, bool2, bool3, (List)localObject1, l2, bool4, l4, m, n, i1);
        bool8 = false;
        break label220;
        l5 = l2;
        break;
        label333: l4 = l3;
        bool2 = false;
        bool3 = false;
        bool4 = false;
        m = 0;
        n = 0;
        i1 = 0;
      }
    }

    private void b(Parcel paramParcel)
    {
      int m = 1;
      paramParcel.writeLong(this.a);
      int n;
      int i1;
      if (this.b)
      {
        n = m;
        paramParcel.writeByte((byte)n);
        if (!this.c)
          break label115;
        i1 = m;
        label35: paramParcel.writeByte((byte)i1);
        if (!this.d)
          break label121;
      }
      label115: label121: for (int i2 = m; ; i2 = 0)
      {
        paramParcel.writeByte((byte)i2);
        int i3 = this.f.size();
        paramParcel.writeInt(i3);
        for (int i4 = 0; i4 < i3; i4++)
          SpliceScheduleCommand.a.a((SpliceScheduleCommand.a)this.f.get(i4), paramParcel);
        n = 0;
        break;
        i1 = 0;
        break label35;
      }
      paramParcel.writeLong(this.e);
      if (this.g);
      while (true)
      {
        paramParcel.writeByte((byte)m);
        paramParcel.writeLong(this.h);
        paramParcel.writeInt(this.i);
        paramParcel.writeInt(this.j);
        paramParcel.writeInt(this.k);
        return;
        m = 0;
      }
    }

    private static b c(Parcel paramParcel)
    {
      return new b(paramParcel);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.6.2
 */