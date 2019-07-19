package com.viber.jni.spam;

import android.os.Handler;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineBackend;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.model.e;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.Set;

public class UnknownNumberReportWrapper
  implements ServiceStateDelegate, UnknownNumberReportController, UnknownNumberSaveDelegate
{
  private static final Logger L = ViberEnv.getLogger();
  private final EngineBackend mEngineBackend;
  private boolean mIsServiceConnected;
  private final SparseArray<String> mSeqToNumbers;
  private final Handler mWorker;

  public UnknownNumberReportWrapper(Engine paramEngine, EngineBackend paramEngineBackend)
  {
    this.mEngineBackend = paramEngineBackend;
    this.mWorker = av.e.d.a();
    paramEngine.getDelegatesManager().getUnknownNumberSaveListener().registerDelegate(this, this.mWorker);
    paramEngine.getDelegatesManager().getServiceStateListener().registerDelegate(this, this.mWorker);
    this.mSeqToNumbers = new SparseArray();
  }

  private void handleSendContactSavedNotification(final String paramString)
  {
    this.mWorker.post(new Runnable()
    {
      public void run()
      {
        e.a("spam_unknown_number", paramString, "");
        UnknownNumberReportWrapper.this.sendSavedPhoneNumbers();
      }
    });
  }

  private void sendSavedPhoneNumbers()
  {
    if (!this.mIsServiceConnected);
    while (true)
    {
      return;
      Iterator localIterator = e.a("spam_unknown_number").iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!da.a(str))
        {
          int i = this.mEngineBackend.generateSequence();
          this.mSeqToNumbers.append(i, str);
          this.mEngineBackend.handleSendContactSavedNotification(str, i);
        }
        else
        {
          e.a("spam_unknown_number", new String[] { str });
        }
      }
    }
  }

  public boolean handleSendContactSavedNotification(String paramString, int paramInt)
  {
    if (!da.a(paramString))
      handleSendContactSavedNotification(paramString);
    return true;
  }

  public void onContactSavedNotificationReply(int paramInt1, int paramInt2)
  {
    String str = (String)this.mSeqToNumbers.get(paramInt2);
    this.mSeqToNumbers.remove(paramInt2);
    if (paramInt1 == 0)
      e.a("spam_unknown_number", new String[] { str });
  }

  public void onServiceStateChanged(int paramInt)
  {
    if ((!this.mIsServiceConnected) && (ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal() == paramInt))
    {
      this.mIsServiceConnected = true;
      sendSavedPhoneNumbers();
    }
    while (ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal() == paramInt)
      return;
    this.mIsServiceConnected = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.spam.UnknownNumberReportWrapper
 * JD-Core Version:    0.6.2
 */