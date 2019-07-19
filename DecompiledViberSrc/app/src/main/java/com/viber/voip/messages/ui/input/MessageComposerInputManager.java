package com.viber.voip.messages.ui.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.ui.input.handlers.ChatExInputHandler.State;
import com.viber.voip.messages.ui.input.handlers.b;

public class MessageComposerInputManager
{
  private final b a;
  private final b[] b;
  private b c;
  private State d;

  public MessageComposerInputManager(b paramb, b[] paramArrayOfb)
  {
    this.a = paramb;
    this.b = paramArrayOfb;
    this.c = this.a;
  }

  public CharSequence a()
  {
    return this.c.b();
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (!paramBoolean)
      if (this.c.a() == paramInt)
        this.c.d();
    label179: 
    while (true)
    {
      if (this.c != localObject)
      {
        this.c = ((b)localObject);
        if ((this.d != null) && (this.d.mInputMode == this.c.a()))
        {
          this.c.a(this.d.mHandlerState);
          this.d = null;
        }
        this.c.c();
      }
      return;
      if (this.c.a() != paramInt)
        this.c.d();
      if (this.b != null)
      {
        b[] arrayOfb = this.b;
        int i = arrayOfb.length;
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label179;
          b localb = arrayOfb[j];
          if (localb.a() == paramInt)
          {
            localObject = localb;
            break;
          }
        }
      }
    }
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof State))
      this.d = ((State)paramParcelable);
  }

  public void a(CharSequence paramCharSequence)
  {
    this.c.a(paramCharSequence);
  }

  public Parcelable b()
  {
    State localState = new State();
    State.access$002(localState, this.c.a());
    State.access$102(localState, this.c.e());
    return localState;
  }

  public boolean c()
  {
    return this.d != null;
  }

  public void d()
  {
    this.a.f();
    if (this.b != null)
    {
      b[] arrayOfb = this.b;
      int i = arrayOfb.length;
      for (int j = 0; j < i; j++)
        arrayOfb[j].f();
    }
  }

  public static class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public MessageComposerInputManager.State a(Parcel paramAnonymousParcel)
      {
        return new MessageComposerInputManager.State(paramAnonymousParcel);
      }

      public MessageComposerInputManager.State[] a(int paramAnonymousInt)
      {
        return new MessageComposerInputManager.State[paramAnonymousInt];
      }
    };
    private Parcelable mHandlerState;
    private int mInputMode;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      this.mInputMode = paramParcel.readInt();
      if (this.mInputMode == 1)
      {
        this.mHandlerState = paramParcel.readParcelable(ChatExInputHandler.State.class.getClassLoader());
        return;
      }
      this.mHandlerState = paramParcel.readParcelable(Parcelable.class.getClassLoader());
    }

    public int describeContents()
    {
      return 0;
    }

    void setHandlerState(Parcelable paramParcelable)
    {
      this.mHandlerState = paramParcelable;
    }

    void setInputMode(int paramInt)
    {
      this.mInputMode = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mInputMode);
      paramParcel.writeParcelable(this.mHandlerState, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.input.MessageComposerInputManager
 * JD-Core Version:    0.6.2
 */