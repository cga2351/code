package com.viber.voip.messages.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.messenger.DeleteMessageListener;
import com.viber.jni.messenger.MessengerDelegate.DeleteMessages;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.c.c;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class a
  implements c
{
  private int a;
  private int b;
  private int c;
  private final int d;
  private final int e;
  private QuotedMessageData f;
  private int g;
  private int h;
  private boolean i;
  private View j;
  private View k;
  private e l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private View p;
  private RelativeLayout.LayoutParams q;
  private View r;
  private View s;
  private final com.viber.voip.messages.c.a t;
  private final Resources u;
  private final ai v;
  private final com.viber.voip.messages.d.b w;
  private final View.OnClickListener x = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      a.this.b();
    }
  };
  private final MessengerDelegate.DeleteMessages y = new MessengerDelegate.DeleteMessages()
  {
    public void onDeleteMessageReply(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.a(a.this, paramAnonymousLong);
    }

    public boolean onDeletedGroupMessage(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
    {
      a.a(a.this, paramAnonymousLong2);
      return false;
    }

    public boolean onDeletedMessage(String paramAnonymousString, long paramAnonymousLong)
    {
      a.a(a.this, paramAnonymousLong);
      return true;
    }
  };
  private com.viber.voip.util.e.h.a z = new com.viber.voip.util.e.h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      int i;
      int j;
      label64: RelativeLayout.LayoutParams localLayoutParams2;
      if ((a.a(a.this) != null) && (a.b(a.this) != null))
      {
        if ((a.a(a.this).getType() != 5) || (paramAnonymousBoolean))
          break label119;
        i = 1;
        RelativeLayout.LayoutParams localLayoutParams1 = a.b(a.this);
        if (i == 0)
          break label125;
        j = a.c(a.this);
        localLayoutParams1.width = j;
        localLayoutParams2 = a.b(a.this);
        if (i == 0)
          break label137;
      }
      label137: for (int k = a.e(a.this); ; k = a.d(a.this))
      {
        localLayoutParams2.height = k;
        a.f(a.this).setLayoutParams(a.b(a.this));
        return;
        label119: i = 0;
        break;
        label125: j = a.d(a.this);
        break label64;
      }
    }
  };

  public a(View paramView, com.viber.voip.messages.c.a parama, ai paramai, com.viber.voip.messages.d.b paramb)
  {
    this.k = paramView;
    this.v = paramai;
    this.w = paramb;
    this.l = e.a(paramView.getContext());
    this.t = parama;
    this.u = paramView.getResources();
    Context localContext = paramView.getContext();
    this.d = dc.a(localContext, R.attr.conversationReplyBannerDefaultThumbnail);
    this.e = dc.a(localContext, R.attr.conversationReplyBannerDefaultContactThumbnail);
    DeleteMessageListener localDeleteMessageListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getDeleteMessageListener();
    MessengerDelegate.DeleteMessages[] arrayOfDeleteMessages = new MessengerDelegate.DeleteMessages[1];
    arrayOfDeleteMessages[0] = this.y;
    localDeleteMessageListener.registerDelegate(arrayOfDeleteMessages);
  }

  private void a(long paramLong)
  {
    if ((this.f != null) && (paramLong == this.f.getToken()) && (a()))
    {
      p.b().d();
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          a.this.b();
        }
      });
    }
  }

  private void a(QuotedMessageData paramQuotedMessageData)
  {
    int i1 = paramQuotedMessageData.getType();
    String str = paramQuotedMessageData.getSenderName();
    CharSequence localCharSequence = com.viber.voip.messages.c.b.a(this.u, paramQuotedMessageData, this.v, this.w, this.g, this.h, true, false);
    this.o.setText(str);
    this.n.setText(localCharSequence);
    if (i1 == 0)
    {
      this.n.setTypeface(null, 0);
      return;
    }
    this.n.setTypeface(null, 2);
  }

  private void b(QuotedMessageData paramQuotedMessageData)
  {
    int i1 = paramQuotedMessageData.getType();
    boolean bool1 = com.viber.voip.messages.c.b.a(paramQuotedMessageData);
    dj.b(this.j.findViewById(R.id.message_thumb), bool1);
    View localView = this.p;
    if (i1 == 3);
    for (boolean bool2 = true; ; bool2 = false)
    {
      dj.b(localView, bool2);
      if (bool1)
        break;
      return;
    }
    Uri localUri = com.viber.voip.messages.c.b.a(i1, this.f, true);
    e locale = this.l;
    ImageView localImageView = this.m;
    if (i1 == 9);
    for (int i2 = this.e; ; i2 = this.d)
    {
      locale.b(localUri, localImageView, f.b(i2), this.z);
      return;
    }
  }

  private void h()
  {
    if (this.f == null)
      return;
    if (this.j == null)
    {
      this.j = ((ViewStub)this.k.findViewById(R.id.reply_banner_stub)).inflate();
      this.m = ((ImageView)this.j.findViewById(R.id.message_thumb));
      this.n = ((TextView)this.j.findViewById(R.id.message_body));
      this.o = ((TextView)this.j.findViewById(R.id.author_name));
      this.p = this.j.findViewById(R.id.video_play_icon);
      this.j.findViewById(R.id.close_button).setOnClickListener(this.x);
      this.a = this.u.getDimensionPixelOffset(R.dimen.reply_banner_default_thumb_width);
      this.c = this.u.getDimensionPixelOffset(R.dimen.reply_banner_location_thumb_width);
      this.b = this.u.getDimensionPixelOffset(R.dimen.reply_banner_location_thumb_height);
      this.q = new RelativeLayout.LayoutParams(this.a, this.a);
      this.q.addRule(15);
      this.q.setMargins(0, 0, this.u.getDimensionPixelOffset(R.dimen.reply_banner_thumb_right_margin), 0);
    }
    dj.b(this.j, true);
    b(this.f);
    a(this.f);
  }

  private void i()
  {
    View localView1 = this.k.findViewById(R.id.remote_banner_container);
    View localView2 = this.k.findViewById(R.id.public_group_share_banner_area);
    if ((localView1 != null) && (localView1.getVisibility() == 0))
    {
      dj.b(localView1, false);
      this.r = localView1;
    }
    if ((localView2 != null) && (localView2.getVisibility() == 0))
    {
      dj.b(localView2, false);
      this.s = localView2;
    }
  }

  public void a(int paramInt)
  {
    if (a())
      this.j.setVisibility(paramInt);
  }

  public void a(QuotedMessageData paramQuotedMessageData, int paramInt1, int paramInt2)
  {
    this.f = paramQuotedMessageData;
    this.i = true;
    this.g = paramInt1;
    this.h = paramInt2;
    this.t.a();
    h();
    i();
  }

  public boolean a()
  {
    return this.i;
  }

  public void b()
  {
    if (this.i)
    {
      this.i = false;
      this.f = null;
      dj.b(this.j, false);
      if (this.r != null)
      {
        dj.b(this.r, true);
        this.r = null;
      }
      if (this.s != null)
      {
        dj.b(this.s, true);
        this.s = null;
      }
      this.t.b();
    }
  }

  public Quote c()
  {
    if (this.f != null)
      return com.viber.voip.messages.c.b.a(this.f, this.g);
    return null;
  }

  public int d()
  {
    if (a())
      return R.string.composer_text_reply_hint;
    return 0;
  }

  public QuotedMessageData e()
  {
    return this.f;
  }

  public void f()
  {
    ViberApplication.getInstance().getEngine(false).getDelegatesManager().getDeleteMessageListener().removeDelegate(this.y);
  }

  public void g()
  {
    i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.c.a.a
 * JD-Core Version:    0.6.2
 */