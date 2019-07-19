package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.e;
import com.viber.common.dialogs.e.a;
import com.viber.common.dialogs.f;
import com.viber.common.dialogs.f.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.a.c.a;
import com.viber.voip.util.ParcelableInt;
import java.util.ArrayList;

public class j
{
  public static a.a a(int paramInt)
  {
    h.a locala = (h.a)((h.a)h.j().a(DialogCode.D448)).d(R.string.dialog_448_title);
    int i = R.string.dialog_448_message;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return ((h.a)locala.b(i, arrayOfObject)).i(R.string.dialog_button_ok);
  }

  public static a.a a(String paramString)
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D450)).d(R.string.dialog_450_title)).b(R.string.dialog_450_message, new Object[] { paramString })).i(R.string.dialog_button_ok);
  }

  public static a.a a(String paramString, int paramInt)
  {
    h.a locala = (h.a)h.j().a(DialogCode.D451);
    int i = R.string.dialog_451_message;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    return ((h.a)locala.b(i, arrayOfObject)).i(R.string.dialog_button_ok);
  }

  public static f.a a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    return ((f.a)f.j().a(DialogCode.D_USER_BIRTH_DATE)).i(paramInt1).j(paramInt2).k(paramInt3).a(paramLong1).b(paramLong2);
  }

  public static l.a a()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D446)).d(R.string.dialog_446_title)).f(R.string.dialog_446_message)).i(R.string.dialog_button_deactivate)).m(R.string.dialog_button_cancel);
  }

  public static a.a b()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D449)).d(R.string.dialog_449_title)).f(R.string.dialog_449_message)).i(R.string.dialog_button_ok);
  }

  public static h.a b(String paramString, int paramInt)
  {
    h.a locala = (h.a)h.j().a(DialogCode.D455);
    int i = R.string.dialog_455_body;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    return ((h.a)locala.b(i, arrayOfObject)).i(R.string.dialog_button_ok);
  }

  public static l.a b(int paramInt)
  {
    l.a locala = (l.a)((l.a)l.n().a(DialogCode.D445)).d(R.string.dialog_445_title);
    int i = R.string.dialog_445_body;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return ((l.a)((l.a)locala.b(i, arrayOfObject)).i(R.string.dialog_button_delete)).m(R.string.dialog_button_cancel);
  }

  public static a.a c()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D452)).d(R.string.dialog_452_title)).f(R.string.dialog_452_message)).i(R.string.dialog_button_confirm)).m(R.string.dialog_button_cancel);
  }

  public static a.a d()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D453)).d(R.string.dialog_453_title)).f(R.string.dialog_453_message)).i(R.string.dialog_button_ok);
  }

  public static h.a e()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D456)).d(R.string.gdpr_data_erasure_header)).f(R.string.dialog_456_body)).i(R.string.dialog_button_ok);
  }

  public static l.a f()
  {
    return ((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D459)).b(false)).d(R.string.dialog_459_title)).f(R.string.dialog_459_message)).i(R.string.dialog_button_update_birthday)).m(R.string.dialog_button_cancel);
  }

  public static e.a g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ParcelableInt(-1));
    localArrayList.add(new ParcelableInt(-2));
    return (e.a)((e.a)e.j().a(DialogCode.D460a)).i(R.layout.bottom_sheet_dialog_item).a(localArrayList).a(new c.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.j
 * JD-Core Version:    0.6.2
 */