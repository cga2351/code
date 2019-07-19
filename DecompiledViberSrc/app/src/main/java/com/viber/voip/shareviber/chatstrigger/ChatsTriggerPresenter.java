package com.viber.voip.shareviber.chatstrigger;

import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.c.d.m.d;
import com.viber.voip.util.cl;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class ChatsTriggerPresenter
  implements m.d, a.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b;
  private final f c;
  private final dagger.a<m> d;
  private final Handler e;
  private h f = (h)cl.b(h.class);
  private State g;
  private boolean h = true;

  public ChatsTriggerPresenter(a parama, f paramf, dagger.a<m> parama1, Handler paramHandler)
  {
    this.b = parama;
    this.c = paramf;
    this.d = parama1;
    this.e = paramHandler;
    this.g = new State(this.b.a(), false, null);
  }

  private void e()
  {
    if ((this.g.getIsTriggerVisible()) && (!this.g.isSearchEnabled()))
    {
      this.f.a();
      if (this.g.getAvatarUris() != null)
        this.f.a(this.g.getAvatarUris());
      return;
    }
    this.f.b();
  }

  public void a()
  {
    this.f = ((h)cl.b(h.class));
  }

  public void a(h paramh, Parcelable paramParcelable)
  {
    this.f = paramh;
    if ((paramParcelable instanceof State));
    for (this.g = ((State)paramParcelable); ; this.g = new State(this.b.a(), false, null))
    {
      e();
      return;
    }
  }

  public void a(final Set<com.viber.voip.model.a> paramSet)
  {
    if (paramSet.size() == 3)
      this.e.post(new Runnable()
      {
        public void run()
        {
          String[] arrayOfString = new String[3];
          Iterator localIterator = paramSet.iterator();
          int j;
          for (int i = 0; localIterator.hasNext(); i = j)
          {
            Uri localUri = ((com.viber.voip.model.a)localIterator.next()).o();
            if (localUri == null)
              return;
            j = i + 1;
            arrayOfString[i] = localUri.toString();
          }
          ChatsTriggerPresenter.a(ChatsTriggerPresenter.this, new ChatsTriggerPresenter.State(ChatsTriggerPresenter.a(ChatsTriggerPresenter.this).getIsTriggerVisible(), ChatsTriggerPresenter.a(ChatsTriggerPresenter.this).isSearchEnabled(), arrayOfString));
          ChatsTriggerPresenter.b(ChatsTriggerPresenter.this);
        }
      });
  }

  public void a(boolean paramBoolean)
  {
    this.g = new State(paramBoolean, this.g.isSearchEnabled(), this.g.getAvatarUris());
    if ((paramBoolean) && (this.h))
    {
      ((m)this.d.get()).a(3, this);
      this.h = false;
    }
    e();
  }

  public void b()
  {
    if (this.g.getIsTriggerVisible())
      this.c.a();
  }

  public void b(boolean paramBoolean)
  {
    this.g = new State(this.g.getIsTriggerVisible(), paramBoolean, this.g.getAvatarUris());
    e();
  }

  public State c()
  {
    return this.g;
  }

  public void d()
  {
    this.b.a(this);
  }

  static class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ChatsTriggerPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ChatsTriggerPresenter.State(paramAnonymousParcel);
      }

      public ChatsTriggerPresenter.State[] a(int paramAnonymousInt)
      {
        return new ChatsTriggerPresenter.State[paramAnonymousInt];
      }
    };
    private final String[] mAvatarUris;
    private final boolean mIsTriggerVisible;
    private final boolean mSearchEnabled;

    protected State(Parcel paramParcel)
    {
      boolean bool2;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.mIsTriggerVisible = bool2;
        if (paramParcel.readInt() <= 0)
          break label46;
      }
      while (true)
      {
        this.mSearchEnabled = bool1;
        this.mAvatarUris = paramParcel.createStringArray();
        return;
        bool2 = false;
        break;
        label46: bool1 = false;
      }
    }

    State(boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString)
    {
      this.mIsTriggerVisible = paramBoolean1;
      this.mSearchEnabled = paramBoolean2;
      this.mAvatarUris = paramArrayOfString;
    }

    public int describeContents()
    {
      return 0;
    }

    String[] getAvatarUris()
    {
      return this.mAvatarUris;
    }

    boolean getIsTriggerVisible()
    {
      return this.mIsTriggerVisible;
    }

    public boolean isSearchEnabled()
    {
      return this.mSearchEnabled;
    }

    public String toString()
    {
      return "State{mIsTriggerVisible=" + this.mIsTriggerVisible + ", mSearchEnabled=" + this.mSearchEnabled + ", mAvatarUris=" + Arrays.toString(this.mAvatarUris) + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      int j;
      if (this.mIsTriggerVisible)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        if (!this.mSearchEnabled)
          break label46;
      }
      while (true)
      {
        paramParcel.writeInt(i);
        paramParcel.writeStringArray(this.mAvatarUris);
        return;
        j = 0;
        break;
        label46: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.chatstrigger.ChatsTriggerPresenter
 * JD-Core Version:    0.6.2
 */