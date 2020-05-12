import 'dart:async';

import 'package:flutter/services.dart';

class FlutterReadExif {
  static const MethodChannel _channel =
      const MethodChannel('flutter_read_exif');

  static Future<Map<String, dynamic>> getExif(String imagePath) async {
    final Map<String, dynamic> exifData = new Map<String, dynamic>.from(await _channel.invokeMethod('getExif', {'imagePath': imagePath}));
    return exifData;
  }
}
