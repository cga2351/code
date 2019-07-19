package com.viber.voip.block;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.apps.AppsBlockerListener;
import com.viber.jni.apps.AppsController;
import com.viber.jni.apps.AppsControllerDelegate.Blocker;
import com.viber.jni.block.BlockController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CMessageReceivedAckMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.action.BlockPublicGroupAction;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ba;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.onepf.oms.util.CollectionUtils;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile b b;
  private k c;
  private a d;
  private Engine e;
  private h f;
  private Handler g = av.a(av.e.f);
  private SparseArray<a.d> h = new SparseArray();
  private boolean i = true;
  private final ConnectionDelegate j = new ConnectionDelegate()
  {
    public void onConnect()
    {
      if (b.a(b.this))
      {
        b.a(b.this, false);
        List localList = b.b(b.this).b();
        if (!CollectionUtils.isEmpty(localList))
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            a.d locald = (a.d)localIterator.next();
            if (locald.b)
              b.a(b.this, locald.a, locald.c);
            else
              b.b(b.this, locald.a, locald.c);
          }
        }
      }
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };
  private final AppsControllerDelegate.Blocker k = new AppsControllerDelegate.Blocker()
  {
    public void onBlockAppReply(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.d locald = (a.d)b.c(b.this).get(paramAnonymousInt2);
      if (locald == null)
        return;
      b.c(b.this).remove(paramAnonymousInt2);
      switch (paramAnonymousInt1)
      {
      case 0:
      default:
        if (locald.b)
        {
          b.b(b.this).b(locald.a, paramAnonymousInt2);
          return;
        }
        break;
      case 13:
        b.a(b.this, true);
        return;
      }
      b.b(b.this).a(locald.a, paramAnonymousInt2);
    }
  };

  private b()
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    this.c = new l();
    this.d = new a();
    this.e = localViberApplication.getEngine(false);
    this.f = UserManager.from(ViberApplication.getApplication()).getAppsController();
    this.e.getDelegatesManager().getConnectionListener().registerDelegate(this.j, this.g);
    this.e.getDelegatesManager().getAppsBlockerListener().registerDelegate(this.k, this.g);
  }

  @Deprecated
  public static b a()
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new b();
      return b;
    }
    finally
    {
    }
  }

  public static boolean a(Engine paramEngine, String paramString, long paramLong)
  {
    try
    {
      boolean bool1 = new FormattedMessage(paramString).canDoAction(ActionType.BLOCK_PUBLIC_GROUP);
      boolean bool2 = false;
      if (bool1)
      {
        paramEngine.getExchanger().handleCMessageReceivedAckMsg(new CMessageReceivedAckMsg(paramLong, 0, (short)0, 0, "", m.a(0, 0)));
        bool2 = true;
      }
      return bool2;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  private void c(final int paramInt1, final int paramInt2)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        List localList = Collections.singletonList(Integer.valueOf(paramInt1));
        b.e(b.this).a(localList, true, new h.a()
        {
          public void onAppInfoFailed()
          {
          }

          public void onAppInfoReady(List<com.viber.voip.apps.b> paramAnonymous2List, boolean paramAnonymous2Boolean)
          {
            Iterator localIterator = paramAnonymous2List.iterator();
            while (localIterator.hasNext())
            {
              com.viber.voip.apps.b localb = (com.viber.voip.apps.b)localIterator.next();
              if (localb.a() == b.8.this.a)
              {
                int i = b.d(b.this).getPhoneController().generateSequence();
                a.d locald = new a.d(b.8.this.a, true, b.8.this.b);
                b.c(b.this).put(i, locald);
                b.b(b.this).a(b.8.this.a, localb.c(), b.8.this.b, i);
                b.d(b.this).getAppsController().handleBlockApp(b.8.this.a, true, i, b.8.this.b);
              }
            }
          }
        });
      }
    });
  }

  private void d(final int paramInt1, final int paramInt2)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        int i = b.d(b.this).getPhoneController().generateSequence();
        a.d locald = new a.d(paramInt1, false, paramInt2);
        b.c(b.this).put(i, locald);
        b.b(b.this).a(paramInt1, paramInt2, i);
        b.d(b.this).getAppsController().handleBlockApp(paramInt1, false, i, paramInt2);
      }
    });
  }

  public void a(int paramInt)
  {
    a(paramInt, 0);
  }

  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }

  public void a(final int paramInt, final a parama)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        boolean bool = b.b(b.this).b(paramInt);
        parama.a(bool);
      }
    });
  }

  public void a(final long paramLong)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        int i = b.d(b.this).getPhoneController().generateSequence();
        b.b(b.this).a(paramLong, i);
        b.d(b.this).getBlockController().handleBlockGroupInvite(paramLong, false, i);
      }
    });
  }

  public void a(final long paramLong, a parama)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        boolean bool = b.b(b.this).a(paramLong);
        this.b.a(bool);
      }
    });
  }

  public void a(final long paramLong, String paramString1, final String paramString2)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        int i = b.d(b.this).getPhoneController().generateSequence();
        b.b(b.this).a(paramLong, paramString2, this.c, i);
        b.d(b.this).getBlockController().handleBlockGroupInvite(paramLong, true, i);
      }
    });
  }

  public void a(final Context paramContext, final int paramInt, final String paramString, final Runnable paramRunnable)
  {
    if (m.i(paramInt))
      a(paramInt, new a()
      {
        public void a(final boolean paramAnonymousBoolean)
        {
          av.a(av.e.a).post(new Runnable()
          {
            public void run()
            {
              if ((paramAnonymousBoolean) || (!d.r.B.d()))
              {
                localba = new ViberDialogHandlers.ba();
                localba.a = b.2.this.a;
                localba.b = b.2.this.b;
                localba.c = paramAnonymousBoolean;
                localContext1 = b.2.this.c;
                i = R.string.dialog_424_title;
                arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = b.2.this.d;
                str = localContext1.getString(i, arrayOfObject1);
                localContext2 = b.2.this.c;
                j = R.string.dialog_424_message;
                arrayOfObject2 = new Object[2];
                arrayOfObject2[0] = b.2.this.d;
                arrayOfObject2[1] = b.2.this.d;
                t.a(str, localContext2.getString(j, arrayOfObject2)).a(localba).a(b.2.this.c);
              }
              while (b.2.this.a == null)
              {
                ViberDialogHandlers.ba localba;
                Context localContext1;
                int i;
                Object[] arrayOfObject1;
                String str;
                Context localContext2;
                int j;
                Object[] arrayOfObject2;
                return;
              }
              b.2.this.a.run();
            }
          });
        }
      });
  }

  public void a(BlockPublicGroupAction paramBlockPublicGroupAction)
  {
    a(paramBlockPublicGroupAction.getGroupId(), paramBlockPublicGroupAction.getGroupName(), paramBlockPublicGroupAction.getImageId());
  }

  public k b()
  {
    return this.c;
  }

  public void b(int paramInt)
  {
    b(paramInt, 0);
  }

  public void b(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2);
  }

  public void c()
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        b.b(b.this).a();
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.b
 * JD-Core Version:    0.6.2
 */