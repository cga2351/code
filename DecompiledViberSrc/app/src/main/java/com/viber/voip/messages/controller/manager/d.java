package com.viber.voip.messages.controller.manager;

import android.support.v4.util.LongSparseArray;
import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSendActionToBotMsg;
import com.viber.jni.im2.CSendActionToBotReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.a.f.b;
import com.viber.voip.ui.g;
import com.viber.voip.util.az;
import com.viber.voip.util.da;
import com.viber.voip.util.links.c;
import com.viber.voip.util.links.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class d
  implements BotFavoriteLinksCommunicator, a
{
  private static final Logger a = ViberEnv.getLogger();
  private final dagger.a<f> b;
  private final Im2Exchanger c;
  private final PhoneController d;
  private final ConnectionController e;
  private final az f;
  private final g g;
  private final Map<Integer, a> h;
  private final LongSparseArray<BotFavoriteLinksCommunicator.SaveLinkActionMessage> i;
  private final EventBus j;
  private final com.viber.voip.messages.controller.publicaccount.d k;
  private final c l;
  private final c.c m = new c.c()
  {
    public void a(String paramAnonymousString, long paramAnonymousLong, LinkParser.Preview paramAnonymousPreview)
    {
      BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = (BotFavoriteLinksCommunicator.SaveLinkActionMessage)d.a(d.this).get(paramAnonymousLong);
      d.a(d.this).delete(paramAnonymousLong);
      if (localSaveLinkActionMessage == null)
        break label32;
      label32: 
      while ((paramAnonymousPreview == null) || (!paramAnonymousPreview.isValid()))
        return;
      BotFavoriteLinksCommunicator.SaveLinkActionMessage.a locala = localSaveLinkActionMessage.buildUpon();
      if ((!da.a(paramAnonymousPreview.title)) && (da.a(localSaveLinkActionMessage.getTitle())))
        locala.b(paramAnonymousPreview.title);
      for (int i = 1; ; i = 0)
      {
        if ((!da.a(paramAnonymousPreview.thumbnail)) && (da.a(localSaveLinkActionMessage.getThumbnailUrl())))
        {
          locala.c(paramAnonymousPreview.thumbnail);
          i = 1;
        }
        if (i == 0)
          break;
        d.a(d.this, locala.c(false).d(true).a(true).a());
        return;
      }
    }
  };
  private final ConnectionDelegate n = new ConnectionDelegate()
  {
    public void onConnect()
    {
      ArrayList localArrayList = new ArrayList(d.b(d.this).values());
      d.b(d.this).clear();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        d.a(d.this, d.a.a(locala));
      }
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };

  d(dagger.a<f> parama, Im2Exchanger paramIm2Exchanger, Engine paramEngine, az paramaz, g paramg, ConnectionListener paramConnectionListener, EventBus paramEventBus, com.viber.voip.messages.controller.publicaccount.d paramd, c paramc)
  {
    this.b = parama;
    this.j = paramEventBus;
    this.c = paramIm2Exchanger;
    this.d = paramEngine.getPhoneController();
    this.e = paramEngine.getConnectionController();
    this.f = paramaz;
    this.g = paramg;
    this.k = paramd;
    this.l = paramc;
    this.h = new LinkedHashMap();
    this.i = new LongSparseArray();
    paramConnectionListener.registerDelegate(this.n, this.f.a());
  }

  private void c(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
  {
    if (paramSaveLinkActionMessage.hasEnoughMetadata())
      return;
    this.i.put(paramSaveLinkActionMessage.getId(), paramSaveLinkActionMessage);
    this.l.a(paramSaveLinkActionMessage.getUrl(), paramSaveLinkActionMessage.getId(), this.m);
  }

  private void d(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
  {
    this.f.a(new e(this, paramSaveLinkActionMessage));
  }

  private void e(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
  {
    if (!paramSaveLinkActionMessage.isValid());
    int i1;
    do
    {
      return;
      i1 = this.d.generateSequence();
      this.h.put(Integer.valueOf(i1), new a(paramSaveLinkActionMessage));
    }
    while (!this.e.isConnected());
    String str = paramSaveLinkActionMessage.toJson(this.b);
    CSendActionToBotMsg localCSendActionToBotMsg = new CSendActionToBotMsg(paramSaveLinkActionMessage.getPublicAccountId(), 0, i1, str);
    this.c.handleCSendActionToBotMsg(localCSendActionToBotMsg);
  }

  public void a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
  {
    d(paramSaveLinkActionMessage);
  }

  public void onCSendActionToBotReplyMsg(CSendActionToBotReplyMsg paramCSendActionToBotReplyMsg)
  {
    a locala;
    if (2 != paramCSendActionToBotReplyMsg.status)
    {
      locala = (a)this.h.remove(Integer.valueOf(paramCSendActionToBotReplyMsg.seq));
      if (locala != null)
        break label33;
    }
    label33: BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage;
    BotFavoriteLinksCommunicator.a locala1;
    do
    {
      return;
      localSaveLinkActionMessage = a.a(locala);
      if (paramCSendActionToBotReplyMsg.status != 0)
      {
        f.a.a(this.j, localSaveLinkActionMessage);
        return;
      }
      String str = localSaveLinkActionMessage.getPublicAccountId();
      if (localSaveLinkActionMessage.isSilent())
      {
        this.k.d(str);
        return;
      }
      locala1 = (BotFavoriteLinksCommunicator.a)((f)this.b.get()).a(paramCSendActionToBotReplyMsg.msgInfo, BotFavoriteLinksCommunicator.a.class);
      if ("success".equals(locala1.a()))
      {
        this.k.d(str);
        this.j.post(new f.b(localSaveLinkActionMessage.getSource()));
        c(localSaveLinkActionMessage);
        return;
      }
    }
    while (!"too_many_links".equals(locala1.a()));
    this.g.a(localSaveLinkActionMessage);
  }

  private static class a
  {
    private final BotFavoriteLinksCommunicator.SaveLinkActionMessage a;

    a(BotFavoriteLinksCommunicator.SaveLinkActionMessage paramSaveLinkActionMessage)
    {
      this.a = paramSaveLinkActionMessage;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.d
 * JD-Core Version:    0.6.2
 */