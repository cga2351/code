package com.viber.voip.q;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegate;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.i.a.b;
import com.viber.voip.notif.i.a.c;
import com.viber.voip.p.e;
import com.viber.voip.p.e.a;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.sound.ptt.AudioPlayer;
import com.viber.voip.sound.ptt.PttFactory;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final EventBus b;
  private final com.viber.voip.p.c c;
  private final dagger.a<ISoundService> d;
  private final Context e;
  private AudioPlayer f;
  private volatile boolean g;
  private final h h = new h()
  {
    public void a(String paramAnonymousString, int paramAnonymousInt)
    {
      f.b(f.this);
    }

    public void a(String paramAnonymousString, long paramAnonymousLong)
    {
      f.a(f.this);
    }

    public void b(String paramAnonymousString, long paramAnonymousLong)
    {
      f.b(f.this);
    }

    public void c(String paramAnonymousString, long paramAnonymousLong)
    {
      f.a(f.this);
    }
  };
  private final m i = new m()
  {
    public void a()
    {
      f.a(f.this, true);
    }

    public void a(int paramAnonymousInt)
    {
      f.a(f.this, false);
    }

    public void a(MessageEntity paramAnonymousMessageEntity)
    {
      f.a(f.this, false);
    }

    public void b()
    {
      f.a(f.this, false);
    }
  };
  private final com.viber.voip.u.c j = new com.viber.voip.u.c()
  {
    public void a()
    {
      f.a(f.this, true);
    }

    public void a(int paramAnonymousInt)
    {
      f.a(f.this, false);
    }

    public void a(MessageEntity paramAnonymousMessageEntity)
    {
      f.a(f.this, false);
    }

    public void b()
    {
      f.a(f.this, false);
    }
  };
  private final PhoneControllerDelegate k = new PhoneControllerDelegateAdapter()
  {
    public void onGSMStateChange(int paramAnonymousInt, String paramAnonymousString)
    {
      switch (paramAnonymousInt)
      {
      default:
        return;
      case 1:
      }
      f.this.a(1);
    }
  };
  private final a.c l = new a.b()
  {
    public void onIncomingCall(String paramAnonymousString1, String paramAnonymousString2, Uri paramAnonymousUri, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, ConferenceInfo paramAnonymousConferenceInfo)
    {
      f.this.a(1);
    }

    public void onOutgoingCall(String paramAnonymousString1, String paramAnonymousString2, Uri paramAnonymousUri, ConferenceInfo paramAnonymousConferenceInfo)
    {
      f.this.a(1);
    }
  };
  private final e.a m = new e.a()
  {
    public void onProximityChanged(boolean paramAnonymousBoolean)
    {
      f localf = f.this;
      if (!paramAnonymousBoolean);
      for (boolean bool = true; ; bool = false)
      {
        f.b(localf, bool);
        return;
      }
    }
  };

  public f(EventBus paramEventBus, dagger.a<ISoundService> parama, EngineDelegatesManager paramEngineDelegatesManager, com.viber.voip.notif.i.a parama1, Context paramContext)
  {
    this.b = paramEventBus;
    this.d = parama;
    this.e = paramContext;
    this.c = new e(paramContext, this.m);
    PhoneControllerDelegate[] arrayOfPhoneControllerDelegate = new PhoneControllerDelegate[1];
    arrayOfPhoneControllerDelegate[0] = this.k;
    paramEngineDelegatesManager.registerDelegate(arrayOfPhoneControllerDelegate);
    parama1.a(this.l);
    this.b.register(this.h);
    this.b.register(this.i);
    this.b.register(this.j);
  }

  private void a(boolean paramBoolean)
  {
    if (!c())
      return;
    ((ISoundService)this.d.get()).setSpeakerphoneOn(paramBoolean);
    this.f.switchStreams(paramBoolean);
  }

  private void g()
  {
    if (this.c.a())
    {
      ((ISoundService)this.d.get()).preparePttAudioRoute();
      this.c.b();
    }
  }

  private void h()
  {
    if (this.c.a())
    {
      ((ISoundService)this.d.get()).cleanupAudioRoute();
      this.c.c();
    }
  }

  public void a()
  {
    if (!c())
      return;
    this.f.pause();
  }

  public void a(int paramInt)
  {
    if (!c())
      return;
    this.f.interruptPlay(paramInt);
  }

  public void a(long paramLong)
  {
    if (!d())
      return;
    this.f.resume(paramLong);
  }

  public void a(h paramh)
  {
    this.b.register(paramh);
  }

  public void a(String paramString, long paramLong)
  {
    ISoundService localISoundService = (ISoundService)this.d.get();
    if ((localISoundService.isGSMCallActive()) || (localISoundService.isViberCallActive()))
    {
      this.b.post(g.a(paramString, 4));
      return;
    }
    if (this.g)
    {
      this.b.post(g.a(paramString, 5));
      return;
    }
    if (!e())
      this.f.interruptPlay(1);
    int n;
    if ((localISoundService.getBluetoothCtl().isHeadsetConnected()) && (!localISoundService.getPlatformAudioManager().isBluetoothA2dpOn()))
    {
      n = 1;
      if (n == 0)
        break label243;
    }
    label243: for (int i1 = 0; ; i1 = 3)
    {
      Uri localUri = dx.i(paramString);
      File localFile = null;
      if (localUri != null)
        localFile = new File(localUri.getPath());
      if (((localFile == null) || (!localFile.exists())) && (localUri != null))
        localFile = dv.w.b(this.e, localUri.getPath());
      if ((localFile == null) || (!localFile.exists()))
        localFile = dv.y.b(this.e, paramString);
      this.f = PttFactory.createPttPlayer(this.b, paramString, localFile, i1);
      this.f.startPlay(paramLong);
      return;
      n = 0;
      break;
    }
  }

  public void b()
  {
    if (e())
      return;
    this.f.stopPlay();
  }

  public void b(long paramLong)
  {
    if (!c())
      return;
    this.f.seek(paramLong);
  }

  public void b(h paramh)
  {
    this.b.unregister(paramh);
  }

  public boolean c()
  {
    return (this.f != null) && (this.f.isPlaying());
  }

  public boolean d()
  {
    return (this.f != null) && (this.f.isPaused());
  }

  public boolean e()
  {
    return (this.f == null) || (this.f.isStopped());
  }

  public long f()
  {
    if (e())
      return 0L;
    return this.f.getPlayingPositionInMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.f
 * JD-Core Version:    0.6.2
 */