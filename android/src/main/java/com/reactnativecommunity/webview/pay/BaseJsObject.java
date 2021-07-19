package com.reactnativecommunity.webview.pay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * <br>
 * function:h5交互基类
 * <p>
 *
 * @author:HubertYoung
 * @date:2020/7/30 2:52 PM
 * @since:V
 * @desc:com.czb.webczbdemo
 */
class BaseJsObject {
    private String key, value;

    public Activity activity;

    public BaseJsObject(Activity activity) {
        this.activity = activity;
    }

    //拿到设置webView的属性
    @SuppressWarnings("unused")
    @JavascriptInterface
    public void setExtraInfoHead(String key, String value) {
        setKey(key);
        setValue(value);
        Log.e("添加头信息", key + "," + value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 除微信、支付宝外其他支付方式，如果不需要微信、支付宝外的其他支付，则不需要提供如下接口
    @JavascriptInterface
    @SuppressWarnings("unused")
    public void requestPayment(String orderSn, String amount) {
        if (TextUtils.isEmpty(orderSn) || TextUtils.isEmpty(amount)) {//如果接收的数据不正确，给予提示
            Toast.makeText(activity, "有不正确的数据", Toast.LENGTH_LONG).show();
            return;
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("提示");
        builder.setMessage("订单号：" + orderSn + "\n金额:" + amount);

        builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.setCancelable(false);
        builder.show();
    }

}
