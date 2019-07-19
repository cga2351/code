package com.viber.voip.validation.a;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PublicAccountFieldStatusMap;
import com.viber.jni.PublicAccountFieldValueMap;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupController;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver;
import com.viber.jni.publicaccount.PublicAccountFieldValidatorListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import com.viber.voip.validation.a;
import com.viber.voip.validation.a.a;

public abstract class c extends com.viber.voip.validation.c<String, a>
{
  private static final Logger f = ViberEnv.getLogger();

  private a a(PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap)
  {
    Integer localInteger = Integer.valueOf(paramPublicAccountFieldStatusMap.getValue(g()));
    if (localInteger == null)
      return k();
    switch (localInteger.intValue())
    {
    default:
      return k();
    case 0:
    }
    return new a(a.a.c);
  }

  private void a(int paramInt, PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap)
  {
    a locala = b(paramInt, paramPublicAccountFieldStatusMap);
    Integer.valueOf(paramPublicAccountFieldStatusMap.getValue(g()));
    a(locala);
  }

  private a b(int paramInt, PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap)
  {
    switch (paramInt)
    {
    default:
      return new a(a.a.d);
    case 0:
    }
    return a(paramPublicAccountFieldStatusMap);
  }

  private a k()
  {
    CharSequence localCharSequence = h();
    if (localCharSequence != null)
      return new a(a.a.b, localCharSequence);
    int i = i();
    if (i == -1)
      return new a(a.a.b);
    if (i == 0);
    return new a(a.a.b, i);
  }

  protected a a(String paramString)
  {
    if (da.a(paramString))
      return j();
    return null;
  }

  protected void b(String paramString)
  {
    PublicAccountFieldValueMap localPublicAccountFieldValueMap = new PublicAccountFieldValueMap();
    localPublicAccountFieldValueMap.put(g(), paramString);
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    final int i = localEngine.getPhoneController().generateSequence();
    PublicAccountFieldValidatorListener localPublicAccountFieldValidatorListener = localEngine.getDelegatesManager().getPublicAccountFieldValidatorListener();
    PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver[] arrayOfPublicAccountFieldsValidatorReceiver = new PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver[1];
    arrayOfPublicAccountFieldsValidatorReceiver[0] = new PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver()
    {
      public void onValidatePublicAccountFieldsReply(int paramAnonymousInt1, PublicAccountFieldStatusMap paramAnonymousPublicAccountFieldStatusMap, int paramAnonymousInt2)
      {
        if (i == paramAnonymousInt2)
        {
          ViberApplication.getInstance().getEngine(true).getDelegatesManager().getPublicAccountFieldValidatorListener().removeDelegate(this);
          c.a(c.this, paramAnonymousInt1, paramAnonymousPublicAccountFieldStatusMap);
        }
      }
    };
    localPublicAccountFieldValidatorListener.registerDelegate(arrayOfPublicAccountFieldsValidatorReceiver);
    localEngine.getGroupController().handleValidatePublicAccountFields(i, localPublicAccountFieldValueMap);
  }

  protected abstract int g();

  protected CharSequence h()
  {
    return null;
  }

  protected int i()
  {
    return 0;
  }

  protected a j()
  {
    return new a(a.a.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.a.c
 * JD-Core Version:    0.6.2
 */