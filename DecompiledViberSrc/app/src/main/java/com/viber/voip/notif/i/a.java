package com.viber.voip.notif.i;

import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.cf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class a
  implements DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerPhoneState, CallHandler.CallInfoReadyListener
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private List<c> c = new ArrayList();

  private void a(final d paramd)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        a.b(a.this, paramd);
      }
    });
  }

  private void b(d paramd)
  {
    synchronized (this.c)
    {
      ArrayList localArrayList = new ArrayList(this.c);
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext())
        paramd.a((c)localIterator.next());
    }
  }

  public void a(c paramc)
  {
    synchronized (this.c)
    {
      this.c.add(paramc);
      ViberApplication.getInstance().getEngine(false).addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymousEngine)
        {
          int i = paramAnonymousEngine.getDialerController().getPhoneState();
          CallInfo localCallInfo = paramAnonymousEngine.getCurrentCall();
          if ((localCallInfo != null) && ((i == 3) || (i == 2)))
          {
            CallerInfo localCallerInfo = localCallInfo.getCallerInfo();
            final String str1 = localCallerInfo.getName();
            final String str2 = localCallerInfo.getPhoneNumber();
            final Uri localUri = localCallerInfo.getCallerPhoto();
            final ConferenceInfo localConferenceInfo = localCallerInfo.getConferenceInfo();
            a.a(a.this, new a.d()
            {
              public void a(a.c paramAnonymous2c)
              {
                paramAnonymous2c.onInProgressCall(str1, str2, localUri, localConferenceInfo);
              }
            });
          }
        }
      });
      return;
    }
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, final int paramInt1, int paramInt2)
  {
    if (this.b != null)
      a.a(this.b).b();
    a(new d()
    {
      public void a(a.c paramAnonymousc)
      {
        paramAnonymousc.onEndedCall(paramInt1);
      }
    });
  }

  public void onCallInfoReady(CallInfo paramCallInfo)
  {
    this.b = new a(paramCallInfo);
    paramCallInfo.getInCallState().addObserver(this.b);
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
  }

  public void onHangup()
  {
  }

  public void onPhoneStateChanged(int paramInt)
  {
  }

  private class a
    implements Runnable, Observer
  {
    private CallInfo b;
    private int c = -1;
    private cf d = new cf(av.a(av.e.e), this, 1000L);
    private boolean e;
    private boolean f;

    public a(CallInfo arg2)
    {
      Object localObject;
      this.b = localObject;
      a(localObject.getInCallState());
    }

    private long a()
    {
      OngoingConferenceCallModel localOngoingConferenceCallModel = ((ConferenceCallsRepository)ViberApplication.getInstance().getLazyConferenceCallsRepository().get()).getConferenceTalkingTo();
      if (localOngoingConferenceCallModel != null)
        return Math.max(System.currentTimeMillis() - localOngoingConferenceCallModel.startTimeMillis, 0L);
      return this.b.getInCallState().getCallStats().getCallDuration();
    }

    private void a(InCallState paramInCallState)
    {
      int i = paramInCallState.getState();
      final String str1;
      final String str2;
      final Uri localUri;
      final ConferenceInfo localConferenceInfo;
      if (this.c != i)
      {
        this.c = i;
        CallerInfo localCallerInfo = this.b.getCallerInfo();
        str1 = localCallerInfo.getName();
        str2 = localCallerInfo.getPhoneNumber();
        localUri = localCallerInfo.getCallerPhoto();
        localConferenceInfo = localCallerInfo.getConferenceInfo();
      }
      switch (i)
      {
      case 1:
      case 4:
      case 7:
      case 9:
      default:
        return;
      case 5:
        a.a(a.this, new a.d()
        {
          public void a(a.c paramAnonymousc)
          {
            paramAnonymousc.onIncomingCall(str1, str2, localUri, a.a.b(a.a.this).isViberIn(), a.a.b(a.a.this).isIncomingVideoCall(), localConferenceInfo);
          }
        });
        return;
      case 6:
        a.a(a.this, new a.d()
        {
          public void a(a.c paramAnonymousc)
          {
            paramAnonymousc.onOutgoingCall(str1, str2, localUri, localConferenceInfo);
          }
        });
        return;
      case 2:
      case 3:
        a.a(a.this, new a.d()
        {
          public void a(a.c paramAnonymousc)
          {
            paramAnonymousc.onInProgressCall(str1, str2, localUri, localConferenceInfo);
          }
        });
        this.d.a();
        return;
      case 8:
        a.a(a.this, new a.d()
        {
          public void a(a.c paramAnonymousc)
          {
            paramAnonymousc.onEndingCall();
          }
        });
        return;
      case 10:
        final int j = paramInCallState.getEndReason();
        final int k = paramInCallState.getDisconnectStatus();
        a.a(a.this, new a.d()
        {
          public void a(a.c paramAnonymousc)
          {
            paramAnonymousc.onFailedCall(j, k);
          }
        });
        return;
      case 0:
      }
      this.d.b();
      a.a(a.this, new a.d()
      {
        public void a(a.c paramAnonymousc)
        {
          paramAnonymousc.onIdleCall();
        }
      });
    }

    public void run()
    {
      InCallState localInCallState = this.b.getInCallState();
      int i = localInCallState.getState();
      final long l;
      if ((i == 3) || (i == 2))
      {
        l = a();
        if (((!localInCallState.isHoldEnabled()) || (!localInCallState.isHoldInitiator())) && (!localInCallState.isPeerOnHold()))
          break label149;
      }
      label149: for (final boolean bool = true; ; bool = false)
      {
        if (this.e != bool)
        {
          this.e = bool;
          a.a(a.this, new a.d()
          {
            public void a(a.c paramAnonymousc)
            {
              paramAnonymousc.onHold(bool);
            }
          });
        }
        if (this.f != localInCallState.isDataInterrupted())
        {
          this.f = localInCallState.isDataInterrupted();
          a.a(a.this, new a.d()
          {
            public void a(a.c paramAnonymousc)
            {
              paramAnonymousc.onReconnecting(a.a.c(a.a.this));
            }
          });
        }
        if ((!this.e) && (!this.f))
          a.a(a.this, new a.d()
          {
            public void a(a.c paramAnonymousc)
            {
              paramAnonymousc.onChronometerTick(l);
            }
          });
        return;
      }
    }

    public void update(Observable paramObservable, Object paramObject)
    {
      a((InCallState)paramObject);
    }
  }

  public static class b
    implements a.c
  {
    public void onChronometerTick(long paramLong)
    {
    }

    public void onEndedCall(int paramInt)
    {
    }

    public void onEndingCall()
    {
    }

    public void onFailedCall(int paramInt1, int paramInt2)
    {
    }

    public void onHold(boolean paramBoolean)
    {
    }

    public void onIdleCall()
    {
    }

    public void onInProgressCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
    {
    }

    public void onIncomingCall(String paramString1, String paramString2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, ConferenceInfo paramConferenceInfo)
    {
    }

    public void onOutgoingCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
    {
    }

    public void onReconnecting(boolean paramBoolean)
    {
    }
  }

  public static abstract interface c
  {
    public abstract void onChronometerTick(long paramLong);

    public abstract void onEndedCall(int paramInt);

    public abstract void onEndingCall();

    public abstract void onFailedCall(int paramInt1, int paramInt2);

    public abstract void onHold(boolean paramBoolean);

    public abstract void onIdleCall();

    public abstract void onInProgressCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo);

    public abstract void onIncomingCall(String paramString1, String paramString2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, ConferenceInfo paramConferenceInfo);

    public abstract void onOutgoingCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo);

    public abstract void onReconnecting(boolean paramBoolean);
  }

  private static abstract interface d
  {
    public abstract void a(a.c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.a
 * JD-Core Version:    0.6.2
 */