package com.viber.voip.widget;

import android.app.Activity;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.d.b;
import java.util.LinkedList;

public class MessageBar
{
  private View a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private ProgressBar f;
  private LinkedList<Message> g = new LinkedList();
  private Message h;
  private boolean i;
  private a j;
  private Handler k;
  private AlphaAnimation l;
  private AlphaAnimation m;
  private final View.OnClickListener n = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((MessageBar.c(MessageBar.this) != null) && (MessageBar.d(MessageBar.this) != null))
        MessageBar.c(MessageBar.this).a(MessageBar.d(MessageBar.this).mToken);
      MessageBar.b(MessageBar.this, null);
      MessageBar.f(MessageBar.this).removeCallbacks(MessageBar.e(MessageBar.this));
      MessageBar.e(MessageBar.this).run();
    }
  };
  private final Runnable o = new b(this, null);

  public MessageBar(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    a(paramActivity.getLayoutInflater().inflate(R.layout.mb__messagebar, localViewGroup));
  }

  private void a(View paramView)
  {
    this.a = paramView.findViewById(R.id.mbContainer);
    this.a.setVisibility(8);
    this.b = ((TextView)paramView.findViewById(R.id.mbMessage));
    this.c = ((TextView)paramView.findViewById(R.id.mbMessageSecond));
    this.e = ((ImageView)paramView.findViewById(R.id.mbButton));
    this.d = ((ImageView)paramView.findViewById(R.id.mbIcon));
    this.f = ((ProgressBar)paramView.findViewById(R.id.mbProgress));
    this.e.setOnClickListener(this.n);
    this.l = new AlphaAnimation(0.0F, 1.0F);
    this.m = new AlphaAnimation(1.0F, 0.0F);
    this.m.setDuration(600L);
    this.m.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        MessageBar.Message localMessage = (MessageBar.Message)MessageBar.a(MessageBar.this).poll();
        if (localMessage != null)
        {
          MessageBar.a(MessageBar.this, localMessage);
          return;
        }
        MessageBar.b(MessageBar.this, null);
        MessageBar.b(MessageBar.this).setVisibility(8);
        MessageBar.a(MessageBar.this, false);
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    this.k = new Handler();
  }

  private void a(Message paramMessage)
  {
    a(paramMessage, false);
  }

  private void a(Message paramMessage, boolean paramBoolean)
  {
    this.i = true;
    this.a.setVisibility(0);
    this.h = paramMessage;
    this.b.setText(paramMessage.mMessage);
    label84: label110: label125: Handler localHandler;
    label137: Runnable localRunnable;
    if (!TextUtils.isEmpty(paramMessage.mActionMessage))
    {
      this.c.setVisibility(0);
      this.c.setText(paramMessage.mActionMessage);
      if (paramMessage.mActionIcon == 0)
        break label193;
      this.e.setVisibility(0);
      this.e.setImageResource(paramMessage.mActionIcon);
      if (paramMessage.mMessageIcon == 0)
        break label205;
      this.d.setVisibility(0);
      this.d.setImageResource(paramMessage.mMessageIcon);
      if (!paramMessage.mShowProgress)
        break label217;
      this.f.setVisibility(0);
      if (!paramBoolean)
        break label229;
      this.l.setDuration(0L);
      this.a.startAnimation(this.l);
      localHandler = this.k;
      localRunnable = this.o;
      if (!paramMessage.mLongDelay)
        break label242;
    }
    label193: label205: label217: label229: label242: for (long l1 = 60000L; ; l1 = 5000L)
    {
      localHandler.postDelayed(localRunnable, l1);
      return;
      this.c.setVisibility(8);
      break;
      this.e.setVisibility(8);
      break label84;
      this.d.setVisibility(8);
      break label110;
      this.f.setVisibility(8);
      break label125;
      this.l.setDuration(600L);
      break label137;
    }
  }

  public void a()
  {
    this.g.clear();
    this.k.removeCallbacks(this.o);
    if (this.i)
      this.o.run();
  }

  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, Parcelable paramParcelable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Message localMessage = new Message(paramString1, paramString2, paramInt1, paramInt2, paramParcelable, paramBoolean2, paramBoolean3);
    if ((this.i) && (!paramBoolean1))
    {
      this.g.add(localMessage);
      return;
    }
    a(localMessage);
  }

  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, null, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramInt, 0, null, true, paramBoolean1, paramBoolean2);
  }

  private static class Message
    implements Parcelable
  {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator()
    {
      public MessageBar.Message a(Parcel paramAnonymousParcel)
      {
        return new MessageBar.Message(paramAnonymousParcel);
      }

      public MessageBar.Message[] a(int paramAnonymousInt)
      {
        return new MessageBar.Message[paramAnonymousInt];
      }
    };
    final int mActionIcon;
    final String mActionMessage;
    final boolean mLongDelay;
    final String mMessage;
    final int mMessageIcon;
    final boolean mShowProgress;
    final Parcelable mToken;

    public Message(Parcel paramParcel)
    {
      this.mMessage = paramParcel.readString();
      this.mActionMessage = paramParcel.readString();
      this.mActionIcon = paramParcel.readInt();
      this.mMessageIcon = paramParcel.readInt();
      int j;
      if (paramParcel.readInt() == i)
      {
        j = i;
        this.mLongDelay = j;
        if (paramParcel.readInt() != i)
          break label81;
      }
      while (true)
      {
        this.mShowProgress = i;
        this.mToken = paramParcel.readParcelable(null);
        return;
        j = 0;
        break;
        label81: i = 0;
      }
    }

    public Message(String paramString1, String paramString2, int paramInt1, int paramInt2, Parcelable paramParcelable)
    {
      this.mMessage = paramString1;
      this.mActionMessage = paramString2;
      this.mActionIcon = paramInt1;
      this.mMessageIcon = paramInt2;
      this.mToken = paramParcelable;
      this.mLongDelay = false;
      this.mShowProgress = false;
    }

    public Message(String paramString1, String paramString2, int paramInt1, int paramInt2, Parcelable paramParcelable, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mMessage = paramString1;
      this.mActionMessage = paramString2;
      this.mActionIcon = paramInt1;
      this.mMessageIcon = paramInt2;
      this.mToken = paramParcelable;
      this.mLongDelay = paramBoolean1;
      this.mShowProgress = paramBoolean2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.mMessage);
      paramParcel.writeString(this.mActionMessage);
      paramParcel.writeInt(this.mActionIcon);
      paramParcel.writeInt(this.mMessageIcon);
      int j;
      if (this.mLongDelay)
      {
        j = i;
        paramParcel.writeInt(j);
        if (!this.mShowProgress)
          break label78;
      }
      while (true)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.mToken, 0);
        return;
        j = 0;
        break;
        label78: i = 0;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(Parcelable paramParcelable);
  }

  private static class b extends b<MessageBar>
  {
    private b(MessageBar paramMessageBar)
    {
      super();
    }

    public void a(MessageBar paramMessageBar)
    {
      MessageBar.b(paramMessageBar).startAnimation(MessageBar.g(paramMessageBar));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.MessageBar
 * JD-Core Version:    0.6.2
 */