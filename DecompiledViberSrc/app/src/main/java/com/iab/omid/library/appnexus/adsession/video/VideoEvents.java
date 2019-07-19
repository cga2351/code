package com.iab.omid.library.appnexus.adsession.video;

import com.iab.omid.library.appnexus.adsession.AdSession;
import com.iab.omid.library.appnexus.adsession.a;
import com.iab.omid.library.appnexus.d.b;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import org.json.JSONObject;

public final class VideoEvents
{
  private final a a;

  private VideoEvents(a parama)
  {
    this.a = parama;
  }

  private void a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("Invalid Video duration");
  }

  private void b(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      throw new IllegalArgumentException("Invalid Video volume");
  }

  public static VideoEvents createVideoEvents(AdSession paramAdSession)
  {
    a locala = (a)paramAdSession;
    com.iab.omid.library.appnexus.d.e.a(paramAdSession, "AdSession is null");
    com.iab.omid.library.appnexus.d.e.g(locala);
    com.iab.omid.library.appnexus.d.e.a(locala);
    com.iab.omid.library.appnexus.d.e.b(locala);
    com.iab.omid.library.appnexus.d.e.e(locala);
    VideoEvents localVideoEvents = new VideoEvents(locala);
    locala.getAdSessionStatePublisher().a(localVideoEvents);
    return localVideoEvents;
  }

  public void adUserInteraction(InteractionType paramInteractionType)
  {
    com.iab.omid.library.appnexus.d.e.a(paramInteractionType, "InteractionType is null");
    com.iab.omid.library.appnexus.d.e.c(this.a);
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "interactionType", paramInteractionType);
    this.a.getAdSessionStatePublisher().a("adUserInteraction", localJSONObject);
  }

  public void bufferFinish()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("bufferFinish");
  }

  public void bufferStart()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("bufferStart");
  }

  public void complete()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("complete");
  }

  public void firstQuartile()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("firstQuartile");
  }

  public void loaded(VastProperties paramVastProperties)
  {
    com.iab.omid.library.appnexus.d.e.a(paramVastProperties, "VastProperties is null");
    com.iab.omid.library.appnexus.d.e.b(this.a);
    this.a.getAdSessionStatePublisher().a("loaded", paramVastProperties.a());
  }

  public void midpoint()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("midpoint");
  }

  public void pause()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("pause");
  }

  public void playerStateChange(PlayerState paramPlayerState)
  {
    com.iab.omid.library.appnexus.d.e.a(paramPlayerState, "PlayerState is null");
    com.iab.omid.library.appnexus.d.e.c(this.a);
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "state", paramPlayerState);
    this.a.getAdSessionStatePublisher().a("playerStateChange", localJSONObject);
  }

  public void resume()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("resume");
  }

  public void skipped()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("skipped");
  }

  public void start(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1);
    b(paramFloat2);
    com.iab.omid.library.appnexus.d.e.c(this.a);
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "duration", Float.valueOf(paramFloat1));
    b.a(localJSONObject, "videoPlayerVolume", Float.valueOf(paramFloat2));
    b.a(localJSONObject, "deviceVolume", Float.valueOf(com.iab.omid.library.appnexus.b.e.a().d()));
    this.a.getAdSessionStatePublisher().a("start", localJSONObject);
  }

  public void thirdQuartile()
  {
    com.iab.omid.library.appnexus.d.e.c(this.a);
    this.a.getAdSessionStatePublisher().a("thirdQuartile");
  }

  public void volumeChange(float paramFloat)
  {
    b(paramFloat);
    com.iab.omid.library.appnexus.d.e.c(this.a);
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "videoPlayerVolume", Float.valueOf(paramFloat));
    b.a(localJSONObject, "deviceVolume", Float.valueOf(com.iab.omid.library.appnexus.b.e.a().d()));
    this.a.getAdSessionStatePublisher().a("volumeChange", localJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.video.VideoEvents
 * JD-Core Version:    0.6.2
 */