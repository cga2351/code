package twitter4j.media;

import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public class ImageUploadFactory
{
  private final String apiKey;
  private final Configuration conf;
  private final MediaProvider defaultMediaProvider;

  public ImageUploadFactory()
  {
    this(ConfigurationContext.getInstance());
  }

  public ImageUploadFactory(Configuration paramConfiguration)
  {
    String str = paramConfiguration.getMediaProvider().toLowerCase();
    if ("twitter".equals(str))
      this.defaultMediaProvider = MediaProvider.TWITTER;
    while (true)
    {
      this.conf = paramConfiguration;
      this.apiKey = paramConfiguration.getMediaProviderAPIKey();
      return;
      if (("imgly".equals(str)) || ("img_ly".equals(str)))
      {
        this.defaultMediaProvider = MediaProvider.IMG_LY;
      }
      else if ("plixi".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.PLIXI;
      }
      else if ("lockerz".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.LOCKERZ;
      }
      else if ("twipple".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.TWIPPLE;
      }
      else if ("twitgoo".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.TWITGOO;
      }
      else if ("twitpic".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.TWITPIC;
      }
      else if ("yfrog".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.YFROG;
      }
      else if ("mobypicture".equals(str))
      {
        this.defaultMediaProvider = MediaProvider.MOBYPICTURE;
      }
      else
      {
        if (!"posterous".equals(str))
          break;
        this.defaultMediaProvider = MediaProvider.POSTEROUS;
      }
    }
    throw new IllegalArgumentException("unsupported media provider:" + str);
  }

  public ImageUpload getInstance()
  {
    return getInstance(this.defaultMediaProvider);
  }

  public ImageUpload getInstance(Authorization paramAuthorization)
  {
    return getInstance(this.defaultMediaProvider, paramAuthorization);
  }

  public ImageUpload getInstance(MediaProvider paramMediaProvider)
  {
    return getInstance(paramMediaProvider, AuthorizationFactory.getInstance(this.conf));
  }

  public ImageUpload getInstance(MediaProvider paramMediaProvider, Authorization paramAuthorization)
  {
    if (!(paramAuthorization instanceof OAuthAuthorization))
      throw new IllegalArgumentException("OAuth authorization is required.");
    OAuthAuthorization localOAuthAuthorization = (OAuthAuthorization)paramAuthorization;
    if (paramMediaProvider == MediaProvider.TWITTER)
      return new TwitterUpload(this.conf, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.IMG_LY)
      return new ImgLyUpload(this.conf, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.PLIXI)
      return new PlixiUpload(this.conf, this.apiKey, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.LOCKERZ)
      return new PlixiUpload(this.conf, this.apiKey, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.TWIPPLE)
      return new TwippleUpload(this.conf, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.TWITGOO)
      return new TwitgooUpload(this.conf, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.TWITPIC)
      return new TwitpicUpload(this.conf, this.apiKey, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.YFROG)
      return new YFrogUpload(this.conf, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.MOBYPICTURE)
      return new MobypictureUpload(this.conf, this.apiKey, localOAuthAuthorization);
    if (paramMediaProvider == MediaProvider.POSTEROUS)
      return new PosterousUpload(this.conf, localOAuthAuthorization);
    throw new AssertionError("Unknown provider");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.ImageUploadFactory
 * JD-Core Version:    0.6.2
 */