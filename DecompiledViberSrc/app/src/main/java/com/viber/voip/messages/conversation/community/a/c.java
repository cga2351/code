package com.viber.voip.messages.conversation.community.a;

import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cn;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.l;
import com.viber.voip.ui.dialogs.d;
import com.viber.voip.ui.dialogs.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class c
{
  static a.a<?> a(int paramInt, Map<String, String> paramMap, DialogInterface.OnClickListener paramOnClickListener)
  {
    ViberDialogHandlers.l locall = new ViberDialogHandlers.l();
    locall.a = paramOnClickListener;
    int i = paramMap.size();
    if (i == 1)
    {
      String str2 = (String)paramMap.values().iterator().next();
      return d.a().b(-1, new Object[] { str2 }).a(locall);
    }
    if ((i > 1) && (i <= 5))
    {
      String str1 = TextUtils.join(", ", new LinkedList(paramMap.values()));
      return d.b().b(-1, new Object[] { str1 }).a(locall);
    }
    if ((i > 5) && (i < paramInt))
      return d.c().a(locall);
    return d.d().a(locall);
  }

  static a.a<?> a(Map<String, String> paramMap, DialogInterface.OnClickListener paramOnClickListener)
  {
    ViberDialogHandlers.cn localcn = new ViberDialogHandlers.cn();
    localcn.a = paramOnClickListener;
    if (paramMap.size() > 1)
    {
      LinkedList localLinkedList = new LinkedList(paramMap.values());
      String str1 = (String)localLinkedList.removeLast();
      String str2 = TextUtils.join(", ", localLinkedList);
      return l.c().b(R.string.dialog_513_message_many, new Object[] { str2, str1 }).a(localcn);
    }
    h.a locala = l.c();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramMap.values().iterator().next();
    return locala.b(-1, arrayOfObject).a(localcn);
  }

  static a.a<?> b(int paramInt, Map<String, String> paramMap, DialogInterface.OnClickListener paramOnClickListener)
  {
    ViberDialogHandlers.l locall = new ViberDialogHandlers.l();
    locall.a = paramOnClickListener;
    int i = paramMap.size();
    if (i == 1)
    {
      h.a locala = d.e();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramMap.values().iterator().next();
      return locala.b(-1, arrayOfObject).a(locall);
    }
    if ((i > 1) && (i <= 5))
    {
      String str = TextUtils.join(", ", new LinkedList(paramMap.values()));
      return d.f().b(-1, new Object[] { str }).a(locall);
    }
    if ((i > 5) && (i < paramInt))
      return d.g().a(locall);
    return d.h().a(locall);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.a.c
 * JD-Core Version:    0.6.2
 */