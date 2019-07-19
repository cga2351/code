package com.viber.voip.s.a;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.d.l;
import com.viber.voip.ads.d.n;
import com.viber.voip.i.c.l;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.a.a;
import com.viber.voip.util.af;

public class x extends y
{
  private boolean a(Cursor paramCursor, String paramString)
  {
    do
      if (paramString.equalsIgnoreCase(paramCursor.getString(ConversationWithPublicAccountLoaderEntity.PUBLIC_GROUP_URI_INDX)))
        return true;
    while (paramCursor.moveToNext());
    return false;
  }

  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    Cursor localCursor = super.a(paramb, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4);
    n localn;
    int i;
    int j;
    if (af.c(localCursor))
    {
      localn = ViberApplication.getInstance().getMessagesManager().r().d();
      if (((localn instanceof l)) || ((localn instanceof com.viber.voip.ads.d.f)))
        i = 0;
      while ((localn != null) && (localn.s()) && (i >= 0))
        if ((localn.t()) && (a(localCursor, localn.u())))
        {
          return localCursor;
          i = -1 + c.l.b.f();
        }
        else
        {
          j = localCursor.getCount();
          if (i <= j)
            break label165;
        }
    }
    while (true)
    {
      localn.a(j + 1);
      return new a(localCursor, j, null);
      return localCursor;
      label165: j = i;
    }
  }

  private static class a extends CursorWrapper
  {
    private int a;
    private int b = -1;

    private a(Cursor paramCursor, int paramInt)
    {
      super();
      this.a = paramInt;
    }

    public int getCount()
    {
      return 1 + super.getCount();
    }

    public int getInt(int paramInt)
    {
      if (this.b == this.a)
        return 0;
      return super.getInt(paramInt);
    }

    public long getLong(int paramInt)
    {
      if (this.b == this.a)
      {
        if (paramInt == 0)
          return -10L;
        return 0L;
      }
      return super.getLong(paramInt);
    }

    public int getPosition()
    {
      return this.b;
    }

    public String getString(int paramInt)
    {
      if (this.b == this.a)
        return null;
      return super.getString(paramInt);
    }

    public boolean move(int paramInt)
    {
      return moveToPosition(paramInt + this.b);
    }

    public boolean moveToFirst()
    {
      return moveToPosition(0);
    }

    public boolean moveToLast()
    {
      return moveToPosition(-1 + getCount());
    }

    public boolean moveToNext()
    {
      return moveToPosition(1 + this.b);
    }

    public boolean moveToPosition(int paramInt)
    {
      int i = getCount();
      if (paramInt >= i)
      {
        this.b = i;
        return false;
      }
      if (paramInt < 0)
      {
        this.b = -1;
        return false;
      }
      if (paramInt == this.b)
        return true;
      this.b = paramInt;
      if (this.b < this.a)
        return super.moveToPosition(paramInt);
      if (this.b == this.a)
        return true;
      return super.moveToPosition(-1 + this.b);
    }

    public boolean moveToPrevious()
    {
      return moveToPosition(-1 + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.x
 * JD-Core Version:    0.6.2
 */