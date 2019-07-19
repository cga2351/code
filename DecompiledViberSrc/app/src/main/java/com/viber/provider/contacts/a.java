package com.viber.provider.contacts;

import android.net.Uri;
import android.provider.BaseColumns;

public class a
{
  public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/method/updateLanguage");

  public static final class a
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/blockednumbers");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/blockednumberscontacts");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibercontacts/blockednumbersviberdata");
  }

  public static final class b
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/calls");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/callsjoincontacts");
  }

  public static final class c
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookcontact");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/joinfullcontactdata");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibercontacts/listunioncontactdata");
    public static final Uri d = Uri.parse("content://com.viber.voip.provider.vibercontacts/listsearchcontactdata");
    public static final Uri e = Uri.parse("content://com.viber.voip.provider.vibercontacts/listsearchcontactdatasecondary");
    public static final Uri f = Uri.parse("content://com.viber.voip.provider.vibercontacts/joinnumberscontactdata");
    public static final Uri g = Uri.parse("content://com.viber.voip.provider.vibercontacts/composenumberscontactdata");
    public static final Uri h = Uri.parse("content://com.viber.voip.provider.vibercontacts/joindatavibernumbers");
    public static final Uri i = Uri.parse("content://com.viber.voip.provider.vibercontacts/fullnumberdata");
    public static final Uri j = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookrcontactrawcontact");
    public static final Uri k = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookrcontactrawcontactphonebookdatawithphone");
    public static final Uri l = Uri.parse("content://com.viber.voip.provider.vibercontacts/updatecontactversion");
  }

  public static final class d
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookrawcontact");
  }

  public static class e
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookdata");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookdatacontact");
    public static final Uri c = Uri.parse("content://com.viber.voip.provider.vibercontacts/phonebookdatanumbersviberblocked");
  }

  public static final class f
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/syncdata");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/deltasyncdata");

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[3];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
      }

      public static a a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 0:
          return a;
        case 1:
          return b;
        case 2:
        }
        return c;
      }
    }
  }

  public static final class g
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/vibernumbers");
  }

  public static final class h
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/walletlist");
  }

  public static final class i
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.viber.voip.provider.vibercontacts/walletnumbers");
    public static final Uri b = Uri.parse("content://com.viber.voip.provider.vibercontacts/walletnumberscontacts");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.contacts.a
 * JD-Core Version:    0.6.2
 */