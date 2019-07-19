package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.c.a;
import android.widget.Toast;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.provider.contacts.a.c;
import com.viber.provider.contacts.a.d;
import com.viber.provider.contacts.a.e;
import com.viber.provider.contacts.a.f;
import com.viber.provider.contacts.a.g;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.analytics.story.o;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.m;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.user.InvitationCreator;
import com.viber.voip.util.ViberActionRunner.al;
import com.viber.voip.util.af;
import com.viber.voip.util.cj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aj
{
  private Context a;

  public aj(Context paramContext)
  {
    this.a = paramContext;
  }

  public static void a(final Activity paramActivity, Map<Member, Boolean> paramMap, final String paramString, boolean paramBoolean, final Runnable paramRunnable)
  {
    int i = 0;
    if (!paramMap.containsValue(Boolean.valueOf(false)))
    {
      com.viber.voip.block.g.a(paramActivity, paramMap.keySet(), paramString, false, paramRunnable);
      return;
    }
    if ((paramBoolean) && (paramMap.size() > 1))
    {
      final Member[] arrayOfMember = new Member[paramMap.size()];
      String[] arrayOfString = new String[paramMap.size()];
      boolean[] arrayOfBoolean = new boolean[paramMap.size()];
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Member localMember = (Member)localEntry.getKey();
        arrayOfMember[i] = localMember;
        arrayOfString[i] = localMember.getPhoneNumber();
        arrayOfBoolean[i] = ((Boolean)localEntry.getValue()).booleanValue();
        i++;
      }
      c.a locala = new c.a(paramActivity);
      locala.a(arrayOfString, arrayOfBoolean, new DialogInterface.OnMultiChoiceClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          this.a.put(arrayOfMember[paramAnonymousInt], Boolean.valueOf(paramAnonymousBoolean));
        }
      });
      locala.a(R.string.block_select_numbers);
      locala.b(R.string.cancel_btn_text, null);
      locala.a(R.string.block, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          HashSet localHashSet = new HashSet(this.a.size());
          Iterator localIterator = this.a.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((Boolean)localEntry.getValue()).booleanValue())
              localHashSet.add(localEntry.getKey());
          }
          if (localHashSet.size() > 0)
            com.viber.voip.block.g.a(paramActivity, localHashSet, paramString, false, paramRunnable, false, false);
        }
      });
      locala.b().show();
      return;
    }
    com.viber.voip.block.g.a(paramActivity, paramMap.keySet(), paramString, false, paramRunnable, true, false);
  }

  public static void a(Context paramContext, String paramString)
  {
    Uri localUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, paramString);
    ViberActionRunner.al.a(paramContext, ContactsContract.Contacts.lookupContact(paramContext.getContentResolver(), localUri));
    com.viber.voip.analytics.g.a().c().a().a("Value Changed Unavailable", "Profile");
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new InvitationCreator(paramContext).createShareInviteIntent(paramString, R.string.invite_via, paramBoolean);
    if (localIntent != null)
    {
      if ((paramBoolean) && (!com.viber.common.d.a.h()))
      {
        com.viber.voip.analytics.g.a().a(i.h(""));
        com.viber.voip.analytics.g.a().a(i.i(""));
      }
      if (!com.viber.common.d.a.h())
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportShareInvitationNativeMenu(null, 1);
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Toast.makeText(paramContext, R.string.action_not_supported, 1).show();
        return;
      }
    }
    Toast.makeText(paramContext, R.string.action_not_supported, 1).show();
  }

  public static void a(boolean paramBoolean, long paramLong, String paramString)
  {
    ViberApplication.getInstance().getContactManager().a(paramLong, paramString, paramBoolean);
  }

  public void a()
  {
    ViberApplication.getInstance().getContactManager().d().b();
    ViberApplication.getInstance().getContactManager().b();
  }

  public void a(int paramInt1, ak paramak, int paramInt2)
  {
    paramak.a(paramInt2, false);
  }

  public void a(Context paramContext, com.viber.voip.model.c paramc)
  {
  }

  public void a(ContactsFragment.MemberActionInfo paramMemberActionInfo, dagger.a<h> parama)
  {
    CallInitiationId.noteNextCallInitiationAttemptId();
    h localh = (h)parama.get();
    h.a.a locala1 = h.a.i();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramMemberActionInfo.member.getPhoneNumber();
    h.a.a locala2 = locala1.a(arrayOfString);
    if (paramMemberActionInfo.isFromSearchResults);
    for (String str = "Search Results"; ; str = "Contacts list")
    {
      localh.b(locala2.a(str).b("Free Audio 1-On-1 Call").a(true).a());
      ViberApplication.getInstance().getEngine(true).getCallHandler().handleDialViber(paramMemberActionInfo.member, false);
      return;
    }
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.startActivity(m.a(paramString1, paramString2, paramString3, false, false, false, false));
  }

  public void b()
  {
    if (cj.a(true))
      a();
  }

  public void c()
  {
  }

  public void d()
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    localContentResolver.delete(a.d.a, null, null);
    localContentResolver.delete(a.e.a, null, null);
    localContentResolver.delete(a.c.a, null, null);
    localContentResolver.delete(a.g.a, null, null);
    localContentResolver.delete(a.f.a, null, null);
  }

  public void e()
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    Cursor localCursor = localContentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    if (localCursor == null)
      return;
    try
    {
      if (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("lookup"));
        localContentResolver.delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, str), null, null);
      }
    }
    finally
    {
      af.a(localCursor);
    }
  }

  public void f()
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("viber", Boolean.valueOf(false));
    ContentResolver localContentResolver = this.a.getContentResolver();
    localContentResolver.delete(a.g.a, null, null);
    localContentResolver.update(a.c.a, localContentValues, null, null);
    ViberApplication.getInstance().getContactManager().d().c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.aj
 * JD-Core Version:    0.6.2
 */