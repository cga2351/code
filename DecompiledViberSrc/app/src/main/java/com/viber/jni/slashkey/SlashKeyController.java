package com.viber.jni.slashkey;

import com.google.d.f;
import com.viber.common.b.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.u;
import java.util.Set;

public class SlashKeyController
{
  private static final Logger L = ViberEnv.getLogger();

  @Deprecated
  private void initializeEngine()
  {
    ViberApplication.getInstance().getEngine(true);
  }

  private static synchronized native long nativeCreateAdapterFor(String paramString, SlashKeyAdapterDelegateWrapper paramSlashKeyAdapterDelegateWrapper);

  private static synchronized native String nativeGetServicesJson(String paramString);

  public SlashKeyAdapter createAdapterFor(String paramString, SlashKeyAdapterDelegate paramSlashKeyAdapterDelegate)
  {
    initializeEngine();
    return new SlashKeyAdapter(nativeCreateAdapterFor(paramString, new SlashKeyAdapterDelegateWrapper(paramSlashKeyAdapterDelegate)), paramSlashKeyAdapterDelegate);
  }

  public ServiceDescription[] getServices()
  {
    initializeEngine();
    Set localSet = d.r.n.d();
    String str1 = "";
    if (!u.a(localSet))
      str1 = new f().b(localSet);
    String str2 = nativeGetServicesJson(str1);
    return (ServiceDescription[])new f().a(str2, [Lcom.viber.jni.slashkey.ServiceDescription.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashKeyController
 * JD-Core Version:    0.6.2
 */