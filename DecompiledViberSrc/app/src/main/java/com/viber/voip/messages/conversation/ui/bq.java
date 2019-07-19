package com.viber.voip.messages.conversation.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.string;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.cj;
import com.viber.voip.widget.c.a;
import com.viber.voip.widget.c.a.a;
import com.viber.voip.widget.c.b;
import java.util.concurrent.TimeUnit;

public class bq extends bv.t
{
  private bv a;
  private GroupController b;
  private PhoneController c;
  private View d;
  private PublicAccount e;
  private int f = -1;
  private a g = a.a;

  public bq(bv parambv, GroupController paramGroupController, PhoneController paramPhoneController, View paramView)
  {
    this.a = parambv;
    this.b = paramGroupController;
    this.c = paramPhoneController;
    this.d = paramView;
  }

  private boolean a(boolean paramBoolean, PublicAccount paramPublicAccount)
  {
    if (this.g != a.a);
    PublicAccount localPublicAccount;
    do
    {
      do
        return false;
      while (!cj.a(true));
      localPublicAccount = new PublicAccount(paramPublicAccount);
      localPublicAccount.setIsPublished(paramBoolean);
    }
    while (paramPublicAccount.equalsBetweenAttributesChangedFlags(localPublicAccount));
    if (paramBoolean);
    for (a locala = a.b; ; locala = a.c)
    {
      this.g = locala;
      this.a.a(this);
      this.f = this.c.generateSequence();
      int i = paramPublicAccount.diffBetweenAttributesChangedFlags(localPublicAccount);
      this.b.a(this.f, i, localPublicAccount);
      return true;
    }
  }

  public void a(PublicAccount paramPublicAccount)
  {
    if (a(true, paramPublicAccount))
      this.e = paramPublicAccount;
  }

  public void onPublicGroupInfoChanged(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (this.f == paramInt1)
    {
      this.f = -1;
      if ((1 == paramInt2) && (this.g == a.b))
      {
        this.e.setIsPublished(true);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            a.a(bq.a(bq.this), bq.a(bq.this).getResources().getString(R.string.published), new a.a()
            {
              public void a(Parcelable paramAnonymous2Parcelable)
              {
                bq.a(bq.this, false, bq.b(bq.this));
              }
            }
            , new b(-1, R.string.undo, TimeUnit.SECONDS.toMillis(3L), 0));
          }
        });
      }
      this.g = a.a;
      this.a.b(this);
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bq
 * JD-Core Version:    0.6.2
 */