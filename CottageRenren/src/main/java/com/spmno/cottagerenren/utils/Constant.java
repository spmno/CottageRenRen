package com.spmno.cottagerenren.utils;

/**
 * Created by spmno on 13-8-26.
 */
public class Constant {
    public static final String AUTHORIZE_URL = "https://graph.renren.com/oauth/authorize";
    public static final String DEFAULT_REDIRECT_URI = "http://graph.renren.com/oauth/login_success.html";
    public static final String[] HAVE_PERMISSIONS = { "publish_feed", "create_album", "photo_upload", "read_user_album", "status_update",
            "read_user_blog", "read_user_checkin", "read_user_feed", "read_user_guestbook", "read_user_invitation", "read_user_like_history",
            "read_user_message", "read_user_notification", "read_user_photo", "read_user_status", "read_user_comment", "read_user_share",
            "read_user_request", "publish_blog", "publish_checkin", "publish_feed", "publish_share", "write_guestbook", "send_invitation",
            "send_request", "send_message", "send_notification", "photo_upload", "create_album", "publish_comment", "operate_like", "admin_page" };
    public static final String API_KEY = "661ea1ba2d6b49859be197d77fe361f1";
    public static final String SECRET_KEY = "a088d31cd5d341819bfc75ac0208b5e1";
    public static final String APP_ID = "195789";
}
