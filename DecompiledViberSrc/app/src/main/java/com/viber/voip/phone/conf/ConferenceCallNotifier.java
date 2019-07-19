package com.viber.voip.phone.conf;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConferenceCallNotifier
  implements IConferenceCall.UiDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  private final CopyOnWriteArrayList<IConferenceCall.UiDelegate> mUiDelegates = new CopyOnWriteArrayList();
  private final Handler mUiExecutor = av.a(av.e.a);

  public boolean addUiDelegate(IConferenceCall.UiDelegate paramUiDelegate)
  {
    if (paramUiDelegate != null)
      this.mUiDelegates.add(paramUiDelegate);
    return paramUiDelegate != null;
  }

  public void clear()
  {
    this.mUiDelegates.clear();
  }

  public void onConferenceCreated(int paramInt, long paramLong, Map<String, Integer> paramMap)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.2(localUiDelegate, paramInt, paramLong, paramMap));
    }
  }

  public void onDisconnected()
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      Handler localHandler = this.mUiExecutor;
      localUiDelegate.getClass();
      localHandler.post(ConferenceCallNotifier..Lambda.6.get$Lambda(localUiDelegate));
    }
  }

  public void onFirstPeerJoined(ConferenceCall paramConferenceCall, String paramString)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.0(localUiDelegate, paramConferenceCall, paramString));
    }
  }

  public void onLastPeerLeft(ConferenceCall paramConferenceCall)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.1(localUiDelegate, paramConferenceCall));
    }
  }

  public void onNewPeerConnectionNeeded()
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      Handler localHandler = this.mUiExecutor;
      localUiDelegate.getClass();
      localHandler.post(ConferenceCallNotifier..Lambda.7.get$Lambda(localUiDelegate));
    }
  }

  public void onPeersChanged(Collection<IConferenceCall.UiDelegate.PeerInfo> paramCollection)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.4(localUiDelegate, paramCollection));
    }
  }

  public void onPeersInvited(int paramInt, Map<String, Integer> paramMap)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.3(localUiDelegate, paramInt, paramMap));
    }
  }

  public void onVolumeLevelChanged(Map<String, Float> paramMap, String paramString)
  {
    Iterator localIterator = this.mUiDelegates.iterator();
    while (localIterator.hasNext())
    {
      IConferenceCall.UiDelegate localUiDelegate = (IConferenceCall.UiDelegate)localIterator.next();
      this.mUiExecutor.post(new ConferenceCallNotifier..Lambda.5(localUiDelegate, paramMap, paramString));
    }
  }

  public void removeUiDelegate(IConferenceCall.UiDelegate paramUiDelegate)
  {
    if (paramUiDelegate != null)
      this.mUiDelegates.remove(paramUiDelegate);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceCallNotifier
 * JD-Core Version:    0.6.2
 */