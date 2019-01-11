//
// reference: https://flutter.io/docs/development/packages-and-plugins/developing-packages
// 1. To create a plugin package, use the --template=plugin flag with flutter create.
//    Use android studio to create plugin project
// 2. Implement the flutter interface routine in xxx.dart
// 3. In a terminal execute cd <project name>/example; flutter build apk).
// 4. use android studio to open example project.
//    4.1 select File > Open
//    4.2 select <project name>/example/android/build.gradle file
// 5. The Android platform code of your plugin is located in <project name>/java/com.example.hello/​XXXPlugin.
// 6. Repeat step 3 if you modified the XXXPlugin java file.
// 7. Run the example app to execute your flutter interface routine.
//
import 'dart:async';

import 'package:flutter/services.dart';

class HelloFlutterPlugin {
  static const MethodChannel _channel =
      const MethodChannel('hello_flutter_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> foo() async {
    final String retstr = await _channel.invokeMethod('getFooStr');
    return retstr;
  }

  static Future<void> showToast() async {
    await _channel.invokeMethod("showToast");
  }
}
