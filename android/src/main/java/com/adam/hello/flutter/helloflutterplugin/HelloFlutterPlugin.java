package com.adam.hello.flutter.helloflutterplugin;

import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** HelloFlutterPlugin */
public class HelloFlutterPlugin implements MethodCallHandler {

  static Registrar mContext;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    mContext = registrar;
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "hello_flutter_plugin");
    channel.setMethodCallHandler(new HelloFlutterPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("getFooStr")) {
      result.success("Hello!!!! I am from Java layer... ");
    } else if (call.method.equals("showToast")) {
      Toast.makeText(mContext.activity(), "waw..... so wondarful", Toast.LENGTH_SHORT).show();
      result.success(null);
    } else {
      result.notImplemented();
    }
  }
}
