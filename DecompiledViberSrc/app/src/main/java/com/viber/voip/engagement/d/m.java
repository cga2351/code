package com.viber.voip.engagement.d;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.b.a.b;
import com.viber.voip.contacts.b.a.h;
import com.viber.voip.model.entity.e;

public class m extends com.viber.voip.model.entity.d
{
  private static final Logger F = ViberEnv.getLogger();
  private static final b G = new b()
  {
    public e a()
    {
      return new m();
    }
  };
  public static final a a = new a(null);
  private int H;
  private boolean I;

  public int a()
  {
    return this.H;
  }

  void a(int paramInt)
  {
    this.H = (paramInt + this.H);
  }

  void a(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }

  public boolean b()
  {
    return this.I;
  }

  public a c()
  {
    return a;
  }

  public String toString()
  {
    return "SuggestedContactEntity{id=" + this.id + ", mScore=" + this.H + ", mIsOnlineRecently=" + this.I + '}';
  }

  private static final class a extends h
  {
    public m b()
    {
      return new m();
    }

    public com.viber.voip.model.d createInstance(Cursor paramCursor)
    {
      return createInstance(paramCursor, 0);
    }

    public com.viber.voip.model.d createInstance(Cursor paramCursor, int paramInt)
    {
      com.viber.voip.model.entity.d locald = (com.viber.voip.model.entity.d)m.d().createInstance(paramCursor, paramInt);
      try
      {
        locald.f(paramCursor.getString(paramCursor.getColumnIndex("viber_data")));
        locald.c(paramCursor.getString(paramCursor.getColumnIndex("all_numbers")));
        locald.e(paramCursor.getString(paramCursor.getColumnIndex("numbers_labels")));
        return locald;
      }
      catch (Exception localException)
      {
      }
      return locald;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.m
 * JD-Core Version:    0.6.2
 */