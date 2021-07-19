package com.reactnativecommunity.webview.pay;

import android.text.TextUtils;

public class PayUtil {
  /**
   * 判断url是不是微信支付url
   * @param url
   * @return
   */
  public static boolean urlIsWexinPay(String url){
    return url.startsWith("weixin://");
  }

  /**
   * 判断url是不是微信统一下单url
   * @param url
   * @return
   */
  public static boolean urlIsWexinPayment(String url){
    return url.startsWith("https://wx.tenpay.com");
  }

  /**
   * 判断url是不是支付宝支付url
   * @param url
   * @return
   */
  public static boolean urlIsAlipayPay(String url){
    return !TextUtils.isEmpty(url) && (url.startsWith("alipays:") || url.startsWith("alipay"));
  }

}
