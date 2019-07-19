package com.viber.provider.contacts;

import android.annotation.TargetApi;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.ViberContentProvider;
import com.viber.provider.contacts.a.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.bk;
import com.viber.voip.s.a.aa;
import com.viber.voip.s.a.af;
import com.viber.voip.s.a.ag;
import com.viber.voip.s.a.ah;
import com.viber.voip.s.a.ai;
import com.viber.voip.s.a.c;
import com.viber.voip.s.a.f;
import com.viber.voip.s.a.i;
import com.viber.voip.s.a.j;
import com.viber.voip.s.a.k;
import com.viber.voip.s.a.l;
import com.viber.voip.s.a.m;
import com.viber.voip.s.a.n;
import com.viber.voip.s.a.o;
import com.viber.voip.s.a.p;
import com.viber.voip.s.a.q;
import com.viber.voip.s.a.r;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.database.SQLException;

@TargetApi(8)
public class ViberContactsProvider extends ViberContentProvider
{
  private static UriMatcher a;
  private static Logger b;

  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    String str1 = (String)paramUri.getPathSegments().get(1);
    StringBuilder localStringBuilder = new StringBuilder().append("_id=").append(str1);
    if (!TextUtils.isEmpty(paramString));
    for (String str2 = " AND (" + paramString + ')'; ; str2 = "")
    {
      String str3 = str2;
      return a().a("calls", str3, paramArrayOfString);
    }
  }

  private int a(String paramString, String[] paramArrayOfString)
  {
    return a().a("calls", paramString, paramArrayOfString);
  }

  private static UriMatcher c()
  {
    if (a == null);
    try
    {
      if (a == null)
      {
        UriMatcher localUriMatcher = new UriMatcher(-1);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "updatecontactversion", 1001);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookcontact", 501);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "joinfullcontactdata", 503);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "joinnumberscontactdata", 504);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "composenumberscontactdata", 506);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "joindatavibernumbers", 505);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "fullnumberdata", 507);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookrawcontact", 601);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookrcontactrawcontact", 602);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookrcontactrawcontactphonebookdatawithphone", 603);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "vibernumbers", 701);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookdata", 801);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookdatanumbersviberblocked", 802);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "phonebookdatacontact", 803);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "listunioncontactdata", 901);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "listsearchcontactdata", 902);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "listsearchcontactdatasecondary", 903);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "callsjoincontacts", 303);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "calls", 302);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "calls/#", 301);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "blockednumbers", 1101);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "blockednumberscontacts", 1102);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "blockednumbersviberdata", 1103);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "syncdata", 1201);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "deltasyncdata", 1202);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "walletnumbers", 1301);
        localUriMatcher.addURI("com.viber.voip.provider.vibercontacts", "walletlist", 1401);
        a = localUriMatcher;
      }
      return a;
    }
    finally
    {
    }
  }

  private static Logger d()
  {
    if (b == null)
      b = ViberEnv.getLogger();
    return b;
  }

  protected com.viber.provider.b a()
  {
    return a.a(getContext());
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    d();
    com.viber.provider.b localb = a();
    localb.a();
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult = super.applyBatch(paramArrayList);
      localb.c();
      return arrayOfContentProviderResult;
    }
    finally
    {
      localb.b();
    }
  }

  protected com.viber.provider.b b()
  {
    return a.b(getContext());
  }

  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    d();
    com.viber.provider.b localb = a();
    localb.a();
    try
    {
      super.bulkInsert(paramUri, paramArrayOfContentValues);
      localb.c();
      return 0;
    }
    finally
    {
      localb.b();
    }
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    d();
    com.viber.provider.b localb = a();
    switch (c().match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unsupported URI:" + paramUri);
    case 302:
      return a(paramString, paramArrayOfString);
    case 301:
      return a(paramUri, paramString, paramArrayOfString);
    case 501:
      return localb.a("phonebookcontact", paramString, paramArrayOfString);
    case 701:
      return localb.a("vibernumbers", paramString, paramArrayOfString);
    case 601:
      localb.a("phonebookdata", "raw_id IN ( SELECT _id FROM phonebookrawcontact WHERE " + paramString + ")", paramArrayOfString);
      int i = localb.a("phonebookrawcontact", paramString, paramArrayOfString);
      localb.a("phonebookcontact", "_id NOT IN ( SELECT contact_id FROM phonebookrawcontact)", null);
      localb.a("vibernumbers", "canonized_number NOT IN ( SELECT data2 FROM phonebookdata WHERE mime_type=0)", null);
      return i;
    case 801:
      return localb.a("phonebookdata", paramString, paramArrayOfString);
    case 1101:
      return localb.a("blockednumbers", paramString, paramArrayOfString);
    case 1301:
      return localb.a("walletnumbers", paramString, paramArrayOfString);
    case 1401:
      return localb.a("walletlist", paramString, paramArrayOfString);
    case 1201:
    }
    return localb.a("sync_data", paramString, paramArrayOfString);
  }

  public String getType(Uri paramUri)
  {
    c().match(paramUri);
    throw new IllegalArgumentException("Unknown URI " + paramUri);
  }

  @TargetApi(8)
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    d();
    com.viber.provider.b localb = a();
    switch (c().match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 302:
      long l = localb.a("calls", null, paramContentValues);
      if (l < 0L)
        throw new SQLException("Failed to insert row into " + paramUri);
      return ContentUris.withAppendedId(paramUri, l);
    case 501:
      return ContentUris.withAppendedId(paramUri, localb.a("phonebookcontact", null, paramContentValues));
    case 701:
      return ContentUris.withAppendedId(paramUri, localb.a("vibernumbers", null, paramContentValues));
    case 601:
      return ContentUris.withAppendedId(paramUri, localb.a("phonebookrawcontact", null, paramContentValues));
    case 801:
      return ContentUris.withAppendedId(paramUri, localb.a("phonebookdata", null, paramContentValues));
    case 1101:
      return ContentUris.withAppendedId(paramUri, localb.a("blockednumbers", null, paramContentValues));
    case 1201:
      return ContentUris.withAppendedId(paramUri, localb.a("sync_data", null, paramContentValues));
    case 1301:
      return ContentUris.withAppendedId(paramUri, localb.a("walletnumbers", null, paramContentValues));
    case 1401:
      return ContentUris.withAppendedId(paramUri, localb.a("walletlist", null, paramContentValues));
    case 301:
    }
    throw new IllegalArgumentException("Unsupported URI:" + paramUri);
  }

  public boolean onCreate()
  {
    bk.a(getContext());
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    d();
    if (a(paramUri, null, null))
      return null;
    com.viber.provider.b localb = b();
    String str1;
    Object localObject;
    switch (c().match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unsupported URI:" + paramUri);
    case 601:
      str1 = "phonebookrawcontact";
      localObject = null;
      if (localObject == null)
        localObject = new ah(str1);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 501:
    case 701:
    case 801:
    case 302:
    case 301:
    case 303:
    case 503:
    case 504:
    case 506:
    case 505:
    case 507:
    case 602:
    case 603:
    case 802:
    case 803:
    case 901:
    case 902:
    case 903:
    case 1101:
    case 1102:
    case 1103:
    case 1201:
    case 1202:
    case 1301:
    case 1401:
    }
    for (String str2 = null; ; str2 = paramString2)
    {
      return ((ai)localObject).a(localb, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str2);
      str1 = "phonebookcontact";
      localObject = null;
      break;
      str1 = "vibernumbers";
      localObject = null;
      break;
      str1 = "phonebookdata";
      localObject = null;
      break;
      str1 = "calls";
      localObject = null;
      break;
      str1 = "calls";
      localObject = new ah(str1, "_id=" + (String)paramUri.getPathSegments().get(1));
      break;
      localObject = new f();
      str1 = "calls";
      break;
      localObject = new o();
      str1 = "phonebookcontact";
      break;
      localObject = new r();
      str1 = "phonebookcontact";
      break;
      localObject = new q();
      str1 = "phonebookcontact";
      break;
      localObject = new p();
      str1 = "phonebookcontact";
      break;
      localObject = new l();
      str1 = "phonebookcontact";
      break;
      localObject = new m();
      str1 = "phonebookcontact";
      break;
      localObject = new n();
      str1 = "phonebookcontact";
      break;
      localObject = new ag();
      str1 = "phonebookdata";
      break;
      localObject = new af();
      str1 = "phonebookdata";
      break;
      localObject = new k();
      str1 = "phonebookcontact";
      break;
      localObject = new i();
      str1 = "phonebookcontact";
      break;
      localObject = new j();
      str1 = "phonebookcontact";
      break;
      str1 = "blockednumbers";
      localObject = null;
      break;
      localObject = new com.viber.voip.s.a.b();
      str1 = "blockednumbers";
      break;
      localObject = new c();
      str1 = "blockednumbers";
      break;
      str1 = "sync_data";
      localObject = null;
      break;
      localObject = new aa();
      str1 = "sync_data";
      break;
      str1 = "walletnumbers";
      localObject = null;
      break;
      str1 = "walletlist";
      localObject = null;
      break;
    }
  }

  @TargetApi(8)
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    d();
    com.viber.provider.b localb = a();
    switch (c().match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unsupported URI:" + paramUri);
    case 302:
      return localb.a("calls", paramContentValues, paramString, paramArrayOfString);
    case 301:
      String str2 = (String)paramUri.getPathSegments().get(1);
      StringBuilder localStringBuilder2 = new StringBuilder().append("_id=").append(str2);
      if (!TextUtils.isEmpty(paramString));
      for (String str3 = " AND (" + paramString + ')'; ; str3 = "")
        return localb.a("calls", paramContentValues, str3, paramArrayOfString);
    case 501:
      return localb.a("phonebookcontact", paramContentValues, paramString, paramArrayOfString);
    case 701:
      return localb.a("vibernumbers", paramContentValues, paramString, paramArrayOfString);
    case 601:
      return localb.a("phonebookrawcontact", paramContentValues, paramString, paramArrayOfString);
    case 801:
      return localb.a("phonebookdata", paramContentValues, paramString, paramArrayOfString);
    case 1101:
      return localb.a("blockednumbers", paramContentValues, paramString, paramArrayOfString);
    case 1301:
      return localb.a("walletnumbers", paramContentValues, paramString, paramArrayOfString);
    case 1401:
      return localb.a("walletlist", paramContentValues, paramString, paramArrayOfString);
    case 1201:
      return localb.a("sync_data", paramContentValues, paramString, paramArrayOfString);
    case 1001:
    }
    StringBuilder localStringBuilder1 = new StringBuilder().append("UPDATE phonebookcontact SET version=(version + 1)  WHERE (");
    if (paramString == null)
      paramString = " 1=1 ";
    String str1 = paramString + ")";
    if (paramArrayOfString == null)
      paramArrayOfString = new String[0];
    localb.a(str1, paramArrayOfString);
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.contacts.ViberContactsProvider
 * JD-Core Version:    0.6.2
 */