package com.yandex.metrica;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.eo;
import com.yandex.metrica.impl.ob.eu;
import com.yandex.metrica.impl.ob.ey;
import com.yandex.metrica.impl.ob.ez;
import com.yandex.metrica.impl.ob.fa;
import com.yandex.metrica.impl.ob.fb;
import com.yandex.metrica.impl.ob.fc;
import java.util.Locale;

@TargetApi(26)
public class ConfigurationJobService extends JobService
{
  SparseArray<fa> a = new SparseArray();
  private eu b;
  private String c;

  public void onCreate()
  {
    super.onCreate();
    Context localContext = getApplicationContext();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localContext.getPackageName();
    this.c = String.format(localLocale, "[ConfigurationJobService:%s]", arrayOfObject);
    this.b = new eu();
    ey localey = new ey(getApplicationContext(), this.b.a(), new eo(localContext));
    this.a.append(1512302345, new fb(getApplicationContext(), localey));
    this.a.append(1512302346, new fc(getApplicationContext(), localey));
  }

  public boolean onStartJob(final JobParameters paramJobParameters)
  {
    if (paramJobParameters != null)
      try
      {
        fa localfa = (fa)this.a.get(paramJobParameters.getJobId());
        if (localfa != null)
        {
          this.b.a(localfa, paramJobParameters.getTransientExtras(), new ez()
          {
            public void a()
            {
              try
              {
                ConfigurationJobService.this.jobFinished(paramJobParameters, false);
                return;
              }
              catch (Exception localException)
              {
              }
            }
          });
          return true;
        }
      }
      catch (Exception localException1)
      {
      }
    try
    {
      jobFinished(paramJobParameters, false);
      label56: return false;
    }
    catch (Exception localException2)
    {
      break label56;
    }
  }

  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.ConfigurationJobService
 * JD-Core Version:    0.6.2
 */