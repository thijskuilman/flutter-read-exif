package nl.wildsea.flutter_read_exif
import androidx.annotation.NonNull
import androidx.exifinterface.media.ExifInterface
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import java.io.IOException

/** FlutterReadExifPlugin */
public class FlutterReadExifPlugin: FlutterPlugin, MethodCallHandler {
  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    val channel = MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutter_read_exif")
    channel.setMethodCallHandler(FlutterReadExifPlugin());
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if(call.method == "getExif") {
      result.success(this.getExif(call.argument("imagePath")))
    } else {
      result.notImplemented()
    }
  }

  @Throws(Exception::class)
  fun getExif(path: String?) : MutableMap<String, String> {
    var exif: ExifInterface? = null
    try {
      exif = ExifInterface(path.toString())
      val exifDetails = mutableMapOf<String, String>();
      exifDetails["F_NUMBER"] = (exif.getAttribute(ExifInterface.TAG_F_NUMBER).toString());
      exifDetails["ISO_SPEED_RATINGS"] = (exif.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS ).toString());
      exifDetails["EXPOSURE_TIME"] = (exif.getAttribute(ExifInterface.TAG_EXPOSURE_TIME).toString());
      exifDetails["DATETIME"] = (exif.getAttribute(ExifInterface.TAG_DATETIME).toString());
      exifDetails["FLASH"] = (exif.getAttribute(ExifInterface.TAG_FLASH).toString());
      exifDetails["FOCAL_LENGTH"] = (exif.getAttribute(ExifInterface.TAG_FOCAL_LENGTH).toString());
      exifDetails["GPS_ALTITUDE"] = (exif.getAttribute(ExifInterface.TAG_GPS_ALTITUDE).toString());
      exifDetails["GPS_ALTITUDE_REF"] = (exif.getAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF).toString());
      exifDetails["GPS_DATESTAMP"] = (exif.getAttribute(ExifInterface.TAG_GPS_DATESTAMP).toString());
      exifDetails["GPS_LATITUDE"] = (exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE).toString());
      exifDetails["GPS_LATITUDE_REF"] = (exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF).toString());
      exifDetails["GPS_LONGITUDE"] = (exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE).toString());
      exifDetails["GPS_LONGITUDE_REF"] = (exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF).toString());
      exifDetails["GPS_PROCESSING_METHOD"] = (exif.getAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD).toString());
      exifDetails["GPS_TIMESTAMP"] = (exif.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP).toString());
      exifDetails["IMAGE_LENGTH"] = (exif.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0).toString());
      exifDetails["IMAGE_WIDTH"] = (exif.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0).toString());
      exifDetails["MAKE"] = (exif.getAttribute(ExifInterface.TAG_MAKE).toString());
      exifDetails["MODEL"] = (exif.getAttribute(ExifInterface.TAG_MODEL).toString());
      exifDetails["ORIENTATION"] = (exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL).toString());
      exifDetails["WHITE_BALANCE"] = (exif.getAttributeInt(ExifInterface.TAG_WHITE_BALANCE, 0).toString());
      return exifDetails;
    } catch (e: IOException) {
      e.printStackTrace()
    }
    return mutableMapOf("0" to "RESULT EXCEPTION");
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
  }
}
