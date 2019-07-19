package com.viber.voip.g;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.sdk.SdkActivity;
import com.viber.voip.workers.EmailCollectionWorker;
import javax.inject.Singleton;

@Singleton
public abstract interface a
{
  public abstract com.viber.voip.api.a.b.a a();

  public abstract void a(ViberApplication paramViberApplication);

  public abstract void a(SdkActivity paramSdkActivity);

  public abstract void a(EmailCollectionWorker paramEmailCollectionWorker);

  public abstract com.viber.voip.invitelinks.q b();

  public abstract com.viber.voip.news.q c();

  public abstract ICdrController d();

  public static abstract interface a
  {
    public abstract a a(ViberApplication paramViberApplication);

    public abstract a a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a
 * JD-Core Version:    0.6.2
 */