package com.viber.voip.contacts.c.f.b;

import android.os.Handler;
import com.viber.jni.PhoneControllerDelegateAdapter;

public class b extends PhoneControllerDelegateAdapter
{
  private final Handler a;
  private final PhoneControllerDelegateAdapter[] b;

  public b(Handler paramHandler, PhoneControllerDelegateAdapter[] paramArrayOfPhoneControllerDelegateAdapter)
  {
    this.a = paramHandler;
    this.b = paramArrayOfPhoneControllerDelegateAdapter;
  }

  public void onRecanonize(final String paramString)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        PhoneControllerDelegateAdapter[] arrayOfPhoneControllerDelegateAdapter = b.a(b.this);
        int i = arrayOfPhoneControllerDelegateAdapter.length;
        for (int j = 0; j < i; j++)
          arrayOfPhoneControllerDelegateAdapter[j].onRecanonize(paramString);
      }
    });
  }

  public void onShareAddressBook()
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        PhoneControllerDelegateAdapter[] arrayOfPhoneControllerDelegateAdapter = b.a(b.this);
        int i = arrayOfPhoneControllerDelegateAdapter.length;
        for (int j = 0; j < i; j++)
          arrayOfPhoneControllerDelegateAdapter[j].onShareAddressBook();
      }
    });
  }

  public void onShareAddressBookReply(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        PhoneControllerDelegateAdapter[] arrayOfPhoneControllerDelegateAdapter = b.a(b.this);
        int i = arrayOfPhoneControllerDelegateAdapter.length;
        for (int j = 0; j < i; j++)
          arrayOfPhoneControllerDelegateAdapter[j].onShareAddressBookReply(paramInt1, paramInt2, paramInt3);
      }
    });
  }

  public void onShareAddressBookReplyOld(final boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        PhoneControllerDelegateAdapter[] arrayOfPhoneControllerDelegateAdapter = b.a(b.this);
        int i = arrayOfPhoneControllerDelegateAdapter.length;
        for (int j = 0; j < i; j++)
          arrayOfPhoneControllerDelegateAdapter[j].onShareAddressBookReplyOld(paramBoolean, paramInt1, paramInt2);
      }
    });
  }

  public boolean onUnregisteredNumber(final String paramString, final int paramInt)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        PhoneControllerDelegateAdapter[] arrayOfPhoneControllerDelegateAdapter = b.a(b.this);
        int i = arrayOfPhoneControllerDelegateAdapter.length;
        for (int j = 0; j < i; j++)
          arrayOfPhoneControllerDelegateAdapter[j].onUnregisteredNumber(paramString, paramInt);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.b
 * JD-Core Version:    0.6.2
 */