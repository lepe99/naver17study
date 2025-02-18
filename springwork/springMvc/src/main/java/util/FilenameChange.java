package util;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class FilenameChange {
    
    public static String addDateToFilename(String originFilename) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        
        String filename = originFilename.substring(0, originFilename.lastIndexOf("."));
        String ext = originFilename.substring(originFilename.lastIndexOf("."));
        
        return filename + "_" + sdf.format(System.currentTimeMillis()) + ext;
    }
    
    public static String addRandomToFilename(String originFilename) {
        String ext = originFilename.substring(originFilename.lastIndexOf("."));
        
        // 최종 파일명 : 랜덤값.확장자
        return UUID.randomUUID() + ext;
    }
}