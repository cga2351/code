package com.viber.voip.publicaccount.d;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import com.viber.common.dialogs.h.a;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.r;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.widget.c.a;
import com.viber.voip.widget.c.a.a;
import java.util.concurrent.TimeUnit;

public class b
  implements bv.r
{
  private ConversationItemLoaderEntity a;
  private final bv b;
  private final k c;
  private final View d;

  public b(View paramView)
  {
    this.d = paramView;
    this.b = o.a();
    this.c = ViberApplication.getInstance().getMessagesManager();
  }

  private void b(final String paramString)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        String str = ViberApplication.getLocalizedResources().getString(R.string.public_account_you_subscribed);
        a.a(b.a(b.this), str, new a.a()
        {
          public void a(Parcelable paramAnonymous2Parcelable)
          {
            b.a(b.this, b.1.this.a);
          }
        }
        , new com.viber.voip.widget.c.b(-1, R.string.undo, TimeUnit.SECONDS.toMillis(3L), 0));
      }
    });
  }

  private void c(String paramString)
  {
    if (ViberApplication.getInstance().getEngine(false).getPhoneController().isConnected())
    {
      this.c.h().a(paramString, false);
      return;
    }
    f.d().d();
  }

  public void a()
  {
    this.b.b(this);
    this.a = null;
  }

  public void a(long paramLong)
  {
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.a = paramConversationItemLoaderEntity;
    this.b.a(this);
  }

  public void a(String paramString)
  {
    if ((this.a != null) && (paramString.equals(this.a.getPublicAccountId())))
      b(paramString);
  }

  public void a(String paramString, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.b
 * JD-Core Version:    0.6.2
 */