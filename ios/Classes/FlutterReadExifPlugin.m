#import "FlutterReadExifPlugin.h"
#if __has_include(<flutter_read_exif/flutter_read_exif-Swift.h>)
#import <flutter_read_exif/flutter_read_exif-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_read_exif-Swift.h"
#endif

@implementation FlutterReadExifPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterReadExifPlugin registerWithRegistrar:registrar];
}
@end
