package com.viber.voip.messages.ui.input.handlers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.input.a;
import com.viber.voip.util.da;

public class ChatExInputHandler
  implements b
{
  private CharSequence a;
  private a b;
  private State c;
  private ai d;

  public ChatExInputHandler(ai paramai, a parama)
  {
    this.d = paramai;
    this.b = parama;
  }

  private void g()
  {
    if (this.a != null)
    {
      this.b.a(this.a);
      this.a = null;
    }
  }

  public int a()
  {
    return 1;
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof State))
      this.c = ((State)paramParcelable);
  }

  public void a(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }

  public CharSequence b()
  {
    if (this.a != null)
      return this.a;
    return this.b.a();
  }

  public void c()
  {
    if (this.c == null)
    {
      if (!da.a(this.b.a()))
        this.a = null;
      return;
    }
    if (this.c.mCachedInput != null);
    for (String str = this.c.mCachedInput; ; str = "")
    {
      this.a = da.a(this.d, str, Base64.decode(this.c.mCachedInputSpans, 19), false, true, aj.b);
      this.b.a(this.c.mCurrentInput);
      this.c = null;
      return;
    }
  }

  public void d()
  {
    g();
  }

  public Parcelable e()
  {
    State localState = new State();
    String str1 = "";
    byte[] arrayOfByte;
    if (this.a != null)
    {
      arrayOfByte = da.c(this.a);
      if (arrayOfByte != null)
        str1 = Base64.encodeToString(arrayOfByte, 19);
      if (this.a == null)
        break label94;
    }
    label94: for (String str2 = this.a.toString(); ; str2 = "")
    {
      State.access$002(localState, str2);
      State.access$102(localState, str1);
      State.access$202(localState, this.b.a().toString());
      return localState;
      arrayOfByte = null;
      break;
    }
  }

  public void f()
  {
    this.a = null;
    this.c = null;
  }

  public static class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ChatExInputHandler.State a(Parcel paramAnonymousParcel)
      {
        return new ChatExInputHandler.State(paramAnonymousParcel);
      }

      public ChatExInputHandler.State[] a(int paramAnonymousInt)
      {
        return new ChatExInputHandler.State[paramAnonymousInt];
      }
    };
    private String mCachedInput;
    private String mCachedInputSpans;
    private String mCurrentInput;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      this.mCachedInput = paramParcel.readString();
      this.mCachedInputSpans = paramParcel.readString();
      this.mCurrentInput = paramParcel.readString();
    }

    public int describeContents()
    {
      return 0;
    }

    String getCachedInput()
    {
      return this.mCachedInput;
    }

    String getCachedInputSpans()
    {
      return this.mCachedInputSpans;
    }

    String getCurrentInput()
    {
      return this.mCurrentInput;
    }

    void setCachedInput(String paramString)
    {
      this.mCachedInput = paramString;
    }

    void setCachedInputSpans(String paramString)
    {
      this.mCachedInputSpans = paramString;
    }

    void setCurrentInput(String paramString)
    {
      this.mCurrentInput = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mCachedInput);
      paramParcel.writeString(this.mCachedInputSpans);
      paramParcel.writeString(this.mCurrentInput);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.input.handlers.ChatExInputHandler
 * JD-Core Version:    0.6.2
 */