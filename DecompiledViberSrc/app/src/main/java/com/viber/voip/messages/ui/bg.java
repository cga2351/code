package com.viber.voip.messages.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.registration.ao;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import dagger.a;
import java.util.Collections;

public class bg extends bc
{
  private static final Logger g = ViberEnv.getLogger();
  private String h;
  private boolean i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;

  public bg(Activity paramActivity, ContextMenu paramContextMenu, int paramInt, Uri paramUri, boolean paramBoolean, j paramj)
  {
    this(paramActivity, paramContextMenu, paramInt, paramUri, paramBoolean, paramj, 57, 38, 76, R.id.menu_empty, R.id.menu_message_call, R.id.menu_message_send, R.id.menu_viber_out_call, R.id.menu_invite_viber, R.id.menu_message_add);
  }

  public bg(Activity paramActivity, ContextMenu paramContextMenu, int paramInt1, Uri paramUri, boolean paramBoolean, j paramj, final int paramInt2, final int paramInt3, final int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: aload 6
    //   6: invokespecial 55	com/viber/voip/messages/ui/bc:<init>	(Landroid/app/Activity;Landroid/view/ContextMenu;ILcom/viber/voip/messages/conversation/ui/j;)V
    //   9: aload_0
    //   10: aload 4
    //   12: invokevirtual 61	android/net/Uri:getSchemeSpecificPart	()Ljava/lang/String;
    //   15: putfield 63	com/viber/voip/messages/ui/bg:h	Ljava/lang/String;
    //   18: aload_0
    //   19: iload 5
    //   21: putfield 65	com/viber/voip/messages/ui/bg:i	Z
    //   24: aload_0
    //   25: iload 10
    //   27: putfield 67	com/viber/voip/messages/ui/bg:j	I
    //   30: aload_0
    //   31: iload 11
    //   33: putfield 69	com/viber/voip/messages/ui/bg:k	I
    //   36: aload_0
    //   37: iload 12
    //   39: putfield 71	com/viber/voip/messages/ui/bg:l	I
    //   42: aload_0
    //   43: iload 13
    //   45: putfield 73	com/viber/voip/messages/ui/bg:m	I
    //   48: aload_0
    //   49: iload 14
    //   51: putfield 75	com/viber/voip/messages/ui/bg:n	I
    //   54: aload_0
    //   55: iload 15
    //   57: putfield 77	com/viber/voip/messages/ui/bg:o	I
    //   60: aload_0
    //   61: invokevirtual 81	com/viber/voip/messages/ui/bg:a	()Landroid/view/View;
    //   64: pop
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 67	com/viber/voip/messages/ui/bg:j	I
    //   70: new 83	com/viber/voip/messages/ui/bg$1
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 86	com/viber/voip/messages/ui/bg$1:<init>	(Lcom/viber/voip/messages/ui/bg;)V
    //   78: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 69	com/viber/voip/messages/ui/bg:k	I
    //   86: new 91	com/viber/voip/messages/ui/bg$2
    //   89: dup
    //   90: aload_0
    //   91: iload 7
    //   93: invokespecial 94	com/viber/voip/messages/ui/bg$2:<init>	(Lcom/viber/voip/messages/ui/bg;I)V
    //   96: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 71	com/viber/voip/messages/ui/bg:l	I
    //   104: new 96	com/viber/voip/messages/ui/bg$d
    //   107: dup
    //   108: aload_0
    //   109: aconst_null
    //   110: invokespecial 99	com/viber/voip/messages/ui/bg$d:<init>	(Lcom/viber/voip/messages/ui/bg;Lcom/viber/voip/messages/ui/bg$1;)V
    //   113: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   116: aload_0
    //   117: aload_0
    //   118: getfield 73	com/viber/voip/messages/ui/bg:m	I
    //   121: new 101	com/viber/voip/messages/ui/bg$3
    //   124: dup
    //   125: aload_0
    //   126: iload 8
    //   128: invokespecial 102	com/viber/voip/messages/ui/bg$3:<init>	(Lcom/viber/voip/messages/ui/bg;I)V
    //   131: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 75	com/viber/voip/messages/ui/bg:n	I
    //   139: new 104	com/viber/voip/messages/ui/bg$a
    //   142: dup
    //   143: aload_0
    //   144: aconst_null
    //   145: invokespecial 105	com/viber/voip/messages/ui/bg$a:<init>	(Lcom/viber/voip/messages/ui/bg;Lcom/viber/voip/messages/ui/bg$1;)V
    //   148: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 77	com/viber/voip/messages/ui/bg:o	I
    //   156: new 107	com/viber/voip/messages/ui/bg$4
    //   159: dup
    //   160: aload_0
    //   161: iload 9
    //   163: invokespecial 108	com/viber/voip/messages/ui/bg$4:<init>	(Lcom/viber/voip/messages/ui/bg;I)V
    //   166: invokevirtual 89	com/viber/voip/messages/ui/bg:a	(ILcom/viber/voip/messages/ui/bc$b;)V
    //   169: aload_0
    //   170: invokespecial 111	com/viber/voip/messages/ui/bg:b	()V
    //   173: return
  }

  private void b()
  {
    this.b.findItem(this.k).setVisible(false);
    this.b.findItem(this.l).setVisible(false);
    this.b.findItem(this.m).setVisible(false);
    this.b.findItem(this.n).setVisible(false);
    this.b.findItem(this.o).setVisible(false);
    dr.a(this.h, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, final int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, final com.viber.voip.model.entity.g paramAnonymousg)
      {
        if ((2 == paramAnonymousInt) || (4 == paramAnonymousInt))
          paramAnonymousg = ViberApplication.getInstance().getContactManager().c().a(paramAnonymousParticipant.getNumber());
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            MenuItem localMenuItem = bg.this.b.findItem(bg.a(bg.this));
            if (localMenuItem == null);
            while (true)
            {
              return;
              localMenuItem.setVisible(false);
              if ((paramAnonymousg == null) || (!paramAnonymousg.p()))
              {
                bg.this.b.findItem(bg.b(bg.this)).setVisible(true);
                if ((1 == paramAnonymousInt) || (7 == paramAnonymousInt) || (paramAnonymousg != null))
                  bg.this.b.findItem(bg.c(bg.this)).setVisible(true);
              }
              while (((paramAnonymousg == null) || (paramAnonymousg.getId() <= 0L)) && (!ao.f()))
              {
                bg.this.b.findItem(bg.f(bg.this)).setVisible(true);
                return;
                bg.this.b.findItem(bg.d(bg.this)).setVisible(true);
                bg.this.b.findItem(bg.e(bg.this)).setVisible(true);
              }
            }
          }
        });
      }
    });
  }

  protected View a()
  {
    View localView = super.a();
    ((TextView)localView.findViewById(R.id.text)).setText(this.h);
    return localView;
  }

  private class a
    implements bc.b
  {
    private a()
    {
    }

    public void a()
    {
      bg.this.b.add(0, bg.c(bg.this), 0, R.string.invite_banner_btn_text);
    }

    public void a(j paramj)
    {
      ViberActionRunner.af.a(bg.this.a, Collections.singletonList(bg.g(bg.this)));
    }
  }

  private abstract class b
    implements bc.c
  {
    private b()
    {
    }

    public void a()
    {
      bg.this.b.add(0, bg.f(bg.this), 0, R.string.add_to_contacts);
    }

    public void a(j paramj)
    {
      j.a(bg.this.a, bg.g(bg.this));
    }

    public String[] b()
    {
      return n.k;
    }
  }

  private abstract class c
    implements bc.c
  {
    private c()
    {
    }

    public void a()
    {
      bg.this.b.add(0, bg.d(bg.this), 0, R.string.menu_call);
    }

    public void a(j paramj)
    {
      CallInitiationId.noteNextCallInitiationAttemptId();
      h localh = (h)ViberApplication.getInstance().getLazyUserStartsCallEventCollector().get();
      h.a.a locala = h.a.i();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = bg.g(bg.this);
      localh.b(locala.a(arrayOfString).b("Free Audio 1-On-1 Call").a("Message Info Popup").a(true).a());
      ViberApplication.getInstance().getEngine(true).getCallHandler().setNextCallIsFromSecretConversation(bg.h(bg.this));
      ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(bg.g(bg.this), false);
    }

    public String[] b()
    {
      return n.h;
    }
  }

  private class d
    implements bc.b
  {
    private d()
    {
    }

    public void a()
    {
      bg.this.b.add(0, bg.e(bg.this), 0, R.string.message);
    }

    public void a(j paramj)
    {
      j.b(bg.this.a, bg.g(bg.this));
    }
  }

  private abstract class e
    implements bc.c
  {
    private e()
    {
    }

    public void a()
    {
      bg.this.b.add(0, bg.b(bg.this), 0, R.string.menu_viber_out_call);
    }

    public void a(j paramj)
    {
      CallInitiationId.noteNextCallInitiationAttemptId();
      h localh = (h)ViberApplication.getInstance().getLazyUserStartsCallEventCollector().get();
      h.a.a locala = h.a.i();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = bg.g(bg.this);
      localh.b(locala.a(arrayOfString).b("Viber Out").a("Message Info Popup").b(true).a());
      ViberApplication.getInstance().getEngine(true).getCallHandler().setNextCallIsFromSecretConversation(bg.h(bg.this));
      ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(bg.g(bg.this));
    }

    public String[] b()
    {
      return n.h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bg
 * JD-Core Version:    0.6.2
 */