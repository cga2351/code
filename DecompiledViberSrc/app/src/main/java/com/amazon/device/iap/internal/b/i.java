package com.amazon.device.iap.internal.b;

import android.os.RemoteException;
import com.amazon.android.Kiwi;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.prompt.PromptManager;
import com.amazon.android.framework.task.command.AbstractCommandTask;
import com.amazon.android.licensing.LicenseFailurePromptContentMapper;
import com.amazon.device.iap.internal.util.d;
import com.amazon.device.iap.model.RequestId;
import com.amazon.venezia.command.FailureResult;
import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.Map;

public abstract class i extends AbstractCommandTask
{
  private static final String a = i.class.getSimpleName();
  private final e b;
  private final String c;
  private final String d;
  private final String e;
  private final Map<String, Object> f;
  private final LicenseFailurePromptContentMapper g = new LicenseFailurePromptContentMapper();
  private boolean h;
  private i i;
  private i j;
  private boolean k = false;

  public i(e parame, String paramString1, String paramString2)
  {
    this.b = parame;
    this.c = parame.c().toString();
    this.d = paramString1;
    this.e = paramString2;
    this.f = new HashMap();
    this.f.put("requestId", this.c);
    this.f.put("sdkVersion", "2.0.61.0");
    this.h = true;
    this.i = null;
    this.j = null;
  }

  private void a(PromptContent paramPromptContent)
  {
    if (paramPromptContent == null)
      return;
    b localb = new b(paramPromptContent);
    Kiwi.getPromptManager().present(localb);
  }

  public i a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  public void a(i parami)
  {
    this.i = parami;
  }

  protected void a(String paramString, Object paramObject)
  {
    this.f.put(paramString, paramObject);
  }

  protected abstract boolean a(SuccessResult paramSuccessResult)
    throws Exception;

  public void a_()
  {
    Kiwi.addCommandToCommandTaskPipeline(this);
  }

  protected e b()
  {
    return this.b;
  }

  public void b(i parami)
  {
    this.j = parami;
  }

  protected void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  protected String c()
  {
    return this.c;
  }

  protected Map<String, Object> getCommandData()
  {
    return this.f;
  }

  protected String getCommandName()
  {
    return this.d;
  }

  protected String getCommandVersion()
  {
    return this.e;
  }

  protected boolean isExecutionNeeded()
  {
    return true;
  }

  protected final void onException(KiwiException paramKiwiException)
  {
    com.amazon.device.iap.internal.util.e.a(a, "onException: exception = " + paramKiwiException.getMessage());
    if (("UNHANDLED_EXCEPTION".equals(paramKiwiException.getType())) && ("2.0".equals(this.e)) && (this.j != null))
    {
      this.j.a(this.k);
      this.j.a_();
    }
    do
    {
      return;
      if (this.h)
        a(this.g.map(paramKiwiException));
    }
    while (this.k);
    this.b.b();
  }

  protected final void onFailure(FailureResult paramFailureResult)
    throws RemoteException, KiwiException
  {
    com.amazon.device.iap.internal.util.e.a(a, "onFailure: result = " + paramFailureResult);
    if (paramFailureResult != null)
    {
      String str = (String)paramFailureResult.getExtensionData().get("maxVersion");
      if ((str == null) || (!str.equalsIgnoreCase("1.0")));
    }
    for (int m = 1; ; m = 0)
    {
      if ((m != 0) && (this.j != null))
      {
        this.j.a(this.k);
        this.j.a_();
      }
      do
      {
        return;
        if (this.h)
          a(new PromptContent(paramFailureResult.getDisplayableName(), paramFailureResult.getDisplayableMessage(), paramFailureResult.getButtonLabel(), paramFailureResult.show()));
      }
      while (this.k);
      this.b.b();
      return;
    }
  }

  protected final void onSuccess(SuccessResult paramSuccessResult)
    throws RemoteException
  {
    String str = (String)paramSuccessResult.getData().get("errorMessage");
    com.amazon.device.iap.internal.util.e.a(a, "onSuccess: result = " + paramSuccessResult + ", errorMessage: " + str);
    if (d.a(str));
    while (this.k)
      try
      {
        boolean bool2 = a(paramSuccessResult);
        bool1 = bool2;
        if ((bool1) && (this.i != null))
        {
          this.i.a_();
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        do
          while (true)
          {
            com.amazon.device.iap.internal.util.e.b(a, "Error calling onResult: " + localException);
            bool1 = false;
          }
        while (this.k);
        if (bool1)
        {
          this.b.a();
          return;
        }
        this.b.b();
        return;
      }
    this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.i
 * JD-Core Version:    0.6.2
 */