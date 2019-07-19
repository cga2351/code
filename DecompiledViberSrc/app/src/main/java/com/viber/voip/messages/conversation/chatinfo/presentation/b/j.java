package com.viber.voip.messages.conversation.chatinfo.presentation.b;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.viber.common.permission.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ae;

public abstract interface j
{
  public abstract void A();

  public abstract void H();

  public abstract void I();

  public abstract void J();

  public abstract void K();

  public abstract void L();

  public abstract void M();

  public abstract void a(int paramInt);

  public abstract void a(int paramInt, String paramString);

  public abstract void a(ae paramae);

  public abstract void b(long paramLong);

  public abstract void b(String paramString);

  public abstract void c(String paramString);

  public abstract void f(boolean paramBoolean);

  public abstract void g(boolean paramBoolean);

  public abstract FragmentActivity getActivity();

  public abstract View getView();

  public abstract void h(boolean paramBoolean);

  public abstract void i(boolean paramBoolean);

  public abstract void j(boolean paramBoolean);

  public abstract c q();

  public abstract Fragment r();

  public abstract ConversationItemLoaderEntity s();

  public abstract void startActivity(Intent paramIntent);

  public abstract void startActivityForResult(Intent paramIntent, int paramInt);

  public abstract void u();

  public abstract void v();

  public abstract void w();

  public abstract void x();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.b.j
 * JD-Core Version:    0.6.2
 */