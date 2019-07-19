package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.x;
import com.google.firebase.iid.zzc;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService extends zzc
{
  private static final Queue<String> b = new ArrayDeque(10);

  protected final Intent a(Intent paramIntent)
  {
    return x.a().b();
  }

  public void a()
  {
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString, Exception paramException)
  {
  }

  public final void b(Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    String str2;
    Task localTask;
    if (("com.google.android.c2dm.intent.RECEIVE".equals(str1)) || ("com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(str1)))
    {
      str2 = paramIntent.getStringExtra("google.message_id");
      if (TextUtils.isEmpty(str2))
        localTask = Tasks.forResult(null);
    }
    while (true)
    {
      int i;
      label53: String str4;
      label124: int j;
      label127: String str7;
      if (TextUtils.isEmpty(str2))
      {
        i = 0;
        if (i == 0)
        {
          str4 = paramIntent.getStringExtra("message_type");
          if (str4 == null)
            str4 = "gcm";
          switch (str4.hashCode())
          {
          default:
            j = -1;
            switch (j)
            {
            default:
              String str6 = String.valueOf(str4);
              if (str6.length() != 0)
              {
                str7 = "Received message with unknown type: ".concat(str6);
                Log.w("FirebaseMessaging", str7);
              }
              break;
            case 0:
            case 1:
            case 2:
            case 3:
            }
            break;
          case 102161:
          case -2062414158:
          case 814800675:
          case 814694033:
          }
        }
      }
      try
      {
        while (true)
        {
          Tasks.await(localTask, 1L, TimeUnit.SECONDS);
          return;
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("google.message_id", str2);
          localTask = com.google.firebase.iid.e.a(this).a(2, localBundle1);
          break;
          if (b.contains(str2))
          {
            String str8;
            if (Log.isLoggable("FirebaseMessaging", 3))
            {
              str8 = String.valueOf(str2);
              if (str8.length() == 0)
                break label293;
            }
            label293: for (String str9 = "Received duplicate message: ".concat(str8); ; str9 = new String("Received duplicate message: "))
            {
              Log.d("FirebaseMessaging", str9);
              i = 1;
              break;
            }
          }
          if (b.size() >= 10)
            b.remove();
          b.add(str2);
          i = 0;
          break label53;
          if (!str4.equals("gcm"))
            break label124;
          j = 0;
          break label127;
          if (!str4.equals("deleted_messages"))
            break label124;
          j = 1;
          break label127;
          if (!str4.equals("send_event"))
            break label124;
          j = 2;
          break label127;
          if (!str4.equals("send_error"))
            break label124;
          j = 3;
          break label127;
          if (b.e(paramIntent))
            b.a(paramIntent);
          Bundle localBundle2 = paramIntent.getExtras();
          if (localBundle2 == null)
            localBundle2 = new Bundle();
          localBundle2.remove("android.support.content.wakelockid");
          ExecutorService localExecutorService;
          e locale;
          if (d.b(localBundle2))
          {
            localExecutorService = Executors.newSingleThreadExecutor();
            locale = new e(this, localBundle2, localExecutorService);
          }
          try
          {
            boolean bool = locale.a();
            if (bool)
            {
              localExecutorService.shutdown();
              continue;
            }
            localExecutorService.shutdown();
            if (b.e(paramIntent))
              b.d(paramIntent);
            a(new RemoteMessage(localBundle2));
          }
          finally
          {
            localExecutorService.shutdown();
          }
          continue;
          a(paramIntent.getStringExtra("google.message_id"));
          continue;
          String str5 = paramIntent.getStringExtra("google.message_id");
          if (str5 == null)
            str5 = paramIntent.getStringExtra("message_id");
          a(str5, new c(paramIntent.getStringExtra("error")));
        }
        str7 = new String("Received message with unknown type: ");
      }
      catch (InterruptedException localInterruptedException)
      {
        do
        {
          String str3 = String.valueOf(localInterruptedException);
          Log.w("FirebaseMessaging", 20 + String.valueOf(str3).length() + "Message ack failed: " + str3);
          return;
          if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(str1))
            break;
        }
        while (!b.e(paramIntent));
        b.c(paramIntent);
        return;
        if ("com.google.firebase.messaging.NEW_TOKEN".equals(str1))
        {
          b(paramIntent.getStringExtra("token"));
          return;
        }
        String str10 = String.valueOf(paramIntent.getAction());
        if (str10.length() != 0);
        for (String str11 = "Unknown intent action: ".concat(str10); ; str11 = new String("Unknown intent action: "))
        {
          Log.d("FirebaseMessaging", str11);
          return;
        }
      }
      catch (ExecutionException localExecutionException)
      {
        break label621;
      }
      catch (TimeoutException localTimeoutException)
      {
        label621: break label621;
      }
    }
  }

  public void b(String paramString)
  {
  }

  public final boolean c(Intent paramIntent)
  {
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
    {
      PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
      if (localPendingIntent != null);
      try
      {
        localPendingIntent.send();
        if (b.e(paramIntent))
          b.b(paramIntent);
        return true;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        while (true)
          Log.e("FirebaseMessaging", "Notification pending intent canceled");
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.FirebaseMessagingService
 * JD-Core Version:    0.6.2
 */