package com.viber.voip.contacts.c.b;

import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.connection.ConnectionDelegate;

public abstract class b extends PhoneControllerDelegateAdapter
  implements ConnectionDelegate
{
  public abstract void a();

  public abstract void a(Engine paramEngine);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.b.b
 * JD-Core Version:    0.6.2
 */